import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {
    WebDriver driver;
    @BeforeMethod
    public void DownloadUploadTestBrowserOpen() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(2000);

    }



    @Test
    public void DownloadAFile() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(2000);

        File downloadedFile = new File("C:\\Users\\harit\\Downloads");
        File [] totalFiles=downloadedFile.listFiles();
        for(File findFile:totalFiles){
            if(findFile.getName().endsWith("TestLeaf Logo.png")){
                System.out.println("File Found in the Downloads directory");
                break;
            }

        }





    }

    @Test
    public void UploadAFile() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way - Using Robot Class
//        WebElement uploadButton = driver.findElement(By.xpath("//span[@id='j_idt88:j_idt89']"));
//        uploadButton.click();
//
//        //Windows control begin here
//        StringSelection selection = new StringSelection("C:\\Users\\harit\\Downloads\\TestLeaf Logo.png");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        Thread.sleep(4000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);

//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//

        //2. Using Send Keys (Applicable only if element type is file)
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys("C:\\Users\\harit\\Downloads\\TestLeaf Logo.png");


    }
}
