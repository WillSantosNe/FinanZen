package br.com.william.finanzen.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.william.finanzen.model.CategoryEnum;
import br.com.william.finanzen.model.Transaction;

/** 
 * Motor Financeiro responsável pelas regras de negócios.
 * Gerencia a lista de transações e realiza cálculos de alta precisão
 * 
*/
public class FinancialManager {
    
    /**
     * Optei pelo uso de Map para melhor performance de pesquisa
     */
    private Map<Long, Transaction> transactions;
    private final CurrencyService currencyService;

    public FinancialManager(){
        this.transactions = new HashMap<>();
        this.currencyService = new CurrencyService();
    }

    /**
     * Adiciona uma nova transão ao motor financeiro
     * 
     * @param transaction
     */
    public void addTransaction(Transaction transaction){
        this.transactions.put(transaction.id(), transaction);
    }

    /**
     * Retorna um Optional da transação buscada pelo Id
     * 
     * @param id
     * @return
     */
    public Optional<Transaction> getTransaction(Long id){
        return Optional.ofNullable(this.transactions.get(id));
    }

    /**
     * Retorna cópia segura de todas as transações (para leitura).
     */
    public List<Transaction> getAllTransactions(){
        return List.copyOf(transactions.values());
    }

    /**
     * Retorna uma lista de Transações por categoria.
     * 
     * Optei pelo uso de .stream.filter por questões perfomáticas e visuais
     * @param category
     * @return
     */
    public List<Transaction> getListByCategory(CategoryEnum category){
        return this.transactions.values()
            .stream()
            .filter(t->t.category().equals(category))
            .toList();
    }

    /**
     * Realiza o calculo de Saldo de acordo com as transações
     * Só entra no calculo o que for receita, os outros tipos são negativos.
     * 
     * Optei pelo BigDecimal pela precisão bancária.
     * Optei pelo HALF_EVEN para arredondamento - padrões bancários.
     */
    public BigDecimal calculateTotalBalance(){
        return this.transactions.values()
        .stream()
        .map(t -> {
            return t.category().equals(CategoryEnum.INCOME) ? t.amount() : t.amount().negate();
        })
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(2,RoundingMode.HALF_EVEN);
    }

    /**
     * Converte determinado valor BRL em USD usando a cotação atual da API externa.
     * 
     * @param balanceInBRL
     * @return
     */
    public BigDecimal convertBalanceToUSD(BigDecimal balanceInBRL){
        BigDecimal rate = currencyService.getCurrentyUSDRate();

        // Validação para evitar divisão por zero - resiliencia
        if(rate.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }

        // Usando arredondamento HALF_EVEN - padrões bancários
        return balanceInBRL.divide(rate, 2, RoundingMode.HALF_EVEN);
    }
}
