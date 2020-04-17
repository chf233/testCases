package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MonkeyTest {
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


        // get all the links
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
                        Thread.sleep(3000);
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

    }
}
