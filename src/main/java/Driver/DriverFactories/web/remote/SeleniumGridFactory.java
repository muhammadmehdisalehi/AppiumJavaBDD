package Driver.DriverFactories.web.remote;

import ConfigFiles.enums.BrowserType;
import Driver.DriverManagers.web.remote.seleniumGrid.SeleniumGridFireFoxManager;
import Driver.DriverManagers.web.remote.seleniumGrid.SeleniumGridChromeManager;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {
    private SeleniumGridFactory(){}
    public static WebDriver getDriver(BrowserType browserType){
        return isaChromeBrowser(browserType)
                ? SeleniumGridChromeManager.getDriver()
                : SeleniumGridFireFoxManager.getDriver();
    }

    private static boolean isaChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

}
