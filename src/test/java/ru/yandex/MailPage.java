package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {
    private WebDriver driver;

    @FindBy(xpath = "//div['HeadBanner-ButtonsWrapper']/a[@aria-pressed='false'][@data-reactid='24']")
    private WebElement enterButton;

}


