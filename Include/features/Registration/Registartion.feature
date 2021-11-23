@Registration
Feature: Registration

  @Invalid_Registartion
  Scenario Outline: User unable to register with invalid infomation
    Given User navigate to Registration Page
    When User input <nama_usaha>, <nama_pengguna>, <lokasi_usaha> and <nomor_ponsel>
    And Click Daftar Button
    Then Verify that registration is invalid

    Examples: 
      | nama_usaha | nama_pengguna | lokasi_usaha | nomor_ponsel   |
      | Toko Halo  | hallo sya     | Klaten       |   085879214397 |
      | Toko Halo  | hallo sya     | Klaten       | +6285879214397 |
