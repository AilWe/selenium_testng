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

public class NavigationClimateHacks_Footer {
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

    @Test(priority = 1, description = "Navigation at f icon")
    public void NavigationAtfIcon(){
        driver.get("https://climatehacks.dev/");
        WebElement element = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[1]/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[1]/a"))).click();

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

        String expectWebsite= "https://www.facebook.com/MinorityProgrammers/";
        String expectTitle = "Minority Programmers Association - Software - Harrisonburg, Virginia | Facebook - 14 Photos";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at f icon successfully");

    }

    @Test(priority = 2, description = "Navigation at twitter icon")
    public void NavigationAtTwitterIcon(){
        driver.get("https://climatehacks.dev/");
        WebElement element = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[2]/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[2]/a"))).click();

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

        String expectWebsite= "https://twitter.com/minorityprogram";
        String expectTitle = "";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at twitter icon successfully");

    }


    @Test(priority = 3, description = "Navigation at instagram icon")
    public void NavigationAtInsIcon(){
        driver.get("https://climatehacks.dev/");
        WebElement element = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[3]/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[3]/a"))).click();

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

        String expectWebsite= "https://www.instagram.com/minorityprogrammers/";
        String expectTitle = "Minority Programmers (@minorityprogrammers) • Instagram photos and videos";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at Instagram icon successfully");

    }


    @Test(priority = 4, description = "Navigation at linkedin icon")
    public void NavigationAtLinkedInIcon(){
        driver.get("https://climatehacks.dev/");
        WebElement element = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[4]/a"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[1]/div/ul/li[4]/a"))).click();

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

        String expectWebsite= "https://www.linkedin.com/company/minority-programmers/";
        String expectTitle = "Minority Programmers Association | LinkedIn";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at LinkedIn icon successfully");

    }


    @Test(priority = 5, description = "Navigation at About At MPA")
    public void navigationAtAboutAtMPA(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[1]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[1]/a"))).click();

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
        System.out.println("Navigation at About At MPA successfully");
    }

    @Test(priority = 6, description = "Navigation at Learn At MPA")
    public void navigationAtLearnAtMPA(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[2]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[2]/a"))).click();

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
        String expectWebsite= "https://minorityprogrammers.com/learn";
        String expectTitle = "Learn";

        //Assert.assertEquals(actualTitle, expectTitle);
        //Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Learn At MPA successfully");
    }

    @Test(priority = 7, description = "Navigation at Services At MPA")
    public void navigationAtServicesAtMPA(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[3]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[3]/a"))).click();

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
        String expectWebsite= "https://minorityprogrammers.com/services";
        String expectTitle = "Services";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Services At MPA successfully");
    }
    @Test(priority = 8, description = "Navigation at Join At MPA")
    public void navigationAtJoinAtMPA(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[4]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[1]/div/div[2]/div/ul/li[4]/a"))).click();

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
        String expectWebsite= "https://minorityprogrammers.com/join";
        String expectTitle = "Join";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Join At MPA successfully");
    }
    @Test(priority = 9, description = "Navigation at Devpost At Quick Access")
    public void navigationAtDevpostAtQuickAccess(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[1]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[1]/a"))).click();

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
        System.out.println("Navigation at Devpost At Quick Access successfully");
    }


    @Test(priority = 10, description = "Navigation at About At Quick Access")
    public void navigationAtAboutAtQuickAccess(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[2]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[2]/a"))).click();


        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.dev/about.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at About At Quick Access successfully");
    }
    @Test(priority = 11, description = "Navigation at Schedule At Quick Access")
    public void navigationAtScheduleAtQuickAccess(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[3]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[3]/a"))).click();


        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.dev/schedule.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Schedule At Quick Access successfully");
    }
    @Test(priority = 12, description = "Navigation at Sponsor At Quick Access")
    public void navigationAtSponsorAtQuickAccess(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[4]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[9]/div/div/div[2]/div/div[1]/div/ul/li[4]/a"))).click();

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.dev/sponsor.html";
        String expectTitle = "ClimateHacks";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Sponsor At Quick Access successfully");
    }

}
