package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeSelActions {

   WebDriver driver;
    WebDriverWait wait;

    public void initialiseDriver()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Utteson/OneDrive - Baker Hughes/Documents/AutomationIndustrialSolutions/summary/selenium25/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver= new ChromeDriver(options);

        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        pageLoadedCompletely();

    }

    public void navigateTo(String url)
    {
        driver.get(url);
    }

    public void pageLoadedCompletely() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!js.executeScript("return document.readyState").equals("complete")) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void selectTheWebElementForTheGivenValue(String value, String type) {


        switch (type)
        {
            case "Type":
                List<WebElement> radio=driver.findElements(By.xpath("//input[contains(@id,'radio-input-triptype-')]"));
//                wait.until(ExpectedConditions.visibilityOfAllElements(radio));
                List<WebElement> radioClick=driver.findElements(By.xpath("//input[contains(@id,'radio-input-triptype-')]//following-sibling::span[@role='radio']"));
                for (int i=0;i<radio.size();i++) {

                    if(radio.get(i).getAttribute("value").contains(value))
                    {
                        if(!radio.get(i).isSelected())


                            radioClick.get(i).click();
                        break;

                    }

                }
                break;
            case "from Destination":

                Actions a=new Actions(driver);
                WebElement fromDestination=driver.findElement(By.xpath("//div[@aria-label='sourceCity']"));
                a.moveToElement(fromDestination).click().build().perform();
                driver.findElement(By.xpath("//div[@aria-label='sourceCity']/input")).sendKeys(value);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<WebElement> fromOptions=driver.findElements(By.xpath("//*[@class='city-selection__list-item-wrapper']"));
                for (WebElement fromOptionPar:fromOptions
                     ) {
                    if(fromOptionPar.getDomAttribute("aria-labelledby").equalsIgnoreCase(value))
                    {
                        fromOptionPar.click();
                        break;
                    }

                }

        }
    }

    public void clickOnLogin() {
        driver.findElement(By.id("userNavBtn")).click();
        driver.findElement(By.xpath("//a[@aria-label='Customer  Login CTA']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='userInput']"))));
        driver.findElement(By.xpath("//input[@name='userInput']")).sendKeys("787885");

    }

    public void openNewTabAndNavigate(String url) {

        driver.navigate().to(url);

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.anotherexample.com', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);

    }
}
