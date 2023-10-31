@run
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

  Scenario: Register Page can be accessed from the Home Page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    And registerLink from Header menu is clicked
    When the register form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                         | lastName                          | emailData | passwordData |
      | First Name         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random                            | Random    | Random       |
      | Last Name          | Alexandru                         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random    | Random       |
      | First Name         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random                            | Random    | Random       |
      | Last Name          | Alexandru                         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random    | Random       |
      | First Name         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random                            | Random    | Random       |
      | Last Name          | Alexandru                         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random    | Random       |
      | First Name         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random                            | Random    | Random       |
      | Last Name          | Alexandru                         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random    | Random       |
      | First Name         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random                            | Random    | Random       |
      | Last Name          | Alexandru                         | asdv1s5dv1asd6v5ad1vad4513dfdcxz2 | Random    | Random       |
