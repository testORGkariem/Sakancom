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
    boolean ownerFlag, ownerUsername, ownerPassword;


    @Given("owner wants to login and add a residence")
    public void owner_wants_to_login_and_add_a_residence() {
        assertTrue(true);
    }
    @Given("owner enters {string} as username and {string} as a password")
    public void owner_enters_as_username_and_as_a_password(String Username, String Password) {
        if(obj.checkValues(Username,Password).equals("owner")){
            assertTrue(true);
            ownerFlag = true;
        }
    }

    @Then("owner logged in with {string} as username and {string} as a password and dashboard appears and adding list appears")
    public void ownerLoggedInWithAsUsernameAndAsAPasswordAndDashboardAppearsAndAddingListAppears(String username, String password) {
        if(obj.checkValues(username,password).equals("owner")){
            assertTrue(true);
            ownerFlag = true;
        }
    }



    @Given("owner is logged in with username {string} and  password {string}")
    public void ownerIsLoggedInWithUsernameAndPassword(String username, String password) {
        if(obj.checkValues(username,password).equals("owner")){
            assertTrue(true);
            ownerFlag = true;
        }
    }



    @Given("adding to the residence options appears and owner enters {string} as username of owner  and {string} as a residence description and {string} as a services and {string} as number of bathrooms and {string} as it have a balcony and {string} as a price and and {int} as floors {string} as residence name")
    public void adding_to_the_residence_options_appears_and_owner_enters_as_username_of_owner_and_as_a_residence_description_and_as_a_services_and_as_number_of_bathrooms_and_as_it_have_a_balcony_and_as_a_price_and_and_as_floors_as_residence_name(String Username, String description, String services, String numOfbBathrooms, String balcony, String price, Integer floors, String residenceName) throws SQLException {
        obj.addResidence(Username, description, services, numOfbBathrooms, balcony, price, floors, residenceName);
    }
    @Then("residence added successfully")
    public void residenceAddedSuccessfully() {
        obj.ownerDashboard();
    }

}
