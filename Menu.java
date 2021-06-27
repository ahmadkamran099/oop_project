package Projectjava;

import java.util.Scanner;

public class Menu {
    Scanner abc=new Scanner(System.in);
    public void display() throws Exception{
        System.out.println("************************************************************");
        System.out.println("                         WELCOME TO BANKING SYSTEM                       ");
        System.out.println("************************************************************");
        DataBase dataBase=new DataBase();
        while (true){
            System.out.println("Press 1 to create new account ");
            System.out.println("Press 2 to Check your account information ");
            System.out.println("Press 3 to deposit money ");
            System.out.println("Press 4 to withdraw money ");
            System.out.println("Press 5 to transfer money ");
            System.out.println("Press 6 to pay bill ");
            System.out.println("Press 7 to delete your account ");
            System.out.println("Press 8 to exit ");
            System.out.println("\nSelect the options above ");
            int input = abc.nextInt();
            int type;
            switch (input) {
                case 1:
                    System.out.println(" *** Creation of the account *** ");
                    System.out.println("Enter your name");
                    Scanner input1 = new Scanner(System.in);
                    String name = input1.nextLine();
                    System.out.println("Enter your CNIC ");
                    String CNIC = input1.nextLine();
                    System.out.println("Enter initial amount to create an account");
                    long Amount = input1.nextLong();
                    System.out.println(" Account type ");
                    System.out.println("press 1 to create Saving account");
                    System.out.println("press 2 to create Checking account");
                    type=input1.nextInt();
                    if (type==1){
                        dataBase.addAcc(new Saving_account(name,CNIC,Amount));
                        break;
                    }
                    else if (type==2){
                        dataBase.addAcc(new Checking_account(name,CNIC,Amount));
                        break;
                    }
                    else {
                        System.out.println("Invalid input");
                        break;
                    }
                case 2:
                    try {


                        System.out.println("Enter your account number");
                        Scanner input2 = new Scanner(System.in);
                        int x = input2.nextInt();
                        dataBase.accountInfo(x);
                        System.out.println("                            ");
                        System.out.println("                            ");
                    } catch (Exception e){
                        System.out.println("This account doesn't exist");
                    }
                    break;
                case 3:
                    try {
                        dataBase.deposit();
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }catch(Exception e){

                        System.out.println("This account doesn't exist");
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }
                    break;
                case 4:
                    try {
                        dataBase.withdraw();
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }catch (Exception e){
                        System.out.println("This account doesn't exist ");
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }

                    break;
                case 5:
                    try {
                        dataBase.transfer();
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }catch (Exception e){
                        System.out.println("This account doesn't exist ");
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }
                    break;
                case 6:
                   try {
                       dataBase.payBill();
                       System.out.println("                            ");
                       System.out.println("----------------------------");
                       System.out.println("                            ");
                   }
                   catch (Exception e){
                       System.out.println("This account doesn't exist");
                       System.out.println("                            ");
                       System.out.println("----------------------------");
                       System.out.println("                            ");

                   }
                    break;
                case 7:
                    try {
                        System.out.println("Enter your Account number");
                        Scanner input11 = new Scanner(System.in);
                        int x1 = input11.nextInt();
                        dataBase.deleteAccount(x1);
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }catch(Exception e){

                        System.out.println("This account doesn't exist");
                        System.out.println("                            ");
                        System.out.println("----------------------------");
                        System.out.println("                            ");
                    }
                    break;
                case 8:
                    dataBase.loadData();
                    System.out.println("*  Thank you for visiting our banking system  *");
                    System.exit(0);
                    break;
                default :
                    System.out.println(" PLEASE SELECT THE RIGHT OPTION ");
                    System.out.println("                            ");
                    System.out.println("----------------------------");
                    System.out.println("                            ");
            }

        }

    }

}