package com.Beetles.systempayout.backend.aluno.Mapper;

import com.Beetles.systempayout.backend.aluno.DTO.AlunoDTO;
import com.Beetles.systempayout.backend.aluno.model.Aluno;

public class AlunoMapper {

    public Aluno map (AlunoDTO alunoDTO){
        Aluno aluno = new Aluno();

        aluno.setAlunoId(alunoDTO.getAlunoId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setDataCadastro(alunoDTO.getDataCadastro());
        aluno.setStatus(alunoDTO.getStatus());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setDataInicioPlano(alunoDTO.getDataInicioPlano());
        aluno.setDiaVencimento(alunoDTO.getDiaVencimento());
        aluno.setDataProximoVencimento(alunoDTO.getDataProximoVencimento());
        aluno.setPrimeiroAcesso(alunoDTO.isPrimeiroAcesso());
        aluno.setPlanoEscolhidoId(alunoDTO.getPlanoEscolhidoId());

        return aluno;
    }

    public AlunoDTO mapDTO (Aluno aluno){
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setAlunoId(aluno.getAlunoId());
        alunoDTO.setPrimeiroAcesso(aluno.isPrimeiroAcesso());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setDataCadastro(aluno.getDataCadastro());
        alunoDTO.setStatus(aluno.getStatus());
        alunoDTO.setTelefone(aluno.getTelefone());
        alunoDTO.setDiaVencimento(aluno.getDiaVencimento());
        alunoDTO.setDataInicioPlano(aluno.getDataInicioPlano());
        alunoDTO.setDataProximoVencimento(aluno.getDataProximoVencimento());
        alunoDTO.setPlanoEscolhidoId(aluno.getPlanoEscolhidoId());

        return alunoDTO;
    }
}
