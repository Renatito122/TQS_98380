Feature: Statistics search
  Scenario: Fetch statistics
    Given the user opens Firefox and navigates to the application
    When the user searches for statistics for the country ZAF
    Then the table should show '2226' new cases
    And the table should show '117' new deaths