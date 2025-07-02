package org.example;

//yetersiz bakiye olduğundaki istisna durum
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
} 