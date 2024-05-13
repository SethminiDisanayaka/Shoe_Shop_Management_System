package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.enttity.SupplierEntity;
import lk.ijse.gdse66.Backend.repository.SupplierRepo;
import lk.ijse.gdse66.Backend.service.SupplierService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
            if (supplierRepo.existsById(supplierDTO.getSupplierCode())){
                throw new DuplicateRecordException("Supplier ID is Already Exist");
            }
            return mapper.map(supplierRepo.save(mapper.map(supplierDTO, SupplierEntity.class)),SupplierDTO.class);
        }


    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        if (!supplierRepo.existsById(supplierDTO.getSupplierCode())){
            throw new NotFoundException("Can't find supplier id!!!");
        }
        return mapper.map(supplierRepo.save(mapper.map(supplierDTO ,SupplierEntity.class)) ,SupplierDTO.class);
    }


    @Override
    public boolean deleteSupplier(String id) {
        if (!supplierRepo.existsById(id)){
            throw new NotFoundException("Can't find supplier id!!!");
        }
        return false;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepo.findAll().stream().map(supplierEntity -> mapper.map(supplierEntity,SupplierDTO.class)).toList();
    }
}
