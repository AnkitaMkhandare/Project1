package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Unsccuessfull_Registration_Weak_Password {

	private WebDriver driver;

	// open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testSuccessfulRegistration() throws Exception {
		// Open the registration page
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

		// Fill in mandatory fields
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Doe");
		driver.findElement(By.id("email_address")).sendKeys("john.doe@example.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("weak");
		Thread.sleep(2000);
		driver.findElement(By.id("password-confirmation")).sendKeys("weak");
		Thread.sleep(2000);

		// Submit the form
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")).click();
		// driver.navigate().to("https://magento.softwaretestingboard.com/");

		// Verify error message

		String expectedErrorMsg = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";

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
