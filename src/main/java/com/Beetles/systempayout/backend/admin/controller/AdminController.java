package com.Beetles.systempayout.backend.admin.controller;

import com.Beetles.systempayout.backend.admin.controller.mapper.AdminMapper;
import com.Beetles.systempayout.backend.admin.controller.response.AdminResponse;
import com.Beetles.systempayout.backend.admin.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("/findEmail/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminResponse> bucarPorEmail (@Valid @RequestBody String email){
        return ResponseEntity.status(HttpStatus.OK)
                .body(AdminMapper.responseMapper(service.buscarPorEmail(email)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id){
        service.deletarAdmin(id);
    }
}
