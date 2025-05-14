package com.jekoomarket.controller;

import com.jekoomarket.model.JekUsuario;
import com.jekoomarket.service.JekUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JekUsuarioController {

    @Autowired
    private JekUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastro")
    public String formCadastro(Model model) {
        model.addAttribute("usuario", new JekUsuario());
        return "jek-cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute JekUsuario usuario, @RequestParam(value="consentimentoLGPD", required=false) boolean consentimentoLGPD) {
        if (!consentimentoLGPD) {
            // Tratar caso usuário não aceite LGPD
            return "jek-cadastro";
        }
        usuario.setConsentimentoLGPD(consentimentoLGPD);
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "jek-login";
    }
}
