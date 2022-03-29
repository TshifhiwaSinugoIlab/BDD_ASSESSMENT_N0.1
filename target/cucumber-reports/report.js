$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BookHotel.feature");
formatter.feature({
  "line": 3,
  "name": "Book hotel Feature",
  "description": "",
  "id": "book-hotel-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@run1"
    }
  ]
});
formatter.before({
  "duration": 10688805400,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "User must login",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "user is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user enters username and password and clicks login",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.userIsOnLoginPage()"
});
formatter.result({
  "duration": 81044400,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.userEntersUsernameAndPasswordAndClicksLogin()"
});
formatter.result({
  "duration": 4708560000,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Successful booking of a hotel",
  "description": "",
  "id": "book-hotel-feature;successful-booking-of-a-hotel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "user fill in fields in the search page and clicks search",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user select hotel and clicks continue",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user fill in fields in book hotel and clicks book now",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.userFillInFieldsInTheSearchPageAndClicksSearch()"
});
formatter.result({
  "duration": 3572007800,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.userSelectHotelAndClicksContinue()"
});
formatter.result({
  "duration": 1039525700,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.userFillInFieldsInBookHotelAndClicksBookNow()"
});
formatter.result({
  "duration": 6158212500,
  "status": "passed"
});
formatter.after({
  "duration": 5104717200,
  "status": "passed"
});
});