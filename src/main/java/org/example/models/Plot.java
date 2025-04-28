package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Plot {

    public WebDriver driver;

    public String region;

    public String district;

    public String quartal;

    public String street;

    public String objNum;

    public String rcNum;

    public String plotSize;

    public int[] intendances;

    public int[] specials;

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

    public Plot() {
    }

    public Plot(WebDriver driver, String region, String district, String quartal, String street, String objNum,
                String rcNum, String plotSize, int[] intendances, int[] specials, boolean interestedChange, boolean forAuction,
                String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phone,
                String email, boolean cbdont_show_in_ads, boolean cbdont_want_chat, int accountType, boolean cbagree_to_rules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.rcNum = rcNum;
        this.plotSize = plotSize;
        this.intendances = intendances;
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
        this.fillRcNum();
        this.fillPlotSize();
        this.fillIntendances();
        this.fillSpecials();
        this.fillInterestedChange();
        this.fillForAuction();
        this.fillNotes_lt();
        this.fillNotes_en();
        this.fillNotes_ru();
        this.fillPhotos();
        this.fillVideo();
        this.fillTour3D();
        this.fillPrice();
        this.fillPhone();
        this.fillEmail();
        this.fillCbDont_show_in_ads();
        this.fillCbDont_want_chat();
        this.fillAccountType();
        this.fillCbAgree_to_rules();
    }

    private void fillStreet() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(200);
        this.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(this.street);//veliau reikes korekciju
        wait(300);
        this.driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    private void fillQuartal() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        this.driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(this.quartal);//veliau reikes korekciju
        wait(2000);
        this.driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(Keys.ENTER);
    }

    private void fillDistrict() { //padaryti veliau
//        this.driver.findElements(By.className("dropdown-input-value-title")).get(1).click();
//        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(this.region);
//        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(Keys.ENTER);
    }
    private void fillRegion() {
        this.driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(this.region);
        wait(300);
        this.driver.findElement(By.className("dropdown-input-search-value")).sendKeys(Keys.ENTER);
    }

    private void fillObjNum() {
        this.driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    private void fillRcNum() {
        this.driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillPlotSize() {
        this.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.plotSize);
    }

    private void fillIntendances() {
        List<WebElement> intendances = this.driver.findElements(By.xpath("//input[@name='FIntendance[]']/following-sibling::label"));
        for (int i = 0; i < this.intendances.length ; i++) {
            switch (this.intendances[i]) {
                case 1:
                    intendances.getFirst().click();
                    break;
                case 2:
                    intendances.get(1).click();
                    break;
                case 3:
                    intendances.get(2).click();
                    break;
                case 4:
                    intendances.get(3).click();
                    break;
                case 5:
                    intendances.get(4).click();
                    break;
                case 6:
                    intendances.get(5).click();
                    break;
                case 7:
                    intendances.get(6).click();
                    break;
                case 8:
                    intendances.get(7).click();
                    break;
                case 9:
                    intendances.get(8).click();
                    break;
                case 10:
                    intendances.get(9).click();
                    break;
                default:
                    break;
            }
        }
    }

    private void fillSpecials() {
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
                default:
                    break;
            }
        }
    }

    private void fillInterestedChange() {
        if (this.interestedChange) {
            this.driver.findElement(By.cssSelector("label[for='cbInterestedChange']")).click();
        }
    }

    private void fillForAuction(){
        if (this.forAuction){
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

    private void fillTour3D() {
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
