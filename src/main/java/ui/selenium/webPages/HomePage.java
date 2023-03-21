package ui.selenium.webPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using="RESEARCH & EDUCATION")
    private WebElement lnkResearchAndEducation;


    public ResearchEducationPage navigateToResearchAndEducation(){
        this.getDriver().manage().timeouts().setScriptTimeout(ELEMENT_WAIT, TimeUnit.SECONDS);
        lnkResearchAndEducation.click();
        return new ResearchEducationPage(getDriver());

    }



}



