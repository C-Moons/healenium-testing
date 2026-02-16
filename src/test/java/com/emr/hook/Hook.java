package com.emr.hook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.emr.utils.DriverUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hook {
    @BeforeAll
    public static void beforeHook() {
        DriverUtil.getInstance();
    }

    @AfterAll
    public static void afterHook() {
        DriverUtil.destroy();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            org.openqa.selenium.WebDriver delegate = DriverUtil.getDelegate();
            if (delegate instanceof org.openqa.selenium.TakesScreenshot) {
                final byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) delegate)
                        .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot: " + scenario.getName());
            }
        } catch (Exception e) {
            System.err.println("Gagal mengambil screenshot: " + e.getMessage());
        }
    }
}
