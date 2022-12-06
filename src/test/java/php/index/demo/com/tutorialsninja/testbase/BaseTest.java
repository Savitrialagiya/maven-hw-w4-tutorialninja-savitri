package php.index.demo.com.tutorialsninja.testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import php.index.demo.com.tutorialsninja.propertyreader.PropertyReader;
import php.index.demo.com.tutorialsninja.utility.Utility;

public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        //closeBrowser();
    }
}
