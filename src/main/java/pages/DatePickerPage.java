package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.DateConstants;


public class DatePickerPage extends BasePage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = DateConstants.TITLE)
    private WebElement title;

    @FindBy(xpath = DateConstants.DEPARTURE_FIELD)
    private WebElement departureField;

    @FindBy(xpath = DateConstants.ARRIVAL_FIELD)
    private WebElement arrivalField;

    @FindBy(xpath = DateConstants.TOTAL_DAYS)
    private WebElement totalDays;

    @FindBy(xpath = DateConstants.MOVE_TO_PASSENGER_DETAILS_BTN)
    private WebElement moveToPassengerDetailsBtn;

    @FindBy(xpath = DateConstants.CHANGE_MONTH)
    private WebElement changeMonth;

    public boolean onPage() {
        return isOnPage(title);
    }


    public String getTotalDays() {
        return getText(totalDays).replaceAll("\\D+", "");
    }

    public void selectDatesInDatePicker(String departureDate, String arrivalDate) {
       enterText(waitToPageLoad(departureField), departureDate);
       clicks(changeMonth);
       enterText(waitToPageLoad(arrivalField), arrivalDate);
       clicks(changeMonth);
    }

    public void moveToPassengerDetailsPage() {
        clicks(waitToPageLoad(moveToPassengerDetailsBtn));
    }
}
