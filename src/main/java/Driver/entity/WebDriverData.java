package Driver.entity;

import ConfigFiles.enums.RemoteModeType;
import ConfigFiles.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
    private BrowserType browserType;
    private RemoteModeType remoteModeType;
}
