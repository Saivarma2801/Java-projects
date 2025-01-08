package ATM_Interface;

import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited Rs: " + amount);
     } 
     else 
         System.out.println("Deposit amount must be greater than zero.");
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Successfully withdraw Rs: " + amount);
     } 
     else if (amount > balance) 
         System.out.println("Insufficient balance...");

     else 
         System.out.println("Withdrawal amount must be greater than zero.");
     
 }

 public double getBalance() {
     return balance;
 }
 
}

class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void Menu() {
     System.out.println("\nATM Menu:");
     System.out.println("---------");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void Operations() {
     Scanner sc = new Scanner(System.in);
     boolean condition = true;

     while (condition) {
         Menu();
         System.out.print("\nChoose an option:");
         int option = sc.nextInt();

         switch (option) {
             case 1: 
                 System.out.print("Enter amount to withdraw Rs: ");
                 double withdrawAmount = sc.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;

             case 2:
                 System.out.print("Enter amount to deposit Rs: ");
                 double depositAmount = sc.nextDouble();
                 account.deposit(depositAmount);
                 break;

             case 3:
                 System.out.println("Your current balance is Rs: " + account.getBalance());
                 break;

             case 4:
            	 System.out.println("Thank you for using the ATM.");
            	 condition = false;
                 break;

             default:
                 System.out.println("Invalid option. Please try again.");
                 break;
         }
     }

     sc.close();
 }
}

public class ATM_Interface {
 public static void main(String[] args) {
     
     BankAccount userAccount = new BankAccount(5000.0);

     ATM atm = new ATM(userAccount);

     atm.Operations();
 }
}
