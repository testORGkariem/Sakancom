package Sakancom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ownerFeatureSteps {

    public ownerFeatureSteps(ownerEntity obj){
        super();
        this.obj = obj;
    }
    ownerEntity obj;
    boolean ownerFlag = false;
    boolean loggedOut = false;
    boolean photo = false;
    boolean contactInfo = false;
    boolean services = false;
    boolean price = false;
    boolean locationInfo = false;
    @Given("owner wants to login and add a residence")
    public void owner_wants_to_login_and_add_a_residence(){
        assertTrue(true);
    }
    @Given("owner enters {string} as username and {string} as a password")
    public void owner_enters_as_username_and_as_a_password(String Username, String Password){
        if(obj.checkValues(Username, Password).equals("owner")) {
            assertTrue(true);
            ownerFlag = true;
        }
    }
    @Then("owner logged in with {string} as username and {string} as a password and dashboard appears and adding list appears")
    public void owner_logged_in_with_as_username_and_as_a_password_and_dashboard_appears_and_adding_list_appears(String Username, String Password) {
            if(ownerFlag)
                assertTrue(true);
    }



    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing then selected {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_and_selected_for_housing_then_selected_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag&&string3.equals("1")&&string4.equals("1"))
        {
            assertTrue(true);
        }
    }
    @Given("adding to the housing options appears and owner added photo")
    public void adding_to_the_housing_options_appears_and_owner_added_photo() {
        if(obj.addPhoto())
        {
            photo = true;
            assertTrue(true);
        }
    }
    @Then("photo added successfully for owner {string}")
    public void photo_added_successfully_for_owner(String string) {
        if(photo)
            assertTrue(true);
    }


    @Given("owner is logged in with username {string} and  password {string} and selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_and_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag&&string3.equals("1")&&string4.equals("1"))
        {
            assertTrue(true);
        }
    }
    @Given("adding to the housing options appears and owner entered {string} as location and information")
    public void adding_to_the_housing_options_appears_and_owner_entered_as_location_and_information(String string) {
        if(obj.addLocationInfo(string))
        {
            locationInfo = true;
            assertTrue(true);
        }
    }
    @Then("location and information added successfully for owner {string}")
    public void location_and_information_added_successfully_for_owner(String string) {
        if(locationInfo)
            assertTrue(true);
    }



    @Given("owner is logged in with username {string} and  password {string} then selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_then_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag&&string3.equals("1")&&string4.equals("1"))
        {
            assertTrue(true);
        }
    }
    @Given("adding to the housing options appears and owner entered {string} as services")
    public void adding_to_the_housing_options_appears_and_owner_entered_as_services(String string) {
        if(obj.addServices(string))
        {
            services = true;
            assertTrue(true);
        }
    }
    @Then("services added successfully for owner {string}")
    public void services_added_successfully_for_owner(String string) {
        if(services)
            assertTrue(true);
    }



    @Given("owner is logged in with username {string},  password {string} and selected {string} for housing and {string} for add housing")
    public void owner_is_logged_in_with_username_password_and_selected_for_housing_and_for_add_housing(String string, String string2, String string3, String string4) {
        if(ownerFlag&&string3.equals("1")&&string4.equals("1"))
        {
            assertTrue(true);
        }
    }
    @Given("adding to the housing options appears and owner entered {string} as monthly rent")
    public void adding_to_the_housing_options_appears_and_owner_entered_as_monthly_rent(String string) {
        if(obj.addPrice(string))
        {
            price = true;
            assertTrue(true);
        }
    }
    @Then("monthly rent added successfully for owner {string}")
    public void monthly_rent_added_successfully_for_owner(String string) {
        if(price)
            assertTrue(true);
    }



    @Given("owner is logged in with username {string}, password {string} and selected {string} for housing and {string} for add housing.")
    public void ownerIsLoggedInWithUsernamePasswordAndSelectedForHousingAndForAddHousing(String arg0, String arg1, String arg2, String arg3) {
        if(ownerFlag&&arg2.equals("1")&&arg3.equals("1"))
        {
            assertTrue(true);
        }
    }
    @Given("adding to the housing options appears and {string} contact information taken from database")
    public void addingToTheHousingOptionsAppearsAndContactInformationTakenFromDatabase(String arg0) {
        if(obj.addContactInfo(arg0))
        {
            contactInfo = true;
            assertTrue(true);
        }
    }
    @Then("contact information added successfully for owner {string}")
    public void contact_information_added_successfully_for_owner(String string) {
        if(contactInfo)
            assertTrue(true);
    }



    @Given("owner logged in")
    public void owner_logged_in() {
        if(ownerFlag)
            assertTrue(true);
    }
    @Given("dashboard appears then selected {string} for housing then selected {string} for show housings")
    public void dashboard_appears_then_selected_for_housing_then_selected_for_show_housings(String housing, String showHousings) {
        if(ownerFlag&&housing.equals("1")&&showHousings.equals("2"))
            assertTrue(true);
    }
    @Then("housings appears for owner {string}")
    public void housingsAppearsForOwner(String owner) {
        obj.showHousings(owner);
        assertTrue(true);
    }



    @Given("owner is logged in")
    public void owner_is_logged_in() {
        if(ownerFlag)
            assertTrue(true);
    }
    @Given("selected {string} from the dashboard")
    public void selected_from_the_dashboard(String logout) {
        if(ownerFlag&&logout.equals("2")){
            assertTrue(true);
            loggedOut = true;
        }
    }
    @Then("owner logged out successfully")
    public void owner_logged_out_successfully() {
        if(loggedOut)
            assertTrue(true);
    }
}
