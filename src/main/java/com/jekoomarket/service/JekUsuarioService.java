package com.jekoomarket.service;

import com.jekoomarket.model.JekUsuario;
import com.jekoomarket.repository.JekUsuarioRepository;
import com.jekoomarket.security.JekUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JekUsuarioService implements UserDetailsService {

    private final JekUsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public JekUsuarioService(JekUsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<JekUsuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Salvar usuário (cadastro)
    public JekUsuario salvar(JekUsuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setAtivo(true);
        usuario.setAdmin(false);
        return usuarioRepository.save(usuario);
    }

    // Método necessário para Spring Security
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JekUsuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));
        return new JekUserDetails(usuario);
    }
}
