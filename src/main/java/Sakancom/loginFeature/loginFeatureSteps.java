package Sakancom.loginFeature;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class loginFeatureSteps {

    myApp obj;

    //dependecy injection
    //dependecy inversion control (SOLID)
   public loginFeatureSteps(myApp obj){
       super();
       this.obj = obj;
   }

    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("enters {string} as a password")
    public void entersAsAPassword(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("enters {string} as a username")
    public void entersAsAUsername(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("admin login success")
    public void adminLoginSuccess() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("admin page appears")
    public void adminPageAppears() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("tenant wants to sign in")
    public void tenantWantsToSignIn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("enters the right username and password")
    public void entersTheRightUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("tenant login success")
    public void tenantLoginSuccess() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("tenant page appears")
    public void tenantPageAppears() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("owner wants to sign in")
    public void ownerWantsToSignIn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("enters the correct username and password")
    public void entersTheCorrectUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("owner login success")
    public void ownerLoginSuccess() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("owner page appears")
    public void ownerPageAppears() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("admin,tenant or owner wants to login to the system")
    public void adminTenantOrOwnerWantsToLoginToTheSystem() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("the password or username is wrong")
    public void thePasswordOrUsernameIsWrong() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("error appears")
    public void errorAppears() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("stay in login page")
    public void stayInLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("admin, tenant, owner wants to change his password")
    public void adminTenantOwnerWantsToChangeHisPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("the password is the same old password")
    public void thePasswordIsTheSameOldPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("error appears that tells that the password is the same old password")
    public void errorAppearsThatTellsThatThePasswordIsTheSameOldPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the password doesn't change and stay in change password page")
    public void thePasswordDoesnTChangeAndStayInChangePasswordPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("user wants to register as a tenant or owner")
    public void userWantsToRegisterAsATenantOrOwner() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("fill in all or some of the information, and the username is available")
    public void fillInAllOrSomeOfTheInformationAndTheUsernameIsAvailable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("registration complete and the account is created")
    public void registrationCompleteAndTheAccountIsCreated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the tenant or owner can login to his new account")
    public void theTenantOrOwnerCanLoginToHisNewAccount() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("user wants to signup as a tenant or owner")
    public void userWantsToSignupAsATenantOrOwner() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("fill in all or some of the information, and the username is username is unavailable")
    public void fillInAllOrSomeOfTheInformationAndTheUsernameIsUsernameIsUnavailable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("registration fails and error appears")
    public void registrationFailsAndErrorAppears() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Account not created and stay in login page")
    public void accountNotCreatedAndStayInLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
