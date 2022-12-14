Feature: Verify Home Page Features

  @Home-page-menu
  Scenario: Verify Menu Options
    When User click the i accept button
    And Click on Menu option
    Then Verify all links like News,Politics,Sports,Lifestyle etc
         |MenuOptions|
         |News       |
         | Politics  |
         | Sport    |
         | Lifestyle |
         | Education |
         | Entertainment|

  Scenario: Verify Menu tabs
    When User click the i accept button
    Then verify and click all tabs like News,Politics,Sports,Lifestyle etc
      |MenuOptions|
      |News       |
      | Politics  |
      | Sport    |
      | Lifestyle |
      | Education |
      | Entertainment|
      | Courier Investigations|

  Scenario Outline: Verify the search details
    When User click the i accept button
    And click on searchIcon and enter keyword "<SearchKeyword>"
    And click Go button
    Then verify the search details "<SearchKeyword>"
    Examples:
         |SearchKeyword|
         | life  |



