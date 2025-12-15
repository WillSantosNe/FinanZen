package br.com.william.finanzen.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa uma transação financeira no sistema.
 * <p>
 * Esta classe é responsável por armazenar os dados de uma movimentação
 * financeira,
 * como valor, data, descrição e tipo.
 * </p>
 * <p>
 * Implementa {@link Comparable} para permitir a ordenação natural cronológica
 * (da data mais antiga para a mais recente).
 * </p>
 *
 * @author FinanZen Team
 * @since 1.0
 */
public class Transacao implements Comparable<Transacao> {

    // Posteriormente implementar um ID
    private String descricao;
    private BigDecimal valor; // Uso correto de guardar dados de dinheiro
    private LocalDate data;
    private Categoria categoria;

    public Transacao(String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Compara esta transação com outra para fins de ordenação.
     * <p>
     * A regra de ordenação natural é <b>CRONOLÓGICA</b>, ou seja,
     * as transações são ordenadas da data mais antiga para a mais recente.
     * </p>
     *
     * @param outra A transação a ser comparada.
     * @return Um inteiro negativo, zero ou positivo se esta transação for
     *         anterior, igual ou posterior à transação comparada, respectivamente.
     */
    @Override
    public int compareTo(Transacao outra) {
        return this.data.compareTo(outra.data);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
