package php.index.demo.com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.reporters.jq.Model;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By desktopsTab = By.linkText("Desktops");
    By showAllDesktop = By.linkText("Show All Desktops");
    By sortByNameZtoA = By.xpath("//select[@id='input-sort']");
    By productsInDescendingOrderText = By.xpath("//h4/a");
    By sortByNameAtoZ = By.xpath("//select[@id='input-sort']");
    By productHpLP3065 = By.linkText("HP LP3065");
    By getHPLP3065Text = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By deliveryDate = By.xpath("//div[@class = 'input-group date']//button");
    By enterQuantity = By.xpath("//input[@id='input-quantity']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By getProductAddedToShoppingCartText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("//span[contains(text(),'Shopping Cart')]");
    By getShoppingCartText = By.xpath("//div[@id='content']//h1");
    By getHPLP3065Message = By.linkText("HP LP3065");
    By getDeliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By getProduct21Text = By.xpath("//td[contains(text(),'Product 21')]");
    By getTotalPriceText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

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
    public void mouseHoverOnDesktop(){
       // clickOnElement(desktopsTab);
        mouseHoverToElementAndClick(desktopsTab);
    }
    public void clickOnShowAllDesktop(){
        clickOnElement(showAllDesktop);
    }
    public void sortByPositionNameZtoA(String text){
        selectByVisibleTextFromDropDown(sortByNameZtoA,text);
    }
    public void getProductsArrangeInDescendingOrderText(){
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);

    }
    public void sortByPositionNameAtoZ(String text){
        selectByVisibleTextFromDropDown(sortByNameAtoZ,text);
    }
    public void clickOnProductHPLP3065(){
        clickOnElement(productHpLP3065);
    }
    public String getHPLP3065TextFromList(){
        return getTextFromElement(getHPLP3065Text);
    }
    public void clickOnDeliveryDate(){
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
    public void enterQuantity1(String  num){
        driver.findElement(enterQuantity).clear();
        sendTextToElement(enterQuantity,num);
    }
    public void clickOnAdToCart() {
        clickOnElement(addToCart);
    }
    public String verifyProductAddedToShoppingCartText(){
        return getTextFromElement(getProductAddedToShoppingCartText);
    }
    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }
    public String verifyTextShoppingCart(){
        return getTextFromElement(getShoppingCartText);
    }
    public String verifyTextProductNameHPLP3065(){
        return getTextFromElement(getHPLP3065Message);
    }
    public String verifyDeliveryDate(){
        return getTextFromElement(getDeliveryDateText);
    }
    public String verifyTheModelProduct21Text(){
        return getTextFromElement(getProduct21Text);
    }
    public String verifyTheTotalPriceText(){
        return getTextFromElement(getTotalPriceText);
    }
}
