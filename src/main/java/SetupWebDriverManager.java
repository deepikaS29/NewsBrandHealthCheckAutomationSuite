import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupWebDriverManager {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().forceDownload().setup();
    }
}

