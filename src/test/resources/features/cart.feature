Feature: Cart and checkout

  Background:
    Given the user is logged in as "standard_user" with password "shop123"

  Scenario: Adding a product updates the cart badge
    When the user adds product 1 to the cart
    Then the cart badge shows "Cart: 1"

  Scenario: Cart shows the items that were added
    When the user adds product 1 to the cart
    And the user adds product 2 to the cart
    And the user opens the cart
    Then the cart shows "Items in cart: 2"

  Scenario: Checkout with items places an order
    When the user adds product 3 to the cart
    And the user opens the cart
    And the user checks out
    Then the order confirmation shows "Order placed"

  Scenario: Checkout with an empty cart is blocked
    When the user opens the cart
    And the user checks out
    Then the order confirmation shows "Cart is empty"