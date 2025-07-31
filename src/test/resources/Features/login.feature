Feature: create a login sceario

  @test1 @Smoke
  Scenario: Login with valid credentials
    Given login sceario
    When I enter the username
    And I enter the pasword
    Then I validate the username and password

  @test2  @Smoke
  Scenario: Login with valid credentials
    Given login sceario
    When I enter the username
    And I enter the pasword
    Then I validate the username and password

  @test3
  Scenario: Login with valid credentials
    Given login sceario
    When I enter the username
    And I enter the pasword
    Then I validate the username and password

