package com.jogo.automation.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.jogo.automation"},
        plugin = {"json:src/test/Reports/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","com.jogo.automation.Hooks.CustomHooks"},
        features = {"src/test/resources/Features"}
)
public class JunitRunnerTest {

}