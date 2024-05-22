import java.util.*;

class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to ATM!");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void performTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0 && account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient funds or invalid amount.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 3:
                System.out.println("Your current balance: " + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using ATM!");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            performTransaction(choice);
        } while (choice != 4);

        scanner.close();
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class ATMMain {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.run();
    }
}
