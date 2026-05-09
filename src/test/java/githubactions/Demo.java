package githubactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author aerok
 * @code @created 09/05/2026
 */
public class Demo {

    protected WebDriver webDriver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        webDriver = new ChromeDriver(options);
    }

    @Test
    public void testCase1(){
        webDriver.get("https://www.google.com");
        System.out.println("Title "+webDriver.getTitle());
    }

    @Test
    public void testCase2(){
        webDriver.get("https://www.stackoverflow.com");
        System.out.println(webDriver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
        }

    }

}
