package com.example.seleniumtest;

//This one is the sumup of the testing
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

public class openLink {

    public static void main(String[] args) throws InterruptedException{

        // set the firefox driver
        System.setProperty("webdriver.chrome.driver","/Users/summer/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        // open my webpage
        driver.get("http://localhost:8081/");
        System.out.println("Allocate the web page");

        // click the link with name "press release"

        //Check link
        WebElement contact = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",contact);
        System.out.println("Contact click successfully");

        WebElement chat = driver.findElement(By.xpath("//a[@href='chat.html']"));
        Thread.sleep(3000);
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].click();",chat);
        System.out.println("Chat click successfully");

        WebElement testForm = driver.findElement(By.id("submission"));
        Thread.sleep(3000);
        testForm.sendKeys("hi");
        Thread.sleep(3000);
        WebElement nextButton = driver.findElement(By.id("submit"));
        nextButton.click();

    }
}

