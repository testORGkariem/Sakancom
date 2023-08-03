package Sakancom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class showLivedInFeature {
    showLivedIn obj=new showLivedIn();
    @Given("tenant pressed {string} to view peoples lived in houses")
    public void tenantPressedToViewPeoplesLivedInHouses(String arg0) {

        assertTrue(arg0.equals("4"));

    }

    @And("theres peoples in houses id {string}")
    public void theresPeoplesInHousesId(String arg0) {

        assertTrue(obj.isLived(arg0));


    }

    @Then("the peoples username will appear in house id {string}")
    public void thePeoplesUsernameWillAppear(String string) {

        assertTrue(obj.displayLived(string));

    }

    @Given("tenant pressed {string} to view peoples who lived in house")
    public void tenantPressedToViewPeoplesWhoLivedInHouse(String arg0) {

        assertTrue(arg0.equals("4"));

    }
    @And("theres no peoples in houses id {string}")
    public void theresNoPeoplesInHousesId(String arg0) {

        assertTrue(!obj.isLived(arg0));

    }

    @Then("this peoples username will not appear in house id {string}")
    public void thisPeoplesUsernameWillNotAppear(String string) {

        assertTrue(!obj.displayLived(string));


    }



}