package testclasses;

import org.testng.annotations.Test;

import runner.BaseClass;

public class LoginTest extends BaseClass {
    @Test(enabled=true)
	public void userWithValidCredetialsCanSuccessfullyLogInAndAccessTheSystem() {
		loginPage.userShouldLoginSuccessfullyWithValidCredential();}
    @Test(enabled=true)
    public void validateErrorMessageIsDisplayedWhenUserAttemptingWithInvalidData() {
    	loginPage.errorMessageIsDisplayedWheAttemptingToLogWithIvalidCredential();}
    @Test(enabled=true)
	public void testLoginButtonIsDisabledWhenBothUsernameAndPasswordFieldsEmpty() {
		loginPage.testLoginButtonIsDisabledWhenBothUserNamePasswordAreEmpty();
	}
    @Test(enabled=true)
    public void verifyClickingTheForgotPasswordLinkRedirectsTheUserToThePasswordRecoveryPage() {
    	loginPage.verifyClickingTheForgotPasswordLinkRedirectsTheUserToThePasswordRecoveryPage();
    }
    @Test(enabled=true)
    public void confirmThatLoginButtonIsEnabledOnlyWhenUsernameAndPasswordIsFilledWithValidData() {
    	loginPage.confirmThatLoginButtonIsEnabledOnlyWhenUsernameAndPasswordIsFilledWithValidData();
    }
    @Test(enabled=true)
    public void ensureThatLoginPageRetainPasswordAndUsernameAfterLoginFailed() {
    	loginPage.ensureThatLoginPageRetainPasswordAndUsernameAfterLoginFailed();
    }
    @Test(enabled=true)
    public void validatePasswordRecoveryFunctionality() {
    	loginPage.validatePasswordRecoveryFunctionality();
    }
}
