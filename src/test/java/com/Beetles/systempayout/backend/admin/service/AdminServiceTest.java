package com.Beetles.systempayout.backend.admin.service;

import com.Beetles.systempayout.backend.admin.controller.request.AdminRequest;
import com.Beetles.systempayout.backend.admin.controller.response.AdminResponse;
import com.Beetles.systempayout.backend.admin.model.Admin;
import com.Beetles.systempayout.backend.admin.repository.AdminRepository;
import com.Beetles.systempayout.backend.shared.enums.Enums_roles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @InjectMocks
    private AdminService service;

    @Mock
    private AdminRepository repository;

    @Mock
    private PasswordEncoder encoder;

    @Test
    public void deveRegistrarUmAdministradorCorretamente() {
        AdminRequest adminRequest =
                new AdminRequest(
                "Matheus",
                "matheus@gmail.com",
                "matheus1"
                );

        when(encoder.encode("matheus1")).thenReturn("senhaCriptografada");

        when(repository.save(any(Admin.class)))
                .thenAnswer(invocation -> {
                    Admin admin = invocation.getArgument(0);

                    admin.setAdminId(UUID.randomUUID());
                    admin.setRole(Enums_roles.ADMIN);

                    return admin;
                });

        Admin adm = service.registrar(adminRequest);

        assertNotNull(adm.getAdminId());
        assertEquals("Matheus", adm.getNome());
        assertEquals("matheus@gmail.com", adm.getEmail());
        assertEquals("senhaCriptografada", adm.getSenha());
        assertEquals(Enums_roles.ADMIN, adm.getRole());
    }

    @Test
    void Deve_Retornar_Um_Administrador_Pelo_Email() {
        Admin admin = new Admin();
        admin.setEmail("matheus@gmail.com");

        when(repository.findByEmail("matheus@gmail.com"))
                .thenReturn(Optional.of(admin));

        AdminResponse resultado = service.buscarPorEmail("matheus@gmail.com");

        assertEquals("matheus@gmail.com", resultado.email());

        verify(repository).findByEmail("matheus@gmail.com");
    }

    @Test
    void Deve_Deletar_Um_Administrador_Por_Id() {
    }
}