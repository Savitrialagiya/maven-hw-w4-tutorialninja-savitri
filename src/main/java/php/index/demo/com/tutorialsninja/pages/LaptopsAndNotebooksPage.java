package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By laptopsAndDesktopTab = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooksTab = By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]");
    By sortByPriceHighToLow = By.xpath("//select[@id='input-sort']");
    By getSortByHighToLowOrder = By.xpath("//p[@class ='price']");
    By macBookTab = By.linkText("MacBook");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By getSuccessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//span[contains(text(),'Shopping Cart')]");
    By getShoppingCartText = By.xpath("//a[contains(text(),'Shopping Cart')]");
    By getProductMacBookText = By.linkText("MacBook");
    By changeQuantityTo2 = By.xpath("//input[contains(@name, 'quantity')]");
    By updateTab = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By getMessageModifiedCart = By.xpath("//div[@id='checkout-cart']/div[1]");
    By getTotalPriceText = By.xpath("//tbody/tr[1]/td[6]");
    By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By getCheckoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By getNewCustomerText = By.xpath("//div[@class='col-sm-6']//h2");
    By guestCheckoutRadioButton = By.xpath("//input[@name='account' and @value='guest']");
    By continueTab = By.xpath("//input[@id='button-account']");
    By nameField = By.name("firstname");
    By lastnameField = By.name("lastname");
    By emailField = By.id("input-payment-email");
    By telephone = By.name("telephone");
    By address1 = By.name("address_1");
    By cityName = By.name("city");
    By postCode = By.name("postcode");
    By countryName = By.id("input-payment-country");
    By zoneName = By.xpath("//select[@id='input-payment-zone']");
    By continueButton = By.xpath("//input[@id='button-guest']");
    By addCommentsToTextArea = By.xpath("//textarea[@name='comment']");
    By termsAndConditionsCheckBox = By.xpath("//input[@name='agree']");
    By finalContinueButton = By.xpath("//input[@id='button-payment-method']");
    By getPaymentMethodMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void mouseHoverOnLaptopsAndDesktopTab(){
        mouseHoverToElementAndClick(laptopsAndDesktopTab);
    }
    public void clickOnShowAllLaptopsAndNotebooks(){
        clickOnElement(showAllLaptopsAndNotebooksTab);
    }
    public void sortByPriceHighToLow(){
        selectByVisibleTextFromDropDown(sortByPriceHighToLow,"Price (High > Low)");
    }
    public String GetSortByHighToLowOrder(){
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        // Assert.assertEquals("Product not sorted by price High to Low",
        // originalProductsPrice, afterSortByPrice);

        return null;

    }
    public void clickOnCurrencyLink(){
        clickOnElement(currencyLink);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
    public void clickOnMacBookTab(){
        clickOnElement(macBookTab);
    }
    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }
    public String getSuccessTextFromLink(){
        return getTextFromElement(getSuccessMessage);
    }
    public void clickOnShoppingCart(){
        clickOnElement(shoppingCartLink);
    }
    public String getShoppingCartMessage(){
        return getTextFromElement(getShoppingCartText);
    }
    public String getVerifyProductMacbook() {
        return getTextFromElement(getProductMacBookText);
    }
    public void changeQuantityTo2(String text){
        driver.findElement(changeQuantityTo2).clear();
        sendTextToElement(changeQuantityTo2,"text");
    }
    public void clickOnUpdateCart() {
        clickOnElement(updateTab);
    }
    public String getSuccessModifiedCartMessage(){
        return getTextFromElement(getMessageModifiedCart);
    }
    public String getVerifyTotal() {
        return getTextFromElement(getTotalPriceText);
    }
    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }
    public String getCheckoutText() {
        return getTextFromElement(getCheckoutText);
    }
    public String getNewCustomerText() {
        return getTextFromElement(getNewCustomerText);
    }
    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
    }
    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }
    public void enterName(String name) {
        sendTextToElement(nameField, name);
    }
    public void enterLastName(String lastname) {
        sendTextToElement(lastnameField, lastname);
    }
    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String phone) {
        sendTextToElement(telephone, phone);
    }
    public void enterAddress(String street) {
        sendTextToElement(address1, street);
    }
    public void enterCity(String city) {
        sendTextToElement(cityName, city);
    }
    public void enterPostcode(String code) {
        sendTextToElement(postCode, code);
    }
    public void enterCountry(String country) {
        sendTextToElement(countryName, country);
    }
    public void enterZone(String state) {
        sendTextToElement(zoneName, state);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
    public void enterTextToTextArea(String message) {
        sendTextToElement(addCommentsToTextArea, message);
    }
    public void clickOnTermsAndConditionsCheckbox(){
        clickOnElement(termsAndConditionsCheckBox);
    }
    public void clickOnFinalContinueButton(){
        clickOnElement(finalContinueButton);
    }
    public String getWarningPaymentMethodRequiredText() {
        return getTextFromElement(getPaymentMethodMessage);
    }
}
