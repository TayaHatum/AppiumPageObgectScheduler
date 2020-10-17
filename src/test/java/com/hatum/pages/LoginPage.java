package com.hatum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    @FindBy (id = "username")
    WebElement username;
    @FindBy(id="password")
    WebElement password;
    @FindBy(xpath = "//input [@id=\"remember\"]")
    WebElement remember;
    @FindBy(id="login_button")
    WebElement loginButton;
    @FindBy(id="login_button_domain")
    WebElement loginAnotherUserBtn;
    @FindBy (id="login_button_current")
    WebElement loginCurrentUserBtn;
    @FindBy(id="error")
    WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String massegeError(){
        return error.getText();
    }


    public void enterUserName(String name){
        if (username.isDisplayed()){
            username.click();
            username.clear();
            username.sendKeys(name);
        }
    }


    public void enterPassword(String pass){
        if(password.isDisplayed()){
            password.click();
            password.clear();
            password.sendKeys(pass);
        }

    }
    public void checkRememberMe(){
        if (remember.isDisplayed()&!remember.isSelected()){
            remember.click();
        }
    }
    public void clickLoginButton(){
        if(loginButton.isDisplayed()){
            loginButton.click();
        }

    }


    public LoginPage loginclickAnotherUserBtn(){
        if (loginAnotherUserBtn.isDisplayed()){
            enterUserName("tester");
            enterPassword("K35G3U");
            loginAnotherUserBtn.click();
        }
        return new LoginPage(driver);

    }
    public LoginPage loginclickCurrentUserBtn(){
        if(loginCurrentUserBtn.isDisplayed()){
            enterUserName("tester");
            enterPassword("K35G3U");
            loginCurrentUserBtn.click();
        }
        return new LoginPage(driver);

    }

    public ProfilePage loginWithTestUser(String user, String password){
        enterUserName(user);
        enterPassword(password);
        clickLoginButton();
        return new ProfilePage(driver);
    }
    public ProfilePage loginWithTestUserWithRememberMe(String user, String password){
        enterUserName(user);
        enterPassword(password);
        checkRememberMe();
        clickLoginButton();
        return new ProfilePage(driver);
    }
    public LoginPage loginWithInvalidData(String user, String password){
        enterUserName(user);
        enterPassword(password);
        clickLoginButton();
        return new LoginPage(driver);
    }
}
