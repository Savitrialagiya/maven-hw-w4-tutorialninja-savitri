package php.index.demo.com.tutorialsninja.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import php.index.demo.com.tutorialsninja.utility.Utility;

import java.util.List;

public class TopMenuPage extends Utility {

By desktopTab = By.linkText("Desktops");
By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
By componentsTab = By.linkText("Components");
By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(selectMenu);
        }
    }
    public void mouseHoverToElementAndClickOnDesktop(){
        mouseHoverToElementAndClick(desktopTab);
    }
    public String getTextDesktop(){
        return getTextFromElement(desktopText);
    }
    public void mouseHoverOnLaptopsAndNotebooksTab(){
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }
    public String getLaptopsAndNotebooksText(){
        return getTextFromElement(laptopsAndNotebooksText);
    }
    public void mouseHoverToComponentsTab(){
        mouseHoverToElementAndClick(componentsTab);
    }
    public String getComponentsText(){
        return getTextFromElement(componentsText);
    }

}
