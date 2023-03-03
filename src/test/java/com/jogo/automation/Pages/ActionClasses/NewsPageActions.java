package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.NewsPageRepo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.CommonFunctions.waitUntilElementDisplayed;

public class NewsPageActions extends NewsPageRepo {
    WebDriver driver = null;
    public NewsPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void verifyUserIsOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(home_Button,10));
    }
}
