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
        if(flag){
            assertTrue(true);
        }else{
            assertFalse(true);
        }

    }

    @And("the tenant typed {string} then type the id {string}")
    public void theTenantTypedThenTypeTheId(String arg0, String arg1) {
        if((arg0.equals("Yes") && arg1.equals("1"))&&!test){
            assertTrue(true);
        }
        else if(test){
            assertTrue(true);
        }
        else{
            assertFalse(true);
        }

    }

    @Then("the booking of housing with id {string} will done and the tenant username is {string}")
    public void theBookingWillDone(String string,String string1) {
        if(obj.booking(string,string1)){
            assertTrue(true);
        }
        else {
            assertFalse(true);
        }
    }

    @Given("tenant doesn't want to booking")
    public void tenantDoesnTWantToBooking() {
        assertTrue(true);
    }
    boolean test=false;
    @And("the tenant typed {string}")
    public void theTenantTyped(String arg0) {
        if(arg0.equals("No")){
            test=true;
            assertTrue(true);

        }

    }

    @Then("the booking will not done")
    public void theBookingWillNotDone() {
        assertTrue(true);
    }
}