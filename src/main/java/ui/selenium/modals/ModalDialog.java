package ui.selenium.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import ui.selenium.webPages.Container;

import java.util.List;

public class ModalDialog extends Container {

    @FindBys({
            @FindBy(how = How.CSS, using = "div.modal-content"),
            @FindBy(how = How.CSS, using = "div.modal-body")
    })
    private WebElement modalText;

    @FindBy(how = How.CSS, using = "div.modal-content")
    private WebElement modalContainer;


    @FindBys({
            @FindBy(how = How.CSS, using = "div.modal-content"),
            @FindBy(how= How.CSS, using = "button.btn")
    })
    private List<WebElement> modalButtons;





    public ModalDialog(WebDriver driver) {
        super(driver);

    }



    String getModalText(){
        return modalText.getText();
    }

    void clickDialogButtonByText(String text){
        clickContainerElementByText(modalButtons, text);
    }





}
