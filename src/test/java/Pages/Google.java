package Pages;

import io.cucumber.java.PendingException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.PageBase;

public class Google extends PageBase {

    String nameItemSelected;
    String userName;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void openDemoPage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void clickSignUpButtonNav() throws InterruptedException {
        driver.findElement(By.id("signin2")).click();
        Thread.sleep(500);
    }

    public void enterUsername( String username, String operation) throws InterruptedException {
        WebElement usernameBox = driver.findElement(By.id(operation.equals("register") ? "sign-username" : "loginusername"));
        Thread.sleep(500);
        usernameBox.sendKeys(username);
        userName = username;
        Thread.sleep(500);
    }

    public void enterPassword(String password, String operation) throws InterruptedException {
        WebElement usernameBox = driver.findElement(By.id(operation.equals("register") ? "sign-password" : "loginpassword"));
        Thread.sleep(500);
        usernameBox.sendKeys(password);
        Thread.sleep(500);
    }

    public void clickSubmitButton(String operation) throws InterruptedException {
        driver.findElement(By.xpath(operation.equals("register") ? "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]" : "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(1000);
    }

    public void detectSuccesfullyAlert() throws Exception {

        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals("This user already exist.") ) {
            throw new Exception("El nombre de usuario ya ha sido registrado ");
        }
    }

    public void clickLogInButtonNav() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(500);
    }

    public void logIn() throws InterruptedException {
        launchBrowser();
        openDemoPage();
        maximize();
        clickLogInButtonNav();
        Thread.sleep(500);
        enterUsername("Prueba_Baufest", "login");
        enterPassword("123456789", "login");
        clickSubmitButton("login");
    }

    public void enterLaptopCategory() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"contcont\"]/div/div[1]/div")).findElement(By.linkText("Laptops")).click();
        Thread.sleep(1500);
    }

    public void clickFirstChild() throws InterruptedException {
        WebElement firstChild = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
        nameItemSelected = firstChild.getText();
        firstChild.click();
        Thread.sleep(500);
    }

    public void clickAddToCartButton() throws InterruptedException {
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(500);
    }

    public void AddFirstLaptopToCart() throws Exception {
        enterLaptopCategory();
        clickFirstChild();
        Thread.sleep(1000);
        clickAddToCartButton();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals("Product added.") ) {
            alert.accept();
        }else{
            throw new Exception("Something it's wrong...");
        }

    }

    public void clickCartButtonNav() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);
    }

    public void detectItem() throws Exception {
        WebElement table = driver.findElement(By.id("tbodyid"));
        WebElement item = table.findElement(By.xpath(String.format("//*[text()='%s']", nameItemSelected)));

        if(!item.isDisplayed()) {
            throw new Exception("Something it's wrong...");
        }

    }

    public void userLogOut() {
        driver.findElement(By.id("logout2")).click();
    }

    public void detectWelcome() throws Exception {
        Thread.sleep(5000);

        WebElement welcome = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]"));




        if(!welcome.isDisplayed()) {
            throw new Exception("Something it's wrong...");
        }

    }



}
