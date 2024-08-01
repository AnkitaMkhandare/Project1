package LUMA_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Add_Multiple_Items_To_Cart_Positive {

	private WebDriver driver;
	public Add_Multiple_Items_To_Cart_Positive() {
		super();
	}

	public Add_Multiple_Items_To_Cart_Positive(WebDriver driver) {
		super();
		this.driver = driver;
	}
//open Browser
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void navigateToWomenSection() throws Exception {
		driver.get("https://magento.softwaretestingboard.com/");

// Click on the "Women" section
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);

	}

// click On Product
	@Test(priority = 2)
	public void clickOnProduct() {

		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 3)
	public void selectSizeAndColor() {
// Click on the M size (or any other size you want)
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]"))
				.click();

// Select color
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[1]"))
				.click();
	}

	@Test(priority = 4)
	public void addToCart() {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
	}

	@Test(priority = 5)
	public void verifyCartContent() throws Exception {
// Go to the cart page
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void navigateToMenSection() throws Exception {
// Click on the "Men" section
		driver.findElement(By.linkText("Men")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[2]/li[1]/a")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void clickOnMenProduct() {

		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 8)
	public void selectSizeAndColorOfProduct() {
// Select size
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[4]"))
				.click();

// Select color
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[2]"))
				.click();
	}

	@Test(priority = 9)
	public void addToCartButton() {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
	}

	@Test(priority = 10)
	public void verifyCartContents() throws Exception {
// Go to the cart page
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");
		Thread.sleep(2000);

	}

	@Test(priority = 11)
	public void showProductCountAndTotal() {

// Assuming you've added multiple products to the cart
		List<WebElement> cartItems = driver
				.findElements(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")); 
																									

		int productCount = cartItems.size();
		System.out.println("Product Count in Cart: " + productCount);

		double total = 0.0;
		for (WebElement cartItem : cartItems) {

// Extract the price for each product 
			WebElement priceElement = cartItem
					.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"));
			double price = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
			total += price;
		}

		System.out.println("Total Price: $" + total);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
