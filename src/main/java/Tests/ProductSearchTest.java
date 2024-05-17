package Tests;

import BaseTest.BaseTest;
import HelpMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class ProductSearchTest extends BaseTest{

    public GeneralMethods generalMethods;

    @Test
    public void productSearch() {
        generalMethods = new GeneralMethods(driver);
        Actions actions = new Actions(driver);

        String expectedTitle =  "Ansambluri Rezidențiale - Storia.ro";
        generalMethods.validatePageTitle(expectedTitle);
        generalMethods.acceptCookiesButton();

        WebElement selectEstate = driver.findElement(By.xpath("//div[contains(text(),'Ansambluri')]"));
        selectEstate.click();
        Integer optionIndex  = 2;
        for (int i = 0; i < optionIndex; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();

        WebElement selectDropDownOptions = driver.findElement(By.xpath("//div[contains(text(),'De vânzare')]"));
        selectDropDownOptions.click();
        Integer optionTwoIndex = 1;
        for (int i = 0; i < optionTwoIndex; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();

        WebElement selectAddress = driver.findElement(By.xpath("//div[contains(text(),'Alege locația')]"));
        selectAddress.click();

        List<WebElement> citiesElementList = driver.findElements(By.xpath("//ul[@data-testid=\"regions-list\"]//li//label[@data-testid=\"checkbox\"]"));
        Random random2 = new Random();
        int randomIndex2 = random2.nextInt(citiesElementList.size());
        WebElement randomProduct2 = citiesElementList.get(randomIndex2);
        randomProduct2.click();

        WebElement clickOutsideElement = driver.findElement(By.xpath("//*[@data-testid='search-section-bg-wrapper']"));
        clickOutsideElement.click();

        WebElement selectKm = driver.findElement(By.xpath("//div[contains(text(),'0 km')]"));
        selectKm.click();
        Integer optionThreeIndex = 4;
        for (int i = 0; i < optionThreeIndex; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();

        WebElement priceMin = driver.findElement(By.id("priceMin"));
        String priceValueMin = "50000";
        priceMin.sendKeys(priceValueMin);

        WebElement priceMax = driver.findElement(By.id("priceMax"));
        String priceValueMax = "150000";
        priceMax.sendKeys(priceValueMax);

        WebElement areaMin = driver.findElement(By.id("areaMin"));
        String areaValueMin = "50";
        areaMin.sendKeys(areaValueMin);

        WebElement areaMax = driver.findElement(By.id("areaMax"));
        String areaValueMax = "90";
        areaMax.sendKeys(areaValueMax);

        WebElement resultButton = driver.findElement(By.id("search-form-submit"));
        resultButton.click();

        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-cy='search.listing.promoted']"));
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement randomProduct = productList.get(randomIndex);
        randomProduct.click();

        String expectedText = "Storia.ro";
        String actualTitle = driver.getTitle();
        System.out.println("Expected Text: " + expectedText);
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedText),"Titlul paginii nu contine textul asteptat");

        WebElement nameField = driver.findElement(By.xpath("//div[@data-cy='contact-form']/form/div/input[@type='text']"));
        String completeName = "Bogdan";
        nameField.sendKeys(completeName);

        WebElement emailField = driver.findElement(By.xpath("//div[@data-cy='contact-form']/form/div/input[@name='email']"));
        String completeEmail = "bacaoanubogdan94@gmail.com";
        emailField.sendKeys(completeEmail);

        WebElement phoneNumberField = driver.findElement(By.xpath("//div[@data-cy='contact-form']/form/div/div/input[@name='phone']"));
        String completePhoneNumber = "12345678";
        phoneNumberField.sendKeys(completePhoneNumber);

        WebElement textField = driver.findElement(By.xpath("//div[@data-cy='contact-form']//div[@class='css-1t98obi ei8l9l75']/textarea"));
        textField.clear();
        String completeText = "As dori mai multe detalii daca se poate. Astept raspuns.";
        textField.sendKeys(completeText);
    }

























}
