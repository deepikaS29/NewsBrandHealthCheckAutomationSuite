package StepDefinition;

import Pages.HomePage;
import Utility.CommonLibrary;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Product_login_newuser_cookie extends CommonLibrary {
    WebDriverWait wait=new WebDriverWait(driver,60);
    @Then("Click on multiple article on home page")
    public void clickonmultipleArticle(DataTable table) {
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String article = (String) data.get("Article");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'"+article+"')])[1]")));
            driver.findElement(By.xpath("(//a[contains(text(),'"+article+"')])[1]")).click();
            String url= driver.getCurrentUrl();
            driver.navigate().to(url+"?articleisfree");
            driver.navigate().back();
            driver.navigate().back();
        }
    }

    @Then("User click the on manage cookies")
    public void clickOnManageCookies() throws InterruptedException {
        //(//*[@class='ot-tgl']/label[@class='ot-switch'])[1]
        driver.findElement(By.xpath("//*[text()='Manage my choices']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[text()='Performance Cookies']")).click();
        driver.findElement(By.xpath("(//*[text()='Performance Cookies']/following::div[@class='ot-tgl']/label[@class='ot-switch'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[text()='Functional Cookies']")).click();
        driver.findElement(By.xpath("(//*[text()='Functional Cookies']/following::div[@class='ot-tgl']/label[@class='ot-switch'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Confirm My Choices']")).click();
    }

}
