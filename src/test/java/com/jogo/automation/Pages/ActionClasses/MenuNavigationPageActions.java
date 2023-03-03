package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.MenuNavigationPageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static Utilities.CommonFunctions.*;


public class MenuNavigationPageActions extends MenuNavigationPageRepo {
    WebDriver driver = null;
    public MenuNavigationPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnMenuOpen(){
        click(home_Button);
    }
    public void clickOnMenuClose(){
        click(close_Button);
    }
    public void clickOnMenuItem(String Item){
        switch (Item.toUpperCase()){
            case "HOME":
                click(home_Icon);
                break;
            case "NEWS":
                click(news_Icon);
                break;
            case "MATCHES":
                click(matches_Icon);
                break;
            case "SEARCH":
                click(search_Icon);
                break;
            case "ARTICLES":
                click(articles_Icon);
                break;
            case "MEDIA":
                click(media_Icon);
                break;
            case "PROFILE":
                click(profile_Icon);
                break;
        }
    }
}
