package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Apartment extends RealEstate {

    public String aptNum;
    public boolean showAptNum;
    public String squareMeters;
    public String roomNum;
    public String aptFloor;
    public String buildingFloor;
    public boolean enterCustomFloors;
    public boolean isElevator;
    public String buildYear;
    public boolean isRenovated;
    public String renovatedYear;
    public String houseType;
    public String houseState;
    public String[] warmSystems;
    public int aptType;
    public int aptIntendance;
    public String[] windowsDirection;
    public String houseEfficiency;

    public Apartment(String region, String district, String quartal, String street, String objNum, boolean showObjNum, String rcNum, boolean showRcNum, String[] specials, boolean interestedChange, boolean forAuction, String notesLt, String notesEn, String notesRu, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dontShowInAds, boolean dontWantChat, String accountType, boolean agreeToRules, String aptNum, boolean showAptNum, String squareMeters, String roomNum, String aptFloor, String buildingFloor, boolean enterCustomFloors, boolean isElevator, String buildYear, boolean isRenovated, String renovatedYear, String houseType, String houseState, String[] warmSystems, int aptType, int aptIntendance, String[] windowsDirection, String houseEfficiency) {
        super(region, district, quartal, street, objNum, showObjNum, rcNum, showRcNum, specials, interestedChange, forAuction, notesLt, notesEn, notesRu, photos, video, tour3d, price, phone, email, dontShowInAds, dontWantChat, accountType, agreeToRules);
        this.aptNum = aptNum;
        this.showAptNum = showAptNum;
        this.squareMeters = squareMeters;
        this.roomNum = roomNum;
        this.aptFloor = aptFloor;
        this.buildingFloor = buildingFloor;
        this.enterCustomFloors = enterCustomFloors;
        this.isElevator = isElevator;
        this.buildYear = buildYear;
        this.isRenovated = isRenovated;
        this.renovatedYear = renovatedYear;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystems = warmSystems;
        this.aptType = aptType;
        this.aptIntendance = aptIntendance;
        this.windowsDirection = windowsDirection;
        this.houseEfficiency = houseEfficiency;
    }

    @Override
    public void fill() {
        this.fillAllFields();
        this.driver.findElement(By.id("submitFormButton")).click();
    }

    public void fillAllFields() {
        super.fill();
        this.fillAptNum();
        this.fillShowAptNum();
        this.fillSquareMeters();
        this.fillRoomNum();
        this.fillAptBuildingFloor();
        this.fillIsElevator();
        this.fillBuildYear();
        this.fillIsRenovated();
        this.fillHouseType();
        this.fillHouseState();
        this.fillWarmSystems();
        this.fillAptType();
        this.fillWindowsDirection();
        this.fillHouseEfficiency();
    }

    public void fillAptNum() {
        this.driver.findElement(By.name("FApartNum")).sendKeys(this.aptNum);
    }

    public void fillShowAptNum() {
        if (!this.showAptNum) {
            this.driver.findElement(By.xpath("//label[@for='cbshow_apart_num']")).click();
        }
    }

    public void fillSquareMeters() {
        this.driver.findElement(By.name("FAreaOverAll")).sendKeys(this.squareMeters);
    }

    public void fillRoomNum() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='FRoomNum']")).findElements(By.xpath(".//*[@data-value]"));
        switch (this.roomNum) {
            case "1" -> inputValues.getFirst().click();
            case "2" -> inputValues.get(1).click();
            case "3" -> inputValues.get(2).click();
            case "4" -> inputValues.get(3).click();
            default -> {
                WebElement input = this.driver.findElement(By.xpath("//*[@data-key='FRoomNum']//span[contains(@class,'input-style-text-unit')]//input[@type='text']"));
                input.clear();
                input.sendKeys(this.roomNum);
                input.sendKeys(Keys.TAB);
            }
        }
    }

    public void fillAptBuildingFloor() {
        if (this.enterCustomFloors || !isValidDropdown()) {
            fillViaManualInput();
        } else {
            fillViaDropdown();
        }
    }

    public boolean isValidDropdown() {
        try {
            int a = Integer.parseInt(this.aptFloor.trim());
            int b = Integer.parseInt(this.buildingFloor.trim());
            return a >= 1 && a <= 4 && b >= a && b <= a + 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void fillViaManualInput() {
        driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
        wait(500);
        WebElement aptInput = driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//li[contains(@class,'manual-value-row')]//input"));
        aptInput.clear();
        aptInput.sendKeys(this.aptFloor, Keys.ENTER);

        wait(500);

        driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
        wait(500);
        WebElement buildingInput = driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//li[contains(@class,'manual-value-row')]//input"));
        buildingInput.clear();
        buildingInput.sendKeys(this.buildingFloor, Keys.ENTER);

        wait(500);
    }

    public void fillViaDropdown() {
        driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
        wait(500);
        List<WebElement> aptOptions = driver.findElements(By.xpath("//li[@id='fieldRow_FFloor']//ul/li[@data-value]"));
        for (WebElement option : aptOptions) {
            if (option.getDomAttribute("data-value").equals(this.aptFloor)) {
                option.click();
                break;
            }
        }

        wait(500);

        driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
        wait(500);
        List<WebElement> buildingOptions = driver.findElements(By.xpath("//div[@id='fieldRow_FHouseHeight']//ul/li[@data-value]"));
        for (WebElement option : buildingOptions) {
            if (option.getText().trim().equals(this.buildingFloor)) {
                option.click();
                break;
            }
        }

        wait(500);
    }

    public void fillIsElevator() {
        if (this.isElevator) {
            this.driver.findElement(By.className("cbelevator_label")).click();
        }
    }

    public void fillBuildYear() {
        this.driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear, Keys.TAB);
    }

    public void fillIsRenovated() {
        if (this.isRenovated) {
            this.driver.findElement(By.className("cbrenovated_label")).click();
            this.driver.findElement(By.name("FRenovatedYear")).sendKeys(this.renovatedYear);
        }
    }

    public void fillHouseType() {
        driver.findElement(By.xpath("//div[contains(translate(normalize-space(@data-title), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.houseType) + "')]")).click();
    }

    public void fillHouseState() {
        driver.findElement(By.xpath("//div[contains(translate(normalize-space(@data-title), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.houseState) + "')]")).click();
    }

    public void fillWarmSystems() {
        for (int i = 0; i < this.warmSystems.length; i++) {
            driver.findElement(By.xpath("//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.warmSystems[i]) + "')]")).click();
        }
    }

    public void fillAptType() {
        if(this.aptType == 1) {
            return;
        }

        this.driver.findElement(By.xpath("//div[@data-key='ApartmentType']//div[@data-value='" + this.aptType + "']")).click();
        wait(500);

        if(this.aptType == 2) {
            this.driver.findElement(By.xpath("//div[@data-key='ApartmentIntendance']//div[@data-value='" + this.aptIntendance + "']")).click();
        }
    }

    public void fillWindowsDirection() {
        for (int i = 0; i < this.windowsDirection.length; i++) {
            driver.findElement(By.xpath("//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.windowsDirection[i]) + "')]")).click();
        }
    }

    public void fillHouseEfficiency() {
        driver.findElement(By.xpath("//div[contains(translate(normalize-space(@data-title), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + normalizeInput(this.houseEfficiency) + "')]")).click();
    }
}
