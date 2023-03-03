package ConfigFiles.Convertors;

import ConfigFiles.enums.BrowserType;
import ConfigFiles.enums.MobilePlatformType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToMobilePlatformTypeConvertor implements Converter<MobilePlatformType> {
    @Override
    public MobilePlatformType convert(Method method, String mobilePlatformType) {
        Map<String, MobilePlatformType> stringMobilePlatformTypeMap = Map.
                of("ANDROID",MobilePlatformType.ANDROID,
                        "IOS",MobilePlatformType.IOS);
        return stringMobilePlatformTypeMap.getOrDefault(mobilePlatformType.toUpperCase(),MobilePlatformType.ANDROID);
    }
}
