package Sakancom;

import java.sql.SQLException;
import java.util.Scanner;

public class SakancomApplication{

    public static void main(String[] args) throws SQLException {
        while(true){
            System.out.println("_____________________________________________");
            System.out.println("Choose from the following ");
            System.out.println("1-Login");
            System.out.println("2-Signup");
            System.out.print("The Value: ");
            Scanner input = new Scanner(System.in);
            int LoginOrSignUp = 0;
            LoginOrSignUp = input.nextInt();
            System.out.println("_____________________________________________");

            if (LoginOrSignUp == 1) {
                System.out.println("\n******* Login Page *******\n");
                loginEntity in = new loginEntity();

                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter User Name: ");
                in.UserName = input1.nextLine();
                System.out.print("Enter the Password: ");
                in.Password = input1.nextLine();
                String role = in.checkValues(in.UserName, in.Password);


                if (role.equals("tenant")) {
                    while (true) {
                        System.out.println("_________________Tenant_________________");
                        System.out.println("Choose from the following");
                        System.out.println("1-View the available housing");
                        System.out.println("2-Furniture");
                        System.out.println("3-Control Panel");
                        System.out.println("4-Logout");
                        System.out.print("The Value: ");
                        Scanner input2 = new Scanner(System.in);
                        int choose = input2.nextInt();
                        System.out.println("_____________________________________________");
                        if (choose == 1) {
                            housingEntity e = new housingEntity();
                            int avb = e.showAvailable();
                            if (avb > 1) {
                                System.out.println("do you want to book  accommodation? (Yes or No)");
                                Scanner inp = new Scanner(System.in);
                                String YN = new String();
                                YN = inp.nextLine();
                                if (YN.equals("Yes")) {
                                    System.out.println("Enter house ID: ");
                                    Scanner id = new Scanner(System.in);
                                    String ID = id.nextLine();
                                    e.booking(ID, in.UserName);
                                }
                            }
                        }
                        if (choose == 2) {
                            while (true) {
                                System.out.println("_____________________________________________");
                                System.out.println("Choose from the following");
                                System.out.println("1-View the available Furniture's");
                                System.out.println("2-Add Furniture's");
                                System.out.println("3-Sell Furniture's");
                                System.out.println("4-Back");
                                System.out.print("The Value: ");
                                Scanner inp = new Scanner(System.in);
                                int ch = inp.nextInt();
                                System.out.println("_____________________________________________");
                                Furniture o = new Furniture();
                                if (ch == 1) {
                                    o.displayFurniture(in.UserName);

                                } else if (ch == 2) {
                                    Scanner inp1 = new Scanner(System.in);
                                    System.out.println("Enter Picture: ");
                                    o.Picture = inp1.nextLine();
                                    System.out.println("Enter Description: ");
                                    o.Description = inp1.nextLine();
                                    System.out.println("Enter Price: ");
                                    o.Price = inp1.nextLine();
                                    System.out.println("Enter ID: ");
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
                        (choose == 3) {
                            ControlPanel e = new ControlPanel();
                            e.displayControlPanel(in.UserName);
                        } else if (choose == 4) {
                            break;
                        }
                    }

                } else if (role.equals("owner")) {
                    System.out.println("____________________Owner____________________");
                    System.out.println("Choose from the following ");
                    System.out.println("1-Housing ");
                    System.out.println("2-Logout ");
                    System.out.print("The Value: ");
                    Scanner i = new Scanner(System.in);
                    int inp = i.nextInt();
                    if (inp == 1) {
                        while (true) {
                            ownerEntity obj = new ownerEntity();
                            System.out.println("___________________Housing___________________");
                            System.out.println("1-Add Housing ");
                            System.out.println("2-Show Housings ");
                            System.out.println("3-Logout ");
                            System.out.print("The Value: ");
                            Scanner inp1 = new Scanner(System.in);
                            int input2 = inp1.nextInt();
                            if (input2 == 1) {
                                Scanner inp3 = new Scanner(System.in);
                                System.out.println("________________Add Housing________________");
                                System.out.println("Enter Housing ID: ");
                                obj.counter = inp3.nextLine();
                                System.out.println("Enter Owner username: '" + in.UserName + "'");
                                obj.addHousing(in.UserName);
                                System.out.println("Enter Department name: ");
                                String depName = inp3.nextLine();
                                obj.departmentName(depName);
                                System.out.println("Do you want to insert picture? ");
                                String yn = inp3.nextLine();
                                if (yn.equals("Yes")) {
                                    System.out.println("Enter the picture: ");
                                    String photo = inp3.nextLine();
                                    obj.addPhoto(photo);
                                }
                                System.out.println("Do you want to Enter Housing Location? ");
                                String yn2 = inp3.nextLine();
                                if (yn2.equals("Yes")) {
                                    System.out.println("Enter Housing Location: ");
                                    String location = inp3.nextLine();
                                    obj.addLocationInfo(location);
                                }
                                System.out.println("Do you want to Enter Housing Services? ");
                                String yn3 = inp3.nextLine();
                                if (yn3.equals("Yes")) {
                                    System.out.println("Enter Housing Services:");
                                    String services = inp3.nextLine();
                                    obj.addServices(services);
                                }
                                System.out.println("Do you want to Enter Rent price? ");
                                String yn4 = inp3.nextLine();
                                if (yn4.equals("Yes")) {
                                    System.out.println("Enter Rent price: ");
                                    String price = inp3.nextLine();
                                    obj.addPrice(price);
                                }
                            }

                            if (input2 == 2) {
                                System.out.println("_______________Show Housings_______________");
                                obj.showHousings(in.UserName);
                            }
                            if (input2 == 3)
                                break;
                        }
                    }
                } else if (role.equals("admin")) {
                    adminEntity obj = new adminEntity();
                    System.out.println("____________________Admin____________________");
                    System.out.println("Choose from the following ");
                    System.out.println("1-See pending Housings ");
                    System.out.println("2-See Reservations ");
                    System.out.println("3-Logout ");
                    System.out.println("The Value:  ");
                    Scanner inp1 = new Scanner(System.in);
                    int input2 = inp1.nextInt();
                        if (input2 == 1) {
                            while (true) {
                                obj.pendingHousings();
                                System.out.println("Enter housing id: ");
                                Scanner inp4 = new Scanner(System.in);
                                String id = inp4.nextLine();
                                System.out.println("Do you want to accept it? ");
                                String acceptance = inp4.nextLine();
                                if (acceptance.equals("Yes")) {
                                    obj.acceptRejectHousing(id, acceptance);
                                    System.out.println("Housing accepted! ");
                                } else {
                                    System.out.println("Housing Rejected! ");
                                }
                                break;
                            }
                        }
                            if (input2 == 2) {
                                while (true) {
                                obj.showReservations();
                                break;
                            }
                        }
                        if (input2 == 3) {
                            while(true) {
                                System.out.println("Logged out successfully");
                                break;
                            }
                        }
                    }
                }
            else if (LoginOrSignUp==2) {
                System.out.println("_____________________________________________");
                System.out.println("Choose from the following ");
                System.out.println("1-Owner");
                System.out.println("2-Tenant");
                System.out.print("The Value: ");
                Scanner in = new Scanner(System.in);
                int inp = in.nextInt();
                if(inp == 1) {
                    loginEntity obj  = new loginEntity();
                    Scanner inp1 = new Scanner(System.in);
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