import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonExample {
    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void leafGroundRadioExample() throws InterruptedException {
        driver.get("https://www.leafground.com/radio.xhtml");



        //01 Find the default selected radio button
        boolean firstButton = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean secondButton = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean thirdButton = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean fourthButton = driver.findElement(By.id("j_idt87:console2:3")).isSelected();


       if(firstButton){
           String chromeText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
           System.out.println("Default selected radio button is : "+chromeText);
       }
       else if(secondButton){
           String fireFoxText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
           System.out.println("Default selected radio button is : "+fireFoxText);
       }
       else if(thirdButton){
           String safariText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
           System.out.println("Default selected radio button is : "+safariText);
       }
       else if(fourthButton){
           String edgeText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
           System.out.println("Default selected radio button is : "+edgeText);
       }






    WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
    boolean isChecked = myAgeGroup.isSelected();
    if(!isChecked){
        //myAgeGroup.click();
        driver.findElement(By.xpath("//label[normalize-space()='1-20 Years']")).click();
    }
    }








}
