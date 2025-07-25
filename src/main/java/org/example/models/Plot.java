package org.example.models;
import org.openqa.selenium.By;

public class Plot extends RealEstate {

    public String plotSize;
    public String[] intendances;

    public Plot(String region, String district, String quartal, String street, String objNum, boolean showObjNum, String rcNum, boolean showRcNum, String[] specials, boolean interestedChange, boolean forAuction, String notesLt, String notesEn, String notesRu, String[] photos, String video, String tour3d, String price, String phone, String email, boolean dontShowInAds, boolean dontWantChat, String accountType, boolean agreeToRules, String plotSize, String[] intendances) {
        super(region, district, quartal, street, objNum, showObjNum, rcNum, showRcNum, specials, interestedChange, forAuction, notesLt, notesEn, notesRu, photos, video, tour3d, price, phone, email, dontShowInAds, dontWantChat, accountType, agreeToRules);
        this.plotSize = plotSize;
        this.intendances = intendances;
    }

    @Override
    public void fill() {
        fillAllFields();
        this.driver.findElement(By.id("submitFormButton")).click();
    }

    public void fillAllFields() {
        super.fill();
        this.fillPlotSize();
        this.fillIntendances();
    }

    public void fillPlotSize() {
        this.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.plotSize);
    }

    public void fillIntendances() {
        for (int i = 0; i < this.intendances.length ; i++) {
            driver.findElement(By.xpath("//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽąčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzaceeisuuz'), '" + normalizeInput(this.intendances[i]) + "')]")).click();
        }
    }
}
