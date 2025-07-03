package org.example;

import java.util.ArrayList;
import java.util.List;


public class Customer {
     private final int customerId;
     private final String fullName;
     private final List<Account> accounts;

     public Customer(int customerId, String fullName){
        this.customerId = customerId;
        this.fullName = fullName;
        this.accounts =  new ArrayList<>();
     }
     public void addAccount(Account account) {
         accounts.add(account);
     }
     public void listAccount() {
         System.out.println("Müşteri: " + fullName + "(ID: " +customerId+ ") Hesapları:");
         for ( Account acc : accounts ) {
             acc.showBalance();
         }
     }
     public Account findAccountByNumber(String accountNumber) {
         for( Account acc : accounts ){
             if (acc.getAccountNumber().equals(accountNumber)){
                return acc;
             }
         }
         return null;
     }

    public int getCustomerID(){
         return customerId;
        }






} 