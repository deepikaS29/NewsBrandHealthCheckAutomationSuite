Feature: Test Register user functionality

    Background: User navigates to Register user page
    #Given User is on login page  "https://www.thecourier.co.uk/login/
      And User click the i accept button
      When User hit the login link
      Then Login page is open
      When User click on Click here to Register link
      Then Register page is open


  @RegisterUser
  Scenario:Negative checks on Register the User
      Given User enter EmailID and password
        | Email         | Password |
        # valid email and less than 8 characters
        | deeT1101@gmail.com | Asc@567 |
        # valid email and only numbers
        | depikaT1101@gmail.com | 12345678 |
        # valid email and only characters
        | deepikaT1101@gmail.com | qqqqqqqq |
        # valid email and without uppercase character
        | deepikaT1101@gmail.com | qqqqqq23 |
        # Already registered valid email and valid password
        | deepikaT1101@gmail.com  | Asc@5678 |
        # Invalid email and valid password
        | gaurav233@gmail | Asc@5678 |


  Scenario Outline:Successfully Register the User
    Given Enter register email Id "<Email>"
    Given Enter register password "<Password>"
    When User hit the Create your account button
    Then User should navigates to The courier home page
    And Login Replaced with My Account link
    Examples:
      | Email                | Password    |
      | Preet00934@gmail.com | Asc@5672334 |
      | Deepika.S12@yahoo.com| Abc#34567    |






