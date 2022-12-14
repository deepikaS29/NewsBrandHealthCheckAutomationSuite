package StepDefinition;

import Pages.LoginPage;
import Pages.ScrollersPage;
import Utility.CommonLibrary;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class Scrollers extends CommonLibrary {
    ScrollersPage scrollersPage=new ScrollersPage();
    WebDriverWait wait=new WebDriverWait(driver,60);

    @Then("verify the respective category in the page after selecting article")
    public void verifyCategory() throws InterruptedException {
        //String expectedURL = "";
        boolean b=scrollersPage.verifyCategory();
        Assert.assertTrue("Category is not appearing",b);
        WebElement morefrom_horizomtal=driver.findElement(By.xpath("(//div[@class='horizontal-scroller-headline-container']/h3[contains(text(),'More from')]/following::div[@class='fullslider slick-initialized slick-slider slick-dotted'])[1]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",morefrom_horizomtal);
        Thread.sleep(2000);
        List<WebElement> elms=morefrom_horizomtal.findElements(By.xpath("//h5[@class='hs-title title--sm']/a[@data-track-id='more from']"));
        System.out.println(elms.size());


    }



    @Then("Click on any article on home page")
    public void clickonArticle(DataTable table) {
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String article = (String) data.get("Article");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'"+article+"')])[1]")));
            driver.findElement(By.xpath("(//a[contains(text(),'"+article+"')])[1]")).click();
           String url= driver.getCurrentUrl();
           driver.navigate().to(url+"?articleisfree");
        }
    }


    @Then("verify the below horizontal scrollers present in the page after selecting article")
    public void verifyhorizontalscrollers(DataTable table) throws  Exception{
        boolean flg=false;
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String scrollers = (String) data.get("HorizontalScrollers");
            try{
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3[text()='"+scrollers+"'])[1]")));
                boolean b=driver.findElement(By.xpath("(//h3[text(),'"+scrollers+"'])[1]")).isDisplayed();
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//h3[text(),'"+scrollers+"'])[1]")));
                flg=true;
            }catch(Exception e){
                e.printStackTrace();
            }
            Assert.assertTrue(scrollers+" horizontal scroller is not displayed",flg);
        }
    }


    @Then("verify the below vertical scrollers present in the page after selecting article")
    public void verifyverticalscrollers(DataTable table) throws  Exception{
        boolean flg=false;
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String scrollers = (String) data.get("VerticalScrollers");
            try{
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3[contains(text(),'"+scrollers+"')])[1]")));
                boolean b=driver.findElement(By.xpath("(//h3[contains(text(),'"+scrollers+"')])[1]")).isDisplayed();
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//h3[contains(text(),'"+scrollers+"')])[1]")));
                flg=true;
            }catch(Exception e){
                e.printStackTrace();
            }
            Assert.assertTrue(scrollers+" vertical scroller is not displayed",flg);
        }
    }


    @Then("verify the scrollers are present under conversation section")
    public void verifyScrollers_InConversation(DataTable table) throws  Exception{
        boolean flg=false;
        for(Map<Object, Object> data:table.asMaps(String.class,String.class)) {
            String scrollers = (String) data.get("Scrollers");
            try{
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'"+scrollers+"')]/preceding::h3[text()='Conversation']")));
                boolean b=driver.findElement(By.xpath("//h3[contains(text(),'"+scrollers+"')]/preceding::h3[text()='Conversation']")).isDisplayed();
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h3[contains(text(),'"+scrollers+"')]/preceding::h3[text()='Conversation']")));
                flg=true;
            }catch(Exception e){
                e.printStackTrace();
            }
            Assert.assertTrue(scrollers+" scroller is not displayed under Conversation",flg);
        }
    }




}








