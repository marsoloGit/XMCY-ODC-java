package ui.jdi.webPages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Link;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

@Url("/") @Title("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™")
public class HomePage extends WebPage {
    @FindBy(how = How.LINK_TEXT, using="RESEARCH & EDUCATION")
    private static Link lnkResearchAndEducation;

    public void navigateToResearchAndEducation(){
        lnkResearchAndEducation.click();

    }

}


//@Url("/index.html") @Title("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™")
// class HomePage1 extends WebPage {
//    @Css("form") public static LoginForm loginForm;
//    @Css("img#user-icon") public static Icon userIcon;
//}