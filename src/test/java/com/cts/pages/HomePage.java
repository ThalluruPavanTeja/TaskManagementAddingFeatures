package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cts.base.LaunchWebDriver;

public class HomePage {
	private By myAdminLoc = By.xpath("//a[@href='Administration.php']");
	//private By administrationLoc = By.xpath("//a[@href='Administration.php']");
	private By loginLoc = By.xpath("//input[@name='login']");
	private By passwordLoc = By.xpath("//input[@name='password']");
	private By submitLoc = By.xpath("//input[@name='DoLogin']");
	private By taskListLoc = By.xpath("//img[@src='images/task-list-button.gif']");
	private By administratorLoc = By.xpath("//img[@src='images/administration-button.gif']");
	//private By addTaskLoc = By.xpath("//img[@src='images/add-task-button.gif']");
	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void clickingMyAccountIcon() {
		driver.findElement(myAdminLoc).click();
	}

	public void accountLogin(String login, String password) {
		driver.findElement(administratorLoc).click();
		driver.findElement(loginLoc).sendKeys(login);
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(submitLoc).click();
	}
	
	public void clickingTaskList()
	{
		driver.findElement(taskListLoc).click();
				
	}
	
	public void clickingAdministrator() 
	{
		driver.findElement(administratorLoc).click();
	}

}
