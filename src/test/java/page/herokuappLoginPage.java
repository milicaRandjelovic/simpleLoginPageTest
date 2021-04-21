package page;

import base.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class herokuappLoginPage extends baseTest {
    public herokuappLoginPage(){

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    WebElement loginButton;

    @FindBy(css = ".flash.error")
    WebElement incorrectCredentialMessage;

    @FindBy(xpath = "//img[@src=\"/img/forkme_right_green_007200.png\"]")
    WebElement gitHubLink;

    @FindBy(linkText = "Elemental Selenium")
    WebElement seleniumLink;

    @FindBy(xpath = "//div[contains(text(), \"Powered by \")]")
     WebElement  elementalText;

    @FindBy(css = ".subheader")
    WebElement loginPageText;

    @FindBy (css = ".close")
     WebElement closeWrongCredentialsBanner;

    public void enterUsernameIntoUsernameField(String username){
        wdwait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys (username);

    }
    public void enterPasswordIntoPasswordField(String password){
        wdwait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void clickOnLoginButton(){
        wdwait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
    public boolean incorrectCredentialMessageIsDisplayed(){
        wdwait.until(ExpectedConditions.visibilityOf(incorrectCredentialMessage));
        return incorrectCredentialMessage.isDisplayed();
    }
    public String incorrectCredentialMessageText(){
        wdwait.until(ExpectedConditions.visibilityOf(incorrectCredentialMessage));
        return incorrectCredentialMessage.getText();
    }
//    public boolean incorrectPasswordMessageIsDisplayed(){
//        wdwait.until(ExpectedConditions.visibilityOf(incorrectCredentialMessage));
//        return incorrectCredentialMessage.isDisplayed();
//    }
//    public String incorrectPasswordMessageText(){
//        wdwait.until(ExpectedConditions.visibilityOf(incorrectCredentialMessage));
//        return incorrectCredentialMessage.getText();
//    }

    public void clickOnGitHubLink(){
        wdwait.until(ExpectedConditions.visibilityOf(gitHubLink));
        gitHubLink.click();

    }

    public void clickOnSeleniumLink(){
        wdwait.until(ExpectedConditions.visibilityOf(seleniumLink));
        seleniumLink.click();
    }
    public void moveToNewTab(){
        wdwait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public boolean checkElementalTextIsDisplayed(){
        wdwait.until(ExpectedConditions.visibilityOf(elementalText));
        return elementalText.isDisplayed();
    }

    public String checkElementalFieldText(){
        wdwait.until(ExpectedConditions.visibilityOf(elementalText));
        return elementalText.getText();
    }

    public boolean checkLoginlTextIsDisplayed(){
        wdwait.until(ExpectedConditions.visibilityOf(loginPageText));
        return loginPageText.isDisplayed();
    }

    public String checkLoginFieldText(){
        wdwait.until(ExpectedConditions.visibilityOf(loginPageText));
        return loginPageText.getText();
    }

    public void wrongCredentialsBannerClose(){
        wdwait.until(ExpectedConditions.visibilityOf(closeWrongCredentialsBanner));
        closeWrongCredentialsBanner.click();
    }

}
