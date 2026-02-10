package infra;

import org.openqa.selenium.WebDriver;

public class PersonalInformationBP extends BaseProcess
{
    public PersonalInformationBP(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return managePages.personalInformationPage().onPage();
    }

    public String getFirstPassengerDetailsTitle() {
        return managePages.personalInformationPage().getFirstPassengerDetailsTitle();
    }
}
