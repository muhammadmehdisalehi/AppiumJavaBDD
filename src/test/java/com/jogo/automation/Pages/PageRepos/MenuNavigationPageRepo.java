package com.jogo.automation.Pages.PageRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuNavigationPageRepo {
    @FindBy(xpath="//*[@content-desc='Home_Button']")
    public static WebElement home_Button;
    @FindBy(xpath="//*[@content-desc='Menu_Home_Icon']")
    public static WebElement home_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_News_Icon']")
    public static WebElement news_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Matches_Icon']")
    public static WebElement matches_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Search_Icon']")
    public static WebElement search_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Articles_Icon']")
    public static WebElement articles_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Media_Icon']")
    public static WebElement media_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Profile_Icon']")
    public static WebElement profile_Icon;
    @FindBy(xpath="//*[@content-desc='Menu_Close_Icon']")
    public static WebElement close_Button;
}
