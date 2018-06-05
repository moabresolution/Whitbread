Feature: Add Product to Cart
  Description:

  Scenario: Add product to cart and verify product added
    Given I navigated to amazon.co.uk
    When I search the "item"
    And I selected added second item on the list
    And I click on cart
    Then I verify Item added