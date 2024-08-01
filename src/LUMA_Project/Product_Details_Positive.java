package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Product_Details_Positive {

	private WebDriver driver;

	public Product_Details_Positive() {
		super();
	}

	public Product_Details_Positive(WebDriver driver) {
		super();
		this.driver = driver;
	}

//open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
// Open the Inventory page
		driver.get("https://magento.softwaretestingboard.com");
	}

	@Test
	public void testProductDetails_Positive() throws Exception {
// Click on a product 
		WebElement SearchBox = driver
				.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[1]/div/input"));
		SearchBox.sendKeys("Affirm Water Bottle");
		Thread.sleep(2000);
		SearchBox.click();
		Thread.sleep(2000);
		driver.navigate().to(("https://magento.softwaretestingboard.com/affirm-water-bottle.html"));

// Validate product details
		String expectedName = "Affirm Water Bottle";
		String expectedDescription = "You'll stay hydrated with ease with the Affirm Water Bottle by your side or in hand. Measurements on the outside help you keep track of how much you're drinking, while the screw-top lid prevents spills. A metal carabiner clip allows you to attach it to the outside of a backpack or bag for easy access.";
		String expectedPrice = "$7.00";
		String expectedRating = "***";

		System.out.println("Categories on the homepage:" + expectedName);
		System.out.println("Categories on the homepage:" + expectedDescription);
		System.out.println("Categories on the homepage:" + expectedPrice);
		System.out.println("Categories on the homepage:" + expectedRating);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
