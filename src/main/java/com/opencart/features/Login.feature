Feature: Login Related Test Cases

  @run
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
#    When the login form is populated with following details:
#      | <email>    |
#      | <password> |
    When the following form from "LoginPage" is populated as follow:
      | emailInput    | <email>    |
      | passwordInput | <password> |
    And the "loginBtn" from "LoginPage" is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email                 | password       | affectedAttribute |
      | medoniialex@gmail.com | The password!1 | password          |
      | medomail.com          | The password!1 | password          |

  @Regression
  Scenario Outline: Successful login is performed with valid credentials
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the following form from "LoginPage" is populated as follow:
      | emailInput    | <username> |
      | passwordInput | <password> |
    And the "loginBtn" from "LoginPage" is clicked
    Then the current url contains "account" keyword
    Examples:
      | username                  | password        |
      | stephen.kuvalis@gmail.com | i17980hpxdzpnwd |
      | myong,turner@yahoo.com    | et2r07t95c5pll  |