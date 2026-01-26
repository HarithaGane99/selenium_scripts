import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {
    WebDriver driver;
    @BeforeMethod
    public void openWindowTestPage(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void windowExample() throws InterruptedException {
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(2000);

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle: " + oldWindow);

        //01 Click and confirm new Window Opens
        driver.findElement(By.id("j_idt88:new")).click();

        Thread.sleep(2000);

        Set<String> handles=driver.getWindowHandles();
        System.out.println("Window Handles size : " + handles.size());

        //1.1 using for each loop

//     for(String newWindow : handles) {
//         System.out.println(newWindow);
//         driver.switchTo().window(newWindow);
//         System.out.println("Page title : " + driver.getTitle());
//    }
//     driver.close();
//     driver.switchTo().window(oldWindow);




        //1.2 using List
        List<String> w_handles=new ArrayList<String>(handles); ///converting set to the List
        if(w_handles.size()>1){
            driver.switchTo().window(w_handles.get(1));
            System.out.println("Window Title : " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }




        WebElement openButton = driver.findElement(By.id("j_idt88:new"));
        boolean openButtonVisibility=openButton.isDisplayed();
        System.out.println("Open button visibility : " + openButtonVisibility);


        //02 Find the number of opened tabs
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        driver.getWindowHandles().size();
        System.out.println("No of windows opened  : " + driver.getWindowHandles().size());

        //03 Close all windows except primary
        WebElement dontCloseMeButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        dontCloseMeButton.click();
        Thread.sleep(2000);

        Set<String> newWindowHandles = driver.getWindowHandles();
        System.out.println("New window handle size "+newWindowHandles.size());
        for(String allWindows:newWindowHandles){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }

        }

        driver.quit();//------>close all browser windows

//         driver.switchTo().window(oldWindow);

//         driver.close();--------> close single browser window driver which on focus

    }

}
