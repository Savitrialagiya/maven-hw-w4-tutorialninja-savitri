package php.index.demo.com.tutorialsninja.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.DesktopPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;

import java.util.List;

public class DesktopPageTest extends BaseTest {
 DesktopPage desktopPage = new DesktopPage();

 @Test
 public void verifyProductsPriceDisplayHighToLowSuccessfully(){
desktopPage.clickOnCurrencyLink();
desktopPage.mouseHoverOnDesktop();
desktopPage.clickOnShowAllDesktop();
desktopPage.sortByPositionNameZtoA("Name (Z - A)");
desktopPage.getProductsArrangeInDescendingOrderText();

 }
 @Test
 public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
  desktopPage.clickOnCurrencyLink();
  desktopPage.mouseHoverOnDesktop();
  desktopPage.clickOnShowAllDesktop();
  desktopPage.sortByPositionNameAtoZ("Name (A - Z)");
  desktopPage.clickOnProductHPLP3065();
  String expectedText = "HP LP3065";
  Assert.assertEquals(desktopPage.getHPLP3065TextFromList(),expectedText,"Product not found");
  desktopPage.clickOnDeliveryDate();
  desktopPage.enterQuantity1("1");
  desktopPage.clickOnAdToCart();
  Thread.sleep(2000);
  String expectedProductText = "Success: You have added HP LP3065 to your shopping cart!\n" +
          "×";
  Assert.assertEquals(desktopPage.verifyProductAddedToShoppingCartText(),expectedProductText,"Error message not displayed");
  desktopPage.clickOnShoppingCart();
  Thread.sleep(2000);
  Assert.assertEquals(desktopPage.verifyTextShoppingCart(),"Shopping Cart  (1.00kg)","Error message not displayed");
  Assert.assertEquals(desktopPage.verifyTextProductNameHPLP3065(),"HP LP3065","Product name not displayed");
  Thread.sleep(2000);
  Assert.assertEquals(desktopPage.verifyDeliveryDate(),"Delivery Date: 2023-11-30","Delivery not displayed");
  Assert.assertEquals(desktopPage.verifyTheModelProduct21Text(),"Product 21","Message not displayed");
  Assert.assertEquals(desktopPage.verifyTheTotalPriceText(),"£74.73","Price not displayed");
 }

}
