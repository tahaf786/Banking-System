import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();

        SavingsAccount savings1 = new SavingsAccount("SAV001", 1000, 0.05);
        CheckingAccount checkings1 = new CheckingAccount("CHK001", 500, 100);
        SavingsAccount savings2 = new SavingsAccount("SAV002", 2500, 0.05);

        accounts.add(savings1);
        accounts.add(checkings1);
        accounts.add(savings2);

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO PROFESSIONAL BANKING SYSTEM       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Accounts Loaded: " + accounts.size());

        mainMenu(accounts, scanner);

        scanner.close();
        System.out.println("\n👋 Goodbye! Have a great day!");
    }

        //displayAccounts(accounts);



        // SavingsAccount savings = new SavingsAccount("SAV001", 1000.0, 0.05);
        // System.out.println("Account Created: " + savings.getAccountNumber());
        // System.out.println("Balance: $" + savings.getBalance());
//        System.out.println("=== SELECT AN ACCOUNT TO USE ===");
//        Account currentAccount = selectAccount(accounts, scanner);
//
//        if (currentAccount == null) {
//            System.out.println("No account selected. Exiting.");
//            scanner.close();
//            return;
//        }
//        System.out.println("Selected: " + currentAccount.getAccountNumber());
//
//       System.out.println("\n=== BANKING SYSTEM ===");
//
//        while (true) {
//        System.out.println("\n--- MENU ---");
//        System.out.println("1. Deposit");
//        System.out.println("2. Withdraw");
//        System.out.println("3. Add Interest");
//        System.out.println("4. Check Balance");
//        System.out.println("5. Exit");
//        System.out.print("Choose option: ");
//
//        int choice = scanner.nextInt();
//
//        if (choice == 5) {
//            System.out.println("Goodbye!");
//            break;
//        }
//
//        try {
//            if (choice == 1) {
//                System.out.print("Deposit amount: $");
//                double amount = scanner.nextDouble();
//                currentAccount.deposit(amount);
//                System.out.println("New balance: $" + currentAccount.getBalance());
//            }
//
//            if (choice == 2) {
//                System.out.print("Withdraw amount: $");
//                double amount = scanner.nextDouble();
//                currentAccount.withdraw(amount);
//                System.out.println("New balance: $" + currentAccount.getBalance());
//            }
//
//            if (choice == 3) {
//                if (currentAccount instanceof SavingsAccount) {
//                    SavingsAccount savingsAccount = (SavingsAccount) currentAccount;
//                    savingsAccount.addInterest();
//                } else {
//                    System.out.println("Only savings accounts earn interest!");
//                }
//
//            }
//
//            if (choice == 4) {
//                System.out.println("Current balance: $" + currentAccount.getBalance());
//            }
//
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//            scanner.nextLine();
//        }
//    }
//
//        scanner.close();
//}


    private static void displayAccounts(ArrayList<Account> accounts) {

        if (accounts.size() == 0) {
            System.out.println("\n No accounts found!");
            return;
        }
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    YOUR ACCOUNTS                                       ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);

            String type;
            String extra = "";

            if (account instanceof SavingsAccount) {
                type = "Savings ";
                SavingsAccount sa = (SavingsAccount) account;
                // If you add getInterestRate() method, show it here
            } else if (account instanceof CheckingAccount) {
                type = "Checking";
                CheckingAccount ca = (CheckingAccount) account;
                extra = " | Overdraft: $" + ca.getOverdraftLimit();
            } else {
                type = "Account ";
            }

            System.out.printf("║ %d. %-10s - %-8s - Balance: $%-10.2f%s%n",
                    (i + 1),
                    account.getAccountNumber(),
                    type,
                    account.getBalance(),
                    extra);
        }

        System.out.println("╠════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Total Accounts: " + accounts.size() + "                                                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
    }

    private static Account selectAccount(ArrayList<Account> accounts, Scanner scanner) {
        if (accounts.size() == 0) {
            System.out.println("No accounts available");
            return null;
        }
        displayAccounts(accounts);

        System.out.println("Select account number (1- " + accounts.size() + "): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > accounts.size()) {
            System.out.println("Invalid choice");
            return null;
        }
        Account selected = accounts.get(choice - 1);
        System.out.println("Selected: " + selected.getAccountNumber());
        return selected;
    }
    private static void mainMenu(ArrayList<Account> accounts, Scanner scanner) {
        while (true) {
            clearScreen();
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║     MAIN MENU                  ║");
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║ 1. View All Accounts           ║");
            System.out.println("║ 2. Select Account              ║");
            System.out.println("║ 3. Create New Account          ║");
            System.out.println("║ 4. Delete Account              ║");
            System.out.println("║ 5. Exit                        ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) {
                System.out.println("Thank you for using our banking system!");
                break;
            }

            switch (choice) {
                case 1:
                    displayAccounts(accounts);
                    break;

                case 2:
                    Account selected = selectAccount(accounts, scanner);
                    if (selected != null) {
                        accountMenu(selected, accounts, scanner);
                    }
                    break;

                case 3:

                    createNewAccount(accounts, scanner);
                    break;

                case 4:

                    deleteAccount(accounts, scanner);
                    break;

                default:
                    System.out.println("Invalid option! Please choose 1-5.");
            }
        }
    }
    private static void accountMenu(Account currentAccount, ArrayList<Account> accounts, Scanner scanner) {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║  ACCOUNT MENU - " + currentAccount.getAccountNumber() + "                          ║");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║ Current Balance: $" + String.format("%.2f", currentAccount.getBalance()) + "                       ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Deposit                                     ║");
            System.out.println("║ 2. Withdraw                                    ║");
            System.out.println("║ 3. Add Interest (Savings only)                 ║");
            System.out.println("║ 4. Check Balance                               ║");
            System.out.println("║ 5. Switch Account                              ║");
            System.out.println("║ 6. Back to Main Menu                           ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 6) {
                System.out.println("Returning to main menu...");
                break; // Exit this menu, return to main menu
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        currentAccount.deposit(depositAmount);
                        System.out.println("✓ New balance: $" + currentAccount.getBalance());
                        break;

                    case 2:
                        System.out.print("Withdraw amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        currentAccount.withdraw(withdrawAmount);
                        System.out.println("✓ New balance: $" + currentAccount.getBalance());
                        break;

                    case 3:
                        if (currentAccount instanceof SavingsAccount) {
                            SavingsAccount savingsAccount = (SavingsAccount) currentAccount;
                            savingsAccount.addInterest();
                            System.out.println("✓ New balance: $" + currentAccount.getBalance());
                        } else {
                            System.out.println("⚠ Only savings accounts earn interest!");
                        }
                        break;

                    case 4:
                        System.out.println("Current balance: $" + currentAccount.getBalance());
                        break;

                    case 5:
                        System.out.println("\n=== SWITCH ACCOUNT ===");
                        Account newAccount = selectAccount(accounts,scanner);
                        if (newAccount != null) {
                            System.out.println("Switching from " + currentAccount.getAccountNumber() + " to " +
                                    newAccount.getAccountNumber());
                            currentAccount = newAccount;
                            System.out.println(" Account switched! ");
                        }else {
                            System.out.println("Switch cancelled");
                        }
                        break;

                    default:
                        System.out.println("Invalid option! Please choose 1-6.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                scanner.nextLine(); // Clear bad input
            }
        }
    }
    private static void createNewAccount(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║     CREATE NEW ACCOUNT         ║");
        System.out.println("╚════════════════════════════════╝");

        System.out.println("Select account type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.println("choice");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter account number(eg., SAV003 for savings account, CHK004 for checking account): ");
        String accountNumber = scanner.nextLine().trim();

        if(accountNumber.isEmpty()) {
            System.out.println("Account Number Cannot be empty!!");
            return;
        }
        if (isAccountNumberTaken(accounts, accountNumber)) {
            System.out.println("Account Number " + accountNumber + " Already exists");
            System.out.println("Please choose a different account Number");
            return;
        }

        System.out.println("Enter Initial Balance: $");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        if(typeChoice == 1) {
            System.out.println("Enter interest rate (eg: 0.05 for 5%): ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine();

            SavingsAccount newAccount = new SavingsAccount(accountNumber, initialBalance, interestRate);
            accounts.add(newAccount);
            System.out.println("Savings Account " + accountNumber + "Created Succesfully!");
            pressEnterToContinue(scanner);
        } else if(typeChoice == 2) {
            System.out.println("Enter overdraft Limit: ");
            double overdraftLimit = scanner.nextDouble();
            scanner.nextLine();

            CheckingAccount newAccount = new CheckingAccount(accountNumber, initialBalance, overdraftLimit);
            accounts.add(newAccount);
            System.out.println("Checking Account " + accountNumber + "Created Succesfully");
        }else {
            System.out.println("Invalid account Type");
        }
        System.out.println("Total accounts: " + accounts.size());
    }

    private static void deleteAccount(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║       DELETE ACCOUNT           ║");
        System.out.println("╚════════════════════════════════╝");

        if (accounts.size() == 0){
            System.out.println("No accounts to delete");
            return ;
        }
        displayAccounts(accounts);

        System.out.println("Enter Account number to delete (1- " + accounts.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if( choice < 1 || choice > accounts.size() ) {
            System.out.println("Invalid Choice");
            return ;
        }
        Account accountToDelete = accounts.get(choice -1);

        System.out.println("Are you sure you want to delete " + accountToDelete.getAccountNumber() + "? yes/no: ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if(confirmation.equals("yes")) {
            accounts.remove(choice -1);
            System.out.println(" Account " + accountToDelete.getAccountNumber() + "deleted sucessfully");
            pressEnterToContinue(scanner);
            System.out.println("Remaining Accounts: " + accounts.size());
        }else {
            System.out.println("Deletion cancelled !!");
        }
    }
    private static boolean isAccountNumberTaken(ArrayList<Account> accounts, String accountNumber) {
        for (Account account : accounts) {
            if(account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    private static void pressEnterToContinue(Scanner scanner) {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

