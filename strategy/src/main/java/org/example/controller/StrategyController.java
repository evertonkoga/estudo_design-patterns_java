package org.example.controller;

import org.example.enums.EFormaPagamento;
import org.example.model.Compra;
import org.example.service.IEstrategiaPagamento;
import org.example.dto.PagamentoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/strategy")
public class StrategyController {

    @PostMapping(value = "pagar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> strategy(@RequestBody PagamentoDTO pedidoPagamento) {
        Compra compra = new Compra(pedidoPagamento.getValor());

        EFormaPagamento eFormaPagamento = EFormaPagamento.valueOfTipo(pedidoPagamento.getFormaPagamento());
        if (eFormaPagamento == null) {
            return ResponseEntity.badRequest().body("Forma de pagamento não permitido");
        }

        IEstrategiaPagamento estrategiaPagamento = eFormaPagamento.criarEstrategia();
        String retorno = compra.processarCompra(estrategiaPagamento);
        return ResponseEntity.ok().body(retorno);
    }
}
