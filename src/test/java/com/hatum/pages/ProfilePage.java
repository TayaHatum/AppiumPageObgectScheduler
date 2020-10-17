package com.hatum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ProfilePage extends Page {
  @FindBy(id="userName")
  WebElement userName;


  public ProfilePage(WebDriver webDriver) {
    super(webDriver);
  }

public boolean varifyIfProfilePage(){
      if (getTitle().contains("Лента - WorkFlow")){
          return true;}
      return false;
}

public boolean checkUserNamePage(String name){
    if (userName.isDisplayed()&userName.getText().equals(name)){
      return true;
    }
    return false;
}
}
