package infra;

import org.openqa.selenium.WebDriver;

public class TravelPolicyBP extends BaseProcess {


    public TravelPolicyBP(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return managePages.travelFlightPolicyPage().onPage();
    }

    public void proceedToDateSelection() {
        managePages.travelFlightPolicyPage().proceedToDateSelection();
    }
}
