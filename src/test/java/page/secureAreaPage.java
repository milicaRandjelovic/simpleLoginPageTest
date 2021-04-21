package page;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

public class secureAreaPage extends baseTest {
    public secureAreaPage(){

        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".example")
    WebElement successfulLoginMessage;

    @FindBy(css = ".button.secondary.radius")
    WebElement logoutButton;

    @FindBy (css = ".close")
    WebElement closeSuccessfulRegistrationBanner;

    @FindBy(id = "flash")
    WebElement bannerSuccessfulRegistration;

    public boolean successfulLoginMessageIsDisplayed(){
        wdwait.until(ExpectedConditions.visibilityOf(successfulLoginMessage));
        return successfulLoginMessage.isDisplayed();

    }
    public String successfulLoginMessageText(){
        wdwait.until(ExpectedConditions.visibilityOf(successfulLoginMessage));
        return successfulLoginMessage.getText();
    }
    public void logoutButtonClick(){
        wdwait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
    public void successfulRegistrationBannerClose(){
        wdwait.until(ExpectedConditions.visibilityOf(closeSuccessfulRegistrationBanner));
        closeSuccessfulRegistrationBanner.click();
    }

//    asserting that the banner is closed
    public boolean bannerCloseButtonListSize() {
        wdwait.until(ExpectedConditions.numberOfElementsToBe(By.id("flash"), 0));

        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.id("flash")));
        return list.isEmpty();
    }

}
