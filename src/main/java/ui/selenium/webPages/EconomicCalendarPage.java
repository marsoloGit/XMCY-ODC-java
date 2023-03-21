package ui.selenium.webPages;

import org.openqa.selenium.WebDriver;
import ui.selenium.webElements.DatePicker;
import ui.selenium.webElements.Slider;

public class EconomicCalendarPage extends BasePage {
    EconomicCalendarPage(WebDriver driver) {
        super(driver);

    }

    public DatePicker datePicker = new DatePicker(this.getDriver());

    private Slider slider = new Slider(
            getDriver(), "mat-slider[role=slider]", "div.mat-slider-thumb", "iFrameResizer0");


    public void move_slider_to(int toValue) {

        slider.move(toValue);
        getDriver().switchTo().defaultContent();
    }


}
