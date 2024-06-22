package com.ATJAVA.ATJAVA.controller;

import com.ATJAVA.ATJAVA.model.Funcionario;
import com.ATJAVA.ATJAVA.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario savedFuncionario = funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.ok(savedFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario.isPresent()) {
            Funcionario updatedFuncionario = funcionario.get();
            updatedFuncionario.setNome(funcionarioDetails.getNome());
            updatedFuncionario.setEndereco(funcionarioDetails.getEndereco());
            updatedFuncionario.setTelefone(funcionarioDetails.getTelefone());
            updatedFuncionario.setEmail(funcionarioDetails.getEmail());
            updatedFuncionario.setDataNascimento(funcionarioDetails.getDataNascimento());
            updatedFuncionario.setDepartamento(funcionarioDetails.getDepartamento());
            funcionarioService.saveFuncionario(updatedFuncionario);
            return ResponseEntity.ok(updatedFuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.ok("Funcionário deletado com sucesso.");
    }
}
