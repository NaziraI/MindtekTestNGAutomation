package tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazeDemoTests extends TestBase {


    @Test(groups = {"regression"})
    public void test1() {
        BlazedemoHomePage blazedemoHomePage = new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();
        driver.get(ConfigReader.getProperty("blazeDemo"));
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazedemoHomePage.findFlightsButton.click();

        List<WebElement> prices = blazedemoFlightsPage.prices;

        for (WebElement element : prices) {
            String priceStr = element.getText();
            //@472.56==String-->int==Integer.parseInt(String);-->int
            //$472==>472.56
            priceStr = priceStr.substring(1);
            double priceDouble = Double.parseDouble(priceStr);
            Assert.assertTrue(priceDouble < 1000);
        }
    }

    @Test(groups ={"regression"})
    public void test2() {
        BlazedemoHomePage blazedemoHomePage = new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();
        driver.get(ConfigReader.getProperty("blazeDemo"));

        Select select = new Select(blazedemoHomePage.fromCityDropdown);
        select.deselectByVisibleText("Boston");
        select = new Select(blazedemoHomePage.toCityDropdown);
        select.selectByVisibleText("London");
        blazedemoHomePage.findFlightsButton.click();
        String actualText = blazedemoFlightsPage.headerText.getText();
        String expectedText = "Flights from Boston to London:";
        Assert.assertEquals(actualText, expectedText);

    }
}
