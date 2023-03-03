package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.FacebookPageRepo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.CommonFunctions.*;

public class GooglePageActions extends FacebookPageRepo {
    WebDriver driver = null;
    public GooglePageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillFacebookForm(String data){
        if(waitUntilElementDisplayed(screenLogin_Text,20)){
            click(continue_Webkit_Button);
        }
        else{
            waitUntilElementDisplayed(screen_Text,20);
            enterDataInInputField(email_Input,"gulraizshah@rocketmail.com");
            enterDataInInputField(password_Input,"pass");
            click(login_Button);
            waitUntilElementDisplayed(continue_Button,20);
            click(continue_Button);
        }
    }
}
