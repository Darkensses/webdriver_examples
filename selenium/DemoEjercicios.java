import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoEjercicios {

    static final String URL_FORM = "https://testpages.herokuapp.com/styled/basic-html-form-test.html";
    static final String URL_FILE = "https://testpages.herokuapp.com/styled/file-upload-test.html";
    static final String URL_FRAME = "https://testpages.herokuapp.com/styled/iframes-test.html";
    static final String URL_BTNS = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
    static final String URL_DRDP = "https://testpages.herokuapp.com/styled/drag-drop-javascript.html";
    static final String URL_HOME = "https://testpages.herokuapp.com/styled/index.html";


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            E01(driver);
            E02(driver);
            E03(driver);
            E04(driver);
            E05(driver);
            E06(driver);

            Thread.sleep(3000);
            driver.quit();
        } catch (Exception ex) {
            System.out.println(ex);
            driver.quit();
        }

    }

    // Ejercicio Form
    static void E01(WebDriver driver){
        driver.get(URL_FORM);

        WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
        element.sendKeys("MyUsername");

        element = driver.findElement(By.name("password"));
        element.sendKeys("password");

        element = driver.findElement(By.name("comments"));
        element.clear();
        element.sendKeys("Este es un comentario lol");

        element = driver.findElement(By.xpath("//input[@value='cb1']"));
        element.click();

        Select select = new Select(driver.findElement(By.name("dropdown")));
        select.selectByVisibleText("Drop Down Item 6");

        element = driver.findElement(By.xpath("//input[@type='submit' and @name='submitbutton']"));
        //element.click();
    }

    // Ejercicio Subir Archivo
    static void E02(WebDriver driver) {
        driver.get(URL_FILE);

        driver.findElement(By.id("fileinput")).sendKeys("image.png");
        driver.findElement(By.name("upload")).click();
    }

    // Ejercicio iframe
    static void E03(WebDriver driver) {
        driver.get(URL_FRAME);

        driver.switchTo().frame("thedynamichtml");
        WebElement element = driver.findElement(By.id("iframe6"));
        System.out.println(element.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("theheaderhtml");

        element = driver.findElement(By.xpath("//*[text() = 'Nested Page Example']"));
        System.out.println(element.getText());
    }

    // Ejercicio Botones Dinámicos
    static void E04(WebDriver driver) {
        driver.get(URL_BTNS);

        WebElement element = driver.findElement(By.id("button00"));
        element.click();

        element = driver.findElement(By.id("button01"));
        element.click();

        //element = driver.findElement(By.id("button02"));
        element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("button02")));
        element.click();

        element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("button03")));
        element.click();

        System.out.println(element.getText());

        // Challenge: https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
    }

    // Ejercicio Drag and Drop
    static void E05(WebDriver driver) {
        driver.get(URL_DRDP);

        WebElement from=driver.findElement(By.id("draggable1"));
        WebElement to=driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();
        //actions.dragAndDropBy(from, 66,66).build().perform();
    }

    static void E06(WebDriver driver) {
        driver.get(URL_HOME);

        WebElement element = driver.findElement(By.id("basicpagetest"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
}
