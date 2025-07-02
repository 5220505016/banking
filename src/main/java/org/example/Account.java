package org.example;


public interface Account {
    void deposit(double amount);

    void withdraw(double amount) throws InsufficientBalanceException;
    void showBalance();
    String getAccountNumber();


}
