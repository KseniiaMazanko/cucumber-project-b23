Feature: Demonstrating the data table feature of cucumber

  Cucumber provide ability to organize repeating steps with different data
  using the data table feature and automatically convert the table into
  few known data types supported by cucumber

  Scenario: Petting zoo
    Given I have a "horse"
    And I have a "dog"
    And I have a "turtle"
    And I have a "zebra"
    When I call their names
    Then They come to me.

  Scenario: Petting zoo with table
    Given I have following animals
    #if I want it nicely aligned -> Command+Option+L
      | horse  |
      | dog    |
      | turtle |
      | zebra  |
    When I call their names with below names
      | Kira  |
      | Spike |
      | Max   |
      | Lilu  |
    Then They come to me wit below noises
      | horse  | Nai |
      | dog    | Woof|
      | turtle | Hiss|
      | zebra  | Bro |

    @ui
  Scenario: Login to weborder app by providing username password in 2 column table

    Given we are at web order login page
    When we provide below credentials
      | username | Tester |
      | password | test   |
    Then we should see all order page


  Scenario: Representing table with header and more than 2 columns with list of map
    Given this is the product reference
      | Product     | Price | Discount |
      | MyMoney     | 100   | 0.08     |
      | FamilyAlbum | 80    | 0.15     |
      | ScreenSaver | 20    | 0.1      |


    And I have another product reference without header
      | MyMoney     | 100   | 0.08     |
      | FamilyAlbum | 80    | 0.15     |
      | ScreenSaver | 20    | 0.1      |




