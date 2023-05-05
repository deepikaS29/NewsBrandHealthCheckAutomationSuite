package newsbrandautomationsuitev3;

import Pages.LoginPage;
import org.junit.Assert;
import utilities.CommonLibrary;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class TheCourierLoginStepDefinition extends CommonLibrary {
    LoginPage loginPage=new LoginPage();
    @Given("Launch The Courier URL {string}")
    public void launch_the_courier_url(String url) {
        System.out.println("Home Page" + url);
        //driver.get(url);
    }


    @Given("User click the i accept button")
    public void u_ser_click_the_i_accept_button() {
        // driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        loginPage.click_accept_btn();
        System.out.println("User accepted the privacy terms and conditions");
    }

    @When("User hit the login link")
    public void user_hit_the_login_link() throws InterruptedException {
        // driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[2]/a")).click();
        loginPage.click_login_lnk();
        Thread.sleep(2000);
        //This is a comment for git demo
    }

    @Then("Login page is open")
    public void login_page_is_open() {
        //String expectedURL = "https://www.thecourier.co.uk/login/";
        String expectedURL=properties.getProperty("loginURL");
        String actualURl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURl);
        System.out.println("Login Page");
    }


    @Given("User enter login EmailID and password")
    public void user_enter_email_id(DataTable table) throws  Exception{
        //System.out.println("Email id " + EmailId);
        //driver.findElement(By.id("reg_email")).sendKeys(EmailId);
        for(Map<String, String> data:table.asMaps(String.class,String.class)) {
            String EmailId = (String) data.get("Email");
            String password = (String) data.get("Password");
            System.out.println(EmailId+" - "+password);
            loginPage.enter_EmailID(EmailId);
            loginPage.enter_Password(password);
            loginPage.click_login_btn();
            boolean error_msg=loginPage.verify_errorMsg();
            Assert.assertTrue("Error message is not displayed",error_msg);
        }
    }


    @Given("Enter registered email id {string}")
    public void enter_registered_email_id(String emailID) {
        loginPage.enter_EmailID(emailID);
    }

    @Given("Enter valid password {string}")
    public void enter_valid_password(String password) {
        loginPage.enter_Password(password);
    }

    @When("User click on login button")
    public void user_click_on_login_button() {
        //driver.findElement(By.xpath("//*[@id=\"form-login-register-wall\"]/form[2]/div[2]/button")).click();
        loginPage.click_login_btn();
    }

    @Then("User  navigates to The courier home page")
    public void user_navigates_to_the_courier_home_page() throws InterruptedException {
        //String expectedURL = "";
        Thread.sleep(2000);
        String expectedURL =properties.getProperty("homepageURL");
        String actualURl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURl);
        System.out.println("Home Page");
    }

    @Then("Login Replaced with My Account link")
    public void login_replaced_with_my_account_link() {
        // boolean MyAccount = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[2]/a")).isDisplayed();
        boolean MyAccount=loginPage.verifyMyAccount_lnk();
        Assert.assertTrue("My account link is not displayed",MyAccount);
        if (MyAccount) {
            System.out.println("User account is open");
        } else {
            System.out.println("Account not created");

        }
    }

    @Then("Verify the user is not logged out")
    public void verify_user_not_loggedout(){
        // boolean MyAccount = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[2]/a")).isDisplayed();
        boolean MyAccount=loginPage.verifyMyAccount_lnk();
        Assert.assertTrue("My account link is not displayed",MyAccount);
        if (MyAccount) {
            System.out.println("logged in");
        } else {
            System.out.println("logged out");

        }
    }


}
