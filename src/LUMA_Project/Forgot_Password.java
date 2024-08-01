package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Forgot_Password {

	private WebDriver driver;

//open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testForgotPassword() {
// Navigate to the "Forgot Password" page
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

// Click the "Forgot Password" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[2]/a"))
				.click();

// Again Enter the user's email address
		driver.findElement(By.id("email_address")).sendKeys("khandareanki@gmail.com");

// Click on Reset Password
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button/span")).click();

// If there is an account associated with khandareanki@gmail.com you will receive an email with a link to reset your password.

// Click on Link &  Rest the password 
		driver.findElement(By.id("password")).sendKeys("secretpassword##001");
		driver.findElement(By.id("password-confirmation")).sendKeys("secretpassword##001");

		WebElement successMessage = driver.findElement(By.id("success-message"));
		Assert.assertTrue(successMessage.isDisplayed(), ("Password reset success message not displayed."));

		driver.navigate().to("https://magento.softwaretestingboard.com/");

	}
}
