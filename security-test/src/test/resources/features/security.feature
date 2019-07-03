Feature: Security
  This feature is to test all security steps

  Scenario: Validate sec scan
    Given I import context from open API specification "/v2/api-docs"
    And I remove alerts
      | url            |
      | http://.*/v2.* |
    And I import scan policy "javaclean" from file "javaclean.policy"
    When I run active scan
    And I generate security test HTML report with name "java-clean-security-report"
    Then the number of risks per category should not be greater than
      | low | medium | high | informational |
      | 0   | 0      | 0    | 0             |