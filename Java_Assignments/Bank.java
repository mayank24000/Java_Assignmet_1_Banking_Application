import java.util.Scanner;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    // Display details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Update contact details
    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // -------------------------
    // Inner class for UI
    // -------------------------
    static class BankingApp {
        private Account[] accounts;
        private Scanner scanner;
        private int accountCount;

        public BankingApp(int size) {
            accounts = new Account[size];
            scanner = new Scanner(System.in);
            accountCount = 0;
        }

        // Create account
        public void createAccount() {
            System.out.print("Enter account holder name: ");
            String accountHolderName = scanner.nextLine();

            System.out.print("Enter initial deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.print("Enter email address: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            int accountNumber = 1000 + accountCount + 1; // auto-generate account number
            accounts[accountCount] = new Account(accountNumber, accountHolderName, amount, email, phoneNumber);
            accountCount++;

            System.out.println("Account created successfully with Account Number: " + accountNumber);
        }

        // Find account
        private Account findAccount(int accountNumber) {
            for (int i = 0; i < accountCount; i++) {
                if (accounts[i].getAccountNumber() == accountNumber) {
                    return accounts[i];
                }
            }
            return null;
        }

        // Deposit
        public void performDeposit() {
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            Account acc = findAccount(accountNumber);
            if (acc != null) {
                acc.deposit(amount);
            } else {
                System.out.println("Account not found.");
            }
        }

        // Withdraw
        public void performWithdrawal() {
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            Account acc = findAccount(accountNumber);
            if (acc != null) {
                acc.withdraw(amount);
            } else {
                System.out.println("Account not found.");
            }
        }

        // Show details
        public void showAccountDetails() {
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            Account acc = findAccount(accountNumber);
            if (acc != null) {
                acc.displayAccountDetails();
            } else {
                System.out.println("Account not found.");
            }
        }

        // Update contact
        public void updateContact() {
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            Account acc = findAccount(accountNumber);
            if (acc != null) {
                acc.updateContactDetails(email, phoneNumber);
            } else {
                System.out.println("Account not found.");
            }
        }

        // Menu
        public void mainMenu() {
            int choice;
            do {
                System.out.println("\n--- Welcome to the Banking Application ---");
                System.out.println("1. Create a new account");
                System.out.println("2. Deposit money");
                System.out.println("3. Withdraw money");
                System.out.println("4. View account details");
                System.out.println("5. Update contact details");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: createAccount(); break;
                    case 2: performDeposit(); break;
                    case 3: performWithdrawal(); break;
                    case 4: showAccountDetails(); break;
                    case 5: updateContact(); break;
                    case 6: System.out.println("Exiting... Thank you for using the Banking Application!"); break;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        }
    }

    // Main method now inside Account.java
    public static void main(String[] args) {
        BankingApp app = new BankingApp(100); // can store up to 100 accounts
        app.mainMenu();
    }
}
