package com.ATJAVA.ATJAVA.repository;

import com.ATJAVA.ATJAVA.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    @Query("SELECT d FROM Departamento d")
    List<Departamento> findAllDepartamentosSemFuncionarios();
}
