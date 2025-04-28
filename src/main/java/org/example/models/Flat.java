package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Flat {

    public WebDriver driver;

    public String region;

    public String district;

    public String quartal;

    public String street;

    public String objNum;

    public String flatNum;

    public String rcNum;

    public String flatSize;

    public int roomNum;

    public int floor;

    public int objHeight;

    public boolean enterCustomFloors;

    public boolean isElevator;

    public String buildYear;

    public boolean isRenovated;

    public int houseType;

    public int houseState;

    public int[] warmSystems;

    public int objType;

    public int[] windows_direction;

    public int[] specials;

    public int house_efficiency;

    public boolean interestedChange;

    public boolean forAuction;

    public String notes_lt;

    public String notes_en;

    public String notes_ru;

    public String[] photos;

    public String video;

    public String tour3d;

    public String price;

    public String phone;

    public String email;

    public boolean cbdont_show_in_ads;

    public boolean cbdont_want_chat;

    public int accountType;

    public boolean cbagree_to_rules;


    public Flat() {
    }

    public Flat(WebDriver driver, String region, String district, String quartal, String street, String objNum, String flatNum,
                String rcNum, String flatSize, int roomNum, int floor, int objHeight, boolean enterCustomFloors, boolean isElevator,
                String buildYear, boolean isRenovated, int houseType, int houseState, int[] warmSystems, int objType, int[] windows_direction,
                int[] specials, int house_efficiency, boolean interestedChange, boolean forAuction, String notes_lt, String notes_en, String notes_ru,
                String[] photos, String video, String tour3d, String price, String phone, String email, boolean cbdont_show_in_ads,
                boolean cbdont_want_chat, int accountType, boolean cbagree_to_rules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.flatNum = flatNum;
        this.rcNum = rcNum;
        this.flatSize = flatSize;
        this.roomNum = roomNum;
        this.floor = floor;
        this.objHeight = objHeight;
        this.enterCustomFloors = enterCustomFloors;
        this.isElevator = isElevator;
        this.buildYear = buildYear;
        this.isRenovated = isRenovated;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystems = warmSystems;
        this.objType = objType;
        this.windows_direction = windows_direction;
        this.specials = specials;
        this.house_efficiency = house_efficiency;
        this.interestedChange = interestedChange;
        this.forAuction = forAuction;
        this.notes_lt = notes_lt;
        this.notes_en = notes_en;
        this.notes_ru = notes_ru;
        this.photos = photos;
        this.video = video;
        this.tour3d = tour3d;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.cbdont_show_in_ads = cbdont_show_in_ads;
        this.cbdont_want_chat = cbdont_want_chat;
        this.accountType = accountType;
        this.cbagree_to_rules = cbagree_to_rules;
    }

    public void fill() {
        this.fillRegion();
        this.fillDistrict();
        this.fillQuartal();
        this.fillStreet();
        this.fillObjNum();
        this.fillFlatNum();
        this.fillRcNum();
        this.fillFlatSize();
        this.fillRoomNum();
        this.fillFloorObjHeight();
        this.fillIsElevator();
        this.fillBuildYear();
        this.fillIsRenovated();
        this.fillHouseType();
        this.fillHouseState();
        this.fillWarmSystems();
        this.fillObjType();
        this.fillWindows_direction();
        this.fillSpecials();
        this.fillHouse_efficiency();
        this.fillInterestedChange();
        this.fillForAuction();
        this.fillNotes_lt();
        this.fillNotes_en();
        this.fillNotes_ru();
        this.fillPhotos();
        this.fillVideo();
        this.fillTour3d();
        this.fillPrice();
        this.fillPhone();
        this.fillEmail();
        this.fillCbDont_show_in_ads();
        this.fillCbDont_want_chat();
        this.fillAccountType();
        this.fillCbAgree_to_rules();
    }

    private void fillRegion() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(this.region);
        wait(300);
        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(Keys.ENTER);
    }

    private void fillDistrict() { //padaryti veliau
//        this.driver.findElements(By.className("dropdown-input-value-title")).get(1).click();
//        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(this.region);
//        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(Keys.ENTER);
    }
    private void fillQuartal() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        this.driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(this.quartal);//veliau reikes korekciju
        wait(2000);
        this.driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(Keys.ENTER);
    }

    private void fillStreet() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(200);
        this.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(this.street);//veliau reikes korekciju
        wait(500);
        this.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    private void fillObjNum() {
        this.driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    private void fillFlatNum() {
        this.driver.findElement(By.name("FApartNum")).sendKeys(this.flatNum);
    }

    private void fillRcNum() {
        this.driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillFlatSize() {
        this.driver.findElement(By.name("FAreaOverAll")).sendKeys(this.flatSize);
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

    private void fillFloorObjHeight() {
        if(this.enterCustomFloors || this.floor > 4 || this.objHeight > 9) {
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//li[contains(@class,'manual-value-row')]//input")).sendKeys(Integer.toString(this.floor), Keys.ENTER);

            this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//li[contains(@class,'manual-value-row')]//input")).sendKeys(Integer.toString(this.objHeight), Keys.ENTER);
        } else {
            this.driver.findElement(By.xpath("//li[@id='fieldRow_FFloor']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
            List<WebElement> floorOptions = this.driver.findElements(By.xpath("//li[@id='fieldRow_FFloor']//ul[contains(@class,'dropdown-input-values')]/li[@data-value]"));
            switch (this.floor) {
               case 1:
                   floorOptions.getFirst().click();
                   break;
               case 2:
                   floorOptions.get(1).click();
               case 3:
                   floorOptions.get(2).click();
               case 4:
                   floorOptions.get(3).click();
                default:
                    break;
           }
           this.driver.findElement(By.xpath("//div[@id='fieldRow_FHouseHeight']//span[contains(@class,'input-right-dropdown')]")).click();
            wait(500);
           List<WebElement> heightOptions = this.driver.findElements(By.xpath("//div[@id='fieldRow_FHouseHeight']//ul[contains(@class,'dropdown-input-values')]/li[@data-value]"));
           switch (this.objHeight) {
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

    public void fillIsRenovated() {
        if (this.isRenovated) {
            this.driver.findElement(By.className("cbrenovated_label")).click();
        }
    }

    public void fillHouseType() {
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
            default:
                break;
        }
    }

    public void fillHouseState() {
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
            default:
                break;
        }
    }

    public void fillWarmSystems() {
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
                default:
                    break;
            }
        }
    }

    public void fillObjType() {
        List<WebElement> inputValues = this.driver.findElement(By.xpath("//*[@data-key='ApartmentType']")).findElements(By.xpath(".//*[@data-value]"));
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
            default:
                break;
        }
    }

    public void fillWindows_direction() {
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
                default:
                    break;
            }
        }
    }

    public void fillSpecials() {
        this.driver.findElement(By.id("showMoreFields")).click();
        List<WebElement> specials = this.driver.findElements(By.xpath("//input[@name='Special[]']/following-sibling::label"));
        for (int i = 0; i < this.specials.length; i++) {
            switch (this.specials[i]){
                case 1:
                    specials.getFirst().click();
                    break;
                case 2:
                    specials.get(1).click();
                    break;
                case 3:
                    specials.get(2).click();
                    break;
                case 4:
                    specials.get(3).click();
                    break;
                case 5:
                    specials.get(4).click();
                    break;
                case 6:
                    specials.get(5).click();
                    break;
                case 7:
                    specials.get(6).click();
                    break;
                case 8:
                    specials.get(7).click();
                    break;
                case 9:
                    specials.get(8).click();
                    break;
                case 10:
                    specials.get(9).click();
                    break;
                case 11:
                    specials.get(10).click();
                    break;
                case 12:
                    specials.get(11).click();
                    break;
                case 13:
                    specials.get(12).click();
                    break;
                case 14:
                    specials.get(13).click();
                    break;
                case 15:
                    specials.get(14).click();
                    break;
                case 16:
                    specials.get(15).click();
                    break;
                case 17:
                    specials.get(16).click();
                    break;
                case 18:
                    specials.get(17).click();
                    break;
                case 19:
                    specials.get(18).click();
                    break;
                case 20:
                    specials.get(19).click();
                    break;
                case 21:
                    specials.get(20).click();
                    break;
                case 22:
                    specials.get(21).click();
                    break;
                case 23:
                    specials.get(22).click();
                    break;
                case 24:
                    specials.get(23).click();
                    break;
                case 25:
                    specials.get(24).click();
                    break;
                case 26:
                    specials.get(25).click();
                    break;
                case 27:
                    specials.get(26).click();
                    break;
                case 28:
                    specials.get(27).click();
                    break;
                case 29:
                    specials.get(28).click();
                    break;
                case 30:
                    specials.get(29).click();
                    break;
                case 31:
                    specials.get(30).click();
                    break;
                case 32:
                    specials.get(31).click();
                    break;
                case 33:
                    specials.get(32).click();
                    break;
                case 34:
                    specials.get(33).click();
                    break;
                case 35:
                    specials.get(34).click();
                    break;
                case 36:
                    specials.get(35).click();
                    break;
                case 37:
                    specials.get(36).click();
                    break;
                default:
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
            default:
                break;
        }
    }

    private void fillInterestedChange() {
        if (this.interestedChange) {
            this.driver.findElement(By.cssSelector("label[for='cbInterestedChange']")).click();
        }
    }

    private void fillForAuction() {
        if (this.forAuction) {
            this.driver.findElement(By.cssSelector("label[for='cbAuction']")).click();
        }
    }

    private void fillNotes_lt() {
        this.driver.findElement(By.cssSelector("label[for='langLt']")).click();
        this.driver.findElement(By.name("notes_lt")).sendKeys(this.notes_lt);
    }

    private void fillNotes_en(){
        this.driver.findElement(By.cssSelector("label[for='langEn']")).click();
        this.driver.findElement(By.name("notes_en")).sendKeys(this.notes_en);
    }

    private void fillNotes_ru(){
        this.driver.findElement(By.cssSelector("label[for='langRu']")).click();
        this.driver.findElement(By.name("notes_ru")).sendKeys(this.notes_ru);
    }

    private void fillPhotos() {
        String base = "C:\\Users\\daini\\IdeaProjects\\aruodasTest\\src\\test\\resources\\images\\";
        String[] abs = new String[this.photos.length];
        for (int i = 0; i < this.photos.length; i++) {
            abs[i] = base + this.photos[i];
        }
        this.driver.findElement(By.xpath("//a[@id='uploadPhotoBtn']//input[@type='file']")).sendKeys(String.join("\n", abs));
    }

    private void fillVideo() {
        this.driver.findElement(By.name("Video")).sendKeys(this.video);
    }

    private void fillTour3d() {
        this.driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);
    }

    private void fillPrice() {
        this.driver.findElement(By.id("priceField")).sendKeys(this.price);
    }

    private void fillPhone() {
        this.driver.findElement(By.name("phone")).clear();
        this.driver.findElement(By.name("phone")).sendKeys(this.phone);
    }

    private void fillEmail() {
        this.driver.findElement(By.name("email")).sendKeys(this.email);
    }

    private void fillCbDont_show_in_ads() {
        if (this.cbdont_show_in_ads) {
            this.driver.findElement(By.cssSelector("label[for='cbdont_show_in_ads']")).click();
        }
    }

    private void fillCbDont_want_chat() {
        if (this.cbdont_want_chat) {
            this.driver.findElement(By.cssSelector("label[for='cbdont_want_chat']")).click();
        }
    }

    private void fillAccountType() {
        switch(this.accountType){
            case 1:
                this.driver.findElement(By.cssSelector("div.input-button[data-value='1'][data-title='Privatus asmuo']")).click();
                break;
            case 2:
                this.driver.findElement(By.cssSelector("div.input-button[data-value='2'][data-title='Tarpininkas']")).click();
                break;
            case 3:
                this.driver.findElement(By.cssSelector("div.input-button[data-value='3'][data-title='Vystytojas/statytojas']")).click();
                break;
            case 4:
                this.driver.findElement(By.cssSelector("div.input-button[data-value='4'][data-title='Kitas verslo subjektas']")).click();
                break;
            default:
                break;
        }
    }

    private void fillCbAgree_to_rules() {
        if (this.cbagree_to_rules) {
            this.driver.findElement(By.xpath("//label[@for='cbagree_to_rules']//span")).click();
        }
    }

    public void wait (int time) {
        try{
            Thread.sleep(time);
        }catch (Exception e){}
    }

}
