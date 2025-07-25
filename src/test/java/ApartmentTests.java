import org.example.Helper;
import org.example.models.Apartment;
import org.example.models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void beforeTest() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    @Test
    public void positiveTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumBlankTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void objNum0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "0", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNum1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum9_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "9999", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNum10_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "10000", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "-15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumDecimalPointTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15.5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumStartsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(1) + "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumEndsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15" + RealEstate.generateRndLetters(1), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void objNumLettersOnlyTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", RealEstate.generateRndLetters(2), true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumInternationalizedTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "十五", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "1" + RealEstate.generateRndSpecialChars(1) + "5", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void objNumContainingWhitespaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", " 15 ", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FHouseNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the house-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void apartNum0Test() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "0", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNum1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "1", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void apartNum9_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "9999", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void apartNum10_000Test() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "10000", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumNegativeTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "-16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumDecimalPointTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16.5", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumStartsWithLetterTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, RealEstate.generateRndLetters(1).toUpperCase() + "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumEndsWithLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16" + RealEstate.generateRndLetters(1).toUpperCase(), true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void apartNumLettersOnlyTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, RealEstate.generateRndLetters(2).toUpperCase(), true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumInternationalizedTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "十六", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumContainingSpecialCharTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "1" + RealEstate.generateRndSpecialChars(1) + "6", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
    public void apartNumContainingWhiteSpaceTest() {
        String beforeUrl = driver.getCurrentUrl();
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16 ", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
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
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNum17DigitsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:11113", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actualValue, "1111-1111-1111:1111", "RC-number field should allow only 16 digits.");
    }

    @Test
    public void rcNumNoSeparatorsTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111111111111111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actualValue, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNumTrailingColonTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumExtraDashTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "11-11-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actualValue, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNum2ConsecutiveDashesTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111--1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actualValue, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void rcNumContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111" + RealEstate.generateRndLetters(1), true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumLettersOnlyTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "aaaa-aaaa-aaaa:aaaa", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:111" + RealEstate.generateRndSpecialChars(1), true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='RCNumber']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the RC-number error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void rcNumContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-11 11:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("RCNumber")).getDomProperty("value");
        Assert.assertEquals(actualValue, "1111-1111-1111:1111", "RC-number field should auto-format the input into xxxx-xxxx-xxxx:xxxx using the JavaScript input handler.");
    }

    @Test
    public void squareMeters0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "0", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMeters1Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "1", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMeters9_999_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "9999999", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMeters10_000_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "10000000", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "001", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "-150", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actualValue, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersInvalidDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "0,9", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FAreaOverAll']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the apartment size error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void squareMetersValidDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150,5", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void squareMetersContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150" + RealEstate.generateRndLetters(1), "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actualValue, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "15" + RealEstate.generateRndSpecialChars(1) + "0", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actualValue, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void squareMetersContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "15 0", "4", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FAreaOverAll")).getDomProperty("value");
        Assert.assertEquals(actualValue, "150", "Apartment size field should normalize the input to '150' using the JavaScript handler.");
    }

    @Test
    public void roomNum0Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "0", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNum99_999_999_999_999Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "99999999999999", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//span[normalize-space(.)='Paslaugų paketo pasirinkimas']")).getText().trim();
        } catch (Exception e) {}
        Assert.assertEquals(actual, "Paslaugų paketo pasirinkimas", "After submitting the ad form, user should land on the plan-selection page.");
    }

    @Test
    public void roomNum100_000_000_000_000Test() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "100000000000000", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumLeadingZerosTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "004", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumNegativeTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "-5", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actualValue, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumDecimalTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "4,5", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fill();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FRoomNum']/ancestor::li//span[contains(@class,'error-arrow')]")));
        } catch (TimeoutException e) {
            Assert.fail("Expected the number of rooms error arrow, but none appeared (user was redirected).");
        }
    }

    @Test
    public void roomNumContainingLetterTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "5" + RealEstate.generateRndLetters(1), 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actualValue, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumContainingSpecialCharTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", "5" + RealEstate.generateRndSpecialChars(1), 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actualValue, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }

    @Test
    public void roomNumContainingWhiteSpaceTest() {
        Apartment apartment = new Apartment("Vilnius", "Vilniaus m.", "Baltupiai", "Goštauto", "15", true, "1111-1111-1111:1111", true, new String[]{"Aukštos lubos", "Drabužinė", "Su baldais", "Šarvuotos durys"}, true, true, "Parduodu butą", "Apartment for sale", "Квартира на продажу", new String[]{"butas.jpg"}, "https://www.youtube.com/watch?v=gB2_xBz3_QQ", "https://tour3d.lt/baltupiai/butas16/", "500000", "+37060011111", "standard@gmail.com", true, true, "Privatus asmuo", true, "16", true, "150", " 5", 8, 9, true, true, "2025", true, "2025", "Mūrinis", "Įrengtas", new String[]{"Kita", "Elektra", "Saulės Energija"}, 2, 1, new String[]{"Šiaurė"}, "A++");
        apartment.fillAllFields();
        String actualValue = driver.findElement(By.name("FRoomNum")).getDomProperty("value");
        Assert.assertEquals(actualValue, "5", "Number of rooms field should normalize the input to '5' using the JavaScript handler.");
    }



























}
