package javaBank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bank = new BankService();

        System.out.println("Welcome to JavaBank!");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Sign Up (Create Account)");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your Name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("Choose a numeric User ID: ");
                int newId = scanner.nextInt();

                boolean success = bank.createAccount(name, newId);
                if (success) {
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Error: User ID already exists.");
                }

            } else if (choice == 2) {
                System.out.print("Enter your User ID: ");
                int userId = scanner.nextInt();

                if (bank.getBalance(userId) == -1) {
                    System.out.println("User not found!");
                } else {
                    System.out.println("Login Successful!");

                    while (true) {
                        System.out.println("\n--- USER MENU (ID: " + userId + ") ---");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. View Transaction History");
                        System.out.println("5. Logout");
                        System.out.print("Choose: ");

                        int userChoice = scanner.nextInt();

                        if (userChoice == 1) {
                            System.out.println("Current Balance: $" + bank.getBalance(userId));

                        } else if (userChoice == 2) {
                            System.out.print("Enter amount to deposit: ");
                            double amount = scanner.nextDouble();
                            bank.deposit(userId, amount);
                            System.out.println("Deposit successful.");

                        } else if (userChoice == 3) {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            boolean ok = bank.withdrawal(userId, amount);
                            if (ok) System.out.println("Withdrawal successful.");
                            else System.out.println("Insufficient funds.");

                        } else if (userChoice == 4) {
                            System.out.println("Transaction History:");
                            bank.printStatement(userId);

                        } else if (userChoice == 5) {
                            System.out.println("Logging out...");
                            break;
                        }
                    }
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}