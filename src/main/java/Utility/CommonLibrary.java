package Utility;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class CommonLibrary {

    public static WebDriver driver;
    public static Properties properties;
    public CommonLibrary(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("/root/project/src/test/Config/Env.properties");
            properties=new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openBrowser() {
        if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe");
            if(properties.getProperty("extension").equalsIgnoreCase("Yes")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addExtensions(new File(("C:\\AdBlock best ad blocker.crx")));
                DesiredCapabilities capabilities=DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                driver=new ChromeDriver(capabilities);
            }else{
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }

        }else if(properties.getProperty("browser").equalsIgnoreCase("firefox")){
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if(properties.getProperty("browser").equalsIgnoreCase("edge")) {
            //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("applcation_URL"));
    }

    public void  closeBrowser() {
        driver.quit();
    }
}
