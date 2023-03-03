package Driver.DriverFactories.mobile.local;

import ConfigFiles.enums.MobilePlatformType;
import Driver.DriverManagers.mobile.local.AndroidManager;
import Driver.DriverManagers.mobile.local.IOSManager;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalMobileDriverFactory {
    private LocalMobileDriverFactory(){}

    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    static {
        MAP.put(MobilePlatformType.ANDROID, AndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, IOSManager::getDriver);
    }
    public static WebDriver getDriver(MobilePlatformType platformType){

        return MAP.get(platformType).get();
    }

}
