package com.jekoomarket.service;

import com.jekoomarket.model.JekProduto;
import com.jekoomarket.repository.JekProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JekProdutoService {

    @Autowired
    private JekProdutoRepository produtoRepository;

    public List<JekProduto> listarTodos() {
        return produtoRepository.findAll();
    }

    public void salvar(JekProduto produto) {
        produtoRepository.save(produto);
    }
}
