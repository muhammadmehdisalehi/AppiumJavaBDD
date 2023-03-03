package com.jogo.automation.Pages.ActionClasses;

import Utilities.CommonFunctions;
import com.jogo.automation.Pages.PageRepos.HomePageRepo;
import org.apache.poi.ss.formula.atp.Switch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;

import static DataReader.JsonReader.*;
import static Utilities.CommonFunctions.*;

public class HomePageActions extends HomePageRepo {
    WebDriver driver = null;
    public HomePageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnNewsSection(){
        click(news_Tile);
    }
    public void clickOnSearchButton(){
        click(search_Button);
    }

    public static void verifyUserIsOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_Text,10));
    }
    public static void verifyElementIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(home_Button,10));
    }
    public static void verifyQuizCountElementIsNotPresentOnScreen(){
        Assert.assertTrue("Quiz Count Element Found on Summary Screen",elementNotPresent(getQuizCountElement(" / ")));
    }
    public static void verifyPollCountElementIsNotPresentOnScreen(){
        Assert.assertTrue("Poll Count Element Found on Summary Screen",elementNotPresent(getQuizCountElement(" / ")));
    }
    public static void verifyMenuHamburgerIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(home_Button_Text,10));
    }
    public static void verifyTopBannerImageIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topBanner_Image,10));
    }
    public static void verifyTopBannerSubcategoryIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topBanner_SubCategory,10));
    }
    public static void verifyTopBannerDescriptionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topBanner_Description,10));
    }
    public static void verifyNewsSectionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_Section,10));
    }
    public static void verifyArticleSectionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(article_Section,10));
    }
    public static void verifyTopViewedSectionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topViewed_Section,10));
    }
    public static void verifyArticleSeeAllIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(article_See_All,10));
    }
    public static void verifyArticleTileIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(article_Tile,10));
    }
    public static void verifyTopViewedTileIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topViewed_Tile,10));
    }
    public static void verifyTopViewedTitleIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topViewed_Title,10));
    }
    public static void verifyDiscoverBadgeIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(discover_Badge,10));
    }
    public static void verifyRecentlyViewBadgeIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(recentlyViewed_Badge,10));
    }
    public static void verifyQuizChoiceIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(quiz_Choice,10));
    }
    public static void verifyPollChoiceIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(poll_Choice,10));
    }
    public static void verifyTopViewedCreaterIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topViewed_Creater,10));
    }
    public static void verifyNewsTitleIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_Title,10));
    }
    public static void verifyNewsMainTitleIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_main_Title,10));
    }
    public static void verifyNewsMainDescriptionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_main_Description,10));
    }
    public static void verifyOtherNewsIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(other_news_Link,10));
    }
    public static void verifyBackButtonIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(back_Button,10));
    }
    public static void verifyNewsDescriptionIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_Description,10));
    }
    public static void verifyNewsCreaterIsPresentOnScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(news_Creater,10));
    }
    public static void verifyTopBannerIsPresentOnTopOfScreen(){
        Assert.assertTrue("Element Not Found",waitUntilElementDisplayed(topBanner_Alignment,10));
    }
    public static void verifyTopBannerCount(String countOfElements){
        Assert.assertEquals(getCount(topBanner_Count),countOfElements);
    }
    public static void verifyArticlesCount(String countOfElements){
        Assert.assertEquals(getCount(article_Title_Count),countOfElements);
    }
    public static void verifyTopBannerCountIsGreater(String countOfElements){
        Boolean flag = false;
        String actualCount = getCount(topBanner_Count);
        if(Integer.parseInt(actualCount) > Integer.parseInt(countOfElements)){
            flag = true;
        }

        Assert.assertTrue("Count of Top banner is less",flag);
    }
    public static void verifyTopBannerCountIsLesser(String countOfElements){
        Boolean flag = false;
        String actualCount = getCount(topBanner_Count);
        if(Integer.parseInt(actualCount) <= Integer.parseInt(countOfElements)){
            flag = true;
        }

        Assert.assertTrue("Count of Top banner is less",flag);
    }
    public static void verifySwipeActionTopBanner(String direction){
        boolean flag = false;
        String firstID = getAttributeValue(topBanner_Image_1,"resourceId");
        flag = swipeElementAndroidHorizontal(topBanner_Image_1,direction.toUpperCase());
        String secondID = getAttributeValue(topBanner_Image_1,"resourceId");
        Assert.assertNotEquals(firstID,secondID);
    }
    public static void verifySwipeActionTopViewed(String direction){
        String firstID = getAttributeValue(topViewed_Tile,"resourceId");
        swipeNewsElementAndroidHorizontal(topViewed_Tile,direction.toUpperCase());
        String secondID = getAttributeValue(topViewed_Tile,"resourceId");
        Assert.assertNotEquals(firstID,secondID);
    }
    public static void verifySwipeActionNews(String direction){
        boolean flag = false;
        String firstID = getAttributeValue(news_Tile,"resourceId");
        flag = swipeNewsElementAndroidHorizontal(news_Tile,direction.toUpperCase());
        String secondID = getAttributeValue(news_Tile,"resourceId");
        Assert.assertNotEquals(firstID,secondID);
    }
    public static void verifySwipeActionNewsCount(String direction,String countOfNews){
        boolean flag = false;
        int count = Integer.parseInt(countOfNews);
        String[] idArray = new String[count];
        for (int i = 0; i < count ;i++){
            idArray[i] = getAttributeValue(news_Tile,"resourceId");
            swipeNewsElementAndroidHorizontal(news_Tile,direction.toUpperCase());
        }
        Assert.assertEquals(true,stringArrayDuplicates(idArray));
    }
    public static void verifySwipeActionTopViewedCount(String direction,String countOfTopViewed){
        boolean flag = false;
        int count = Integer.parseInt(countOfTopViewed);
        String[] idArray = new String[count];
        for (int i = 0; i < count ;i++){
            if(i==count-1){
                idArray[i] = getAttributeValue(topViewed_Tile_End,"resourceId");
            }
            else{
                idArray[i] = getAttributeValue(topViewed_Tile,"resourceId");
            }
            swipeNewsElementAndroidHorizontal(topViewed_Tile,direction.toUpperCase());
        }
        Assert.assertEquals(true,stringArrayDuplicates(idArray));
    }
    public static void verifySwipeActionTopBannerCount(String direction,String fileName){
        boolean flag = false;
        int numberOfCarousal =  getSizeofRecords(fileName,"data");
        String firstID = getAttributeValue(topBanner_Image_1,"resourceId");
        flag = swipeElementAndroidHorizontalCounted(topBanner_Image_1,direction.toUpperCase(),numberOfCarousal);
        String secondID = getAttributeValue(topBanner_Image_1,"resourceId");
        Assert.assertEquals(firstID,secondID);
    }
    public static void verifyTopBannerAccordingToFile(String fileName){
        boolean flag = false;
        String idOfBanner = "";
        String titleOfBanner = "";
        String typeOfBanner = "";
        String bannerTypeOfBanner = "";
        int countOfTopBannersInFile = getSizeofRecords(fileName,"data");
        int countOfElementsOnScreen = Integer.parseInt(getCount(topBanner_Count));
        Assert.assertEquals(countOfTopBannersInFile,countOfElementsOnScreen);
        JSONArray arrayForData = getJsonArray("bannersData","data","records");
        for(int i = 0; i < countOfTopBannersInFile; i++){
            JSONObject tempObj = (JSONObject) arrayForData.get(i);
            bannerTypeOfBanner = tempObj.get("model_name").toString();
            JSONObject contentObj = (JSONObject) tempObj.get("content_info");
            idOfBanner = contentObj.get("id").toString();
            titleOfBanner = contentObj.get("title").toString();
            contentObj = (JSONObject) contentObj.get("child_category");
            typeOfBanner = contentObj.get("name").toString();
            Assert.assertEquals(true,waitUntilElementDisplayed(getTopBannerTitleElement(titleOfBanner),5));
            Assert.assertEquals(true,waitUntilElementDisplayed(getTopBannerIdElement(idOfBanner),5));
            Assert.assertEquals(true,waitUntilElementDisplayed(getTopBannerTypeElement(typeOfBanner),5));
            click(getTopBannerTitleElement(titleOfBanner));
            if(bannerTypeOfBanner.toLowerCase().equals("Article".toLowerCase())){
                Assert.assertEquals(true,waitUntilElementDisplayed(back_Button,5));
                Assert.assertEquals(true,waitUntilElementDisplayed(share_Button,5));
                Assert.assertEquals(typeOfBanner.toLowerCase(),getText(main_Label).toLowerCase());
                Assert.assertEquals(titleOfBanner.toLowerCase(),getText(main_Title).toLowerCase());
                Assert.assertEquals(false,waitForInvisibilityOfElement(home_Button));
                click(back_Button);
            }
            else if(bannerTypeOfBanner.toLowerCase().equals("Media".toLowerCase())){
                Assert.assertEquals(true,waitUntilElementDisplayed(back_Button,5));
                Assert.assertEquals(true,waitUntilElementDisplayed(share_Button,5));
                Assert.assertEquals(true,waitUntilElementDisplayed(play_Button,5));
                Assert.assertEquals(titleOfBanner.toLowerCase(),getText(main_Title).toLowerCase());
                Assert.assertEquals(false,waitForInvisibilityOfElement(home_Button));
                click(back_Button);
            }
            else if(bannerTypeOfBanner.toLowerCase().equals("News".toLowerCase())){
                Assert.assertEquals(true,waitUntilElementDisplayed(back_Button,5));
                Assert.assertEquals(true,waitUntilElementDisplayed(other_news_Link,5));
                Assert.assertEquals(false,waitForInvisibilityOfElement(home_Button));
                //Assert.assertEquals(titleOfBanner.toLowerCase(),getText(news_main_Title).toLowerCase());
                click(back_Button);
            }
            else {

            }
            swipeElementAndroidHorizontal(topBanner_Image_1,"LEFT");
        }
    }
    public static void verifyNewsAccordingToFile(String fileName){
        boolean flag = false;
        String idOfNews = "";
        String titleOfNews = "";
        String newsDescription = "";
        String newsCreater = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        for(int i = 0; i < 5; i++){
            JSONObject tempObj = (JSONObject) arrayForData.get(i);
            idOfNews = tempObj.get("id").toString();
            JSONArray tempArray = (JSONArray) tempObj.get("news_slides");
            JSONObject contentObj = (JSONObject) tempArray.get(0);
            titleOfNews = contentObj.get("title").toString();
            newsDescription = contentObj.get("description").toString();
            newsCreater = contentObj.get("name").toString();
            if(newsCreater.equals("")){

            }
            else {
                Assert.assertEquals(true, waitUntilElementDisplayed(getNewsTitleElement(titleOfNews), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getNewsIdElement(idOfNews), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getNewsDescriptionElement(newsDescription), 5));
                //Assert.assertEquals(true, waitUntilElementDisplayed(getNewsCreaterElement(newsCreater), 5));
                click(getNewsTitleElement(titleOfNews));

                Assert.assertEquals(true, waitUntilElementDisplayed(back_Button, 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(other_news_Link, 5));
                Assert.assertEquals(titleOfNews.toLowerCase(),getText(news_main_Title).toLowerCase());
                Assert.assertEquals(newsDescription.toLowerCase(),getText(news_main_Description).toLowerCase());
                Assert.assertEquals(false, waitForInvisibilityOfElement(home_Button));
                click(back_Button);
            }
            swipeNewsElementAndroidHorizontal(getNewsIdElement(idOfNews),"LEFT");
        }
    }
    public static void verify6thNewsAccordingToFile(String fileName){
        boolean flag = false;
        String idOfNews = "";
        String titleOfNews = "";
        String newsDescription = "";
        String newsCreater = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        JSONObject tempObj = (JSONObject) arrayForData.get(5);
        idOfNews = tempObj.get("id").toString();
        JSONArray tempArray = (JSONArray) tempObj.get("news_slides");
        JSONObject contentObj = (JSONObject) tempArray.get(0);
        titleOfNews = contentObj.get("title").toString();
        newsDescription = contentObj.get("description").toString();
        newsCreater = contentObj.get("name").toString();
        if(newsCreater.equals("")){

        }
        else {
            click(getNewsIdElement(idOfNews));
            Assert.assertEquals(true, waitUntilElementDisplayed(back_Button, 5));
            Assert.assertEquals(true, waitUntilElementDisplayed(other_news_Link, 5));
            Assert.assertEquals(titleOfNews.toLowerCase(),getText(news_main_Title).toLowerCase());
            Assert.assertEquals(newsDescription.toLowerCase(),getText(news_main_Description).toLowerCase());
            Assert.assertEquals(false, waitForInvisibilityOfElement(home_Button));
        }
    }
    public static void verifyQuizAccordingToFile(String fileName){
        boolean flag = false;
        String idOfQuiz = "";
        String questionOfQuiz = "";
        String answerID = "";
        String answerText = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        for(int i = 0; i < arrayForData.size(); i++){
            JSONObject tempObj = (JSONObject) arrayForData.get(i);
            if(tempObj.get("question_type").toString().toUpperCase().equals("QUIZ")){
                idOfQuiz = tempObj.get("id").toString();
                questionOfQuiz = tempObj.get("question").toString();
                Assert.assertEquals(true, waitUntilElementDisplayed(getQuizTileElement(idOfQuiz), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getQuizImageElement(idOfQuiz), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getQuizQuestionElement(idOfQuiz), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getQuizQuestionTextElement(questionOfQuiz), 5));
                JSONArray tempArray = (JSONArray) tempObj.get("answers");
                for(int j = 0; j<tempArray.size();j++){
                    JSONObject contentObj = (JSONObject) tempArray.get(j);
                    answerID = contentObj.get("id").toString();
                    answerText = contentObj.get("answer").toString().toUpperCase();
                    Assert.assertEquals(true, waitUntilElementDisplayed(getQuizAnswerElement(answerID), 5));
                    Assert.assertEquals(true, waitUntilElementDisplayed(getQuizAnswerTextElement(answerText), 5));
                }
                break;
            }
        }
    }
    public static void answerOneQuizAccordingToFile(String fileName){
        boolean flag = false;
        int numberOfQuiz = getSizeofObject(fileName,"data","total_quizzes");
        String answerID = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfQuiz > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals("QUIZ")) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    waitUntilElementDisplayed(getQuizAnswerElement(answerID), 5);
                    click(getQuizAnswerElement(answerID));
                    if(numberOfQuiz > 1){
                        contentObj = (JSONObject) tempArray.get(1);
                        answerID = contentObj.get("id").toString();
                        Assert.assertTrue("Multiple Quiz is not showing ",waitUntilElementDisplayed(getQuizAnswerElement(answerID),5));
                        break;
                    }
                    else {
                        Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
                        break;
                    }
                }
            }
        }
        else {
            Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
        }
    }
    public static void answerMultipleQuestionsAccordingToFile(String fileName,String task){
        boolean flag = false;
        String questionType ="";
        String questionTypeJsonElement ="";
        if(task.toUpperCase().equals("POLL")){
            questionType = "POLL";
            questionTypeJsonElement = "total_polls";
        }else if(task.toUpperCase().equals("QUIZ")){
            questionType = "QUIZ";
            questionTypeJsonElement = "total_quizzes";
        }
        else {
            Assert.assertTrue("Required task is not right",false);
        }
        int numberOfQuestions = getSizeofObject(fileName,"data",questionTypeJsonElement);
        String answerID = "";
        int count =0;
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfQuestions > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals(questionType)) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    if(questionType.equals("QUIZ")){
                        waitUntilElementDisplayed(getQuizAnswerElement(answerID), 10);
                        click(getQuizAnswerElement(answerID));
                    }else if(questionType.equals("POLL")){
                        waitUntilElementDisplayed(getPollAnswerElement(answerID), 10);
                        click(getPollAnswerElement(answerID));
                    }
                    else {
                        Assert.assertTrue("Required task is not right",false);
                    }
                    try {
                        Thread.sleep(5000);
                    }
                    catch (Exception ex){

                    }
                    if(count == numberOfQuestions-1){
                        if(questionType.equals("QUIZ")){
                            Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
                        }else if(questionType.equals("POLL")){
                            Assert.assertTrue("Poll Summary Element is not present", waitUntilElementDisplayed(poll_Summary_Text, 5));
                        }
                        else {
                            Assert.assertTrue("Required task is not right",false);
                        }
                    }
                    count++;
                }
            }
        }
        else {
            if(questionType.equals("QUIZ")){
                Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
            }else if(questionType.equals("POLL")){
                Assert.assertTrue("Poll Summary Element is not present", waitUntilElementDisplayed(poll_Summary_Text, 5));
            }
            else {
                Assert.assertTrue("Required task is not right",false);
            }
        }
    }
    public static void answerMultipleQuizAccordingToFile(String fileName){
        boolean flag = false;
        int numberOfQuiz = getSizeofObject(fileName,"data","total_quizzes");
        String answerID = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfQuiz > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals("QUIZ")) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    click(quiz_Summary_Arrow_Text);
                    Assert.assertTrue("Quiz Answer is not moving forward",waitUntilElementDisplayed(getQuizAnswerElement(answerID), 5));
                }
            }
        }
        else {
            Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
        }
    }
    public static void answerMultiplePollsAccordingToFile(String fileName){
        boolean flag = false;
        int numberOfPolls = getSizeofObject(fileName,"data","total_polls");
        String answerID = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfPolls > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals("POLL")) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    click(poll_Summary_Arrow_Text);
                    Assert.assertTrue("Poll Answer is not moving forward",waitUntilElementDisplayed(getPollAnswerElement(answerID), 5));
                }
            }
        }
        else {
            Assert.assertTrue("Poll Summary Element is not present", waitUntilElementDisplayed(poll_Summary_Text, 5));
        }
    }
    public static void reviewingQuizCount(String fileName){
        boolean flag = false;
        int numberOfQuiz = getSizeofObject(fileName,"data","total_quizzes");
        String answerID = "";
        int count = 1;
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfQuiz > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals("QUIZ")) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    click(quiz_Summary_Arrow_Text);
                    waitUntilElementDisplayed(getQuizAnswerElement(answerID), 5);
                    Assert.assertTrue("Quiz Answer Count is not correct",waitUntilElementDisplayed(getQuizCountElement(count+" / "+numberOfQuiz), 5));
                    count++;
                }
            }
        }
        else {
            Assert.assertTrue("Quiz Summary Element is not present", waitUntilElementDisplayed(quiz_Summary_Text, 5));
        }
    }
    public static void reviewingPollCount(String fileName){
        boolean flag = false;
        int numberOfQuiz = getSizeofObject(fileName,"data","total_polls");
        String answerID = "";
        int count = 1;
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        if(numberOfQuiz > 0) {
            for (int i = 0; i < arrayForData.size(); i++) {
                JSONObject tempObj = (JSONObject) arrayForData.get(i);
                if (tempObj.get("question_type").toString().toUpperCase().equals("POLL")) {
                    JSONArray tempArray = (JSONArray) tempObj.get("answers");
                    JSONObject contentObj = (JSONObject) tempArray.get(0);
                    answerID = contentObj.get("id").toString();
                    click(poll_Summary_Arrow_Text);
                    waitUntilElementDisplayed(getPollAnswerElement(answerID), 5);
                    Assert.assertTrue("Poll Answer Count is not correct",waitUntilElementDisplayed(getQuizCountElement(count+" / "+numberOfQuiz), 5));
                    count++;
                }
            }
        }
        else {
            Assert.assertTrue("Poll Summary Element is not present", waitUntilElementDisplayed(poll_Summary_Text, 5));
        }
    }
    public static void verifyPollAccordingToFile(String fileName){
        boolean flag = false;
        String idOfPoll = "";
        String questionOfPoll = "";
        String answerID = "";
        String answerText = "";
        JSONArray arrayForData = getJsonArray(fileName,"data","records");
        for(int i = 0; i < arrayForData.size(); i++){
            JSONObject tempObj = (JSONObject) arrayForData.get(i);
            if(tempObj.get("question_type").toString().toUpperCase().equals("POLL")){
                idOfPoll = tempObj.get("id").toString();
                questionOfPoll = tempObj.get("question").toString();
                Assert.assertEquals(true, waitUntilElementDisplayed(getPollTileElement(idOfPoll), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getPollImageElement(idOfPoll), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getPollQuestionElement(idOfPoll), 5));
                Assert.assertEquals(true, waitUntilElementDisplayed(getPollQuestionTextElement(questionOfPoll), 5));
                JSONArray tempArray = (JSONArray) tempObj.get("answers");
                for(int j = 0; j<tempArray.size();j++){
                    JSONObject contentObj = (JSONObject) tempArray.get(j);
                    answerID = contentObj.get("id").toString();
                    answerText = contentObj.get("answer").toString().toUpperCase();
                    Assert.assertEquals(true, waitUntilElementDisplayed(getPollAnswerElement(answerID), 5));
                    Assert.assertEquals(true, waitUntilElementDisplayed(getPollAnswerTextElement(answerText), 5));
                }
                break;
            }
        }
    }
    public static void verifyQuizSummaryScreen(){
        Assert.assertEquals(true, waitUntilElementDisplayed(quiz_SummaryShort_Text, 5));
        Assert.assertEquals(true, waitUntilElementDisplayed(quiz_Summary_Right_Text, 5));
        Assert.assertEquals(true, waitUntilElementDisplayed(quiz_Summary_Wrong_Text, 5));
        Assert.assertEquals(true, waitUntilElementDisplayed(quiz_Summary_Footer_Text, 5));
    }
    public static void verifyPollSummaryScreen(){
        Assert.assertEquals(true, waitUntilElementDisplayed(poll_Summary_Text, 5));
        Assert.assertEquals(true, waitUntilElementDisplayed(poll_SummaryShort_Button, 5));
    }
    public static void verifyQuizSummaryArrow(){
        Assert.assertEquals(true, waitUntilElementDisplayed(quiz_Summary_Arrow_Text, 5));
    }
    public static void verifyTopBannerSwipeAccordingToCountOfCarousal(String direction){
        boolean flag = false;
        int numberOfCarousal = Integer.parseInt(getCount(topBanner_Count));
        if(numberOfCarousal <= 1){
            flag = swipeElementAndroidHorizontalCounted(topBanner_Image_1,direction.toUpperCase(),numberOfCarousal);
            Assert.assertEquals(flag,false);
        }
        else{
            flag = swipeElementAndroidHorizontalCounted(topBanner_Image_1,direction.toUpperCase(),numberOfCarousal);
            Assert.assertEquals(flag,true);
        }
    }
}
