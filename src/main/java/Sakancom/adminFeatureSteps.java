package Sakancom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class adminFeatureSteps {
boolean admin = false;
    public adminFeatureSteps(adminEntity obj){
        super();
   //     this.obj = obj;
    }
   // obj adminEntity = new adminEntity();
    @Given("admin logged in with {string} as username and {string} as password and dashboard appears")
    public void admin_logged_in_with_as_username_and_as_password_and_dashboard_appears(String string, String string2) {
       // if()
    }
    @Given("selected {string} from dashboard and see the pending features")
    public void selected_from_dashboard_and_see_the_pending_features(String string) {

    }
    @Given("selected one of the pending housings")
    public void selected_one_of_the_pending_housings() {

    }
    @Given("Selected {string} to accept the housing or {string} to rejects it")
    public void selected_to_accept_the_housing_or_to_rejects_it(String string, String string2) {
    }
    @Then("housing accepted or rejected")
    public void housing_accepted_or_rejected() {

    }



    @Given("admin is logged in")
    public void admin_is_logged_in() {


    }
    @Given("selected {string} from admin dashboard")
    public void selected_from_admin_dashboard(String string) {


    }
    @Then("admin logged out successfully")
    public void admin_logged_out_successfully() {


    }





}
