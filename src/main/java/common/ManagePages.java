package common;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pages.DatePickerPage;
import pages.DestinationPage;
import pages.PersonalInformationPage;
import pages.TravelPolicyPage;

@Component
@Lazy
public class ManagePages {

    private final WebDriver driver;

    public ManagePages(WebDriver driver) {
        this.driver = driver;
    }


    public <T> T getPage(Class<T> pageClass) {
        try {
            return pageClass.getConstructor(WebDriver.class).newInstance(driver);
        }catch(Exception e) {
            throw new RuntimeException("Cannot create page due to" + e.getMessage());
        }
    }


    public TravelPolicyPage travelFlightPolicyPage() {
        return getPage(TravelPolicyPage.class);
    }

    public DestinationPage travelDestinationPage() {
        return getPage(DestinationPage.class);
    }

    public DatePickerPage travelDatePage() {
        return getPage(DatePickerPage.class);
    }

    public PersonalInformationPage personalInformationPage() {
        return getPage(PersonalInformationPage.class);
    }
}
