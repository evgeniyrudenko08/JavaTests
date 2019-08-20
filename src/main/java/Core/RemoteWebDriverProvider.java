package Core;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteWebDriverProvider implements WebDriverProvider{
    
    @Override
    public RemoteWebDriver createDriver (DesiredCapabilities desiredCapabilities)
    {
        try {
            return new RemoteWebDriver(
                    URI.create("http://ondemand.eu-central-l.saucelabs.com/wd/hub").toURL(), getSauceLabs());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities getSauceLabs(){
        DesiredCapabilities sauceLabs = DesiredCapabilities.chrome();

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "Sava12345");
        sauceOptions.setCapability("accessKey", "c09fdfll-e5dd-473e-b64b-3b65d06665cd");

        sauceLabs.setCapability("platform", "Windows 10");
        sauceLabs.setCapability("version", "75.0");

        return sauceLabs;
    }
}
