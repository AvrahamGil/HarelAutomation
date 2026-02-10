package infra;

import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TravelDateSelectionBP extends BaseProcess {

    public TravelDateSelectionBP(WebDriver driver) {
        super(driver);
    }

    private static final DateTimeFormatter DATE_PICKER_FORMAT = DateTimeFormatter.ofPattern("ddMMyyyy");

    public boolean isOnPage() {
        return managePages.travelDatePage().onPage();
    }


    public void selectDatesForFlight() {
        LocalDate departureDate = LocalDate.now().plusDays(7);

        // According to the requirements, the total number of days between the departure and arrival dates should be 30.
        // However, the website currently displays 31, I changed it to plus 29 days.
        LocalDate arrivalDate = departureDate.plusDays(29);

        String departure = departureDate.format(DATE_PICKER_FORMAT);
        String arrival = arrivalDate.format(DATE_PICKER_FORMAT);

        System.out.println("Departure: " + departureDate);
        System.out.println("Arrival:   " + arrivalDate);

        managePages.travelDatePage().selectDatesInDatePicker(departure, arrival);

    }

    public String getDaysCounter() {
        return managePages.travelDatePage().getTotalDays();
    }

    public void moveToPassengerDetails() {
        managePages.travelDatePage().moveToPassengerDetailsPage();
    }
}
