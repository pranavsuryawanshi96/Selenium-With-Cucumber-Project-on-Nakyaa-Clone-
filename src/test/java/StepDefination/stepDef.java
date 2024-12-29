package StepDefination;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.Login;
import PageObject.PurchaseProduct;
import PageObject.Search;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDef {

	WebDriver driver;
	Login loginPg;
	Search searchpg;
	PurchaseProduct buy;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("I launch the browser")
	public void i_launch_the_browser() {
		driver.get("https://sweet-donut-1ca8e9.netlify.app/");
		loginPg = new Login(driver);
		searchpg = new Search(driver);
		buy = new PurchaseProduct(driver);
	}

	@Given("I navigate to the Sign In page")
	public void i_navigate_to_the_sign_in_page() {
		loginPg.clickAccountOption();
	}

	@Given("I click on the  Enter Phone or Email button")
	public void i_click_on_the_enter_phone_or_email_button() {
		loginPg.clickPhoneField();
	}

	@When("I enter the valid phone number {string} into the phone number field")
	public void i_enter_the_valid_phone_number_into_the_phone_number_field(String string) {
		loginPg.enterPhoneNumber(string);
	}

	@When("I click on the Proceed button")
	public void i_click_on_the_proceed_button1() {
		loginPg.clickOnProceed();
	}

	@When("I enter the retrieved OTP into the OTP field")
	public void i_enter_the_retrieved_otp_into_the_otp_field() {
		String otp = loginPg.retrieveOTP();
		loginPg.enterOTP(otp);
		loginPg.clickFinalProceed();
		loginPg.closeAlert();
	}

	@When("I enter the full name {string}")
	public void i_enter_the_full_name(String string) {
		loginPg.enterFullName(string);
	}

	@When("I enter the email address {string}")
	public void i_enter_the_email_address(String string) {
		loginPg.enterEmail(string);
	}

	@When("I click on the Proceed submit")
	public void i_click_on_the_proceed_submit() {
		loginPg.clickSubmit();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
		if (driver.getTitle().contains("NYKAA")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	@Given("I navigate to the home page")
	public void i_navigate_to_the_home_page() {
		if (driver.getTitle().contains("NYKAA")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	// ===============Search Bar check========================//
	@When("I enter {string} in the search bar")
	public void i_enter_in_the_search_bar(String string) {
		searchpg.performSearch(string);
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		searchpg.enteronSearch();
	}

	@Then("I should see a list of products related to {string}")
	public void i_should_see_a_list_of_products_related_to(String product) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productList = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"dropdown_category\"]")));

		assertTrue(productList.isDisplayed(), "Product list is not displayed.");

		boolean productFound = productList.findElements(By.cssSelector("[class=\"dropdown_category\"]")).stream()
				.anyMatch(item -> item.getText().toLowerCase().contains(product.toLowerCase()));
		assertTrue(productFound, "No products found related to " + product);
	}

	// =======================Purchase Product===========================//
	@Given("I am on the Homepage")
	public void i_am_on_the_homepage() {
		driver.get("https://sweet-donut-1ca8e9.netlify.app/");
		buy = new PurchaseProduct(driver);
	}

	@When("I click on the Appliances category")
	public void i_click_on_the_appliances_category() {
		buy.clickOnAppliances();
	}

	@When("I click on the Hairdryer product")
	public void i_click_on_the_hairdryer_product() {
		buy.clickOnHairdryer();
	}

	@When("I click on any product")
	public void i_click_on_any_product() {
		buy.addToBag();
	}

	@When("I am on the Cart page")
	public void i_am_on_the_cart_page() {
		buy.selectQuantity();
	}

	@Then("I click on Proceed")
	public void i_click_on_proceed() {
		buy.clickNextButton();
	}

	@Then("I enter {string} as the country")
	public void i_enter_as_the_country(String string) {
		buy.enterCountry(string);
	}

	@Then("I enter {string} as the name")
	public void i_enter_as_the_name(String string) {
		buy.enterName(string);
	}

	@Then("I enter {string} as the phone number")
	public void i_enter_as_the_phone_number(String string) {
		buy.enterPhoneNumber(string);
	}

	@Then("I enter {string} as the pin code")
	public void i_enter_as_the_pin_code(String string) {
		buy.enterPinCode(string);
	}

	@Then("I click on Ship to this address")
	public void i_click_on_ship_to_this_address() {
		buy.clickProceedButton();
	}

	@Then("I select Cash On Delivery  as the payment method")
	public void i_select_cash_on_delivery_as_the_payment_method() {
		buy.selectPaymentMethod();
	}

	@Then("I click on Confirm Order")
	public void i_click_on_confirm_order() {
		buy.clickConfirmOrderButton();
	}

	@Then("I enter {string} as the OTP")
	public void i_enter_as_the_otp(String string) {
		buy.enterOTP(string);
	}

	@Then("I click on  Submit")
	public void i_click_on_submit() {
		buy.clickSubmitButton();
	}

	@Then("I verify the order confirmation message is displayed")
	public void i_verify_the_order_confirmation_message_is_displayed() {
		Alert alert = driver.switchTo().alert();
		String confirmmsg = alert.getText();
		if (confirmmsg.contains("Payment Successfull !")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	@After
	public void teardown(Scenario sc) {
		if(sc.isFailed()==true) {
			// Generate a unique file name using the scenario name and a timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String scenarioName = sc.getName().replace(" ", "_"); // Replace spaces in scenario name
            String fileWithPath = "D:\\Automn Selenium\\CucumberNakyaaProject\\Screenshoot\\" + scenarioName + "_" + timestamp + ".png";

			//Call getScreenshotAs method to create image file
			 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Attach the screenshot to the Cucumber report
             byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
             sc.attach(screenshotBytes, "image/png", sc.getName());

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination
			try {
				FileUtils.copyFile(srcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		driver.quit();

	}
}
