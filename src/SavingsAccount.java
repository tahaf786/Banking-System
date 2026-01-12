public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate){
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }
}