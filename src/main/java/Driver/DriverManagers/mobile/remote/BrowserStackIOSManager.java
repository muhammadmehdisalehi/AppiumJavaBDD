package Driver.DriverManagers.mobile.remote;

import ConfigFiles.Factory.BrowserStackConfigFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackIOSManager {
    private BrowserStackIOSManager(){}
    public static AppiumDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("device", "Google Pixel 3");
        return new IOSDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);
    }
}
