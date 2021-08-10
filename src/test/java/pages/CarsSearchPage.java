package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarsSearchPage {
    public CarsSearchPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='model_audi-q5']")
    public WebElement modelCheckBox;
    @FindBy(xpath="//h1[@class='sds-heading--1 sds-page-section__title']")
    public WebElement q5Cars;

    @FindBy(id= "price-badge-label-deal_rating_great")
    public WebElement greatDealCheckBox;

    @FindBy(xpath = "//span[@class='sds-badge__label']")
    public List<WebElement> q5Validation;


}
