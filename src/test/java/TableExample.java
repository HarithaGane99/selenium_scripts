import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TableExample {
    WebDriver driver;
    @BeforeMethod
    public void TableExampleBrowserOpen() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        File file = new File("D:\\QA\\NDGIMIBANHLABGDGJCPBBNDIEHLJCPFH_5_6_2_0.crx");
        options.addExtensions(file);
        driver = new ChromeDriver();

        driver.manage().window().maximize();


    }



    @Test
    public void TableExample() throws InterruptedException {

        driver.get("https://testautomationpractice.blogspot.com/");
        //1. How many rows in the table
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
        int rowSize=rows.size();
        System.out.println("Row count is "+rowSize);

        //2. How many columns count
        int columns=driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column count is "+columns);

        //3. Retrieve the specific row/column data
        String value =driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified row column data is "+value);

        //4. Retrieve all the data from table
        for (int i=1;i<=rowSize;i++) { ///Rows
            for (int j=1;j<columns;j++) { //Columns
               String tblData= driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
               System.out.println(tblData+"  ");
            }
            System.out.println();
        }

    }
}
