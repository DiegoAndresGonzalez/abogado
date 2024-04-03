package com.proyecto.abogado.controller;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.dto.UserRequestDto;
import com.proyecto.abogado.service.CaseService;
import com.proyecto.abogado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> createClient(@RequestBody UserRequestDto userRequestDto){
        userService.createClient(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/case")
    public ResponseEntity<Void> createCase(@RequestBody CaseRequestDto caseRequestDto){
        caseService.createCase(caseRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}