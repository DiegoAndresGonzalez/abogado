package com.proyecto.abogado.controller;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.dto.UserRequestDto;
import com.proyecto.abogado.service.CaseService;
import com.proyecto.abogado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.proyecto.abogado.utils.Constant.LAWYER_ROLE;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final CaseService caseService;

    @PostMapping("/lawyer")
    public ResponseEntity<Void> createLawyer(@RequestBody UserRequestDto userRequestDto){
        userService.createLawyer(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/client")
    @PreAuthorize("hasRole('"+LAWYER_ROLE+"')")
    public ResponseEntity<Void> createClient(@RequestBody UserRequestDto userRequestDto){
        userService.createClient(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/case")
    @PreAuthorize("hasRole('"+LAWYER_ROLE+"')")
    public ResponseEntity<Void> createCase(@RequestBody CaseRequestDto caseRequestDto){
        caseService.createCase(caseRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}