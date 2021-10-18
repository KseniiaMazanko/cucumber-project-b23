
@ui
Feature: Weborder app should work as expected


  Scenario: User should see all product from the list according to available product
    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then we should see below options Product dropdown list
      | MyMoney     |
      | FamilyAlbum |
      | ScreenSaver |


    #Homework Task1
  Scenario: User should see side bar tabs as expected

    Given we are at web order login page
    When we provide valid credentials
    Then we should see all order page
    Then side bar tabs should be as below
      | View all orders   |
      | View all products |
      | Order             |


    #Homework Task2
  Scenario: User should see product table as expected
    Given we are at web order login page
    And we provide valid credentials
    When we select "View all products" tab from sidebar
    Then we should see table with below content
    # for the sake of simplicity below table is modified to match exactly to actual table
      | Product name| Price | Discount |
      | MyMoney     | $100  | 8%       |
      | FamilyAlbum | $80   | 15%      |
      | ScreenSaver | $20   | 10%      |

    #Homework Task 3

  Scenario: User should see correct product price generated

    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then we should see three section as below
      |Product Information|
      |Address Information|
      |Payment Information|
    And select each product from dropdown should change the unit price accordingly
      | ScreenSaver | 20   |
      | MyMoney     | 100  |
      | FamilyAlbum | 80   |
      # you need to loop to select each item and assert unit price box



