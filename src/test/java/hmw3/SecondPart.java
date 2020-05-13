package hmw3;

import Utility.BrowserUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondPart {
    private WebDriver driver;
    private By fullNameBy = By.cssSelector("input[name='full_name']");
    private By emailBy = By.xpath("//input[@name='email']");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    //Test case #6
    @Test
    public void emailSignupTest(){
        driver.get("https://www.fakemail.net");
        String email = driver.findElement(By.xpath("//span[@id='email' and @class='animace']")).getText();
        BrowserUtility.wait(2);
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(fullNameBy).sendKeys("Katie Mandel");
        BrowserUtility.wait(2);
        driver.findElement(emailBy).sendKeys(email);
        BrowserUtility.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtility.wait(2);

        WebElement signupMessage = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(signupMessage.isDisplayed());

        driver.get("https://www.fakemail.net");
        BrowserUtility.wait(2);
        WebElement dontReplyEmail = driver.findElement(By.cssSelector("td[class='from']"));
        Assert.assertTrue(dontReplyEmail.isDisplayed());
    }



    //Test case #7
    @Test
    public void fileUploadTest(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtility.wait(2);

        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        String filePath = "/Users/lsilavunduk/Desktop/Homework3.txt";
        uploadButton.sendKeys(filePath);

        driver.findElement(By.id("file-submit"));

        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedMessage.isDisplayed());

    }

    //Test case #8
    @Test
    public void countryInputBoxMessageText(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Autocomplete")).click();
        BrowserUtility.wait(2);
        driver.findElement(By.cssSelector("input[id=myCountry]")).sendKeys("United States of America");
        BrowserUtility.wait(2);
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        WebElement youSelectedMessage = driver.findElement(By.xpath("//input[@type ='button' and @class='btn btn-primary']"));
        Assert.assertTrue(youSelectedMessage.isDisplayed());

    }


    //Test case #9
    @Test
    public void statusCodes200Test(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtility.wait(2);
        driver.findElement(By.xpath("//a[contains(text(),'200')]")).click();
        BrowserUtility.wait(2);
        WebElement statusCode200Message = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statusCode200Message.isDisplayed());
    }

    //Test case #10
    @Test
     public void statusCodes301Test() {
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtility.wait(2);
        driver.findElement(By.xpath( "//a[contains(text(),'301')]" )).click();
        BrowserUtility.wait(2);
        WebElement statusCode301Message = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statusCode301Message.isDisplayed());
    }


    //Test case #11
    @Test
    public void statusCodes404Test() {
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtility.wait(2);
        driver.findElement(By.xpath( "//a[contains(text(),'404')]" )).click();
        BrowserUtility.wait(2);
        WebElement statusCode404Message = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statusCode404Message.isDisplayed());
    }



    //Test case #12
    @Test
    public void statusCodes500Test() {
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtility.wait(2);
        driver.findElement(By.xpath( "//a[contains(text(),'500')]" )).click();
        BrowserUtility.wait(2);
        WebElement statusCode500Message = driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(statusCode500Message.isDisplayed());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}



