package com.emr.definition;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.emr.page.DashboardPage;
import com.emr.page.LoginPage;
import com.emr.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given ("user buka web dan akses halaman login.")
    public void openBrowserAndLogin(){
        loginPage = new LoginPage(DriverUtil.getInstance());
        dashboardPage = new DashboardPage(DriverUtil.getInstance());

        DriverUtil.getInstance().get("http://localhost:8074/clinic/");
    }

    @When("user input username {string} dan password {string}")
    public void loginWeb(String user, String pass){
        loginPage.inputUsername(user);
        loginPage.inputPassword(pass);
    }

    @And("user klik login.")
    public void clickButtonSignIn(){
        loginPage.clickButtonLogin();
    }

    @Then("user masuk tampilan dashboard.")
    public void accessDashboard(){
        String expectedURL = "http://localhost:8074/clinic/administrator.php";
        WebDriverWait wait = new WebDriverWait(DriverUtil.getInstance(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String currentUrl = loginPage.getCurrentURL();
        Assert.assertEquals(currentUrl, expectedURL);
    }
}
