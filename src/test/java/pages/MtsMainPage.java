package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MtsMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final By BLOCK_TITLE = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    public static final By PAY_PARTNERS = By.cssSelector(".pay-partners");
    public static final By MORE_INFO_LINK = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    public static final By COOKIE_BUTTON = By.xpath("//button[contains(text(), 'Принять')]");
    private static final By BUTTON_CONTINUE = By.xpath("//button[contains(text(), 'Продолжить')]");
    private static final By INPUT_PHONE = By.id("connection-phone");
    private static final By INPUT_SUM = By.id("connection-sum");

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void acceptCookies() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(COOKIE_BUTTON));
            System.out.println("Cookie banner found, clicking accept...");
            cookie.click();
            wait.until(ExpectedConditions.invisibilityOf(cookie));
            System.out.println("Cookie banner closed");
        } catch (TimeoutException e) {
            System.out.println("Cookie banner not found or already accepted");
        }
    }

    public void enterMobileData(String phone, String sum) {
        System.out.println("Entering phone: " + phone + " and sum: " + sum);


        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement sumInput = wait.until(ExpectedConditions.elementToBeClickable(INPUT_SUM));
        sumInput.clear();
        sumInput.sendKeys(sum);

        System.out.println("Data entered successfully");
    }

    public void clickContinue() {
        try {

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(BUTTON_CONTINUE));
            System.out.println("Continue button found: " + continueButton.getText());
            System.out.println("Button enabled: " + continueButton.isEnabled());
            System.out.println("Button displayed: " + continueButton.isDisplayed());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
            System.out.println("Continue button clicked successfully");

        } catch (TimeoutException e) {
            System.err.println("Continue button not found by text 'Продолжить'");

            List<WebElement> allButtons = driver.findElements(By.tagName("button"));
            WebElement continueBtn = allButtons.stream()
                    .filter(btn -> btn.getText().contains("Продолжить"))
                    .findFirst()
                    .orElse(null);

            if (continueBtn != null) {
                System.out.println("Found alternative continue button: " + continueBtn.getText());
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
                System.out.println("Alternative continue button clicked");
            } else {
                System.err.println("No continue button found at all");
                throw e;
            }
        }
    }

    public String getPhonePlaceholder() {
        return getPlaceholderSafely(INPUT_PHONE, "Номер телефона");
    }

    public String getSumPlaceholder() {
        return getPlaceholderSafely(INPUT_SUM, "Сумма");
    }

    private String getPlaceholderSafely(By locator, String defaultValue) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            String placeholder = element.getAttribute("placeholder");
            return placeholder != null ? placeholder : defaultValue;
        } catch (TimeoutException e) {
            System.err.println("Element not found for placeholder: " + locator);
            return defaultValue;
        }
    }
}