package page;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class logoutPage extends baseTest {
    public logoutPage(){

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "flash")
    WebElement successfulLogoutMessage;

    @FindBy (css = ".close")
    WebElement closeSuccessfulLogoutBanner;

    public boolean successfulLogoutMessageIsDisplayed(){
        wdwait.until(ExpectedConditions.visibilityOf(successfulLogoutMessage));
        return successfulLogoutMessage.isDisplayed();
    }
    public String successfulLogoutMessageText(){
        wdwait.until(ExpectedConditions.visibilityOf(successfulLogoutMessage));
        return successfulLogoutMessage.getText();
    }

    public void succcessfulLogoutBannerClose(){
        wdwait.until(ExpectedConditions.visibilityOf(closeSuccessfulLogoutBanner));
        closeSuccessfulLogoutBanner.click();
    }
    public boolean bannerSuccessfulLogoutCloseButtonListSize() {
        wdwait.until(ExpectedConditions.numberOfElementsToBe(By.id("flash"), 0));

        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.id("flash")));
        return list.isEmpty();
    }
}
