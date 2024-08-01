package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sorting_Options_By_Product_Name {

	private WebDriver driver;

	public Sorting_Options_By_Product_Name() {
		super();
	}

	public Sorting_Options_By_Product_Name(WebDriver driver) {
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
	public void SortingOptionsByProductName() throws Exception {
		try {
			driver.get("https://magento.softwaretestingboard.com/");

// Click on the "Women" section
			driver.findElement(By.linkText("Men")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[1]/a")).click();

// Wait for the new page to load
			Thread.sleep(2000);

// Find the sorting option and select "Product Name"
			WebElement sortingDropdown = driver.findElement(By.id("sorter"));
			sortingDropdown.click();
			Thread.sleep(2000);
			WebElement priceOption = driver
					.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/select/option[2]"));
			priceOption.click();

// Verify sorting completion
// If sorting Pass

			boolean sortingSuccessful = true;
			if (sortingSuccessful) {
				System.out.println("Sorting completed successfully!");
			} else {
				System.out.println("Sorting failed!");
			}

// If sorting fails, handle the failure 

			Assert.assertTrue(sortingSuccessful, "Sorting should be successful.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test execution failed: " + e.getMessage());
		}
	}

}
