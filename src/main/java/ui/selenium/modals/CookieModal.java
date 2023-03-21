package ui.selenium.modals;

import org.openqa.selenium.WebDriver;
import ui.selenium.webPages.HomePage;

public class CookieModal extends ModalDialog {
    public CookieModal(WebDriver driver) {
        super(driver);

    }

    public HomePage acceptAllCookies(){
        clickDialogButtonByText("ACCEPT ALL");
        return new HomePage(getDriver());
    }

}
