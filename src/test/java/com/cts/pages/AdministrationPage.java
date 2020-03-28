package com.cts.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cts.base.LaunchWebDriver;

public class AdministrationPage {

//	private By addTaskIconLoc = By.xpath("//img[@src='images/add-task-button.gif']");
//	private By taskListLoc = By.xpath("//img[@src='images/task-list-button.gif']");

	private By employeesLoc = By.xpath("//a[text()='Employees']");
	private By prioritiesLoc = By.xpath("//a[text()='Priorities']");
	private By projectsLoc = By.xpath("//a[text()='Projects']");
	private By statusesLoc = By.xpath("//a[text()='Statuses']");
	private By typesLoc = By.xpath("//a[text()='Types']");
//	private By employeeLoc = By.linkText("Employees");
//	private By projectLoc = By.linkText("Projects");
//	private By tableLoc = By.xpath(" //table[@class='Grid']//tbody//tr");
	private By logoutLoc = By.linkText("Logout");
	// private By errorTextLoc = By.xpath("//td[contains(text(),'Login or Password
	// is incorrect.')]");

	private WebDriver driver;

	public AdministrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickingEmployees() {
		driver.findElement(employeesLoc).click();
	}

	public void clickingPriorities() {
		driver.findElement(prioritiesLoc).click();
	}

	public void clickingProjects() {
		driver.findElement(projectsLoc).click();
	}

	public void clickingStatuses() {
		driver.findElement(statusesLoc).click();
	}

	public void clickingTypes() {
		driver.findElement(typesLoc).click();
	}

	public void clickingLogout() {
		driver.findElement(logoutLoc).click();
	}
	
	public String actualTitle()
	{
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

}
