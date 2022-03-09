package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    private WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Given("I navigate to the IMDB home page on Chrome")
    public void iNavigateToTheIMDBHomePageOnChrome() {
        driver.get("https://www.imdb.com/");
    }
    @And("Click on Sign In Button")
    public void clickOnSignInButton() {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#imdbHeader>div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner>div._3x17Igk9XRXcaKrcG3_MXQ.navbar__user.UserMenu-sc-1poz515-0.lkfvZn>a>div")));
        driver.findElement(By.cssSelector("#imdbHeader>div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner>div._3x17Igk9XRXcaKrcG3_MXQ.navbar__user.UserMenu-sc-1poz515-0.lkfvZn>a>div")).click();
    }
    @And("Click Sign in with IMDB button on Sign In Page")
    public void clickSignInWithIMDBButtonOnSignInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#signin-options > div > div:nth-child(2) > a:nth-child(1) > span.auth-provider-text")));
        driver.findElement(By.cssSelector("#signin-options > div > div:nth-child(2) > a:nth-child(1) > span.auth-provider-text")).click();
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials()  {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        driver.findElement(By.id("ap_email")).sendKeys("hesap10marttownhall@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Townhall.123");
        driver.findElement(By.id("signInSubmit")).click();
    }
    @Then("I should be taken to the valid page")
    public void i_should_be_taken_to_the_valid_page() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > div._3x17Igk9XRXcaKrcG3_MXQ.navbar__user.UserMenu-sc-1poz515-0.lkfvZn > div > label.ipc-button.ipc-button--single-padding.ipc-button--center-align-content.ipc-button--default-height.ipc-button--core-baseAlt.ipc-button--theme-baseAlt.ipc-button--on-textPrimary.ipc-text-button.navbar__flyout__text-button-after-mobile.navbar__user-menu-toggle__button > div > span")));
        String userName = driver.findElement(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > div._3x17Igk9XRXcaKrcG3_MXQ.navbar__user.UserMenu-sc-1poz515-0.lkfvZn > div > label.ipc-button.ipc-button--single-padding.ipc-button--center-align-content.ipc-button--default-height.ipc-button--core-baseAlt.ipc-button--theme-baseAlt.ipc-button--on-textPrimary.ipc-text-button.navbar__flyout__text-button-after-mobile.navbar__user-menu-toggle__button > div > span")).getText().toString();
        assertTrue(userName, userName.contains("Mart"));
    }
    @Given("I log in to IMDB app successfully on Chrome")
    public void iLogInToIMDBAppSuccessfullyonChrome() {
        iNavigateToTheIMDBHomePageOnChrome();
        clickOnSignInButton();
        clickSignInWithIMDBButtonOnSignInPage();
        i_enter_valid_credentials();
        i_should_be_taken_to_the_valid_page();
    }
    @And("I search a {string} and select")
    public void iSearchAFilmAndSelect(String film) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search")));
        driver.findElement(By.id("suggestion-search")).sendKeys(film);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-autowhatever-1--item-0 > a")));
        driver.findElement(By.cssSelector("#react-autowhatever-1--item-0 > a")).click();
    }
    @When("I click to add watch list button")
    public void iClickToAddWatchListButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.MainDetailPageLayout__StyledPageBackground-sc-13rp3wh-0.hsughJ > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__Video-sc-kvkd64-2.gVRpZB > div.Hero__ContentContainer-sc-kvkd64-10.frcskz > div.Hero__WatchContainer__Video-sc-kvkd64-5.ezpEqe > div > div > button.ipc-split-button__btn > div")));
        driver.findElement(By.cssSelector("#__next > main > div > section.ipc-page-background.ipc-page-background--base.MainDetailPageLayout__StyledPageBackground-sc-13rp3wh-0.hsughJ > section > div:nth-child(4) > section > section > div.Hero__MediaContentContainer__Video-sc-kvkd64-2.gVRpZB > div.Hero__ContentContainer-sc-kvkd64-10.frcskz > div.Hero__WatchContainer__Video-sc-kvkd64-5.ezpEqe > div > div > button.ipc-split-button__btn > div")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > div.NavWatchlistButton-sc-1b65w5j-0.dAMWXo.imdb-header__watchlist-button > a > div")));
    }
    @Then("I expect to see it in the watch list")
    public void iExpectToSeeItInTheWatchList() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > div.NavWatchlistButton-sc-1b65w5j-0.dAMWXo.imdb-header__watchlist-button > a > div")));
        driver.findElement(By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > div.NavWatchlistButton-sc-1b65w5j-0.dAMWXo.imdb-header__watchlist-button > a > div")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#page-1 > div > div > div.lister-item-content > h3 > a")));
        driver.findElement(By.cssSelector("#page-1 > div > div > div.lister-item-content > h3 > a"));
    }
    @After()
    public void quitBrowser() {
        driver.quit();
    }
}
