import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setUpTest(String browser){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("no browser is defined in xml file");
        }
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\chromedriver_win32\\chromedriver.exe");

        wait = new WebDriverWait(driver, 15);
        driver.manage().window().fullscreen();
        driver.get("http://users.bugred.ru/user/login/index.html");
        page = new Page(driver, wait);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
