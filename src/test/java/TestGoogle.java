import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestGoogle {

    private WebDriver driver;
    Logging logs = new Logging();

    @BeforeSuite
    public static void Setup() {
        DOMConfigurator.configure("src/main/java/resources/Log4j.xml");
    }

    @Test
    private void FindCheeseInGoogle() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\chromedriver_win32\\chromedriver.exe");
            logs.logger.info("Start driver");
            driver = new ChromeDriver();

            driver.navigate().to("http://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Cheese!");
            element.submit();
            System.out.println("Page title is: " + driver.getTitle());
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("cheese!");
                }
            });
            System.out.println("Page title is: " + driver.getTitle());
            logs.logger.info("Finish test");
            Assert.assertEquals(driver.getTitle(), "Cheese! - Пошук Google");
    }

    @Test
    public void FindCheeseInGoogleWithFirefox () {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Cheese! - Пошук Google");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
