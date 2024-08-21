package org.example.dto;

import org.example.enums.EFormaPagamento;

import java.math.BigDecimal;

public class PagamentoDTO {
    BigDecimal valor;
    Integer formaPagamento;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
