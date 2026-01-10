package org.solvd.test.webTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver webDriver;

    @BeforeTest
    public  void  setUp(){
        webDriver = new ChromeDriver();
         webDriver.manage().window().maximize();
         webDriver.get("https://sauce-demo.myshopify.com/account/login");
    }
    @AfterTest
    public void settleDown(){
       // webDriver.quit();
    }
    @Test
    public  void TestLogin(){

        WebElement customerEmail=webDriver.findElement(By.id("customer_email"));
        customerEmail.sendKeys("g.ugulava12@gmail.com");
        WebElement customerPassword=webDriver.findElement(By.id("customer_password"));
        customerPassword.sendKeys("kaikaci1234");
        webDriver.findElement(By.xpath("//input[@value='Sign In']")).click();

    }
}
