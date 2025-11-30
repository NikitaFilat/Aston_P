package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MtsPaymentFrame {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final By IFRAME = By.className("bepaid-iframe");
    private static final By PHONE_LABEL = By.cssSelector(".pay-info-row_phone .pay-info-row__value");
    private static final By SUM_LABEL = By.cssSelector(".pay-info-row_sum .pay-info-row__value");
    private static final By BUTTON_PAY = By.cssSelector("button.payment-form__btn");
    private static final By INPUT_CARD = By.cssSelector("input#card-number"); // Критичен для ожидания!
    private static final By INPUT_DATE = By.cssSelector("input#card-expiry");
    private static final By INPUT_CVC = By.cssSelector("input#card-cvc");
    private static final By ICONS = By.cssSelector(".payment-system-icons");

    public MtsPaymentFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME));

        wait.until(ExpectedConditions.presenceOfElementLocated(INPUT_CARD));

    }

    public void switchToMain() {
        driver.switchTo().defaultContent();
    }

    public String getPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_LABEL)).getText();
    }

    public String getSum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_LABEL)).getText();
    }

    public String getButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_PAY)).getText();
    }

    public String getCardPlaceholder() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(INPUT_CARD)).getAttribute("placeholder");
    }

    public String getDatePlaceholder() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(INPUT_DATE)).getAttribute("placeholder");
    }

    public String getCVCPlaceholder() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(INPUT_CVC)).getAttribute("placeholder");
    }

    public List<WebElement> getIcons() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(ICONS)).findElements(By.tagName("img"));
    }
}