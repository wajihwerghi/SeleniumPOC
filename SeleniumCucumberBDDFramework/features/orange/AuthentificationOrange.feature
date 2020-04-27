@ParallelOrange1
Feature: valider l'authentication Orange
Background:l' utilisateur ouvre le navigateur et accade a la page d'accueil 
Given je suis sur la page d'authentication
  @UPCorrecte
  Scenario Outline: verifier l'authentication avec username et mots de passe correcte
   When Saisir le "<User>" et le "<Pwd>"
   And Cliquer sur le bouton login
   Then acceder a la page d'acceuil 
   
    
    
Examples:

| User    | Pwd         |
| Admin   | admin123    |

   @PIncorrecte
  Scenario Outline: verifier l'authentication avec mots de passe incorrecte
   When Saisir le "<User>" et le "<Pwd>"
   And Cliquer sur le bouton login
   Then  connection invalide
   
    
    
Examples:

| User    | Pwd         |
| Admin   | admin1234    |


