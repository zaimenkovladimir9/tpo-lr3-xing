package ru.tpo.lr3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Tag("functional")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class XingPublicTest {
    private static final Duration TIMEOUT = Duration.ofSeconds(25);

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private String browser;
    private boolean headed;

    @BeforeAll
    void setUp() {
        baseUrl = System.getProperty("baseUrl", "https://www.xing.com").replaceAll("/+$", "");
        browser = System.getProperty("browser", "chrome").toLowerCase();
        headed = Boolean.parseBoolean(System.getProperty("headed", "false"));
        createDriver();
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            quitDriver();
        }
    }

    @Test
    void homePageShowsAiJobSearchHero() {
        open("/");

        assertAnyPresent(
            "//h1[contains(normalize-space(), 'Tell the XING AI about the job you want')]",
            "//a[@aria-label='Find your next job with AI']",
            "//input[@data-testid='search-bar-fake-input']"
        );
        assertTitleContainsAny("Find the right job", "XING");
    }

    @Test
    void homeNavigationContainsFindJobs() {
        open("/");

        visible("//a[@data-testid='frame-vnav-jobs' or .//*[normalize-space()='Find jobs'] or normalize-space()='Find jobs']");
    }

    @Test
    void homeNavigationContainsCompanies() {
        open("/");

        visible("//a[@data-testid='frame-vnav-companies' or .//*[normalize-space()='Companies'] or normalize-space()='Companies']");
    }

    @Test
    void homeNavigationContainsNetwork() {
        open("/");

        visible("//a[@data-testid='frame-vnav-members' or .//*[normalize-space()='Network'] or normalize-space()='Network']");
    }

    @Test
    void homeNavigationContainsInsights() {
        open("/");

        visible("//a[@data-testid='frame-vnav-insights' or .//*[normalize-space()='Insights'] or normalize-space()='Insights']");
    }

    @Test
    void homeNavigationContainsSearch() {
        open("/");

        visible("//a[@data-testid='frame-vnav-job-search' or .//*[normalize-space()='Search'] or normalize-space()='Search']");
    }

    @Test
    void homeNavigationContainsLogin() {
        open("/");

        visible("//a[@data-testid='frame-vnav-activity-center-login-button' or @aria-label='Log in' or .//*[normalize-space()='Log in'] or normalize-space()='Log in']");
    }

    @Test
    void homeShowsPopularEmployersBlock() {
        open("/");

        visible("//*[contains(normalize-space(), 'Over 270,000 employers hiring')]");
        visible("//*[contains(normalize-space(), 'Popular employers')]");
    }

    @Test
    void homeShowsPreferenceControls() {
        open("/");

        visible("//button[.//span[normalize-space()='Your career level'] or normalize-space()='Your career level']");
        visible("//button[.//span[normalize-space()='Your workplace'] or normalize-space()='Your workplace']");
        visible("//button[.//span[normalize-space()='Salary expectations'] or normalize-space()='Salary expectations']");
        visible("//button[.//span[normalize-space()='Save preferences'] or normalize-space()='Save preferences']");
    }

    @Test
    void homeAiSearchEntryLinksToJobsSearch() {
        open("/");

        WebElement aiSearchLink = visible("//a[@aria-label='Find your next job with AI']");
        assertTrue(aiSearchLink.getDomProperty("href").contains("/jobs/search/ki"));
    }

    @Test
    void jobsSearchPageShowsAllAvailableJobsHeading() {
        open("/jobs/search/ki");

        visible("//*[self::h1 or self::h2][contains(normalize-space(), 'All available jobs')]");
    }

    @Test
    void jobsSearchPageHasLocationInput() {
        open("/jobs/search/ki");

        visible("//input[@placeholder='Location']");
    }

    @Test
    void jobsSearchPageShowsWorkplaceFilter() {
        open("/jobs/search/ki");

        assertBodyContains("Workplace");
    }

    @Test
    void jobsSearchPageShowsEmploymentTypeFilter() {
        open("/jobs/search/ki");

        assertBodyContains("Employment type");
    }

    @Test
    void jobsSearchPageShowsCareerLevelFilter() {
        open("/jobs/search/ki");

        assertBodyContains("Career level");
    }

    @Test
    void jobsSearchPageShowsSalaryFilter() {
        open("/jobs/search/ki");

        assertBodyContains("Salary");
    }

    @Test
    void jobsSearchPageListsMultipleJobCards() {
        open("/jobs/search/ki");

        assertAtLeast("//a[contains(@href, '/jobs/') and string-length(@aria-label) > 0]", 5);
    }

    @Test
    void jobsSearchPageShowsSaveJobActions() {
        open("/jobs/search/ki");

        assertAtLeast("//button[@aria-label='Save job' or .//span[normalize-space()='Save job']]", 5);
    }

    @Test
    void companiesPageShowsTopCompaniesSection() {
        open("/companies");

        visible("//*[self::h1 or self::h2][contains(normalize-space(), 'Top companies hiring now')]");
    }

    @Test
    void companiesPageShowsCompaniesByIndustrySection() {
        open("/companies");

        visible("//*[self::h1 or self::h2][contains(normalize-space(), 'Companies by industry')]");
    }

    @Test
    void companiesPageListsCompanyHeadings() {
        open("/companies");

        assertAtLeast("//*[self::h2 or self::h3][string-length(normalize-space()) > 2]", 8);
    }

    @Test
    void companiesPageListsCompanyJobLinks() {
        open("/companies");

        assertAtLeast("//a[contains(normalize-space(), 'View') and contains(normalize-space(), 'jobs')]", 5);
    }

    @Test
    void firstCompanyJobLinkPointsToCompanyJobs() {
        open("/companies");

        WebElement firstJobLink = visible("(//a[contains(normalize-space(), 'View') and contains(normalize-space(), 'jobs')])[1]");
        assertTrue(firstJobLink.getDomProperty("href").contains("/jobs"));
    }

    @Test
    void networkPageShowsJoinPrompt() {
        open("/network");

        visible("//*[contains(normalize-space(), 'Join XING now')]");
    }

    @Test
    void networkRegisterLinkPointsToLoginXing() {
        open("/network");

        WebElement registerLink = visible("//a[contains(normalize-space(), 'Register now')]");
        assertTrue(registerLink.getDomProperty("href").contains("login.xing.com"));
    }

    @Test
    void networkPageShowsLoginLink() {
        open("/network");

        visible("//a[contains(normalize-space(), 'Log in') or @aria-label='Log in']");
    }

    @Test
    void signupPageShowsHeading() {
        open("/start/signup");

        visible("//*[self::h1 or self::h2][contains(normalize-space(), 'Sign up now')]");
    }

    @Test
    void signupShowsGoogleAndAppleOptions() {
        open("/start/signup");

        visible("//a[contains(normalize-space(), 'Continue with Google')]");
        visible("//a[contains(normalize-space(), 'Continue with Apple')]");
    }

    @Test
    void signupHasFirstAndLastNameFields() {
        open("/start/signup");

        visible("//input[@name='firstName' and not(@aria-hidden='true')]");
        visible("//input[@name='lastName' and not(@aria-hidden='true')]");
    }

    @Test
    void signupHasEmailAndPasswordFields() {
        open("/start/signup");

        visible("//input[@name='email' and not(@aria-hidden='true')]");
        visible("//input[@name='password' and not(@aria-hidden='true')]");
    }

    @Test
    void signupEmptyFormMarksFirstNameInvalid() {
        openSignupAndSubmitEmptyForm();

        assertFieldInvalid("firstName");
    }

    @Test
    void signupEmptyFormMarksEmailInvalid() {
        openSignupAndSubmitEmptyForm();

        assertFieldInvalid("email");
    }

    @Test
    void signupTermsAndPrivacyLinksPresent() {
        open("/start/signup");

        visible("//a[contains(normalize-space(), 'GTC')]");
        visible("//a[contains(normalize-space(), 'Privacy Policy')]");
    }

    @Test
    void insightsShowsRecommendedCategory() {
        open("/insights");

        assertAnyPresent(
            "//*[self::h1 or self::h2][contains(normalize-space(), 'Recommended')]",
            "//*[contains(normalize-space(), 'Top picks')]",
            "//*[@data-qa='insights-entry-logged-out']"
        );
    }

    @Test
    void insightsShowsSalaryCategory() {
        open("/insights");

        assertBodyContains("Salary");
    }

    @Test
    void insightsShowsJobSearchCategory() {
        open("/insights");

        assertBodyContains("Job search");
    }

    @Test
    void insightsListsArticleLinks() {
        open("/insights");

        assertAtLeast("//a[string-length(normalize-space()) > 20]", 5);
    }

    @Test
    void jobAdCreationPageShowsHeading() {
        open("/recruiting/jobs/create?sc_cmp=oow5eb8bc92");

        visible("//*[contains(normalize-space(), 'XING Job Ads')]");
        visible("//*[contains(normalize-space(), 'Quick & easy')]");
    }

    @Test
    void jobAdCreationPageHasJobTitleAndCompanyInputs() {
        open("/recruiting/jobs/create?sc_cmp=oow5eb8bc92");

        visible("//input[@name='title']");
        visible("//input[@data-testid='company-input']");
    }

    @Test
    void jobAdCreationPageHasPreviewButton() {
        open("/recruiting/jobs/create?sc_cmp=oow5eb8bc92");

        visible("//button[.//span[normalize-space()='Preview your ad'] or normalize-space()='Preview your ad']");
    }

    private WebDriver createChromeDriver(boolean headed) {
        ChromeOptions options = new ChromeOptions();
        String chromeBinary = binaryPropertyOrDefault("chrome.binary", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        if (!chromeBinary.isBlank() && Files.exists(Path.of(chromeBinary))) {
            options.setBinary(chromeBinary);
        }
        if (!headed) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1440,1000");
        options.addArguments("--lang=en-US");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    private WebDriver createFirefoxDriver(boolean headed) {
        FirefoxOptions options = new FirefoxOptions();
        String firefoxBinary = binaryPropertyOrDefault("firefox.binary", "/Applications/Firefox.app/Contents/MacOS/firefox");
        boolean firefoxExists = !firefoxBinary.isBlank() && Files.exists(Path.of(firefoxBinary));
        Assumptions.assumeTrue(firefoxExists, "Firefox is not installed in this environment.");
        options.setBinary(firefoxBinary);
        if (!headed) {
            options.addArguments("-headless");
        }
        options.addArguments("--width=1440");
        options.addArguments("--height=1000");
        return new FirefoxDriver(options);
    }

    private void createDriver() {
        driver = switch (browser) {
            case "chrome" -> createChromeDriver(headed);
            case "firefox" -> createFirefoxDriver(headed);
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    private void restartDriver() {
        quitDriver();
        createDriver();
    }

    private void quitDriver() {
        try {
            driver.quit();
        } catch (RuntimeException ignored) {
            // Browser may already be closed by the OS, user, or driver crash.
        }
    }

    private String binaryPropertyOrDefault(String propertyName, String defaultPath) {
        String configured = System.getProperty(propertyName, "");
        if (!configured.isBlank()) {
            return configured;
        }
        return defaultPath;
    }

    private void open(String path) {
        try {
            driver.get(baseUrl + path);
            waitReady();
        } catch (NoSuchSessionException e) {
            restartDriver();
            driver.get(baseUrl + path);
            waitReady();
        } catch (WebDriverException e) {
            if (isInvalidSession(e)) {
                restartDriver();
                driver.get(baseUrl + path);
                waitReady();
                return;
            }
            throw e;
        }
    }

    private boolean isInvalidSession(WebDriverException e) {
        String message = e.getMessage();
        return message != null && message.toLowerCase().contains("invalid session");
    }

    private void waitReady() {
        wait.until(page -> js().executeScript("return document.readyState").toString().matches("interactive|complete"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));
        closeCookieBannerIfPresent();
    }

    private void closeCookieBannerIfPresent() {
        clickUsercentricsButtonIfPresent();
        for (String xpath : List.of(
            "//button[normalize-space()='Accept all']",
            "//button[normalize-space()='Accept All']",
            "//button[normalize-space()='Agree']",
            "//button[contains(normalize-space(),'Accept')]",
            "//button[contains(normalize-space(),'Allow all')]"
        )) {
            try {
                WebElement button = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                button.click();
                return;
            } catch (RuntimeException ignored) {
                // Cookie banners are regional and may be absent.
            }
        }
        removeBlockingConsentOverlay();
    }

    private void clickUsercentricsButtonIfPresent() {
        js().executeScript("""
            const host = document.querySelector('#usercentrics-cmp-ui');
            const root = host && host.shadowRoot ? host.shadowRoot : document;
            const buttons = Array.from(root.querySelectorAll('button'));
            const acceptButton = buttons.find((button) => /accept|allow|agree/i.test(button.textContent || ''));
            if (acceptButton) {
              acceptButton.click();
            }
        """);
    }

    private void removeBlockingConsentOverlay() {
        js().executeScript("""
            document
              .querySelectorAll('#usercentrics-cmp-ui, [data-testid="uc-app-container"], .uc-overlay')
              .forEach((element) => element.remove());
            document.body.style.overflow = 'visible';
        """);
    }

    private WebElement visible(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void assertAnyPresent(String... xpaths) {
        for (String xpath : xpaths) {
            if (!elements(xpath).isEmpty()) {
                return;
            }
        }
        throw new AssertionError("Expected at least one present element for XPath variants: " + String.join(" | ", xpaths));
    }

    private List<WebElement> elements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    private void assertAtLeast(String xpath, int minCount) {
        assertTrue(elements(xpath).size() >= minCount, "Expected at least " + minCount + " elements for XPath: " + xpath);
    }

    private void assertBodyContains(String expectedText) {
        String pageText = driver.findElement(By.xpath("//body")).getText();
        assertTrue(pageText.contains(expectedText), "Page text must contain: " + expectedText);
    }

    private void assertTitleContainsAny(String... expectedParts) {
        String title = driver.getTitle();
        for (String expectedPart : expectedParts) {
            if (title.contains(expectedPart)) {
                return;
            }
        }
        throw new AssertionError("Page title '" + title + "' must contain one of: " + String.join(", ", expectedParts));
    }

    private void openSignupAndSubmitEmptyForm() {
        open("/start/signup");
        closeCookieBannerIfPresent();
        WebElement submitButton = visible("//button[.//span[normalize-space()='Next'] or normalize-space()='Next']");
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        submitButton.click();
    }

    private void assertFieldInvalid(String fieldName) {
        WebElement field = visible("//input[@name='" + fieldName + "' and not(@aria-hidden='true')]");
        Boolean isValid = (Boolean) js().executeScript("return arguments[0].validity.valid;", field);
        String validationMessage = (String) js().executeScript("return arguments[0].validationMessage;", field);
        assertFalse(isValid, "Field must be invalid: " + fieldName);
        assertFalse(validationMessage.isBlank(), "Validation message must not be empty: " + fieldName);
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) driver;
    }
}
