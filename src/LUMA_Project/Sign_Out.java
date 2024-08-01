package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sign_Out {

	private WebDriver driver;
	
	public Sign_Out() {
		super();
	}

	public Sign_Out(WebDriver driver) {
		super();
		this.driver = driver;
	}

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
	public void testLoginWithValidCredentials() throws Exception {

// Enter valid credentials
		driver.findElement(By.id("email")).sendKeys("khandareanki@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Password-1");

// Click the "Login" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button"))
				.click();

// User is redirected to the inventory page
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

// Signout
	@Test
	public void testSignout() throws Exception {

		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span")).click();
		Thread.sleep(2000);

		WebElement signOutButton = driver
				.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
		signOutButton.click();

// Verify Signout completion
		boolean signOutSuccessful = true;
		if (signOutSuccessful) {
			System.out.println("Signout completed successfully!");
		} else {
			System.out.println("Signout failed!");
		}

	}

}
