@Orange
Feature: Orange Login Validation
  
  Scenario Outline: Orange Login Validation
   Given Open Chrome browser with URL
   When Click on link
   Then Saisir "<Login>" and "<Pwd>"
    
    
Examples:

| user    | Pwd        |
| Admin   | test123    |
