package Driver.DriverFactories.web.local;

import ConfigFiles.enums.BrowserType;
import Driver.DriverManagers.web.local.ChromeManager;
import Driver.DriverManagers.web.local.FireFoxManager;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {
    private LocalDriverFactory(){}

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FireFoxManager::getDriver);
    }
    public static WebDriver getDriver(BrowserType browserType){

        return MAP.get(browserType).get();//adding one more comment
    }

}
