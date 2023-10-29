package vivacomwebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class MainPage {

    @FindBy(xpath = "//div[@class='e-shop-devices-product-details-phone-grid-box'][.//img[@alt='APPLE IPHONE 15 PLUS 128GB']]")
    public WebElement appleIphonePlus;

    @FindBy(xpath = "//a[@class='see-more']")
    public WebElement cartButtonContinue;

    @FindBy(xpath = "//div[@class='e-shop-devices-product-details-phone-grid-box'][.//img[@alt='APPLE iPhone 15 Plus FineWoven Taupe']]")
    public WebElement applePhonePlusFine;

    @FindBy(xpath = "//*[@id=\"faciaDataHighResView\"]/div[4]/div[1]/button")
    public WebElement addAccToCart;

    @FindBy(xpath = "//em[contains(@class, 'vivacom-icons')]")
    public WebElement removeItem;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getMobilePhoneCategory(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();

        WebElement device = driver.findElement(By.xpath("//*[@id=\"main-big-menu\"]/li[2]/a"));
        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"main-big-menu\"]/li[2]/ul/li[1]/div/div[2]/a"));

        device.click();
        mobile.click();
    }

    public void filterPhoneOptions(WebDriver driver) {
        WebElement labelApple = driver.findElement((By.xpath("//label[.//input[@val='APPLE']]")));
        WebElement labelBlue = driver.findElement(By.xpath("//label[.//input[@val='BLUE']]"));

        labelApple.click();
        labelBlue.click();
    }

    public void getAppropriatePlan(WebDriver driver) {
        WebElement colorBlue = driver.findElement(By.xpath("//span[contains(@style, '#003366')]"));
        WebElement buttonUnlimited300 = driver.findElement(By.xpath("/html/body/div[30]/div[4]/div[2]/div[3]/div[2]"));
        WebElement buttonUnlimitedPayDevice = driver.findElement(By.xpath("//*[@id=\"relatedOfferDiv-epc_cfi230105161710184106_so_olr230914134624687999\"]/div[3]/div[2]/div[1]/label/span[2]"));
        WebElement chooseServiceType = driver.findElement(By.xpath("//*[@id='xSellBtn']"));
        WebElement addToCart = driver.findElement(By.xpath("/html/body/div[29]/div/div/form/div[2]/div[4]/div[1]/button/span"));

        colorBlue.click();
        buttonUnlimited300.click();
        buttonUnlimitedPayDevice.click();
        chooseServiceType.click();
        addToCart.click();

    }

    public void getAccessories(WebDriver driver) {
        WebElement device = driver.findElement(By.xpath("/html/body/nav/div[3]/div/div/ul/div[1]/div[2]/li/a"));
        WebElement accessories = driver.findElement(By.xpath("//*[@id=\"vivacom-devices-navbar\"]/ul/li[1]/ul/div[6]/li/div/div[2]/a"));

        device.click();
        accessories.click();

    }

    public void filterAccessory(WebDriver driver) {
        WebElement labelApple = driver.findElement((By.xpath("//label[.//input[@val='APPLE']]")));
        WebElement labelPriceOver40 = driver.findElement((By.xpath("//label[.//input[@val='price-more-than-forty']]")));

        labelApple.click();
        labelPriceOver40.click();
    }

    public void verifyBasket(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        String title = driver.getTitle();
        String expectedTitle = "Кошница | VIVACOM";
        Assert.assertEquals(title, expectedTitle);
    }

    public void checkSumOrder(WebDriver driver) {
        WebElement total = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/aside/div[1]/div/div[4]/span[2]"));

        String price = total.getText().replace("лв.", "");
        double sum = Double.parseDouble(price);

        if (sum > 1900) {

            WebElement deleteCase = driver.findElement(By.xpath("//em[contains(@class, 'vivacom-icons')]"));
            deleteCase.click();
        }
    }

    public void verifyDisableButtons(WebDriver driver) {
        WebElement client = driver.findElement(By.xpath("//div[@data-widget='2876962483225389488']"));
        WebElement newClient = driver.findElement(By.xpath("//div[@data-widget='2876959325892468592']"));


        client.click();
        Assert.assertTrue(client.isEnabled());
        newClient.click();
        Assert.assertTrue(newClient.isEnabled());
    }

    public void verifyCheckBox(WebDriver driver) {
        WebElement check = driver.findElement(By.xpath("//em[contains(@class, 'icon-box_empty')]"));
        check.isEnabled();
        check.click();

    }

    public void verifyTextInBasket(WebDriver driver) {
        WebElement messageOne = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/div/div/section/div/div/h3"));
        WebElement messageTwo = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/div/div/section/div/div/p"));
        String messageHeader = messageOne.getText();
        String messageParagraph = messageTwo.getText();
        String expectedHeader = "В момента кошницата ви е празна";
        String expectedParagraph = "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".";

        Assert.assertEquals(messageHeader, expectedHeader);
        Assert.assertEquals(messageParagraph, expectedParagraph);

    }

}






