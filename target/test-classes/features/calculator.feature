##below line is how we add tag to a feature at feature level
  ## you can add more than 1 tag on anything
@calculator @non_ui
Feature: Calculator feature
  As a user,
  I should be able
  to use the calculator,
  that I can do arithmetic operations

  ##below line is how we add tag to a feature at scenario level
  @addition
  Scenario: Add 2 numbers
    Given calculator app is open
    When I add 5 with 4
    Then I should get result 9 displayed

    @smoke
  Scenario: Add 2 numbers
    Given calculator app is open
    When I add 2 with 3
    Then I should get result 5 displayed