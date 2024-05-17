package HelpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class GeneralMethods {

    private WebDriver driver;
    public GeneralMethods(WebDriver driver){
        this.driver = driver;
    }
    public void validatePageTitle(String expectedPageTitle){
        String actualPageTitle = driver.getTitle();
        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle),"Page not found.");
    }
    public void acceptCookiesButton() {
        try {
            WebElement acceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            acceptButton.click();
        } catch (NoSuchElementException ignored) {

        } finally {
        }

    }
    public void ScrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
    }

    public void doubleClick(WebElement element){
        Actions click = new Actions(driver);
        click.doubleClick(element).perform();
    }
    public void rightClickMe(WebElement element2){
        Actions rightClick = new Actions(driver);
        rightClick.contextClick().perform();
    }
    public void scrollIntoView(WebElement element3){
        Actions actions = new Actions(driver);
        actions.moveToElement(element3);
        actions.perform();
    }
    public void switchToNewTab (int index){
        ArrayList<String> openTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTab.get(index));
        System.out.println(driver.getTitle());
//        driver.close();
    }
    public void switchToDefaultTab(){
        ArrayList<String> openTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTab.get(0));
        System.out.println("Titlul noului tab este: " + driver.getTitle());
    }
    public void waitForElementToBeSelected(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public void waitForElementToBeClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            if (!element.isDisplayed()) {
                wait.until(ExpectedConditions.stalenessOf(element));
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }


    }
    public void selectOptions(WebElement element4, int optionIndex){
        Select select = new Select(element4);
        select.selectByIndex(optionIndex);
    }



















}
