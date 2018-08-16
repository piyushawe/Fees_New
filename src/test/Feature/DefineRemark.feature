Feature:Testing of function

  Background: Opening a fees manager
    Given Go to the url
    When Enter the username
    And Enter the password
    Then Click on login button
    And Click on the fees button
    And Go to the left navigation panel and click on Global Master
    And Click on Define Remark menu

  Scenario: Login to chrome
    Given open tools qa

  Scenario: Login to Firefox
    Given intilize brow

