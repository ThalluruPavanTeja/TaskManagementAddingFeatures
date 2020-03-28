package com.cts.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cts.base.LaunchWebDriver;
import com.cts.pages.AdministrationPage;
import com.cts.pages.HomePage;
import com.cts.pages.PriorityListPage;
import com.cts.pages.ProjectListPage;
import com.cts.utils.Excel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriorityStepDefinition {
	LaunchWebDriver launchWebDriver = new LaunchWebDriver();
	public WebDriver driver;

	@Given("I have a browser {string} with TaskManagement Home Page")
	public void i_have_a_browser_with_TaskManagement_Home_Page(String browserName) {
		// Launching browser with Task Management home page
		launchWebDriver.setUp(browserName);
		this.driver = launchWebDriver.driver;
	}

	@When("I enter login details from Excel {string} with SheetName {string}")
	public void i_enter_login_details_from_Excel_with_SheetName(String fileDetails, String sheetName)
			throws IOException {
		// class objects of pages
		Excel excel = new Excel();
		HomePage homePage = new HomePage(driver);

		// Reading Login Credentials from Excel
		String[][] loginData = excel.excelReading(fileDetails, sheetName);

		// Entering user name and password and clicking on login button
		homePage.accountLogin(loginData[0][0], loginData[0][1]);
	}

	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		String actualTitle = administrationPage.actualTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			Assert.assertTrue("Assertion Failed", actualTitle.equalsIgnoreCase(expectedTitle));
		} else {
			Assert.fail("Assertion Failed");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@Given("I have a browser {string} with Administration Page")
	public void i_have_a_browser_with_Administration_Page(String browserName) throws IOException {
		// Launch browser with Task Management administration page
		launchWebDriver.setUp(browserName);
		this.driver = launchWebDriver.driver;
		
		// class objects of pages
		Excel excel = new Excel();
		HomePage homePage = new HomePage(driver);

		// Reading Login Credentials from Excel
		String[][] loginData = excel.excelReading("src/test/resources/Excel/TaskManagement.xlsx", "LoginDetails");
		
		// Entering user name and password and clicking on login button
		homePage.accountLogin(loginData[0][0], loginData[0][1]);
	}

	@When("I enter Priority as  {string} and clicking add button")
	public void i_enter_Priority_as_and_clicking_add_button(String priorityText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);

		// Clicking on  priority
		administrationPage.clickingPriorities();
		// Enter text and click on add
		priorityListPage.addingPriority(priorityText);
	}

	@Then("{string} should be added in the Priority List")
	public void should_be_added_in_the_Priority_List(String priorityText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = priorityListPage.assertionData();

		if (cellData.contains(priorityText)) {
			Assert.assertTrue("Assertion Failed", cellData.contains(priorityText));
		} else {
			Assert.fail("Assertion Failed");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@When("I select Priority {string} and  edited priority as {string}")
	public void i_select_Priority_and_edited_priority_as(String editingPriority, String editingText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);

		// Click on priority
		administrationPage.clickingPriorities();
		// Editing priority text
		priorityListPage.editingPriority(editingPriority, editingText);
	}

	@Then("{string} edited Priority details should be added in the Priority List")
	public void edited_Priority_details_should_be_added_in_the_Priority_List(String editingText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = priorityListPage.assertionData();

		if (cellData.contains(editingText)) {
			Assert.assertTrue("Assertion Failed", cellData.contains(editingText));
		} else {
			Assert.fail("Assertion Failed");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@When("I select Priority {string} and  deleted the priority")
	public void i_select_Priority_and_deleted_the_priority(String deletingPriority) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);

		// Click on priority
		administrationPage.clickingPriorities();
		// Deleting priority
		priorityListPage.deletingPriority(deletingPriority);
	}

	@Then("{string} Priority details should be deleted from the Priority list")
	public void priority_details_should_be_deleted_from_the_Priority_list(String deletingPriority) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		PriorityListPage priorityListPage = new PriorityListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = priorityListPage.assertionData();

		if (cellData.contains(deletingPriority)) {
			Assert.fail("Assertion Failed");
		} else {
			System.out.println("Assertion passed ");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@When("I enter Project as  {string} and clicking add button")
	public void i_enter_Project_as_and_clicking_add_button(String projectText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);

		// Click on project
		administrationPage.clickingProjects();
		// Add project
		projectListPage.addingProject(projectText);
	}

	@Then("{string} should be added in the Project List")
	public void should_be_added_in_the_Project_List(String projectText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = projectListPage.assertionData();
		if (cellData.contains(projectText)) {
			Assert.assertTrue("Assertion Failed", cellData.contains(projectText));
		} else {
			Assert.fail("Assertion Failed");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@When("I select Project {string} and  edited Project as {string}")
	public void i_select_Project_and_edited_Project_as(String editingProject, String editingText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);

		// Click on project
		administrationPage.clickingProjects();
		// Editing project list
		projectListPage.editingProject(editingProject, editingText);

	}

	@Then("{string} edited Project details should be added in the Project List")
	public void edited_Project_details_should_be_added_in_the_Project_List(String editingText) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = projectListPage.assertionData();
		if (cellData.contains(editingText)) {
			Assert.assertTrue("Assertion Failed", cellData.contains(editingText));
		} else {
			Assert.fail("Assertion Failed");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}

	@When("I select Project {string} and  deleted the project")
	public void i_select_Project_and_deleted_the_project(String deletingProject) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);

		// Click on project
		administrationPage.clickingProjects();
		// Deleting the project
		projectListPage.deletingProject(deletingProject);
	}

	@Then("{string} Project details should be deleted from the Project list")
	public void project_details_should_be_deleted_from_the_Project_list(String deletingProject) {
		// class objects of pages
		AdministrationPage administrationPage = new AdministrationPage(driver);
		ProjectListPage projectListPage = new ProjectListPage(driver);
		HomePage homePage = new HomePage(driver);

		// Assertion
		List<String> cellData = projectListPage.assertionData();
		if (cellData.contains(deletingProject)) {
			Assert.fail("Assertion Failed");
		} else {
			System.out.println("Assertion passed ");
		}
		// screenshots
		launchWebDriver.screenShots();

		// Click on administration icon
		homePage.clickingAdministrator();

		// Click on logout button
		administrationPage.clickingLogout();

		// Close the browser
		launchWebDriver.tearDown();

	}
}
