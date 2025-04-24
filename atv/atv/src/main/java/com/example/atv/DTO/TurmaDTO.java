package com.example.atv.DTO;

import com.example.atv.Entity.Aluno;
import com.example.atv.Entity.Turma;
import com.example.atv.Entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDTO {

    private Long id;
    private String sigla;
    private int numeroSala;
    private String nome;
    private List<Professor> professores;

    public Turma toTurma(){
        return new Turma(
                this.id,
                this.sigla,
                this.numeroSala,
                this.nome
        );
    }


    public TurmaDTO fromTurma(Turma turma) {
        return new TurmaDTO(
                turma.getId(),
                turma.getSigla(),
                turma.getNumerosala(),
                turma.getNome(),
                turma.getProfessores()
        );
    }
}
