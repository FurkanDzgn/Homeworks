package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class utils {

    public static void switchWindow(WebDriver driver,String parentId) {
        Set<String> ids=driver.getWindowHandles();
        for(String id:ids){
            if(!id.equals(parentId)){
                driver.switchTo().window(id);
            }
        }

    }
}
