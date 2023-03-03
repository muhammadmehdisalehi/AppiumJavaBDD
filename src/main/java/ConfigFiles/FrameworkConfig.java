package ConfigFiles;

import ConfigFiles.Convertors.*;
import ConfigFiles.enums.*;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {

    @Key("runMode")
    @ConverterClass(StringToRunModeBrowserTypeConvertor.class)
    RunModeType RunMode();

    @Key("platformType")
    @ConverterClass(StringToPlatformTypeConvertor.class)
    PlatformType PlatformType();

    @Key("mobilePlatformType")
    @ConverterClass(StringToMobilePlatformTypeConvertor.class)
    MobilePlatformType MobilePlatformType();

    @Key("deviceName")
    @ConverterClass(StringToDeviceNameConvertor.class)
    DeviceName DeviceName();

    @Key("environmentType")
    @ConverterClass(StringToEnvironmentTypeConvertor.class)
    EnvironmentType EnvironmentType();

    @ConverterClass(StringToURLConvertor.class)
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL localAppiumURL();

    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConvertor.class)
    BrowserType browser();

    @Key("remoteModeType")
    @ConverterClass(StringToRemoteModeTypeConvertor.class)
    RemoteModeType RemoteModeType();


    @ConverterClass(StringToURLConvertor.class)
    URL seleniumGridURL();

    @ConverterClass(StringToURLConvertor.class)
    URL selenoidURL();

}
