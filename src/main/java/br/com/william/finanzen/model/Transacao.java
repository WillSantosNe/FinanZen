package br.com.william.finanzen.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    // Posteriormente implementar um ID
    private String descricao;
    private BigDecimal valor; // Uso correto de guardar dados de dinheiro
    private LocalDate data;
    private String tipo; // Posteriormente implementar um Enum

    public Transacao(String descricao, BigDecimal valor, LocalDate data, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
