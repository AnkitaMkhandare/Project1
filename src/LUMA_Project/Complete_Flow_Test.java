package LUMA_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Complete_Flow_Test {

	private WebDriver driver;

// open Browser
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/");

	}

// Step 1: Sign In
// Step 2: Test Search_Functionality
// Step 3: Sign Out
	@Test(priority = 1)
	public void Search_FunctionalityTest() throws Exception {
// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		Search_Functionality searchInstance = new Search_Functionality(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the  method from class

		signInInstance.testLoginWithValidCredentials();
		searchInstance.testProductSearch();
		signOutInstance.testSignout();

	}

// Step 1: Sign In
// Step 2: Test Negative Search_Functionality
// Step 3: Sign Out

	@Test(priority = 2)
	public void Search_Functionality_NegativeTest() throws Exception {
// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		Search_Functionality_Negative searchFunctionInstance = new Search_Functionality_Negative(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the  method from class
		signInInstance.testLoginWithValidCredentials();
		searchFunctionInstance.testProductSearchNegative();
		signOutInstance.testSignout();

	}

// Step 1: Sign In
// Step 2: Test Sorting Options by Price & Product Name Functionality
// Step 3: Sign Out

	@Test(priority = 3)
	public void Sorting_OptionsTest() throws Exception {
// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		Sorting_Options sortingOptionsInstance = new Sorting_Options(driver);
		Sorting_Options_By_Product_Name sortingPNInstance = new Sorting_Options_By_Product_Name(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the method from class
		signInInstance.testLoginWithValidCredentials();
		sortingOptionsInstance.sortByPrice();
		sortingPNInstance.SortingOptionsByProductName();
		signOutInstance.testSignout();

	}

// Step 1: Sign In
// Step 2: Test which product Categories are present in HomePage Functionality
// Step 3: Print  product details Functionality
// Step 4: Sign Out

	@Test(priority = 4)
	public void ProductTest() throws Exception {
// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		HomePage_Categories homePageCategoriesInstance = new HomePage_Categories(driver);
		Product_Details_Positive ProducDetailsInstance = new Product_Details_Positive(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the method from class
		signInInstance.testLoginWithValidCredentials();
		homePageCategoriesInstance.testHomePageCategories();
		ProducDetailsInstance.testProductDetails_Positive();
		signOutInstance.testSignout();

	}

//Step 1: Sign In
// Step 2: Add Product in wishlist  	
// Step 3: Sign Out

	@Test(priority = 5)
	public void wishlist_Test() throws Exception {
// Create an instance of the class

		Add_To_WishList wishlistProductInstance = new Add_To_WishList(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the method from class

		wishlistProductInstance.testLoginWithValidCredentials();
		wishlistProductInstance.addToWishlistTest();
		wishlistProductInstance.totalProductsInWishlist();

		signOutInstance.testSignout();

	}

//Step 1: Sign In
// Step 2: Add Product in wishlist 
// Step 3: Remove Product from wishlist 
// Step 4: Sign Out	

	@Test(priority = 6)
	public void removeFromWishlist_Test() throws Exception {
// Create an instance of the class

		WishList_Remove_Product removeFromWishlistInstance = new WishList_Remove_Product(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the method from class

		removeFromWishlistInstance.testLoginWithValidCredentials();
		removeFromWishlistInstance.addToWishlistTest();
		removeFromWishlistInstance.removeFromWishlistTest();
		removeFromWishlistInstance.totalProductsInWishlist();

		signOutInstance.testSignout();

	}

// Step 1: Sign In
// Step 2: Test Product Add To Cart Functionality
// Step 3: Sign Out

	@Test(priority = 7)
	public void AddToCartTest() throws Exception {
		// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		Add_Multiple_Items_To_Cart_Positive addMultipleProductInstance = new Add_Multiple_Items_To_Cart_Positive(
				driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

		// Call the method from class
		signInInstance.testLoginWithValidCredentials();

		addMultipleProductInstance.navigateToWomenSection();
		addMultipleProductInstance.clickOnProduct();
		addMultipleProductInstance.selectSizeAndColor();
		addMultipleProductInstance.addToCart();
		addMultipleProductInstance.verifyCartContents();

		signOutInstance.testSignout();

	}

//Step 1: Sign In
// Step 2: Add Product  To Cart  
// Step 3: Remove Product To Cart 	
// Step 4: Sign Out

	@Test(priority = 8)
	public void RemoveProductFromCart_Test() throws Exception {
// Create an instance of the class

		Sign_In signInInstance = new Sign_In(driver);
		Remove_Product_From_Cart removeProductInstance = new Remove_Product_From_Cart(driver);
		Sign_Out signOutInstance = new Sign_Out(driver);

// Call the method from class
		signInInstance.testLoginWithValidCredentials();

		removeProductInstance.navigateToWomenSection();
		removeProductInstance.clickProduct();
		removeProductInstance.selectSizeAndColor();
		removeProductInstance.addToCart();
		removeProductInstance.verifyCartContents();

		removeProductInstance.navigateToGearSection();
		removeProductInstance.clickOnGearProduct();
		removeProductInstance.addToCartButton1();

		removeProductInstance.navigateToMenSection();
		removeProductInstance.clickOnMenProduct();
		removeProductInstance.selectSizeAndColorOfProduct();
		removeProductInstance.addToCartButton();
		removeProductInstance.verifyCartContent();
		removeProductInstance.testShoppingCart();
		removeProductInstance.showProductCountAndTotal();

		signOutInstance.testSignout();

	}

// Step 1: Sign In
// Step 2: Add Product  To Cart  
// Step 3: Test Checkout process
// Step 4: Test Payment process
// Step 5: Sign Out

	@Test(priority = 9)
	public void CheckOutPayment_Process() throws Exception {
// Create an instance of the class

		CheckOut_Payment_Process checkoutFunctionInstance = new CheckOut_Payment_Process(driver);
		

// Call the  method from class

		checkoutFunctionInstance.navigateToWomenSection();
		checkoutFunctionInstance.clickProduct();
		checkoutFunctionInstance.selectSizeAndColor();
		checkoutFunctionInstance.addToCart();
		checkoutFunctionInstance.verifyCartContents();
		checkoutFunctionInstance.proceedToCheckoutButton();
		checkoutFunctionInstance.ShippingAddress();
		checkoutFunctionInstance.paymentMethod();

		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
