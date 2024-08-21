package org.example.model;

import org.example.service.IEstrategiaPagamento;

import java.math.BigDecimal;

public class Compra {
    BigDecimal valor;

    public Compra(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String processarCompra(IEstrategiaPagamento IEstrategiaPagamento) {
        return IEstrategiaPagamento.pagar(this);
    }
}
