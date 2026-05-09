package githubactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
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
@Epic("Web UI Automation")
@Feature("Search Engine and Q&A Tests")
public class Demo {

    protected WebDriver webDriver;

    @BeforeMethod
    @Step("Setting up Chrome WebDriver")
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        webDriver = new ChromeDriver(options);
    }

    @Test(description = "Verify Google Homepage")
    @Description("This test navigates to Google and prints the page title.")
    @Severity(SeverityLevel.NORMAL)
    public void testCase1(){
        navigateToUrl("https://www.google.com");
        printPageTitle();
    }

    @Test(description = "Verify StackOverflow Homepage")
    @Description("This test navigates to StackOverflow and prints the page title.")
    @Severity(SeverityLevel.NORMAL)
    public void testCase2(){
        navigateToUrl("https://www.stackoverflow.com");
        printPageTitle();
    }

    @Step("Navigating to URL: {0}")
    public void navigateToUrl(String url) {
        webDriver.get(url);
    }

    @Step("Printing the page title")
    public void printPageTitle() {
        System.out.println("Title " + webDriver.getTitle());
    }

    @AfterMethod
    @Step("Tearing down WebDriver")
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
        }
    }

}
