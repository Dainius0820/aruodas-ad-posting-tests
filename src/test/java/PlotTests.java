import org.example.models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class PlotTests {
    public static WebDriver driver;
    
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    public void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void positiveTest(){
        Plot plot = new Plot(driver,"Vilnius","Vilniaus m.","Baltupiai","Goštauto","15",
                "1111-1111-1111","45",new int[]{1,3,7},new int[]{1,3,7},false,false,
                "pardodu plota", "plot for seil", "a?????",new String[]{"plotas.jpg"},
                "https://www.youtube.com/watch?v=-nWYn6XB6Hg","tour3d.com","1000","+37061111111",
                "ne@tavo.reikalas",false,true,1,true);
        plot.fill();
        String actual = "";
        Assert.assertEquals(actual, "");
    }
}
