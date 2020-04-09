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
        List<WebElement> links= driver.findElements(By.tagName("button"));
        for(int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i));

        }
        links.get(5).click();
        System.out.println("ib button clicked");

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

        driver.navigate().back();
        System.out.println("return");

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
        userSelect.selectByVisibleText("Consotosh");
        System.out.println("product selected");

        Select userSelect2=new Select(driver.findElement(By.id("problem")));
        Thread.sleep(3000);
        userSelect2.selectByVisibleText("Screen");
        System.out.println("problem selected");

        WebElement status = driver.findElement(By.id("status"));
        System.out.println(status.getText());
        while(status.getText().equals("Finding/Waiting for an Agent")){
            System.out.println("waiting");
        }
        WebElement callButton = driver.findElement(By.id("callButton"));
        Thread.sleep(3000);
        callButton.click();
        System.out.println("start call");

        /*JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",contact);
        System.out.println("iphonebattery selected");*/

    }
}
