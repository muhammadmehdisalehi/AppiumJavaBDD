package Driver.DriverManagers.mobile.remote;

import ConfigFiles.Factory.BrowserStackConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackAndroidManager {
    private BrowserStackAndroidManager(){};
    public static AndroidDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "12.0");
        capabilities.setCapability("device", "Google Pixel 5");
        capabilities.setCapability("app", "bs://005717236e27016b3780961114f92cb8f63c43c6");
        return new AndroidDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);
    }
}
