package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckOut_Payment_Process {

	private WebDriver driver;

	public CheckOut_Payment_Process() {
		super();
	}

	public CheckOut_Payment_Process(WebDriver driver) {
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
	public void navigateToWomenSection() throws Exception {
// Open the e-commerce website		
		driver.get("https://magento.softwaretestingboard.com/");
		// Click on the "Women" section
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void clickProduct() {
// Click on the product
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 4)
	public void selectSizeAndColor() {
// Click on the M size
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]"))
				.click();

// Select color
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[1]"))
				.click();
	}

	@Test(priority = 5)
	public void addToCart() throws Exception {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void verifyCartContents() throws Exception {
// Go to the cart page (you'll need to navigate to the appropriate URL)
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");
		Thread.sleep(2000);
	}

// Click "Proceed to Checkout" button

	@Test(priority = 7)
	public void proceedToCheckoutButton() throws Exception {

		WebElement stickyboxhide = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]"));
		stickyboxhide.click();
		Thread.sleep(2000);
		WebElement proceedToCheckoutButton = driver
				.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
		proceedToCheckoutButton.click();

		Thread.sleep(2000);
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");

	}

	@Test(priority = 8)
	public void ShippingAddress() throws Exception {

// Fill in mandatory fields if account is not created

// Email ID & password
		driver.findElement(By.id("customer-email")).sendKeys("khandareanki@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("customer-password")).sendKeys("password-1");

// User first name & last name
		driver.findElement(By.name("firstname")).sendKeys("John");
		driver.findElement(By.name("lastname")).sendKeys("Doe");

// Address
		driver.findElement(By.name("street[0]")).sendKeys("XXXX");

// City
		driver.findElement(By.name("city")).sendKeys("Mumbai");

//Country
		driver.findElement(By.name("country_id")).sendKeys("India");

//  State 

		driver.findElement(By.name("region_id")).sendKeys("Maharashra");

// Pincode		
		driver.findElement(By.name("postcode")).sendKeys(" 400001");

// Phone number
		driver.findElement(By.name("telephone")).sendKeys("9988357398");
		Thread.sleep(2000);

// Select the Radio Button
//		WebElement radio_button = driver.findElement(By.xpath(
//				"/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]"));
//		radio_button.click();

// Click on Next button	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(2000);
		WebElement next_button = driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button"));
		next_button.click();
		Thread.sleep(2000);

		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#payment");
		Thread.sleep(2000);
	}

	@Test(priority = 9)
	public void paymentMethod() throws Exception {
//Payment		
		WebElement placeOrder_button = driver.findElement(By.xpath(
				"/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button/span"));
		placeOrder_button.click();

//Thank you for your purchase! page		
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/onepage/success/");
		Thread.sleep(2000);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
