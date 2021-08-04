package tests;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class StoreTests extends TestBase {

    @Test(groups = {"regression","smoke"})
    public void test1() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));

        storeAppHomePage.contactUsButton.click();
//Select object
        Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");

        storeAppContactUsPage.email.sendKeys("123@gmail.com");

        String projectPath = System.getProperty("user.dir");//
        storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/configurations/testData/Myimage.jpeg");

        storeAppContactUsPage.message.sendKeys("Hello World");
        storeAppContactUsPage.submitButton.click();

        String actualmessage = storeAppContactUsPage.successMesage.getText();
        String expected = "Your message has been successfully sent to our team.";
        Assert.assertEquals(actualmessage, expected);


    }

    //Negative scenario for contact us
    @Test(groups={"regression","smoke"})
    public void test2() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));

        storeAppHomePage.contactUsButton.click();
//Select object
        Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");

        storeAppContactUsPage.email.sendKeys("123@gmail.com");

        String projectPath = System.getProperty("user.dir");//
        storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/configurations/testData/Myimage.jpeg");

        storeAppContactUsPage.submitButton.click();

        String actualErrorMessage=storeAppContactUsPage.erroeMessage.getText();
        String expectedErrorMessage="The message cannot be blank.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }






}
