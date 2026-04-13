class BankAccount {
    private double balance;
    private String password;

    public BankAccount(double balance, String password) {
        this.balance = balance;
        this.password = password;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount, String pwd) {
        if (!password.equals(pwd)) {
            System.out.println("Wrong password!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

    public double getBalance(String pwd) {
        if (pwd == password) {
            return balance;
        }
        throw new IllegalArgumentException("Wrong password!");
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000, "1234");
        acc.deposit(500);
        acc.withdraw(300, "1234");
        acc.withdraw(200, "9999");
        acc.withdraw(2000, "1234");
        System.out.println("Balance: $" + acc.getBalance("1234"));
        System.out.println("Balance: $" + acc.getBalance("0000"));
    }
}
