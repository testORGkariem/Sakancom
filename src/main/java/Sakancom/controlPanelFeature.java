package Sakancom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class controlPanelFeature {

    boolean loggedIn = false;
    boolean loggedOut = false;
    ControlPanel obj=new ControlPanel();

    @Given("tenant choosed {string} to view control panel")
    public void tenant_choosed_to_view_control_panel_username_is(String string) {
        assertTrue(string.equals("3"));
        boolean loggedIn = false;

    }
    @Given("the tenant has house booked before username is {string}")
    public void the_tenant_has_house_booked_before_username_is(String string) {
        assertTrue(obj.isBooked(string));
    }
    @Then("the control panel will appear for tenant username {string}")
    public void the_control_panel_will_appear(String string) {
        assertTrue(obj.displayControlPanel(string));
    }

    @Given("tenant pressed {string} to view the control panel")
    public void tenantPressedToViewTheControlPanel(String arg0) {
        assertTrue(arg0.equals("3"));
    }

    @And("the tenant didnt booked before username is {string}")
    public void theTenantDidntBookedBeforeUsernameIs(String arg0) {
        assertFalse(obj.isBooked(arg0));
    }

    @Then("the control panel will not appear for tenant username {string}")
    public void theControlPanelWillNotAppearForTenantUsername(String arg0) {
        assertFalse(obj.displayControlPanel(arg0));
    }

    @Given("tenant is logged in")
    public void tenantIsLoggedIn() {
        assertTrue(loggedIn);
    }
    @Given("selected {string} from tenant dashboard")
    public void selectedFromTenantDashboard(String string) {
        assertTrue(string.equals("4"));
        loggedOut = false;
    }
    @Then("tenant logged out successfully")
    public void tenantLoggedOutSuccessfully() {
        assertTrue(loggedOut);
    }

//    @Given("user choosed {string} to view control panel")
//    public void userChoosedToViewControlPanel(String arg0) {
//    }
}