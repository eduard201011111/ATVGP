package com.example.atv.Controller;


import com.example.atv.DTO.AlunoDTO;
import com.example.atv.DTO.TurmaDTO;
import com.example.atv.Entity.Turma;
import com.example.atv.Service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")

public class TurmaController {


        @Autowired
        private TurmaService turmaService;

        @GetMapping
        public List<Turma> getAll(){
            return turmaService.getAllTurmas();
        }

        @GetMapping("/{id}")
        public ResponseEntity<TurmaDTO> getById(@PathVariable Long id){
            Optional<TurmaDTO> turmaDTOOptional = turmaService.getById(id);
            if(turmaDTOOptional.isPresent()){
                return ResponseEntity.ok(turmaDTOOptional.get());
            }else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<TurmaDTO> create(@RequestBody TurmaDTO turmaDTO){
            TurmaDTO turmaDTOSave = turmaService.create(turmaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTOSave);
        }

        @PutMapping("/{id}")
        public ResponseEntity<TurmaDTO> update(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO){
            Optional<TurmaDTO> turmaDTOOptional = turmaService.update(id, turmaDTO);
            if(turmaDTOOptional.isPresent()){
                return ResponseEntity.ok(turmaDTOOptional.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            if(turmaService.delete(id)){
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }
    }







