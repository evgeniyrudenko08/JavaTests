import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\evgeniy.rudenko\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
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
