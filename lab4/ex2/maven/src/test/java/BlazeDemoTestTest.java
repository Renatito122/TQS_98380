// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BlazeDemoTestTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void blazeDemoTest() {
    // Test name: BlazeDemoTest
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://blazedemo.com/");
    // 2 | setWindowSize | 550x694 | 
    driver.manage().window().setSize(new Dimension(550, 694));
    // 3 | click | name=fromPort | 
    driver.findElement(By.name("fromPort")).click();
    // 4 | click | css=.form-inline:nth-child(1) > option:nth-child(1) | 
    driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(1)")).click();
    // 5 | click | name=toPort | 
    driver.findElement(By.name("toPort")).click();
    // 6 | select | name=toPort | label=London
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'London']")).click();
    }
    // 7 | click | css=.form-inline:nth-child(4) > option:nth-child(3) | 
    driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
    // 8 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 9 | click | css=tr:nth-child(4) .btn | 
    driver.findElement(By.cssSelector("tr:nth-child(4) .btn")).click();
    // 10 | click | id=inputName | 
    driver.findElement(By.id("inputName")).click();
    // 11 | type | id=inputName | Renato Dias
    driver.findElement(By.id("inputName")).sendKeys("Renato Dias");
    // 12 | click | id=address | 
    driver.findElement(By.id("address")).click();
    // 13 | type | id=address | 234 Road
    driver.findElement(By.id("address")).sendKeys("234 Road");
    // 14 | click | id=city | 
    driver.findElement(By.id("city")).click();
    // 15 | type | id=city | GeorgeTown
    driver.findElement(By.id("city")).sendKeys("GeorgeTown");
    // 16 | click | id=state | 
    driver.findElement(By.id("state")).click();
    // 17 | type | id=state | California
    driver.findElement(By.id("state")).sendKeys("California");
    // 18 | click | id=zipCode | 
    driver.findElement(By.id("zipCode")).click();
    // 19 | type | id=zipCode | 13524
    driver.findElement(By.id("zipCode")).sendKeys("13524");
    // 20 | click | id=cardType | 
    driver.findElement(By.id("cardType")).click();
    // 21 | select | id=cardType | label=American Express
    {
      WebElement dropdown = driver.findElement(By.id("cardType"));
      dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
    }
    // 22 | click | css=option:nth-child(2) | 
    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
    // 23 | click | id=creditCardNumber | 
    driver.findElement(By.id("creditCardNumber")).click();
    // 24 | type | id=creditCardNumber | 13579257
    driver.findElement(By.id("creditCardNumber")).sendKeys("13579257");
    // 25 | click | id=creditCardMonth | 
    driver.findElement(By.id("creditCardMonth")).click();
    // 26 | click | id=creditCardMonth | 
    driver.findElement(By.id("creditCardMonth")).click();
    // 27 | type | id=creditCardMonth | 12
    driver.findElement(By.id("creditCardMonth")).sendKeys("12");
    // 28 | click | id=creditCardYear | 
    driver.findElement(By.id("creditCardYear")).click();
    // 29 | type | id=creditCardYear | 2022
    driver.findElement(By.id("creditCardYear")).sendKeys("2022");
    // 30 | click | id=nameOnCard | 
    driver.findElement(By.id("nameOnCard")).click();
    // 31 | type | id=nameOnCard | Renato Dias
    driver.findElement(By.id("nameOnCard")).sendKeys("Renato Dias");
    // 32 | click | id=rememberMe | 
    driver.findElement(By.id("rememberMe")).click();
    // 33 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
  }
}
