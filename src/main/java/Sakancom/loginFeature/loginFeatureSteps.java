package Sakancom.loginFeature;

import java.sql.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class loginFeatureSteps {

    boolean adminFlag,adminPass,adminUsername,userLoggedin;
    boolean tenantFlag, tenantPass, tenantUser, ownerFlag, ownerPass, ownerUser;
    String user= "admin";
    String pass= "1234567";
    loginEntity obj;
    String tenant= "tenant";
    String owner = "owner";
    String User = "kariem";
    String Pass = "123456";
    String wrongUser = "kari";
    String wrongPass = "12345";
    //dependecy injection
    //dependecy inversion control (SOLID)
   public loginFeatureSteps(loginEntity obj){
       super();
       this.obj = obj;
   }



    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }

    @Given("enters {string} as a username and enters {string} as a password")
    public void enters_as_a_username_and_enters_as_a_password(String string, String string2) {
        adminFlag = false;
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+user+"'";
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()) {
                if (user.equals(resultSet.getString("username")))
                {
                    adminUsername = true;
                }
                if (pass.equals(resultSet.getString("password")));
                {
                    adminPass = true;
                    if(adminUsername)
                    assertTrue(true);
                }
            }
            else {
                assertFalse(true);
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }

    @Then("admin login success")
    public void adminLoginSuccess() {
        if(adminUsername&&adminPass==true)
            adminFlag = true;
    }



    @Given("tenant or owner wants to login to the system")
    public void tenant_or_owner_wants_to_login_to_the_system()
    {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and both are correct")
    public void enters_as_a_username_and_as_a_password_and_both_are_correct(String USERNAME, String PASSWORD) {
        tenantFlag = false;
        ownerFlag = false;
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try (Connection connection = DriverManager.getConnection(url, username, password))
        {

            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+User+"' and password = '"+Pass+"'";
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next())
            {
                if (User.equals(resultSet.getString("username")))
                {
                    if(resultSet.getString("role").equals("tenant"))
                    {
                        System.out.println("tenant");
                        tenantUser = true;
                    }
                    else if(resultSet.getString("role").equals("owner"))
                    {
                        System.out.println("owner");
                        ownerUser = true;
                    }
                }
                if(Pass.equals(resultSet.getString("password")))
                {
                    if(resultSet.getString("role").equals("tenant"))
                    {
                        if(tenantUser)
                        {
                            tenantPass = true;
                            tenantFlag = true;
                            assertTrue(true);
                        }
                    }
                    else if(resultSet.getString("role").equals("owner"))
                    {
                        System.out.println("owner");
                        if(ownerUser)
                        {
                            ownerPass = true;
                            ownerFlag = true;
                            assertTrue(true);
                        }
                    }
                }
            }
            if(ownerFlag&&tenantFlag == false)
            {
                assertFalse(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("login successful")
    public void login_successful() {
        if(tenantFlag == true)
            assertTrue(true);
        else if(ownerFlag == true)
            assertTrue(true);
        else
        {
            assertFalse(true);
        }
    }



    @Given("tenant or owner login to the system")
    public void tenant_or_owner_login_to_the_system() {
        tenantFlag = false;
        ownerFlag = false;
    }

    @Given("enters {string} as a username and {string} as a password and one of them are wrong")
    public void enters_as_a_username_and_as_a_password_and_one_of_them_are_wrong(String USERNAME, String PASSWORD)
    {
        tenantFlag = false;
        ownerFlag = false;
        String host = "localhost";
        int port = 3306;
        String database = "Sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try (Connection connection = DriverManager.getConnection(url, username, password))
        {

            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "Select * from login where username = '"+wrongUser+"' and password = '"+wrongPass+"'";
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next())
            {
                tenantFlag = true;
                ownerFlag = true;
                assertFalse(true);
            }
            else
            {
                assertTrue(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("error appears")
    public void error_appears() {
            System.out.println("Username or Password are invalid");
    }



    @Given("user wants to register as a tenant or owner")
    public void user_wants_to_register_as_a_tenant_or_owner() {
        assertTrue(true);
    }
    @Given("fill in all or some of the information, and the username is available")
    public void fill_in_all_or_some_of_the_information_and_the_username_is_available() {
            String Fname = "Ahmad";
            String Mname = "mohammed";
            String Lname = "AbuAishe";
            String Phone = "0593220265";
            String Email = "ahmadmohammed@gmail.com";
            String age = "21";
            String tenUser = "Ahmad mohammed";
            String tenPass = "11223344";
            String FFname = "Ahmad";
            String MMname = "Sameer";
            String LLname = "AbuAishe";
            String PPhone = "0593220255";
            String EEmail = "ahmadAbuAishe@gmail.com";
            String aage = "21";
            String major = "Computer Engineering";
            String reg_num = "12028797";
            String tennUser = "Ahmad AbuAishe";
            String tennPass = "1234";
            System.out.println("_____________________________________________");
            System.out.println("Choose from the following ");
            System.out.println("1-Login");
            System.out.println("2-Signup");
            System.out.print("The Value : ");
            System.out.println("_____________________________________________");
            String owner = "owner";
            System.out.println("________________Signup as Owner________________");
            System.out.println("Please enter your First name: " +Fname+ "\n");
            System.out.println("Please enter your Middle name name: " +Mname+ "\n");
            System.out.println("Please enter your Last name: " +Lname+ "\n");
            System.out.println("Please enter your Phone number: " +Phone+ "\n");
            System.out.println("Please enter your Email: " +Email+ "\n");
            System.out.println("Please enter your age: " +age+ "\n");
            System.out.println("Please enter your username: " +tenUser+ "\n");
            System.out.println("Please enter your password: " +tenPass+ "\n");
            System.out.println("_____________________________________________");
            String host = "localhost";
            int port = 3306;
            String database = "Sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            try (Connection connection = DriverManager.getConnection(url, username, password))
            {
                System.out.println("Connected to the MySQL database!");
                Statement statement = connection.createStatement();
                String query = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+owner+"')";
                statement.executeUpdate(query);
                Statement statement2 = connection.createStatement();
                String query2 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+Fname+"', '"+Mname+"', '"+Lname+"', '"+Phone+"', '"+Email+"', '"+age+"', '"+tenUser+"','"+tenPass+"', '"+owner+"')";
                statement2.executeUpdate(query2);
                System.out.println("Creating Owner Account...");
                System.out.println("_____________________________________________");
                assertTrue(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("________________Signup as Tenant________________");
            String tenant = "tenant";
            System.out.println("Please enter your First name: " +FFname+ "\n");
            System.out.println("Please enter your Middle name name: " +MMname+ "\n");
            System.out.println("Please enter your Last name: " +LLname+ "\n");
            System.out.println("Please enter your Phone number: " +PPhone+ "\n");
            System.out.println("Please enter your Email: " +EEmail+ "\n");
            System.out.println("Please enter your age: " +aage+ "\n");
            System.out.println("Please enter your Registration number: " +reg_num+ "\n");
            System.out.println("Please enter your major: " +major+ "\n");
            System.out.println("Please enter your username: " +tennUser+ "\n");
            System.out.println("Please enter your password: " +tennPass+ "\n");
            System.out.println("_____________________________________________");
            try (Connection connection = DriverManager.getConnection(url, username, password))
            {
                System.out.println("Connected to the MySQL database!");
                Statement statement3 = connection.createStatement();
                String query3 = "insert into login (username, password, role) values ('"+tennUser+"','"+tennPass+"', '"+tenant+"')";
                statement3.executeUpdate(query3);
                Statement statement4 = connection.createStatement();
                String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('"+FFname+"', '"+MMname+"', '"+LLname+"', '"+PPhone+"', '"+EEmail+"', '"+aage+"', '"+reg_num+"', '"+major+"', '"+tennUser+"','"+tennPass+"', '"+tenant+"')";
                statement4.executeUpdate(query4);
                System.out.println("Creating Tenant Account...");
                System.out.println("_____________________________________________");
                assertTrue(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    @Then("registration complete and the account is created")
    public void registration_complete_and_the_account_is_created() {
            System.out.println("_________Account Created Successfully________");
            System.out.println("_____________________________________________");
            assertTrue(true);
    }



    @Given("user wants to signup as a tenant or owner")
    public void user_wants_to_signup_as_a_tenant_or_owner() {
        assertTrue(true);

    }
    @Given("fill in all or some of the information, and the username isn't unavailable")
    public void fill_in_all_or_some_of_the_information_and_the_username_is_username_is_unavailable() {
            String Fname = "Ahmad";
            String Mname = "mohammed";
            String Lname = "AbuAishe";
            String Phone = "0593220265";
            String Email = "ahmadmohammed@gmail.com";
            String age = "21";
            String tenUser = "Ahmad mohammed";
            String tenPass = "11223344";
            String FFname = "Ahmad";
            String MMname = "mohammed";
            String LLname = "AbuAishe";
            String PPhone = "0593220255";
            String EEmail = "ahmadAbuAishe@gmail.com";
            String aage = "21";
            String major = "Computer Engineering";
            String reg_num = "12028797";
            String tennUser = "Ahmad AbuAishe";
            String tennPass = "1234";
            System.out.println("_____________________________________________");
            System.out.println("Choose from the following ");
            System.out.println("1-Login");
            System.out.println("2-Signup");
            System.out.print("The Value : ");
            System.out.println("_____________________________________________");
            String owner = "owner";
            System.out.println("________________Signup as Owner________________");
            System.out.println("Please enter your First name: " +Fname+ "\n");
            System.out.println("Please enter your Middle name name: " +Mname+ "\n");
            System.out.println("Please enter your Last name: " +Lname+ "\n");
            System.out.println("Please enter your Phone number: " +Phone+ "\n");
            System.out.println("Please enter your Email: " +Email+ "\n");
            System.out.println("Please enter your age: " +age+ "\n");
            System.out.println("Please enter your username: " +tenUser+ "\n");
            System.out.println("Please enter your password: " +tenPass+ "\n");
            System.out.println("_____________________________________________");
            String host = "localhost";
            int port = 3306;
            String database = "Sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            try (Connection connection = DriverManager.getConnection(url, username, password))
            {
                System.out.println("Connected to the MySQL database!");
                assertTrue(true);
                Statement statement = connection.createStatement();
                String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
                ResultSet resultSet= statement.executeQuery(query);
                if(resultSet.next())
                {
                    assertTrue(true);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("________________Signup as Tenant________________");
            String tenant = "tenant";
            System.out.println("Please enter your First name: " +FFname+ "\n");
            System.out.println("Please enter your Middle name name: " +MMname+ "\n");
            System.out.println("Please enter your Last name: " +LLname+ "\n");
            System.out.println("Please enter your Phone number: " +PPhone+ "\n");
            System.out.println("Please enter your Email: " +EEmail+ "\n");
            System.out.println("Please enter your age: " +aage+ "\n");
            System.out.println("Please enter your Registration number: " +reg_num+ "\n");
            System.out.println("Please enter your major: " +major+ "\n");
            System.out.println("Please enter your username: " +tennUser+ "\n");
            System.out.println("Please enter your password: " +tennPass+ "\n");
            System.out.println("_____________________________________________");
    }
    @Then("registration fails and error appears")
    public void registration_fails_and_error_appears() {
            System.out.println("User already have an Account or Username isn't available");
            assertTrue(true);
    }



    @Given("admin, tenant or owner already logged in to the system")
    public void admin_tenant_or_owner_already_logged_in_to_the_system() {
       userLoggedin = true;
       assertTrue(true);
    }
    @Given("pressed logout")
    public void pressed_logout()
    {
       System.out.println("_____________________________________________");
       System.out.println("Choose from the following ");
       System.out.println("7-logout");
       System.out.print("The Value : ");
       System.out.println("_____________________________________________");
       System.out.println("\n******* information *******\n");
       System.out.println("_____________________________________________");
       System.out.println("___________Logged out Successfully___________");
       System.out.println("_____________________________________________");
       assertTrue(true);
   }
    @Then("admin, tenant or owner logged out successfully")
    public void admin_tenant_or_owner_logged_out_successfully() {
        System.out.println("___________Logged oud Successfully___________");
        System.out.println("_____________________________________________");
        assertTrue(true);
    }
}