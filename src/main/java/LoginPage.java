import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By email = By.name("login");
    By password = By.name("password");
    By autorization = By.cssSelector("body > div.content > div.row > div:nth-child(1) > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input");

    public String getLoginLoginTitle(){
        return driver.getTitle();
    }

    public void doLogin(String username, String pwd){
        doSendKeys(email, username);
        doSendKeys(password, pwd);
        doClick(autorization);
    }
}
