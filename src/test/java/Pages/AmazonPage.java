package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AmazonPage {

    public AmazonPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='gwt-Button PRCPopupOldcalculatorLink']")
    public WebElement continueButton;

    @FindBy(xpath = "(//img[@src='//d2zogmwzrm9slh.cloudfront.net/ver20200527oH/common/icons/small/add.png'])[1]")
    public WebElement addEC2;

    @FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//td//input")
    public List<WebElement> addDescription;

    @FindBy(xpath = "//img[@src='//d2zogmwzrm9slh.cloudfront.net/ver20200527oH/common/icons/small/config_16x16.png']")
    public List<WebElement> addType;

    @FindBy(xpath = "//input[@name='SelectorDialogType']")
    public List<WebElement> tiTypeSelectButton;

    @FindBy(xpath = "//tr[@class='instance RowSelectable']//td[@align='left']//div[@class='gwt-Label']")
    public List<WebElement> tiTypeText;

    @FindBy(xpath = "//button[contains(text(),'Close and Save')]")
    public WebElement closeAndSave;

    @FindBy(xpath = "//div[@class='gwt-HTML DynamicPrice DynamicPricePricing']")
    public List<WebElement> prices;

    @FindBy(xpath = "//div[@class='gwt-TabBarItem']")
    public WebElement estimateButton;

    @FindBy(xpath = "//div[contains(text(),'Estimate of your Monthly Bill ($ 381.24)')]")
    public WebElement newPrice;

    @FindBy(xpath = "(//div[.='Services'])[1]")
    public WebElement serviceButton;

    @FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//select[@class='gwt-ListBox unit']")
    public List<WebElement> usage;

    @FindBy(xpath = "//div[contains(text(),'Estimate of your Monthly Bill ($ 223.97)')]")
    public WebElement newPrice2;

    @FindBy(xpath = "//button[.='Save and Share']")
    public WebElement saveAndShare;

    @FindBy(xpath = "//input[contains(@class,'gwt-TextBox SC_SOLUTION_Input')]")
    public WebElement getName;

    @FindBy(xpath = "//textarea[contains(@class,'gwt-TextArea SC_INCLUDES_Input')]")
    public WebElement getIncludes;

    @FindBy(xpath = "//button[contains(.,'OK')]")
    public WebElement okButton;

    @FindBy(xpath = "//a[@id='saveURL']")
    public WebElement url;

    @FindBy(xpath = "(//div[.='Estimate of your Monthly Bill ($ 223.97)'])[2]")
    public WebElement lastPrice;

    @FindBy(xpath = "//button[.='Continue with Simple Monthly Calculator']")
    public WebElement getContinueButton;



}
