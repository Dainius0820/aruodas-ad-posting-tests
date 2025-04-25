package org.example.models;
import org.openqa.selenium.WebDriver;

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

    public int objectHeight;

    public boolean enterCustomFloors;

    public boolean isElevator;

    public String buildYear;

    public boolean isRenovated;

    public int houseType;

    public int houseState;

    public int[] warmSystem;

    public int objectType;

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

    public boolean cbagree_to_rules;


    public Flat() {
    }

    public Flat(WebDriver driver, String region, String district, String quartal, String street, String objNum, String flatNum,
                String rcNum, String flatSize, int roomNum, int floor, int objectHeight, boolean enterCustomFloors, boolean isElevator,
                String buildYear, boolean isRenovated, int houseType, int houseState, int[] warmSystem, int objectType, int[] windows_direction,
                int[] specials, int house_efficiency, boolean interestedChange, boolean forAuction, String notes_lt, String notes_en, String notes_ru,
                String[] photos, String video, String tour3d, String price, String phone, String email, boolean cbdont_show_in_ads,
                boolean cbdont_want_chat, boolean cbagree_to_rules) {
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
        this.objectHeight = objectHeight;
        this.enterCustomFloors = enterCustomFloors;
        this.isElevator = isElevator;
        this.buildYear = buildYear;
        this.isRenovated = isRenovated;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystem = warmSystem;
        this.objectType = objectType;
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
        this.cbagree_to_rules = cbagree_to_rules;
    }

    public void fill() {
        this.fillRegion();
    }

    private void fillRegion() {
    }

}
