package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Add_Items_To_Cart_Positive {

	private WebDriver driver;
	
	public Add_Items_To_Cart_Positive() {
		super();
	}

	public Add_Items_To_Cart_Positive(WebDriver driver) {
		super();
		this.driver = driver;
	}
//Open Browser
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

//click On Product
	@Test(priority = 2)
	public void clickOnProduct() {

		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]/div/a/span/span/img"))
				.click();
	}

	@Test(priority = 3)
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

	@Test(priority = 4)
	public void addToCart() {
// Click on the "Add to Cart" button
		driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();
	}

	@Test(priority = 5)
	public void verifyCartContents() {
// Go to the cart page
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/cart/");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
