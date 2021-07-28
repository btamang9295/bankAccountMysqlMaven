package main.java;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

     BankAccountInterface account = new mysql_connection();  //for mysql instance class
     // BankAccountInterface account = new BankAccountImplementation();
        account.createTable();
        account.insertDummyData();
        Scanner input = new Scanner(System.in);

        int option = -1;

        while(option < 1 || option > 11){

            System.out.println(" ============================= ");
            System.out.println(" 1. Show Account Balance ");
            System.out.println(" 2. Deposit ");
            System.out.println(" 3. withdraw ");
            System.out.println(" 4. Create an Account  ");
            System.out.println(" 5. Update name  ");
            System.out.println(" 6. Update Email  ");
            System.out.println(" 7. Update phone Number  ");
            System.out.println(" 8. Delete an Account  ");
            System.out.println(" 9. Display all User ");
            System.out.println(" 10. Search User by name ");
            System.out.println(" 11. Exit ");

            System.out.println( " Please Enter a Number to select from the menu: ");


            if(input.hasNextInt())
                option = input.nextInt();

        }

        switch(option){
            case 1:
                //do logic
                //account.showBalance();
                account.getAllAccount();
                break;
            case 2:
                //do logic
                account.deposit();
                break;
            case 3:
                //do logic
                account.withdraw();
                break;
            case 4:
                account.createAccount();
                break;

            case 5:
                Scanner acc = new Scanner(System.in);
                System.out.println("Please enter you account number to change the name");
                int accNum = acc.nextInt();

                Scanner newName = new Scanner(System.in);
                System.out.println("Please enter your new name");
                String s1 = newName.nextLine();
                account.updateAccountName(accNum, s1);
                break;
            case 6:
                account.updateAccountEmail();
                break;
            case 7:
                account.updateAccountPhoneNumber();
                break;
            case 8:
                account.deleteAccount();
                break;
            case 9:
                account.getAllAccount();
                break;
            case 10:
                account.searchUser();
                break;






        }

        // Test for the new added account.
       account.getAllAccount();

    }

}
