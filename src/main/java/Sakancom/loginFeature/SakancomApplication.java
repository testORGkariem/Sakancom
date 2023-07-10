package Sakancom.loginFeature;
import Sakancom.OwnerFeatures.ownerEntity;
import Sakancom.tenantFeatures.ControlPanel;
import Sakancom.tenantFeatures.Furniture;
import Sakancom.tenantFeatures.housingEntity;

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

                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter User Name : ");
                in.UserName = input1.nextLine();
                System.out.print("Enter the Password : ");
                in.Password = input1.nextLine();
                String role= in.checkValues(in.UserName,in.Password);


                if(role.equals("tenant")){
                    while(true){

                        System.out.println("_____________________________________________");
                        System.out.println("Choose from the following");
                        System.out.println("1-View the available housing");
                        System.out.println("2-Furniture");
                        System.out.println("3-Control Panel");
                        System.out.println("4-Sign out");
                        System.out.print("The Value : ");
                        Scanner input2=new Scanner(System.in);
                        int choose=input2.nextInt();
                        System.out.println("_____________________________________________");
                        if(choose==1){
                            housingEntity e=new housingEntity();
                            int avb= e.showAvailable();
                            if(avb>1){
                                System.out.println("do you want to book  accommodation? (Yes or No)");
                                Scanner inp=new Scanner(System.in);
                                String YN=new String();
                                YN=inp.nextLine();
                                if(YN.equals("Yes")){
                                    System.out.println("Enter house ID : ");
                                    Scanner id = new Scanner(System.in);
                                    String ID = id.nextLine();
                                    e.booking(ID,in.UserName);

                                }}
                        }
                        if(choose==2) {
                            while (true) {
                                System.out.println("_____________________________________________");
                                System.out.println("Choose from the following");
                                System.out.println("1-View the available Furniture's");
                                System.out.println("2-Add Furniture's");
                                System.out.println("3-Sell Furniture's");
                                System.out.println("4-Back");
                                System.out.print("The Value : ");
                                Scanner inp = new Scanner(System.in);
                                int ch = inp.nextInt();
                                System.out.println("_____________________________________________");
                                Furniture o = new Furniture();
                                if (ch == 1) {
                                    o.displayFurniture(in.UserName);

                                } else if (ch == 2) {
                                    Scanner inp1 = new Scanner(System.in);
                                    System.out.println("Enter Picture : ");
                                    o.Picture = inp1.nextLine();
                                    System.out.println("Enter Description : ");
                                    o.Description = inp1.nextLine();
                                    System.out.println("Enter Price : ");
                                    o.Price = inp1.nextLine();
                                    System.out.println("Enter ID : ");
                                    o.ID = inp1.nextLine();
                                    o.selled = "No";
                                    o.addFurniture(in.UserName, o.Picture, o.Description, o.Price, o.ID, o.selled);

                                } else if (ch == 3) {
                                    Scanner inp1 = new Scanner(System.in);
                                    System.out.println("Enter ID to sell: ");
                                    o.ID = inp1.nextLine();
                                    o.sellFurniture(o.ID, in.UserName);

                                } else if (ch == 4) {
                                    break;
                                }

                            }
                        } else if
                        (choose==3) {
                            ControlPanel e=new ControlPanel();
                            e.displayBooked(in.UserName);
                        } else if (choose==4) {
                            break;
                        }
                    }

                }
                else if(role.equals("owner")){
                    System.out.println("_____________________________________________");
                    System.out.println("___________________Welcome___________________");
                    System.out.println("Choose from the following ");
                    System.out.println("1-Housing ");
                    System.out.println("2-Logout ");
                    System.out.print("The Value : ");
                    Scanner i = new Scanner(System.in);
                    int inp = i.nextInt();
                    if(inp == 1)
                    {
                        System.out.println("___________________Housing___________________");
                        System.out.println("1-Add Residence ");
                        System.out.println("2-Show Residences ");
                        System.out.print("The Value : ");
                        Scanner inp1 = new Scanner(System.in);
                        int input2 = i.nextInt();
                        if(input2 == 1)
                        {
                            System.out.println("________________Add Residence________________");
                            System.out.println("....");
                        }
                        System.out.println("__________________Residences_________________ ");
                    }
                }
                else if (role.equals("admin")) {

                }
                System.out.println("_____________________________________________");
            }
            else if (LoginOrSignUp==2) {
                System.out.println("_____________________________________________");
                System.out.println("Choose from the following ");
                System.out.println("1-Owner");
                System.out.println("2-Tenant");
                System.out.print("The Value : ");
                Scanner in = new Scanner(System.in);
                int inp = in.nextInt();
                if(inp == 1) {
                    loginEntity obj  = new loginEntity();
                    Scanner inp1 = new Scanner(System.in);
                    System.out.println("_____________________________________________");
                    System.out.println("________________Signup as Owner________________");
                    System.out.println("Please enter your First name: ");
                    obj.fName = inp1.nextLine();
                    System.out.println("Please enter your Middle name name: ");
                    obj.mName = inp1.nextLine();
                    System.out.println("Please enter your Last name: ");
                    obj.lName = inp1.nextLine();
                    System.out.println("Please enter your Phone number: ");
                    obj.Phone = inp1.nextLine();
                    System.out.println("Please enter your Email: ");
                    obj.owEmail = inp1.nextLine();
                    System.out.println("Please enter your age: ");
                    obj.age = inp1.nextLine();
                    System.out.println("Please enter your username: ");
                    obj.owUser = inp1.nextLine();
                    System.out.println("Please enter your password: ");
                    obj.owPass = inp1.nextLine();
                    System.out.println("Creating Owner Account... \n");
                    if (obj.printOwner(obj.fName, obj.mName, obj.lName, obj.Phone, obj.owEmail, obj.age, obj.owUser, obj.owPass)) {
                        System.out.println("Owner Account Created");
                    } else {
                        System.out.println("Error! Creation Failed");
                    }
                }
                else if(inp == 2)
                {
                    loginEntity ob  = new loginEntity();
                    Scanner inp3 = new Scanner(System.in);
                    System.out.println("________________Signup as Tenant________________");
                    System.out.println("Please enter your First name: ");
                    ob.fName = inp3.nextLine();
                    System.out.println("Please enter your Middle name name: ");
                    ob.mName = inp3.nextLine();
                    System.out.println("Please enter your Last name: ");
                    ob.lName = inp3.nextLine();
                    System.out.println("Please enter your Phone number: ");
                    ob.Phone = inp3.nextLine();
                    System.out.println("Please enter your Email: ");
                    ob.tenEmail = inp3.nextLine();
                    System.out.println("Please enter your age: ");
                    ob.age = inp3.nextLine();
                    System.out.println("Please enter your Registration number: ");
                    ob.Reg_num = inp3.nextLine();
                    System.out.println("Please enter your major: ");
                    ob.major = inp3.nextLine();
                    System.out.println("Please enter your username: ");
                    ob.UserName = inp3.nextLine();
                    System.out.println("Please enter your password: ");
                    ob.Password = inp3.nextLine();
                    System.out.println("Creating Tenant Account... \n");
                    if(ob.printTenant(ob.fName, ob.mName, ob.lName, ob.Phone, ob.tenEmail, ob.age, ob.Reg_num, ob.major, ob.UserName, ob.Password)) {
                        System.out.println("Tenant Account Created");
                    }
                    else{
                        System.out.println("Error! Creation Failed");
                    }
                }
            }
        }
    }
}