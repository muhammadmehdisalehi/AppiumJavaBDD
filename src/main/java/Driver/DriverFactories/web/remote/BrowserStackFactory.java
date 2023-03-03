package Driver.DriverFactories.web.remote;

import ConfigFiles.enums.BrowserType;
import Driver.DriverManagers.web.remote.browserStack.BrowserStackChromeManager;
import Driver.DriverManagers.web.remote.browserStack.BrowserStackFireFoxManager;
import org.openqa.selenium.WebDriver;

public final class BrowserStackFactory {
    private BrowserStackFactory(){}
    public static WebDriver getDriver(BrowserType browserType){
        return isaChromeBrowser(browserType)
                ? BrowserStackChromeManager.getDriver()
                : BrowserStackFireFoxManager.getDriver();
    }

    private static boolean isaChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

}
