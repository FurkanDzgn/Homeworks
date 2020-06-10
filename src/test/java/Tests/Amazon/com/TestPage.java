package Tests.Amazon.com;

import DataSource.AmazonDataSource;
import Pages.AmazonPage;
import Tests.TestBase;
import Utils.StringConverter;
import Utils.utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPage extends TestBase {

    AmazonPage page;

    @BeforeClass
    public void setUpPage(){
        page=new AmazonPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://calculator.s3.amazonaws.com/index.html");
        page.continueButton.click();
    }

    @Test(priority = 1,dataProvider = "AmazonData",dataProviderClass = AmazonDataSource.class)
    public void testCase1(String text,String type){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(page.addEC2));
        page.addEC2.click();
        page.addType.get(page.addType.size()-2).click();

        int index=0;
        for(int i=0;i<page.tiTypeSelectButton.size();i++){
            if(page.tiTypeText.get(i).getText().equals(type)){
                index=i;
                break;
            }
        }
        page.tiTypeSelectButton.get(index).click();
        page.closeAndSave.click();
        page.addDescription.get(page.addDescription.size()-1).sendKeys(text);


    }

    @Test(priority = 2,dependsOnMethods = "testCase1")
    public void testCase2(){

        softAssert.assertTrue(page.addDescription.size()==5);
        softAssert.assertAll();

        double total=0;
        for(WebElement pp:page.prices){
           double res=StringConverter.converter(pp.getText());
            total+=res;
        }

       page.estimateButton.click();

        double result=StringConverter.converter2(page.newPrice.getText())+8.50;

        Assert.assertEquals(total,result);

        page.serviceButton.click();
    }

    @Test(priority = 3)
    public void testCase2sub2(){

        double oldTotal=0;
        for(WebElement pp:page.prices){
            double res=StringConverter.converter(pp.getText());
            oldTotal+=res;
        }

        double oldResult=StringConverter.converter2(page.newPrice.getText())+8.50;

        for(WebElement x:page.usage){
            Select select=new Select(x);
            select.selectByValue("2");
        }

        double newTotal=0;
        for(WebElement pp:page.prices){
            double res=StringConverter.converter(pp.getText());
            newTotal+=res;
        }
        Assert.assertTrue(oldTotal!=newTotal);
        page.estimateButton.click();
        double newResult=StringConverter.converter2(page.newPrice2.getText())+8.50;

        Assert.assertTrue(oldResult!=newResult);



    }

    @Parameters({"name","Includes"})
    @Test(priority = 4)
    public void testCase2Sub3(String name,String include){
        page.saveAndShare.click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(page.getName));
        page.getName.sendKeys(name);
        page.getIncludes.sendKeys(include);
        page.okButton.click();
        page.url.click();

        String id=driver.getWindowHandle();
        utils.switchWindow(driver,id);

        wait.until(ExpectedConditions.visibilityOf(page.continueButton));
        page.getContinueButton.click();

//        Actions actions=new Actions(driver);
//        actions.moveToElement(page.getContinueButton).click().perform();
        Double step1=StringConverter.converter2(page.newPrice2.getText());
        Double step2=StringConverter.converter2(page.lastPrice.getText());
        Assert.assertEquals(step1,step2);

    }



}
