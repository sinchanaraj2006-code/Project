import java.util.Scanner;

class Project{

    private static double balance = 10.00;  
    private static int secretPin = 1234;      

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (!pinValidator(input)) {
            System.out.println("Access Denied. Your account is locked.");
            return;
        }

        System.out.println("Access Granted. Welcome back!");

        int choice;
        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs ");
                    double depositAmount = input.nextDouble();
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs ");
                    double withdrawAmount = input.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        input.close();
    }

    public static boolean pinValidator(Scanner input) {
        System.out.println(" Welcome ,Please insert your card");
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = input.nextInt();

        return enteredPin == secretPin;
    }

    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: Rs " + amount);
            System.out.println("New Balance: Rs " + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: Rs " + amount);
            System.out.println("Remaining Balance: Rs " + balance);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    public static void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
}