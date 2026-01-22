import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.setBrowserVersion("122");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.leafground.com/input.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }


    @Test
    public void testBoxTests(){
        //01 Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Haritha Ganegoda");

        //02 Append Country to the city
        WebElement country =  driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("India");


        //03 Verify if textbox is disabled
        boolean answer=driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        if(answer){
            System.out.println("Text box is enabled");
        }
        else {
            System.out.println("Text box is not enabled");
        }

        //04 Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05 Retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        textElement.getAttribute("value");

        //06 Type email and Tab. Confirm control moved to next element.
        WebElement emailText= driver.findElement(By.id("j_idt88:j_idt99"));
        emailText.sendKeys("haritha.99ganegoda@gmail.com" + Keys.TAB + "Confirm control moved to next element");






    }

}
