package com.Beetles.systempayout.backend.plano.service;

import com.Beetles.systempayout.backend.plano.model.Planos;
import com.Beetles.systempayout.backend.plano.repository.PlanosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanosService {
    private final PlanosRepository repository;

    public PlanosService(PlanosRepository repository) {
        this.repository = repository;
    }
    @Transactional
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
    @Transactional
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
    @Transactional
    public void deletarPlano(Integer id){
        if(id == null) {
            throw new RuntimeException("Id não encontrado");
        }else{
            repository.deleteById(id);
        }
    }
}