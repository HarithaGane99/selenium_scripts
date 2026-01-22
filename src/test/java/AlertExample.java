import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;
    @BeforeMethod
    public void openAlertTestPage(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://www.leafground.com/alert.xhtml");

        //01 Alert (simple dialog)
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        Alert alert =driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //02 Cancel Button (confirm dialog)
        driver.findElement(By.id("j_idt88:j_idt93")).click();

        Alert alert2 =driver.switchTo().alert();
        Thread.sleep(2000);
        alert2.dismiss();


        //03 Typing Alert Box
        driver.findElement(By.id("j_idt88:j_idt104")).click();
        Alert alert3 =driver.switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert3.getText();
        System.out.println("Alert Text: " + alertText);
        alert3.sendKeys("Haritha");
        alert.accept();



    }
}
