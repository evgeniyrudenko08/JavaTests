package Core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;


public class BaseUITestInSauceLabs {
    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "http://167.71.169.4";
        Configuration.browser = "Core.RemoteWebDriverProvider";
        Configuration.timeout=6000;
    }
}
