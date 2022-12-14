Feature: Test login functionality



  Background: Check user is navigates to login page
    When User click the i accept button
    And User hit the login link
    Then Login page is open

  Scenario:Negative checks on login page
    Given User enter login EmailID and password
      | Email         | Password |
        # valid email and invalid characters
      | GauracS@gmail.com | 2d@£4 |
        # invalid email and valid password
      | GauracS222@gmail| Abc@1234 |


  @login-page
 Scenario Outline:Check user is Login to the courier successfully
  Given Enter registered email id "<Email>"
   And  Enter valid password "<Password>"
   When User click on login button
   Then User  navigates to The courier home page
   And Login Replaced with My Account link

    Examples:
    | Email             | Password |
    | Preet00934@gmail.com | Asc@5672334|
    | Deepika.S12@yahoo.com| Abc#34567  |


#Scenario: Sign in with Facebook
#  Given User click on Sign in With Facebook button
#  When  Click on essential and optional cookies
#  Then Facebook login page open
#  When User enter valid facebook email id
#  And User enter valid facebook password
#  And Click on login button
#  And Click on continue button
#  Then The courier home page open
#
#  Scenario: Sign in with Goggle
#    Given User Click on Menuk on Sign in with Goggle
#    And Click on the users google account
#    And Enter google account password
#    When Hit the next button
#    Then The courier home page o

