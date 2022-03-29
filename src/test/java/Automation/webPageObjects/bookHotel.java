package Automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class bookHotel {

    protected WebDriver driver;
    public bookHotel(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath ="//*[@id=\"first_name\"]")
    public WebElement firstname;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    public WebElement surname  ;

    @FindBy(xpath = "//*[@id=\"address\"]")
    public WebElement billing;

    @FindBy(xpath ="//*[@id=\"cc_num\"]")
    public WebElement account;

    @FindBy(xpath ="//*[@id=\"cc_type\"]")
    public  WebElement account_type;

    @FindBy(xpath ="//*[@id=\"cc_exp_month\"]")
    public  WebElement month;

    @FindBy(xpath ="//*[@id=\"cc_exp_year\"]")
    public  WebElement year;

    @FindBy(xpath ="//*[@id=\"cc_cvv\"]")
    public  WebElement cvv;

    @FindBy(xpath ="//*[@id=\"book_now\"]")
    public  WebElement book;

    @FindBy(xpath ="//*[@id=\"order_no\"]")
    public  WebElement orderNo;

}
