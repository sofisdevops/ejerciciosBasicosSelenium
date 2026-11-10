import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class segundo {
    public void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor JS = (JavascriptExecutor) driver;

        try{
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();

            WebElement impressiveRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("impressiveRadio")));

            impressiveRadio.click();

            if (impressiveRadio.isSelected()){
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
