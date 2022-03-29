package Automation.stepDefinition;

import Automation.data.data;
import Automation.pageObjects.webFunctions;
import Automation.webUtilities.webUtilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.AfterTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyStepdefs {
    webUtilities web = new webUtilities();
    webFunctions functions = new webFunctions();
    data connect = new data();
    ResultSet loginCredentials;
    ResultSet bookHotelData;

    @Before
    public void setUp() throws InterruptedException {

        web.setWebDriver(web.initializeWebDriver("CHROME"));
        web.navigate("http://adactinhotelapp.com/");

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String user = "root";
        String pass = "password";


        String credQuery = "select * from credentials";
        loginCredentials = connect.ConnectAndQuerySQL(url, user, pass, credQuery);

        String bookingQuery = "select * from booking";
        bookHotelData = connect.ConnectAndQuerySQL(url, user, pass, bookingQuery);
    }


    @Given("^user is on login page$")
    public void userIsOnLoginPage() { System.out.println("Hello, you are on login page.");}

    @When("^user enters username and password and clicks login$")
    public void userEntersUsernameAndPasswordAndClicksLogin() throws SQLException {

        while (loginCredentials.next()) {

            String username = loginCredentials.getString("username");
            String password = loginCredentials.getString("password");
            functions.Login(web.getWebDriver(), username, password);
        }
    }

    @And("^user fill in fields in the search page and clicks search$")
    public void userFillInFieldsInTheSearchPageAndClicksSearch() throws SQLException {

        try{
        while (bookHotelData.next()) {

            String location = bookHotelData.getString("Location");
            String hotels = bookHotelData.getString("Hotels");
            String roomType = bookHotelData.getString("RoomType");
            String numberOfRooms = bookHotelData.getString("NumberOfRooms");
            String checkInDate = bookHotelData.getString("CheckInDate");
            String checkOutDate = bookHotelData.getString("CheckOutDate");
            String adultsPerRoom = bookHotelData.getString("AdultsPerRoom");
            String childrenPerRoom = bookHotelData.getString("ChildrenPerRoom");

            functions.search(web.getWebDriver(), location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);

        }

            bookHotelData.beforeFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @And("^user select hotel and clicks continue$")
    public void userSelectHotelAndClicksContinue() {

        functions.select_Hotel(web.getWebDriver());

    }

    @And("^user fill in fields in book hotel and clicks book now$")
    public void userFillInFieldsInBookHotelAndClicksBookNow() throws SQLException {

        while (bookHotelData.next()) {

            String firstName = bookHotelData.getString("FirstName");
            String lastName = bookHotelData.getString("LastName");
            String billingAddress = bookHotelData.getString("BillingAddress");
            String creditCardNumber = bookHotelData.getString("CreditCardNumber");
            String creditCardType = bookHotelData.getString("CreditCardType");
            String expiryDateMonth = bookHotelData.getString("ExpiryDateMonth");
            String expiryDateYear = bookHotelData.getString("ExpiryDateYear");
            String cvvNumber = bookHotelData.getString("CVVNumber");

            functions.Book_hotel(web.getWebDriver(), firstName, lastName, billingAddress, creditCardNumber, creditCardType, expiryDateMonth, expiryDateYear, cvvNumber);
        }
    }

    @And("^user clicks on Booked Itinerary$")
    public void userClicksOnBookedItinerary() {

        functions.navigateToBookedItinerary(web.getWebDriver());
    }

    @And("^user fill the search order id field and clicks on search and confirm cancellation$")
    public void userFillTheSearchOrderIdFieldAndClicksOnSearchAndConfirmCancellation() {
        functions.searchExistingBooking(web.getWebDriver());

    }

    @And("^a user clicks on cancel$")
    public void aUserClicksOnCancel() {

        functions.deleteExistingBooking(web.getWebDriver());

    }

    @Then("^booking is successfully cancelled$")
    public void bookingIsSuccessfullyCancelled() {

        functions.confirmDelete(web.getWebDriver());
    }

    @After
    public void cleanUp() throws Exception {

        functions.logout(web.getWebDriver());
        loginCredentials.close();
        bookHotelData.close();

        Thread.sleep(3000);
        web.getWebDriver().quit();
    }
}
