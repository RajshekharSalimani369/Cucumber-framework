Feature: Customers
Background:Common steps
  Given User launch Chrome browser
  When User opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  And User enters Email as "admin@yourstore.com" and password as "admin"
  And click on Login
  Then page title should be "Dashboard / nopCommerce administration"

  @Sanity
  Scenario:Add new customer
    When User clicks on Customers menu
    And User clicks on Customer
    And User clicks on Add new button
    When User enters customer info
    And clicks on Save button
    When Users clicks on Logout
    And close the browser

  @Regression
Scenario: search customer by email
  When User clicks on Customers menu
  And User clicks on Customer
  When User enters in customer email textbox
  When User clicks on search bar
  And close the browser

  @Sanity
Scenario:Search customer by Name
  When User clicks on Customers menu
  And User clicks on Customer
  And User enters FirstName
  And User enters LastName
  When User clicks on search bar
  And close the browser