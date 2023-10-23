package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
        public RegisterPage(WebDriver driver){
            super (driver);
        }
    @FindBy(xpath = "//input[@id='input-firstname']")
        private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='input-email']")
        private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")
        private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='agree']")
        private WebElement privacyToggle;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
        private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password, boolean toggle){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        if(toggle){
            privacyToggle.click();
        }
        continueBtn.click();
    }

}
