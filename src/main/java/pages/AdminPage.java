package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class AdminPage {
    private WebDriver driver;

    private By adminTab = By.linkText("Admin");
    private By addButton = By.cssSelector(".orangehrm-header-container button");
    private By records = By.cssSelector("div.oxd-table-card");
    private By searchField = By.cssSelector("input.oxd-input");
    private By deleteUserButton = By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space");
    private By confirmDeleteButton = By.cssSelector(".oxd-button--label-danger");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAdminPage() {
        driver.findElement(adminTab).click();
    }

    public int getNumberOfRecords() {
        List<WebElement> recordElements = driver.findElements(records);
        return recordElements.size();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void searchUser(String username) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        driver.findElements(searchField).get(1).sendKeys(username);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteUserButton).click();
    }

    public void confirmDelete() {
        driver.findElement(confirmDeleteButton).click();
    }
}
