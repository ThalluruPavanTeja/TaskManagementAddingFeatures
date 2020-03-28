Feature: Modify Priorities 
	In order create a webpage
	As a task manager
	I want to get access to the portal
	

Scenario: LoginValidCredential 
	Given I have a browser 'ch' with TaskManagement Home Page 
	When I enter login details from Excel "src/test/resources/Excel/TaskManagement.xlsx" with SheetName "LoginDetails" 
	Then I should access to the portal with title as 'Administration' 
	
Scenario: addingPrioritiesTest 
	Given I have a browser 'ch' with Administration Page 
	When I enter Priority as  'New Priority' and clicking add button 
	Then 'New Priority' should be added in the Priority List 
	
	
Scenario: editingPrioritiesTest 
	Given I have a browser 'ch' with Administration Page 
	When I select Priority 'Highest' and  edited priority as 'New Highest' 
	Then 'New Highest' edited Priority details should be added in the Priority List 
	
Scenario: deletingPriorityTest 
	Given I have a browser 'ch' with Administration Page 
	When I select Priority 'Normal' and  deleted the priority 
	Then 'Normal' Priority details should be deleted from the Priority list 
	
	
Scenario: addingProjectsTest 
	Given I have a browser 'ch' with Administration Page 
	When I enter Project as  'New Project' and clicking add button 
	Then 'New Project' should be added in the Project List 
	
	
Scenario: editingProjectsTest 
	Given I have a browser 'ch' with Administration Page 
	When I select Project 'Test Project' and  edited Project as 'New Test Project' 
	Then 'New Test Project' edited Project details should be added in the Project List 
	
Scenario: deletingProjectsTest 
	Given I have a browser 'ch' with Administration Page 
	When I select Project 'My Project' and  deleted the project 
	Then 'My Project' Project details should be deleted from the Project list 
	
