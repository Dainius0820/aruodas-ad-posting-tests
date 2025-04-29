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

    public String rcNum;

    public String[] specials;

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

    public boolean dont_show_in_ads;

    public boolean dont_want_chat;

    public int accountType;

    public boolean agree_to_rules;

    public RealEstate() {
    }

    public RealEstate(String region, String district, String quartal, String street, String objNum, String rcNum, String[] specials, boolean interestedChange, boolean forAuction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dont_show_in_ads, boolean dont_want_chat, int accountType, boolean agree_to_rules) {
        this.driver = Helper.driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.rcNum = rcNum;
        this.specials = specials;
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
        this.dont_show_in_ads = dont_show_in_ads;
        this.dont_want_chat = dont_want_chat;
        this.accountType = accountType;
        this.agree_to_rules = agree_to_rules;
    }

    public void fill() {
        this.fillLocation();
        this.fillSpecials();
        this.fillObjNum();
        this.fillRcNum();
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
        this.fillDont_show_in_ads();
        this.fillDont_want_chat();
        this.fillAccountType();
        this.fillAgree_to_rules();
    }

    public void fillLocation() {
        this.fillRegion();
        this.fillDistrict();
        this.fillQuartal();
        this.fillStreet();
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

    private void fillRcNum() {
        this.driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillSpecials() {
        driver.findElement(By.id("showMoreFields")).click();
        wait(200);
        for (int i = 0; i < this.specials.length; i++) {
            driver.findElement(By.xpath(
                    "//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeSpecial(specials[i]) +"')]"
            )).click();
        }
    }

    private String normalizeSpecial(String text) {
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

    private void fillDont_show_in_ads() {
        if (this.dont_show_in_ads) {
            this.driver.findElement(By.cssSelector("label[for='cbdont_show_in_ads']")).click();
        }
    }

    private void fillDont_want_chat() {
        if (this.dont_want_chat) {
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
        }
    }

    private void fillAgree_to_rules() {
        if (this.agree_to_rules) {
            this.driver.findElement(By.xpath("//label[@for='cbagree_to_rules']//span")).click();
        }
    }

    public void wait (int time) {
        try{
            Thread.sleep(time);
        }catch (Exception e){}
    }

}
