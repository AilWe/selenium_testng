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

public class NavigationClimateHacks_VolunteerPage {
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

    @Test(priority = 1, description = "Navigation at Volunteer Tab")
    public void NavigationAtVolunteerTab(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(3) > a")).click();


        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);

        String expectWebsite= "https://climatehacks.dev/volunteer.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at 'Get Started' successfully");

    }

    @Test(priority = 2, description = "Navigation at Help Now at Volunteer Page")
    public void NavigationatHelpNowatVolunteerPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(3) > a")).click();

        WebElement  HelpNow= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[1]/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(HelpNow).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[1]/div/div[2]/div/a"))).click();


        //hard code
        Set<String> windowshandle = driver.getWindowHandles();
        //System.out.println(windowshandle);

        Iterator<String> iterator = windowshandle.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //System.out.println(parentWindow);
        //System.out.println(childWindow);

        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Help Now at Volunteer Page successfully");

    }

    @Test(priority = 3, description = "Navigation at Sign up at Volunteer Page")
    public void NavigationatSignUpatVolunteerPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(3) > a")).click();

        WebElement  HelpNow= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(HelpNow).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/div[2]/div/a"))).click();


        //hard code
        Set<String> windowshandle = driver.getWindowHandles();
        //System.out.println(windowshandle);

        Iterator<String> iterator = windowshandle.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //System.out.println(parentWindow);
        //System.out.println(childWindow);

        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Sign Up at Volunteer Page successfully");

    }

    @Test(priority = 4, description = "Navigation at volunteer at Volunteer Page")
    public void NavigationatVolunteeratVolunteerPage(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_header > div > div.col-lg-9.col-md-5.col-sm-12.col-12.align-self-center > div > ul > li:nth-child(3) > a")).click();

        WebElement  Volunteer= driver.findElement(By.xpath("/html/body/section[4]/div/div/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(Volunteer).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[4]/div/div/div/div[2]/div/button"))).click();


        //hard code
        Set<String> windowshandle = driver.getWindowHandles();
        //System.out.println(windowshandle);

        Iterator<String> iterator = windowshandle.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //System.out.println(parentWindow);
        //System.out.println(childWindow);

        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //String expectWebsite= "https://climatehacks.devpost.com/";
        //String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        //Assert.assertEquals(actualTitle, expectTitle);
        //Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Volunteer at Volunteer Page successfully");

    }

}
