package climatehacks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NavigationClimateHacks_SponserPage {
    public static String browser = "chrome"; // External configuration -XLS, CVS
    public static WebDriver driver;
    //private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void invokeTheDriver(){

        System.out.println("Invoke the driver");
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void closeTheDriver(){
        System.out.println("Close the driver");
        driver.quit();
    }

    /*@BeforeMethod
    public void openTheWebsite(){

        System.out.println("Open the website");
        driver.manage().deleteAllCookies();

    }*/

    /*@AfterMethod
    public void closeTheWebsite(){
        System.out.println("Close the website");
    }*/

    @Test(priority = 1, description = "Navigation at Sponser Tab")
    public void NavigationAtSponserTab(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);

        String expectWebsite= "https://climatehacks.dev/sponsor.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Sponser Tab successfully");

    }

    @Test(priority = 2, description = "Navigation at Get Involved at Sponser Page")
    public void NavigationatGetInvolvedatSponserPage() throws InterruptedException{
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        WebElement element = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[2]/div/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[1]/div[2]/div/a"))).click();
        //Thread.sleep(2000);
        System.out.println("Navigation at Get Involved at Sponser Page successfully");

    }

    @Test(priority = 3, description = "Navigation at Bronze Sponser At Sponser Page")
    public void NavigationatBronzeSponserAtSponserPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        WebElement element = driver.findElement(By.xpath("/html/body/section[4]/div/div/div[1]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div[1]/div/span/a"))).click();
        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Bronze Sponser At Sponser Page successfully");

    }
    @Test(priority = 4, description = "Navigation at Silver Sponser At Sponser Page")
    public void NavigationatSilverSponserAtSponserPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        WebElement element = driver.findElement(By.xpath("/html/body/section[4]/div/div/div[2]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div[2]/div/span/a"))).click();
        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Silver Sponser At Sponser Page successfully");
    }
    @Test(priority = 5, description = "Navigation at Gold Sponser At Sponser Page")
    public void NavigationatGoldSponserAtSponserPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        WebElement element = driver.findElement(By.xpath("/html/body/section[4]/div/div/div[3]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div[3]/div/span/a"))).click();
        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Gold Sponser At Sponser Page successfully");
    }
    @Test(priority = 6, description = "Navigation at Platinum Sponser At Sponser Page")
    public void NavigationatPlatinumSponserAtSponserPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        WebElement element = driver.findElement(By.xpath("/html/body/section[4]/div/div/div[4]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div[4]/div/span/a"))).click();
        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Platinum Sponser At Sponser Page successfully");
    }
}
