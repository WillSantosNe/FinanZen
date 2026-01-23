package br.com.william.finanzen.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.william.finanzen.model.CategoryEnum;
import br.com.william.finanzen.model.Transaction;
import br.com.william.finanzen.service.FinancialManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- FINANZEN CORE STARTED --- \n");

        FinancialManager manager = new FinancialManager();

        // Criando massa de dados para teste
        Transaction t1 = new Transaction(1L, "Monthly Salary", new BigDecimal("5000.00"), LocalDate.now(), CategoryEnum.INCOME);

        Transaction t2 = new Transaction(2L, "Electricity Bill", new BigDecimal("250.50"), LocalDate.now(), CategoryEnum.EXPENSE);

        Transaction t3 = new Transaction(3L, "Supermarket", new BigDecimal("800.00"), LocalDate.now(), CategoryEnum.EXPENSE);

        Transaction t4 = new Transaction(4L, "Treasury Investment", new BigDecimal("1000.00"), LocalDate.now(), CategoryEnum.INVESTIMENT);

        manager.addTransaction(t1);
        manager.addTransaction(t2);
        manager.addTransaction(t3);
        manager.addTransaction(t4);

        System.out.println("Transactions added successfully!" + "\n");

        System.out.println("Calculating Total Balance...");
        System.out.println("Current Balance: R$ " + manager.calculateTotalBalance() + "\n");

        System.out.println("Retrieving transaction by ID 3...");
        System.out.println(manager.getTransaction((long) 3) + "\n");

        System.out.println("Listing only EXPENSES: ");
        manager.getListByCategory(CategoryEnum.EXPENSE).forEach(t -> System.out.println("   " + t));

        System.out.println("\n--- EXECUTION FINISHED ---");
    }
}
