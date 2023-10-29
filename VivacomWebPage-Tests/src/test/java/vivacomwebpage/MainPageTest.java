package vivacomwebpage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.vivacom.bg/bg");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void mobileSearch() {

        mainPage.getMobilePhoneCategory(driver);
        mainPage.filterPhoneOptions(driver);
        mainPage.appleIphonePlus.click();
        mainPage.getAppropriatePlan(driver);


        mainPage.verifyBasket(driver);

        mainPage.cartButtonContinue.click();
        mainPage.getAccessories(driver);
        mainPage.filterAccessory(driver);
        mainPage.applePhonePlusFine.click();
        mainPage.addAccToCart.click();

        mainPage.verifyBasket(driver);

        mainPage.checkSumOrder(driver);

        mainPage.verifyDisableButtons(driver);

        mainPage.verifyCheckBox(driver);

        mainPage.removeItem.click();

        mainPage.verifyTextInBasket(driver);


    }

}



