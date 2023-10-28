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
    public Account(int age)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter the Account Number : ");
        this.accountNumber=sc.nextInt();
        
        System.out.print("Enter the first name of Account Holder : ");
        this.accountHolder=sc.next();
        
        System.out.print("Enter the balance : ");
        this.balance=sc.nextDouble();
        
        System.out.print("Enter the Phone Number : ");
        this.phoneNumber=sc.nextLong();
        
        System.out.print("Enter your Residential Address : ");
        this.address=sc.next();
        
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
    
    public void editAccountNumber(int newaccountNumber)
    {
         accountNumber = newaccountNumber;
    } 

    public void editAccountHolder(String newaccountHolder)
    {
        accountHolder = newaccountHolder;
    }

    public void editPhoneNumber(long newphoneNumber)
    {
        phoneNumber = newphoneNumber;
    }

    public void editAddress(String newaddress)
    {
        address = newaddress;
    }

    public void editBalance(double newBalance)
    {
        balance = newBalance;
    }

    public int getAge()
    {
        return age;
    } 

}

class Bank 
{
    private ArrayList<Account> accounts;

    public Bank() 
    {
        accounts = new ArrayList<>();
    }

    //adding account to arraylist
    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    //for finding account
    public Account findAccount(int accountNumberFind) 
    {
        for (Account account : accounts) 
        {
            if (account.getAccountNumber() == accountNumberFind) 
            {
                int count=0;
                while(count==0)
                {
                    System.out.println("Account Number found.\n");
                    count++;
                }
            }
            else
            {
                continue;
            }
        }
        return null;
    }

