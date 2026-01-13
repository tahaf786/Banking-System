import java.util.ArrayList;

public class TestingArrays {
    public static void main(String[] args) {
        // Step 1: Create the magic list
        ArrayList<Account> accounts = new ArrayList<>();

        // Step 2: Create some accounts
        SavingsAccount savings1 = new SavingsAccount("SAV001", 1000.0, 0.05);
        CheckingAccount checking1 = new CheckingAccount("CHK001", 500.0, 100.0);
        SavingsAccount savings2 = new SavingsAccount("SAV002", 2000.0, 0.05);

        // Step 3: Add accounts to the list
        accounts.add(savings1);
        accounts.add(checking1);
        accounts.add(savings2);

        // Step 4: Check how many accounts we have
        System.out.println("Total accounts: " + accounts.size());

        // Step 5: Get a specific account
        Account firstAccount = accounts.get(0);
        System.out.println("First account: " + firstAccount.getAccountNumber());

        // Step 6: Get balance of second account
        System.out.println("Second account balance: $" + accounts.get(1).getBalance());
    }
}