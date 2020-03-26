package com.cts.base;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;

public class LaunchWebDriver {
	// public static WebDriver driver;
public WebDriver driver;
	public void setUp(String browserName) {

		if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");

	}

	public void screenShots()
	{
		Date date = new Date();
		String dateStr = date.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File("src/test/resources/ScreenShots/image" + dateStr + ".png"));
	}

	@After
	public  void tearDown() {
		driver.quit();
	}
}
