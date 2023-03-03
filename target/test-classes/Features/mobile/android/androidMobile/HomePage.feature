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


  @mobile @Android @HomePageButtonPresentOnOtherFeature @Regression @Sanity
  Scenario Outline: Validate that when user clicks on icon and navigates to another feature and when user is on that feature, the navigation button will still have a hamburger icon
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    #And Verify user is on "HomePage" screen
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    When User clicks "Menu" button on "MenuNavigation" screen
    When User clicks "News" button on "MenuNavigationItem" screen
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    When User clicks "Menu" button on "MenuNavigation" screen
    When User clicks "Matches" button on "MenuNavigationItem" screen
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    When User clicks "Menu" button on "MenuNavigation" screen
    When User clicks "Articles" button on "MenuNavigationItem" screen
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    When User clicks "Menu" button on "MenuNavigation" screen
    When User clicks "Media" button on "MenuNavigationItem" screen
    And Verify "Menu" element is present
    And Verify "Menu Hamburger" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerUI @Regression @Sanity
  Scenario Outline: Validate Top Banners UI
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner Image" element is present
    And Verify "Top Banner Subcategory" element is present
    And Verify "Top Banner Description" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerOnTopOfHomepage @Regression @Sanity
  Scenario Outline: Validate user is able to view Top Banners on top of homepage
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" element is present on top
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerCountOnHomepage @Regression @Sanity
  Scenario Outline: Validate user is able to view maximum 5 top banners
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" element count can have maximum "5"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerCountIsGreaterThanOnHomepage @Regression @Sanity
  Scenario Outline: Validate user is able to view minimum 1 top banner
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" element count is greater than "1"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerSwipe @Regression @Sanity
  Scenario Outline: Validate user is able to swipe top banners
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" element to be swipe "Right"
    And Verify "Top Banner" element to be swipe "Left"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerSwipeLoop @Regression @Sanity
  Scenario Outline: Validate swipe works in a loop
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner" element to be swipe "Right" with a count of "bannersData"
    And Verify "Top Banner" element to be swipe "Left" with a count of "bannersData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @TopBannerSwipeEdgeCase @Regression @Sanity
  Scenario Outline: Validate user is able to swipe top banners Edge Case
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "Top Banner Count" element to be swipe "Right"
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

  @mobile @Android @HomePageNewsSection @Regression @Sanity
  Scenario Outline: Validate user is able to scroll to Latest news section
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageNewsSwipe @Regression @Sanity
  Scenario Outline: Validate user is able to swipe Latest News tiles
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then Scroll "Down" into view "News" Section
    And Verify "News" element to be swipe "Left"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageNewsCount @Regression @Sanity
  Scenario Outline: Validate user is able to view top 5 news tiles on homepage
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then Scroll "Down" into view "News" Section
    And Verify "News Count" element to be swipe "Left" with a count of "5"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageNewsBanner @Regression @Sanity
  Scenario Outline: Validate user is able to open Latest news section by clicking on the banner
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then Scroll "Down" into view "News" Section
    And Verify "News Title" element is present
    And Verify "News Description" element is present
    #And Verify "News Creater" element is present
    When User clicks "News Section" button on "HomePage" screen
    And Verify "News Main Title" element is present
    And Verify "News Main Description" element is present
    And Verify "See Other News" element is present
    And Verify "Back Button" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageNews6thNews @Regression @Sanity
  Scenario Outline: Validate that when user taps on see all news, the 6th news is displayed on top
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then Scroll "Down" into view "News" Section
    And Verify "News Count" element to be swipe "Left" with a count of "5"
    And Verify "6th News" screen according to file name "newsData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageNewsMain @Regression @Sanity
  Scenario Outline: Validate that when user taps on a news tile, that news is displayed on top
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    And Verify "News Section" element is present
    Then Scroll "Down" into view "News" Section
    And Verify "News" screen according to file name "newsData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageArticlesMain @Regression @Sanity
  Scenario Outline: Validate user is able to scroll to Articles section
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "ARTICLES HEADING" Section
    And Verify "Article Section" element is present
    And Verify "Article See All" element is present
    Then Scroll "Down" into view "ARTICLES" Section
    And Verify "Article Tile" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageArticlesCount @Regression @Sanity
  Scenario Outline: Validate user is able to view top 4 articles tiles on homepage
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "ARTICLES" Section
    And Verify "Articles" element count is "4"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageTopViewedMain @Regression @Sanity
  Scenario Outline: Validate user is able to scroll to Top viewed section
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Top Viewed" Section
    And Verify "Top Viewed Section" element is present
    And Verify "Top Viewed Tile" element is present
    And Verify "Top Viewed Creater" element is present
    And Verify "Top Viewed Title" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageTopViewedSwipe @Regression @Sanity
  Scenario Outline: Validate user is able to swipe Top Viewed banners
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Top Viewed" Section
    And Verify "Top Viewed" element to be swipe "Left"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageTopViewedSwipeCount @Regression @Sanity
  Scenario Outline: Validate user is able to view top 5 top viewed tiles on homepage
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Top Viewed" Section
    And Verify "Top Viewed Count" element to be swipe "Left" with a count of "5"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageSearchDiscoverSection @Regression @Sanity
  Scenario Outline: Validate that "Discover Section" is present on the search screen
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    When User clicks "SEARCH" button on "HomePage" screen
    And Verify "Discover" element is present
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @HomePageSearchRecentlyViewSection @Regression @Sanity
  Scenario Outline: Validate that "Recently Viewed Section" is present on the search screen
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    When User clicks "SEARCH" button on "HomePage" screen
    Then User "<Task>" is deleted successfully
   # And Verify "Recently View" element is present
    Examples:
      | Task                  |
      | Skip                  |
      | Create Account Random |

  @mobile @Android @AndroidMobileWeb @HomePageQuizSectionAll @Regression @Sanity
  Scenario Outline: Validate user is able to scroll to Quiz section
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Quiz" Section
    And Verify "Quiz Choice" element is present
    And Verify "Quiz" screen according to file name "questionsData"
    And Verify user is able to answer "Multiple Quiz" according to file "questionsData"
    And Verify "Quiz Summary" screen according to file name ""
    And Verify "Quiz Summary Arrow Forward" screen according to file name "questionsData"
    Then User Restarts App
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<TaskRedo>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Quiz" Section
    And Verify "Quiz Summary" screen according to file name ""
    And Verify "Quiz Count" element is not present
    And Verify "Quiz Summary Arrow Reviewing Count" screen according to file name "questionsData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  | TaskRedo             |
      | Create Account Random | Random Account Login |

  @mobile @Android @AndroidMobileWeb @HomePageMatches @Regression @Sanity
  Scenario Outline: Validate user is able to scroll to Matches section
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<Task>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Matches" Section
     And Verify "Poll Choice" element is present
    And Verify "Poll" screen according to file name "questionsData"
    And Verify user is able to answer "Multiple Poll" according to file "questionsData"
    And Verify "Poll Summary" screen according to file name ""
    And Verify "Poll Summary Arrow Forward" screen according to file name "questionsData"
    Then User Restarts App
    Given Verify user is on "Welcome" screen
    Given User is on homepage screen via "<TaskRedo>"
    And Verify "Menu" element is present
    Then Scroll "Down" into view "Poll" Section
    And Verify "Poll Summary" screen according to file name ""
    And Verify "Poll Count" element is not present
    And Verify "Poll Summary Arrow Reviewing Count" screen according to file name "questionsData"
    Then User "<Task>" is deleted successfully
    Examples:
      | Task                  | TaskRedo             |
      | Create Account Random | Random Account Login |
