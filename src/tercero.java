
// Envío de formulario y mensaje de confirmación

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tercero {
    public void main(String[] args){
        WebDriver driversin = new ChromeDriver();
        WebDriverWait waitsin = new WebDriverWait(driversin, Duration.ofSeconds(5));

        try{
            driversin.get("https://www.selenium.dev/selenium/web/web-form.html");
            driversin.manage().window().maximize();

            WebElement textInput = waitsin.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));
            WebElement password = waitsin.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password")));
            WebElement textArea = waitsin.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));
            WebElement submit = waitsin.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Submit']") ));

            textInput.sendKeys("ADSO");
            password.sendKeys("Sena2026");
            textArea.sendKeys("Automatización con Selenium");
            submit.click();

            WebElement resultado = waitsin.until(ExpectedConditions.visibilityOfElementLocated(By.className("lead")));

            String obtenerResultado = resultado.getText();

            if (obtenerResultado.contains("Received!")){
                System.out.println("La prueba es correcta");
            } else{
                System.out.println("No funcionó la prueba");
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
            throw new RuntimeException(e);
        }finally {
            driversin.quit();
        }

    }
}
