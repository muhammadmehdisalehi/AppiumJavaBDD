@CreateAccount
Feature: SignUp Feature

  @mobile @Android @SignUpThroughCreateAccount @Regression @Sanity
  Scenario: Validate user is able to SignUp through Create account option
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "All" form data on "Create Account" screen
    Then Verify user is on "Email Validation" screen
    #Api verification is pending
    #And Verify user is on "HomePage" screen

  @mobile @Android  @SignUpThroughFacebook @Regression @Sanity
  Scenario: Validate User is able to SignUp through facebook
    Given Verify user is on "Welcome" screen
    When User clicks "FACEBOOK" button on "Welcome" screen
    Then User login with "FACEBOOK" with data "Valid"
    And Verify user is on "HomePage" screen

  @mobile @Android @AndroidMobileWeb @SignUpThroughGooglePending @Regression @Sanity
  Scenario: Validate User is able to SignUp through Google
    Given Verify user is on "Welcome" screen
    When User clicks "GOOGLE" button on "Welcome" screen
    #pending

  @mobile @Android @AndroidMobileWeb @SignUpThroughSkip @Regression @Sanity
  Scenario: Validate user is able to use application as guest user without signing up
    Given Verify user is on "Welcome" screen
    When User clicks "SKIP" button on "Welcome" screen
    And Verify user is on "HomePage" screen

  @mobile @Android @AndroidMobileWeb @SignUpThroughCreateAccountSkipVerification @Regression @Sanity
  Scenario: Validate user can skip the verification step when signing up
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "All" form data on "Create Account" screen
    Then Verify user is on "Email Validation" screen
    #BAck button is not locatable
    When User clicks "Back" button on "Verification" screen
    And Verify user is on "CREATE ACCOUNT BUTTON" screen

  @mobile @Android @AndroidMobileWeb @SignUpThroughInValidEmail @Regression @Sanity
  Scenario: Validate user can not sign up with invalid email format
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Invalid Email" form data on "Create Account" screen
    Then Verify Validation Error "Invalid Email" present on "Create Account" screen

    #Additional Test Case
  @mobile @Android @AndroidMobileWeb @SignUpThroughExistingEmail @Regression @Sanity
  Scenario: Validate user can not sign up with already existing email
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Existing Email" form data on "Create Account" screen
    Then Verify Validation Error "Existing Email" present on "Create Account" screen

  @mobile @Android @AndroidMobileWeb @SignUpThroughExistingUserName @Regression @Sanity
  Scenario: Validate user can not sign up with already existing username
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Existing Username" form data on "Create Account" screen
    Then Verify Validation Error "Existing Username" present on "Create Account" screen

  @mobile @Android @AndroidMobileWeb @SignUpPasswordMissing @Regression @Sanity
  Scenario: Validate user can not register without entering mandatory fields
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Password Missing" form data on "Create Account" screen
    #Enable disable is not working
    #Then Verify user is on "Create Account" screen

  @mobile @Android @AndroidMobileWeb @SignUpInvalidPassword @Regression @Sanity
  Scenario: Validate user can not register if password criteria is not met
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Invalid Password" form data on "Create Account" screen
    #Enable disable is not working
    #Then Verify user is on "Create Account" screen

  @mobile @Android @AndroidMobileWeb @SignUpExistingSocialAccount @Regression @Sanity
  Scenario: Validate user can not register with an email that is used through social signup already
    Given Verify user is on "Welcome" screen
    When User clicks "Create Account" button on "Welcome" screen
    Then Verify user is on "Create Account" screen
    When User fills "Social Existing Email" form data on "Create Account" screen
    Then Verify Validation Error "Existing Facebook Email" present on "Create Account" screen