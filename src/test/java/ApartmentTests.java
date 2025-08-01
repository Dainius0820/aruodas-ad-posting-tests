import org.example.Helper;
import org.example.models.Apartment;
import org.example.models.RealEstate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class ApartmentTests {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        Helper.setUp();
        driver = Helper.driver;
        wait = Helper.wait;
    }

    @BeforeMethod
    public void beforeTest() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveApartmentAdFormTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNumBlankTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected without providing the house number.");
    }

    @Test
    public void aptNumBlankTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected without providing the apartment number.");
    }

    @Test
    public void rcNumBlankTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected without providing the RC number.");
    }

    @Test
    public void squareMetersBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li[contains(@class, 'has-error')]//span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Įveskite bendrą plotą", "Unexpected error message for apartment size field.");
    }

    @Test
    public void roomNumBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='FRoomNum']/ancestor::li//span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Įveskite kambarių sk.", "Unexpected error message for room number field.");
    }

    @Test
    public void aptFloorBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fieldRow_FFloor']//div[contains(@class, 'col')][1]//span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Įveskite aukštą", "Unexpected error message for apartment floor field.");
    }

    @Test
    public void buildingFloorBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Įveskite aukštų sk.", "Unexpected error message for building floor field.");
    }

    @Test
    public void buildYearBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FBuildYear']/following::span[@class='error-arrow'][1]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Įveskite statybos metus", "Unexpected error message for build year field.");
    }

    @Test
    public void renovatedYearBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRenovatedYear']/following::span[@class='error-arrow'][1]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Klaida. Netinkami metai", "Unexpected error message for renovated year field.");
    }

    @Test
    public void houseTypeBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='FHouseType']/following-sibling::span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Pasirinkite pastato tipą", "Unexpected error message for house type field.");
    }

    @Test
    public void houseStateBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='FHouseState']/following-sibling::span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Pasirinkite įrengimą", "Unexpected error message for house state field.");
    }

    @Test
    public void warmSystemsBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{""}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[span[text()='Šildymas']]/span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(actual, "Privalomas", "Unexpected error message for heating systems field.");
    }

    @Test
    public void windowsDirectionBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{""}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "0", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNum1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum9_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "9999", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum10_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "10000", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "-15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumDecimalPointTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15.5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumStartsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(1) + "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumEndsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15" + RealEstate.generateRndLetters(1), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNumLettersOnlyTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(2), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumInternationalizedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "十五", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1" + RealEstate.generateRndSpecialChars(1) + "5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingWhitespaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", " 15 ", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void aptNum0Test() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "0", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNum1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "1", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptNum9_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "9999", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptNum10_000Test() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "10000", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumNegativeTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "-16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumDecimalPointTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16.5", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumStartsWithLetterTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, RealEstate.generateRndLetters(1).toUpperCase() + "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumEndsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16" + RealEstate.generateRndLetters(1).toUpperCase(), true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptNumLettersOnlyTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, RealEstate.generateRndLetters(2).toUpperCase(), true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumInternationalizedTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "十六", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumContainingSpecialCharTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "1" + RealEstate.generateRndSpecialChars(1) + "6", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void aptNumContainingWhiteSpaceTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16 ", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean redirected;
        try {
            redirected = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(beforeUrl)));
        } catch (TimeoutException e) {
            redirected = false;
        }
        Assert.assertFalse(redirected, "User should NOT be redirected with invalid apartment number input.");
    }

    @Test
    public void rcNum15DigitsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNum17DigitsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:11113", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actual, "1111-1111-1111:1111", "RC-number field should allow only 16 digits.");
    }

    @Test
    public void rcNumNoSeparatorsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111111111111111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actual, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNumTrailingColonTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumExtraDashTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "11-11-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actual, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNum2ConsecutiveDashesTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111--1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actual, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNumContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111" + RealEstate.generateRndLetters(1), true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumLettersOnlyTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "aaaa-aaaa-aaaa:aaaa", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111" + RealEstate.generateRndSpecialChars(1), true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-11 11:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actual, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void squareMeters0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "0", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMeters1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "1", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMeters9_999_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "9999999", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMeters10_000_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "10000000", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "001", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "-150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actual, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersInvalidDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "0,9", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersValidDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150,5", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMetersContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150" + RealEstate.generateRndLetters(1), "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actual, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "15" + RealEstate.generateRndSpecialChars(1) + "0", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actual, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "15 0", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actual, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void roomNum0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "0", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNum99_999_999_999_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "99999999999999", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void roomNum100_000_000_000_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "100000000000000", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "004", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "-5", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actual, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4,5", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "5" + RealEstate.generateRndLetters(1), "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actual, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "5" + RealEstate.generateRndSpecialChars(1), "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actual, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", " 5", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actual, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void aptBuildingNormalDropdownSelectionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "2", "5", false, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptBuildingUpperLimitDropdownTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "4", "12", false, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void buildingFloorDropdownUpdateTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class, 'input-right-dropdown')]")).click();
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='fieldRow_FHouseHeight']//ul/li[@data-value]")));
        List<String> optionsTexts = options.stream().map(WebElement::getText).map(String::trim).filter(text -> !text.isEmpty()).toList();
        int actual = Integer.parseInt(optionsTexts.getFirst());
        Assert.assertEquals(actual, 8, "Building floor dropdown should start at apartment floor (8)");
    }

    @Test
    public void aptFloorEqualsBuildingFloorTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "6", "6", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptHigherThanBuildingFloorTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "5", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'error-arrow') and not(contains(@class, 'hide'))]")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Aukštų sk. negali būti mažesnis nei aukštas", "Error message should be shown when building floor is lower than apartment floor");
    }

    @Test
    public void aptBuildingFloor0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "0", "0", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void unrealisticBuildingFloorValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "1000000", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'error-arrow')]")).getDomAttribute("class");
        } catch (Exception e) {}
        Assert.assertFalse(actual.contains("hide"), "Expected error message to be visible for unrealistically high floor value, but it remains hidden.");
    }

    @Test
    public void unrealisticApartmentFloorValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "1000000", "1000001", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'error-arrow')]")).getDomAttribute("class");
        } catch (Exception e) {}
        Assert.assertFalse(actual.contains("hide"), "Expected error message to be visible for unrealistically high floor value, but it remains hidden.");
    }

    @Test
    public void aptFloorLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "008", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fieldRow_FFloor']//div[contains(@class, 'col')][1]//span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment floor error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void buildingFloorLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "009", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the building floor error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void aptFloorNegativeValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "-8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FFloor")).getDomProperty("value");
        Assert.assertEquals(actual, "8", "Apartment floor field should normalize the input to '8' using the JavaScript handler.");
    }

    @Test
    public void buildingFloorNegativeValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "-9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FHouseHeight")).getDomProperty("value");
        Assert.assertEquals(actual, "9", "Building floor field should normalize the input to '9' using the JavaScript handler.");
    }

    @Test
    public void aptFloorDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "0,8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fieldRow_FFloor']//div[contains(@class, 'col')][1]//span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment floor error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void buildingFloorDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9,9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the building floor error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void aptFloorContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8" + RealEstate.generateRndLetters(1), "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FFloor")).getDomProperty("value");
        Assert.assertEquals(actual, "8", "Apartment floor field should normalize the input to '8' using the JavaScript handler.");
    }

    @Test
    public void buildingFloorContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9" + RealEstate.generateRndLetters(1), true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FHouseHeight")).getDomProperty("value");
        Assert.assertEquals(actual, "9", "Building floor field should normalize the input to '9' using the JavaScript handler.");
    }

    @Test
    public void aptFloorContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8" + RealEstate.generateRndSpecialChars(1), "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FFloor")).getDomProperty("value");
        Assert.assertEquals(actual, "8", "Apartment floor field should normalize the input to '8' using the JavaScript handler.");
    }

    @Test
    public void buildingFloorContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9" + RealEstate.generateRndSpecialChars(1), true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FHouseHeight")).getDomProperty("value");
        Assert.assertEquals(actual, "9", "Building floor field should normalize the input to '9' using the JavaScript handler.");
    }

    @Test
    public void aptFloorContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", " 8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FFloor")).getDomProperty("value");
        Assert.assertEquals(actual, "8", "Apartment floor field should normalize the input to '8' using the JavaScript handler.");
    }

    @Test
    public void buildingFloorContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", " 9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FHouseHeight")).getDomProperty("value");
        Assert.assertEquals(actual, "9", "Building floor field should normalize the input to '9' using the JavaScript handler.");
    }

    @Test
    public void buildRenovatedSameYearTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void renovatedBeforeBuildYearTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2025", true, "2000", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRenovatedYear']/following::span[@class='error-arrow'][1]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the renovated year error arrow, but none appeared.");
        }
    }

    @Test
    public void buildYear999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "999", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FBuildYear']/following::span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the build year error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void renovatedYear999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "974", true, "999", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRenovatedYear']/following::span[@class='error-arrow'][1]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the renovated year error arrow, but none appeared.");
        }
    }

    @Test
    public void buildYear1_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "1000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void renovatedYear1_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "975", true, "1000", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        boolean isErrorVisible;
        try {
            WebElement errorElement = driver.findElement(By.xpath("//input[@name='FRenovatedYear']/following::span[@class='error-arrow'][1]"));
            isErrorVisible = errorElement.isDisplayed();
        } catch (Exception e) {
            isErrorVisible = false;
        }
        Assert.assertFalse(isErrorVisible, "Unexpected error message for renovated year field.");
    }

    @Test
    public void buildYear2_075Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2075", true, "2100", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        try {
            WebElement errorElement = driver.findElement(By.xpath("//input[@name='FBuildYear']/following::span[contains(@class, 'error-arrow')]"));
            Assert.assertFalse(errorElement.isDisplayed(), "Unexpected error message for build year field.");
        } catch (Exception e) {
        }
    }

    @Test
    public void renovatedYear2_075Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2075", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void buildYear2_076Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2076", true, "2101", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FBuildYear']/following::span[contains(@class, 'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the build year error arrow, but none appeared.");
        }
    }

    @Test
    public void renovatedYear2_076Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2075", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRenovatedYear']/following::span[@class='error-arrow'][1]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the renovated year error arrow, but none appeared.");
        }
    }

    @Test
    public void buildYearNegativeValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "-2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FBuildYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2000", "Build year field should normalize the input to '2000' using the JavaScript handler.");
    }

    @Test
    public void renovatedYearNegativeValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "-2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRenovatedYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2025", "Renovated year field should normalize the input to '2025' using the JavaScript handler.");
    }

    @Test
    public void buildYearDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000,5", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FBuildYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2000", "Build year field should normalize the input to '2000' using the JavaScript handler.");
    }

    @Test
    public void renovatedYearDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025,5", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRenovatedYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2025", "Renovated year field should normalize the input to '2025' using the JavaScript handler.");
    }

    @Test
    public void buildYearContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000" + RealEstate.generateRndLetters(1), true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FBuildYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2000", "Build year field should normalize the input to '2000' using the JavaScript handler.");
    }

    @Test
    public void renovatedYearContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025" + RealEstate.generateRndLetters(1), "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRenovatedYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2025", "Renovated year field should normalize the input to '2025' using the JavaScript handler.");
    }

    @Test
    public void buildYearContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000" + RealEstate.generateRndSpecialChars(1), true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FBuildYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2000", "Build year field should normalize the input to '2000' using the JavaScript handler.");
    }

    @Test
    public void renovatedYearContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025" + RealEstate.generateRndSpecialChars(1), "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRenovatedYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2025", "Renovated year field should normalize the input to '2025' using the JavaScript handler.");
    }

    @Test
    public void buildYearContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, " 2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FBuildYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2000", "Build year field should normalize the input to '2000' using the JavaScript handler.");
    }

    @Test
    public void renovatedYearContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, " 2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actual = driver.findElement(By.name("FRenovatedYear")).getDomProperty("value");
        Assert.assertEquals(actual, "2025", "Renovated year field should normalize the input to '2025' using the JavaScript handler.");
    }

    @Test
    public void houseTypeSwitchSelectionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.houseType = "Medinis";
        apartment.fillHouseType();
        String actual = driver.findElement(By.name("FHouseType")).getDomProperty("value");
        Assert.assertEquals(actual, "wood", "FHouseType should be set to 'wood' after selecting 'Medinis'");
    }

    @Test
    public void houseTypeClickSameOptionTwiceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.houseType = "Mūrinis";
        apartment.fillHouseType();
        String actual = driver.findElement(By.xpath("//div[@data-key='FHouseType']//div[@data-title='" + apartment.houseType + "']")).getDomAttribute("data-selected");
        Assert.assertEquals(actual, "0", "House type 'Mūrinis' should be deselected after clicking it twice.");
    }

    @Test
    public void houseTypeErrorDisappearsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        apartment.houseType = "Mūrinis";
        apartment.fillHouseType();
        String actual = driver.findElement(By.xpath("//div[@data-key='FHouseType']/following-sibling::span[contains(@class, 'error-arrow')]")).getDomAttribute("class");
        Assert.assertEquals(actual, "error-arrow hide", "Error message should have 'hide' class after valid selection.");
    }

    @Test
    public void houseStateSwitchSelectionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.houseState = "Nebaigtas statyti";
        apartment.fillHouseState();
        String actual = driver.findElement(By.name("FHouseState")).getDomProperty("value");
        Assert.assertEquals(actual, "n_finished", "FHouseState should be set to 'n_finished' after selecting 'Nebaigtas statyti'");
    }

    @Test
    public void houseStateClickSameOptionTwiceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.houseState = "Įrengtas";
        apartment.fillHouseState();
        String actual = driver.findElement(By.xpath("//div[@data-key='FHouseState']//div[@data-title='" + apartment.houseState + "']")).getDomAttribute("data-selected");
        Assert.assertEquals(actual, "0", "House state 'Įrengtas' should be deselected after clicking it twice.");
    }

    @Test
    public void houseStateErrorDisappearsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.houseState = "Įrengtas";
        apartment.fillHouseState();
        String actual = driver.findElement(By.xpath("//div[@data-key='FHouseState']/following-sibling::span[contains(@class, 'error-arrow')]")).getDomAttribute("class");
        Assert.assertEquals(actual, "error-arrow hide", "Error message should have 'hide' class after valid selection.");
    }

    @Test
    public void warmSystemsOneValidOptionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Centrinis"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void warmSystemsAllOptionsSelectedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Centrinis", "Elektra", "Skystu kuru", "Centrinis kolektorinis", "Geoterminis", "Aeroterminis", "Dujinis", "Kietu kuru", "Saulės energija", "Kita"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void warmSystemsDeselectOptionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Centrinis"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.warmSystems = new String[] {"Centrinis"};
        apartment.fillWarmSystems();
        WebElement checkbox = driver.findElement(By.id("cb_FWarmSystem_central"));
        Assert.assertFalse(checkbox.isSelected(), "'Centrinis' should be deselected");
    }

    @Test
    public void warmSystemsErrorDisappearsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{""}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        apartment.warmSystems = new String[] {"Kita", "Elektra", "Saulės Energija"};
        apartment.fillWarmSystems();
        String actual = driver.findElement(By.xpath("//label[span[text()='Šildymas']]/span[contains(@class, 'error-arrow')]")).getDomAttribute("class");
        Assert.assertEquals(actual, "error-arrow hide", "Error message should have 'hide' class after valid selection.");
    }

    @Test
    public void aptTypePreselectedValueTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 1, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void aptTypeWithoutIntendanceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++") {
            @Override
            public void fillAptType() {
                driver.findElement(By.xpath("//div[@data-key='ApartmentType']//div[@data-value='2']")).click();
            }
        };
        apartment.fill();
        String actual = "";
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key='ApartmentIntendance']/following-sibling::span[contains(@class, 'error-arrow')]")));
            actual = errorElement.getText().trim();
        } catch (TimeoutException e) {}
        Assert.assertEquals(actual, "Privalomas", "Validation error should be visible for missing apartment intendance.");
    }

    @Test
    public void aptTypeHideIntendanceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        driver.findElement(By.xpath("//div[@data-key='ApartmentType']//div[@data-value='1']")).click();
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'apart_intendance_row')]")).getDomAttribute("class");
        Assert.assertEquals(actual, "apart_intendance_row hide", "Apartment intendance row should be hidden after switching back to 'Butas'.");
    }

    @Test
    public void windowsDirectionDeselectOptionTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        apartment.windowsDirection = new String[] {"Šiaurė"};
        apartment.fillWindowsDirection();
        WebElement checkbox = driver.findElement(By.id("cb_windows_direction_n"));
        Assert.assertFalse(checkbox.isSelected(), "'Šiaurė' should be deselected");
    }

    @Test
    public void windowsDirectionAllOptionsSelectedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė", "Vakarai", "Pietūs", "Rytai"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void windowsDirectionAllArrowsHighlightedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė", "Vakarai", "Pietūs", "Rytai"}, "A++");
        apartment.fillAllFields();
        for (String dir : new String[]{"n", "e", "s", "w"}) {
            WebElement arrow = driver.findElement(By.id("arrow_" + dir));
            String actual = arrow.getDomAttribute("class");
            Assert.assertNotEquals(actual, "arrow invisible", "Arrow for direction '" + dir + "' should be visible.");
        }
    }

    @Test
    public void windowsDirectionClickCompassArrowTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", "8", "9", true, true, "2000", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{""}, "A++");
        apartment.fillAllFields();
        for (String dir : new String[] {"n", "e", "s", "w"}) {
            driver.findElement(By.id("arrow_" + dir)).click();
            WebElement checkbox = driver.findElement(By.id("cb_windows_direction_" + dir));
            Assert.assertTrue(checkbox.isSelected(), "Checkbox for '" + dir + "' should be selected after clicking zone.");
        }
    }

    






















}
