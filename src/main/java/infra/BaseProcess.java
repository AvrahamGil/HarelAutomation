package infra;

import common.ManagePages;
import org.openqa.selenium.WebDriver;

public class BaseProcess {

    protected ManagePages managePages = null;

    public BaseProcess(WebDriver driver) {;
        managePages = new ManagePages(driver);
    }
}
