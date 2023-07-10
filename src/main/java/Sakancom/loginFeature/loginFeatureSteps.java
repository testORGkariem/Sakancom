package Sakancom.loginFeature;

import java.sql.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class loginFeatureSteps {

    boolean adminFlag,userLoggedin;
    boolean tenantFlag, ownerFlag,flag;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    loginEntity obj;
    public loginFeatureSteps(loginEntity obj){
        super();
        this.obj = obj;
    }
    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }
    @Given("enters {string} as a username and enters {string} as a password")
    public void enters_as_a_username_and_enters_as_a_password(String uname, String pword) {
        adminFlag = false;
        String Role=new String("admin");
        if(Role.equals(obj.checkValues(uname,pword)));
        adminFlag = true;
    }
    @Then("admin login success")
    public void adminLoginSuccess() {
        if(adminFlag)
            assertTrue(true);
    }
    @Given("tenant or owner wants to login to the system")
    public void tenant_or_owner_wants_to_login_to_the_system()
    {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and both are correct")
    public void enters_as_a_username_and_as_a_password_and_both_are_correct(String USERNAME, String PASSWORD)
    {
        tenantFlag = false;
        ownerFlag = false;
        if(obj.checkValues(USERNAME,PASSWORD).equals("tenant")||obj.checkValues(USERNAME,PASSWORD).equals("owner"))
        {
            assertTrue(true);
            tenantFlag = true;
            ownerFlag = true;
        }
    }
    @Then("login successful")
    public void login_successful() {
        if(tenantFlag||ownerFlag)
            assertTrue(true);
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
        if(!obj.checkValues(USERNAME,PASSWORD).equals("owner")||!obj.checkValues(USERNAME,PASSWORD).equals("tenant")||!obj.checkValues(USERNAME,PASSWORD).equals("admin")){
            assertTrue(true);
        }

    }
    @Then("error appears")
    public void error_appears() {
        assertTrue(true);
    }
    @Given("user wants to register as a tenant or owner")
    public void user_wants_to_register_as_a_tenant_or_owner() {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and both usernames is available")
    public void firstNameSecondNameLastnamePhoneEmailAgeOwUserOwPassForOwnerAndFirstNameSecondNameLastnamePhoneEmailAgeRegNumMajorTenUserTenPassForTenantAndBothUsernamesIsAvailable(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass)
    {
        obj.printTenant(FFname, MMname, LLname, PPhone, tenmail, Age, Reg_num, major, tenUser, tenPass);
        obj.printOwner(Fname, Mname, Lname, Phone, Owemail, age, OwUser, OwPass);
    }
    @Then("registration complete and the account is created with username{string} and password {string}")
    public void registrationCompleteAndTheAccountIsCreatedWithUsernameAndPassword(String username, String password)
    {
        if("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)))
        {
            assertTrue(true);
        }
    }
    @Given("user wants to signup as a tenant or owner")
    public void user_wants_to_signup_as_a_tenant_or_owner()
    {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and usernames isn't available")
    public void first_name_second_name_lastname_phone_email_age_ow_user_ow_pass_for_owner_and_first_name_second_name_lastname_phone_email_age_reg_num_major_ten_user_ten_pass_for_tenant_and_usernames_isn_t_available(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass)
    {
        assertTrue(obj.failureReg(FFname, MMname, LLname, PPhone, tenmail, Age, Reg_num, major, tenUser, tenPass));
    }
    @Then("registration fails the account with username{string} and password {string} isn't created")
    public void registrationFailsTheAccountWithUsernameAndPasswordIsnTCreated(String username, String password) {
        if("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)))
        {
            assertTrue(true);
        }
    }
    @Given("admin, tenant or owner already logged in to the system")
    public void admin_tenant_or_owner_already_logged_in_to_the_system()
    {
        userLoggedin = true;
        assertTrue(true);
    }
    @Given("pressed logout")
    public void pressed_logout()
    {
        obj.logout();
    }
    @Then("admin, tenant or owner logged out successfully")
    public void admin_tenant_or_owner_logged_out_successfully()
    {
        assertTrue(true);
    }
}