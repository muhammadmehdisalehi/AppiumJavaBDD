package com.jogo.automation.Pages.PageRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPageRepo {
    @FindBy(xpath="//*[@content-desc='facebook']")
    public WebElement screen_Text;
    @FindBy(xpath="//*[@text='Log in With Facebook']")
    public WebElement screenLogin_Text;
    @FindBy(xpath="//*[@resource-id='m_login_email']")
    public WebElement email_Input;
    @FindBy(xpath="//*[@resource-id='m_login_password']")
    public WebElement password_Input;
    @FindBy(xpath="//*[@text='Log In']")
    public WebElement login_Button;
    @FindBy(xpath="//*[@text='Continue as Gulraiz']")
    public WebElement continue_Button;
    @FindBy(xpath="//*[@text='Continue']")
    public WebElement continue_Webkit_Button;

}
