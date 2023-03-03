package ConfigFiles;

import ConfigFiles.Convertors.StringToURLConvertor;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/browser_Stack.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("userName")
    String userName();
    @Key("key")
    String key();

    @DefaultValue("https://${userName}:${key}@hub-cloud.browserstack.com/wd/hub")
    @ConverterClass(StringToURLConvertor.class)
    URL browserStackURL();
}
