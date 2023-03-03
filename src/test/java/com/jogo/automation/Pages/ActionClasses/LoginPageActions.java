package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.LoginPageRepo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static DataReader.EnvConfig.*;
import static Utilities.CommonFunctions.*;

public class LoginPageActions extends LoginPageRepo {

    WebDriver driver = null;

    public LoginPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userClickOnLoginButton() {
        click(login_Button);
    }

    public void verifyUserIsOnScreen() {
        waitUntilElementDisplayed(login_screen_text, 5);
    }

    public void enterDataInForm(String formData) {
        switch (formData.toUpperCase()) {
            case "ALL":
                enterDataInFullForm();
                break;
            case "API RANDOM":
                enterDataInFullFormRandom();
                break;
            case "UNREGISTERED EMAIL":
                enterUnregisteredEmailInForm();
                break;
            case "INVALID EMAIL":
                enterInvalidEmailInForm();
                break;
            case "ALL DATA WITHOUT LOGIN":
                enterDataInFullFormWithoutLogin();
        }


    }

    private void enterDataInFullForm() {
        clickAndEnterDataInInputField(email_Input,LoginValidData_2.get("Email"));
        clickAndEnterDataInInputField(password_Input,LoginValidData_2.get("Password"));
        click(loginMain_button);
    }
    private void enterDataInFullFormRandom() {
        clickAndEnterDataInInputField(email_Input,randomEmailToBeUsed);
        clickAndEnterDataInInputField(password_Input,randomPasswordToBeUsed);
        click(loginMain_button);
    }
    private void enterDataInFullFormWithoutLogin() {
        clickAndEnterDataInInputField(email_Input,LoginValidData_2.get("Email"));
        clickAndEnterDataInInputField(password_Input,LoginValidData_2.get("Password"));
    }

    public void userClickOnEyeButton(){
        click(eyeButton);
    }

    private void enterUnregisteredEmailInForm(){
        clickAndEnterDataInInputField(email_Input,UnregisteredAccountDetails.get("Email"));
        clickAndEnterDataInInputField(password_Input,UnregisteredAccountDetails.get("Password"));
        click(loginMain_button);
    }

    private void enterInvalidEmailInForm(){
        clickAndEnterDataInInputField(email_Input,InvalidEmailAccountDetails.get("Email"));
        clickAndEnterDataInInputField(password_Input,InvalidEmailAccountDetails.get("Password"));
    }

    public void userNotFoundError(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(userNotFoundErrorText,20));
    }

    public void buttonDisabled(){
        System.out.println(loginMain_button.getAttribute("enabled"));
        Assert.assertFalse("Login button is disabled",loginMain_button.isEnabled());
    }


    public void verifyPasswordText(){
        assertString(LoginValidData_2.get("Password"),password_Input.getText());
    }

    public void verifyHiddenPasswordText(){
        String convertedPassword = "•".repeat(LoginValidData_2.get("Password").length());
        //System.out.println(convertedPassword);
        assertString(LoginValidData_2.get("Password"),convertedPassword);
    }

}
