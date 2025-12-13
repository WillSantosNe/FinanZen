package br.com.william.finanzen.service;

import br.com.william.finanzen.model.Transacao;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class GestorFinanceiro {

    private List<Transacao> transacoes;

    public GestorFinanceiro() {
        // Cria um banco de dados vazio para exemplo
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao novaTransacao) {
        this.transacoes.add(novaTransacao);
        System.out.println("Transação salva: " + novaTransacao.toString());
    }

    // Exemplo de regra de negócio: Calcular Saldo
    public BigDecimal consultarSaldo() {
        BigDecimal saldo = BigDecimal.ZERO;

        for (Transacao t : this.transacoes) {
            if (t.getTipo().equals("RECEITA")) {
                saldo = saldo.add(t.getValor());
            } else if (t.getTipo().equals("DESPESA")) {
                saldo = saldo.subtract(t.getValor());
            }
        }
        return saldo;
    }

    public List<Transacao> listarTodas() {
        return this.transacoes;
    }
}
