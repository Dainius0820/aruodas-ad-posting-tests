import org.example.Helper;
import org.example.models.Plot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PlotTests {
    public static WebDriver driver;
    
    @BeforeClass
    public void setUp(){
        Helper.setUp();
        driver = Helper.driver;
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
    }

    @Test
    public void positiveTest(){
        Plot plot = new Plot("Vilnius","Vilniaus m.","Baltupiai","Goštauto","15",true,"1111-1111-1111:11111",true,new String[]{"Greta miško", "Elektra", "Su pakrante"},false,false,"pardodu plota","plot for seil","a?????",new String[]{"plotas.jpg"},"https://www.youtube.com/watch?v=-nWYn6XB6Hg","tour3d.com","10000","+37061111111","standard@gmail.com",true,true,1,true,"45",new int[]{1,3,7});
        plot.fill();
        String actual = "";
        Assert.assertEquals(actual, "");
    }
}
