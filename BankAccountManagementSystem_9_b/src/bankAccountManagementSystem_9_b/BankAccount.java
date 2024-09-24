package bankAccountManagementSystem_9_b;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
        }
    }
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ". Insufficient funds.");
        }
    }
    public synchronized double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Thread user1 = new Thread(() -> {
            account.deposit(500);
            account.withdraw(200);
        }, "User1");

        Thread user2 = new Thread(() -> {
            account.deposit(300);
            account.withdraw(400);
        }, "User2");

        Thread user3 = new Thread(() -> {
            account.withdraw(700);
            account.deposit(100);
        }, "User3");
        user1.start();
        user2.start();
        user3.start();
    }
}

