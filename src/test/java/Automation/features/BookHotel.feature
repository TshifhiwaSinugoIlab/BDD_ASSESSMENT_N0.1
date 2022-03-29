@run1

Feature: Book hotel Feature

  Background: User must login

    Given user is on login page
    When user enters username and password and clicks login



  Scenario: Successful booking of a hotel

    And user fill in fields in the search page and clicks search
    And user select hotel and clicks continue
    And user fill in fields in book hotel and clicks book now

    @ignore
  Scenario: Delete an existing booking

    And user clicks on Booked Itinerary
    And user fill the search order id field and clicks on search and confirm cancellation
    Then booking is successfully cancelled


