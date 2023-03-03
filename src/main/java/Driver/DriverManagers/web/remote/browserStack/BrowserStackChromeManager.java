package Driver.DriverManagers.web.remote.browserStack;

import ConfigFiles.Factory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackChromeManager {
    private BrowserStackChromeManager(){}
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(),capabilities);
    }
}
