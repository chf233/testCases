package com.example.seleniumtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class openChatLink {
    public static void main(String[] args) throws InterruptedException {
        // set the firefox driver
        System.setProperty("webdriver.chrome.driver","/Users/summer/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        // open my webpage
        driver.get("https:localhost:8086");
        System.out.println("Allocate the web page");

        // click the link with name "press release"

        WebElement detailButton = driver.findElement(By.id("details-button"));
        detailButton.click();
        System.out.println("detail button click");
        WebElement goButton = driver.findElement(By.id("proceed-link"));
        goButton.click();
        System.out.println("gobutton click");

        //Check link
        WebElement contact = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",contact);
        System.out.println("Contact click successfully");

        //WebElement iphoneBattery = driver.findElement(By.tagName("button"));
        Thread.sleep(4000);

        List<WebElement> links= driver.findElements(By.className("dropbtn"));
        System.out.println("chat click");
        System.out.println(links);
        System.out.println(links.get(0));
        System.out.println("another");
        WebElement drpbtn = driver.findElement(By.className("dropbtn"));
        System.out.println(drpbtn.getText());
        System.out.println("yeee");
        //WebElement dropdown = driver.findElement(By.className("dropdown-content"));
        Actions actions = new Actions(driver);
        actions.moveToElement(drpbtn).perform();
        System.out.println("yeeeeeee");
        Thread.sleep(2000);
        List<WebElement> buttonsList = driver.findElements(By.className("dropbutton-content"));
        System.out.println("find buttons");
        Thread.sleep(1000);
        System.out.println(buttonsList);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println(buttons);
        Thread.sleep(2000);

        WebElement buttoni = buttons.get(2);
        actions.moveToElement(buttoni).click().perform();
        System.out.println("gg");

        Thread.sleep(1000);
        WebElement statusChat = driver.findElement(By.id("status"));
        System.out.println(statusChat.getText());
        while (statusChat.getText().equals("Finding/Waiting for an Agent")){
            System.out.println("waiting");
        }
        WebElement testForm = driver.findElement(By.id("submission"));
        Thread.sleep(1000);
        testForm.sendKeys("hi");
        WebElement nextButton = driver.findElement(By.id("submit"));
        Thread.sleep(1000);
        nextButton.click();
        System.out.println("message sent");
        Thread.sleep(3000);
        WebElement endChat = driver.findElement(By.id("endChat"));
        endChat.click();
/*
        driver.navigate().back();
        System.out.println("return");*/

        WebElement contact2 = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(4000);
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].click();",contact2);
        System.out.println("Contact click successfully");

        WebElement call = driver.findElement(By.xpath("//a[@href='call.html']"));
        Thread.sleep(3000);
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].click();",call);
        System.out.println("Call click successfully");

        Select userSelect=new Select(driver.findElement(By.id("product")));
        Thread.sleep(3000);
        userSelect.selectByVisibleText("iphone");
        System.out.println("product selected");

        Select userSelect2=new Select(driver.findElement(By.id("problem")));
        Thread.sleep(3000);
        userSelect2.selectByVisibleText("Iphone: Battery/Power");
        System.out.println("problem selected");

        WebElement status = driver.findElement(By.id("status"));
        System.out.println(status.getText());
        WebElement callButton = driver.findElement(By.id("callButton"));
        Thread.sleep(4000);
        callButton.click();
        System.out.println("start call");
        while(status.getText().equals("Finding/Waiting for an Agent")){
            System.out.println("waiting");
        }
        Thread.sleep(5000);
        WebElement endCall = driver.findElement(By.id("endCall"));
        endCall.click();
        /*JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",contact);
        System.out.println("iphonebattery selected");*/

    }
}
