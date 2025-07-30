package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter account data: ");
            System.out.println("Number: ");
            Integer number = sc.nextInt();
            sc.nextLine();
            System.out.println("Holder: ");
            String holder = sc.nextLine();
            System.out.println("Initial Balance: ");
            double balance = sc.nextDouble();
            System.out.println("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());

        } catch(DomainException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error: ");
        }

    }
}