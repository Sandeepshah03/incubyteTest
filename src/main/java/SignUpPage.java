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

public class SignUpPage {

    public static void main(String[] args) throws IOException {
        // Load data from properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Incubyte\\src\\main\\java\\config.properties");
//enter property file location
        prop.load(fis);

        // Get the sign-up URL and credentials from the properties file
        String signUpUrl = prop.getProperty("signUpUrl");
        String firstName = prop.getProperty("signUpFirstName");
        String lastName = prop.getProperty("signUpLastName");
        String email = prop.getProperty("signUpEmail");
        String password = prop.getProperty("signUpPassword");
        String confirmPassword = prop.getProperty("signUpConfirmPassword");

        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the sign-up page
        driver.get(signUpUrl);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for first name field to be visible and enter value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        driver.findElement(By.id("firstname")).sendKeys(firstName);

        // Enter last name
        //Thread.sleep(1000); // think time can be added to other elements as well
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        // Enter email
        driver.findElement(By.id("email_address")).sendKeys(email);

        // Enter password
        driver.findElement(By.id("password")).sendKeys(password);

        // Enter confirm password
        driver.findElement(By.id("password-confirmation")).sendKeys(confirmPassword);

        // Wait for the create account button to be clickable and click
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Create an Account']")));
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();

        // Print the current URL and page title after the sign-up attempt
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
