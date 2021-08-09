package pages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class StoreAppShoppingCartPage {
    public StoreAppShoppingCartPage(){//constructor
        WebDriver driver= Driver.getDriver();//driver
        PageFactory.initElements(driver,this);//
    }
    @FindBy(id = "total_shipping")
    public WebElement totalShipping;

    @FindBy(id = "total_tax")
    public WebElement tax;

    @FindBy(id = "total_price")
    public WebElement totalPrice;

    @FindBy(id = "total_product")
    public WebElement totalProduct;
}

