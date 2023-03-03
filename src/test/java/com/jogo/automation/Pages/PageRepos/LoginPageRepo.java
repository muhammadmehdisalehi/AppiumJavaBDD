package com.jogo.automation.Pages.PageRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageRepo {

    @FindBy(xpath = "//*[@content-desc='Registration_Wall_loginNavigation']")
    public WebElement login_Button;

    @FindBy(xpath = "//*[@text='Log in using Email']")
    public WebElement login_screen_text;

    @FindBy(xpath = "//*[@content-desc='Login_emailInput']")
    public WebElement email_Input;

    @FindBy(xpath = "//*[@content-desc='Login_passwordInput']")
    public WebElement password_Input;

    @FindBy(xpath = "//*[@content-desc='Login_loginButton']")
    public WebElement loginMain_button;

    @FindBy(xpath = "//*[@text='User not found']")
    public WebElement userNotFoundErrorText;

    @FindBy(xpath="//*[@content-desc='Login_passwordInput']/following-sibling::android.view.ViewGroup")
    public WebElement eyeButton;
}
