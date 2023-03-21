package ui.selenium.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ui.selenium.webPages.BasePage;
import java.util.List;
import java.util.stream.Collectors;


public class DatePicker extends BasePage {
    public DatePicker(WebDriver driver) {
        super(driver);
    }


    @FindBys({
            @FindBy(id = "iFrameResizer0"),
            @FindBy(css = "button.mat-calendar-body-cell")
    })
    private List<WebElement> dateButtons;


    public List<String> getSelectedRange() {

        List<String> datesRange;

        datesRange = dateButtons
                .stream()
                .filter((b) -> b.getAttribute("class").contains("in-range") || b.getAttribute("class").contains("active"))
                .map((b) -> b.getAttribute("aria-label"))
                .collect(Collectors.toList());

        return datesRange;

    }



}



