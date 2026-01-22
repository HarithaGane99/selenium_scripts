import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void leafGroundDropDownExample() throws InterruptedException {

        driver.get("https://www.leafground.com/select.xhtml");
        //1.1 Ways to select values in basic dropdown

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(2000);





        //1.2 Get the number of dropDown options

        int numberofElements = select.getOptions().size();
        System.out.println("Dropdown has "+numberofElements+" options");


        ///generics
        List<WebElement> listOfOptions=select.getOptions();
//        System.out.println(listOfOptions.size());

        for (WebElement option : listOfOptions) {
            System.out.println(option.getText());
        }



        //1.3 using sendKeys select dropdown value
        dropdown.sendKeys("Puppeteer");


        //1.4 Selecting value in a Bootstrap dropdown

        //WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));



    }

    //-------------------Google Search-----------------------------------------

    @Test
    public void googleSearchDropDown() throws InterruptedException { //This did not work though. I don't know why TT
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("harsha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList =  driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//div[@class='lnnVSe']"));

        System.out.println(googleSearchList.size());

        for (WebElement googleSearch : googleSearchList) {
            System.out.println(googleSearch.getText());
            String searchText = googleSearch.getText();
            if (searchText.equals("harsha de silva")) {
                googleSearch.click();
                break;
            }


            //3 Handle Hidden Auto Suggestions Drop Down And Search using DOM Debugger Trick
            //"body/div[@id='container']/div/div[@class='HaReuk']/div[@class='cDeXU9']/div[@class='uBUBH6']/div/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0 r-1iqfa7g r-60vfwk']/div[@class='css-175oi2r r-13awgt0 r-1iqfa7g r-60vfwk']/div[@class='bR1LPC']/div[@class='RWJtE9 MgT0wK']/div[@class='t4xD1Q']/div[@class='vi7ICf y1ntLi']/header[@class='YWJtky']/div[@class='MJZLK1']/div[@class='FQZ6ZB yBSM00']/form[@class='_Bidnv header-form-search XN_jdV']/ul[@class='GZVzXz GFxnd4 zWhq_n']/li[1]/div[1]"
        }
    }
}
