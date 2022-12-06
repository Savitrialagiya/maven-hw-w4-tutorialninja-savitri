package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    By getRegisterAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    By getReturningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By enterEmailId = By.id("input-email");
    By enterPhoneNumber = By.id("input-telephone");
    By enterPassword = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subscribeYesRadioButton = By.xpath("//input[@name='newsletter']");
    By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By clickOnContinueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By getAccountCreatedText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueButton2 = By.xpath("//a[contains(text(),'Continue')]");
    By myAccount2 = By.xpath("//span[contains(text(),'My Account')]");
    By getAccountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton3 = By.xpath("//a[contains(text(),'Continue')]");
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    By getMyAccountText = By.xpath("//h2[contains(text(),'My Account')]");

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }
    public String getRegisterAccountMessage() {
        return getTextFromElement(getRegisterAccountText);
    }
    public String getReturningCustomerMessage() {
        return getTextFromElement(getReturningCustomerText);
    }
    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }
    public void enterEmailId(String email) {
        sendTextToElement(enterEmailId, email);
    }
    public void enterPhoneNumber(String phone) {
        sendTextToElement(enterPhoneNumber, phone);
    }
    public void enterPassword(String phone) {
        sendTextToElement(enterPassword, phone);
    }
    public void enterConfirmPassword(String phone) {
        sendTextToElement(confirmPassword, phone);
    }
    public void clickSubscribeOnYesRadioButton() {
        clickOnElement(subscribeYesRadioButton);
    }
    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
    }
    public void clickOnContinue1() {
        clickOnElement(clickOnContinueButton);
    }
    public String getAccountCreatedMessage() {
        return getTextFromElement(getAccountCreatedText);
    }
    public void clickOnContinueButton2() {
        clickOnElement(continueButton2);
    }
    public void clickOnMyAccountTab() {
        clickOnElement(myAccount2);
    }
    public String getAccountLogoutMessage() {
        return getTextFromElement(getAccountLogoutText);
    }
    public void clickOnContinueButton3() {
        clickOnElement(continueButton3);
    }
    public void clickOnLogin() {
        clickOnElement(loginButton);
    }
    public String getMyAccountText(){
        return getTextFromElement(getMyAccountText);
    }

}
