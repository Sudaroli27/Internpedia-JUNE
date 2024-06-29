import java.util.Scanner;
class UserAccount 
{
    private double balance;
    public UserAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } 
        else if (amount > balance) 
        {
            System.out.println("Insufficient funds.");
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
public class ATM 
{
    private UserAccount account;
    private Scanner scanner;
    public ATM(UserAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance ");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw ");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(1000); 
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
