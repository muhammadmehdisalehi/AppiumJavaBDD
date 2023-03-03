package Driver.DriverManagers;

import Driver.DriverFactories.DriverFactory;
import Driver.DriverManager;
import Driver.entity.MobileDriverData;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static ConfigFiles.Factory.ConfigFactory.getConfig;

public final class MobileManager {
    private MobileManager(){}

    public static void getDriver(){
        if (Objects.isNull(DriverManager.getDriver())) {
            MobileDriverData driverData = new MobileDriverData(getConfig().MobilePlatformType(), getConfig().RemoteModeType());
            AndroidDriver driver = (AndroidDriver) DriverFactory.getDriverForMobile(getConfig().RunMode()).getDriver(driverData);
            DriverManager.setDriver(driver);
        }
    }
}
