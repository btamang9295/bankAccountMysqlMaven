package main.java;

public class BankAccount {
    private static int accNumber = 555555;
    private int accountNumber;
    private String name;
    private double balance;
    private String phoneNumber;
    private String email;


    public BankAccount(String name, double balance, String phoneNumber, String email){
        accNumber ++;
        this.accountNumber = accNumber;
        this.name = name;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }
    public int getAccountNumber(){
        return accountNumber;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double amt){
        this.balance = balance + amt;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    double showBalance(){
        return this.balance;
    }
    void depositAmount (double amt){
        balance = balance + amt;
    }
    void withdrawAmount (double amt){
        balance = balance - amt;
    }

}
