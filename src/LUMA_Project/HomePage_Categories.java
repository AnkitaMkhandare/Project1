package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Categories {

	private WebDriver driver;

	public HomePage_Categories() {
		super();
	}

	public HomePage_Categories(WebDriver driver) {
		super();
		this.driver = driver;
	}

// open Browser
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
// Print Home Page Categories
	public void testHomePageCategories() throws Exception {
		try {
			driver.get("https://magento.softwaretestingboard.com/");

			driver.findElement(By.linkText("What's New"));
			driver.findElement(By.linkText("Women"));
			driver.findElement(By.linkText("Men"));
			driver.findElement(By.linkText("Gear"));
			driver.findElement(By.linkText("Training"));

			System.out.println("Categories on the homepage:");
			System.out.println("- What's New");
			System.out.println("- Women");
			System.out.println("- Men");
			System.out.println("- Gear");
			System.out.println("- Training");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@AfterMethod
	public void tearDown() {
// Clean up: Close the browser
		driver.quit();
	}
}