/**
 * Copyright (c) [2023]
 * All rights reserved. 
 *
 * Authors : Pranav Sodani 
 *           Manas Maheshwari
 */

import java.util.Scanner;
import java.util.ArrayList;

class Account
{
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private String address;
    private long phoneNumber;
    private int age;
   
    //This is taking the details of User
    public void userDetails(int age)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter the Account Number : ");
        this.accountNumber=sc.nextInt();
        
        System.out.print("Enter the name of Account Holder : ");
        this.accountHolder=sc.nextLine();
        sc.nextLine();
        
        System.out.print("Enter the balance : ");
        this.balance=sc.nextDouble();
        
        System.out.print("Enter the Phone Number : ");
        this.phoneNumber=sc.nextLong();
        
        System.out.print("Enter your Residential Address : ");
        this.address=sc.nextLine();
        sc.nextLine();
        this.age=age;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    } 

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public double getBalance()
    {
        return balance;
    }

    public long getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public int getAge()
    {
        return age;
    } 

    //for showing details
    public void showDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Holder Name : "+accountHolder);
        System.out.println("Account Balance : "+balance);
        System.out.println("Phone Number : "+phoneNumber);
        System.out.println("Address : "+address);
        char check;
        System.out.println("Do you want to edit any details? (y/n)");
        check=sc.next().charAt(0);
        if(check=='y')
        {
            editDetails();
        }
        else
        {
            return;
        }
    }

    //for modifying details
    public void editDetails()
    {
        Scanner sc=new Scanner(System.in);
        int flag=0;

        while(flag==0)
        {
            System.out.println("Mention the index you want to edit : ");
            System.out.println("1. Account Number.");
            System.out.println("2. Account Holder Name.");
            System.out.println("3. Account Balance.");
            System.out.println("4. Phone Number.");
            System.out.println("5. Residential Address.");
            System.out.println("6. Exit Editing.");
        
            int index=sc.nextInt();

            switch(index)
            {
                case 1:
                    System.out.print("Enter new Account Number : ");
                    this.accountNumber = sc.nextInt();
                case 2:
                    System.out.print("Enter new Account Holder Name : ");
                    this.accountHolder = sc.nextLine();
                    sc.nextLine();
                case 3:
                    System.out.print("Sorry Balance cannot be edited.");
                case 4:
                    System.out.print("Enter new Phone Number : ");
                    this.phoneNumber = sc.nextLong();
                case 5:
                    System.out.print("Enter new Residential Address : ");
                    this.address = sc.nextLine();
                    sc.nextLine();
                case 6:
                    flag = 1;
                default:
                    System.out.println("Invalid Index.");
            }
        }    
    } 
}

class Bank
{
    private ArrayList<Account> accountList;
    
    public Bank()
    {
        accountList = new ArrayList<>();
    }

    public void addAccount(Account account)
    {
        accountList.add(account);
    }

    public Account findAccount(int accountNumber)
    {
        for(Account account : accountList)
        {
            if(account.getAccountNumber() == accountNumber)
            {
                return account;
            }
        }
        return null;
    }
    
}
public class BankManagement
{
    public static void main(String args[])
    {
        //Welcome Message
        System.out.println("Welcome to Bank Management System. We are here to assist you with your financial needs.");
        
        //Terms and Conditions
        System.out.println("Terms and Conditions : \n");
        System.out.println("1. Account Opening and Eligibility : ");
        System.out.println("Your age should be greater than 15\n");
        System.out.println("2. Interest Rates : ");
        System.out.println("->We will be charging 8% interest rate on Home loan.");
        System.out.println("->We will be charging 7% interest rate on Vehicle loan.");
        System.out.println("->We will be charging 6% interest rate on Education loan.");
        System.out.println("->We will be giving 4% interest rate on Fixed Deposit.");
        
        Scanner sc=new Scanner(System.in);

        //object creation
        Bank bank = new Bank();
        Account newAccount = new Account();

        int age;

        System.out.println("Enter your choice : ");
        System.out.println("1. Add new Account.");
        
        System.out.println("Enter your Age : ");
        age=sc.nextInt();
        if(age>=15)
        {
            newAccount.userDetails(age);
            bank.addAccount(newAccount);
        }
        else
        {
            System.out.println("You are a Minor. You cannot account cannot be created.");
        }
        

        
    }
}