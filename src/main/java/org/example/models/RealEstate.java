package org.example.models;
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

    public boolean cbdont_show_in_ads;

    public boolean cbdont_want_chat;

    public int accountType;

    public boolean cbagree_to_rules;

    public void fill() {
        fillLocation();
        fillSpecials();
    }

    public void fillLocation() {
        fillRegion();
        fillDistrict();
        fillQuartal();
        fillStreet();
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

    public void wait (int time) {
        try{
            Thread.sleep(time);
        }catch (Exception e){}
    }

    public void fillSpecials() {}










































}
