package ConfigFiles.Convertors;

import ConfigFiles.enums.RemoteModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemoteModeTypeConvertor implements Converter<RemoteModeType> {
    @Override
    public RemoteModeType convert(Method method, String remoteMode) {
        return RemoteModeType.valueOf(remoteMode.toUpperCase());
    }
}
