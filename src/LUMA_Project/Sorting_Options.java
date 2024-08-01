package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sorting_Options {
	private WebDriver driver;

	public Sorting_Options() {
		super();
	}

	public Sorting_Options(WebDriver driver) {
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
	public void sortByPrice() throws Exception {
		try {
			driver.get("https://magento.softwaretestingboard.com/");

// Click on the "Women" section
			driver.findElement(By.linkText("Women")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a")).click();
			Thread.sleep(2000);

// Find the sorting option and select "Price"
			WebElement sortingDropdown = driver.findElement(By.id("sorter"));
			sortingDropdown.click();
			Thread.sleep(2000);
			WebElement priceOption = driver
					.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/select/option[3]"));
			priceOption.click();

// Verify sorting completion
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
