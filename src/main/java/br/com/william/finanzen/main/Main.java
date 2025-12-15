package br.com.william.finanzen.main;

import br.com.william.finanzen.model.Transacao;
import br.com.william.finanzen.model.Categoria;
import br.com.william.finanzen.service.GestorFinanceiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Finanzen...");

        // Instancia o "Banco" em memória
        GestorFinanceiro banco = new GestorFinanceiro();

        // Criando cenários (Mock data)
        Transacao t1 = new Transacao("Salário Cap", new BigDecimal("5000.00"), LocalDate.now(), Categoria.RECEITA);
        Transacao t2 = new Transacao("Academia", new BigDecimal("120.00"), LocalDate.now(), Categoria.SAUDE);
        Transacao t3 = new Transacao("Suplementos", new BigDecimal("250.50"), LocalDate.now(), Categoria.SAUDE);
        Transacao t4 = new Transacao("Uber", new BigDecimal("45.00"), LocalDate.now(), Categoria.TRANSPORTE);

        banco.adicionarTransacao(t1);
        banco.adicionarTransacao(t2);
        banco.adicionarTransacao(t3);
        banco.adicionarTransacao(t4);

        System.out.println("--------------------------------");
        System.out.println("Saldo Atual: R$ " + banco.consultarSaldo());

        System.out.println("--------------------------------");
        System.out.println("Relatório por Categoria:");
        java.util.Map<Categoria, BigDecimal> relatorio = banco.agruparTotalPorCategoria();
        relatorio.forEach((categoria, total) -> System.out.println(categoria + ": R$ " + total));
    }
}