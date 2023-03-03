package Driver.DriverFactories.mobile.remote;

import ConfigFiles.enums.MobilePlatformType;
import ConfigFiles.enums.RemoteModeType;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteMobileDriverFactory {
    private RemoteMobileDriverFactory(){}
    private static final Map<RemoteModeType,Function<MobilePlatformType,AppiumDriver>> MAP = new EnumMap<>(RemoteModeType.class);
    static {
        MAP.put(RemoteModeType.BROWSER_STACK, BrowserStackMobileFactory::getDriver);
//        MAP.put(MobileRemoteModeType.SAUCE_LAB, SelenoidFactory::getDriver);
    }

    public static AppiumDriver getDriver(RemoteModeType mobileRemoteModeType, MobilePlatformType platformType){
        return MAP.get(mobileRemoteModeType).apply(platformType);
    }
}
