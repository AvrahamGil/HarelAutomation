package infra;

import org.openqa.selenium.WebDriver;

public class TravelDestinationBP extends BaseProcess {

    public TravelDestinationBP(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return managePages.travelDestinationPage().onPage();
    }

    public void startNewPurchase() {
        managePages.travelDestinationPage().selectDestinationAndContinue();
    }
}
