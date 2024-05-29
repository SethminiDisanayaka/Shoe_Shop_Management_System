package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import lk.ijse.gdse66.Backend.enttity.SupplierEntity;
import lk.ijse.gdse66.Backend.repository.SupplierRepo;
import lk.ijse.gdse66.Backend.service.SupplierService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    SupplierRepo supplierRepository;
    ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepo supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        System.out.println(genarateNextSupplierCode());
        return supplierRepository.findAll().stream().map(
                supplier -> modelMapper.map(supplier, SupplierDTO.class)
        ).toList();
    }

    @Override
    public SupplierDTO getSupplierDetails(String id) {
        if(!supplierRepository.existsBySupplierCode(id)){
            throw new NotFoundException("Supplier "+id+" Not Found!");
        }
        return modelMapper.map(supplierRepository.findBySupplierCode(id), SupplierDTO.class);
    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        if(supplierRepository.existsBySupplierCode(supplierDTO.getSupplierCode())){
            throw new DuplicateRecordException("This Supplier "+supplierDTO.getSupplierCode()+" already exicts...");
        }
        return modelMapper.map(supplierRepository.save(modelMapper.map(
                supplierDTO, SupplierEntity.class)), SupplierDTO.class
        );
    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {
        if(!supplierRepository.existsBySupplierCode(id)){
            throw new NotFoundException("Supplier ID"+ id + "Not Found...");
        }
        supplierDTO.setSupplierCode(id);
        supplierRepository.save(modelMapper.map(supplierDTO,SupplierEntity.class));
    }

    @Override
    public void deleteSupplier(String id) {
        if(!supplierRepository.existsBySupplierCode(id)){
            throw  new NotFoundException("Supplier ID"+ id + "Not Found...");
        }
        supplierRepository.deleteBySupplierCode(id);
    }

    @Override
    public String genarateNextSupplierCode() {
        String lastSupplierCode = supplierRepository.findLatestSupplierCode();
        int numericPart = Integer.parseInt(lastSupplierCode.substring(3));
        numericPart++;
        String nextSupplierCode = "SUP" + String.format("%03d", numericPart);
        return nextSupplierCode;
    }
}
