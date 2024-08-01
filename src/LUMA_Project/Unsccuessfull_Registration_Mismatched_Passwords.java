package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Unsccuessfull_Registration_Mismatched_Passwords {

	private WebDriver driver;

	// open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testUnsuccessfulRegistration() throws Exception {
		// Open the registration page
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

		// Fill in mandatory fields
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Doe");
		driver.findElement(By.id("email_address")).sendKeys("john.doe@example.com");
		driver.findElement(By.id("password")).sendKeys("secretpassword##001"); // Valid Password
		driver.findElement(By.id("password-confirmation")).sendKeys("Differentpassword##001"); // Invalid Password
		Thread.sleep(2000);

		// Submit the form
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")).click();

		// Verify error message

		String expectedErrorMsg = "Please enter the same value again.";

		WebElement exp = driver.findElement(By.id("password-confirmation"));
		String actualErrorMsg = exp.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		// driver.navigate().to("https://magento.softwaretestingboard.com/");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}

}
