package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static Driver.DriverManager.getDriver;


public class CommonFunctions {
    public static Boolean waitUntilElementDisplayed(WebElement element,int timeOut) {
        Boolean flag = false;
        try {
            Wait<AppiumDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
            boolean aboutMe = wait.until(new Function<AppiumDriver, Boolean>() {

                public Boolean apply(AppiumDriver driver) {
                    System.out.println("Loading Element of "+element);
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    if(element!=null && element.isDisplayed()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            });
            if (aboutMe == false) {
                flag = false;
            } else {
                flag = true;
            }
        }
        catch(Exception e) {
            flag=false;

        }
        return flag;
    }
    public static boolean elementNotPresent(WebElement element){
        if(element == null){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean waitForInvisibilityOfElement(WebElement element){
        Boolean flag = false;
        try {
            Wait<AppiumDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
            boolean aboutMe = wait.until(new Function<AppiumDriver, Boolean>() {

                public Boolean apply(AppiumDriver driver) {
                    System.out.println("Loading Element of "+element);
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    if(!element.isDisplayed()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            });
            if (aboutMe == false) {
                flag = false;
            } else {
                flag = true;
            }
        }
        catch(Exception e) {
            flag=false;

        }
        return flag;
    }
    public static Boolean waitUntilElementClickable(WebElement element) {
        Boolean flag = false;
        try {
            Wait<AppiumDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
            boolean aboutMe = wait.until(new Function<AppiumDriver, Boolean>() {

                public Boolean apply(AppiumDriver driver) {
                    System.out.println("Loading Element of "+element);
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    if(element!=null && element.isDisplayed() && element.isEnabled()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            });
            if (aboutMe == false) {
                flag = false;
            } else {
                flag = true;
            }
        }
        catch(Exception e) {
            flag=false;

        }
        return flag;
    }
    public static String randomEmail() {
        String n = UUID.randomUUID().toString().substring(30);
        String s = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()).toString().replaceAll(":", "").
                replaceAll(" ", "").replaceAll("-", "").replace(".", "").substring(2);
        String email = "test" + n + s + "@yopmail.com";
        return email;
    }

    public static String randomPassword() {
        String password = "P@sswOrd" + getTime();
        return password;
    }
    public static String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    public static int randInt() {
        Random rand = new Random();
        int randomNum = rand.nextInt((999999 - 1) + 1) + 1;
        return randomNum;
    }
    public static Boolean click(WebElement element){
        hideKeyboard_Android();
        element.click();
        return true;
    }
    public static Boolean enterDataInInputField(WebElement element,String data){
        element.sendKeys(data);
        return true;
    }
    public static Boolean clickAndEnterDataInInputField(WebElement element,String data){
        waitUntilElementDisplayed(element,2);
        click(element);
        element.sendKeys(data);
        hideKeyboard_Android();
        return true;
    }
    public static void selectDateDropDown(WebElement element,String dob) {
        click(element);
        click(element);
        String year = dob.substring(dob.lastIndexOf(" ")+1);
        getDriver().findElement(By.id("android:id/date_picker_header_year")).click();
        getDriver().findElement(By.xpath("//*[@text='"+year+"']")).click();
        getDriver().findElement(By.xpath("//*[contains(@text,'22')]")).click();
        getDriver().findElement(By.xpath("//*[@text='OK']")).click();
    }
    public static void selectDateDropDownFail(WebElement element) {
        click(element);
        getDriver().findElement(By.id("android:id/date_picker_header_year")).click();
        getDriver().findElement(By.xpath("//*[@text='2008']")).click();
        getDriver().findElement(By.xpath("//*[contains(@text,'22')]")).click();
        getDriver().findElement(By.xpath("//*[@text='OK']")).click();
    }
    public static void hideKeyboard_Android() {
        //Appium Driver
        while (((AndroidDriver) getDriver()).isKeyboardShown()) {
            try {((AndroidDriver) getDriver()).hideKeyboard();} catch (Exception e) {}
        }
    }
    public static void scrollDownUntilTextDisplayed(String textToSearch) {
        // By Element
        getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                        ".scrollIntoView(new UiSelector().text(\""+textToSearch+"\"))"));
    }
    public static void scrollDownUntilElementDisplayed(String textToSearch) {
        // By Element
        getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\"))"));
    }
    public static boolean scrollToElement(String direction,WebElement webElement){
        boolean flag = false;
        try {
            for(int i=0;i<20;i++) {
                scrollByDirection(direction);
                flag = waitUntilElementDisplayed(webElement, 2);
                if(flag == true){
                    return true;
                }
            }
            System.out.println("Element not found in scrolling");
            return false;
        }
        catch (Exception exception){
            System.out.println("Element not found in scrolling");
            System.out.println(exception);
            return false;
        }
    }
    public static void scrollByDirection(String direction) {
        TouchAction  action =new TouchAction(getDriver());
        Dimension size	=getDriver().manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height/2);
        int endYCoordinate= (int)(height*.1);
        if(direction.toLowerCase().equals("down")){
            endYCoordinate = endYCoordinate;
        }else if(direction.toLowerCase().equals("up")){
            endYCoordinate = endYCoordinate * -1;
        }

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }
    public static void scrollByElement(WebElement element,String direction) {
        TouchAction  action =new TouchAction(getDriver());
        Dimension size	= element.getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int middleOfY=height/2;
        int endXCoordinate=0;
        if(direction.equals("LEFT")){
            endXCoordinate=-middleOfX;
            action.press(PointOption.point(width+10, middleOfY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(-30, middleOfY)).release().perform();
        }else if(direction.equals("RIGHT")){
            endXCoordinate=width+10;
            action.press(PointOption.point(-30, middleOfY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(endXCoordinate, middleOfY)).release().perform();
        }
        else{
            int endYCoordinate= (int)(height*.1);
            int startYCoordinate= (int)(height*.4);
            if(direction.toLowerCase().equals("down")){
                endYCoordinate = endYCoordinate;
                action.press(PointOption.point(middleOfX, startYCoordinate))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
            }else if(direction.toLowerCase().equals("up")){
                endYCoordinate = endYCoordinate * -1;
                action.press(PointOption.point(middleOfX, startYCoordinate))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
            }
        }

    }

    public static String getCount(List<WebElement> element) {
        String emptyText = "";
        try {
            return String.valueOf(element.size());
        } catch (Throwable t) {
            t.printStackTrace();
            return emptyText;
        }
    }
    public static String getText(WebElement element) {
        String emptyText = "";
        try {
            return element.getText();
        } catch (Throwable t) {
            t.printStackTrace();
            return emptyText;
        }
    }
    public static String getAttributeValue(WebElement element,String attributeToGet) {
        String emptyText = "";
        try {
            return element.getAttribute(attributeToGet);
        } catch (Throwable t) {
            t.printStackTrace();
            return emptyText;
        }
    }

    public static String getCssValue(WebElement element,String cssValue) {
        String emptyText = "";
        try {
            return element.getCssValue(cssValue);
        } catch (Throwable t) {
            t.printStackTrace();
            return emptyText;
        }
    }

    public static Boolean assertString(String expectedString, String actualString){
        return expectedString.equals(actualString);
    }
    public static boolean stringArrayDuplicates(String[] arrayToCheck){
        for (int i = 0; i < arrayToCheck.length; i++)
        {
            for (int j = i + 1 ; j < arrayToCheck.length; j++)
            {
                if (arrayToCheck[i].equals(arrayToCheck[j]))
                {
                 return false;
                }
            }
        }
        return true;
    }
    public static boolean swipeElementAndroid(WebElement el, String dir) {
        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension size	= el.getSize();
        int width=size.width;
        int height=size.height;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case "DOWN": // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case "UP": // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case "LEFT": // from right to left
//                getDriver().executeScript("mobile: scroll", ImmutableMap.of("direction", "left"));
                int startX = rect.x + rect.width - edgeBorder;
                pointOptionStart = PointOption.point(startX / 2,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x/2 + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case "RIGHT": // from left to right
                int startRightX = rect.x + rect.width - edgeBorder;
                pointOptionStart = PointOption.point(startRightX/2,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
    public static boolean swipeElementAndroidHorizontal(WebElement el, String dir) {

        final int ANIMATION_TIME = 2000; // ms

        final int PRESS_TIME = 200; // ms

        PointOption pointOptionStart, pointOptionEnd;
        Dimension size	= el.getSize();
        int width=size.width;
        int height=size.height;
        int x = width/2;
        int y = height/2;

        switch (dir) {
            case "LEFT": // from left to right
                pointOptionStart = PointOption.point(x, y);
                pointOptionEnd = PointOption.point(0, y);
                break;
            case "RIGHT": // from right to left
                pointOptionStart = PointOption.point(x, y);
                pointOptionEnd = PointOption.point((int)(x*1.9), y);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction(getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
    public static boolean swipeElementAndroidHorizontalCounted(WebElement el, String dir,int countOfSwipe) {

        final int ANIMATION_TIME = 2000; // ms

        final int PRESS_TIME = 200; // ms

        PointOption pointOptionStart, pointOptionEnd;
        Dimension size	= el.getSize();
        int width=size.width;
        int height=size.height;
        int x = width/2;
        int y = height/2;

        switch (dir) {
            case "LEFT": // from left to right
                pointOptionStart = PointOption.point(x, y);
                pointOptionEnd = PointOption.point(0, y);
                break;
            case "RIGHT": // from right to left
                pointOptionStart = PointOption.point(x, y);
                pointOptionEnd = PointOption.point((int)(x*1.9), y);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        try {
            int counter = countOfSwipe;
            for(int i = 0; i < counter; i++) {
                new TouchAction(getDriver())
                        .press(pointOptionStart)
                        // a bit more reliable when we add small wait
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                        .moveTo(pointOptionEnd)
                        .release().perform();
                Thread.sleep(ANIMATION_TIME);
            }
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
    public static boolean swipeNewsElementAndroidHorizontal(WebElement el, String dir) {

        final int ANIMATION_TIME = 2000; // ms

        final int PRESS_TIME = 2000; // ms

        PointOption pointOptionStart, pointOptionEnd;
        Dimension size	= el.getSize();
        int width=size.width;
        int height=size.height;
        int x = width/2;
        int y = height/2;
        Rectangle rect = el.getRect();

        switch (dir) {
            case "LEFT": // from left to right
                pointOptionStart = PointOption.point(width+rect.x+20, rect.y+y);
                pointOptionEnd = PointOption.point(0, rect.y+y);
                break;
            case "RIGHT": // from right to left
                pointOptionStart = PointOption.point(x, rect.y+y);
                pointOptionEnd = PointOption.point((int)(x*1.9), rect.y+y);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction(getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
    public static boolean swipeTopViewedElementAndroid(WebElement el, String dir) {
        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;
        Dimension size	= el.getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX= (int) (width/2);
        int middleOfY=height/2;

        switch (dir) {
            case "LEFT": // from right to left
                pointOptionStart = PointOption.point( width+10, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(middleOfX,rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
    public static boolean swipeElementAndroidCounted(WebElement el, String dir,int countOfSwipe) {

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case "DOWN": // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case "UP": // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case "LEFT": // from right to left
                int startX = rect.x + rect.width - edgeBorder;
                pointOptionStart = PointOption.point(startX / 2,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case "RIGHT": // from left to right
                int startRightX = rect.x + rect.width - edgeBorder;
                pointOptionStart = PointOption.point(startRightX/2,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            int counter = countOfSwipe;
            for(int i = 0; i < counter; i++) {
                new TouchAction(getDriver())
                        .press(pointOptionStart)
                        // a bit more reliable when we add small wait
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                        .moveTo(pointOptionEnd)
                        .release().perform();
                Thread.sleep(ANIMATION_TIME);
            }
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }

    }
}
