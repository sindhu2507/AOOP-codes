package com.Banking;

public class Main {

	public static void main(String[] args) {
	
		UserLoginState loginState = UserLoginState.getInstance();
        BankingOperations bankingOps = new BankingOperations();
        bankingOps.viewBalance();
        bankingOps.deposit(100.0);
        bankingOps.withdraw(50.0);
        loginState.login();

        bankingOps.viewBalance();
        bankingOps.deposit(100.0);
        bankingOps.withdraw(50.0);

        loginState.logout();

        bankingOps.viewBalance();
        bankingOps.deposit(100.0);
        bankingOps.withdraw(50.0);

	}

}
