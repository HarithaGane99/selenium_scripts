import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/button.xhtml");
        Dimension newSize = new Dimension(1000, 800);
        driver.manage().window().setSize(newSize);

    }

    @Test
    public void buttonTests(){
        //1. Click and confirm title

        WebElement clickbutton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        clickbutton.click();
        String expectedTitle="Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test Passed. Actual Title is same as expected Title");
        }
        else {
            System.out.println("Test Failed. Actual Title is different from expected Title");
        }

        //2.Find the position of the submit button

        driver.navigate().back();
         WebElement getPosition =driver.findElement(By.id("j_idt88:j_idt94"));
         Point xypoint =getPosition.getLocation();
         int x=xypoint.getX();
         int y=xypoint.getY();
        System.out.println("X position is "+ x +" and Y position is "+ y);



        //3. Find the 'Save' button's color

        WebElement saveButton = driver.findElement(By.id("j_idt88:j_idt96"));
        String bgColor= saveButton.getCssValue("background-color");
        System.out.println("The background color is "+ bgColor);

        //4.Find the height and width of the button

        WebElement submitButton = driver.findElement(By.id("j_idt88:j_idt98"));
        int height=submitButton.getSize().getHeight();
        int width=submitButton.getSize().getWidth();

        System.out.println("The height is "+ height);
        System.out.println("The width is "+ width);

    }

}
