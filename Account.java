package Projectjava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public  abstract class Account implements Serializable,Operations {

    private String name;
    private String CNIC;
    private long currentBalance;
    private long account_no;
    public static int Available_account=0;//Declare this because account number of two accounts
    //can not be same
    //not declaring any of the variable transient because we want to serialize all the variable
    public Account(String name,String CNIC, long currentBalance) {
        this.name = name;
        this.account_no = Available_account;
        this.currentBalance = currentBalance;
        this.CNIC=CNIC;
        Available_account++;
        System.out.println("Your account number is "+account_no+"" +
                "\nPlease remember this account number\n" +
                "--------------------------------------------"+"" +
                "                                              ");
    }
        public abstract void Display();//declaring an abstract method
        public String getName() {
            return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return this.account_no==account.account_no &&
                this.CNIC.equals(account.CNIC) &&
                this.currentBalance==account.currentBalance ;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public static int getAvailable_account() {
        return Available_account;
    }

    public static void setAvailable_account(int available_account) {
        Available_account = available_account;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public long getAccount_no() {
        return account_no;
    }



    public static int getCount() {
        return Available_account;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }
    public void withdraw(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount you wants to withdraw");
        int amount= sc.nextInt();
        if(currentBalance>amount){
            currentBalance-=amount;
            System.out.println(amount+" was withdrew ! Current balance is "+ currentBalance);
        }
        else  System.out.println("Not enough balance to withdraw amount "+ amount);

    }
    public void deposit(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount you wants to deposit");
        int amount= sc.nextInt();
        currentBalance+=amount;
        System.out.println(amount+" was added to the balance! Current balance is "+ currentBalance);
    }
    public void transfer(Account transferTo){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount you wants to transfer");
        int amount= sc.nextInt();
        if(currentBalance>amount)  {
            currentBalance-=amount; transferTo.currentBalance+=amount;
            System.out.println(amount+" amount was transferred to "+transferTo.account_no+" from "+this.account_no);
        }
        else System.out.println("Not enough balance in account number "+ this.account_no+" to carry out the transfer!");
    }
    public void balanceInquiry(){
        System.out.println("Balance of "+this.account_no+" is "+ this.currentBalance);

    }
    public void payBill() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount of Bill");
        int amount= sc.nextInt();
        if (currentBalance<amount){
            System.out.println("Not enough balance");
        }
        else {
            currentBalance=currentBalance-amount;
            System.out.println("Bill payed successfully ");
            System.out.println("now your balance is "+currentBalance);
        }
    }
    

  
}

