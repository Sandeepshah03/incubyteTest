package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
 
		System.out.println(driver.getTitle());
		Thread.sleep(2000);  // think time added
		driver.findElement(By.id("email")).sendKeys("test.account123@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("test@123");
		driver.findElement(By.id("send2")).click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
		driver.close();
		}

}
