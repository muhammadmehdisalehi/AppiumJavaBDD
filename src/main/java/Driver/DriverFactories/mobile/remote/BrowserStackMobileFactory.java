package Driver.DriverFactories.mobile.remote;

import ConfigFiles.enums.MobilePlatformType;
import Driver.DriverManagers.mobile.remote.BrowserStackAndroidManager;
import Driver.DriverManagers.mobile.remote.BrowserStackIOSManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class BrowserStackMobileFactory {
    private BrowserStackMobileFactory(){}
    private static final Map<MobilePlatformType, Supplier<AppiumDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    static {
        MAP.put(MobilePlatformType.ANDROID, BrowserStackAndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, BrowserStackIOSManager::getDriver);
    }
    public static AppiumDriver getDriver(MobilePlatformType platformType){
        return MAP.get(platformType).get();
    }
}
