package com.Beetles.systempayout.backend.plano.controller;

import com.Beetles.systempayout.backend.plano.controller.mapper.PlanoMapper;
import com.Beetles.systempayout.backend.plano.controller.request.PlanoRequest;
import com.Beetles.systempayout.backend.plano.controller.response.PlanoResponse;
import com.Beetles.systempayout.backend.plano.model.Plano;
import com.Beetles.systempayout.backend.plano.service.PlanosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    private final PlanosService service;

    public PlanoController(PlanosService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PlanoResponse> salvarPlano(@RequestBody PlanoRequest plano) {
        Plano planoSalvo = service.criarPlano(PlanoMapper.mapRequest(plano));
        PlanoResponse planoResponse = PlanoMapper.mapResponse(planoSalvo);
        return new ResponseEntity<>(planoResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanoResponse>> mostrarPlanos() {
        List<Plano> plano = service.mostrarTodosPlanos();
        List<PlanoResponse> planoResponses = plano
                .stream().map(PlanoMapper::mapResponse)
                .toList();
        return ResponseEntity.ok(planoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponse> verPlanoEspecifico(@PathVariable UUID id) {
        Plano plano = service.mostrarPlanoEspecificoPeloId(id);
        PlanoResponse planoResponse = PlanoMapper.mapResponse(plano);
        return new ResponseEntity<>(planoResponse, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponse> atualizarPlano(@RequestBody PlanoRequest plano, @PathVariable UUID id) {
        Plano planoAnterior = service.modificarPlano(PlanoMapper.mapRequest(plano), id);
        PlanoResponse planoAtualizado = PlanoMapper.mapResponse(planoAnterior);
        return new ResponseEntity<>(planoAtualizado, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void apagarPlano(@PathVariable UUID id){
        service.deletarPlano(id);
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}