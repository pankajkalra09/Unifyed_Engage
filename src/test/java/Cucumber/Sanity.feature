
@tag
Feature: Sanity check to ensure Login Logout is working fine.
  I want to use this template for my feature file

	Background:
	Given I landed onto enagage login page
	
  @tag2
  Scenario Outline: Login Logout checking
    Given logged in with username <username> and password <password>
    When I click on the profile drop down and click on the Logout option and click yes for the warning message
    Then "Verify" page title is showing up

    Examples: 
      | username  									| password | 
      | philip_parker@unifyedqa.edu | Admin@2008 |
