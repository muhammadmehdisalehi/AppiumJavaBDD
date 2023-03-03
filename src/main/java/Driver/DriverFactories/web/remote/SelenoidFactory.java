package Driver.DriverFactories.web.remote;

import ConfigFiles.enums.BrowserType;
import Driver.DriverManagers.web.remote.selenoid.SelenoidChromeManager;
import Driver.DriverManagers.web.remote.selenoid.SelenoidFireFoxManager;
import org.openqa.selenium.WebDriver;

public final class SelenoidFactory {
    private SelenoidFactory(){}
    public static WebDriver getDriver(BrowserType browserType){
        return isaChromeBrowser(browserType)
                ? SelenoidChromeManager.getDriver()
                : SelenoidFireFoxManager.getDriver();
    }

    private static boolean isaChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

}
