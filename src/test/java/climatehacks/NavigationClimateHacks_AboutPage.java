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

public class NavigationClimateHacks_AboutPage {
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

    @Test(priority = 1, description = "Navigation at About Tab")
    public void NavigationAtAboutTab(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);

        String expectWebsite= "https://climatehacks.dev/about.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at About Tab successfully");

    }
//Not sure what it links to.
    @Test(priority = 2, description = "Navigation at 'f' under Tahmid Biswas at Home Page")
    public void NavigationatfunderTahmidBiswasatHomePage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div/div/div[1]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div/div/div[1]/div/ul/li/a"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at 'f' under Tahmid Biswas at Home Page successfully");

    }
//Not sure what it links to.
    @Test(priority = 3, description = "Navigation at 'f' under Jillian Lynch at Home Page")
    public void NavigationatfunderJillianLynchatHomePage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div/div/div[2]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div/div/div[2]/div/ul/li/a"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at 'f' under Jillian Lynch at Home Page successfully");

    }
    //Not sure what it links to.
    @Test(priority = 4, description = "Navigation at 'f' under Marc Duny at Home Page")
    public void NavigationatfunderMarcDunyatHomePage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div/div/div[3]/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div/div/div[3]/div/ul/li/a"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at 'f' under Marc Duny at Home Page successfully");

    }
    //Not sure what it links to.
    @Test(priority = 5, description = "Navigation at 'f' under Myles Patterson at Home Page")
    public void NavigationatfunderMylesPattersonatHomePage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div/div/div[4]/div/img"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div/div/div[4]/div/ul/li/a"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at 'f' under Myles Patterson at Home Page successfully");

    }
    @Test(priority = 6, description = "Navigation at Learn More At About Page")
    public void NavigationAtLearnMoreAtAboutPage(){

        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/section[4]/div/div/div[1]/div/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div[1]/div/a"))).click();

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
        String expectWebsite= "https://minorityprogrammers.com/";
        String expectTitle = "Minority Programmers Associations - Connecting programmers";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Learn More At About Page successfully");
    }

    @Test(priority = 7, description = "SendKey at stay connected with us at about page")
    public void SendKeyatstayconnectedwithusataboutpage() throws InterruptedException{
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(1) > a")).click();

        WebElement Enteryoutemail = driver.findElement(By.xpath("/html/body/section[6]/div/div/div/div[2]/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(Enteryoutemail).perform();
        Enteryoutemail.sendKeys("aileen@minorityprogrammers.org");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/section[6]/div/div/div/div[2]/div/button")).click();
        System.out.println("SendKey at stay connected with us at about page successfully");
    }
}
