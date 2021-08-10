package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarsHomePage;
import pages.CarsSearchPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.IOException;

public class FilteringSearchResultTest extends TestBase {
    @Test(groups = {"regression", "smoke"})
    public void modelValidation() throws InterruptedException, IOException {
        driver.get(ConfigReader.getProperty("CarsURL"));//User Navigating to application

        CarsHomePage carsHomePage = new CarsHomePage();
        CarsSearchPage carsSearchPage = new CarsSearchPage();

        carsHomePage.newUsedButton.sendKeys("New & used cars");
        carsHomePage.makeButton.sendKeys("Audi");
        carsHomePage.modelsBotton.sendKeys("All models");
        carsHomePage.priceButton.sendKeys("$15,000");
        carsHomePage.distanceButton.sendKeys("50 miles");
        carsHomePage.zipCodeButton.sendKeys("60659");
        carsHomePage.searchButton.click();

        BrowserUtils.scroll(1000);
        BrowserUtils.hoverOver(carsSearchPage.modelCheckBox);

        carsSearchPage.modelCheckBox.click();
        Thread.sleep(9000);
        BrowserUtils.takeScreenshot("CarsQ5");
        String actualTitle = carsSearchPage.q5Cars.getText();
        String expectedTitle = "New and used Audi Q5 for sale";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups = {"regression", "smoke"})
    public void greatDealValidation() throws InterruptedException, IOException {
        driver.get(ConfigReader.getProperty("CarsURL"));//User Navigating to application

        CarsHomePage carsHomePage = new CarsHomePage();
        CarsSearchPage carsSearchPage = new CarsSearchPage();

        carsHomePage.newUsedButton.sendKeys("New & used cars");
        carsHomePage.makeButton.sendKeys("Audi");
        carsHomePage.modelsBotton.sendKeys("All models");
        carsHomePage.priceButton.sendKeys("$15,000");
        carsHomePage.distanceButton.sendKeys("50 miles");
        carsHomePage.zipCodeButton.sendKeys("60659");
        carsHomePage.searchButton.click();

        BrowserUtils.scroll(1200);
        BrowserUtils.hoverOver(carsSearchPage.greatDealCheckBox);
        carsSearchPage.greatDealCheckBox.click();
        Thread.sleep(8000);
        BrowserUtils.takeScreenshot("Cars");
        String expectedResults = carsSearchPage.q5Validation.get(0).getText().substring(0,10);
        String actualResults = "Great Deal";
        Assert.assertEquals(actualResults, expectedResults);


    }

}
