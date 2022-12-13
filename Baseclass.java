package com.day.com; hi

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.desktop.QuitResponse;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;



public class Baseclass {
	public static WebDriver driver;

	public static WebDriver browserlaunch(String browsername) {
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\PUVI\\eclipse-workspace\\mavenproject\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid browser");
		}
		return driver;
	}

	public static void launchurl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void getpagetitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

	public static void screenshot() throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File sou = shot.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\PUVI\\eclipse-workspace\\mavenproject\\screenshot\\ss2.png");
		FileUtils.copyFile(sou, des);
	}

	public static void navigateto(String value) {
		driver.navigate().to(value);

	}

	public static void navigateback() {
		driver.navigate().back();

	}

	public static void navigateforward() {
		driver.navigate().forward();

	}

	public static void navigaterefresh() {
		driver.navigate().refresh();

	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendkey(WebElement element, String values) {
		element.sendKeys(values);

	}

	public static void select(WebElement element, String value, String method) {
		Select s = new Select(element);
		if (method.equalsIgnoreCase("val")) {
			s.selectByValue(value);
		} else if (method.equalsIgnoreCase("vis")) {
			s.selectByVisibleText(value);
		} else if (method.equalsIgnoreCase("index")) {
			int i = Integer.parseInt(value);
			s.selectByIndex(i);
		}
	}

	public static void select2(WebElement element, String value, String method) {
		Select s = new Select(element);
		if (method.equalsIgnoreCase("first")) {
			s.getFirstSelectedOption();
		} else if (method.equalsIgnoreCase("all")) {
			s.getAllSelectedOptions();
		}
	}

	public static void Wait(TimeUnit Seconds) {
		driver.manage().timeouts().implicitlyWait(6, Seconds);

	}

	public static void windowhandles() {

	}

	public static void alert(String value, String method) {
		if (method.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (method.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (method.equalsIgnoreCase("sendkey")) {
			driver.switchTo().alert().sendKeys(value);
		}

	}

	public static void scrollupanddown() {

	}

	public static void action(String value, String method, WebElement element) {
		Actions ac = new Actions(driver);
		if (method.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick();
		} else if (method.equalsIgnoreCase("move")) {
			ac.moveToElement(element);
		} else if (method.equalsIgnoreCase("drag")) {
			ac.dragAndDrop(element, element);

		} else if (method.equalsIgnoreCase("hold")) {
			ac.dragAndDrop(element, element);
		}
	}

	public static void frame(int num) {
		driver.switchTo().frame(num);

	}

	public static void robot() throws AWTException {
		Robot r = new Robot();
	}

	public static void radio(WebElement element, String method) {
		if (method.equalsIgnoreCase("click")) {
			element.click();
		} else if (method.equalsIgnoreCase("clear")) {
			element.clear();
		}
	}

}
