# To perform vehicle lookup using registration number
@test
Feature: Vehicle Lookup using registration number
  This feature will test vehicle lookup for multiple vechile registration number combination

  @Scenario1
  Scenario Outline: User searches for vehicle details with vehicle registration number
    Given user launches the dealer portal
    When user performs Vehicle lookup for "<VehicleRegNum>"
    Then results for "<VehicleRegNum>" should be displayed

    Examples: 
      | VehicleRegNum |
      | OV12UYY       |
      | OV12UZZ       |
      |           123 |
      |               |
