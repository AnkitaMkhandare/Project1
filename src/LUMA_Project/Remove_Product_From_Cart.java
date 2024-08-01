package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Remove_Product_From_Cart {

	private WebDriver driver;

	public Remove_Product_From_Cart() {
		super();
	}

	public Remove_Product_From_Cart(WebDriver driver) {
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
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[1]/a")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void clickProduct() {
// Select Product
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 3)
	public void selectSizeAndColor() {
// Click on the size 
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[1]"))
				.click();

// Select color
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[3]"))
				.click();
	}

	@Test(priority = 4)
	public void addToCart() throws Exception {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void verifyCartContents() throws Exception {
// Go to the cart page 
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void navigateToGearSection() throws Exception {
// Click on the "Gear" section
		driver.findElement(By.linkText("Gear")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[2]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void clickOnGearProduct() {

		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[9]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 8)
	public void addToCartButton1() {
// Click on the "Add to Cart" button
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div/div/div[2]/button"))
				.click();
	}

	@Test(priority = 9)
	public void navigateToMenSection() throws Exception {
// Click on the "Men" section
		driver.findElement(By.linkText("Men")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[2]/li[1]/a")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 10)
	public void clickOnMenProduct() {

		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 11)
	public void selectSizeAndColorOfProduct() {
// Click on the size 
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[4]"))
				.click();

// Select color
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[2]"))
				.click();
	}

	@Test(priority = 12)
	public void addToCartButton() {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
	}

	@Test(priority = 13)
	public void verifyCartContent() throws Exception {
// Go to the cart page
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");
		Thread.sleep(2000);
	}

//Remove the first product from the cart
	@Test(priority = 14)
	public void testShoppingCart() throws Exception {

		WebElement firstProductRemoveButton = driver.findElement(By.xpath(
				"/html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody/tr[2]/td/div/a[@title='Remove item']"));
		// /html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody[1]/tr[2]/td/div/a[3]
		// /html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody/tr[2]/td/div/a[2]
		// /html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody[1]/tr[2]/td/div/a[3]
		firstProductRemoveButton.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test(priority = 15)
	public void showProductCountAndTotal() {
// Assuming you've added multiple products to the cart

		WebElement productCount = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]"));
		// T--> /html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]
		/// html/body/div[2]/header/div[2]/div[1]/a/span[2]

		System.out.println("Product Count in Cart: " + productCount.getText());

// Extract the price for each product
		WebElement priceElement = driver.findElement(By
				.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"));
		// T---> //span[@class='price']

		/// html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span

		System.out.println("Total Price: " + priceElement.getText());

	}

	// @AfterSuite
	// public void tearDown() {
	// driver.quit();
}
