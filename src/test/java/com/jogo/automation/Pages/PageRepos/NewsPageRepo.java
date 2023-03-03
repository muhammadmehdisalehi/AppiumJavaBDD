package com.jogo.automation.Pages.PageRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPageRepo {
    @FindBy(xpath="//*[@content-desc='Home_Button']")
    public static WebElement home_Button;
}
