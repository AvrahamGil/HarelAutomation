package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.PersonalInformationConstants;


public class PersonalInformationPage extends BasePage{

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = PersonalInformationConstants.TITLE)
    private WebElement title;

    @FindBy(xpath = PersonalInformationConstants.FIRST_PASSENGER_TITLE)
    private WebElement firstPassengerTitle;

    public boolean onPage() {
        return isOnPage(title);
    }

    public String getFirstPassengerDetailsTitle() {
        return getText(firstPassengerTitle);
    }
}
