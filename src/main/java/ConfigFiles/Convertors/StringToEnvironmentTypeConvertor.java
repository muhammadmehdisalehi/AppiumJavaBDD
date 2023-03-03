package ConfigFiles.Convertors;

import ConfigFiles.enums.EnvironmentType;
import ConfigFiles.enums.MobilePlatformType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToEnvironmentTypeConvertor implements Converter<EnvironmentType> {
    @Override
    public EnvironmentType convert(Method method, String environmentType) {
        Map<String, EnvironmentType> stringEnvironmentTypeMap = Map.
                of("PROD",EnvironmentType.PROD,
                        "STAGING",EnvironmentType.STAGING,
                        "DEV",EnvironmentType.DEV);
        return stringEnvironmentTypeMap.getOrDefault(environmentType.toUpperCase(),EnvironmentType.STAGING);
    }
}
