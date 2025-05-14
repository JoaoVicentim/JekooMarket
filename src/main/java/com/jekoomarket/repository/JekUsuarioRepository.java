package com.jekoomarket.repository;

import com.jekoomarket.model.JekUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JekUsuarioRepository extends JpaRepository<JekUsuario, Long> {
    Optional<JekUsuario> findByEmail(String email);
}
