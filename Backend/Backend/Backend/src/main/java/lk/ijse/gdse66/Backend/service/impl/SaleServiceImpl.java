package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.dto.SalesDTO;
import lk.ijse.gdse66.Backend.dto.SalesDetailsDTO;
import lk.ijse.gdse66.Backend.enttity.InventoryEntity;
import lk.ijse.gdse66.Backend.enttity.SalesDetailsEntity;
import lk.ijse.gdse66.Backend.enttity.SalesEntity;
import lk.ijse.gdse66.Backend.repository.InventoryRepo;
import lk.ijse.gdse66.Backend.repository.SaleRepo;
import lk.ijse.gdse66.Backend.repository.SalesDetailRepo;
import lk.ijse.gdse66.Backend.service.SaleService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import lk.ijse.gdse66.Backend.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    SaleRepo salesRepository;
    SalesDetailRepo salesDetailsRepository;
    InventoryRepo inventoryRepository;
    ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepo salesRepository, SalesDetailRepo salesDetailsRepository, ModelMapper modelMapper,InventoryRepo inventoryRepository) {
        this.salesRepository = salesRepository;
        this.salesDetailsRepository = salesDetailsRepository;
        this.modelMapper = modelMapper;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<SalesDTO> getAllSales() {
        //getWeeklyProfit();
        List<SalesEntity> salesList = salesRepository.findAll();
        return salesList.stream().map(sales -> {
            SalesDTO salesDTO = modelMapper.map(sales, SalesDTO.class);

            List<SalesDetailsEntity> salesDetailsList = salesDetailsRepository.findAllBySalesOrderNo(sales.getOrderNo());
            List<SalesDetailsDTO> salesInventoryDTOList = salesDetailsList.stream()
                    .map(details -> {
                        SalesDetailsDTO salesInventoryDTO = modelMapper.map(details, SalesDetailsDTO.class);
                        salesInventoryDTO.setInventory(modelMapper.map(details.getInventory(), InventoryDTO.class));
                        return salesInventoryDTO;
                    })
                    .collect(Collectors.toList());

            salesDTO.setSalesDetails(salesInventoryDTOList);
            return salesDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public SalesDTO getSaleDetails(String id) {
        if(!salesRepository.existsByOrderNo(id)){
            throw new NotFoundException("Sales "+id+" Not Found!");
        }
        SalesDTO salesDTO = modelMapper.map(salesRepository.findByOrderNo(id), SalesDTO.class);
        System.out.println("ID-----------------------"+id);
        List<SalesDetailsDTO> salesInventory = salesDetailsRepository.findAllBySalesOrderNo(id).stream().map(
                salesDetails -> modelMapper.map(salesDetails, SalesDetailsDTO.class)
        ).toList();
        salesDTO.setSalesDetails(salesInventory);

        return salesDTO;
    }

    @Transactional
    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        if(maintainInventoryQuantity(salesDTO)){
            if(salesRepository.existsByOrderNo(salesDTO.getOrderNo())){
                throw new DuplicateRecordException("This Sales "+salesDTO.getOrderNo()+" already exicts...");
            }
            SalesDTO newsalesDTO = modelMapper.map(salesRepository.save(modelMapper.map(
                    salesDTO, SalesEntity.class)), SalesDTO.class
            );

            List<SalesDetailsDTO> salesInventoryDTO = new ArrayList<>();
            for (SalesDetailsDTO inventoryDTO : salesDTO.getSalesDetails()) {
                SalesDetailsEntity savedSaleDetails = salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetailsEntity.class));
                salesInventoryDTO.add(modelMapper.map(savedSaleDetails, SalesDetailsDTO.class));
            }
            newsalesDTO.setSalesDetails(salesInventoryDTO);
            return newsalesDTO;
        }else {
            return salesDTO;
        }
    }

    @Transactional
    @Override
    public void updateSales(String id, SalesDTO salesDTO) {
        for(SalesDetailsDTO inventoryDTO : salesDTO.getSalesDetails()){
            if(inventoryDTO.getQuantity() == 0){
                if(!isDateWithinThreeDays(String.valueOf(salesDTO.getPurchaseDate()))){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("comming");
                    throw new NotFoundException("Update Failed This Order " +
                            salesDTO.getOrderNo() + " Can't refund");
                }
            }
        }
        if(salesRepository.existsById(salesDTO.getOrderNo())){
            salesRepository.save(modelMapper.map(salesDTO,SalesEntity.class));
            for (SalesDetailsDTO inventoryDTO : salesDTO.getSalesDetails()) {
                if(!salesDetailsRepository.existsById(inventoryDTO.getId())){
                    throw new NotFoundException("Update Failed; Sales id: " +
                            salesDTO.getOrderNo() + " does not exist");
                }
                salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetailsEntity.class));
            }
        }
    }

    @Override
    public void deleteSales(String id) {
        if(!salesDetailsRepository.existsBySalesOrderNo(id)&&!salesRepository.existsByOrderNo(id)){
            throw  new NotFoundException("Sales "+ id + "Not Found...");
        }else if(salesRepository.existsByOrderNo(id)){
            salesRepository.deleteByOrderNo(id);
        }
        salesDetailsRepository.deleteAllBySalesOrderNo(id);
        salesRepository.deleteByOrderNo(id);
    }

    @Override
    public String nextOrderCode() {
        String lastOrderCode = salesRepository.findLatestOrderCode();
        if(lastOrderCode==null){lastOrderCode = "ORD0000";}
        int numericPart = Integer.parseInt(lastOrderCode.substring(4));
        numericPart++;
        String nextOrderCode = "ORD" + String.format("%04d", numericPart);
        return nextOrderCode;
    }

    protected boolean isDateWithinThreeDays(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        LocalDateTime inputDate = LocalDateTime.parse(dateString, formatter.withZone(ZoneId.of("Asia/Kolkata")));
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        LocalDateTime threeDaysAgo = currentDate.minus(3, ChronoUnit.DAYS);
        return !inputDate.isBefore(threeDaysAgo);
    }

    protected Boolean maintainInventoryQuantity(SalesDTO salesDTO){
        boolean valid = false;
        for (int i = 0; i<salesDTO.getSalesDetails().size();i++){
            SalesDetailsDTO inventoryDTO = salesDTO.getSalesDetails().get(i);
            String itemCode = inventoryDTO.getInventory().getItemCode();
            System.out.println(itemCode);

            InventoryDTO inventory = modelMapper.map(inventoryRepository.findByItemCode(itemCode),InventoryDTO.class);
            if(inventory.getQuantity()>0){
                if(inventory.getQuantity()-inventoryDTO.getQuantity()>=0){
                    inventory.setQuantity(inventory.getQuantity()-inventoryDTO.getQuantity());
                    inventoryRepository.save(modelMapper.map(inventory, InventoryEntity.class));
                    valid = true;
                }else{
                    valid = false;
                    throw new ServiceException("Can't Proceed this Sale ."+inventory.getItemDescription()+" No much Quantity");
                }
            }else{
                valid = false;
                throw new ServiceException("Can't Proceed this Sale ."+inventory.getItemDescription()+" No much Quantity");
            }
        }
        return valid;
    }

    public void getWeeklyProfit(){
        Map<String, Double> dataList = new HashMap<>();
        List<Date> dates = salesRepository.findAllPurchaseDate();
        int quantity;
        double dayProfit = 0;
        for (Date date:dates){
            if(convertToLocalDateFormat(String.valueOf(date))){
                List<SalesEntity> sales = salesRepository.findAllByPurchaseDate(date);
                for (int i = 0; i < sales.size(); i++) {
                    List<SalesDetailsEntity> salesDetailsArray = salesDetailsRepository.findAllBySalesOrderNo(sales.get(i).getOrderNo());
                    for (int j = 0; j < salesDetailsArray.size(); j++){
                        System.out.println("----------------------------------------------------------------");
                        quantity = salesDetailsArray.get(j).getQuantity();
                        InventoryDTO inventoryDTO = modelMapper.map(
                                inventoryRepository.findByItemCode(salesDetailsArray.get(j).getInventory().getItemCode()),InventoryDTO.class
                        );
                        dayProfit += quantity*(inventoryDTO.getExpectedProfit());
                    }
                    System.out.println("////////////////////////////////////////////////////////////////");
                    System.out.println(date);
                    System.out.println(dayProfit);
                    if(dayProfit!=0){
                        String newdate = convertDateFormat(String.valueOf(date));
                        if (!dataList.containsKey(newdate)) {
                            dataList.put(newdate, dayProfit);
                        } else {
                            double currentProfit = dataList.get(newdate);
                            dataList.put(newdate, currentProfit + dayProfit);
                        }
                    }
                    dayProfit = 0;
                }
            }
        }
        System.out.println(dataList);
    }

    private Boolean convertToLocalDateFormat(String dateTimeString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);
        LocalDate localDate = localDateTime.toLocalDate();

        Boolean purchaseDateEqualToWeeklyDate = checkWeeklyDate(localDate.format(dateFormatter));
        return purchaseDateEqualToWeeklyDate;
    }

    private boolean checkWeeklyDate(String purchasedate){
        List<LocalDate> dates = new ArrayList<>();
        Boolean vaid = false;
        LocalDate today = LocalDate.now();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            dates.add(date);
        }

        L:for (LocalDate date : dates) {
            if(String.valueOf(date).equals(purchasedate)){
                vaid = true;
                break L;
            }else{
                vaid = false;
            }
        }
        return vaid;
    }

    private String convertDateFormat(String inputDateStr) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date inputDate = null;
        try {
            inputDate = inputDateFormat.parse(inputDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outputDateFormatObj = new SimpleDateFormat("yyyy-MM-dd");
        return outputDateFormatObj.format(inputDate);
    }
}
