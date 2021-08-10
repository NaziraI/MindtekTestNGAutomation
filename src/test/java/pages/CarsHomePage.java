package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarsHomePage {
    public  CarsHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="make-model-search-stocktype")
    public WebElement newUsedButton;

    @FindBy(id="makes")
    public WebElement makeButton;

    @FindBy(id="models")
    public WebElement  modelsBotton;

    @FindBy(id="make-model-max-price")
    public WebElement priceButton;

    @FindBy(id="make-model-maximum-distance")
    public WebElement distanceButton;

    @FindBy(id="make-model-zip")
    public WebElement zipCodeButton;

    @FindBy(xpath  ="//button[@data-linkname='search-all-make']")
    public WebElement searchButton;

}
