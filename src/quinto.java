
// Agregar y buscar un registro en una tabla

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quinto {
    public void main (String[] args){
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            driver.get("https://demoqa.com/webtables");
            driver.manage().window().maximize();

            WebElement botonsin = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
            botonsin.click();

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
            WebElement age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")));
            WebElement salary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary")));
            WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department")));
            WebElement botonForm = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            firstName.sendKeys("Carlos");
            lastName.sendKeys("Ramírez");
            email.sendKeys("carlos@gmail.com");
            age.sendKeys("25");
            salary.sendKeys("2500000");
            department.sendKeys("Sistemas");
            botonForm.click();
            System.out.println("Hizo click");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBox")));
            search.sendKeys("Carlos");

            WebElement botonFormCarlos = wait.until(ExpectedConditions.elementToBeClickable(By.id("basic-addon2")));
            botonFormCarlos.click();
            System.out.println("Carlos hizo click");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            String  tablaNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody"))).getText();

            if (tablaNombre.contains("Carlos Ramírez")){
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

