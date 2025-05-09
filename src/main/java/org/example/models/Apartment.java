package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Apartment extends RealEstate {
    public String apartNum;

    public boolean showApartNum;

    public String squareMeters;

    public int roomNum;

    public int apartFloor;

    public int buildingFloor;

    public boolean enterCustomFloors;

    public boolean isElevator;

    public String buildYear;

    public boolean isRenovated;

    public String renovatedYear;

    public int houseType;

    public int houseState;

    public int[] warmSystems;

    public int apartType;

    public int apartIntendance;

    public int[] windows_direction;

    public int house_efficiency;

    public Apartment(String region, String district, String quartal, String street, String objNum, boolean showObjNum, String rcNum, boolean showRcNum, String[] specials, boolean interestedChange, boolean forAuction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dont_show_in_ads, boolean dont_want_chat, int accountType, boolean agree_to_rules, String apartNum, boolean showApartNum, String squareMeters, int roomNum, int apartFloor, int buildingFloor, boolean enterCustomFloors, boolean isElevator, String buildYear, boolean isRenovated, String renovatedYear, int houseType, int houseState, int[] warmSystems, int apartType, int apartIntendance, int[] windows_direction, int house_efficiency) {
        super(region, district, quartal, street, objNum, showObjNum, rcNum, showRcNum, specials, interestedChange, forAuction, notes_lt, notes_en, notes_ru, photos, video, tour3d, price, phone, email, dont_show_in_ads, dont_want_chat, accountType, agree_to_rules);
        this.apartNum = apartNum;
        this.showApartNum = showApartNum;
        this.squareMeters = squareMeters;
        this.roomNum = roomNum;
        this.apartFloor = apartFloor;
        this.buildingFloor = buildingFloor;
        this.enterCustomFloors = enterCustomFloors;
        this.isElevator = isElevator;
        this.buildYear = buildYear;
        this.isRenovated = isRenovated;
        this.renovatedYear = renovatedYear;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystems = warmSystems;
        this.apartType = apartType;
        this.apartIntendance = apartIntendance;
        this.windows_direction = windows_direction;
        this.house_efficiency = house_efficiency;
    }

    @Override
    public void fill() {
        super.fill();
        this.fillApartNum();
        this.fillShowApartNum();
        this.fillSquareMeters();
        this.fillRoomNum();
        this.fillApartBuildingFloor();
        this.fillIsElevator();
        this.fillBuildYear();
        this.fillIsRenovated();
        this.fillHouseType();
        this.fillHouseState();
        this.fillWarmSystems();
        this.fillApartType();
        this.fillWindows_direction();
        this.fillHouse_efficiency();
        this.driver.findElement(By.id("submitFormButton")).click();
    }

    private void fillApartNum() {
        this.driver.findElement(By.name("FApartNum")).sendKeys(this.apartNum);
    }

    private void fillShowApartNum() {
        if (!this.showApartNum) {
            this.driver.findElement(By.xpath("//label[@for='cbshow_apart_num']")).click();
        }
    }

    private void fillSquareMeters() {
        this.driver.findElement(By.name("FAreaOverAll")).sendKeys(this.squareMeters);
    }

    private void fillRoomNum() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='FRoomNum']")).findElements(By.xpath(".//*[@data-value]"));
        switch (this.roomNum) {
            case 1:
                inputValues.getFirst().click();
                break;
            case 2:
                inputValues.get(1).click();
                break;
            case 3:
                inputValues.get(2).click();
                break;
            case 4:
                inputValues.get(3).click();
                break;
            default:
                this.driver.findElement(By.xpath(".//span[contains(@class,'input-style-text-unit')]//input[@type='text']")).sendKeys(Integer.toString(this.roomNum));
        }
    }

    private void fillApartBuildingFloor() {
        if(this.enterCustomFloors || this.apartFloor > 4 || this.buildingFloor > 9) {
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//li[contains(@class,'manual-value-row')]//input")).sendKeys(Integer.toString(this.apartFloor), Keys.ENTER);

            this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//li[contains(@class,'manual-value-row')]//input")).sendKeys(Integer.toString(this.buildingFloor), Keys.ENTER);
        } else {
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            List<WebElement> floorOptions = this.driver.findElements(By.xpath("//li[@id='fieldRow_FFloor']//ul[contains(@class,'dropdown-input-values')]/li[@data-value]"));
            switch (this.apartFloor) {
               case 1:
                   floorOptions.getFirst().click();
                   break;
               case 2:
                   floorOptions.get(1).click();
               case 3:
                   floorOptions.get(2).click();
               case 4:
                   floorOptions.get(3).click();
           }
           this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
           List<WebElement> heightOptions = this.driver.findElements(By.xpath("//div[@id='fieldRow_FHouseHeight']//ul[contains(@class,'dropdown-input-values')]/li[@data-value]"));
           switch (this.buildingFloor) {
               case 1:
                   heightOptions.getFirst().click();
                   break;
               case 2:
                   heightOptions.get(1).click();
                   break;
               case 3:
                   heightOptions.get(2).click();
                   break;
               case 4:
                   heightOptions.get(3).click();
                   break;
               case 5:
                   heightOptions.get(4).click();
                   break;
               case 6:
                   heightOptions.get(5).click();
                   break;
               case 7:
                   heightOptions.get(6).click();
                   break;
               case 8:
                   heightOptions.get(7).click();
                   break;
               case 9:
                   heightOptions.get(8).click();
                   break;
           }

        }
    }

    private void fillIsElevator() {
        if (this.isElevator) {
            this.driver.findElement(By.className("cbelevator_label")).click();
        }
    }

    private void fillBuildYear() {
        this.driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear);
    }

    private void fillIsRenovated() {
        if (this.isRenovated) {
            this.driver.findElement(By.className("cbrenovated_label")).click();
            this.driver.findElement(By.name("FRenovatedYear")).sendKeys(this.renovatedYear);
        }
    }

    private void fillHouseType() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='FHouseType']")).findElements(By.xpath(".//*[@data-value]"));
        switch (this.houseType) {
            case 1:
                inputValues.getFirst().click();
                break;
            case 2:
                inputValues.get(1).click();
                break;
            case 3:
                inputValues.get(2).click();
                break;
            case 4:
                inputValues.get(3).click();
                break;
            case 5:
                inputValues.get(4).click();
                break;
            case 6:
                inputValues.get(5).click();
                break;
            case 7:
                inputValues.get(6).click();
                break;
            case 8:
                inputValues.get(7).click();
                break;
        }
    }

    private void fillHouseState() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='FHouseState']")).findElements(By.xpath(".//*[@data-value]"));
        switch (this.houseType) {
            case 1:
                inputValues.getFirst().click();
                break;
            case 2:
                inputValues.get(1).click();
                break;
            case 3:
                inputValues.get(2).click();
                break;
            case 4:
                inputValues.get(3).click();
                break;
            case 5:
                inputValues.get(4).click();
                break;
            case 6:
                inputValues.get(5).click();
                break;
        }
    }

    private void fillWarmSystems() {
        List<WebElement> warmSystems = this.driver.findElements(By.xpath("//input[@name='FWarmSystem[]']/following-sibling::label"));
        for (int i = 0; i < this.warmSystems.length ; i++) {
            switch (this.warmSystems[i]) {
                case 1:
                    warmSystems.getFirst().click();
                    break;
                case 2:
                    warmSystems.get(1).click();
                    break;
                case 3:
                    warmSystems.get(2).click();
                    break;
                case 4:
                    warmSystems.get(3).click();
                    break;
                case 5:
                    warmSystems.get(4).click();
                    break;
                case 6:
                    warmSystems.get(5).click();
                    break;
                case 7:
                    warmSystems.get(6).click();
                    break;
                case 8:
                    warmSystems.get(7).click();
                    break;
                case 9:
                    warmSystems.get(8).click();
                    break;
                case 10:
                    warmSystems.get(9).click();
                    break;
            }
        }
    }

    private void fillApartType() {
        if(this.apartType == 1) {
            return;
        }

        this.driver.findElement(By.xpath("//div[@data-key='ApartmentType']//div[@data-value='" + this.apartType + "']")).click();
        wait(500);

        if(this.apartType == 2) {
            this.driver.findElement(By.xpath("//div[@data-key='ApartmentIntendance']//div[@data-value='" + this.apartIntendance + "']")).click();
        }
    }

    private void fillWindows_direction() {
        List<WebElement> windowsDirections = this.driver.findElements(By.xpath("//input[@name='windows_direction[]']/following-sibling::label"));
        for (int i = 0; i < this.windows_direction.length ; i++) {
            switch (this.windows_direction[i]) {
                case 1:
                    windowsDirections.getFirst().click();
                    break;
                case 2:
                    windowsDirections.get(1).click();
                    break;
                case 3:
                    windowsDirections.get(2).click();
                    break;
                case 4:
                    windowsDirections.get(3).click();
                    break;
            }
        }
    }

    private void fillHouse_efficiency() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='house_efficiency']")).findElements(By.xpath(".//*[@data-value]"));
        switch (this.houseType) {
            case 1:
                inputValues.getFirst().click();
                break;
            case 2:
                inputValues.get(1).click();
                break;
            case 3:
                inputValues.get(2).click();
                break;
            case 4:
                inputValues.get(3).click();
                break;
            case 5:
                inputValues.get(4).click();
                break;
            case 6:
                inputValues.get(5).click();
                break;
            case 7:
                inputValues.get(6).click();
                break;
            case 8:
                inputValues.get(7).click();
                break;
            case 9:
                inputValues.get(8).click();
        }
    }
}
