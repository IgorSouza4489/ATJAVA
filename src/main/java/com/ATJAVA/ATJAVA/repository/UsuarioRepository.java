package com.ATJAVA.ATJAVA.repository;

import com.ATJAVA.ATJAVA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByNome(final String nome);
}