package br.com.itau.desafioitau.controller;

import br.com.itau.desafioitau.model.Transacao;
import br.com.itau.desafioitau.model.TransacaoEstatisticaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();

    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody Transacao transacao) {
        if (transacao.getValor() < 0 ||
            transacao.getDataHora() == null ||
            transacao.getDataHora().isAfter(OffsetDateTime.now()) ||
            Double.isNaN(transacao.getValor())) {
            return ResponseEntity.unprocessableEntity().build(); // 422 ou 400
        }

        transacoes.add(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes() {
        transacoes.clear();
        return ResponseEntity.ok().build(); // 200
    }

    @GetMapping("/statistics")
    public ResponseEntity<TransacaoEstatisticaDTO> estatisticas() {
        OffsetDateTime agora = OffsetDateTime.now();
        List<Transacao> ultimasTransacoes = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(60)))
                .toList();

        if (ultimasTransacoes.isEmpty()) {
            return ResponseEntity.ok(new TransacaoEstatisticaDTO(0, 0, 0, 0, 0));
        }

        double soma = ultimasTransacoes.stream().mapToDouble(Transacao::getValor).sum();
        double media = soma / ultimasTransacoes.size();
        double max = ultimasTransacoes.stream().mapToDouble(Transacao::getValor).max().orElse(0);
        double min = ultimasTransacoes.stream().mapToDouble(Transacao::getValor).min().orElse(0);
        long quantidade = ultimasTransacoes.size();

        return ResponseEntity.ok(new TransacaoEstatisticaDTO(soma, media, max, min, quantidade));
    }
}
