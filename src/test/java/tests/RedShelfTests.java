package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class RedShelfTests extends TestBase {
    /*
    @ Before method--->inherited from TestBase
    @Test
    @After method--->inherited from TestBase
     */

   // WebDriver driver;

    /*@BeforeMethod
    public void setUp() {
        /*
        Set up driver
        1.Setproperty-> we need chrome driver
        2.Create Webdriver Object
         */
        //WebDriverManager.edgedriver().setup();//1.
       //
        //driver = new EdgeDriver();//2
       // driver= Driver.getDriver();
    //}

    @Test(groups = {"regression"})
    public void test1() {
        driver.get(ConfigReader.getProperty("RedShelfURL"));
        String expectedTitle = "RedShelf";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups = {"regression"})
    public void test2() {
        driver.get(ConfigReader.getProperty("RedShelfURL"));//if I want to change I go to Config.properties and change the value
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure"+Keys.ENTER) ;
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookName = driver.findElement(By.xpath("//h1/span")).getText();
        String title=driver.getTitle();

        //We should validate that title starts with book name
        Assert.assertTrue(title.startsWith(bookName));//boolean
    }
    @Test(groups ={"regression","smoke"})
    public void test3(){
        driver.get(ConfigReader.getProperty("RedShelfURL"));
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure"+Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookName = driver.findElement(By.xpath("//h1/span")).getText();
        String eISBN=driver.findElement(By.xpath("//span[@class='significant-isbn']")).getText();
        System.out.println(eISBN);

        driver.findElement(By.id("search-catalog-navbar")).sendKeys(eISBN+Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookNameISBN = driver.findElement(By.xpath("//h1/span")).getText();
        //Validation:validate  both books are same
        Assert.assertEquals(bookNameISBN,bookName);


    }

    //@AfterMethod
    //public void tearDown() {
      //  driver.quit();
    }

