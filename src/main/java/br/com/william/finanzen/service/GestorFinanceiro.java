package br.com.william.finanzen.service;

import br.com.william.finanzen.model.Transacao;
import br.com.william.finanzen.model.Categoria;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * Gerencia as operações financeiras do sistema.
 * <p>
 * Responsável por manter a lista de transações e realizar operações
 * como adicionar transações, consultar saldo e listar transações ordenadas.
 * </p>
 *
 * @author FinanZen Team
 * @since 1.0
 */
public class GestorFinanceiro {

    private List<Transacao> transacoes;

    public GestorFinanceiro() {
        // Cria um banco de dados vazio para exemplo
        this.transacoes = new ArrayList<>();
    }

    /**
     * Adiciona uma nova transação ao gestor.
     *
     * @param novaTransacao A transação a ser adicionada.
     */
    public void adicionarTransacao(Transacao novaTransacao) {
        this.transacoes.add(novaTransacao);
        System.out.println("Transação salva: " + novaTransacao.toString());
    }

    // Exemplo de regra de negócio: Calcular Saldo
    public BigDecimal consultarSaldo() {
        BigDecimal saldo = BigDecimal.ZERO;

        for (Transacao t : this.transacoes) {
            saldo = t.getCategoria() == Categoria.RECEITA ? saldo.add(t.getValor()) : saldo.subtract(t.getValor());
        }
        return saldo;
    }

    public List<Transacao> listarTodas() {
        return this.transacoes;
    }

    /**
     * Retorna uma nova lista de transações ordenada pelo valor de forma
     * decrescente.
     * <p>
     * Este método não modifica a lista original de transações (side-effect free).
     * Ele cria uma cópia, ordena pelo valor (do maior para o menor) e a retorna.
     * </p>
     *
     * @return Uma nova lista contendo as transações ordenadas pelo valor (DESC).
     */
    public List<Transacao> listarPorMaiorValor() {
        return this.transacoes.stream()
                .sorted(Comparator.comparing(Transacao::getValor).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Agrupa o total dos valores das transações por categoria.
     * <p>
     * Este método itera sobre a lista de transações e acumula os valores
     * correspondentes a cada categoria em um Map.
     * </p>
     *
     * @return Um Map onde a chave é a categoria e o valor é a soma total
     *         (BigDecimal).
     */
    public Map<Categoria, BigDecimal> agruparTotalPorCategoria() {
        Map<Categoria, BigDecimal> totalPorCategoria = new HashMap<>();

        for (Transacao t : this.transacoes) {
            totalPorCategoria.merge(t.getCategoria(), t.getValor(), BigDecimal::add);
        }

        return totalPorCategoria;
    }
}
