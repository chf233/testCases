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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;

public class openCallLink {
    public static void main(String[] args) throws InterruptedException{

        // set the firefox driver

        // open my webpage
        //driver.get("https://localhost:8086");

        DesiredCapabilities cap=DesiredCapabilities.chrome();

        // 设置变量ACCEPT_SSL_CERTS的值为True
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        System.setProperty("webdriver.chrome.driver","/Users/summer/Downloads/chromedriver");

        // 打开带capability设置选项的浏览器
        WebDriver driver=new ChromeDriver(cap);
        driver.manage().window().maximize();
        driver.get("https:localhost:8086");

        System.out.println("Allocate the web page");

        WebElement detailButton = driver.findElement(By.id("details-button"));
        detailButton.click();
        System.out.println("detail button click");
        WebElement goButton = driver.findElement(By.id("proceed-link"));
        goButton.click();
        System.out.println("gobutton click");
        // click the link with name "press release"

        //Check link
        WebElement contact = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",contact);
        System.out.println("Contact click successfully");

        WebElement chat = driver.findElement(By.xpath("//a[@href='call.html']"));
        Thread.sleep(3000);
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].click();",chat);
        System.out.println("Chat click successfully");

        Select userSelect=new Select(driver.findElement(By.id("product")));
        Thread.sleep(3000);
        userSelect.selectByVisibleText("Consotosh");
        System.out.println("product selected");

        Select userSelect2=new Select(driver.findElement(By.id("problem")));
        Thread.sleep(3000);
        userSelect2.selectByVisibleText("Screen");
        System.out.println("problem selected");


        /*WebElement nextButton = driver.findElement(By.id("submitProblem"));
        Thread.sleep(3000);
        nextButton.click();
        System.out.println("problemSubmitted");*/


        WebElement callButton = driver.findElement(By.id("callButton"));
        Thread.sleep(3000);
        callButton.click();
        System.out.println("start call");
/*
        WebElement testForm = driver.findElement(By.id("submission"));
        Thread.sleep(3000);
        testForm.sendKeys("hi");
        Thread.sleep(3000);
        WebElement nextButton = driver.findElement(By.id("submit"));
        nextButton.click();*/

    }
}
