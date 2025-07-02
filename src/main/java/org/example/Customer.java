package org.example;

import java.util.ArrayList;
import java.util.List;


public class Customer {
     private int customerId;
     private String fullName;
     private List<Account> accounts;

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
     public void showCustomerInfo(){
         System.out.println("Müşteri ID: " + customerId + "Ad Soyad: " +fullName);
     }

        public int getCustomerID(){
         return customerId;
        }
        public String getFullName(){
         return fullName;
        }
        public List<Account> getAccounts(){
         return accounts;
        }





} 