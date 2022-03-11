import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DemoRegistro {

	public static void main(String[] args) {
		// Primero que nada, hay que indicar en donde esta nuestro driver
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
		
		// Las banderas de chrome le dan ciertas caracteristicas al navegador
		String[] flags = {
			//"--headless", // sin interfaz gráfica
			"--start-maximized", // ventana maximizada
			"--window-size=1200,900", // Redimensiona la ventana del navegador
		};
        ChromeOptions options = new ChromeOptions();
        options.addArguments(flags); //mejor pratica para redimensionar pantallas
        
        // Instanciamos Selenium
        WebDriver driver = new ChromeDriver(options);
        
        // Método para ir a una página
        driver.get("http://demo.automationtesting.in/Register.html");
        
		writeElement(driver, "//input[@placeholder='First Name']", "Diego");
        writeElement(driver, "//input[@placeholder='Last Name']", "Zavala");
        writeElement(driver, "//textarea", "Cerezo #3020");
        writeElement(driver, "//input[@type='email']", "example@gmail.com");
        writeElement(driver, "//input[@type='tel']", "8008002022");
        clickElement(driver, "//input[@value='Male']");
        clickElement(driver, "//input[@id='checkbox1']");
        clickElement(driver, "//div[@id='msdd']");
        clickElement(driver, "//div[@id='msdd']//following::div/ul//li/a[contains(text(),'English')]");
        selectElement(driver, "//select[@id='Skills']", "APIs");
        //selectElement(driver, "//select[@id='countries']", "Australia");
        clickElement(driver, "//span[@role='combobox']");
        selectElement(driver, "//select[@class='select2-hidden-accessible']", "Australia");
        clickElement(driver, "//span[@role='combobox']");
        selectElement(driver, "//select[@id='yearbox']", "1998");
        selectElement(driver, "//select[@ng-model='monthbox']", "April");
        selectElement(driver, "//select[@ng-model='daybox']", "20");
        writeElement(driver, "//input[@ng-model='Password']", "Contraseña!23");
        writeElement(driver, "//input[@ng-model='CPassword']", "Contraseña!23");
        writeElement(driver, "//input[@id='imagesrc']", "C:\\Path\\To\\photo.jpg");






        /*        
        // findElement sirve para encontrar un elemento en la página. 
        // Regresa un objeto del tipo WebElement.
        WebElement element;
        element =  driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        element.click();
        
        element.sendKeys("Zavala");
        element = driver.findElement(By.xpath("//textarea"));
        element.click();
        element.sendKeys("Cerezo #1312");
        element = driver.findElement(By.xpath("//input[@type='email']"));
        element.click();
        element.sendKeys("example@gmail.com");
        element = driver.findElement(By.xpath("//input[@type='tel']"));
        element.click();
        element.sendKeys("8117002121");
        WebElement element = driver.findElement(By.xpath("//input[@value='Male']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@value='Male']"));
        element.click();
        */


        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      // Siempre es buena idea cerrar/matar los proceso para evitar problemas en un futuro
        driver.quit();
        System.out.println("===FIN===");

    }

    public static void writeElement(WebDriver driver, String xpath, String text) {
        WebElement element =  driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    public static void clickElement(WebDriver driver, String xpath) {
        WebElement element =  driver.findElement(By.xpath(xpath));
        element.click();
    }

    public static void selectElement(WebDriver driver, String xpath, String value) {
        Select select = new Select (driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(value);
    }

 
}