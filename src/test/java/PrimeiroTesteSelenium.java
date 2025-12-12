import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.support.ui.Select;

public class PrimeiroTesteSelenium {

    WebDriver driver;

    @Before
    public void entrarAplicacao() {

        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void primeiroTesteSelenium() {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Paulo");

        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Fernandes");

        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Rua Boa Ventura, Belo Horizonte - MG");

        driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("qa_academy.com.br");

        driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("9999999");

        driver.findElement(By.xpath("//input[@value='Male']")).click();

        driver.findElement(By.id("checkbox2")).click();

        driver.findElement(By.id("msdd")).click();
        driver.findElement(By.xpath("//a[text()='Portuguese']")).click();

        WebElement element = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(element);
        skillsSelect.selectByVisibleText("Java");

        WebElement country = driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Australia");


        WebElement ano = driver.findElement(By.id("yearbox"));
        Select selectAno = new Select(ano);
        selectAno.selectByVisibleText("1992");

        WebElement mes = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select selectMes = new Select(mes);
        selectMes.selectByVisibleText("July");

        WebElement dia = driver.findElement(By.id("daybox"));
        Select selectDia = new Select(dia);
        selectDia.selectByVisibleText("17");

        driver.findElement(By.id("firstpassword")).sendKeys("123456");
        driver.findElement(By.id("secondpassword")).sendKeys("123456");

        driver.findElement(By.id("imagesrc")).sendKeys("C:/Users/Pauli/Downloads/teste.jpg");//Upload de arquivo
    }

    @Test
    public void desafioQA(){

        driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Windows']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Open New Seperate Windows']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Object[] windowHandles=driver.getWindowHandles().toArray();//Mapeia as janleas

        System.out.println(windowHandles[0] +" - "+ windowHandles[1]);
        driver.switchTo().window((String) windowHandles[1]);//faz a troca do contexto
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));





    }

    @After
    public void fechar() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}

