package com.ATJAVA.ATJAVA.controller;

import com.ATJAVA.ATJAVA.model.Departamento;
import com.ATJAVA.ATJAVA.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoService.getAllDepartamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.getDepartamentoById(id);
        return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        Departamento savedDepartamento = departamentoService.saveDepartamento(departamento);
        return ResponseEntity.ok(savedDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamentoDetails) {
        Optional<Departamento> departamento = departamentoService.getDepartamentoById(id);
        if (departamento.isPresent()) {
            Departamento updatedDepartamento = departamento.get();
            updatedDepartamento.setNome(departamentoDetails.getNome());
            updatedDepartamento.setLocal(departamentoDetails.getLocal());
            updatedDepartamento.setFuncionarios(departamentoDetails.getFuncionarios());
            departamentoService.saveDepartamento(updatedDepartamento);
            return ResponseEntity.ok(updatedDepartamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteDepartamento(id);
        return ResponseEntity.ok("Departamento deletado com sucesso.");
    }
}
