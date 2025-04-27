Feature: Login functionality


  Scenario: Successful login
    Given User navigates to "https://www.goindigo.in/"
#    When User selects "roundTrip" as a "Type"
#    Then User selects "Mumbai" as a "from Destination"
    Then User clicks on login
  Then User opens a new Tab and navigates to "https://www.facebook.com/"
#    Then User selects "Dehradun" as a "To Destination"
