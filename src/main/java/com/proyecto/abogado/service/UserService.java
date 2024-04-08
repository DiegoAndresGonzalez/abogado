package com.proyecto.abogado.service;

import com.proyecto.abogado.dto.ClientRequestDto;
import com.proyecto.abogado.dto.LawyerRequestDto;
import com.proyecto.abogado.mapper.UserMapper;
import com.proyecto.abogado.model.ClientModel;
import com.proyecto.abogado.model.RoleModel;
import com.proyecto.abogado.model.LawyerModel;
import com.proyecto.abogado.repository.ClientRepository;
import com.proyecto.abogado.repository.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final LawyerRepository lawyerRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public LawyerModel createLawyer(LawyerRequestDto lawyerRequestDto){
        LawyerModel lawyerModel = userMapper.toUserModel(lawyerRequestDto);
        lawyerModel.setRole(RoleModel.LAWYER_ROLE);
        lawyerModel.setPassword(passwordEncoder.encode(lawyerModel.getPassword()));
        lawyerRepository.save(lawyerModel);
        return lawyerModel;
    }

    public ClientModel createClient(ClientRequestDto clientRequestDto){
        ClientModel clientModel = userMapper.toClientModel(clientRequestDto);
        clientModel.setRole(RoleModel.CLIENT_ROLE);
        clientRepository.save(clientModel);
        return clientModel;
    }

}