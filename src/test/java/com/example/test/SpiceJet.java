package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SpiceJet {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "//Users//valaypatel//Documents//chromedriver");
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public  void goHomePage() {
        driver.get("https://www.spicejet.com/");
    }

    private static void dropDownSelection(WebDriver driver,By element,int number) {
        for (int i = 1; i < number; i++) {

            driver.findElement(element).click();
        }
    }

    @Test
    public void searchFlight() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='AMD']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BOM']")).click();
        WebElement toDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));
        toDate.findElement(By.linkText("9")).click();

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("Its Disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
//        driver.findElement(By.cssSelector(".ctl00_mainContent_chk_friendsandfamily"));
//
//        dropDownSelection(driver, By.id("divpaxinfo"), 3);

//		for (int i = 1; i < 3; i++)
//		{
//
//			driver.findElement(By.id("divpaxinfo")).click();
//		}
//        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3Adults");
//        System.out.println("driver.findElement(By.id(\"divpaxinfo\").getText()");
//
//        dropDownSelection(driver, By.id("ctl00_mainContent_ddl_Child"), 2);
//		for (int j = 1; j < 2; j++)
//		{
//			driver.findElement(By.id("ctl00_mainContent_ddl_Child")).click();
//		}
//        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_Child")).getText(), "2Child");
//        dropDownSelection(driver, By.id("ctl00_mainContent_DropDownListCurrency"), 3);
//        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText(), "USD");
//        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }


}