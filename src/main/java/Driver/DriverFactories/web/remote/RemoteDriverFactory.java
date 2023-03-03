package Driver.DriverFactories.web.remote;

import ConfigFiles.enums.RemoteModeType;
import ConfigFiles.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {
    private RemoteDriverFactory(){}
    private static final Map<RemoteModeType,Function<BrowserType,WebDriver>> MAP = new EnumMap<>(RemoteModeType.class);
    static {
        MAP.put(RemoteModeType.SELENIUM,SeleniumGridFactory::getDriver);
        MAP.put(RemoteModeType.SELENOID,SelenoidFactory::getDriver);
        MAP.put(RemoteModeType.BROWSER_STACK,BrowserStackFactory::getDriver);
    }

    public static WebDriver getDriver(RemoteModeType remoteModeType, BrowserType browserType){
        return MAP.get(remoteModeType).apply(browserType);
    }
}
