package Driver.Interfaces;

import Driver.entity.MobileDriverData;
import Driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IMobileDriver {
    WebDriver getDriver(MobileDriverData driverData);
}
