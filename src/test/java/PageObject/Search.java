package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory
    public Search(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement identified for the search input field
    @FindBy(css = "[placeholder=\"Search on Nykaa\"]")
    WebElement searchElement;

    // WebElement identified for the search button
    @FindBy(xpath = "//form[@id='nykaa_search']//span[@class='material-symbols-outlined'][normalize-space()='search']")
    WebElement enterElement;

    // Method to perform a search operation
    public void performSearch(String str) {
        searchElement.click(); // Click on the search field
        searchElement.sendKeys(str); // Enter the search string
    }

    // Method to click on the search button
    public void enteronSearch() {
        enterElement.click();
    }
}
