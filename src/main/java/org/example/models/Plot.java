package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Plot extends RealEstate {
    public String plotSize;

    public int[] intendances;

    public Plot(String region, String district, String quartal, String street, String objNum, String rcNum, String[] specials, boolean interestedChange, boolean forAuction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dont_show_in_ads, boolean dont_want_chat, int accountType, boolean agree_to_rules, String plotSize, int[] intendances) {
        super(region, district, quartal, street, objNum, rcNum, specials, interestedChange, forAuction, notes_lt, notes_en, notes_ru, photos, video, tour3d, price, phone, email, dont_show_in_ads, dont_want_chat, accountType, agree_to_rules);
        this.plotSize = plotSize;
        this.intendances = intendances;
    }

    public void fill() {
        super.fill();
        this.fillPlotSize();
        this.fillIntendances();
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
            }
        }
    }
}
