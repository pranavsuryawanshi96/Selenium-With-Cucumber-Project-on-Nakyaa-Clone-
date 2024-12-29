package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchaseProduct {
    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory
    public PurchaseProduct(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements identified using @FindBy annotations
    @FindBy(xpath = "(//a[contains(text(),'Appliances')])[1]")
    WebElement accountElement;

    @FindBy(xpath = "(//a[normalize-space()='Hair Dryers'])[1]")
    WebElement hairdryerElement;

    @FindBy(xpath = "(//div)[29]")
    WebElement addToBagElement;

    @FindBy(id = "godj")
    WebElement nextButtonElement;

    @FindBy(xpath = "(//select)[1]")
    WebElement drpdnqty;

    @FindBy(css = "[id=\"country\"]")
    WebElement txtCountry;

    @FindBy(css = "[id=\"name\"]")
    WebElement txtNamElement;

    @FindBy(css = "[id=\"phone\"]")
    WebElement txtphone;

    @FindBy(css = "[id=\"postal\"]")
    WebElement txtpincode;

    @FindBy(css = "[type=\"submit\"]")
    WebElement btnclk;

    @FindBy(xpath = "(//div[normalize-space()='Cash On Delivery'])[1]")
    WebElement drpdownpaymentmethod;

    @FindBy(css = "[type=\"submit\"]")
    WebElement btnconfirm;

    @FindBy(css = "[id=\"enterotp\"]")
    WebElement txtenterotp;

    @FindBy(css = "[type=\"submit\"]")
    WebElement submit;

    // Actions to interact with elements

    // Method to click on the "Appliances" category
    public void clickOnAppliances() {
        accountElement.click();
    }

    // Method to click on "Hair Dryers"
    public void clickOnHairdryer() {
        hairdryerElement.click();
    }

    // Method to add the product to the bag
    public void addToBag() {
        addToBagElement.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Method to select the quantity from the dropdown
    public void selectQuantity() {
        drpdnqty.click();
        Select qty = new Select(drpdnqty);
        qty.selectByIndex(2);
    }

    // Method to click the "Next" button
    public void clickNextButton() {
        nextButtonElement.click();
    }

    // Method to enter the country
    public void enterCountry(String country) {
        txtCountry.sendKeys(country);
    }

    // Method to enter the name
    public void enterName(String name) {
        txtNamElement.sendKeys(name);
    }

    // Method to enter the phone number
    public void enterPhoneNumber(String phoneNumber) {
        txtphone.sendKeys(phoneNumber);
    }

    // Method to enter the pin code
    public void enterPinCode(String pinCode) {
        txtpincode.sendKeys(pinCode);
    }

    // Method to click the "Proceed" button
    public void clickProceedButton() {
        btnclk.click();
    }

    // Method to select the payment method
    public void selectPaymentMethod() {
        drpdownpaymentmethod.click();
    }

    // Method to click the "Confirm Order" button
    public void clickConfirmOrderButton() {
        btnconfirm.click();
    }

    // Method to enter the OTP
    public void enterOTP(String otp) {
        txtenterotp.sendKeys(otp);
    }

    // Method to click the "Submit" button
    public void clickSubmitButton() {
        submit.click();
    }
}
