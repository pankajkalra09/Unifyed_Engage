@tag
Feature: We are checking the category CRUD operation here.
  I want to use this template for my feature file

  @Regression
  Scenario Outline: Category creation
    Given I landed onto enagage login page
    And logged in with username <username> and password <password>
    When I click on the profile drop down and click on the Preference option User is able to create a category with Name <categoryName>
    
    Then Browser close
    
    
Examples: 
      | username                    | password |          categoryName  |
      | philip_parker@unifyedqa.edu | Admin@2008 |    Automation20Sep_8 |
 