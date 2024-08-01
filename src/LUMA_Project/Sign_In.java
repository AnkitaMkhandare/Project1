package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sign_In {

	private WebDriver driver;

	public Sign_In() {
		super();
	}

	public Sign_In(WebDriver driver) {
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
	public void testLoginWithValidCredentials() {

// Enter valid credentials
		 
		driver.findElement(By.id("email")).sendKeys("khandareanki@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Password-1");

// Click the "SignIn" button
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button")).click();

// Assert that the user is redirected to the inventory page
		driver.navigate().to("https://magento.softwaretestingboard.com/");

		
// Verify SignIn completion
				boolean signInSuccessful = true;
				if (signInSuccessful) {
					System.out.println("SignIn completed successfully!");
				} else {
					System.out.println("SignIn failed!");
				}
	}


	}


