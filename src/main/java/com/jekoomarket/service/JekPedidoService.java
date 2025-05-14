package com.jekoomarket.service;

import com.jekoomarket.model.JekPedido;
import com.jekoomarket.repository.JekPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JekPedidoService {

    @Autowired
    private JekPedidoRepository pedidoRepository;

    public void salvar(JekPedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<JekPedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}
