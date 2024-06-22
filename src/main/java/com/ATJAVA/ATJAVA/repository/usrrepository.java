package com.ATJAVA.ATJAVA.repository;

import com.ATJAVA.ATJAVA.model.Funcionario;
import com.ATJAVA.ATJAVA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usrrepository extends JpaRepository<Usuario, Long> {
}
