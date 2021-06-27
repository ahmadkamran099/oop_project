package Projectjava;

public class Saving_account extends Account {
    public final String Account_type="Saving Account";
    public Saving_account(String name,String CNIC,long currentBalance){
        super(name,CNIC,currentBalance);
    }

    @Override
     public  void Display(){
                    System.out.println( "    *** Account information ***       " +"\n"+
                "Name = " +super.getName()+"\n"+
                "CNIC = " + super.getCNIC()+"\n"+
                "Current Balance = " + super.getCurrentBalance()+"\n"+
                "Account type = " + Account_type+"\n"+
                "                                                       "+"\n"+
                "-------------------------------------------------------"+
                "                                                       ");
     }
    

}
