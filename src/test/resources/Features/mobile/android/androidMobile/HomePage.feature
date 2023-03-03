@HomePage
Feature: Homepage Feature

  @mobile @Android @HomePageButton @Regression @Sanity
  Scenario Outline: Validate that the Navigation button icon is changed from Home icon to hamburger
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |



  @mobile @Android @TopBannerAPISwipeEdgeCase @Regression @Sanity
  Scenario Outline: Validate labels on banners are displayed correctly
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" screen according to file name "bannersData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

