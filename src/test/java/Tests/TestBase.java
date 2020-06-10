package Tests;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestBase {

    public WebDriver driver;
    public SoftAssert softAssert;

    @Parameters("driverName")
    @BeforeClass(alwaysRun = true)
    public void setUp(String drivername){
        driver= Driver.getDriver(drivername);
        softAssert=new SoftAssert();
        driver.manage().window().maximize();

    }

}
