package com.Banking;

public class BankingOperations {
	public void viewBalance() {
        if (UserLoginState.getInstance().isLoggedIn()) {
            System.out.println("Viewing balance...");
        } else {
            System.out.println("Please log in to view your balance.");
        }
    }

    public void deposit(double amount) {
        if (UserLoginState.getInstance().isLoggedIn()) {
            System.out.println("Depositing $" + amount + "...");
        } else {
            System.out.println("Please log in to deposit money.");
        }
    }

    public void withdraw(double amount) {
        if (UserLoginState.getInstance().isLoggedIn()) {
            System.out.println("Withdrawing $" + amount + "...");
        } else {
            System.out.println("Please log in to withdraw money.");
        }
    }
}
