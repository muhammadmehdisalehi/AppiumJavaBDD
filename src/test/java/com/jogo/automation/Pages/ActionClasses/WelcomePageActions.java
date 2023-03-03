package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.WelcomePageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static Utilities.CommonFunctions.*;

public class WelcomePageActions extends WelcomePageRepo {
    WebDriver driver = null;

    public WelcomePageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyUserIsOnScreen(){
        waitUntilElementDisplayed(welcome_Text,5);
    }
    public void userClickOnCreateAccountButton(){
        click(createAccount_Button);
    }

    public void userClickOnFacebookButton(){
        click(facebook_Button);
    }
    public void userClickOnGoogleButton(){
        click(google_Button);
    }
    public void userClickOnSkipButton(){
        click(skip_Button);
    }
}
