package Sakancom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bookingFeature {
    housingEntity obj=new housingEntity();

    @Given("tenant wants to booking and theres available housing id {string}")
    public void tenantWantsToBooking(String string) {
        boolean flag;
        flag= obj.availableWithID(string);
        assertTrue(flag);

    }

    @And("the tenant typed {string} then type the id {string}")
    public void theTenantTypedThenTypeTheId(String arg0, String arg1) {

        assertTrue(((arg0.equals("Yes") && arg1.equals("1"))&&!test)||test);

    }

    @Then("the booking of housing with id {string} will done and the tenant username is {string}")
    public void theBookingWillDone(String string,String string1) {
        assertTrue(obj.booking(string,string1));
    }

    @Given("tenant doesn't want to booking")
    public void tenantDoesnTWantToBooking() {

        assertTrue(true);
    }
    boolean test=false;
    @And("the tenant typed {string}")
    public void theTenantTyped(String arg0) {

        test=true;
        assertTrue(arg0.equals("No"));
//


    }

    @Then("the booking will not done")
    public void theBookingWillNotDone() {
        assertTrue(true);
    }

    @Given("tenant wants to booking and the house id {string} is not available")
    public void tenantWantsToBookingAndTheHouseIdIsNotAvailable(String arg0) {
        assertFalse(   obj.availableWithID("2"));
    }

    @And("tenant typed {string} then select id {string}")
    public void tenantTypedThenSelectId(String arg0, String arg1) {
        assertTrue(arg0.equals("Yes")&&arg1.equals("2"));
    }

    @Then("the booking will not done for id {string} for username {string}")
    public void theBookingWillNotDoneForId(String arg0,String arg1) {
        assertFalse(obj.booking(arg0,arg1));
    }
}