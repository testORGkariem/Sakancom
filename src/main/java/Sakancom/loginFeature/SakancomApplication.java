package Sakancom.loginFeature;
import java.io.IOException;
import java.util.Scanner;

public class SakancomApplication{

    public static void main(String[] args) {
        while(true){
            System.out.println("_____________________________________________");
            System.out.println("Choose from the following ");
            System.out.println("1-Login");
            System.out.println("2-Signup");
            System.out.print("The Value : ");
            Scanner input = new Scanner(System.in);
            int LoginOrSignUp = 0;
            LoginOrSignUp = input.nextInt();
            System.out.println("_____________________________________________");

            if (LoginOrSignUp == 1) {
                System.out.println("\n******* Login Page *******\n");
                loginEntity in=new loginEntity();

               // String role= in.checkValues();
                //if(role.equals("tenant")){
                    //tenantEntity e=new tenantEntity();

                    //e.Start();
                //}
                //else if(role.equals("owner")){
                //}
                //else if (role.equals("admin")) {
//
               // }

                System.out.println("_____________________________________________");

            }

        }
    }
}