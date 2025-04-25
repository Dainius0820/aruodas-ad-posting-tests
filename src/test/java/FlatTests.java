import org.example.models.Flat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlatTests {
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    public void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void positiveTest() {
        Flat flat = new Flat();
        flat.fill();
        String actual = "";
        Assert.assertEquals(actual, "");
    }
}
