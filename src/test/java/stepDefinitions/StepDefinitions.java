package stepDefinitions;

import pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AdminPage;
import pages.CreateUserPage;
import pages.LoginPage;
import utils.Utils;

import java.awt.*;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private CreateUserPage createUserPage;
    private int firstNumberOfRecords;
    private int secondNumberOfRecords;
    private int thirdNumberOfRecords;
    private String randomString;

    @Before
    public void setUp() {
        BasePage.setUp();
        driver = BasePage.driver;
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        createUserPage = new CreateUserPage(driver);
    }

    @After
    public void tearDown() {BasePage.tearDown();}

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I navigate to the Admin page")
    public void i_navigate_to_the_admin_page() {
        adminPage.goToAdminPage();
    }

    @Then("I record the initial number of users")
    public void i_record_the_initial_number_of_users() {
        firstNumberOfRecords = adminPage.getNumberOfRecords();
    }

    @When("I add a new user with a random username")
    public void i_add_a_new_user_with_a_random_username() throws AWTException, InterruptedException {
        randomString = Utils.generateRandomString();
        adminPage.clickAddButton();
        createUserPage.addUser(randomString, "TestAdmin1");
    }

    @Then("the number of users should increase by 1")
    public void the_number_of_users_should_increase_by_1() {
        secondNumberOfRecords = adminPage.getNumberOfRecords();
        Assert.assertEquals(secondNumberOfRecords, firstNumberOfRecords + 1, "The number of users did not increase by 1.");
    }

    @When("I search for the newly added user")
    public void i_search_for_the_newly_added_user() throws InterruptedException, AWTException {
        adminPage.searchUser(randomString);
    }

    @When("I delete the user")
    public void i_delete_the_user() {
        adminPage.clickDeleteButton();
        adminPage.confirmDelete();
        adminPage.goToAdminPage();
    }

    @Then("the number of users should be back to the initial count")
    public void the_number_of_users_should_be_back_to_the_initial_count() {
        thirdNumberOfRecords = adminPage.getNumberOfRecords();
        Assert.assertEquals(thirdNumberOfRecords, firstNumberOfRecords, "The number of users did not return to the initial count.");
    }
}
