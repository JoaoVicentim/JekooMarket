package com.jekoomarket.controller;

import com.jekoomarket.model.JekPedido;
import com.jekoomarket.model.JekProduto;
import com.jekoomarket.model.JekUsuario;
import com.jekoomarket.service.JekPedidoService;
import com.jekoomarket.service.JekProdutoService;
import com.jekoomarket.service.JekUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class JekPedidoController {

    @Autowired
    private JekPedidoService pedidoService;

    @Autowired
    private JekProdutoService produtoService;

    @Autowired
    private JekUsuarioService usuarioService;

    @GetMapping("/novo")
    public String formPedido(Model model) {
        List<JekProduto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        model.addAttribute("pedido", new JekPedido());
        return "jek-pedido-form";
    }

    @PostMapping("/novo")
    public String criarPedido(@RequestParam List<Long> produtosIds, Authentication auth) {
        String email = auth.getName();
        JekUsuario comprador = usuarioService.buscarPorEmail(email).orElse(null);
        if (comprador == null) {
            return "redirect:/login";
        }

        if (produtosIds == null || produtosIds.isEmpty()) {
            return "redirect:/pedidos/novo?erro=semProdutos";
        }

        List<JekProduto> produtosSelecionados = produtoService.listarTodos().stream()
                .filter(p -> produtosIds.contains(p.getId()))
                .toList();

        if (produtosSelecionados.isEmpty()) {
            return "redirect:/pedidos/novo?erro=semProdutos";
        }

        JekPedido pedido = new JekPedido();
        pedido.setComprador(comprador);
        pedido.setProdutos(produtosSelecionados);
        pedido.setDataPedido(LocalDateTime.now());
        double valorTotal = produtosSelecionados.stream()
                .mapToDouble(JekProduto::getPreco)
                .sum();
        pedido.setValorTotal(valorTotal);

        pedidoService.salvar(pedido);

        return "redirect:/pedidos/meus";
    }

    @GetMapping("/meus")
    public String listarMeusPedidos(Model model, Authentication auth) {
        String email = auth.getName();
        JekUsuario comprador = usuarioService.buscarPorEmail(email).orElse(null);
        if (comprador == null) {
            return "redirect:/login";
        }

        List<JekPedido> pedidos = pedidoService.listarTodos().stream()
                .filter(p -> p.getComprador().getId().equals(comprador.getId()))
                .toList();

        model.addAttribute("pedidos", pedidos);
        return "jek-pedidos-lista";
    }
}
