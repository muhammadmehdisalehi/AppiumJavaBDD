package Driver;

import ConfigFiles.enums.BrowserType;
import ConfigFiles.enums.MobilePlatformType;
import ConfigFiles.enums.PlatformType;
import Driver.DriverFactories.DriverFactory;
import Driver.DriverManagers.MobileManager;
import Driver.DriverManagers.WebManager;
import Driver.DriverManagers.web.local.ChromeManager;
import Driver.DriverManagers.web.local.FireFoxManager;
import Driver.entity.MobileDriverData;
import Driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import static ConfigFiles.Factory.ConfigFactory.getConfig;

public final class Driver {
    private Driver(){}


    private static final Map<PlatformType, Runnable> MAP = new EnumMap<>(PlatformType.class);
    static {
        MAP.put(PlatformType.WEB, WebManager::getDriver);
        MAP.put(PlatformType.MOBILE, MobileManager::getDriver);
    }

    public static void initializeDriver(){
        MAP.get(getConfig().PlatformType()).run();
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
