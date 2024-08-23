package com.Banking;

public class UserLoginState {
	private static UserLoginState instance;

    
    private boolean isLoggedIn;

    private UserLoginState() {
        isLoggedIn = false; 
    }
    public static UserLoginState getInstance() {
        if (instance == null) {
            instance = new UserLoginState();
        }
        return instance;
    }
    public void login() {
        if (!isLoggedIn) {
            isLoggedIn = true;
            System.out.println("User successfully logged in.");
        } else {
            System.out.println("User is already logged in.");
        }
    }

    public void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("User successfully logged out.");
        } else {
            System.out.println("User is already logged out.");
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
