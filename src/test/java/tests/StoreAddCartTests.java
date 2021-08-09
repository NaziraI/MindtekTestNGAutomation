package tests;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StoreAppHomePage;
import pages.StoreAppShoppingCartPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import javax.swing.*;

public class StoreAddCartTests extends TestBase {

    @Test(groups={"regression","smoke"})
    public void addCartFunctionalityTest() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppShoppingCartPage storeAppShoppingCartPage = new StoreAppShoppingCartPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        String itemPrice = storeAppHomePage.prices.get(1).getText();

        //To scroll down we use this method
        BrowserUtils.scroll(700);

        //To hover over we need to create action object
        Actions actions = new Actions(driver);//we can optimize it by creating a method in BrowserUtils class and
        actions.moveToElement(storeAppHomePage.item1).perform();//We can delete line30,31 and replace with : BrowserUtils.hoverOver(storeAppHomePage.item1)

        storeAppHomePage.addToCartItem1.click();

        String actualSuccessMessage = BrowserUtils.waitElementToBeVisible(storeAppHomePage.addCartSuccessMessage).getText();
        String expectedSuccessMessage = "Product successfully added to your shopping cart";// here I  can change the value"cart --> car, purposely so we can see why we need softAssert


        //we wil do softAssert when have  multiple validation
        // for example it will be failure with first validation it will skip it and do next validation;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);// instead of Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        String qauntity = storeAppHomePage.quantity.getText();
        String total = storeAppHomePage.totalPrice.getText();

        //itemPrice,quantity, total
        //itemPrice->1$6.51
        //quantity->2
        //total->$33.02

        itemPrice = itemPrice.substring(1);// we took out $ sign from $16.51

        double itemPriceDouble = Double.parseDouble(itemPrice);// we are converting String in to the double
        double quantityDouble = Double.parseDouble(qauntity);//"1"->1.0
        total = total.substring(1);//$33.02->33.02
        double totalDouble = Double.parseDouble(total);

        double expectedPrice = itemPriceDouble * quantityDouble;
        double actualPrice = totalDouble;
        softAssert.assertEquals(actualPrice, expectedPrice);//or we can do  Assert.assertEquals(actualPrice, expectedPrice);

        storeAppHomePage.proceedToCheckOut.click();

        String totalProduct = storeAppShoppingCartPage.totalProduct.getText();//$16.51
        totalProduct = totalProduct.substring(1);
        double totalProductDouble = Double.parseDouble(totalProduct);
        softAssert.assertEquals(actualPrice, totalProductDouble);// it was like:Assert.assertEquals(actualPrice, totalProductDouble);

        String shippingAmount = storeAppShoppingCartPage.totalShipping.getText().substring(1);
        double shippingAmountDouble = Double.parseDouble(shippingAmount);

        String taxAmount = storeAppShoppingCartPage.tax.getText().substring(1);
        double taxAmountDouble = Double.parseDouble(taxAmount);

        String actualTotal = storeAppShoppingCartPage.totalPrice.getText().substring(1);
        double actualTotalDouble = Double.parseDouble(actualTotal);// To optimize we can create a method in DataUtils class->DataUtils.remove$AndConvertToDouble(actualTotal)
        //getting total:
        double expectedTotal = totalProductDouble + shippingAmountDouble + taxAmountDouble;

        softAssert.assertEquals(actualTotalDouble, expectedTotal);
        softAssert.assertAll();// to show which test fail

    }


}
