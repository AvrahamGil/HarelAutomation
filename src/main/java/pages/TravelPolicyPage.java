package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.TravelPolicyConstants;


public class TravelPolicyPage extends BasePage {

    public TravelPolicyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = TravelPolicyConstants.TITLE)
    private WebElement title;

    @FindBy(xpath = TravelPolicyConstants.FIRST_TIME_PURCHASE)
    private WebElement firstTimePurchase;


    public boolean onPage() {
        return isOnPage(title);
    }

    public void proceedToDateSelection() {
        waitToPageLoad(firstTimePurchase);
        clicks(firstTimePurchase);
    }
}
