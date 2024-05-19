package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.AdminDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.enttity.AdminEntity;
import lk.ijse.gdse66.Backend.repository.AdminRepo;
import lk.ijse.gdse66.Backend.service.AdminService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getAdminId())){
            throw new DuplicateRecordException("Admin ID is Already Exist");
        }
        return mapper.map(adminRepo.save(mapper.map(adminDTO, AdminEntity.class)), AdminDTO.class);
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getAdminId())){
            throw new NotFoundException("Can't find admin id!!!");
        }
        return mapper.map(adminRepo.save(mapper.map(adminDTO ,AdminEntity.class)) ,AdminDTO.class);

    }

    @Override
    public boolean deleteAdmin(String id) {
        if (!adminRepo.existsById(id)){
            throw new NotFoundException("Can't find admin id!!!");
        }
        adminRepo.deleteById(id);
        return false;
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        return adminRepo.findAll().stream().map(adminEntity -> mapper.map(adminEntity,AdminDTO.class)).toList();
    }
}
