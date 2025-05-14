package com.jekoomarket.controller;

import com.jekoomarket.model.JekProduto;
import com.jekoomarket.service.JekProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JekProdutoController {

    @Autowired
    private JekProdutoService produtoService;

    @GetMapping({"/", "/produtos"})
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "jek-produtos";
    }
}
