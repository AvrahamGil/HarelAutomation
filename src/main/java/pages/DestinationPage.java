package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.DestinationConstants;


public class DestinationPage extends BasePage{

    public DestinationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = DestinationConstants.TITLE)
    private WebElement title;

    @FindBy(xpath = DestinationConstants.ASIA)
    private WebElement asia;

    @FindBy(xpath = DestinationConstants.PROCEED_TO_PICK_DATES_PAGE_BTN)
    private WebElement proceedToPickDatesBtn;


    public boolean onPage() {
        return isOnPage(title);
    }

    public void selectDestinationAndContinue() {
        clicks(waitToPageLoad(asia));
        clicks(waitToPageLoad(proceedToPickDatesBtn));
    }
}
