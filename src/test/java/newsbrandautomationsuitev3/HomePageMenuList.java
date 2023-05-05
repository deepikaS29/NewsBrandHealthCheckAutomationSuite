package newsbrandautomationsuitev3;

import Pages.HomePage;
import utilities.CommonLibrary;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class HomePageMenuList extends CommonLibrary {

    HomePage homePage=new HomePage();


    @When("Click on Menu option")
    public void clickMenuOption() {

        homePage.click_Menu_Icon();
    }

    @Then("Verify all links like News,Politics,Sports,Lifestyle etc")
    public void verifyMenuOptions(DataTable table) throws  Exception{

        for(Map<String,String> data:table.asMaps(String.class,String.class)) {
            String menuoption = (String) data.get("MenuOptions");
            boolean flg=false;
            try{
                flg=driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='"+menuoption+"']")).isDisplayed();
            }catch(Exception e) {
                e.printStackTrace();
            }
            Assert.assertTrue(menuoption+" link is not displayed under Menu",flg);
        }
    }

    @Then("verify and click all tabs like News,Politics,Sports,Lifestyle etc")
    public void verifyMenuTabOptions(DataTable table) throws Exception {
        for(Map<String,String> data:table.asMaps(String.class,String.class)) {
            String menuoption = (String) data.get("MenuOptions");
            boolean flg=false;
            try{
                flg=driver.findElement(By.xpath("//ul[@class='nav-bar clearfix wrap']/li[contains(@id,'menu-item')]/a[text()='"+menuoption+"']"))
                        .isDisplayed();
                driver.findElement(By.xpath("//ul[@class='nav-bar clearfix wrap']/li[contains(@id,'menu-item')]/a[text()='"+menuoption+"']"))
                        .click();
                Thread.sleep(2000);
                String url=driver.getCurrentUrl();
                if(menuoption.contains("Courier Investigations")){
                    menuoption="Investigations";
                }
                if(menuoption.contains("&")){
                    menuoption=menuoption.replace("&","-");
                }
                Assert.assertTrue(menuoption+" Page is not displayed",url.contains(menuoption.toLowerCase()));
                takeScreenshot(); // take screenshot after each page is visited
                driver.navigate().back();
            } catch(Exception e) {
                e.printStackTrace();
            }
            Assert.assertTrue(menuoption+" Menu tab is not displayed under Menu",flg);
        }
    }

    @And("Take screenshot of the page")
    public void takeScreenshot() throws Exception{
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        homePage.takeScreenshot("screenshot-" + timestamp);
    }

    @When("click on searchIcon and enter keyword {string}")
    public void clickSearchIconanEnter(String val) throws  Exception{
        homePage.click_Search_Icon();
        homePage.enterSearchbox(val);
        homePage.clickGobtn();
    }


    @When("click Go button")
    public void clickGobutton() throws  Exception{
        homePage.clickGobtn();
    }

    @Then("verify the search details {string}")
    public void verifySearchdetails(String val) throws  Exception{
        int count=homePage.getResultcount();
        Assert.assertTrue(val+" details not found",count>0);
    }
}

