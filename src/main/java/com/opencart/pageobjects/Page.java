package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {


public Page(WebDriver driver){
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//i[@class='fa-solid fa-user']")
protected WebElement myAccountIcon;
@FindBy(xpath = "//a[normalize-space()='Register']")
protected WebElement registerBtn;
@FindBy(xpath = "//a[normalize-space()='Login']")
protected WebElement loginBtn;

    public void navigateToRegisterPageFromHeader(){
        myAccountIcon.click();
        registerBtn.click();
    }

    public void navigateToLoginFromHeader(){
        myAccountIcon.click();
        loginBtn.click();
    }
}


