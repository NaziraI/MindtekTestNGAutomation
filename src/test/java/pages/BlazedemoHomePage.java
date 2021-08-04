package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazedemoHomePage {

    //@FindBy
    public BlazedemoHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);//
    }

    //attribute
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement findFlightsButton;
//public WebElement findFlightsButton=driver.findElement("//input[@type='submit']");

    @FindBy(name="fromPort")
    public WebElement fromCityDropdown;

    @FindBy(name = "toPort")
    public WebElement toCityDropdown;
}
