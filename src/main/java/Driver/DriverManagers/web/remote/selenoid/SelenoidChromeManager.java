package Driver.DriverManagers.web.remote.selenoid;

import ConfigFiles.Factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SelenoidChromeManager {
    private SelenoidChromeManager(){}
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        return new RemoteWebDriver(ConfigFactory.getConfig().selenoidURL(),capabilities);
    }
}
