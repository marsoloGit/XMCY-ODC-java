package ui.selenium;
import config.Const;
import config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {


    public static WebDriver getBrowserInstance(Const.BrowserType browser_type) throws Exception {

        ChromeOptions chromeOptions;
        FirefoxOptions firefoxOptions;


        if (browser_type == Const.BrowserType.FIREFOX) {
            firefoxOptions = new FirefoxOptions();
            if (Settings.BROWSER_HEADLESS) {
                firefoxOptions.addArguments("headless", "window-size=1920,1080", "no-sandbox", "disable-gpu", "start-maximized");
            }
            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver(firefoxOptions);

        }

        else if (browser_type == Const.BrowserType.CHROME) {
            chromeOptions = new ChromeOptions();
            if (Settings.BROWSER_HEADLESS) {
                chromeOptions.addArguments("--headless", "--window-size=1920,1080", "--no-sandbox", "--disable-gpu", "--start-maximized");
            }
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions);

        }



        else {
            throw new Exception("Driver was not defined");
        }

    }


}


