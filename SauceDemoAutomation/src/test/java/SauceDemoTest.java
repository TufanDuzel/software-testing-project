import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SauceDemoTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Unit Test 01: Standard User Login Verification")
    public void testStandardUserLogin() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement header = driver.findElement(By.className("title"));
        String actualHeaderText = header.getText();

        Assertions.assertEquals("Products", actualHeaderText, "Login failed or header text mismatch!");

        if (actualHeaderText.equals("Products")) {
            System.out.println("LOG: Unit Test Passed. User successfully redirected to Products page.");
        }
    }

    @Test
    @DisplayName("Unit Test 02: Inventory Display Verification")
    public void testInventoryVisibility() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean isInventoryVisible = driver.findElement(By.id("inventory_container")).isDisplayed();

        Assertions.assertTrue(isInventoryVisible, "Inventory container is not visible!");

        if (isInventoryVisible) {
            System.out.println("LOG: Unit Test Passed. Inventory list is visible for the user.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}