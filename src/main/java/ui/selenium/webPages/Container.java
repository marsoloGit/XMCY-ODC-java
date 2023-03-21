package ui.selenium.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Container extends BasePage {
    public Container(WebDriver driver) {
        super(driver);

    }

    public void clickContainerElementByText(List<WebElement> elements, String text){

        for(WebElement el: elements){
            if (el.getText().trim().contains(text)){
                el.click();
                break;
            }
        }

    }

}
