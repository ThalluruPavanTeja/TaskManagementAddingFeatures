package com.cts.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriorityListPage {
	private By newPriorityLoc = By.xpath("//a[text()='Add New Priority']");
	private By priorityTextLoc = By.xpath("//input[@name='priority_name']");
	private By addLoc = By.xpath("//input[@name='Insert']");
	private By submitLoc = By.xpath("//input[@name='Update']");
	private By deleteLoc = By.xpath("//input[@name='Delete']");
	private By tableLoc = By.xpath("//table[@class='Grid']//tbody//tr");
	private WebDriver driver;

	public PriorityListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addingPriority(String priorityText) {
		driver.findElement(newPriorityLoc).click();
		driver.findElement(priorityTextLoc).sendKeys(priorityText);
		driver.findElement(addLoc).click();
	}

	public void editingPriority(String editingPriority, String editingText) {
		driver.findElement(By.xpath("//a[text()='" + editingPriority + "']")).click();
		driver.findElement(priorityTextLoc).clear();
		driver.findElement(priorityTextLoc).sendKeys(editingText);
		driver.findElement(submitLoc).click();
	}

	public void deletingPriority(String deletingPriority) {
		driver.findElement(By.xpath("//a[text()='" + deletingPriority + "']")).click();
		driver.findElement(deleteLoc).click();
	}

	public List<String> assertionData() {
		List<String> cellData = new ArrayList<String>();
		List<WebElement> rowList = driver.findElements(tableLoc);
		for (WebElement row : rowList) {
			List<WebElement> cellList = row.findElements(By.tagName("td"));
			for (WebElement cell : cellList) {
				String data = cell.getText();
				cellData.add(data);
				System.out.println(cellData);
			}
		}
		return cellData;
	}

}
