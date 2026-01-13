


public class Testing {
    public static void main(String[] args) {
        CheckingAccount checking = new CheckingAccount("CHK001", 100.0, 50.0);

        System.out.println("=== TEST 1: Normal Withdrawal ===");
        try {
            checking.withdraw(50);
            System.out.println("Balance: $" + checking.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== TEST 2: Using Overdraft ===");
        try {
            checking.withdraw(80);  // Should trigger warning
            System.out.println("Balance: $" + checking.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== TEST 3: Exceeding Overdraft ===");
        try {
            checking.withdraw(100);  // Should fail
            System.out.println("Balance: $" + checking.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
