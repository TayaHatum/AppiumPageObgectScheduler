package com.hatum.pagetests;

import com.hatum.TestNgTestBase;
import com.hatum.pages.LoginPage;
import com.hatum.pages.ProfilePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestNgTestBase {
    ProfilePage profilePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects(){
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @Test
    public void varifyLoginPage(){
        driver.get(baseUrl);
        Assert.assertEquals(loginPage.getTitle(),"WorkFlow");
    }


    @Test
    public void loginWithValidData() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginWithTestUser("tester","K35G3U");
        Thread.sleep(15000);
        Assert.assertTrue(profilePage.varifyIfProfilePage());

    }


    @Test
    public void loginWithInvalidData() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginWithInvalidData("tester1", "12345t");
        Thread.sleep(5000);
        Assert.assertEquals(loginPage.massegeError(), "Неверное имя пользователя или пароль");
    }

    @Test
    public void loginWithButtonAnotherUser() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginclickAnotherUserBtn();
        Thread.sleep(5000);
        Assert.assertEquals(loginPage.massegeError(),"Аутентификация не удалась");
    }
    @Test
    public void loginWithButtonCurrentUser() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginclickCurrentUserBtn();
        Thread.sleep(5000);
        Assert.assertEquals(loginPage.massegeError(),"Аутентификация не удалась");
    }

    @Test
    public void loginWithValidDataAndRememberMe() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginWithTestUserWithRememberMe("tester","K35G3U");
        Thread.sleep(15000);
        Assert.assertTrue(profilePage.varifyIfProfilePage());


    }

}
