import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class DatePickerExample {



        WebDriver driver;
        @BeforeMethod
        public void DatePickerBrowserOpen() throws InterruptedException {
            ChromeOptions options = new ChromeOptions();
            File file = new File("D:\\QA\\NDGIMIBANHLABGDGJCPBBNDIEHLJCPFH_5_6_2_0.crx");
            options.addExtensions(file);
            driver = new ChromeDriver();

            driver.manage().window().maximize();


        }



        @Test
        public void DatePicker() throws InterruptedException {
            driver.get("https://jqueryui.com/datepicker/");
            Thread.sleep(2000);

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

            //Method 1
//            WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//            datePicker.sendKeys("04/29/2026");

            //Method 2

                WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
                datePicker.click();

                //setFutureDate("2027","January","16");
                setPastDate("2025","January","23");





        }

        public void setFutureDate(String year, String month, String day) throws InterruptedException {
            while(true){
                String actual_month =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                String actual_year =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

                if(actual_year.equals(year) && actual_month.equals(month)){
                    break;
                }
                else{
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                }
            }
            List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

            for(WebElement dateElement : allDates){
                if(dateElement.getText().equals(day)){
                    dateElement.click();
                    break;
                }
            }

        }

    public void setPastDate(String year, String month, String day) throws InterruptedException {
        while(true){
            String actual_month =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actual_year =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(actual_year.equals(year) && actual_month.equals(month)){
                break;
            }
            else{
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }
        }
        List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for(WebElement dateElement : allDates){
            if(dateElement.getText().equals(day)){
                dateElement.click();
                break;
            }
        }

    }


}
