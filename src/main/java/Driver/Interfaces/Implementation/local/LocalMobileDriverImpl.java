package Driver.Interfaces.Implementation.local;

import Driver.DriverFactories.mobile.local.LocalMobileDriverFactory;
import Driver.Interfaces.IMobileDriver;
import Driver.entity.MobileDriverData;
import org.openqa.selenium.WebDriver;

public class LocalMobileDriverImpl implements IMobileDriver {

    @Override
    public WebDriver getDriver(MobileDriverData driverData) {
        return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
    }
}
