package php.index.demo.com.tutorialsninja.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.MyAccountPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;

public class MyAccountPageTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountPage.getRegisterAccountMessage(),"Register Account","Message not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountPage.getReturningCustomerMessage(),"Returning Customer","Message not displayed");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName("Dev");
        myAccountPage.enterLastName("Coldo");
        myAccountPage.enterEmailId("dev123"+getAlphaNumericString(3)+"@gmail.com");
        myAccountPage.enterPhoneNumber("1234567890");
        myAccountPage.enterPassword("Dev123");
        myAccountPage.enterConfirmPassword("Dev123");
        myAccountPage.clickSubscribeOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinue1();
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Message not displayed");
        myAccountPage.clickOnContinueButton2();
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Message not displayed");
        myAccountPage.clickOnContinueButton3();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId("dev123"+getAlphaNumericString(3)+"@gmail.com");
        myAccountPage.enterPassword("Dev123");
        myAccountPage.clickOnLogin();
        Assert.assertEquals(myAccountPage.getMyAccountText(),"My Account","My account text not displayed");
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Account Logout text not displayed");
        myAccountPage.clickOnContinueButton3();
    }

}
