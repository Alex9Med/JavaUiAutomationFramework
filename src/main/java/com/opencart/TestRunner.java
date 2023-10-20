package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.andreisecuqa.host/");
        Thread.sleep(3000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);

        Thread.sleep(500);
        WebElement termsAndConditionsToggleBar = driver.findElement(By.xpath("//input[@name='agree']"));
        termsAndConditionsToggleBar.click();

        WebElement registerBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        registerBtn.click();
        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
        System.out.println("The execution is over");


    }
}