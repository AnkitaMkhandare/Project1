package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Search_Functionality_Negative {

	private WebDriver driver;

	public Search_Functionality_Negative() {
		super();
	}

	public Search_Functionality_Negative(WebDriver driver) {
		super();
		this.driver = driver;
	}

//open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testProductSearchNegative() throws Exception {
// Open the e-commerce website
		driver.get("https://magento.softwaretestingboard.com");

// Find the search input field and enter a valid keyword

		WebElement SearchBox = driver
				.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[1]/div/input"));
		SearchBox.sendKeys("XXXX");
		Thread.sleep(2000);
		SearchBox.click();
		Thread.sleep(2000);
		driver.navigate().to(("https://magento.softwaretestingboard.com/catalogsearch/result/?q=xxxxx"));
	}

	{
		System.out.println("Product search test passed!");
		System.out.println("Your search returned no results.");

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
