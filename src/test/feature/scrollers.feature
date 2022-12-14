Feature: Test the horizontal&Vertical scrollers

  Background: Check user is navigates to Home Page
    And User click the i accept button
    When Click on any article on home page
      |Article|
      |Perth’s ‘Father Christmas’ pledges to deliver free gifts to 500 kids after appeal goes viral|

  Scenario: Verify the category of article
    Then verify the respective category in the page after selecting article


  Scenario: Verify the 3 horizontal scrollers
    Then verify the below horizontal scrollers present in the page after selecting article
    | HorizontalScrollers |
    | More from       |
    | Most Read   |
    | More from The Courier |

  Scenario: Verify the 2 vertical scrollers
    Then verify the below vertical scrollers present in the page after selecting article
      | VerticalScrollers |
      | Editor     |
      | Most Commented   |

    Scenario: Verify the scrollers position.
      Then verify the scrollers are present under conversation section
      |Scrollers |
      | More from    |
      | Most Read   |
      | More from The Courier|
      | Editors      |
      | Most Commented |




