package com.emr.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/LoginTest.feature",
        }, glue = {
                "com.emr.definition",
                "com.emr.hook",
        }, plugin = { "pretty", "html:test-output", "json:target/cucumber/cucumber.json",
                "html:target/cucumber-html-report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunnerTest extends AbstractTestNGCucumberTests {

}
