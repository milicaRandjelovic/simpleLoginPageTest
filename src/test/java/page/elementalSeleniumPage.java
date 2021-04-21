package page;

import base.baseTest;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class elementalSeleniumPage extends baseTest {
    public elementalSeleniumPage(){
        PageFactory.initElements(driver, this);
    }
    public String gettingCurrentUrlSelenium(){
        wdwait.until(ExpectedConditions.urlContains("elementalselenium"));
        return driver.getCurrentUrl();
    }


}
