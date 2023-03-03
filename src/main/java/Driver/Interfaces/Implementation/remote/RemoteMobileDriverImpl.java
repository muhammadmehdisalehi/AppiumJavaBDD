package Driver.Interfaces.Implementation.remote;

import Driver.DriverFactories.mobile.remote.RemoteMobileDriverFactory;
import Driver.Interfaces.IMobileDriver;
import Driver.entity.MobileDriverData;
import org.openqa.selenium.WebDriver;

public class RemoteMobileDriverImpl implements IMobileDriver {

    @Override
    public WebDriver getDriver(MobileDriverData driverData) {
        return RemoteMobileDriverFactory.getDriver(driverData.getMobileRemoteModeType(),driverData.getMobilePlatformType());
    }
}
