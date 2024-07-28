package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CreateUserPage {
    private WebDriver driver;

    private By userRoleDropdown = By.cssSelector(".oxd-select-text--after ");
    private By employeeNameField = By.cssSelector("[placeholder='Type for hints...']");
    private By statusDropdown = By.cssSelector(".oxd-select-text--after ");
    private By usernameField = By.cssSelector(".oxd-input");
    private By passwordField = By.cssSelector(".oxd-input");
    private By confirmPasswordField = By.cssSelector(".oxd-input");
    private By saveButton = By.cssSelector("[type='submit']");

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUserRole() throws AWTException, InterruptedException {
        WebElement userRoleElement = driver.findElements(userRoleDropdown).get(0);
        userRoleElement.click();
        Thread.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void enterEmployeeName(String name) throws InterruptedException, AWTException {
        WebElement employeeNameElement = driver.findElement(employeeNameField);
        employeeNameElement.sendKeys(name);
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void selectStatus() throws AWTException, InterruptedException {
        WebElement statusElement = driver.findElements(statusDropdown).get(1);
        statusElement.click();
        Thread.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void enterUsername(String username) {
        List<WebElement> usernameElements = driver.findElements(usernameField);
        WebElement usernameElement = usernameElements.get(1);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        List<WebElement> passwordElements = driver.findElements(passwordField);
        WebElement passwordElement = passwordElements.get(2);
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        List<WebElement> confirmPasswordElements = driver.findElements(confirmPasswordField);
        WebElement confirmPasswordElement = confirmPasswordElements.get(3);
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void addUser(String username, String password) throws AWTException, InterruptedException {
        selectUserRole();
        enterEmployeeName("a");
        selectStatus();
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);
        clickSaveButton();
    }
}
