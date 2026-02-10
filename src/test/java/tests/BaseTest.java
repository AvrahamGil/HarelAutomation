package tests;

import common.ProcessManager;
import constants.Constants;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(AllureTestNg.class)
public abstract  class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver webDriver;

    protected ProcessManager manageProcesses = null;
    protected final String BASE_URL = "https://digital.harel-group.co.il/travel-policy";


    @BeforeMethod
    public void init() {
        String browserType = System.getProperty(Constants.BROWSER_TYPE, "chrome");

        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
        manageProcesses = new ProcessManager(webDriver);
    }


    @AfterMethod(alwaysRun = true)
    public void testDown() {
        System.clearProperty(Constants.BROWSER_TYPE);
        if(this.webDriver != null) this.webDriver.quit();
    }

}
