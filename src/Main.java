import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();

        SavingsAccount savings1 = new SavingsAccount("SAV001", 1000, 0.05);
        CheckingAccount checkings1 = new CheckingAccount("CH001", 500, 100);
        SavingsAccount savings2 = new SavingsAccount("SAV002", 2500, 0.05);

        accounts.add(savings1);
        accounts.add(checkings1);
        accounts.add(savings2);
        System.out.println("Accounts Loaded: " + accounts.size());
        displayAccounts(accounts);

        System.out.println("=== SELECT AN ACCOUNT TO USE ===");
        System.out.println("Select account number (1-" + accounts.size() + "): ");
        int accountChoice = scanner.nextInt();

        Account currentAccount = accounts.get(accountChoice - 1);
        System.out.println("Selected: " + currentAccount.getAccountNumber());

        // SavingsAccount savings = new SavingsAccount("SAV001", 1000.0, 0.05);
        // System.out.println("Account Created: " + savings.getAccountNumber());
        // System.out.println("Balance: $" + savings.getBalance());

        System.out.println("\n=== BANKING SYSTEM ===");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                if (choice == 1) {
                    System.out.print("Deposit amount: $");
                    double amount = scanner.nextDouble();
                    currentAccount.deposit(amount);
                    System.out.println("New balance: $" + currentAccount.getBalance());
                }

                if (choice == 2) {
                    System.out.print("Withdraw amount: $");
                    double amount = scanner.nextDouble();
                    currentAccount.withdraw(amount);
                    System.out.println("New balance: $" + currentAccount.getBalance());
                }

                if (choice == 3) {
                    savings1.addInterest();
                    System.out.println("New balance: $" + currentAccount.getBalance());
                }

                if (choice == 4) {
                    System.out.println("Current balance: $" + currentAccount.getBalance());
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayAccounts(ArrayList<Account> accounts) {
        System.out.println("\n=== YOUR ACCOUNTS ===");

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);

            String type;
            if (account instanceof SavingsAccount) {
                type = "Savings";
            } else if (account instanceof CheckingAccount) {
                type = " Checking";
            } else {
                type = "Account";
            }

            System.out.println((i + 1) + ". " + account.getAccountNumber() + " - " + type + " - $ " + account.getBalance());
        }
        System.out.println();
    }
}
