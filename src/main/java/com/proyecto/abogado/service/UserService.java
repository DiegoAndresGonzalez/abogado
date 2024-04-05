package com.proyecto.abogado.service;

import com.proyecto.abogado.dto.UserRequestDto;
import com.proyecto.abogado.mapper.UserMapper;
import com.proyecto.abogado.model.RoleModel;
import com.proyecto.abogado.model.UserModel;
import com.proyecto.abogado.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.proyecto.abogado.utils.Constant.CLIENT_ROLE;
import static com.proyecto.abogado.utils.Constant.LAWYER_ROLE;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserModel createLawyer(UserRequestDto userRequestDto){
        UserModel userModel = userMapper.toUserModel(userRequestDto);
        userModel.setRole(RoleModel.LAWYER_ROLE);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

    public UserModel createClient(UserRequestDto userRequestDto){
        UserModel userModel = userMapper.toUserModel(userRequestDto);
        userModel.setRole(RoleModel.CLIENT_ROLE);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

}