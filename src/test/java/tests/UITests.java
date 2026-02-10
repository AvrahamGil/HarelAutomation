package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(classes = {com.gil.automation.HarelExam.HarelExamApplication.class, config.SeleniumConfig.class})
public class UITests extends BaseTest {

    @Test
    @Epic("Travel Insurance")
    @Feature("Purchase Process")
    public void purchaseTravelInsuranceSuccessfully() {
        Assert.assertTrue(manageProcesses.flightTravelPolicyBP().isOnPage(), "Validate is on flight travel policy page");
        manageProcesses.flightTravelPolicyBP().proceedToDateSelection();

        Assert.assertTrue(manageProcesses.travelDestinationBP().isOnPage(), "Validate is on travel destination page");
        manageProcesses.travelDestinationBP().startNewPurchase();

        Assert.assertTrue(manageProcesses.travelDateBP().isOnPage(), "Validate is on travel date page");
        manageProcesses.travelDateBP().selectDatesForFlight();

        Assert.assertEquals(manageProcesses.travelDateBP().getDaysCounter(), "30" , "Validate that the total number of days is equal to 30");

        manageProcesses.travelDateBP().moveToPassengerDetails();
        Assert.assertTrue(manageProcesses.personalInformationBP().isOnPage(), "Validate is on personal information page");
        Assert.assertNotNull(manageProcesses.personalInformationBP().getFirstPassengerDetailsTitle(), "Verify First passenger details title appears");
    }

}