    //for showing details
    public void showDetails(int accountNumberShow)
    {
        for(Account account : accounts)
        {
            if(account.getAccountNumber() == accountNumberShow)
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Account Number : "+account.getAccountNumber());
                System.out.println("Account Holder Name : "+account.getAccountHolder());
                System.out.println("Account Balance : Rs. "+account.getBalance());
                System.out.println("Phone Number : "+account.getPhoneNumber());
                System.out.println("Address : "+account.getAddress());
            }
            else
            {
                System.out.println("Account Number not found.\n");
            }

        }
    }

    //for modifying details
    public void editDetails(int accountNumberEdit)
    {
        Scanner sc=new Scanner(System.in);

        for(Account account : accounts)
        {
            if(account.getAccountNumber() == accountNumberEdit)
            {
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
                            System.out.println("Account Number cannot be changed.\n");
                            break;

                        case 2:
                            System.out.print("Enter new Account Holder Name : ");
                            String newaccountHolder = sc.next();
                            account.editAccountHolder(newaccountHolder);
                            break;

                        case 3:
                            System.out.println("Sorry Balance cannot be edited.\n");
                            break;

                        case 4:
                            System.out.print("Enter new Phone Number : ");
                            long newphoneNumber = sc.nextLong();
                            account.editPhoneNumber(newphoneNumber);
                            break;

                        case 5:
                            System.out.print("Enter new Residential Address : ");
                            String newaddress = sc.next();
                            account.editAddress(newaddress);
                            break;

                        case 6:
                            flag++;
                            break;

                        default:
                            System.out.println("Invalid Index.");
                    }
                } 
            }
            else
            {
                System.out.println("Account Number not found. \n");
            }
        }

    } 

    //for transfereing amount
    public void transferAmount(int accountNumber1, int accountNumber2, double amount)
    {
        for(Account account : accounts)
        {
            if(amount >= 0.0)
            {
                if(account.getAccountNumber() == accountNumber1)
                {
                    if(account.getBalance() >= amount)
                    {
                        double balance1 = account.getBalance();
                        balance1 -= amount;
                        account.editBalance(balance1);
                    }
                    else
                    {
                        System.out.println("\nInsufficient Balance.\n");
                    }
                }
                if(account.getAccountNumber() == accountNumber2)
                {
                    if(account.getBalance() >= amount)
                    {
                        double balance2 = account.getBalance();
                        balance2 += amount;
                        account.editBalance(balance2);
                        System.out.println("\nTransaction Successful.\n");
                    }
                }
            }
            else
            {
                System.out.println("\n Invalid Amount. \n");
            }
        }
    }

    //for deleting an account
    public void deleteAccount(int accountNumberDelete)
    {
        for(Account account : accounts)
        {
            if(account.getAccountNumber() == accountNumberDelete)
            {
                accounts.remove(account);
            }
            else
            {
                System.out.println("Account Number not found.\n");
                return;
            }
        }
    }

    //for depositing amount
    public void depositToAccount(int accountNumberDeposit, double amountDeposit)
    {
        if(amountDeposit >= 0.0)
        {
            for(Account account : accounts)
            {
                if(account.getAccountNumber() == accountNumberDeposit)
                {
                    double balanceDeposit = account.getBalance();
                    balanceDeposit += amountDeposit;
                    account.editBalance(balanceDeposit);
                    System.out.println("New Balance is : Rs. " + account.getBalance());
                    break;
                }
            }
        }
        else
        {
            System.out.println("Invalid Amount.\n");
        }
    }
    
    //for withdrawing amount
    public void withdrawFromAccount(int accountNumberWithdraw, double amountWithdraw)
    {
        if(amountWithdraw >= 0.0)
        {
            for(Account account : accounts)
            {
                if(account.getBalance() >= amountWithdraw)
                {
                    if(account.getAccountNumber() == accountNumberWithdraw)
                    {
                        double balanceWithdraw = account.getBalance();
                        balanceWithdraw -= amountWithdraw;
                        account.editBalance(balanceWithdraw);
                        System.out.println("New Balance is : Rs. " + account.getBalance());
                        break;
                    }
                }
                else
                {
                    System.out.println("Insufficient Balance.\n");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Invalid Amount.\n");
        }
    }

    //for loan
    public void loan()
    {
        Scanner sc = new Scanner(System.in);

        int flag = 0;
        
        while(flag==0)
        {
            System.out.println("\nChoose from below index about the type of loan : ");
            System.out.println("1. Education Loan");
            System.out.println("2. Home Loan");
            System.out.println("3. Vehicle Loan");
            System.out.println("4. Exit Loan Section");
            
            int index = sc.nextInt();

            switch(index)
            {
                //education loan interest rate = 6%.
                case 1:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberLoan1 = sc.nextInt();
                    System.out.println("Enter the name of the candidate : ");
                    String candidateName1 = sc.next();
                    System.out.println("Enter the amount of loan : ");
                    double amountLoan1 = sc.nextDouble();
                    System.out.println("Enter the tenure of loans in year : ");
                    int loanTime1 = sc.nextInt();
                    for(Account account : accounts)
                    {
                        if(account.getAccountNumber() == accountNumberLoan1)
                        {
                            double balanceLoan1 = account.getBalance();
                            balanceLoan1 += amountLoan1;
                            account.editBalance(balanceLoan1);
                            System.out.println("Loan ammount has been credited.");  
                            System.out.println("New Balance is : Rs."+account.getBalance());
                        }
                    }
                    System.out.println("Interest Rate = 6%.");
                    double amountPerMonth1 = (amountLoan1/(loanTime1*12)) + 0.06*(amountLoan1/(loanTime1*12));
                    System.out.println("You have to pay : Rs." + amountPerMonth1 + " every month.");
                    flag++;
                    break;

                //home loan interest rate = 7%.
                case 2:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberLoan2 = sc.nextInt();
                    System.out.println("Enter the name of the eligible person : ");
                    String candidateName2 = sc.next();
                    System.out.println("Enter the amount of loan : ");
                    double amountLoan2 = sc.nextDouble();
                    System.out.println("Enter the tenure of loans in year : ");
                    int loanTime2 = sc.nextInt();
                    for(Account account : accounts)
                    {
                        if(account.getAccountNumber() == accountNumberLoan2)
                        {
                            double balanceLoan2 = account.getBalance();
                            balanceLoan2 += amountLoan2;
                            account.editBalance(balanceLoan2);
                            System.out.println("Loan ammount has been credited.");  
                            System.out.println("New Balance is : Rs."+account.getBalance());
                        }
                    }
                    System.out.println("Interest Rate = 7%.");
                    double amountPerMonth2 = (amountLoan2/(loanTime2*12)) + 0.07*(amountLoan2/(loanTime2*12));
                    System.out.println("You have to pay : Rs." + amountPerMonth2 + " every month.");
                    flag++;
                    break;

                //Vehicle loan interest rate = 5%.
                case 3:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberLoan3 = sc.nextInt();
                    System.out.println("Enter the name of the candidate : ");
                    String candidateName3 = sc.next();
                    System.out.println("Enter the amount of loan : ");
                    double amountLoan3 = sc.nextDouble();
                    System.out.println("Enter the tenure of loans in year : ");
                    int loanTime3 = sc.nextInt();
                    for(Account account : accounts)
                    {
                        if(account.getAccountNumber() == accountNumberLoan3)
                        {
                            double balanceLoan3 = account.getBalance();
                            balanceLoan3 += amountLoan3;
                            account.editBalance(balanceLoan3);
                            System.out.println("Loan ammount has been credited.");  
                            System.out.println("New Balance is : Rs."+account.getBalance());
                        }
                    }
                    System.out.println("Interest Rate = 5%.");
                    double amountPerMonth3 = (amountLoan3/(loanTime3*12)) + 0.05*(amountLoan3/(loanTime3*12));
                    System.out.println("You have to pay : Rs." + amountPerMonth3 + " every month.");
                    flag++;
                    break;

                    case 4:
                        flag++;
                        break;

                    default:
                        System.out.println("Enter correct Index.\n");
            }
        }

    }

    //for fixed deposit
    public void fixedDeposit()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Account Number : ");
        int accountNumberFixedDeposit = sc.nextInt();
        System.out.println("Enter the amount to be deposited : ");
        double amountFixedDeposit = sc.nextDouble();
        System.out.println("Enter time for fixed deposit in years : ");
        int fixedDepositTime = sc.nextInt();

        for(Account account : accounts)
        {
            if(account.getAccountNumber() == accountNumberFixedDeposit)
            {
                double balanceFixedDeposit = account.getBalance();
                balanceFixedDeposit -= amountFixedDeposit;
                account.editBalance(balanceFixedDeposit);
                System.out.println("Fixed Deposit has been debited from your Account.");  
                System.out.println("New Balance is : Rs."+account.getBalance());
            }
        }
        double amountMature = (amountFixedDeposit*fixedDepositTime*4)/100;
        System.out.println("You will be credited : Rs."+ (amountMature + amountFixedDeposit) +" after completion of tenure.\n");
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
        System.out.println("->We will be giving 4% interest rate on Fixed Deposit.\n");
        
        Scanner sc = new Scanner(System.in);

        //object creation
        Bank bank = new Bank();

        int age;

        int check=0;
        while(check==0)
        {
            System.out.println("\nEnter your choice : ");
            System.out.println("1. Add new Account.");
            System.out.println("2. Show Account Details.");
            System.out.println("3. Edit Account Details.");
            System.out.println("4. Transfer Amount to another Account.");
            System.out.println("5. Finding Account.");
            System.out.println("6. Deleting Account.");
            System.out.println("7. Deposit Amount.");
            System.out.println("8. Withdraw Amount.");
            System.out.println("9. Apply for Loan.");
            System.out.println("10. Fixed Deposit.");
            System.out.println("11. Exit.");
            int index=sc.nextInt();
            
            switch(index)
            {
                case 1:
                    System.out.print("\nEnter your Age : ");
                    age=sc.nextInt();
                    if(age>=15)
                    {
                        Account newAccount = new Account(age);
                        bank.addAccount(newAccount);
                    }
                    else
                    {
                        System.out.println("You are a Minor. Your account cannot be created.\n");
                    }
                    break;

                case 2:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberShow = sc.nextInt();
                    bank.showDetails(accountNumberShow);
                    break;

                case 3:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberEdit = sc.nextInt();
                    bank.editDetails(accountNumberEdit);
                    break;
                    
                case 4:
                    System.out.println("Enter your Account Number : ");
                    int accountNumber1 = sc.nextInt();
                    System.out.println("Enter reciever's Account Number : ");
                    int accountNumber2 = sc.nextInt();
                    System.out.println("Enter amount to be transfered : ");
                    double amount = sc.nextDouble();
                    bank.transferAmount(accountNumber1, accountNumber2, amount);
                    break;

                case 5: 
                    System.out.println("Enter your Account Number : ");
                    int accountNumberFind = sc.nextInt();
                    bank.findAccount(accountNumberFind);
                    break;

                case 6:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberDelete = sc.nextInt();
                    bank.deleteAccount(accountNumberDelete);
                    break;

                case 7:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberDeposit = sc.nextInt();
                    System.out.println("Enter Amount : ");
                    double amountDeposit = sc.nextDouble();
                    bank.depositToAccount(accountNumberDeposit,amountDeposit);
                    break;
                
                case 8:
                    System.out.println("Enter your Account Number : ");
                    int accountNumberWithdraw = sc.nextInt();
                    System.out.println("Enter Amount : ");
                    double amountWithdraw = sc.nextDouble();
                    bank.withdrawFromAccount(accountNumberWithdraw,amountWithdraw);
                    break;

                case 9:
                    bank.loan();
                    break;

                case 10:
                    bank.fixedDeposit();
                    break;
                
                case 11:
                    System.out.println("Thank you for choosing us.");
                    System.out.println("Do Visit us again :) ");
                    check++;
                    break;
                
                default:
                    System.out.println("Invalid Index.");
            }
        } 
    }
}   