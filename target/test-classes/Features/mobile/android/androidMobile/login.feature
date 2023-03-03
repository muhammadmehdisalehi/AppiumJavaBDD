@Login
Feature: Login Feature

    @mobile @Android @AndroidMobileWeb @NavigateToLoginPage @Regression @Sanity
    Scenario: Navigate to Login Page
    Given Verify user is on "Welcome" screen
    When User clicks "LOGIN" button on "Welcome" screen
    Then Verify user is on "Login" screen


    @mobile @Android @AndroidMobileWeb @LoginThroughValidCredentials @Regression @Sanity
    Scenario: Login with valid credentials
    Given Verify user is on "Welcome" screen
    When User clicks "LOGIN" button on "Welcome" screen
    Then Verify user is on "Login" screen
    When User fills "All" form data on "login" screen
    Then Verify user is on "Homepage" screen

    @mobile @Android @AndroidMobileWeb @LoginThroughUnregisteredEmail @Regression @Sanity
    Scenario: Login with unregistered email
      Given Verify user is on "Welcome" screen
      When User clicks "LOGIN" button on "Welcome" screen
      Then Verify user is on "Login" screen
      When User fills "UNREGISTERED EMAIL" form data on "login" screen
      Then Verify Validation Error "USER NOT FOUND" present on "Login" screen

    @mobile @Android @AndroidMobileWeb @LoginThroughInvalidEmailFormat @Regression @Sanity
    Scenario: Login with invalid email format
      Given Verify user is on "Welcome" screen
      When User clicks "LOGIN" button on "Welcome" screen
      Then Verify user is on "Login" screen
      When User fills "INVALID EMAIL" form data on "login" screen
      Then Verify "LOGIN" button is "DISABLED"

    @mobile @Android @ViewPassword @Regression @Sanity
    Scenario: View password with eye option
      Given Verify user is on "Welcome" screen
      When User clicks "LOGIN" button on "Welcome" screen
      Then Verify user is on "Login" screen
      When User fills "ALL DATA WITHOUT LOGIN" form data on "LOGIN FORM DATA" screen
      When User clicks "EYE" button on "login" screen
      Then User verifies "PASSWORD" string

    @mobile @Android @HidePassword @Regression @Sanity
      Scenario: Hide password with eye option
        Given Verify user is on "Welcome" screen
        When User clicks "LOGIN" button on "Welcome" screen
        Then Verify user is on "Login" screen
        When User fills "ALL DATA WITHOUT LOGIN" form data on "LOGIN FORM DATA" screen
        When User clicks "EYE" button on "login" screen
        Then User verifies "PASSWORD" string
        When User clicks "EYE" button on "login" screen
        Then User verifies "HIDDEN PASSWORD" string
