package com.hatum;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hatum.pages.ProfilePage;

public class SampleTestNgTest extends TestNgTestBase {

  private ProfilePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, ProfilePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);

  }
}
