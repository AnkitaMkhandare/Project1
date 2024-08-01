package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Invalid_Sign_In {

	private WebDriver driver;
//open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
// Navigate to the login page
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/");
	}

	@Test
	public void testLoginWithValidCredentials() {

// Enter valid credentials
		driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
		driver.findElement(By.id("pass")).sendKeys("secretpassword##0000000"); // Invalid Password

// Click the "Login" button
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button")).click();

// Verify error message
        WebElement errorMessage = driver.findElement(By.id("pass"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Test passed: Invalid credentials handled correctly.");
        } else {
            System.out.println("Test failed: Unexpected error message.");
        }

// Clean up (close browser.)
        driver.quit();
    }


	}



