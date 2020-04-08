@DataDrivenTesting
Feature: Linkedin Login Validation


  Scenario Outline: Linkedin Login Validation
    Given Open Chrome browser with URL
    When Search login link "<LoginLink>"
    And Click on link
    Then Saisir "<Login>" and "<Pwd>"
    
    
Examples: 

| Login                     | Pwd        | LoginLink     | 
| wajihwerghi3@gmail.com    | test123    | linkedinlogin |
| wajihwerghi@gmail.com     | 21290529   | linkedinlogin | 