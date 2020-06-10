package DataSource;

import org.testng.annotations.DataProvider;

public class AmazonDataSource {

    @DataProvider(name = "AmazonData")
    public Object[][] getData(){
        return new Object[][]{
            {"T1 Linux Micro (Free)","t3.micro"},
            {"T1 Linux Micro 2","t2.micro"},
            {"T2 Linux Medium","t2.medium"},
            {"T2 Linux Large","t2.large"},
            {"T2 Linux XtraLarge","t2.2xlarge"},
        };
    }
}
