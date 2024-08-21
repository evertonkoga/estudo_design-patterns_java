package org.example.enums;

import org.example.service.IEstrategiaPagamento;
import org.example.service.impl.PagamentoCredito;
import org.example.service.impl.PagamentoDebito;
import org.example.service.impl.PagamentoPix;

import java.util.HashMap;
import java.util.Map;

public enum EFormaPagamento {

    DEBITO(1) {
        @Override
        public IEstrategiaPagamento criarEstrategia() {
            return new PagamentoDebito();
        }
    },
    CREDITO(2) {
        @Override
        public IEstrategiaPagamento criarEstrategia() {
            return new PagamentoCredito();
        }
    },
    PIX(3) {
        @Override
        public IEstrategiaPagamento criarEstrategia() {
            return new PagamentoPix();
        }
    };

    private static final Map<Integer, EFormaPagamento> ALL = new HashMap<>();
    static {
        for (EFormaPagamento eFormaPagamento: values()) {
            ALL.put(eFormaPagamento.tipo, eFormaPagamento);
        }
    }

    public final Integer tipo;

    EFormaPagamento(Integer tipo) {
        this.tipo = tipo;
    }

    public static EFormaPagamento valueOfTipo(Integer tipo) {
        return ALL.get(tipo);
    }

    public abstract IEstrategiaPagamento criarEstrategia();
}
