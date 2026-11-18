# Test Cases

| ID | Area | Title | Type | Expected result |
|----|------|-------|------|-----------------|
| TC-01 | Login | Valid login | Functional | Products screen is shown |
| TC-02 | Login | Wrong password | Negative | Error "Invalid username or password" |
| TC-03 | Login | Empty username | Negative | Same error shown |
| TC-04 | Login | Empty password | Negative | Same error shown |
| TC-05 | Login | Unknown user | Negative | Same error shown |
| TC-06 | Login | Password is case sensitive | Negative | Same error shown |
| TC-07 | Cart | Add one product | Functional | Badge shows "Cart: 1" |
| TC-08 | Cart | Add two products, open cart | Functional | "Items in cart: 2" |
| TC-09 | Cart | Add same product twice | Regression | Badge shows "Cart: 2" |
| TC-10 | Cart | Add all three products | Regression | "Items in cart: 3" |
| TC-11 | Cart | Badge after Back from cart | Regression | Badge still "Cart: 1" |
| TC-12 | Checkout | Checkout with items | Functional | "Order placed" |
| TC-13 | Checkout | Checkout with empty cart | Negative | "Cart is empty" |