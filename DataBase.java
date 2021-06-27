package Projectjava;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
    private ArrayList<Account> list;

    public DataBase() {
        this.list = new ArrayList<Account>();//the type is account, since account is abstract
        // we can not  create its object, therefore, by using the concept of polymorphism
        // we will be storing the objects of child classes
        //of account in the reference variable of account
    }

    public void addAcc(Account acc) {
        for (Account AL : list) {
            if (list.isEmpty()){
                list.add(acc);
            }
            if (AL.getAccount_no()==acc.getAccount_no()) {//Adding accounts on the base of Account number
                System.out.println("This account number is already exist");
                return;
            }

        }
        list.add(acc);
        updateFile();// After every method, Simultaneously storing all the information in the text file
    }


    public void deleteAccount(int x) {
        for (int i = 0; i < list.size(); i++) {
            if (x==list.get(i).getAccount_no()) {
                list.remove(list.get(i));
                System.out.println("Account removed");
                updateFile();
                return;
            }
        }
        System.out.println("This account number does not exist");
    }

    public void deposit() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        long an = sc.nextLong();
        int index=0;
        for (int i = 0; i < list.size(); i++) {
            if (an == list.get(i).getAccount_no()) {
                System.out.println("Your current balance is " + list.get(i).getCurrentBalance());
                System.out.println("Enter the amount of money you want to deposit");
                long depo = sc.nextLong();
                index=i;
                list.get(i).setCurrentBalance(list.get(i).getCurrentBalance() + depo);
                System.out.println("Your amount deposited successfully");
                updateFile();
                return;
            }
        }
        if (an!=list.get(index).getAccount_no()){
            System.out.println("This account number does not exist");
            return;
        }
    }
    public void withdraw() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        long an = sc.nextLong();
        int Index =0;
        long x=0;
        for (int i = 0; i < list.size(); i++) {
            if (an==list.get(i).getAccount_no()) {
                System.out.println("Your current balance is " + list.get(i).getCurrentBalance());
                System.out.println("Enter the amount of money you want to withdraw");
                long withdraw = sc.nextLong();
                Index =i;
                x=withdraw;
            }
        }
        if (an!=list.get(Index).getAccount_no()){
            System.out.println("This account number does not exist");
            return;
        }
        if (x<1000){
            System.out.println("You can not withdraw less than 1000 rupees");
            return;
        }
        if (x>list.get(Index).getCurrentBalance()){
            System.out.println("Not Enough Balance");
            return;
        }
        list.get(Index).setCurrentBalance(list.get(Index).getCurrentBalance() - x);
        System.out.println("Your amount withdrawn successfully");
        updateFile();
    }

    public void transfer() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        int to = sc.nextInt();
        System.out.println("Enter account number to which you want to transfer money");
        Scanner sc1 = new Scanner(System.in);
        int from = sc1.nextInt();
        int t = -1, f = -1, x = 0;
        for (int i = 0; i < list.size(); i++) {
            if (to == list.get(i).getAccount_no()) {
                System.out.println("Your current balance is " + list.get(i).getCurrentBalance());
                t = i;
            }
        }
        if (to!=list.get(t).getAccount_no()){
            System.out.println("Your account number is incorrect");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (from==list.get(i).getAccount_no()) {
                System.out.println("Enter the amount you want to transfer");
                x = sc.nextInt();
                f = i;
            }

        }
        if (from!=list.get(f).getAccount_no()) {
            System.out.println("receiver's account number is incorrect ");
            return;
        }
        if (t != -1 && f != -1 && list.get(t).getCurrentBalance() >= x) {
            list.get(t).setCurrentBalance(list.get(t).getCurrentBalance() - x);
            list.get(f).setCurrentBalance(list.get(f).getCurrentBalance() + x);
            System.out.println("Amount is transfer");
            updateFile();
        } else {
            System.out.println("You don't have enough money ");
        }
    }


    public void payBill() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        int an = sc.nextInt();
        int index = 0, amount1 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (an == list.get(i).getAccount_no()) {
                System.out.println("Enter the amount of bill");
                int amount = sc.nextInt();
                amount1 = amount;
                index = i;
            }

        }
        if (an!=list.get(index).getAccount_no()){
            System.out.println("This account number is not available");
            return;
        }
        if (list.get(index).getCurrentBalance() < amount1) {
            System.out.println(" Not enough money");
            return;
        }
        list.get(index).setCurrentBalance(list.get(index).getCurrentBalance() - amount1);
        System.out.println("Your bill has been payed successfully");

    }

    private void updateFile() {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
            oos.writeObject(this.list);
        } catch (IOException e) {
            System.out.println("File didn't get saved because of error " + e.getMessage());
        }
    }

    public void loadData() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.txt"));
            try {
                this.list = (ArrayList<Account>) ois.readObject();
            } catch (ClassNotFoundException e) {
                this.list = new ArrayList<Account>();
            }
        } catch (IOException e) {
            this.list = new ArrayList<Account>();
        }
    }
    public void accountInfo(int an){
        if (list.size()==1  && list.get(0).getAccount_no()==an){
            list.get(0).Display();
            return;
        }

        else
            for (int i=0;i<list.size();i++){
                if (an==list.get(i).getAccount_no()) {
                    list.get(i).Display();
                    return;
                }
            }
        System.out.println("This account does not exist");
    }

}


