package com.hatum.pagetests;

import com.hatum.TestNgTestBase;
import com.hatum.pages.LoginPage;
import com.hatum.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestNgTestBase {
    ProfilePage profilePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @Test
    protected void verifyProfilePage() throws InterruptedException {
        driver.get(baseUrl);
        loginPage.loginWithTestUser("tester", "K35G3U");
        Thread.sleep(10000);
        Assert.assertTrue(profilePage.varifyIfProfilePage());
        Assert.assertTrue(profilePage.checkUserNamePage("Скворцофф А. И. (Jinior QA. Dptt)"));
    }

}
