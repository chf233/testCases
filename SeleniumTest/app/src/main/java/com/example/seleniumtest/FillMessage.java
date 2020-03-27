package com.example.seleniumtest;
//这个
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillMessage {

    //static String myUserName = "##escistd50.003";
    //static String myPassword = "SUTD@Singapore";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/summer/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        // open my webpage
        driver.get("http://localhost:8081/chat.html");
        System.out.println("123");

        // get the user name field of the account page
        /*
        WebElement testForm = driver.findElement(By.id("textInput"));

        Thread.sleep(3000);

        // send my user name to fill up the box
        testForm.sendKeys("hii");

        Thread.sleep(3000);

        WebElement nextButton = driver.findElement(By.linkText("Submit"));
        nextButton.click();
*/
        WebElement testForm = driver.findElement(By.id("submission"));
        testForm.sendKeys("hi");
        WebElement nextButton = driver.findElement(By.id("submit"));
        nextButton.click();

    }
}

