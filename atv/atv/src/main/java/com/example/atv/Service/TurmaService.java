package com.example.atv.Service;

import com.example.atv.DTO.TurmaDTO;
import com.example.atv.DTO.AlunoDTO;
import com.example.atv.Entity.Aluno;
import com.example.atv.Repository.AlunoRepository;
import com.example.atv.Entity.Turma;
import com.example.atv.Repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<TurmaDTO> getById(Long id){
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if(turmaOptional.isPresent()){
            TurmaDTO turmaDTO = new TurmaDTO();
            return Optional.of(turmaDTO.fromTurma(turmaOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public TurmaDTO create(TurmaDTO turmaDTO){
        Turma turma = turmaDTO.toTurma();
        turma = turmaRepository.save(turma);
        return turmaDTO.fromTurma(turma);
    }

    public Optional<TurmaDTO> update(Long id, TurmaDTO turmaDTO){
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if(turmaOptional.isPresent()){
            Turma turma = turmaOptional.get();
            turma.setId(TurmaDTO.getId());
            turma.setSigla(TurmaDTO.getSigla());
            turma.setNumerosala(TurmaDTO.getNumerosala());
            turma.setNome(turmaDTO.getNome());

            turma = turmaRepository.save(turma);

            return Optional.of(turmaDTO.fromTurma(turma));
        }else{
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(turmaRepository.existsById(id)){
            turmaRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}

