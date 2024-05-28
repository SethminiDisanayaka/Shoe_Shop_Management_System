package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.SaleDTO;
import lk.ijse.gdse66.Backend.dto.SalesDetailsDTO;
import lk.ijse.gdse66.Backend.enttity.SalesDetailsEntity;
import lk.ijse.gdse66.Backend.enttity.SalesEntity;
import lk.ijse.gdse66.Backend.repository.SaleRepo;
import lk.ijse.gdse66.Backend.repository.SalesDetailRepo;
import lk.ijse.gdse66.Backend.service.SaleService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    SaleRepo saleRepo;
    SalesDetailRepo salesDetailRepo;
    ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepo saleRepo, SalesDetailRepo salesDetailRepo, ModelMapper modelMapper) {
        this.saleRepo = saleRepo;
        this.salesDetailRepo = salesDetailRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SaleDTO> getAllOrders() {
        return saleRepo.findAll().stream().map(
                sales -> modelMapper.map(sales,SaleDTO.class)
        ).toList();
    }

    @Override
    public SaleDTO getOrderDetails(String id) {
     return null;
    }

    @Override
    public SaleDTO saveOrder(SaleDTO salesDTO) {
     return null;
    }

    @Override
    public void updateOrder(String id, SaleDTO salesDTO) {

    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public CustomDTO orderGenerateId() {
        return null;
    }
}
