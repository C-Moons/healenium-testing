package com.emr.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.id("user_email");
    private By password = By.id("password");
    private By loginButton = By.id("login_button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String data) {
        waitingElementReady(username).sendKeys(data);
    }

    public void inputPassword(String data) {
        waitingElementReady(password).sendKeys(data);
    }

    public void clickButtonLogin() {
        driver.findElement(loginButton).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickButtonLogin();
    }
}
