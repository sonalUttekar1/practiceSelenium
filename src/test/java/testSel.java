
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.format.DecimalStyle;
import java.util.ArrayList;

public class testSel {
//    @Test
//    public void testGoogleSearch() throws URISyntaxException, MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        DesiredCapabilities cap=new DesiredCapabilities();
//        cap.setBrowserName("chrome");
//        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.29.119:4444").toURL(),cap);
//        driver.get("https://www.google.com");
//        System.out.println("Title: " + driver.getTitle());
//        driver.quit();
//    }
//
//    @Test
//    public void testGoogleSearchRemote() throws URISyntaxException, MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        DesiredCapabilities cap=new DesiredCapabilities();
//        cap.setBrowserName("chrome");
//        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.29.119:4444").toURL(),cap);
//        driver.get("https://www.gmail.com");
//        System.out.println("Title: " + driver.getTitle());
//        driver.quit();
//    }


    //Use this as a skeleton
    @Test
    public void basicSkel() throws URISyntaxException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Utteson/OneDrive - Baker Hughes/Documents/AutomationIndustrialSolutions/summary/selenium25/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.quit();
    }

    //This is to test navigations/New Tabs
        @Test
    public void testNavigations() throws URISyntaxException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Utteson/OneDrive - Baker Hughes/Documents/AutomationIndustrialSolutions/summary/selenium25/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.navigate().to("https://www.gmail.com");
            System.out.println("Title2: " + driver.getTitle());
            driver.navigate().to("https://www.facebook.com");
            System.out.println("Title3: " + driver.getTitle());
            driver.navigate().back();
            System.out.println("Title4: " + driver.getTitle());
            ((JavascriptExecutor) driver).executeScript("window.open('https://www.anotherexample.com', '_blank');");
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://www.facebook.com");

            driver.switchTo().window(tabs.get(0));

            driver.close();
//        driver.quit();
    }


    @Test
    public void webComponentAuto() throws URISyntaxException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Utteson/OneDrive - Baker Hughes/Documents/AutomationIndustrialSolutions/summary/selenium25/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.goindigo.in/");

        WebElement type=driver.findElement(By.id("radio-input-triptype-roundTrip"));
        type.click();



        driver.quit();
    }


}
