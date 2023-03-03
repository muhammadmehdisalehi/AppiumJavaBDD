package Driver.entity;

import ConfigFiles.enums.MobilePlatformType;
import ConfigFiles.enums.RemoteModeType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MobileDriverData {
    private MobilePlatformType mobilePlatformType;
    private RemoteModeType mobileRemoteModeType;
}
