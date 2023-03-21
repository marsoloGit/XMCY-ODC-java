package ui.selenium.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResearchEducationPage extends BasePage {

    public ResearchEducationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.LINK_TEXT, using="Economic Calendar")
    private WebElement lnkEconomicCalendar;


    public EconomicCalendarPage navigateToCalendar(){
        lnkEconomicCalendar.click();
        return new EconomicCalendarPage(getDriver());
    }

}


