import java.util.ArrayList; 
import java.util.Scanner;  

public class BankSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

   
    public void createAccount() {
        System.out.println("Enter the account holder's name: ");
        String name = scanner.nextLine();
        BankAccount newAccount = new BankAccount(name);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Account Number: " + newAccount.getAccountNumber());
    }

    
    private BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; 
    }

  
    public void deposit() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

   
    public void withdraw() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    
    public void transfer() {
        System.out.println("Enter your account number: ");
        int sourceAccountNumber = scanner.nextInt();
        BankAccount sourceAccount = findAccount(sourceAccountNumber);
        
        if (sourceAccount != null) {
            System.out.println("Enter target account number: ");
            int targetAccountNumber = scanner.nextInt();
            BankAccount targetAccount = findAccount(targetAccountNumber);

            if (targetAccount != null) {
                System.out.println("Enter the amount to transfer: ");
                double amount = scanner.nextDouble();
                sourceAccount.transfer(targetAccount, amount);
            } else {
                System.out.println("Target account not found.");
            }
        } else {
            System.out.println("Your account not found.");
        }
    }

   
    public void displayAccount() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

  
    public void mainMenu() {
        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    displayAccount();
                    break;
                case 6:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankSystem system = new BankSystem();
        system.mainMenu();
    }
}
