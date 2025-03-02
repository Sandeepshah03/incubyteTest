package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPage {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		Thread.sleep(2000);
		driver.findElement(By.id("firstname")).sendKeys("Account");
		Thread.sleep(2000);
		driver.findElement(By.id("email_address")).sendKeys("test.account123@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("test123");
		Thread.sleep(2000);
		driver.findElement(By.id("password_confirmation")).sendKeys("test123");
		
		driver.findElement(By.cssSelector("button[title='Create an Account']")).click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
	
		
	}

}
