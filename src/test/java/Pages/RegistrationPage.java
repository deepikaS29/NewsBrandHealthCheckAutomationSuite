package Pages;

import Utility.CommonLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends CommonLibrary {

    @FindBy(linkText="Click here to register")
    WebElement register_lnk;
    @FindBy(xpath="(//p[@class='blaize-error'])[1]")
    WebElement error_msg;
    @FindBy(xpath="//div[contains(text(),'Register')]")
    WebElement header_Register;
    @FindBy(id="reg_email")
    WebElement reg_email_edt;
    @FindBy(id="reg_pass")
    WebElement reg_password_edt;
    @FindBy(xpath="//button[contains(text(),'Create your account')]")
    WebElement CreateAccount_btn;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }
    public void click_register_link(){
        register_lnk.click();
    }

    public void enterRegister_EmailId(String mailId){
        reg_email_edt.clear();
        reg_email_edt.sendKeys(mailId);
    }
    public void enterRegister_Password(String pwd){
        reg_password_edt.clear();
        reg_password_edt.sendKeys(pwd);
    }
    public void click_CreateAccount_btn(){
        CreateAccount_btn.click();
    }

   public boolean verifyRegister_header(){
       return header_Register.isDisplayed();
   }

    public boolean verifyError_msg(){
        boolean flg=false;
        WebDriverWait wait=new WebDriverWait(driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='blaize-error'])[1]")));
            flg=error_msg.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flg;
    }

}
