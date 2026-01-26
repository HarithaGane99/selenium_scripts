import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

        WebDriver driver;
        @BeforeMethod
        public void openFrameTestPage(){
            driver = new ChromeDriver();

            driver.manage().window().maximize();

        }

        @Test
        public void frameExample() throws InterruptedException {
            driver.get("https://www.leafground.com/frame.xhtml");
            Thread.sleep(2000);

            //01 Click Me Inside Frame
            driver.switchTo().frame(0);
           WebElement btn = driver.findElement(By.id("Click"));
           btn.click();

           String afterClickBtnText= btn.getText();
           System.out.println(afterClickBtnText);


            //02 Click Me Inside Nested Frame

            driver.switchTo().defaultContent();
            driver.switchTo().frame(2);  //inside in the 3rd frame //index cant apply here (because nested frames)
            driver.switchTo().frame("frame2");//inside into child frame (4th)

            WebElement btn3 = driver.findElement(By.xpath("//button[@id='Click']"));
            btn3.click();


            //03 Count frames

            driver.switchTo().defaultContent();
            List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
            int count = getIframeTagCount.size();
            System.out.println(count);

            for(WebElement iframeElement : getIframeTagCount){
                String frameSRCAttribute = iframeElement.getAttribute("src");
                System.out.println(frameSRCAttribute);
            }




        }

}
