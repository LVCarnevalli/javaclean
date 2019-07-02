Feature: Security
  This feature is to test all security steps

  Scenario: Validate sec scan
    Given import context from open API specification "/v2/api-docs"
    And wait passive scan running
    And verify that the proxy has captured host information
    When recovery list of alerts
    And remove alerts
      | url            |
      | http://.*/v2.* |
    Given import scan policy "javaclean.policy"
    When run active scan
    And recovery list of alerts
    And generate ACTIVE security test HTML report
    Then the number of risks per category should not be greater than
      | low | medium | high | informational |
      | 0   | 0      | 0    | 0             |