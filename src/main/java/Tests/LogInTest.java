package Tests;

import BaseTest.BaseTest;
import HelpMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    public GeneralMethods generalMethods;

    @Test

    public void logIn(){
        generalMethods = new GeneralMethods(driver);

        String expectedTitle =  "Ansambluri Rezidențiale - Storia.ro";
        generalMethods.validatePageTitle(expectedTitle);
        generalMethods.acceptCookiesButton();

        WebElement myAccountButton = driver.findElement(By.xpath("//div[@class='edaxo2a3 css-5topit']//span"));
        myAccountButton.click();

        WebElement emailAddressField = driver.findElement(By.id("username"));
        String username = "bacaoanubogdan94@gmail.com";
        emailAddressField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        String password = "Bogdan2124!";
        passwordField.sendKeys(password);

        WebElement submitButtom = driver.findElement(By.xpath("//button[@type='submit']/span/span"));
        submitButtom.click();
    }





















}
