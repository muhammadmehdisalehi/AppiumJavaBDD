package Driver;

import ConfigFiles.enums.PlatformType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

import static ConfigFiles.enums.PlatformType.*;
import static java.lang.ThreadLocal.*;

public final class DriverManager {
    private DriverManager(){}
    private static ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static ThreadLocal<PlatformType> CONTEXT = withInitial(()-> WEB);
    private static final Map<PlatformType,ThreadLocal<AppiumDriver>> DRIVER_MAP = new EnumMap<>(PlatformType.class);
    public static AppiumDriver getDriver(){
        //if(CONTEXT.get() == WEB) {
        //    return WEB_DRIVER_THREAD_LOCAL.get();
       // }
       // else {
            return MOBILE_DRIVER_THREAD_LOCAL.get();
        //}
    }
    public static void setDriver(AppiumDriver driver){
        //if (isMobileDriver(driver)){
            MOBILE_DRIVER_THREAD_LOCAL.set(driver);
            DRIVER_MAP.put(MOBILE,MOBILE_DRIVER_THREAD_LOCAL);
            CONTEXT.set(MOBILE);
        //}
        //else {
        //    WEB_DRIVER_THREAD_LOCAL.set(driver);
        //    DRIVER_MAP.put(WEB,WEB_DRIVER_THREAD_LOCAL);
        //    CONTEXT.set(WEB);
       // }
    }

    private static boolean isMobileDriver(WebDriver driver) {
        return driver instanceof AndroidDriver || driver instanceof IOSDriver;
    }

    public static void unload(){
        WEB_DRIVER_THREAD_LOCAL.remove();
        MOBILE_DRIVER_THREAD_LOCAL.remove();
        CONTEXT.remove();
    }
}
