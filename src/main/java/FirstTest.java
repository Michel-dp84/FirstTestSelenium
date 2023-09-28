import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class FirstTest {
    String Mobile_Service_URL = "https://next.privat24.ua/payments/dashboard";
    String IBAN = "UA333510050000026005325079000";
    String OKPO = "532507901";
    String FIO_1 = "Olovar Mykhailo";
    String FIO_2 = "OMV";
    String USER_CARD_NUMBER = "4567739561253907";
    By query = By.xpath("//input[@data-qa-node='query']");
    By button = By.xpath("//div[@id='app']/div[2]/section/div/div/div[2]/div[2]/div/div[2]/a/div/button");
    By FIO_sender = By.xpath("//textarea[@name='FIO']");
    By FIO_recipient = By.xpath("//textarea[@name='CUSTOM_COMPANY']");
    By CUSTOM_OKPO = By.xpath("//textarea[@name='CUSTOM_OKPO']");
    By Purpose_of_Payment = By.xpath("//textarea[@name='DEST']");
    By amount = By.xpath("//input[@name='SUM']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By first_name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By last_name = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submit = By.xpath("//div[@id='app']/div[2]/section/div/div/div[3]/div/form/div[9]/div[2]/button");
    By button_2 = By.xpath("//div[@id='app']/div[2]/section/div/div/div[2]/div/div[8]/div[2]/button");
    By expectedAmount = By.xpath("//div[@data-qa-node='amount']");
    By expectedCommission = By.xpath("//span[@data-qa-node='commission']");

    @Test
    public void checkMinPaymentSum(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(Mobile_Service_URL);
        driver.findElement(query).sendKeys(IBAN);
        driver.findElement(button).click();
        driver.findElement(FIO_sender).sendKeys(FIO_1);
        driver.findElement(FIO_recipient).sendKeys(FIO_2);
        driver.findElement(CUSTOM_OKPO).sendKeys(OKPO);
        driver.findElement(Purpose_of_Payment).sendKeys("повітря");
        driver.findElement(amount).sendKeys("1");
        driver.findElement(cardNumber).sendKeys(USER_CARD_NUMBER);
        driver.findElement(expDate).sendKeys("09/24");
        driver.findElement(cvv).sendKeys("528");
        driver.findElement(first_name).sendKeys("Taras");
        driver.findElement(last_name).sendKeys("Shevchenko");
        driver.findElement(submit).submit();
        driver.findElement(button_2).click();

        Assert.assertEquals("1 UAH", driver.findElement(expectedAmount).getText());
        Assert.assertEquals("3", driver.findElement(expectedCommission).getText());
   }
}
