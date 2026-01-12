import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount savings = new SavingsAccount("SAV001", 1000.0, 0.05);
        System.out.println("Account Created: " + savings.getAccountNumber());
        System.out.println("Balance: $" + savings.getBalance());

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
                    savings.deposit(amount);
                    System.out.println("New balance: $" + savings.getBalance());
                }

                if (choice == 2) {
                    System.out.print("Withdraw amount: $");
                    double amount = scanner.nextDouble();
                    savings.withdraw(amount);
                    System.out.println("New balance: $" + savings.getBalance());
                }

                if (choice == 3) {
                    savings.addInterest();
                    System.out.println("New balance: $" + savings.getBalance());
                }

                if (choice == 4) {
                    System.out.println("Current balance: $" + savings.getBalance());
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
