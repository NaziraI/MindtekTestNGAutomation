package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    /*
    method that will accept dropdown Webelement and value  of that dropdown, and it will select that value which is provided in parameter
    Ex:
    .selectByValue(dropdownElement,"1");---> void
     */
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);//the one that user provided

    }

    //Tih method will take screenshot of browser
    //Ex:
    //  .takeScreenshot("LoginTest");
    public static void takeScreenshot(String name) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshorts/" + name + ".png";//for dynamic value so other can reachit
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);
    }

    //Method will wait til element is clickable
    public static WebElement waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }

    //Method will wait until element is visible
    public static WebElement waitElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }

    public  static void scroll(int pixels){
        WebDriver driver=Driver.getDriver();
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }
}