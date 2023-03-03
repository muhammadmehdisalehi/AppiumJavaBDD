package com.jogo.automation.Pages;

import com.jogo.automation.Pages.ActionClasses.*;
import org.openqa.selenium.WebDriver;

public class ClassInitializers {
    public static WelcomePageActions welcomePageActions;
    public static CreateAccountPageActions createAccountPageActions;
    public static FacebookPageActions facebookPageActions;
    public static GooglePageActions googlePageActions;
    public static LoginPageActions loginPageActions;
    public static HomePageActions homePageActions;
    public static VerificationPageActions verificationPageActions;
    public static MenuNavigationPageActions menuNavigationPageActions;
    public static NewsPageActions newsPageActions;
    public void initializePages(WebDriver driver) {
        welcomePageActions = new WelcomePageActions(driver);
        createAccountPageActions = new CreateAccountPageActions(driver);
        facebookPageActions = new FacebookPageActions(driver);
        googlePageActions = new GooglePageActions(driver);
        loginPageActions = new LoginPageActions(driver);
        homePageActions = new HomePageActions(driver);
        verificationPageActions = new VerificationPageActions(driver);
        menuNavigationPageActions = new MenuNavigationPageActions(driver);
        newsPageActions = new NewsPageActions(driver);
    }
}
