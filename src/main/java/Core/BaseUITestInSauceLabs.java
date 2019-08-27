package Core;

import com.codeborne.selenide.Configuration;


public class BaseUITestInSauceLabs {
    public void setUp() {
        Configuration.baseUrl = "http://167.71.169.4";
        Configuration.browser = "Core.RemoteWebDriverProvider";
        Configuration.timeout=6000;
    }
}
