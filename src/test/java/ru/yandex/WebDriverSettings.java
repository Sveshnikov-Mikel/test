package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
  public void setDriver(ChromeDriver driver) {
    this.driver = driver;
  }

  public ChromeDriver driver;

        @Before
        public void setup() {
            driver = new ChromeDriver();
        }

        @After
        public void close() {
            driver.quit();
        }
    }
