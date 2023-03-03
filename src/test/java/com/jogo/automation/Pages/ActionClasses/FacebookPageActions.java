package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.FacebookPageRepo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static DataReader.EnvConfig.*;
import static Utilities.CommonFunctions.*;

public class FacebookPageActions extends FacebookPageRepo {
    WebDriver driver = null;
    public FacebookPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillFacebookForm(String data){
        if(waitUntilElementDisplayed(screenLogin_Text,20)){
            click(continue_Webkit_Button);
        }
        else{
            waitUntilElementDisplayed(screen_Text,20);
            enterDataInInputField(email_Input,FacebookData.get("emailAddress"));
            enterDataInInputField(password_Input,FacebookData.get("password"));
            click(login_Button);
            waitUntilElementDisplayed(continue_Webkit_Button,20);
            click(continue_Webkit_Button);
        }
    }
}
