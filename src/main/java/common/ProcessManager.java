package common;

import infra.PersonalInformationBP;
import infra.TravelDateSelectionBP;
import infra.TravelDestinationBP;
import infra.TravelPolicyBP;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ProcessManager {

    private final WebDriver driver;

    public ProcessManager(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T getProcess(Class<T> processClass) {
        try {
            return processClass.getConstructor(WebDriver.class).newInstance(driver);
        }catch(Exception e) {
            throw new RuntimeException("Cannot create process due to" +  e.getMessage());
        }
    }

    public TravelPolicyBP flightTravelPolicyBP() { return getProcess(TravelPolicyBP.class); }

    public TravelDestinationBP travelDestinationBP() { return getProcess(TravelDestinationBP.class);}

    public TravelDateSelectionBP travelDateBP() { return getProcess(TravelDateSelectionBP.class); }

    public PersonalInformationBP personalInformationBP() { return getProcess(PersonalInformationBP.class); }
}
