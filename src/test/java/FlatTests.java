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
        Flat flat = new Flat(driver,"Vilnius","Vilniaus m.","Baltupiai","Goštauto","15",
                "16","1111-1111-1111","150",4,8,9,false,
                true,"2025",false,6,1,new int[]{3},1,new int[]{1},
                new int[]{2,5,9,10,13,16,19,20,23,24,27,31,32,33,34,36},1,false,false,
                "pardodu chata", "crib for seil","a????", new String[]{"chata.jpg"},"https://www.youtube.com/watch?v=gB2_xBz3_QQ",
                "tour3d.com","2000000","+37061111111","ne@tavo.reikalas",true,
                true,1,true);
        flat.fill();
        String actual = "";
        Assert.assertEquals(actual, "");
    }
}
