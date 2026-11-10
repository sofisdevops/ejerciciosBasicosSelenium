
// Captura de pantalla de un campo dinámico

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class sexto {
    public void main (String[] args){
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            driver.manage().window().maximize();

            WebElement revelarInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reveal")));
            WebElement revelarInputBotton = wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal")));
            revelarInputBotton.click();

            WebElement inputRevelado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
            inputRevelado.sendKeys("Prueba Selenium ADSO");

            String obtenerTexto = inputRevelado.getDomProperty("value");

            if (obtenerTexto.equals("Prueba Selenium ADSO")){
                System.out.println("Funciono");
            } else{
                System.out.println("No funciono");
            }

            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");

            FileHandler.copy(captura,destino);

        } catch (Exception e) {
            System.out.println("Error " + e);
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }

    }
}
