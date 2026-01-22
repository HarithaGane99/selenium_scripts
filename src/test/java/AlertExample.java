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
    public void alertTest(){
        driver.get("https://www.leafground.com/alert.xhtml");

        //01 Alert (simple dialog)
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        Alert alert =driver.switchTo().alert();
        alert.accept();

    }
}
