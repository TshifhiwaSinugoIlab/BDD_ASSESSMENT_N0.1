package Automation.pageObjects;

import Automation.webPageObjects.*;
import Automation.webUtilities.generateFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;

import static Automation.webUtilities.webActions.*;

public class webFunctions {

    generateFile generator;
    searchExistingBooking existingBooking;
    deleteBooking delBooking;

    public void Login(WebDriver driver, String Username, String Password) {
        LoginAdactin log = new LoginAdactin(driver);

        try {
            passData(log.txtUsernme, driver, Username);
            passData(log.txtPassword, driver, Password);
            clickObject(log.btnLogin, driver);

            WebElement next = log.next;
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(next));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(WebDriver driver, String Location, String Hotels, String RoomType, String NumberOfRooms, String CheckInDate, String CheckOutDate, String AdultsPerRoom, String ChildrenPerRoom) {
        searchHotel search = new searchHotel(driver);


        try {
            Thread.sleep(2000);
            selectObject(search.location, driver, "selectByVisibleText", Location);
            selectObject(search.hotels, driver, "selectByVisibleText", Hotels);
            selectObject(search.room_type, driver, "selectByVisibleText", RoomType);
            selectObject(search.room_no, driver, "selectByVisibleText", NumberOfRooms);

            passData(search.check_in_date, driver, CheckInDate);
            passData(search.check_out_date, driver, CheckOutDate);

            selectObject(search.adults, driver, "selectByVisibleText", AdultsPerRoom);
            selectObject(search.children, driver, "selectByVisibleText", ChildrenPerRoom);

            clickObject(search.submit, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Hotel(WebDriver driver) {
        selectHotel selHotel = new selectHotel(driver);

        try {

            clickObject(selHotel.sel_hotel, driver);
            clickObject(selHotel.contin, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Book_hotel(WebDriver driver, String FirstName, String LastName, String BillingAddress, String CreditCardNumber, String CreditCardType, String ExpiryDateMonth, String ExpiryDateYear, String CVVNumber ) throws SQLException {
        bookHotel bookHotel = new bookHotel(driver);
        generator = new generateFile();

        try {
            passData(bookHotel.firstname, driver, FirstName);

            passData(bookHotel.surname, driver, LastName);

            passData(bookHotel.billing, driver, BillingAddress);

            passData(bookHotel.account, driver, CreditCardNumber);

            selectObject(bookHotel.account_type, driver, "selectByVisibleText", CreditCardType);

            selectObject(bookHotel.month, driver, "selectByVisibleText", ExpiryDateMonth);

            selectObject(bookHotel.year, driver, "selectByVisibleText", ExpiryDateYear);

            passData(bookHotel.cvv, driver, CVVNumber);

            clickObject(bookHotel.book, driver);

            Thread.sleep(2000);
            WebElement order_number = bookHotel.orderNo;

            String orderNum = order_number.getAttribute("value");

            generator.writeToFile(orderNum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public  void logout (WebDriver driver) {
        logout logout = new logout(driver);


        try {
            Thread.sleep(1000);
            clickObject(logout.logout, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //navigate to the itinerary page
    public void navigateToBookedItinerary(WebDriver driver){
        existingBooking = new searchExistingBooking(driver);
        try{
            clickObject(existingBooking.searchItineraryLink,driver);
        }catch(Exception e){
            System.out.println("Could not navigate to booked itinerary successfully" + e.getMessage());
        }
    }

    // Search for existing booking
    public void searchExistingBooking(WebDriver driver){
        existingBooking = new searchExistingBooking(driver);
        generator = new generateFile();

        String theOderNumber = generator.readFromFile();
        try{
            passData(existingBooking.orderSearchBox,driver,theOderNumber);
            clickObject(existingBooking.goButton,driver);

        }catch (Exception e){
            System.out.println("Could not search successfully" + e.getMessage());
        }
    }

    // Confirm existing booking
    public void confirmExistingBooking(){
        if (existingBooking.tableFirstRow.isDisplayed()){
            System.out.println("Existing booking matches the provided orderNumber searched successfully");
        }else {
            System.out.println("Search unsuccessful");
        }
    }

    public void deleteExistingBooking(WebDriver driver){
        delBooking = new deleteBooking(driver);
        try {
            clickObject(delBooking.selectOrderButton,driver);
            clickObject(delBooking.cancelSelectedButton,driver);
            Thread.sleep(10000);
            driver.switchTo().alert().accept();


        }catch (Exception e){
            System.out.println("Could not delete Booking" + e.getMessage());
        }

    }

    // Confirm Delete
    public void confirmDelete(WebDriver webDriver){
        try {
            if (delBooking.search_result_error.isDisplayed()){
                System.out.println("Booking delete successfully");
            }else{
                System.out.println("Booking not deleted");
            }

        }catch (Exception e){
            System.out.println("Could not delete Booking" + e.getMessage());
        }
    }
}
