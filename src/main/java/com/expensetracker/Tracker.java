package com.expensetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Net Balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    showNetBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addIncome(Scanner scanner) {
        System.out.println("Enter income source:");
        String source = scanner.next();
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        incomes.add(new Income(source, amount));
        System.out.println("Income added.");
    }

    private void addExpense(Scanner scanner) {
        System.out.println("Enter expense category:");
        String category = scanner.next();
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        expenses.add(new Expense(category, amount));
        System.out.println("Expense added.");
    }

    private void showNetBalance() {
        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpense = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double netBalance = totalIncome - totalExpense;

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + netBalance);
    }
}
