package com.jogo.automation.Hooks;

import ConfigFiles.Factory.ConfigFactory;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static DataReader.EnvConfig.*;
import static Driver.Driver.*;
import static Utilities.frameworkUtilities.sendMail;

public class CustomHooks implements EventListener {
    public static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static ProcessBuilder builder = new ProcessBuilder();
    public CustomHooks() {
    }
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
        publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::ScenarioFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }
    private void runStarted(TestRunStarted event) {
        if(ConfigFactory.getConfig().RunMode().toString().toUpperCase().equals("local".toUpperCase())){
            if (ConfigFactory.getConfig().PlatformType().toString().toUpperCase().equals("mobile".toUpperCase()) && ConfigFactory.getConfig().MobilePlatformType().toString().toUpperCase().equals("android".toUpperCase())){
                runCommand("cd ~/Library/Android/sdk/emulator;./emulator -avd "+ConfigFactory.getConfig().DeviceName().toString());
            }
        }
        loadTestDataFile();
        //System.out.println(getTestDataAsString("Gulraiz","Address","Home"));
    }
    public static void runCommand(String command) {
        try {

            if(isWindows) {
                builder.command("cmd.exe", "/c", command);
            }else {
                builder.command("sh", "-c", command);
            }
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            line = r.readLine();
            System.out.println(line);
        }
        catch (Exception ex){
            System.out.println("Exception in AVD");
            System.out.println(ex);
        }
    }
    private void runFinished(TestRunFinished event){
        if(ConfigFactory.getConfig().RunMode().toString().toUpperCase().equals("local".toUpperCase())){
            if (ConfigFactory.getConfig().PlatformType().toString().toUpperCase().equals("mobile".toUpperCase()) && ConfigFactory.getConfig().MobilePlatformType().toString().toUpperCase().equals("android".toUpperCase())){
                runCommand("adb devices | grep emulator | cut -f1 | while read line; do adb -s $line emu kill;done");
            }
        }
        //sendMail();
//        String reportFilepath = System.getProperty("user.dir")+"/src/test/Reports/";
//        System.out.println(reportFilepath);
       // ZipUtil.pack(new File(reportFilepath), new File(reportFilepath+"/AllReports.zip"));
//        sendData();
    }
    private void featureRead(TestSourceRead event) {
        System.out.println("Feature Started");
    }
    private void ScenarioStarted(TestCaseStarted event) {
        initializeDriver();
    }
    private void ScenarioFinished(TestCaseFinished event)
    {

    }
    private void stepStarted(TestStepStarted event) {
//        System.out.println("Step Started");
    }
    private void stepFinished(TestStepFinished event) {

//        System.out.println("Step Finished");
    }
}