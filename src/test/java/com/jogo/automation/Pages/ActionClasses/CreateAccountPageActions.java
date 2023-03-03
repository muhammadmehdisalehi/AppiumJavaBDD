package com.jogo.automation.Pages.ActionClasses;

import com.jogo.automation.Pages.PageRepos.CreateAccountPageRepo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static DataReader.EnvConfig.*;
import static Utilities.CommonFunctions.*;

public class CreateAccountPageActions extends CreateAccountPageRepo {
    WebDriver driver = null;

    public CreateAccountPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyUserIsOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(screen_Text,5));
    }
    public void verifyCreateAccountButton(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(createAccount_Button,5));
    }
    public void verifyUserIsOnEmailValidationScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(emailValidation_Text,5));
    }
    public void enterDataInForm(String formData){
        switch (formData.toUpperCase()){
            case "ALL":
                enterDataInFullForm();
                break;
            case "FAIL":
                enterDataInFullFormFail();
                break;
            case "INVALID EMAIL":
                enterInvalidEmailDataInForm();
                break;
            case "EXISTING EMAIL":
                enterExistingEmailDataInForm();
                break;
            case "EXISTING USERNAME":
                enterExistingUserNameDataInForm();
                break;
            case "PASSWORD MISSING":
                passwordMissingInForm();
                break;
            case "INVALID PASSWORD":
                invalidPasswordForm();
                break;
            case "SOCIAL EXISTING EMAIL":
                enterExistingSocialEmailDataInForm();
                break;
        }
    }
    public void enterDataInFullForm(){
        clickAndEnterDataInInputField(firstName_Input,"Auto");
        clickAndEnterDataInInputField(lastName_Input,"Mation");
        clickAndEnterDataInInputField(userName_Input,"Auto" + String.valueOf(randInt()));
        clickAndEnterDataInInputField(shirtNumber_Input, String.valueOf(randInt()));
        selectDateDropDown(dob_Input,"01 November 2008");
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,randomEmail());
        clickAndEnterDataInInputField(password_Input,randomPassword());
        click(termAndConditions_Checkbox);
        click(termAndConditions_Checkbox);
        click(emailSubscription_Checkbox);
        click(continue_Button);
    }
    public void passwordMissingInForm(){
        clickAndEnterDataInInputField(firstName_Input,"Auto");
        clickAndEnterDataInInputField(lastName_Input,"Mation");
        clickAndEnterDataInInputField(userName_Input,"Auto" + String.valueOf(randInt()));
        clickAndEnterDataInInputField(shirtNumber_Input, String.valueOf(randInt()));
        selectDateDropDown(dob_Input,"01 November 2008");
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,randomEmail());
        click(termAndConditions_Checkbox);
        click(termAndConditions_Checkbox);
        click(emailSubscription_Checkbox);
    }
    public void invalidPasswordForm(){
        clickAndEnterDataInInputField(firstName_Input,"Auto");
        clickAndEnterDataInInputField(lastName_Input,"Mation");
        clickAndEnterDataInInputField(userName_Input,"Auto" + String.valueOf(randInt()));
        clickAndEnterDataInInputField(shirtNumber_Input, String.valueOf(randInt()));
        selectDateDropDown(dob_Input,"01 November 2008");
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,randomEmail());
        clickAndEnterDataInInputField(password_Input,CreateAccountInValidData.get("password"));
        click(termAndConditions_Checkbox);
        click(termAndConditions_Checkbox);
        click(emailSubscription_Checkbox);
    }
    public void enterExistingUserNameDataInForm(){
        clickAndEnterDataInInputField(userName_Input,CreateAccountExistingData.get("userName"));
        clickAndEnterDataInInputField(lastName_Input,"Mation");
    }
    public void enterInvalidEmailDataInForm(){
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,CreateAccountInValidData.get("emailAddress"));
        clickAndEnterDataInInputField(password_Input,randomPassword());
    }
    public void enterExistingEmailDataInForm(){
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,CreateAccountExistingData.get("emailAddress"));
        clickAndEnterDataInInputField(password_Input,randomPassword());
    }
    public void enterExistingSocialEmailDataInForm(){
        scrollDownUntilTextDisplayed("CONTINUE");
        clickAndEnterDataInInputField(emailAddress_Input,CreateAccountExistingData.get("facebookEmailAddress"));
        clickAndEnterDataInInputField(password_Input,randomPassword());
    }
    public void existingEmailValidationError(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(existingEmailValidation_Text,10));
    }
    public void existingFacebookEmailValidationError(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(existingFacebookEmailValidation_Text,10));
    }
    public void existingUserNameError(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(existingUsernameValidation_Text,10));
    }
    public void invalidEmailError(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(invalidEmailValidation_Text,10));
    }
    public void enterDataInFullFormFail(){
        waitUntilElementDisplayed(firstName_Input,5);
        enterDataInInputField(firstName_Input,"Auto");
        enterDataInInputField(lastName_Input,"Mation");
        enterDataInInputField(userName_Input,"Auto" + String.valueOf(randInt()));
        enterDataInInputField(shirtNumber_Input, String.valueOf(randInt()));
        scrollDownUntilTextDisplayed("CONTINUE");
        selectDateDropDownFail(dob_Input);
        enterDataInInputField(emailAddress_Input,randomEmail());
        enterDataInInputField(password_Input,randomPassword());
        click(termAndConditions_Checkbox);
        click(emailSubscription_Checkbox);
        click(continue_Button);
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(emailValidation_Text,5));
    }

}
