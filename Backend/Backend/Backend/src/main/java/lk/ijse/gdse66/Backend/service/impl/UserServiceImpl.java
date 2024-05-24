package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import lk.ijse.gdse66.Backend.dto.UserDTO;
import lk.ijse.gdse66.Backend.enttity.UserEntity;
import lk.ijse.gdse66.Backend.repository.UserRepo;
import lk.ijse.gdse66.Backend.service.UserService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepository, ModelMapper modelMapper) {
        this.userRepo = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDetailsService userDetailService() {
        return username -> (UserDetails) userRepo.findByEmail(username)
                .orElseThrow(() -> new
                        UsernameNotFoundException(
                        "user not found"));
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getEmail())){
            throw new DuplicateRecordException("User ID is Already Exist");
        }
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, UserEntity.class)), UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getEmail())){
            throw new NotFoundException("Can't find user id!!!");
        }
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, UserEntity.class)), UserDTO.class);
    }

    @Override
    public boolean deleteUser(String id) {
        if (!userRepo.existsById(id)){
            throw new NotFoundException("Can't find user id!!!");
        }
        userRepo.deleteById(id);
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).toList();
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(userRepo.getLastIndex());    }

    @Override
    public UserDTO getRegUsers(String username, String password) {
            return modelMapper.map(userRepo.findUserByUser_NameAndPassword(username, password), UserDTO.class);
    }
}
