Feature: Testing login Web Lokal pake Self-Healing
    Scenario Outline: User bisa klik tombol di web lokal

    Given user buka web dan akses halaman login.
    When user input username "test@clinic.com" dan password "1234554321"
    And user klik login.
    Then user masuk tampilan dashboard.