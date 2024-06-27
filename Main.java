import java.util.Scanner;

class BankAccount
{
    private double balance;
    public BankAccount(double initialBalance)
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
            System.out.println("Successfully deposited " + amount + " Rupees");
        }
        else
        {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount + " Rupees");
            return true;
        }
        else if (amount > balance)
        {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
        else
        {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
    public void checkBalance()
    {
        System.out.println("Current balance: " + balance + " Rupees");
    }
}

class ATM 
{
    private BankAccount account;
    public ATM(BankAccount account)
    {
        this.account = account;
    }
    public void withdraw(double amount)
    {
        account.withdraw(amount);
    }
    public void deposit(double amount)
    {
        account.deposit(amount);
    }
    public void checkBalance()
    {
        account.checkBalance();
    }
    public void displayMenu()
    {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to DIBS Bank!");
        BankAccount account = new BankAccount(10000.0);
        ATM atm = new ATM(account);
        boolean exit = false;
        while (!exit)
        {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you for using the DIBS ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}