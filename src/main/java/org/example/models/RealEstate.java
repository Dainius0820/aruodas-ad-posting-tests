package org.example.models;
import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RealEstate {

    public WebDriver driver;

    public String region;
    public String district;
    public String quartal;
    public String street;
    public String objNum;
    public boolean showObjNum;
    public String rcNum;
    public boolean showRcNum;
    public String[] specials;
    public boolean interestedChange;
    public boolean forAuction;
    public String notesLt;
    public String notesEn;
    public String notesRu;
    public String[] photos;
    public String video;
    public String tour3d;
    public String price;
    public String phone;
    public String email;
    public boolean dontShowInAds;
    public boolean dontWantChat;
    public String accountType;
    public boolean agreeToRules;

    public RealEstate() {
    }

    public RealEstate(String region, String district, String quartal, String street, String objNum, boolean showObjNum, String rcNum, boolean showRcNum, String[] specials, boolean interestedChange, boolean forAuction, String notesLt, String notesEn, String notesRu, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dontShowInAds, boolean dontWantChat, String accountType, boolean agreeToRules) {
        this.driver = Helper.driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.showObjNum = showObjNum;
        this.rcNum = rcNum;
        this.showRcNum = showRcNum;
        this.specials = specials;
        this.interestedChange = interestedChange;
        this.forAuction = forAuction;
        this.notesLt = notesLt;
        this.notesEn = notesEn;
        this.notesRu = notesRu;
        this.photos = photos;
        this.video = video;
        this.tour3d = tour3d;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.dontShowInAds = dontShowInAds;
        this.dontWantChat = dontWantChat;
        this.accountType = accountType;
        this.agreeToRules = agreeToRules;
    }

    public void fill() {
        this.fillLocation();
        this.fillSpecials();
        this.fillObjNum();
        this.fillShowObjNum();
        this.fillRcNum();
        this.fillShowRcNum();
        this.fillInterestedChange();
        this.fillForAuction();
        this.fillNotes();
        this.fillPhotos();
        this.fillVideo();
        this.fillTour3d();
        this.fillPrice();
        this.fillPhone();
        this.fillEmail();
        this.fillDontShowInAds();
        this.fillDontWantChat();
        this.fillAccountType();
        this.fillAgreeToRules();
    }

    public void fillLocation() {
        this.fillRegion();
        this.fillDistrict();
        this.fillQuartal();
        this.fillStreet();
    }

    public void fillNotes() {
        this.fillNotesLt();
        this.fillNotesEn();
        this.fillNotesRu();
    }

    public void fillRegion() {
        if (!this.region.isEmpty()) {
            this.driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
            this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(this.region);
            wait(300);
            this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(Keys.ENTER);
        }
    }

    public void fillDistrict() {
        if (!this.region.isEmpty()) {
            this.driver.findElements(By.className("dropdown-input-value-title")).get(1).click();
            this.driver.findElement(By.xpath("//ul[contains(@class, 'dropdown-input-values-address')]/li[normalize-space(text())='" + this.district + "']")).click();
        }
    }

    public void fillQuartal() {
        if (!this.region.isEmpty()) {
            this.driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
            this.driver.findElement(By.xpath("//ul[contains(@id, 'quartals_')]//li[contains(normalize-space(text()), '" + this.quartal + "')]")).click();
        }
    }

    public void fillStreet() {
        if (!this.region.isEmpty()){
            this.driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
            this.driver.findElement(By.xpath("//ul[contains(@id, 'streets_')]//li[contains(normalize-space(text()), '" + this.street + "')]")).click();
        }
    }

    public void fillObjNum() {
        this.driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    public void fillShowObjNum() {
        if (!this.showObjNum) {
            this.driver.findElement(By.xpath("//label[@for='cbshow_house_num']")).click();
        }
    }

    public void fillRcNum() {
        this.driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    public void fillShowRcNum() {
       if (!this.showRcNum) {
           this.driver.findElement(By.xpath("//label[@for='cbshow_rc_number']")).click();
       }
    }

    public void fillSpecials() {
        driver.findElement(By.id("showMoreFields")).click();
        wait(200);
        for (int i = 0; i < this.specials.length; i++) {
            driver.findElement(By.xpath(
                    "//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.specials[i]) +"')]"
            )).click();
        }
    }

    public void fillInterestedChange() {
        if (this.interestedChange) {
            this.driver.findElement(By.cssSelector("label[for='cbInterestedChange']")).click();
        }
    }

    public void fillForAuction() {
        if (this.forAuction) {
            this.driver.findElement(By.cssSelector("label[for='cbAuction']")).click();
        }
    }

    public void fillNotesLt() {
        this.driver.findElement(By.cssSelector("label[for='langLt']")).click();
        this.driver.findElement(By.name("notes_lt")).sendKeys(this.notesLt);
    }

    public void fillNotesEn(){
        this.driver.findElement(By.cssSelector("label[for='langEn']")).click();
        this.driver.findElement(By.name("notes_en")).sendKeys(this.notesEn);
    }

    public void fillNotesRu(){
        this.driver.findElement(By.cssSelector("label[for='langRu']")).click();
        this.driver.findElement(By.name("notes_ru")).sendKeys(this.notesRu);
    }

    public void fillPhotos() {
        String base = "C:\\Users\\daini\\IdeaProjects\\aruodasTest\\src\\test\\resources\\images\\";
        String[] abs = new String[this.photos.length];
        for (int i = 0; i < this.photos.length; i++) {
            abs[i] = base + this.photos[i];
        }
        this.driver.findElement(By.xpath("//a[@id='uploadPhotoBtn']//input[@type='file']")).sendKeys(String.join("\n", abs));
    }

    public void fillVideo() {
        this.driver.findElement(By.name("Video")).sendKeys(this.video);
    }

    public void fillTour3d() {
        this.driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);
    }

    public void fillPrice() {
        this.driver.findElement(By.id("priceField")).sendKeys(this.price);
    }

    public void fillPhone() {
        this.driver.findElement(By.name("phone")).clear();
        this.driver.findElement(By.name("phone")).sendKeys(this.phone);
    }

    public void fillEmail() {
        this.driver.findElement(By.name("email")).sendKeys(this.email);
    }

    public void fillDontShowInAds() {
        if (this.dontShowInAds) {
            this.driver.findElement(By.cssSelector("label[for='cbdont_show_in_ads']")).click();
        }
    }

    public void fillDontWantChat() {
        if (this.dontWantChat) {
            this.driver.findElement(By.cssSelector("label[for='cbdont_want_chat']")).click();
        }
    }

    public void fillAccountType() {
        this.driver.findElement(By.xpath("//div[contains(translate(normalize-space(@data-title), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.accountType) + "')]")).click();
    }

    public void fillAgreeToRules() {
        if (this.agreeToRules) {
            this.driver.findElement(By.xpath("//label[@for='cbagree_to_rules']//span")).click();
        }
    }

    public void wait(int time) {
        try{
            Thread.sleep(time);
        }catch (Exception e){
        }
    }

    public String normalizeInput(String text) {
        return text.toLowerCase()
                .replace("ą", "a")
                .replace("č", "c")
                .replace("ę", "e")
                .replace("ė", "e")
                .replace("į", "i")
                .replace("š", "s")
                .replace("ų", "u")
                .replace("ū", "u")
                .replace("ž", "z");
    }

    public static String generateRndLetters(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }

    public static String generateRndSpecialChars(int length) {
        String symbols = "\"#$%&'()*:;<=>?[\\]^_`{|}~";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random()*symbols.length()));
        }
        return text;
    }
}
