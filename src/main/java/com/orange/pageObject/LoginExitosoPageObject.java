package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginExitosoPageObject extends PageObject {


   private final By txtUserName = By.xpath("(//input[@placeholder=\"Username\"])");
    public By getTxtUserName() {
        return txtUserName;
    }


    private final By txtPassword = By.xpath("(//input[@placeholder=\"Password\"])");

    public By getTxtPassword() {return txtPassword;
    }

    private final  By btnLogin = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"])");

    public By getBtnLogin() {
        return btnLogin;
    }


}

