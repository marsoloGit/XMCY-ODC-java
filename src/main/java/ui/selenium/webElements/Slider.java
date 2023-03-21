package ui.selenium.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.selenium.webPages.BasePage;
import static java.lang.Math.round;

public class Slider extends BasePage {

    private String cssSlider;
    private String cssThumb;
    private String idIframe;
    private WebElement sliderContainer;
    private WebElement thumb;
    private int min;
    private int max;
    private int sliderStep;




    public Slider(WebDriver driver, String cssSlider, String cssThumb, String cssIframe) {
        super(driver);
        this.cssSlider = cssSlider;
        this.cssThumb = cssThumb;
        this.idIframe = cssIframe;


    }


    private void switchToIframe() {


        if (!idIframe.isEmpty()) {
            getDriver().switchTo().frame(idIframe);
        }
//            new WebDriverWait(getDriver(), 20)
//                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(idIframe)));
//
//        }


    }


    WebElement getSlider() {
        if (!idIframe.isEmpty()){
            switchToIframe();
        }

        WebElement slider = getDriver().findElement(By.cssSelector(cssSlider));


        return slider;
    }


    WebElement getThumb() {

        return getSlider().findElement(By.cssSelector(cssThumb));
    }


    private void getSliderParams() {
        sliderContainer = getSlider();
        min = Integer.valueOf(sliderContainer.getAttribute("aria-valuemin"));
        max = Integer.valueOf(sliderContainer.getAttribute("aria-valuemax"));
        sliderStep = sliderContainer.getSize().width / (max - min);
    }



    public void move(int value) {
        getSliderParams();

        int xOffset = round(sliderStep * value);
        getDriver().switchTo().defaultContent();

        thumb = getThumb();

        new Actions(getDriver()).clickAndHold(thumb).moveByOffset(xOffset, 0).release().perform();
    }


}


