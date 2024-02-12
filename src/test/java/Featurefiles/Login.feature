Feature:Login
  @Sanity
  Scenario:Successful Login with valid Credentials
    Given User launch Chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When Users clicks on Logout
    Then page title should be as "Your store. Login"
    And close the browser

@Regression
  Scenario Outline:Successful Login with valid Credentials
    Given User launch Chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "<email>" and password as "<password>"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When Users clicks on Logout
    Then page title should be as "Your store. Login"
    And close the browser
    Examples:
    |email|password|
    |admin@yourstore.com     |admin       |
    |test@yourstore.com      |admin       |




