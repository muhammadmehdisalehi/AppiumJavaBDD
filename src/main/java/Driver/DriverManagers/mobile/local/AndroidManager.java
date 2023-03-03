package Driver.DriverManagers.mobile.local;

import ConfigFiles.Factory.ConfigFactory;
import ConfigFiles.enums.DeviceName;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class AndroidManager {
    private AndroidManager(){}
    public static AndroidDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/cloudprimero/Downloads/app-dev-release.apk");
        capabilities.setCapability(MobileCapabilityType.VERSION,"12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigFactory.getConfig().DeviceName());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,9000);
        capabilities.setCapability("no-reset", false);
        capabilities.setCapability("full-reset", false);
        capabilities.setCapability("autoGrantPermissions", true);

        return new AndroidDriver(ConfigFactory.getConfig().localAppiumURL(),capabilities);
    }
}
