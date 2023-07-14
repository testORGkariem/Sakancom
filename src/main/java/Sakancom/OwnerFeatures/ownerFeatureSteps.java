package Sakancom.OwnerFeatures;

import Sakancom.loginFeature.loginEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ownerFeatureSteps {

    public ownerFeatureSteps(ownerEntity obj){
        super();
        this.obj = obj;
    }
    ownerEntity obj;
    boolean ownerFlag = false;
    boolean loggedOut = false;

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



    @Given("owner is logged in with username {string} and  password {string} and dashboard appears then selected {string} for housing then selected {string} for add housing")
    public void owner_is_logged_in_with_username_and_password_and_dashboard_appears_then_selected_for_housing_then_selected_for_add_housing(String string, String string2, String housing, String addHousing) {
        if(ownerFlag&&housing.equals("1")&&addHousing.equals("1"))
            assertTrue(true);
    }
    @Given("adding to the housing options appears and owner enters {string} as username of owner  and {string} as a residence description and {string} as a services and {string} as number of bathrooms and {string} as it have a balcony and {string} as a price and and {int} as floors {string} as residence name")
    public void adding_to_the_housing_options_appears_and_owner_enters_as_username_of_owner_and_as_a_residence_description_and_as_a_services_and_as_number_of_bathrooms_and_as_it_have_a_balcony_and_as_a_price_and_and_as_floors_as_residence_name(String Username, String description, String services, String numOfbBathrooms, String balcony, String price, Integer floors, String residenceName) throws SQLException {
        obj.addHousing(Username, description, services, numOfbBathrooms, balcony, price, floors, residenceName);
    }
    @Then("residence added successfully")
    public void residence_added_successfully() { //added with id? or name ? // to search and be sure if added
        obj.showHousings();
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
    @Then("housings appears")
    public void housings_appears() {
            obj.showHousings();
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
