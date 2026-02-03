import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImage {
    WebDriver driver;
    @BeforeMethod
    public void BrokenImageBrowserOpen() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        File file = new File("D:\\QA\\NDGIMIBANHLABGDGJCPBBNDIEHLJCPFH_5_6_2_0.crx");
        options.addExtensions(file);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(2000);

    }



    @Test
    public void BrokenImage() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        //naturalWidth ='0'
        int i=1;
        for(WebElement image:images){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image "+i+" is Broken");
            }
            else{
                System.out.println("Image "+i+" is not Broken");
            }
            i++;
        }


    }
}
