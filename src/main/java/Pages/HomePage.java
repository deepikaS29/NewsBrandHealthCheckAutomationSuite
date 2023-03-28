package Pages;

import Utility.CommonLibrary;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends CommonLibrary {

    @FindBy(xpath="(//*[text()='Menu'])[2]")
    WebElement elmMenu;
    @FindBy(xpath="(//button[contains(@class,'search-form')])[3]")
    WebElement iconSearch;
    @FindBy(xpath="(//button[text()='Go'])[2]")
    WebElement btnGo;

    @FindBy(xpath="(//*[@title='Search'])[2]")
    WebElement edt_Search;

    @FindBy(xpath="//span[@class='results__count']")
    WebElement elmResultcnt;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public void click_Menu_Icon(){
        elmMenu.click();
    }
    public void click_Search_Icon() throws InterruptedException {
        Thread.sleep(2000);
        iconSearch.click();
    }

    public void enterSearchbox(String searchval){
        edt_Search.sendKeys(searchval);
    }

    public int getResultcount(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='results__count']")));
        String cnt=elmResultcnt.getText();
        int actualcount=Integer.parseInt(cnt);
        return actualcount;
    }

    public void clickGobtn() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btnGo);
       // btnGo.click();
    }

    public void takeScreenshot(String fileName) throws IOException {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String filePath = "C:\\Test Automation\\NewsBrand\\Automation\\TheCourierHealthCheck\\target\\" + fileName + "-" + timestamp + ".png";
        FileUtils.copyFile(screenshotFile, new File(filePath));
    }



}
