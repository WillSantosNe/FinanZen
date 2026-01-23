package br.com.william.finanzen.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
Representa uma transação financeira imutável no sistema.

Uso de Records para garantir a imutabilidade dos dados e a clareza
de propósito como um transportador de dados (DTO).

@param id           - Indentificador único da transação
@param description    - Descricao curta da movimentacao
@param amount        - Valor monetário de alta precisão (BigDecimal)
@param date         - Data da ocorrência
@param category    - Tipo da movimentação
*/
public record Transaction(
    Long id,
    String description,
    BigDecimal amount,
    LocalDate date,
    CategoryEnum category
) {
    
    public Transaction{
        Objects.requireNonNull(id, "ID cannot be null");
        Objects.requireNonNull(description, "Description cannot be null");
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(date, "Date cannot be null");
        Objects.requireNonNull(category, "Category cannot be null");
    }

}
