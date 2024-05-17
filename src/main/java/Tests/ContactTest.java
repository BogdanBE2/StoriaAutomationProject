package Tests;

import BaseTest.BaseTest;
import HelpMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    public GeneralMethods generalMethods;

    @Test

    public void contactTest(){
        generalMethods = new GeneralMethods(driver);

        String expectedTitle = "Ansambluri Rezidențiale - Storia.ro";
        generalMethods.validatePageTitle(expectedTitle);
        generalMethods.acceptCookiesButton();

        WebElement contactSupport = driver.findElement(By.xpath("//ul[@class='css-67gm5 evika910']/li[6]/ul/li[1]"));
        contactSupport.click();
        generalMethods.switchToNewTab(1);

        String expectedPageTitle = "Trimitere solicitare - Ajutor";
        generalMethods.validatePageTitle(expectedPageTitle);

        WebElement subject = driver.findElement(By.xpath("//div[@class='content oneAlohaPageDeprecated']/iframe"));
        driver.switchTo().frame(subject);
        WebElement selectOption = driver.findElement(By.xpath("//select[@class='request request_required dependent-picklist form-control']/option[10]"));
        selectOption.click();

        WebElement emailAddressField = driver.findElement(By.id("j_id0:HelpCenterTemplateTemporary:new_request:request_email"));
        String emailAdress = "bacaoanubogdan94@gmail.com";
        emailAddressField.sendKeys(emailAdress);

        WebElement descriptionField = driver.findElement(By.id("j_id0:HelpCenterTemplateTemporary:new_request:request_description"));
        String description = "Buna ziua, consider a fiind o imbunatatire daca se pot adauga mai multe poze in acelasi timp si mai mari de 5MB. Multumesc";
        descriptionField.sendKeys(description);

        WebElement sellerType = driver.findElement(By.xpath("//select[@class='request request_required form-control']/option[3]"));
        sellerType.click();

        WebElement nameField = driver.findElement(By.id("j_id0:HelpCenterTemplateTemporary:new_request:request_name"));
        String name = "Bogdan";
        nameField.sendKeys(name);

        WebElement phoneNumberField = driver.findElement(By.id("j_id0:HelpCenterTemplateTemporary:new_request:request_telephonenumber"));
        String phoneNumber = "0750123456";
        phoneNumberField.sendKeys(phoneNumber);

        WebElement announcementNumberField = driver.findElement(By.id("j_id0:HelpCenterTemplateTemporary:new_request:request_numberorlinktothead"));
        String announcementNumber = "4235622";
        announcementNumberField.sendKeys(announcementNumber);

        driver.close();

        generalMethods.switchToDefaultTab();
    }







}
