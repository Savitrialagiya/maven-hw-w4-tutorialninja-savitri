package php.index.demo.com.tutorialsninja.testsuite;


import org.testng.Assert;
import org.testng.annotations.Test;
import php.index.demo.com.tutorialsninja.pages.TopMenuPage;
import php.index.demo.com.tutorialsninja.testbase.BaseTest;

public class TopMenuPageTest extends BaseTest {

TopMenuPage topMenuPage = new TopMenuPage();
@Test
public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
    topMenuPage.mouseHoverToElementAndClickOnDesktop();
    topMenuPage.selectMenu("Show All Desktops");
    Assert.assertEquals(topMenuPage.getTextDesktop(),"Desktops","Message not displayed");
}
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
    topMenuPage.mouseHoverOnLaptopsAndNotebooksTab();
    topMenuPage.selectMenu("Show All Laptops & Notebooks");
    Assert.assertEquals(topMenuPage.getLaptopsAndNotebooksText(),"Laptops & Notebooks","Massage not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
    topMenuPage.mouseHoverToComponentsTab();
    topMenuPage.selectMenu("Show All Components");
    Assert.assertEquals(topMenuPage.getComponentsText(),"Components","Message not displayed");

    }
}
