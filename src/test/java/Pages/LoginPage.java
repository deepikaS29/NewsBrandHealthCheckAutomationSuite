package Pages;

import Utility.CommonLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonLibrary {

    @FindBy(xpath="(//a[text()='Log In'])[2]")
    WebElement login_lnk;

    @FindBy(xpath="//*[text()='The email address or password you entered are incorrect.']")
    WebElement elm_errorMsg;

    @FindBy(id="login_email")
    WebElement email_edt;
    @FindBy(id="login_pass")
    WebElement password_edt;
    @FindBy(xpath="//button[text()='Login']")
    WebElement login_btn;
    @FindBy(id="onetrust-accept-btn-handler")
    WebElement accept_btn;
    @FindBy(xpath="(//a[text()='My Account'])[2]")
    WebElement myaccount_lnk;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public void click_accept_btn(){
        accept_btn.click();
    }

    public void click_login_lnk(){
        login_lnk.click();
    }

    public void enter_EmailID(String emailID) {
        email_edt.clear();
        email_edt.sendKeys(emailID);
    }

    public void enter_Password(String password){
        password_edt.clear();
        password_edt.sendKeys(password);
    }

    public void click_login_btn(){
        login_btn.click();
    }


    public boolean verifyMyAccount_lnk(){
        return myaccount_lnk.isDisplayed();
    }

    public boolean verify_errorMsg() {
        boolean flg=false;
        WebDriverWait wait=new WebDriverWait(driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='The email address or password you entered are incorrect.']")));
            flg=elm_errorMsg.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flg;
    }






}
