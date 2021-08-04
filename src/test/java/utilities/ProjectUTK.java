package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectUTK {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get(ConfigReader.getProperty("SeleniumURL"));
        driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
        driver.findElement(By.xpath("//div[@id='navbar-brand-centered']//a[.='Table Pagination']")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='myTable']/tr[@style='display: table-row;']"));

        System.out.println(rows.size());
        Assert.assertEquals(rows.size(), 5);

        driver.findElement(By.xpath("//a[.='2'")).click();
        List<WebElement> rows2 = driver.findElements(By.xpath("//tbody[@id='myTable']/tr[@style='display: table-row;']"));
        Assert.assertEquals(rows2.size(), 5);


    }

    @Test
    public void test2() {
        driver.get(ConfigReader.getProperty("SeleniumURL2"));
        driver.findElement(By.xpath("//option[@value='Florida']")).click();
        driver.findElement(By.id("printMe")).click();

        String actualMessage = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
        String expectedMessage = "First selected option is : Florida";
        Assert.assertTrue( expectedMessage.contains(actualMessage));
    }

    @Test

    public void test3() {
        driver.get(ConfigReader.getProperty("SeleniumURL"));
        driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
        driver.findElement(By.xpath("//div[@id='navbar-brand-centered']//a[.='Table Sort & Search']")).click();
        driver.findElement(By.xpath("//th[contains(text(),'Name')]")).click();
        List<WebElement> names = driver.findElements(By.xpath("//td[@class='sorting_1']"));


    }
    @Test
    public void test4(){
        driver.get(ConfigReader.getProperty("URL"));

    }

    @AfterMethod
    public void tearUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
