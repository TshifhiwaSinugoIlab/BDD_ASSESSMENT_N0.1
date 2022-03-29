package Automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class searchHotel {

    protected WebDriver driver;
    public searchHotel(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath ="//*[@id=\"location\"]")
    public WebElement location;

    @FindBy(xpath = "//*[@id=\"hotels\"]")
    public WebElement hotels  ;

    @FindBy(xpath = "//*[@id=\"room_type\"]")
    public WebElement room_type;

    @FindBy(xpath ="//*[@id=\"room_nos\"]")
    public WebElement room_no;

    @FindBy(xpath ="//*[@id=\"datepick_in\"]")
    public WebElement check_in_date;

    @FindBy(xpath ="//*[@id=\"datepick_out\"]")
    public WebElement check_out_date;

    @FindBy(xpath = "//*[@id=\"adult_room\"]")
    public WebElement adults;

    @FindBy(xpath ="//*[@id=\"child_room\"]")
    public WebElement children;

    @FindBy(xpath ="//*[@id=\"Submit\"]")
    public WebElement submit;

}
