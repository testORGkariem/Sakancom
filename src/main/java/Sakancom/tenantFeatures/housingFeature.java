package Sakancom.tenantFeatures;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class housingFeature {
    housingEntity obj=new housingEntity();
    boolean appear=false;

    @Given("tenant wants to view the available housing")
    public void tenant_wants_to_view_the_available_housing() {

        assertTrue(true);

    }
    @Given("the tenant choose {string} to view the available housing")
    public void the_tenant_choose_to_view_the_available_housing(String string) {
        if(string.equals("1")){
            appear=true;
            assertTrue(true);
        }else {
            assertTrue("Theres no Available housing",false);
        }
    }
    @Then("the Available housing appear")
    public void the_available_housing_appear() {
        int counter=obj.showAvailable();
        if(counter>1){
            assertTrue(true);
        }
        else {
            assertTrue("The available doesn't appear",false);
        }


    }



    @Given("tenant wants to view the available housing but theres no available")
    public void tenant_wants_to_view_the_available_housing_but_theres_no_available() {
        assertTrue(true);
    }
    @Given("the tenant choose {int} to view the available housing")
    public void the_tenant_choose_to_view_the_available_housing(Integer int1) {
        if(int1==1){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }
    @Then("the Available housing doesn't appear")
    public void the_available_housing_doesn_t_appear() {
        System.out.println("theres no available housing");

        if(appear){
            assertTrue(false);
        }
        else{
            assertTrue(true);
        }
    }
}
