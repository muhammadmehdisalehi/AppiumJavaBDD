package Driver.Interfaces.Implementation.remote;

import Driver.DriverFactories.web.remote.RemoteDriverFactory;
import Driver.Interfaces.IWebDriver;
import Driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver {

    @Override
    public WebDriver getDriver(WebDriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getRemoteModeType(),driverData.getBrowserType());
    }
}
