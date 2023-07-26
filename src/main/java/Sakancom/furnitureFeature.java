package Sakancom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class furnitureFeature {
    Furniture obj=new Furniture();
    @Given("tenant typed {int} to view his furnitures")
    public void tenant_typed_to_view_his_furnitures(Integer int1) {
        if(int1==1){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }
    boolean avb=false;
    @Given("the tenant has available furnitures the tenant username is {string}")
    public void the_tenant_has_available_furnitures(String string) {
        boolean flag= obj.checkAvailability(string);
        if(flag){
            avb=true;
            assertTrue(true);
        }
        else {
            avb=false;
            assertTrue(false);
        }
    }
    @Then("the program will appear the furnitures for username {string}")
    public void the_program_will_appear_the_furnitures(String string) {
        if(avb){
            obj.displayFurniture(string);
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }

    }

    @Given("tenant typed {int} to show his furnitures")
    public void tenant_typed_to_show_his_furnitures(Integer int1) {
        if(int1==1){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }
    boolean avb1=false;
    @Given("the tenant doesn't have available furnitures the tenant username is {string}")
    public void the_tenant_doesn_t_have_available_furnitures(String string) {
        boolean flag=obj.checkAvailability(string);
        if(flag){
            avb1=false;
            assertTrue(false);

        }
        else{
            avb1=true;
            assertTrue(true);
        }
    }
    @Then("the program will not appear the furnitures")
    public void the_program_will_not_appear_the_furnitures() {
        if(avb1){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }
    @Given("tenant typed {string} to choose add option to add furniture")
    public void tenant_wants_to_add_furniture(String string) {
        if(string.equals("2")){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }

    @Then("the program will appear window to add furniture has these informations username is {string} and Picture is {string} and Description is {string} and Price is {string} and ID is {string} and selled is {string}")
    public void theProgramWillAppearWindowToAddFurnitureHasTheseInformationsUsernameIsAndPrictureIsAndDescriptionIsAndPriceIsAndIDIsAndSelledIs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        boolean flag= obj.addFurniture(arg0, arg1, arg2, arg3, arg4, arg5);
        if(flag){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

    @Given("tenant typed {string} to Sell his furniture id is {string}")
    public void tenantTypedToSellHisFurnitureIdIs(String arg0, String arg1) {
        if(arg0.equals("3" )&& arg1.equals("1")){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }

    @And("furniture id is {string} its available to sell and the tenant username is {string}")
    public void furnitureIdIsItsAvailableToSellAndTheTenantUsernameIs(String arg0, String arg1) {
        boolean flag= obj.checkAvailability(arg1,arg0);
        if(flag){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }

    }


    @Then("the program will sell the furniture id {string} username is {string}")
    public void theProgramWillSellTheFurnitureId(String arg0,String arg1) {
        if( obj.sellFurniture(arg1,arg0)){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }


    @Given("tenant typed {string} to sell his furniture id is {string}")
    public void tenantTypedTosellHisFurnitureIdIs(String arg0, String arg1) {
        if(arg0.equals("3" )&& arg1.equals("2")){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }

    @And("furniture id is {string} its not available to sell and the tenant username is {string}")
    public void furnitureIdIsItsNotAvailableToSellAndTheTenantUsernameIs(String arg0, String arg1) {
        boolean flag= obj.checkAvailability(arg1,arg0);
        if(flag){
            assertTrue(false);
        }
        else {
            assertTrue(true);
        }
    }

    @Then("the program will not sell the furniture id {string} username is {string}")
    public void theProgramWillNotSellTheFurnitureId(String arg0,String arg1) {
        if( obj.sellFurniture(arg1,arg0)){
            assertTrue(false);
        }
        else{
            assertTrue(true);
        }
    }
}