package StepDefinition;

import Pages.RegistrationPage;
import Utility.CommonLibrary;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class TheCourierRegisterUSer extends CommonLibrary {

    RegistrationPage registrationPage=new RegistrationPage();

    @When("User click on Click here to Register link")
    public void user_click_on_click_here_to_register_link() {
       // driver.findElement(By.xpath("//*[@id=\"form-login-register-wall\"]/form[2]/span[1]/a")).click();
        registrationPage.click_register_link();
    }

    @And("Clear cookies for the site")
    public void clear_cookies() {
        driver.manage().deleteAllCookies();
    }



    @Then("Register page is open")
    public void register_page_is_open() {
        boolean IsDisplayed=registrationPage.verifyRegister_header();
       Assert.assertTrue("Register page not displayed",IsDisplayed);
        if (IsDisplayed) {
            System.out.println("Register Page is open");
        } else {
            System.out.println("Register Page is not open");
        }
    }

    @Given("User enter EmailID and password")
    public void user_enter_email_id(DataTable table) throws  Exception{
        //System.out.println("Email id " + EmailId);
        //driver.findElement(By.id("reg_email")).sendKeys(EmailId);
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String EmailId = (String) data.get("Email");
            String password = (String) data.get("Password");
            System.out.println(EmailId+" - "+password);
            registrationPage.enterRegister_EmailId(EmailId);
            registrationPage.enterRegister_Password(password);
            registrationPage.click_CreateAccount_btn();
            boolean error_msg=registrationPage.verifyError_msg();
            Assert.assertTrue("Error message is not displayed",error_msg);
        }
    }

    @Given("Enter register email Id {string}")
    public void user_enter_email_id(String emailId) throws  Exception{
        registrationPage.enterRegister_EmailId(emailId);
    }

    @Given("Enter register password {string}")
    public void user_enter_password(String Password) {
        System.out.println("Password " + Password);
        //driver.findElement(By.id("reg_pass")).sendKeys(Password);
        registrationPage.enterRegister_Password(Password);
    }

    @When("User hit the Create your account button")
    public void user_hit_the_create_your_account_button() {
        //driver.findElement(By.xpath("//*[@id=\"form-login-register-wall\"]/form[1]/div[2]/button")).click();
        registrationPage.click_CreateAccount_btn();
    }

    @Then("User should navigates to The courier home page")
    public void user_should_navigates_to_the_courier_home_page() {
        //String expectedURL = "https://www.thecourier.co.uk/login/";
        String expectedURL =properties.getProperty("homepageURL");
        String actualURl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURl);
        System.out.println("Home Page");
    }

    @And("verify error message")
    public void verify_Registration_error_msg() {
       // boolean MyAccount = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[2]/a")).isDisplayed();
        boolean error_msg=registrationPage.verifyError_msg();
        Assert.assertTrue("Error message is not displayed",error_msg);

    }



}
