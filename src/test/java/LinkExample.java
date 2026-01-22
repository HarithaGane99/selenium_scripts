import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/link.xhtml");
        driver.manage().window().maximize();

    }

    @Test
    public void LinkTests(){
        //01 Take me to dashboard
       WebElement homeLink =  driver.findElement(By.linkText("Go to Dashboard"));
       homeLink.click();
       driver.navigate().back();

        //02 Find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : "+ path);

        //03 Am I a broken link
        WebElement brokenLink = driver.findElement(By.partialLinkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("The link is broken");
        }
        else{
            System.out.println("Link is not broken");


        }
        driver.navigate().back();

        //04 Duplicate Link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();

        //05 Count Page Links

        List<WebElement> countFullPageLinks=  driver.findElements(By.tagName("a"));
        countFullPageLinks.size();
        System.out.println("This page has "+countFullPageLinks.size()+" links");



        //06 Count layout Links
        WebElement layoutElement =  driver.findElement(By.className("layout-main-content"));

        List<WebElement> countLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("This section has "+countLayoutLinks.size()+" links");



    }












}
