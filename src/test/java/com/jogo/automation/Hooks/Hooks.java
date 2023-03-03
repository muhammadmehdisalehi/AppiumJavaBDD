package com.jogo.automation.Hooks;

import ConfigFiles.Factory.ConfigFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static ConfigFiles.Factory.ConfigFactory.getConfig;
import static Driver.Driver.quitDriver;
import static Driver.DriverManager.getDriver;

public class Hooks {


    @BeforeAll
    public static void before_all(){

    }

/*    @AfterAll
    public static void after_all(){
//        System.out.println("Cucumber Hooks After All");
    }*/
    @Before
    public static void beforeScenario() {
//        System.out.println("Cucumber Hooks Before Scenario");
    }
    @After
    public static void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        else{

        }
        if(getConfig().PlatformType().toString() != "api"){
        quitDriver();
        }
    }
   /* @BeforeStep
    public static void beforeStep(){
//        System.out.println("Cucumber Hooks Before Step");
    }
    @AfterStep
    public static void afterStep(){
//        System.out.println("Cucumber Hooks After Step");
    }*/

}
