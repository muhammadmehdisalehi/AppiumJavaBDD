package com.jogo.automation.Pages.PageRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePageRepo {

    @FindBy(xpath="//*[@text='Welcome to The Home of Football']")
    public WebElement welcome_Text;
    @FindBy(xpath="//*[@content-desc='Registration_Wall_facebookButton']")
    public WebElement facebook_Button;
    @FindBy(xpath="//*[@content-desc='Registration_Wall_gmailButton']")
    public WebElement google_Button;
    @FindBy(xpath="//*[@content-desc='Registration_Wall_createAccountButton']")
    public WebElement createAccount_Button;

    @FindBy(xpath="//*[@text='Skip']")
    public WebElement skip_Button;

}
