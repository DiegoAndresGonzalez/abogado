package com.proyecto.abogado.controller;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.dto.ClientRequestDto;
import com.proyecto.abogado.dto.LawyerRequestDto;
import com.proyecto.abogado.model.CaseModel;
import com.proyecto.abogado.service.CaseService;
import com.proyecto.abogado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.proyecto.abogado.utils.Constant.LAWYER_ROLE;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final CaseService caseService;

    @PostMapping("/lawyer")
    public ResponseEntity<Void> createLawyer(@RequestBody LawyerRequestDto lawyerRequestDto){
        userService.createLawyer(lawyerRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/client")
    @PreAuthorize("hasRole('"+LAWYER_ROLE+"')")
    public ResponseEntity<Void> createClient(@RequestBody ClientRequestDto clientRequestDto){
        userService.createClient(clientRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/case")
    @PreAuthorize("hasRole('"+LAWYER_ROLE+"')")
    public ResponseEntity<Void> createCase(@RequestBody CaseRequestDto caseRequestDto){
        caseService.createCase(caseRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/file")
    @PreAuthorize("hasRole('"+LAWYER_ROLE+"')")
    public ResponseEntity<CaseModel> updateCaseFile(@PathVariable Long id, @RequestParam("file")MultipartFile file){
        CaseModel updatedCase = caseService.updateCaseFile(id,file);
        return ResponseEntity.ok(updatedCase);
    }

}