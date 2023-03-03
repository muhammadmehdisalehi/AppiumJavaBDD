package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.VerificationPageRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.CommonFunctions.click;

public class VerificationPageActions extends VerificationPageRepo {
    WebDriver driver = null;

    public VerificationPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userClickOnBackButton(){
        click(back_Button);
    }
}
