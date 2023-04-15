package Pages;

import Utility.CommonLibrary;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollersPage extends CommonLibrary {

    @FindBy(xpath="(//a[contains(@href,'category') and @class='breadcrumb__link'])[2]")
    WebElement lnkCategory;
    @FindBy(xpath="(//span[text()='Tags']/following::h3[contains(text(),'More from')])[1]")
    WebElement elmMorefromcategory;


    public ScrollersPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCategory(){
        boolean flg=false;
        try{
            flg=lnkCategory.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
        }

        return flg;
    }

    public boolean verifyMorefromCategory(){
        boolean flg=false;
        try{
            flg=elmMorefromcategory.isDisplayed();
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true)",elmMorefromcategory);
        }catch(Exception e){
            e.printStackTrace();
        }
        return flg;
    }

}
