package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements ConstantItems{

	public WebDriver driver;
	@BeforeTest
	public void OpenApp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@DataProvider(name = "loginData")
	public Object[][] passData(){
		Object[][] data = new Object[3][2];
		data[0][0] = "alok";
		data[0][1] = "alok";
		data[1][0] = "rajeev";
		data[1][1] = "rajeev";
		data[2][0] = "admin";
		data[2][1] = "manager";
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void loginData(String username , String password) throws InterruptedException{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();
		if(actualTitle.contains("Enter")){
			System.out.println("navidated to home page");
		}
		else
		{
			System.out.println("invalid credentials");
		}
	}
	@AfterTest
	public void closeApp(){
		driver.close();
	}
}
