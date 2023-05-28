Feature: This feature will be used to test the add to cart functionlity of saucedemo.com
Background: 
    Given I have launched the application
    When I enter username as "standard_user"
    And I enter password as "secret_sauce"
    And Click on login
    

Scenario: Login Success Scenario using parameter
   When I click add to cart for product "Sauce Labs Backpack"
   And I click view cart to check product added
   Then I should be able to see the product as "Sauce Labs Backpack"