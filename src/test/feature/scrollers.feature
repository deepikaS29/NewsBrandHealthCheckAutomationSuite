Feature: Test the horizontal&Vertical scrollers

  Background: Check user is navigates to Home Page
    And User click the i accept button
    When Click on any article on home page
      | Article                                                      |
      | One more point for Kwik Fit worker means ban after A92 crash |

  Scenario: Verify the category of article
    Then verify the respective category in the page after selecting article


  Scenario: Verify the 3 horizontal scrollers
    Then verify the below horizontal scrollers present in the page after selecting article
      | HorizontalScrollers   |
      | More from             |
      | Most Read             |
      | More from The Courier |

  Scenario: Verify the 2 vertical scrollers
    Then verify the below vertical scrollers present in the page after selecting article
      | VerticalScrollers |
      | Editor            |
      | Most Commented    |

  Scenario: Verify the scrollers position.
    Then verify the scrollers are present under conversation section
      | Scrollers             |
      | More from             |
      | Most Read             |
      | More from The Courier |
      | Editors               |
      | Most Commented        |

  Scenario: Verify there is no duplicate article in scrollers
    Then Verify there is no duplicate article in More from Category and More from Page scrollers






