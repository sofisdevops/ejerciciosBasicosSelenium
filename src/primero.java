
// Registro de informacion en un formulario

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class primero {
    public void main (String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor JS = (JavascriptExecutor) driver;

        try{
            driver.get("https://demoqa.com/text-box");
            driver.manage().window().maximize();

            WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
            WebElement currentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
            WebElement permanentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            userName.sendKeys("Laura Martinez");
            email.sendKeys("laura@gmail.com");
            currentAddress.sendKeys("Calle 25 # 10-20");
            permanentAddress.sendKeys("Carrera 15 # 30-40");
            JS.executeScript("arguments[0].scrollIntoView({block:'center'});",submit);

            submit.click();
            System.out.println("Hizo click");

            WebElement div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
            JS.executeScript("arguments[0].scrollIntoView({block:'center'});",div);

            WebElement userValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            WebElement emailValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

            String textName = userValue.getText();
            String textEmail = emailValue.getText();

            if (textName.contains("Laura Martinez") && textEmail.contains("laura@gmail.com")){
                System.out.println("La prueba es exitosa, los valores son los correctos");
            } else{
                System.out.println("Los valores son diferentes, la prueba fallo");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
