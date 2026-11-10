
// Doble clic sobre un botón

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cuarto {
    public void main (String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions accion = new Actions(driver);

        try{
            driver.get("https://demoqa.com/buttons");
            driver.manage().window().maximize();

            WebElement botonsin = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
            accion.doubleClick(botonsin).perform();
            System.out.println("Hizo click");

            WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

            String obtenerResultado = resultado.getText();

            if (obtenerResultado.equals("You have done a double click")){
                System.out.println("La prueba es correcta");
            } else{
                System.out.println("No funcionó la prueba");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
