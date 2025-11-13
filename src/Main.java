import java.util.Scanner;

public class Main{
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BANKING SYSTEM ===");
        while (true) {
            System.out.println("1. Deposit: ");
            //double depositAmmount = scanner.nextDouble();
            System.out.println("2. withdraw: ");
            //double withdrawAmmount = scanner.nextDouble();
            System.out.println("3. Add Interest: ");
            //double addInterest = scanner.nextDouble();
            System.out.println("4. Check Balance: ");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 5){
                System.out.println("Goodbye");
                break;
            }
            System.out.println("You chose: " + choice);
        }


    }
}
