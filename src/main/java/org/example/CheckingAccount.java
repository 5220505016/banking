package org.example;


public class CheckingAccount implements Account {
    private static int counter = 1000;
    private String accountNumber;
    private double balance;

    public CheckingAccount(double balance) {
        this.accountNumber = "C" + (++counter);
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Yatırılan miktar pozitif olmalıdır.");
            return;
        }
        balance += amount;
        System.out.println(amount + " TL yatırıldı. Yeni bakiye: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Çekilen miktar pozitif olmalıdır.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Yetersiz bakiye!");
        }
        balance -= amount;
        System.out.println(amount + " TL çekildi. Yeni bakiye: " + balance);
    }

    @Override
    public void showBalance() {
        System.out.println("Hesap No: " + accountNumber + ", Bakiye: " + balance);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
