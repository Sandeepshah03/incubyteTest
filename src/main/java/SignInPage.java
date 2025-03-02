package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SignInPage {

    public static void main(String[] args) throws IOException {
        // Load data from properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Incubyte\\src\\main\\java\\config.properties");
        prop.load(fis);

        // Get the sign-in URL and credentials from the properties file
        String signInUrl = prop.getProperty("signInUrl");
        String email = prop.getProperty("signInEmail");
        String password = prop.getProperty("signInPassword");

        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the sign-in page
        driver.get(signInUrl);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for email input field to be visible and enter value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys(email);

        // Enter password
        driver.findElement(By.id("pass")).sendKeys(password);

        // Click on the sign-in button
        driver.findElement(By.id("send2")).click();

        // Wait for the page to load after login
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Print the current URL and page title after the sign-in attempt
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
