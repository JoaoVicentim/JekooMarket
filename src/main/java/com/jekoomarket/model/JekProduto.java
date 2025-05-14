package com.jekoomarket.model;

import jakarta.persistence.*;

@Entity
public class JekProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 2000)
    private String descricao;

    private double preco;

    private String categoria;

    private boolean seloVerde;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private JekUsuario vendedor;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isSeloVerde() { return seloVerde; }
    public void setSeloVerde(boolean seloVerde) { this.seloVerde = seloVerde; }

    public JekUsuario getVendedor() { return vendedor; }
    public void setVendedor(JekUsuario vendedor) { this.vendedor = vendedor; }
}
