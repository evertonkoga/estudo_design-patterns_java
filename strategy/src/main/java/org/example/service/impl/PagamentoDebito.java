package org.example.service.impl;

import org.example.model.Compra;
import org.example.service.IEstrategiaPagamento;

public class PagamentoDebito implements IEstrategiaPagamento {
    @Override
    public String pagar(Compra compra) {
        return "Pagou no débito " + compra.getValor();
    }
}
