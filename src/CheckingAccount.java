public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Withdrawal amount must be positive");
        }

        if (amount > balance + overdraftLimit) {
            throw new Exception("Exceeds overdraft Limit!!");
        }

        if (amount > balance) {
            System.out.println("Warning: using overdraft!!");
        }

        balance -= amount;
        System.out.println("Withdrew: $" + amount);

    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getAvailableBalance() {
        return balance + overdraftLimit;
    }
}