package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main(String[] args)
    {
        //  Add this block
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");   // required for Jenkins
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        //  Replace driver creation
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        
        //  maximize may fail in headless, so optional
        // driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // good practice
        driver.quit();
    }
}
