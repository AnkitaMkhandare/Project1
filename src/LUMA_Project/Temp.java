package LUMA_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Temp {

	private WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void navigateToWomenSection() throws Exception {
		driver.get("https://magento.softwaretestingboard.com/");
	}

	@Test(priority = 3)
	public void Search() {
		WebElement SearchBox = driver.findElement(By.name("q"));
		SearchBox.sendKeys("Fitness equipment");
		SearchBox.click();
		driver.findElement(By.xpath("//li[@id='qs-option-0']")).click();
	}

	@Test(priority = 4)
	public void women() {
		WebElement Women = driver.findElement(By.xpath("//a[@id='ui-id-4']/child::span[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(Women).build().perform();

		WebElement Tops = driver.findElement(By.linkText("Tops"));
		Actions top = new Actions(driver);
		act.moveToElement(Tops).build().perform();

		WebElement Jackets = driver.findElement(By.linkText("Jackets"));
		Actions jackets = new Actions(driver);
		act.moveToElement(Jackets).click().perform();
	}

	@Test(priority = 5)
	public void SelectOneProduct() {
		WebElement selectonproduct = driver
				.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"));
		selectonproduct.click();
	}

	@Test(priority = 6)
	public void SelectColour() {
		WebElement Colour = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-57']"));
		Colour.click();
	}

	@Test(priority = 7)
	public void AddQty() {
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("2");
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
	}

	@Test(priority = 8)
	public void AddtoCart_Withoutselectingsize() {
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
	}

	@Test(priority = 9)
	public void SelectSize() {
		driver.findElement(By.xpath("//div[@id='option-label-size-143-item-169']")).click();
	}

	@Test(priority = 10)
	public void AddtoCart_selectingAllOptions() {
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
	}

	@Test(priority = 11)
	public void AddToWishLList() {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]/span")).click();
	}

	@Test(priority = 12)
	public void ViewCart() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//a[@class='action viewcart']")).click();

	}

	@Test(priority = 13)
	public void WhatsNew() {
		driver.findElement(By.id("ui-id-3")).click();
	}

	@Test(priority = 14)
	public void WishList() {
		driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[3]/div[3]/div[2]/div/div/a")).click();
	}

	@Test(priority = 15)
	public void UpdateWishList() {
		driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[1]/span")).click();
	}

	@Test(priority = 16)
	public void men() {
		WebElement men = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(men).build().perform();

		WebElement Tops = driver.findElement(By.linkText("Tops"));
		Actions top = new Actions(driver);
		act.moveToElement(Tops).build().perform();

		WebElement Jackets = driver.findElement(By.linkText("Jackets"));
		Actions jackets = new Actions(driver);
		act.moveToElement(Jackets).click().perform();
	}

	@Test(priority = 17)
	public void SortBy() {
		WebElement sortby = driver.findElement(By.id("sorter"));
		Select sc = new Select(sortby);
		sc.selectByVisibleText("Price");
	}

	@Test(priority = 18)
	public void Gear() {
		WebElement Gear = driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(Gear).build().perform();

		WebElement Bags = driver.findElement(By.linkText("Bags"));
		Actions top = new Actions(driver);
		act.moveToElement(Bags).click().perform();

	}

	@Test(priority = 19)
	public void Grid() {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[1]/strong[2]")).click();
	}

	@Test(priority = 20)
	public void List() {
		driver.findElement(By.xpath("//*[@id=\"mode-list\"]")).click();
	}

	@Test(priority = 21)
	public void AddtoCompare() {
		WebElement AddtoCompare = driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]/div[2]/a[2]"));
		AddtoCompare.click();
	}

	@Test(priority = 22)
	public void Comparisonlist() {
		WebElement Comparisonlist = driver
				.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/a"));
		Comparisonlist.click();
		driver.navigate().back();
	}

	@Test(priority = 23)
	public void AddReview() {
		WebElement AddReview = driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[1]/div[2]/a[2]"));
		AddReview.click();
		driver.findElement(By.xpath("//*[@id=\"Rating_1_label\"]")).click();
		driver.findElement(By.id("summary_field")).sendKeys("Nice Prduct nad Comfortable");
		driver.findElement(By.id("review_field")).sendKeys("Quality is Good go for it. Evenly satisfied!!!!!!");
		driver.findElement(By.xpath("//*[@id=\"review-form\"]/div/div/button")).click();
	}

	@Test(priority = 24)
	public void VerifyLogo() {
		boolean Logo = driver.findElement(By.xpath(
				"//img[@src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']"))
				.isDisplayed();
		Assert.assertTrue(Logo);
		System.out.println("Logo Verified");
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
