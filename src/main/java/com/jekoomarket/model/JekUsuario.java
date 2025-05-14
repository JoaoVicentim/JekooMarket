package com.jekoomarket.model;

import jakarta.persistence.*;

@Entity
public class JekUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    private boolean vendedor;

    private boolean consentimentoLGPD;

    private boolean ativo;
    private boolean admin;

    // getters e setters
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }


    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean isVendedor() { return vendedor; }
    public void setVendedor(boolean vendedor) { this.vendedor = vendedor; }

    public boolean isConsentimentoLGPD() { return consentimentoLGPD; }
    public void setConsentimentoLGPD(boolean consentimentoLGPD) { this.consentimentoLGPD = consentimentoLGPD; }
}
