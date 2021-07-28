package main.java;

public interface BankAccountInterface {

    public void getAllAccount();
    public void showBalance();
    public BankAccount getAccount (int AccNumber);
    public void updateAccountName (int accountNo, String newName);
    public void deleteAccount ();
    public void  createAccount ();
    public void updateAccountEmail();
    public void updateAccountPhoneNumber();
    public void searchUser();
    public void deposit();
    public void withdraw();
    public void insertDummyData();

    public void createTable();

}
