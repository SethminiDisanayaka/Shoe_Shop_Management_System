package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.enttity.InventoryEntity;
import lk.ijse.gdse66.Backend.repository.InventoryRepo;
import lk.ijse.gdse66.Backend.service.InventoryService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InventoryDTO saveItem(InventoryDTO inventoryDTO) {
        if(inventoryRepo.existsById(inventoryDTO.getItemCode())){
            throw new DuplicateRecordException("Item ID is already exist");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(inventoryDTO , InventoryEntity.class)) , InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateItem(InventoryDTO inventoryDTO) {
        if(inventoryRepo.existsById(inventoryDTO.getItemCode())){
            throw new NotFoundException("Item ID is already exist");
        }
        return modelMapper.map(inventoryRepo.save(modelMapper.map(inventoryDTO , InventoryEntity.class)) , InventoryDTO.class);
    }

    @Override
    public boolean deleteItem(String id) {
        if (!inventoryRepo.existsById(id)){
            throw new NotFoundException("Can't find customer id!!!");
        }
        inventoryRepo.deleteById(id);
        return false;
    }

    @Override
    public List<InventoryDTO> getAllItems() {
        return inventoryRepo.findAll().stream().map(inventoryEntity -> modelMapper.map(inventoryEntity,InventoryDTO.class)).toList();
    }
}
