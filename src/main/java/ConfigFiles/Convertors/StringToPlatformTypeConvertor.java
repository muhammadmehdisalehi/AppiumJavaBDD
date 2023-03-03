package ConfigFiles.Convertors;

import ConfigFiles.enums.BrowserType;
import ConfigFiles.enums.PlatformType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToPlatformTypeConvertor implements Converter<PlatformType> {
    @Override
    public PlatformType convert(Method method, String platformType) {
        Map<String, PlatformType> stringPlatformTypeMap = Map.
                of("WEB",PlatformType.WEB,
                        "MOBILE",PlatformType.MOBILE);
        return stringPlatformTypeMap.getOrDefault(platformType.toUpperCase(),PlatformType.WEB);
    }
}
