import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoWebcam {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");

        // Las banderas de chrome le dan ciertas caracteristicas al navegador
        String[] flags = {
                "--use-fake-ui-for-media-stream", // Permiso de usar webcam
                "--use-fake-device-for-media-stream", // envia un patrón de prueba de video
                "--use-file-for-fake-video-capture=C:\\Path\\To\\video.y4m" // Video a inyectar >:D
        };
        ChromeOptions options = new ChromeOptions();
        options.addArguments(flags);

        // Enviamos las opciones al driver
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.pixect.com/es/");

        WebElement element = driver.findElement(By.id("btnStart"));
        element.click();

        // Explicit Wait para esperar por un elemento
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCamFirst")));
        element.click();

        try {
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
