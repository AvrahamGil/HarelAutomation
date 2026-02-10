package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    private final long TIME_OUT = 30L;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
    }

    public boolean isOnPage(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public WebElement waitToPageLoad(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void clicks(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void enterText(WebElement element, String value) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
    }
}
