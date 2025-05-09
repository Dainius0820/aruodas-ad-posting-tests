import org.example.Helper;
import org.example.models.Apartment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApartmentTests {
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        Helper.setUp();
        driver = Helper.driver;
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveTest() {
        Apartment apartment = new Apartment("Vilnius","Vilniaus m.","Baltupiai","Goštauto","15",true,"1111-1111-1111:1111",true,new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"},true,true,"pardodu chata","crib for seil","a????",new String[]{"chata.jpg"},"https://www.youtube.com/watch?v=gB2_xBz3_QQ","https://tour3d.lt/baltupiai/butas16/","500000","+37060011111","standard@gmail.com",true,true,1,true,"16",true,"150",4,8,9,true,true,"2025",true,"2025",1,1,new int[]{1},2,1,new int[]{4},1);
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e){}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

}
