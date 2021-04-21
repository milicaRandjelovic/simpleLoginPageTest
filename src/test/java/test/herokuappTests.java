package test;

import base.baseTest;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.*;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

public class herokuappTests extends baseTest {
    herokuappLoginPage HerokuappLoginPage;
    logoutPage LogoutPage;
    secureAreaPage SecureAreaPage;
    githubPage GithubPage;
    elementalSeleniumPage ElementalSeleniumPage;
    String username = "tomsmith";
    String password = "SuperSecretPassword!";
    String wrongUsername = "milica";
    String wrongPassword = "milica";
    String blankUsername = "";
    String blankPassword = "";
    String successfulRegistrationMessage = "Secure Area\n" +
            "Welcome to the Secure Area. When you are done click logout below.\n" +
            "Logout";
    String successfulLogoutMessage = "You logged out of the secure area!\n" +
            "×";
    String wrongCredentialsMessage = "Your username or password are incorrect";
    String gitHubURL = "https://github.com/saucelabs/the-internet";
    String elementalURL = "http://elementalselenium.com/";
    String elementalText = "Powered by Elemental Selenium";
    String loginPageText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";



    @Before
    public void setUpTest(){
        HerokuappLoginPage = new herokuappLoginPage();
        LogoutPage = new logoutPage();
        SecureAreaPage = new secureAreaPage();
        GithubPage = new githubPage();
        ElementalSeleniumPage = new elementalSeleniumPage();
    }

    @Test
    public void successfulRegistrationTest() {

        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(SecureAreaPage.successfulLoginMessageIsDisplayed());
        Assert.assertEquals(successfulRegistrationMessage, SecureAreaPage.successfulLoginMessageText());
    }
    @Test
    public void logoutTest() {
        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        SecureAreaPage.logoutButtonClick();
        Assert.assertTrue(LogoutPage.successfulLogoutMessageIsDisplayed());
        Assert.assertEquals(successfulLogoutMessage, LogoutPage.successfulLogoutMessageText());
    }


    @Test
    public void incorrectUsernameTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(wrongUsername);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }

    @Test
    public void incorrectPasswordTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(wrongPassword);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }
    @Test
    public void incorrectPasswordAndUsernameTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(wrongUsername);
        HerokuappLoginPage.enterPasswordIntoPasswordField(wrongPassword);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }
    @Test
    public void emptyUsernameTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(blankUsername);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }

    @Test
    public void EmptyPasswordTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(blankPassword);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }

    @Test
    public void usernameAndPasswordAreEmptyTest(){
        HerokuappLoginPage.enterUsernameIntoUsernameField(blankUsername);
        HerokuappLoginPage.enterPasswordIntoPasswordField(blankPassword);
        HerokuappLoginPage.clickOnLoginButton();
        Assert.assertTrue(HerokuappLoginPage.incorrectCredentialMessageIsDisplayed());
        Assert.assertEquals(wrongCredentialsMessage, HerokuappLoginPage.incorrectCredentialMessageText());
    }

    @Test
    public void clickOnGitHubLinkTest(){
        HerokuappLoginPage.clickOnGitHubLink();

        Assert.assertEquals(gitHubURL, GithubPage.gettingCurrentUrlGit());

    }
    @Test
    public void clickOnSeleniumLinkTest(){
        HerokuappLoginPage.clickOnSeleniumLink();
        HerokuappLoginPage.moveToNewTab();

        Assert.assertEquals(elementalURL, ElementalSeleniumPage.gettingCurrentUrlSelenium());

    }

    @Test
    public void elementalTextTest(){
        Assert.assertTrue(HerokuappLoginPage.checkElementalTextIsDisplayed());
        Assert.assertEquals(elementalText, HerokuappLoginPage.checkElementalFieldText());
    }

    @Test
    public void loginTextTest(){
        Assert.assertTrue(HerokuappLoginPage.checkLoginlTextIsDisplayed());
        Assert.assertEquals(loginPageText, HerokuappLoginPage.checkLoginFieldText());
    }

    @Test
    public void closingWrongCredentialsBannerTest () {
        HerokuappLoginPage.enterUsernameIntoUsernameField(blankUsername);
        HerokuappLoginPage.enterPasswordIntoPasswordField(blankPassword);
        HerokuappLoginPage.clickOnLoginButton();
        try {
            HerokuappLoginPage.wrongCredentialsBannerClose();
        } catch (Exception e) {
            Assert.assertTrue("Unable to close banner, close button is overlaped by an image", false);

        }
    }
    @Test
    public void SuccessfulRegistrationBannerTest ()  {
        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        SecureAreaPage.successfulRegistrationBannerClose();

        Assert.assertTrue(SecureAreaPage.bannerCloseButtonListSize());

    }

    @Test
    public void successfulLogoutBannerCloseTest() {
        HerokuappLoginPage.enterUsernameIntoUsernameField(username);
        HerokuappLoginPage.enterPasswordIntoPasswordField(password);
        HerokuappLoginPage.clickOnLoginButton();
        SecureAreaPage.logoutButtonClick();
        SecureAreaPage.successfulRegistrationBannerClose();
//        similar as in previous test, we are asserting that there is no such element, which means that the banner is closed
        Assert.assertTrue(SecureAreaPage.bannerCloseButtonListSize());

    }

}

