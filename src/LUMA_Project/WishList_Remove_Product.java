package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WishList_Remove_Product {

	private WebDriver driver;

	public WishList_Remove_Product() {
		super();
	}

	public WishList_Remove_Product(WebDriver driver) {
		super();
		this.driver = driver;
	}

// open Browser
	@BeforeSuite
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testLoginWithValidCredentials() {

// Navigate to the login page
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/");

// Enter valid credentials

		driver.findElement(By.id("email")).sendKeys("khandareanki@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Password-1");

// Click the "SignIn" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button"))
				.click();
	}

	@Test(priority = 2)
	public void addToWishlistTest() throws Exception {
		driver.get("https://magento.softwaretestingboard.com/");

// Go to the product page
		driver.findElement(By.linkText("Men")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"))
				.click();

//Add to Wishlist
		WebElement wishlistButton = driver
				.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]"));

		wishlistButton.click();

	}

// Remove from wishlist

	@Test(priority = 3)
	public void removeFromWishlistTest() throws Exception {

// Locate the product you want to remove
		Thread.sleep(2000);
		driver.navigate().refresh();

// Click the remove button

		WebElement productToRemove = driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div[3]/div[3]/div[2]/ol/li/div/div/div[2]/div[2]/a"));

		productToRemove.click();
		driver.navigate().refresh();

	}

// locate the product elements and count them
	@Test(priority = 4)
	public void totalProductsInWishlist() {

		int numberOfProducts = driver.findElements(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div/p/span"))
				.size();
		System.out.println("Total number of products in the cart: " + numberOfProducts);

	}
}
