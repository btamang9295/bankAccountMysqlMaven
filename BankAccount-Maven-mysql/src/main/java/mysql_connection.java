package main.java;

import java.sql.*;
import java.util.Scanner;

public class mysql_connection implements BankAccountInterface{
   static final String JDBC_driver = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://database-jenkins-1.cd2roeg6zwyk.us-west-1.rds.amazonaws.com:3306/BankDB";
   static final String USER = "admin";
   static final String PASS = "admin123";


   @Override
   public  void insertDummyData()
   {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Connecting to Database...");

           Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("creating table in given database...");
           Statement stmt = conn.createStatement();

           System.out.println("Inserting records into the table...");
           String sql = "INSERT INTO account VALUES ('123', 'Zara', 'Ali', '18', 'asd@')";
           stmt.executeUpdate(sql);
           sql = "INSERT INTO account VALUES ('124', 'Mahnaz', 'Fatma', '25', 'chi@')";
           stmt.executeUpdate(sql);
           sql = "INSERT INTO account VALUES ('125', 'Zaid', 'Khan', '30', 'lee@')";
           stmt.executeUpdate(sql);
           sql = "INSERT INTO account VALUES('126', 'Sumit', 'Mittal', '28', 'laa@')";
           stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
           System.out.println("Inserted records into the table...");
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }
   }

    @Override
    public void createTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("creating table in given database...");
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE account " +
                    "(AccountId INTEGER not NULL AUTO_INCREMENT," +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR (255), " +
                    "phoneNumber VARCHAR(255), " +
                    "email VARCHAR(255)," +
                    "PRIMARY KEY (AccountId))";

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Create table in given database");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllAccount() {

    }

    @Override
    public void showBalance() {

    }

    @Override
    public BankAccount getAccount(int AccNumber) {
        return null;
    }

    @Override
    public void updateAccountName(int accountNo, String newName) {

    }

    @Override
    public void deleteAccount() {

    }

    @Override
    public void createAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Creating a New account");
        System.out.println("Please enter your first name");
        String name = in.nextLine();
        System.out.println("Please enter your last name");
        String lastName = in.nextLine();
        System.out.println("Please deposit your initial balance (must be more than $ 5)");
        double balance = in.nextDouble();
        Scanner number = new Scanner(System.in);
        System.out.println("Please enter your phone Number");
        String phNumber = number.nextLine();

        Scanner email = new Scanner(System.in);
        System.out.println("Please enter your email");
        String mail = email.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("creating table in given database...");
            Statement stmt = conn.createStatement();

//            String sql = "CREATE TABLE account " +
//                    "(AccountId INTEGER not NULL," +
//                    "firstName VARCHAR(255), " +
//                    "lastName VARCHAR (255), " +
//                    "phoneNumber VARCHAR(255), " +
//                    "email VARCHAR(255)," +
//                    "PRIMARY KEY (AccountId))";

            String sql = "INSERT INTO account" +
                    "(firstName, lastName, phoneNumber, email)" + "VALUES(?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name );
            ps.setString(2, lastName);
            ps.setString(3, phNumber);
            ps.setString(4, mail);

            ps.executeUpdate();
            System.out.println("Create table in given database");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

//    @Override
//    public void addAccount(BankAccount account) {
//
//    }

    @Override
    public void updateAccountEmail() {

    }

    @Override
    public void updateAccountPhoneNumber() {

    }

    @Override
    public void searchUser() {

    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }


}
