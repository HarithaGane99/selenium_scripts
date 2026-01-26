import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationsExample {
    WebDriver driver;
    @BeforeMethod
    public void openWindowTestPage(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void actionMouseExample() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");



        System.out.println("---(1)------Move to an element operation-------");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();


        System.out.println("---(2)------Drag and Drop Operation-------");

        WebElement from = driver.findElement(By.id("form:drag_content"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.dragAndDrop(from, to).perform();
        actions.clickAndHold(from).moveToElement(to).release().perform();


        System.out.println("---(3)------Slider Operation-------");

        WebElement  sliderPoint1 =driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("location of slider point 1 before moving"+sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1, 50,0).perform();
        System.out.println("Location of slider point 1 after moving"+sliderPoint1.getLocation());


    }

    @Test()
        public void mouseOperationTest2(){
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
            System.out.println("-----(4)----- Right Click ------");

             WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

             Actions actions1 = new Actions(driver);
             actions1.contextClick(rightClickBtn).perform();
             WebElement editBtn = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
             editBtn.click();
             Alert alertPop = driver.switchTo().alert();

             System.out.println("Alert shows the text as "+alertPop.getText());
             alertPop.accept();

        }


}
