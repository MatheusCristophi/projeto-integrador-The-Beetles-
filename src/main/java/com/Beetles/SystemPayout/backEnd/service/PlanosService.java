package com.Beetles.SystemPayout.backEnd.service;

import com.Beetles.SystemPayout.backEnd.domain.Planos;
import com.Beetles.SystemPayout.backEnd.repository.PlanosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanosService {
    private final PlanosRepository repository;

    public PlanosService(PlanosRepository repository) {
        this.repository = repository;
    }
    public Planos criarPlano(Planos planos){
        return repository.save(planos);
    }

    public List<Planos> mostrarTodosPlanos(){
        return repository.findAll();
    }

    public Planos mostrarPlanoEspecificoPeloId(Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
    }

    public Planos modificarPlano(Planos planos, Integer id){
        Planos planoExistente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        if(planoExistente.getNome() != null){
        planoExistente.setNome(planos.getNome());}
        if(planoExistente.getCategoria() != null){
        planoExistente.setCategoria(planos.getCategoria());}
        if(planoExistente.getValor() != null){
        planoExistente.setValor(planos.getValor());}
        planoExistente.setFrequenciaAulas(planos.getFrequenciaAulas());
        return repository.save(planoExistente);
    }
}