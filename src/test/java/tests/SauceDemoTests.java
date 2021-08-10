package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SauseDemoLoginPage;
import pages.SauseDemoTitlePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {
    @Test(groups = {"regression", "smoke"})
    @Parameters({"username", "password"})

    public void loginTest1(String username, String password) {
        SauseDemoLoginPage sauseDemoLoginPage = new SauseDemoLoginPage();
        SauseDemoTitlePage sauseDemoTitlePage=new SauseDemoTitlePage();
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauseDemoLoginPage.login.sendKeys(username);
        sauseDemoLoginPage.password.sendKeys(password);
        sauseDemoLoginPage.loginButton.click();
        String actualTitle=sauseDemoTitlePage.title.getText();
        String expectedTitle="PRODUCTS";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
