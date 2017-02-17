Feature: F to C links test 

  Scenario: Verify convertion from F to C via link
    Given user opens Crunchify web page
    When user clicks on f to c links
    Then output message showing f into c is displayed
    
  Scenario: Verify convertion from F to C via link with parameters
    Given user opens Crunchify web page
    When user clicks on f to c links with parameters
    Then output message showing f into c is displayed    