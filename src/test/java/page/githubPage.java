package page;

import base.baseTest;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class githubPage extends baseTest {
    public githubPage(){
        PageFactory.initElements(driver, this);
    }

    public String gettingCurrentUrlGit(){
        wdwait.until(ExpectedConditions.urlContains("github"));
        return driver.getCurrentUrl();
    }

}
