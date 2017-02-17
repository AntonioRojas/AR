Feature: C to F links test 

  Scenario: Verify convertion from C to F via link
    Given user opens Crunchify web page
    When user clicks on c to f links
    Then output message showing c into f is displayed
    
  Scenario: Verify convertion from C to F via link with parameters
    Given user opens Crunchify web page
    When user clicks on c to f links with parameters
    Then output message showing c into f is displayed    