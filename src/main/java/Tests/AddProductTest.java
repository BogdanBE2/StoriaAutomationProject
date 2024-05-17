package Tests;

import BaseTest.BaseTest;
import HelpMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductTest extends BaseTest {

    public GeneralMethods generalMethods;

    @Test

    public void addProduct() {
        generalMethods = new GeneralMethods(driver);

        String expectedTitle = "Ansambluri Rezidențiale - Storia.ro";
        generalMethods.validatePageTitle(expectedTitle);
        generalMethods.acceptCookiesButton();

        WebElement addProductButton = driver.findElement(By.xpath("//div[@class='eku0oc62 css-1bc7oiu']/div/div[4]/div/button/span/span"));
        addProductButton.click();

        WebElement checkBoxSell = driver.findElement(By.xpath("//div[@data-testid='category-type-radio-input']/label/span[contains(text(),'Voi vinde')]"));
        checkBoxSell.click();

        WebElement propertyType = driver.findElement(By.xpath("//div[@data-testid='category-grid-input']/label[3]"));
        propertyType.click();

        WebElement continueButton = driver.findElement(By.xpath("//div[@class='css-miq1l8 e11v8ez64']/button/span/span"));
        continueButton.click();

        WebElement emailAddressField = driver.findElement(By.id("username"));
        String emailAddress = "bacaoanubogdan94@gmail.com";
        emailAddressField.sendKeys(emailAddress);

        WebElement passwordField = driver.findElement(By.id("password"));
        String password = "Bogdan2124!";
        passwordField.sendKeys(password);

        WebElement logInButton = driver.findElement(By.xpath("//div[@class='css-13dpkcn es0c85k0']/form/button/span/span"));
        logInButton.click();

        driver.get("https://www.storia.ro/vanzare/teren/anunt-nou/");
        WebElement pageTitle = driver.findElement(By.xpath("//h4[contains(text(),'Informații principale anunț')]"));
        Assert.assertTrue(pageTitle.isDisplayed());

        WebElement addTitle = driver.findElement(By.id("add-title"));
        String titleDescription = "Teren de vanzare intravilan in Galati";
        addTitle.sendKeys(titleDescription);

        WebElement priceField = driver.findElement(By.xpath("//div[@class='col-xs-7']/input"));
        String price = "25750";
        priceField.sendKeys(price);

        WebElement areaField = driver.findElement(By.id("param1002"));
        String areaM2 = "1000";
        areaField.sendKeys(areaM2);

        WebElement sellerType = driver.findElement(By.xpath("//div[@class='df_radio df_radio_2 df_radio_2_light']/label[@for='checkbox-owner']"));
        sellerType.click();

        WebElement locationField = driver.findElement(By.xpath("//div[@class='form-group']/span/span/span"));
        locationField.click();
        WebElement locationFieldTwo = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        String location = "Galati";
        locationFieldTwo.sendKeys(location);

        WebElement selectLocation = driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[3]"));
        selectLocation.click();

        driver.switchTo().frame("wysiwyg_ifr");
        WebElement descriptionBox = driver.findElement(By.id("tinymce"));
        String description = "Vand teren intravilan aproape de oras, pentru mai multe detalii, astept mesaje.";
        descriptionBox.sendKeys(description);
        driver.switchTo().defaultContent();

        WebElement selectType = driver.findElement(By.id("param1012"));
        selectType.click();
        generalMethods.selectOptions(selectType, 7);

        WebElement sizeBox = driver.findElement(By.id("param1019"));
        String sizeMeters = "1000";
        sizeBox.sendKeys(sizeMeters);

        WebElement selectFence = driver.findElement(By.id("param1015"));
        selectFence.click();
        generalMethods.selectOptions(selectFence,2);

        WebElement locationType = driver.findElement(By.id("param1013"));
        locationType.click();
        generalMethods.selectOptions(locationType, 3);

        WebElement electricityBox = driver.findElement(By.xpath("//label[contains(text(),'electricitate')]"));
        electricityBox.click();

        WebElement waterBox = driver.findElement(By.xpath("//label[contains(text(),'apa')]"));
        waterBox.click();

        WebElement gasBox = driver.findElement(By.xpath("//label[contains(text(),'gaz')]"));
        gasBox.click();

        WebElement drainageBox = driver.findElement(By.xpath("//label[contains(text(),'canalizare')]"));
        drainageBox.click();

        WebElement accessTypeBox = driver.findElement(By.xpath("//label[contains(text(),'asfaltat')]"));
        accessTypeBox.click();

        WebElement surroundingsLakeBox = driver.findElement(By.xpath("//label[contains(text(),'lac')]"));
        surroundingsLakeBox.click();

        WebElement surroundingOpenFieldBox = driver.findElement(By.xpath("//label[contains(text(),'camp deschis')]"));
        surroundingOpenFieldBox.click();

        WebElement remoteViewing = driver.findElement(By.id("param1003"));
        remoteViewing.click();
        generalMethods.selectOptions(remoteViewing, 1);

        WebElement firstNameField = driver.findElement(By.id("add-person"));
        String firstName = "Bogdan";
        firstNameField.sendKeys(firstName);

        WebElement phoneNumberField = driver.findElement(By.id("add-phone"));
        String phoneNumber = "0757 000 123";
        phoneNumberField.sendKeys(phoneNumber);

        WebElement acceptTerms = driver.findElement(By.xpath("//label[contains(text(),'Sunt de acord')]"));
        acceptTerms.click();
    }











}
