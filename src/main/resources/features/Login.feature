Feature: Login Action

#Scenario: Successful Login with Valid Credentials
Scenario Outline: Successful Login with Valid Credentials using Scenario
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters username and password
    And User enters "Thor123" and "dawgsss3350?"
    And User enters "<username>" and "<password>"
    #Then Message displayed Login Successfully
    
    Examples:
    | username   | password |
   | Thor123   | dawgsss3350? |
   