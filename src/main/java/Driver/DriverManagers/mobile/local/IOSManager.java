package Driver.DriverManagers.mobile.local;

import ConfigFiles.Factory.ConfigFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class IOSManager {
    private IOSManager(){}
    public static WebDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Plus");
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause", "8000");
        capabilities.setCapability("wdaStartupRetryInterval", "20000");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apps/ios-app.zip");
        return new RemoteWebDriver(ConfigFactory.getConfig().localAppiumURL(),capabilities);
    }
}
