package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MonkeyTestContact {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/summer/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        // open my webpage
        driver.get("https://localhost:8086/");
        System.out.println("Allocate the web page");

        // click the link with name "press release"

        WebElement detailButton = driver.findElement(By.id("details-button"));
        detailButton.click();
        System.out.println("detail button click");
        WebElement goButton = driver.findElement(By.id("proceed-link"));
        goButton.click();
        System.out.println("gobutton click");

        WebElement contact = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",contact);
        System.out.println("Contact click successfully");

        //get links
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println("***Printing all link names***");
        // print all the links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getText());

        }
        System.out.println("***Printing all link addresses***");
        // print all the hyper links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getAttribute("href"));

        }
        for(int i = 0; i < links.size(); i++)
        {
            System.out.println("*** Navigating to" + " " + links.get(i).getAttribute("href"));
            //if (links.get(i).getAttribute("href") == null ||
            //		links.get(i).getAttribute("href").equals("https://sudiptac.bitbucket.io"))
            if (links.get(i).getAttribute("href") == null){
                continue;}
            else {
                boolean staleElementLoaded = true;
                //the loop checks whether the elements is properly loaded
                while(staleElementLoaded) {
                    try {
                        //navigate to the link
                        driver.navigate().to(links.get(i).getAttribute("href"));
                        Thread.sleep(2000);
                        //click the back button in browser
                        driver.navigate().back();
                        links = driver.findElements(By.tagName("a"));
                        System.out.println("*** Navigated to" + " " + links.get(i).getAttribute("href"));
                        staleElementLoaded = false;
                    } catch (StaleElementReferenceException e) {
                        staleElementLoaded = true;
                    }
                }
            }
        }

            WebElement drpbtn = driver.findElement(By.className("dropbtn"));
            System.out.println(drpbtn.getText());
            System.out.println("yeee");
            //WebElement dropdown = driver.findElement(By.className("dropdown-content"));
            Actions actions = new Actions(driver);
            actions.moveToElement(drpbtn).perform();
            System.out.println("yeeeeeee");
            Thread.sleep(1000);
            List<WebElement> buttonsList = driver.findElements(By.className("dropbutton-content"));
            System.out.println("find buttons");
            Thread.sleep(3000);
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            Thread.sleep(3000);
            System.out.println("ohhhh");
            WebElement buttonI = buttons.get(0);
            actions.moveToElement(buttonI).click().perform();
            Thread.sleep(3000);
            System.out.println("gg");
            driver.navigate().back();


        /*
        List<WebElement> buttons= driver.findElements(By.tagName("button"));
        for(int i = 0; i < buttons.size(); i++) {
            System.out.println(buttons.get(i));

        }
        buttons.get(0).click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement contact2 = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();",contact2);
        System.out.println("Contact click successfully");


        List<WebElement> buttons2= driver.findElements(By.tagName("button"));
        for(int i = 0; i < buttons2.size(); i++) {
            System.out.println(buttons2.get(i));
        }
        buttons2.get(5).click();
        Thread.sleep(2000);
        driver.navigate().back();
*/
        /*
        for(int i = 0; i < buttons.size(); i++)
        {
            System.out.println("*** Navigating to" + " " + buttons.get(i).getText());
            //if (links.get(i).getAttribute("href") == null ||
            //		links.get(i).getAttribute("href").equals("https://sudiptac.bitbucket.io"))
            if (buttons.get(i).getText() == null){
                continue;}
            else if(i == 0 || i == 5) {
                boolean staleElementLoaded = true;
                //the loop checks whether the elements is properly loaded
                while(staleElementLoaded) {
                    try {
                        //navigate to the link
                        buttons.get(i).click();
                        Thread.sleep(3000);
                        //click the back button in browser
                        driver.navigate().back();
                        buttons = driver.findElements(By.tagName("button"));
                        System.out.println("*** Navigated to" + " " + buttons.get(i).getText());
                        staleElementLoaded = false;
                    } catch (StaleElementReferenceException e) {
                        staleElementLoaded = true;
                    }
                }
            }
            else{
                continue;
            }
        }*/
    }
}
