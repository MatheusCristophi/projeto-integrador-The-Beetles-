package com.Beetles.systempayout.backend.plano.controller;

import com.Beetles.systempayout.backend.plano.controller.request.PlanoRequest;
import com.Beetles.systempayout.backend.plano.controller.response.PlanoResponse;
import com.Beetles.systempayout.backend.plano.service.PlanosService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/plano")
@RateLimiter(name = "planoRateLimiter", fallbackMethod = "rateLimiterResponse")
public class PlanoController {

    private final PlanosService service;

    public PlanoController(PlanosService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PlanoResponse> salvarPlano(@Valid @RequestBody PlanoRequest request) {
        var plano = service.criarPlano(request);
        var response = PlanoResponse.toPlanoResponse(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<PlanoResponse>> mostrarPlanos(
            @PageableDefault(size = 20, page = 0) Pageable pageable){
        Page<PlanoResponse> response = service
                .mostrarTodosPlanos(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PlanoResponse> verPlanoEspecifico(@PathVariable UUID id) {
        var plano = service.mostrarPlanoEspecificoPeloId(id);
        return ResponseEntity.ok(plano);
    }

    @PutMapping("/atualizar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PlanoResponse> atualizarPlano(@Valid @RequestBody PlanoRequest request, @PathVariable UUID id) {
        var plano = service.modificarPlano(request, id);
        var response = PlanoResponse.toPlanoResponse(plano);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> apagarPlano(@PathVariable UUID id){
        service.deletarPlano(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> rateLimiterResponse(){
        return ResponseEntity.ok("Muitas requisições, espere um momento e tente novamente");
    }
}