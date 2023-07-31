package Sakancom.loginFeature;

import Sakancom.tenantEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class controlPanelFeature {

    tenantEntity obj=new tenantEntity();

    @Given("tenant choosed {string} to view control panel")
    public void tenant_choosed_to_view_control_panel_username_is(String string) {
       if(string.equals("3")){
           assertTrue(true);
       }else {
           assertTrue(false);
       }
    }
    @Given("the tenant has house booked before username is {string} the house id is {string}")
    public void the_tenant_has_house_booked_before_username_is(String string,String string2) {
if(obj.checkBooking(string,string2)){
    assertTrue(true);
}
else{
    assertTrue(false);
}
    }
    @Then("the control panel will appear for tenant username {string}")
    public void the_control_panel_will_appear(String string) {
       if(obj.displayBooked(string)){
           assertTrue(true);
       }
       else {
           assertTrue(false);
       }
    }

    @Given("tenant pressed {string} to view the control panel")
    public void tenantPressedToViewTheControlPanel(String arg0) {
        if(arg0.equals("3")){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }

    @And("the tenant didnt booked before username is {string}")
    public void theTenantDidntBookedBeforeUsernameIs(String arg0) {

    }

    @Then("the control panel will not appear for tenant username {string}")
    public void theControlPanelWillNotAppearForTenantUsername(String arg0) {
    }
}
