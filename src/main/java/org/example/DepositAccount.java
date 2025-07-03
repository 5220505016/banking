package org.example;


public class DepositAccount implements Account {
    private static int counter = 2000;
    private final String accountNumber;
    private double balance;
    private final double interestRate = 0.3;

    public DepositAccount(double balance) {
        this.accountNumber = "D" + (++counter);
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

        double penalty = amount * 0.01;
        balance -= (amount + penalty);
        System.out.println(amount + " TL çekildi. Ceza: " + penalty + " TL. Yeni bakiye: " + balance);
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Faiz uygulandı: " + interest + " TL. Yeni bakiye: " + balance);
    }

    @Override
    public void showBalance() {
        System.out.println("Hesap No: " + accountNumber + ", Bakiye: " + balance + ", Faiz Oranı: " + interestRate);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }


}
