import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {
    WebDriver driver;
    @BeforeMethod
    public void keyboardOperationsTestBrowserOpen(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }



    @Test
    public void keyboardOperationsTestBrowserClose() throws InterruptedException {
        driver.get("http://google.com");
        WebElement textArea = driver.findElement(By.name("q"));
//        textArea.sendKeys("welcome");
//
        Actions actions = new Actions(driver);
//        ///Select the text
//        Action storingBuildOperation= actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
//        storingBuildOperation.perform();
//
//        Thread.sleep(3000);
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentence")
//                .keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .build().perform();

        //To write in capital in a text box
        actions.keyDown(textArea, Keys.SHIFT).
                sendKeys("haritha ganegoda")
                .perform();
    }

    @Test
    public void keyBoardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']//li"));
        int size =selectable.size();
        System.out.println("Li count is "+size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();


    }
    }