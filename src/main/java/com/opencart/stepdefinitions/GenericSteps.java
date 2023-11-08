package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigReaderManager;
import com.opencart.managers.DataSubstituteManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the current url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keyWordFromTheUrl) throws InterruptedException {
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keyWordFromTheUrl);
        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keyWordFromTheUrl + " is present in " + currentUrl);
    }

    @Given("{string} endpoint is accessed")
    public void endpointIsAccessed(String endpointValue) {
        driver.get(ConfigReaderManager.getPropertyValue("url") + endpointValue);
    }

    @Then("the following list of error messages is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(1000);
        errorMessagesList.forEach(errorMessage -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "The error message: " + errorMessage + " is displayed");
        });
    }

    @And("the {string} from {string} is clicked")
    public void theElementFromPageNameIsClicked(String elementName, String pageName) {
        try {
            Class classInstance = Class.forName("com.opencart.pageobjects." + pageName);
            Field classField = classInstance.getDeclaredField(elementName);
            classField.setAccessible(true);
            WebElement elementToBeClicked = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ScrollManager.scrollToTheElement(elementToBeClicked);
            elementToBeClicked.click();
            System.out.println("The element " + elementName + " is clicked");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the following form from {string} is populated as follow:")
    public void theFollowingFormFromIsPopulatedAsFollow(String pageName, Map<String, String> fieldAndValuesMap) {
        fieldAndValuesMap.forEach((fieldName, fieldValue) -> {
            try {
                Class classInstance = Class.forName("com.opencart.pageobjects." + pageName);
                Field classField = classInstance.getDeclaredField(fieldName);
                classField.setAccessible(true);
                WebElement inputElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
                fieldValue = DataSubstituteManager.subsituteString(fieldValue);
                inputElement.sendKeys(fieldValue);
                System.out.println("The field [" + fieldName + "] is populated with [" + fieldValue + "]");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
