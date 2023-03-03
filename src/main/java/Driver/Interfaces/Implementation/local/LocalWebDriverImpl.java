package Driver.Interfaces.Implementation.local;

import Driver.DriverFactories.web.local.LocalDriverFactory;
import Driver.Interfaces.IWebDriver;
import Driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver {

    @Override
    public WebDriver getDriver(WebDriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getBrowserType());
    }
}
