import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsWebTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mts.by");

        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("cookie__ok")));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already closed");
        }
    }

    @Test
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {

        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'pay__wrapper')]//h2")
        ));

        String actualText = blockTitle.getText().trim().replace("\n", " ");

        assertTrue(actualText.contains("Онлайн пополнение без комиссии"),
                "Заголовок блока не совпадает. Фактический: " + actualText);
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {

        WebElement partnersBlock = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".pay__partners ul")
        ));

        List<WebElement> logos = partnersBlock.findElements(By.tagName("img"));

        assertTrue(logos.size() > 0, "Логотипы платежных систем не найдены");

        boolean hasVisa = false;
        for (WebElement logo : logos) {
            String src = logo.getAttribute("src");
            if (src != null && src.toLowerCase().contains("visa")) {
                hasVisa = true;
                break;
            }
        }
        assertTrue(hasVisa, "Логотип Visa не найден среди партнеров");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Подробнее о сервисе")
        ));

        link.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("poryadok-oplaty"),
                "Переход по ссылке не произошел, текущий URL: " + currentUrl);
    }

    @Test
    @DisplayName("Заполнение полей и проверка кнопки 'Продолжить' (Услуги связи)")
    public void testPaymentForm() {

        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("connection-phone")));
        phoneInput.click(); // Фокус на поле
        phoneInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys("10"); // Тестовая сумма

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("form#pay-connection button.button__default")
        ));
        continueButton.click();

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

            assertTrue(true);
        } catch (Exception e) {

            System.out.println("Платежный фрейм не загрузился. Проверьте валидацию полей.");
            throw e;
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}