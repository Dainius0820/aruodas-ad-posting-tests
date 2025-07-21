import org.example.Helper;
import org.example.models.Apartment;
import org.example.models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void beforeMethod() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNumBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void apartNumBlankTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FApartNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNum0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "0", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNum1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum9_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "9999", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum10_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "10000", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "-15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumDecimalPointTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15.5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumStartsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(1) + "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumEndsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15" + RealEstate.generateRndLetters(1), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNumLettersOnlyTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(2), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumInternationalizedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "十五", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1" + RealEstate.generateRndSpecialChars(1) + "5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingWhitespaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", " 15 ", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "pardodu chata", "crib for seil", "a????", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", 4, 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }


}
