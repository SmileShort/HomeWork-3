package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        System.out.println("Просмотр страницы друга");
        friendView();
        System.out.println("Отправка сообщения");
        sendMessage();

    }

    public static void friendView() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://vk.com");
        driver.findElement(By.id("index_email")).sendKeys("smileshort@mail.ru");
        driver.findElement(By.id("index_pass")).sendKeys("detonator5610");
        driver.findElement(By.xpath("//button[@class='index_login_button flat_button button_big_text']")).click();

        driver.findElement(By.xpath("//*[@id='l_fr']/a/span")).click();

        driver.findElement(By.xpath("//*[@id='friends_user_row533079423']/div[3]/div[1]/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("top_profile_link")).click();
        driver.findElement(By.id("top_logout_link")).click();
        driver.quit();
    }


    public static void sendMessage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://vk.com");
        driver.findElement(By.id("index_email")).sendKeys("smileshort@mail.ru");
        driver.findElement(By.id("index_pass")).sendKeys("detonator5610");
        driver.findElement(By.cssSelector("#index_login_button")).click();

        driver.findElement(By.id("l_msg")).click();

        //driver.findElement(By.xpath("//li[@data-peer='533079423']")).click();  // Лир
        driver.findElement(By.xpath("//li[@data-peer='664069291']")).click();
        WebElement message = driver.findElement(By.cssSelector("#im_editable0"));
        message.sendKeys("Как заработать деньги на Шри-Ланку?" + "\n");
        Thread.sleep(3000);

        driver.findElement(By.id("top_profile_link")).click();
        driver.findElement(By.id("top_logout_link")).click();
        driver.quit();
    }

}
