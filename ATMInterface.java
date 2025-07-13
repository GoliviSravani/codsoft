package javatasks.com;
import java.util.Scanner;
public class ATMInterface {
	// Step 1: Define an interface for ATM operations
	interface BankOperations {
	    void withdraw(double amount);
	    void deposit(double amount);
	    void checkBalance();
	}

	// Step 2: Create the BankAccount class
	class BankAccount {
	    private double balance;

	    public BankAccount(double initialBalance) {
	        this.balance = Math.max(initialBalance, 0); // Ensure non-negative balance
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public boolean withdrawAmount(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	    public boolean depositAmount(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            return true;
	        }
	        return false;
	    }
	}

	// Step 3: ATM class that implements BankOperations
	class ATM implements BankOperations {
	    private BankAccount account;

	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (account.withdrawAmount(amount)) {
	            System.out.println("Withdrawal successful. Remaining balance: ₹" + account.getBalance());
	        } else {
	            System.out.println("Withdrawal failed. Either insufficient balance or invalid amount.");
	        }
	    }

	    @Override
	    public void deposit(double amount) {
	        if (account.depositAmount(amount)) {
	            System.out.println("Deposit successful. Current balance: ₹" + account.getBalance());
	        } else {
	            System.out.println("Deposit failed. Amount must be greater than 0.");
	        }
	    }

	    @Override
	    public void checkBalance() {
	        System.out.println("Current balance: ₹" + account.getBalance());
	    }
	}

	// Step 4: Main application class
	public class ATMInterfaceApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create account with default initial balance
	        BankAccount userAccount = new BankAccount(10000);
	        ATM atm = new ATM(userAccount);

	        int choice;

	        do {
	            System.out.println("\n======= ATM MENU =======");
	            System.out.println("1. Withdraw");
	            System.out.println("2. Deposit");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            while (!scanner.hasNextInt()) {
	                System.out.print("Please enter a valid option (1-4): ");
	                scanner.next();
	            }

	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter amount to withdraw: ₹");
	                    double withdrawAmount = scanner.nextDouble();
	                    atm.withdraw(withdrawAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to deposit: ₹");
	                    double depositAmount = scanner.nextDouble();
	                    atm.deposit(depositAmount);
	                    break;
	                case 3:
	                    atm.checkBalance();
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }

	        } while (choice != 4);

	        scanner.close();
	    }
	}
}


