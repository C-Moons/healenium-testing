package com.emr.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtil {
    private static SelfHealingDriver driver;
    private static WebDriver delegate;

    public static SelfHealingDriver getInstance() {
        if (driver == null) {
            System.out.println("Initializing Driver with Healenium...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            delegate = new ChromeDriver(options);
            System.out.println("Delegate driver created: " + delegate.getClass().getName());

            driver = SelfHealingDriver.create(delegate);
            System.out.println("SelfHealingDriver created and proxying delegate.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDelegate() {
        return delegate;
    }

    public static void destroy() {
        if (driver != null) {
            driver.quit();
            driver = null;
            delegate = null;
        }
    }
}