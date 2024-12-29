package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory
    public Login(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements identified using @FindBy annotations
    @FindBy(xpath = "//div[@class='account']")
    WebElement accountOption;

    @FindBy(css = "#s_sign_number")
    WebElement phoneFieldClick;

    @FindBy(id = "number")
    WebElement enterNumber;

    @FindBy(id = "s_register_proceed")
    WebElement clickOnProceed;

    @FindBy(css = "#alert_title")
    List<WebElement> otpElements;

    @FindBy(xpath = "//input[@id='s_otp']")
    WebElement otpInput;

    @FindBy(xpath = "//button[@id='s_register_proceed']")
    WebElement finalProceedButton;

    @FindBy(id = "close_alert")
    WebElement closeAlertButton;

    @FindBy(css = "[id=\"fullname\"]")
    WebElement fullNameElement;

    @FindBy(css = "[id=\"email\"]")
    WebElement emailElement;

    @FindBy(xpath = "//button[@id='s_register_proceed']")
    WebElement finalSubmitElement;

    // Method to click on the "Account" option
    public void clickAccountOption() {
        accountOption.click();
    }

    // Method to click on the phone number field
    public void clickPhoneField() {
        phoneFieldClick.click();
    }

    // Method to enter the phone number
    public void enterPhoneNumber(String number) {
        enterNumber.sendKeys(number);
    }

    // Method to click on the "Proceed" button
    public void clickOnProceed() {
        clickOnProceed.click();
    }

    // Method to retrieve the OTP from a popup
    public String retrieveOTP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the visibility of all OTP elements
        List<WebElement> visibleOtpElements = wait.until(ExpectedConditions.visibilityOfAllElements(otpElements));
        // Get the last OTP element's text
        String otpText = visibleOtpElements.get(visibleOtpElements.size() - 1).getText();
        // Extract and return the OTP using regex
        return otpText.split("OTP-\\s*")[1].trim();
    }

    // Method to enter the OTP
    public void enterOTP(String otp) {
        otpInput.sendKeys(otp);
    }

    // Method to click on the final "Proceed" button
    public void clickFinalProceed() {
        finalProceedButton.click();
    }

    // Method to close the alert if visible
    public void closeAlert() {
        closeAlertButton.click();
    }

    // Method to enter the full name
    public void enterFullName(String fullName) {
        fullNameElement.sendKeys(fullName);
    }

    // Method to enter the email address
    public void enterEmail(String email) {
        emailElement.sendKeys(email);
    }

    // Method to click on the "Submit" button
    public void clickSubmit() {
        finalSubmitElement.click();
    }
}
