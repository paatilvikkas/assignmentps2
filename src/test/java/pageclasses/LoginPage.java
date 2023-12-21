package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import runner.BaseClass;

public class LoginPage {
	
     @FindBy(xpath="//*[@name='username']")
     private WebElement username;
     @FindBy(xpath="//*[@name='password']")
     private WebElement password;
     @FindBy(xpath="//*[@type='submit']")
     private WebElement button;
     @FindBy(xpath="//div[@class='_ab2z']")
     private WebElement errorMessage;
     @FindBy(xpath="//*[text()='Forgot password?']")
     private WebElement forgotPassword;
     @FindBy(xpath="//*[@name='cppEmailOrUsername']")
     private WebElement enterEmail;
     @FindBy(xpath="//*[@role='button']")
     private WebElement sendLoginLinkButton;
     @FindBy(xpath="//*[@class='_acb4']")
     private WebElement successFullyResetPasswordMessage;
     @FindBy(xpath="//*[@type='email']")
     private WebElement email;
     @FindBy(xpath="(//*[@class='VfPpkd-vQzf8d'])[2]")
     private WebElement next;
     @FindBy(xpath="(//*[@class='zA yO'])[1]")
     private WebElement mail;
     @FindBy(xpath="(//*[@target='_blank'])[3]")
     private WebElement resetPassword;
     @FindBy(xpath="//*[@placeholder='New password']")
     private WebElement newPassword;
     @FindBy(xpath="//*[@placeholder='New password, again']")
     private WebElement newPasswordAgain;
     @FindBy(xpath="(//*[@class='wbloks_1'])[15]")
     private WebElement resetButton;
     @FindBy(xpath="(//*[@class='x9f619 xxk0z11 xii2z7h x11xpdln x19c4wfv xvy4d1p'])[9]")
     private WebElement profile;
     
     
     String inValidUserame="";
     String inValidPassword="";
     
     
	 public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);}
	
	 public void userShouldLoginSuccessfullyWithValidCredential() {
		username.sendKeys("give username");
		password.sendKeys("give password");
		button.click();
		Assert.assertTrue(profile.isEnabled());
		Reporter.log("user logged Successfully with valid data",true);}
		
     public void errorMessageIsDisplayedWheAttemptingToLogWithIvalidCredential() {
    	username.sendKeys("give any invalid username");
 		password.sendKeys("give any invalid password");
 		button.click();
 		Assert.assertTrue(errorMessage.isDisplayed());
 		Reporter.log("Error message is displayed",true);}
 		
     public void testLoginButtonIsDisabledWhenBothUserNamePasswordAreEmpty() {
    	Assert.assertFalse(button.isEnabled());
    	Reporter.log("Login button is disabled with empty fields",true);}
     
     public void verifyClickingTheForgotPasswordLinkRedirectsTheUserToThePasswordRecoveryPage() {
     	forgotPassword.click();
    	String actualLink=BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals(actualLink, "https://www.instagram.com/accounts/password/reset/");
    	Reporter.log("user redirect to reset password page",true);}
    
     public void confirmThatLoginButtonIsEnabledOnlyWhenUsernameAndPasswordIsFilledWithValidData() {
    	username.sendKeys("give valid username");
		password.sendKeys("give valid password");
		Assert.assertTrue(button.isEnabled());}
     public void ensureThatLoginPageRetainPasswordAndUsernameAfterLoginFailed() {
    	 username.sendKeys("give invalid username");
 		 password.sendKeys("give invalid password");
 		 button.click();
 		 if(errorMessage.isDisplayed()) {
 		     inValidUserame=username.getAttribute("value");
 			 inValidPassword=password.getAttribute("value");
 			 Reporter.log("Username:"+inValidUserame,true);
 			 Reporter.log("password:"+inValidPassword,true);
 			 Reporter.log("login page retained username and password values",true);
 			 }
 		 }
 	 public void  validatePasswordRecoveryFunctionality() {
 		 forgotPassword.click();
 		 enterEmail.sendKeys("Enter email");
 		 sendLoginLinkButton.click();
 		 BaseClass.driver.get("https://mail.google.com");
 		 email.sendKeys("enter email");
 		 next.click();
 		 mail.click();
 		 resetPassword.click();
 		 newPassword.sendKeys("xyz@123");
 		 newPasswordAgain.sendKeys("xyz@123");
 		 resetButton.click();
 		 Assert.assertTrue(profile.isDisplayed());
 	 }   
}
