package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\edvin\\OneDrive\\Desktop\\Geckodriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://orteil.dashnet.org/cookieclicker/");

        WebElement cookie = driver.findElement(By.xpath("//div[@id='bigCookie']"));

        int count = 0;
        boolean flag = false;
        for (int i = 0; i < 5000; i++) {

            cookie.click();
            WebElement cookie_count = driver.findElement(By.id("cookies"));
            String[] splitCookie_count = cookie_count.getText().split(" ");
            System.out.println(splitCookie_count[0]);
            WebElement product0 = driver.findElement(By.id("product0"));
            WebElement product1 = driver.findElement(By.id("product1"));
            WebElement product2 = driver.findElement(By.id("product2"));
            WebElement product3 = driver.findElement(By.id("product3"));


            if (Integer.parseInt(splitCookie_count[0]) > 50 && (!flag)){
                Thread.sleep(10);
                product0.click();
                flag = true;
            } else if ((Integer.parseInt(splitCookie_count[0]) > 100) && flag) {
                product1.click();
                flag = false;
                System.out.println();
                System.out.println();
                System.out.println();
            }

        }
        System.out.println(count);
    }
}
