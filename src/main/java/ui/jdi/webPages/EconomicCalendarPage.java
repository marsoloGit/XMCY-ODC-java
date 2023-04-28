package ui.jdi.webPages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Slider;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;

@Url("/research/economicCalendar")
public class EconomicCalendarPage extends WebPage {

    @UI()
    public static DatePicker datePicker;
    @UI("mat-slider[role=slider]")
    private static Slider slider;


    public void move_slider_to(String toValue) {
        slider.dragAndDropThumbTo(toValue);
    }



}
