package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.io.IOException;
import java.util.Random;

// DATA DRIVEN TESTING :
// TESTING FUNCTIONALITY WITH DIFFERENT SETS OF DATA

public class StoreRegisterFunctionalityTests extends TestBase {

    String email;
    String password;

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData() {
        Object[][] data = new Object[][]{// two dimentional array
                {"John", "Doe", "123456789", DataUtils.generateNumber(30) + "", "1", "2021", "123 Clark street", "Chicago", "13", "12345", "21", "123456789"},
                {"Kim", "Mi", "bchfjsk", "1", "12", "1980", "234 clark str", "New York", "32", "54321", "21", "987654321"}// we can add as muvh as we want
        };
        return data;
    }

    @Test(dataProvider = "signUpDataProvider", groups = {"regression", "smoke"})
    public void test1(String firstname, String lastName, String password, String day, String month, String year, String address, String city, String state,
                      String zipCode, String country, String phoneNumber) throws IOException {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.signInButton.click();
        //abc37346@gmail.com
        //abc23867@gmail.com
        // we need to generate random number by Creating object Random..
        //for Dynamic testing

        //Random random = new Random();
        //int emailId = random.nextInt(100000);//range number between 0 and 100000
        //String email = "abc" + emailId + "@gmail.com";
        email = DataUtils.generateEmail();
        storeAppLoginPage.emailBox.sendKeys(email);
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.firstName.sendKeys(firstname);
        storeAppCreateAccountPage.LastNameBox.sendKeys(lastName);
        this.password = password;
        storeAppCreateAccountPage.PasswordBox.sendKeys(password);

        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);//see BrowserUtils class in Utilities package
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);
        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);

        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox, state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox, country);
        storeAppCreateAccountPage.phoneNumber.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        //taking screenshot
        BrowserUtils.takeScreenshot("signUpValidation");
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";

        // If it does not match actual and expected we can add 3rd parameter for reading purpose
        //Assert.assertEquals(actualTitle, expectedTitle,"Actual title "+actualTitle+"did not match with expected title "+expectedTitle);

        Assert.assertEquals(actualTitle, expectedTitle);


    }

    //Login Functionality
    @Test(dependsOnMethods = {"test1"})
    public void test2() throws IOException {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.signInButton.click();
        storeAppLoginPage.logInEmaibox.sendKeys(email);
        storeAppLoginPage.loginPasswordBox.sendKeys(password);
        storeAppLoginPage.loginButton.click();

        BrowserUtils.takeScreenshot("LogInValidation");
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
