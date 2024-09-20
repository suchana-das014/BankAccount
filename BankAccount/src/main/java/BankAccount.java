import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private static int accountCounter = 1000;
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName) {
        this.accountNumber = accountCounter++;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transfer successful. Your current balance: $" + balance);
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
        }
    }

    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
    }
}

