package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BankAccountImplementation implements BankAccountInterface{

    ArrayList <BankAccount> bankAccount;

    public BankAccountImplementation(){
        bankAccount = new ArrayList<>();
        BankAccount account1 = new BankAccount( "Joe lame", 500.0, "510-989-7564",
                "Joe@lame.com");
        BankAccount account2 = new BankAccount( "Rupy chichi", 1200.0,
                "514-234-3434", "chichi@gmail.com");

        bankAccount.add(account1);
        bankAccount.add(account2);
    }

    @Override
    public void getAllAccount() {
        //return bankAccount;
        for ( BankAccount accounts : bankAccount)
        {
            System.out.println(accounts.getAccountNumber() + " " +
                    accounts.getName()+ " " + accounts.getBalance()+ " " +
                    accounts.getPhoneNumber()+ " " +accounts.getEmail());
        }

    }

    @Override
    public void showBalance() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter your account number to see the balance");
        int accountNo = in.nextInt();
        for ( BankAccount account : bankAccount){
            if (account.getAccountNumber() == accountNo)
            {
                System.out.println(account.getBalance());

            }

            else {
                System.out.println("Error");
            }
        }
    }

    @Override
    public void deposit() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter your account number to deposit amount");
        int accountNo = in.nextInt();
        for ( BankAccount account : bankAccount){
            if (account.getAccountNumber() == accountNo)
            {
                System.out.println("please enter the amount you want to deposit");
                Scanner depo = new Scanner(System.in);
                double amt = depo.nextDouble();
                if ( amt > 5.0 && amt < 10000.0)
                {
                    account.setBalance(amt);

                }
                else {
                    System.out.println("Error, deposits must be more than $5 and less than $10000");
                }

            }

            else {
                System.out.println("Error, please check your account number ");
            }
        }
    }

    @Override
    public void withdraw() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter your account number to withdraw amount");
        int accountNo = in.nextInt();
        for ( BankAccount account : bankAccount){
            if (account.getAccountNumber() == accountNo)
            {
                System.out.println("please enter the amount you want to withdraw");
                Scanner draw = new Scanner(System.in);
                double amt = draw.nextDouble();
                if (  amt > 10000.0 )
                {
                    System.out.println("Error withdraw limit exceeded");

                }
                else if(amt > account.getBalance())
                {
                    System.out.println("Error not enough balance");
                }
                else {
                    account.setBalance( - amt);
                    System.out.println("Withdraw sucessful");
                }

            }
            else {
                System.out.println("Error");
            }
        }
    }

    @Override
    public void insertDummyData() {

    }

    @Override
    public void createTable() {

    }

    @Override
    public BankAccount getAccount(int AccNumber) {
        return bankAccount.get(AccNumber);
    }



    @Override
    public void updateAccountName(int accountNo, String newName) {
        //bankAccount.get(account.getAccountNumber()).setName(account.getName());
        for ( BankAccount account : bankAccount)
        {
            System.out.println("Please enter your account number to change your information: ");
            if (account.getAccountNumber() == accountNo)
            {


                account.setName(newName);
                System.out.println("Your new name has been saved.");

            }

            else {
                System.out.println("Error, please check your account number and try again");
            }
        }

    }

    @Override
    public void deleteAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter your account number to delete the account");
        int accountNo = in.nextInt();
        for ( BankAccount accounts : bankAccount)
        {
            if (accounts.getAccountNumber() == accountNo)
            {
                bankAccount.remove(accounts);
                System.out.println("Account " + accountNo + "has been successfully removed" );
            }
            else {
                System.out.println("account does not exist");
            }
        }


    }

    @Override
    public void  createAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Creating a New account");
        System.out.println("Please enter your first and last name");
        String name = in.nextLine();
        System.out.println("Please deposit your initial balance (must be more than $ 5)");
        double balance = in.nextDouble();
        Scanner number = new Scanner(System.in);
        System.out.println("Please enter your phone Number");
        String phNumber = number.nextLine();

        Scanner email = new Scanner(System.in);
        System.out.println("Please enter your email");
        String mail = email.nextLine();

            BankAccount newAccount = new BankAccount(name, balance, phNumber, mail);

            bankAccount.add(newAccount);
            System.out.println("Thank you for creating an account with us \n" +
                    "please confirm you Account information below \n" +
                    "Account number:" + newAccount.getAccountNumber() + "\n" + "Name: " +newAccount.getName()
                    + "\n" + "Balance: " +newAccount.getBalance()+ "\n" + "Phone Number:"+ newAccount.getPhoneNumber()
                    + "\n" + "E-mail address: "+ newAccount.getEmail());

    }

//    @Override
//    public void addAccount(BankAccount account) {
//        bankAccount.add(account);
//        //account.setAccountNumber();
//
//    }


    public void updateAccountEmail()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter you account number to change the email");
        int accountNo = in.nextInt();
        for ( BankAccount account : bankAccount)
        {
            if (account.getAccountNumber() == accountNo)
            {
                System.out.println("Please enter your new Email: ");
                Scanner email =  new Scanner(System.in);
                String newEmail = email.nextLine();
                account.setEmail(newEmail);
                System.out.println("Your new Email has been saved.");

            }

            else {
                System.out.println("Error, please check your account number and try again");
            }
        }

    }

    @Override
    public void updateAccountPhoneNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter you account number to change the email");
        int accountNo = in.nextInt();
        for ( BankAccount account : bankAccount)
        {
            if (account.getAccountNumber() == accountNo)
            {
                System.out.println("Please enter your new Phone Number : ");
                Scanner phone =  new Scanner(System.in);
                String phoneNo = phone.nextLine();
                account.setPhoneNumber(phoneNo);
                System.out.println("Your new phone Number has been saved.");

            }

            else {
                System.out.println("Error, please check your account number and try again");
            }
        }
    }

    @Override
    public void searchUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter the name of the user you want to search");
        String accountName = in.nextLine();
        for (BankAccount account : bankAccount) {
            if (account.getName().equals(accountName)) {
                System.out.println("User Found \n" +
                        "Account number: " + account.getAccountNumber() + "\n" +
                        "Name: " + account.getName() + "\n" +
                        "Balance : " + account.getBalance() + "\n" +
                        "Phone number : " + account.getPhoneNumber() + "\n" +
                        "Email  :" + account.getEmail());

            } else {
                System.out.println("No User found by that name ");
            }
        }
    }
}
