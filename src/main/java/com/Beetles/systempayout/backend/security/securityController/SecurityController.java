package com.Beetles.systempayout.backend.security.securityController;


import com.Beetles.systempayout.backend.admin.controller.mapper.AdminMapper;
import com.Beetles.systempayout.backend.admin.controller.request.AdminRequest;
import com.Beetles.systempayout.backend.admin.controller.response.AdminResponse;
import com.Beetles.systempayout.backend.admin.service.AdminService;
import com.Beetles.systempayout.backend.aluno.controller.mapper.AlunoMapper;
import com.Beetles.systempayout.backend.aluno.controller.request.AlunoRequest;
import com.Beetles.systempayout.backend.aluno.controller.response.AlunoResponse;
import com.Beetles.systempayout.backend.aluno.service.AlunoService;
import com.Beetles.systempayout.backend.security.securityController.request.LoginRequest;
import com.Beetles.systempayout.backend.security.securityController.response.LoginResponse;
import com.Beetles.systempayout.backend.security.tokenService.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class SecurityController {
    private final AlunoService alunoService;
    private final AdminService adminService;
    private final ObjectProvider<AuthenticationManager> authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/aluno/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AlunoResponse> registrar(@RequestBody @Valid AlunoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlunoMapper.mapResponse(alunoService.registerUser(AlunoMapper.mapRequest(request))));
    }

    @PostMapping("/admin/register")
    public ResponseEntity<AdminResponse> registrar(@RequestBody @Valid AdminRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AdminMapper.responseMapper(adminService.registrar(AdminMapper.requestMapper(request))));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        var userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var auth = authenticationManager.getObject().authenticate(userAndPass);
        var userDetails = (UserDetails) auth.getPrincipal();
        var token = tokenService.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
