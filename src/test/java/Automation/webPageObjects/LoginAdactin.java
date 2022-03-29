package Automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginAdactin {

    protected WebDriver driver;
    public LoginAdactin(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement txtUsernme;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement txtPassword  ;
    @FindBy(xpath = "//*[@id=\"login\"]")
    public WebElement btnLogin;

    @FindBy(xpath ="//*[@id=\'login_form\']/table/tbody/tr[5]/td[2]/div/b")
    public WebElement error;
    @FindBy(xpath = "//*[@id=\"Submit\"]")
    public WebElement next;


}
