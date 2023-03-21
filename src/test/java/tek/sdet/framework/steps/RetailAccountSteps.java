package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		sendText(factory.accountPage().profileNameInputField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profilePhoneNumberField, phoneValue);
		logger.info("user updated Name and Phone values ");
	}
	@When("User click on Update button") 
	public void userClickOnUpdateButton() {
	click(waitTillClickable(factory.accountPage().profileUpdateButton));
		logger.info("user clicked on Update button");
		
		
	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("user profile information updated");
	}
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
	  factory.accountPage().addAddressBtn.click();
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	List<Map<String, String>>Data = dataTable.asMaps(String.class, String.class);
	selectByVisibleText(factory.accountPage().countryDropDown, Data.get(0).get("country"));
	factory.accountPage().addressNameInput.sendKeys(Data.get(0).get("fullName"));
	factory.accountPage().addressPhoneNumber.sendKeys(Data.get(0).get("phoneNumber"));
	factory.accountPage().streetAddressOption.sendKeys(Data.get(0).get("streetAddress"));
	factory.accountPage().apartmentAddressInput.sendKeys(Data.get(0).get("apt"));
	factory.accountPage().addressCityInput.sendKeys(Data.get(0).get("city"));
	factory.accountPage().stateAddressInput.sendKeys(Data.get(0).get("state"));
	factory.accountPage().addressZipCodeInput.sendKeys(Data.get(0).get("zipCode"));
	Thread.sleep(5000);
	}
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() throws InterruptedException {
    factory.accountPage().addressSubmitButton.click();
	Thread.sleep(2000);
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String string) throws InterruptedException {
	waitTillPresence(factory.accountPage().addressMessageSuccessfull);
	Assert.assertTrue(isElementDisplayed(factory.accountPage().addressMessageSuccessfull));
	logger.info("Address Added Successfully");
	Thread.sleep(2000);
	}
	@When("User enter below information")
	public void user_enter_below_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	 List<Map<String,String>>Data = dataTable.asMaps(String.class, String.class);
	factory.accountPage().previousPassword.sendKeys(Data.get(0).get("previousPassword"));
	Thread.sleep(2000);
	factory.accountPage().newPassword.sendKeys(Data.get(0).get("newPassword"));
	Thread.sleep(2000);
	factory.accountPage().confirmPassword.sendKeys(Data.get(0).get("confirmPassword"));
	Thread.sleep(2000);	
	}

	@And("User click on Change Password button")
	public void user_click_on_change_password_button() {
		factory.accountPage().submitButton.click();
	  
	}

	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void a_message_should_be_displayed_password_updated_successfully() throws InterruptedException {
		waitTillPresence(factory.accountPage().UpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().UpdateMessage));
		logger.info("Password Updated Successfully");
		Thread.sleep(2000);
	}
	@When("User click on Add a payment method link")
	public void user_click_on_add_a_payment_method_link() throws InterruptedException {
	    factory.accountPage().addPaymentBtn.click();
	    Thread.sleep(2000);
	}

	@When("User fill Debit or credit card information")
	public void user_fill_debit_or_credit_card_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>>Data = dataTable.asMaps(String.class, String.class);
		factory.accountPage().cardNoField.sendKeys(Data.get(0).get("cardNumber"));
		Thread.sleep(2000);
		factory.accountPage().nameField.sendKeys(Data.get(0).get("nameOnCard"));
		Thread.sleep(2000);
		factory.accountPage().monthField.sendKeys(Data.get(0).get("expirationMonth"));
		Thread.sleep(2000); 
		factory.accountPage().YearField.sendKeys(Data.get(0).get("expirationYear"));
		Thread.sleep(2000);
		factory.accountPage().securityCode.sendKeys(Data.get(0).get("securityCode"));
		Thread.sleep(2000);
	}

	@When("User click on Add your card button")
	public void user_click_on_add_your_card_button() throws InterruptedException {
	    factory.accountPage().paymentBtn.click();
		Thread.sleep(2000);

	}

	@Then("a message should be displayed ‘Payment Method added successfully’")
	public void a_message_should_be_displayed_payment_method_added_successfully() throws InterruptedException {
		waitTillPresence(factory.accountPage().paymentMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMessage));
		logger.info("Payment Method added sucessfully");
		Thread.sleep(2000);
	}
	
	@When("User click on Edit option of card section")
	public void user_click_on_edit_option_of_card_section() throws InterruptedException {
	    factory.accountPage().editLink.click();
	    factory.accountPage().editButton.click();
	    Thread.sleep(2000);
	}

	@When("user edit information with below data")
	public void user_edit_information_with_below_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>>Data = dataTable.asMaps(String.class, String.class);
		factory.accountPage().cardNoField.clear();
		factory.accountPage().cardNoField.sendKeys(Data.get(0).get("cardNumber"));
		Thread.sleep(2000);
		factory.accountPage().nameField.clear();
		factory.accountPage().nameField.sendKeys(Data.get(0).get("nameOnCard"));
		Thread.sleep(2000);
		selectByVisibleText(factory.accountPage().monthField, Data.get(0).get("expirationMonth"));
		Thread.sleep(2000);
		selectByVisibleText(factory.accountPage().YearField, Data.get(0).get("expirationYear"));
		Thread.sleep(2000);
		factory.accountPage().securityCode.clear();
		factory.accountPage().securityCode.sendKeys(Data.get(0).get("securityCode"));
		Thread.sleep(2000);
	}

	@When("user click on Update Your Card button")
	public void user_click_on_update_your_card_button() {
    factory.accountPage().paymentBtn.click();
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void a_message_should_be_displayed_payment_method_updated_successfully() throws InterruptedException {
		waitTillPresence(factory.accountPage().updateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().updateMessage));
		logger.info("Payment Method updated sucessfully");
		Thread.sleep(2000);
	}
    
	@When("User click on remove option of card section")
	public void user_click_on_remove_option_of_card_section() {
	   factory.accountPage().editLink.click();
	   factory.accountPage().removeCardBtn.click();
	}

	@Then("payment details should be removed")
	public void payment_details_should_be_removed() throws InterruptedException {
		factory.accountPage().cardNoField.isDisplayed();
		Thread.sleep(2000);
	}
	
	@When("User click on edit address option")
	public void user_click_on_edit_address_option() throws InterruptedException {
	  factory.accountPage().editBtn.click();
	  Thread.sleep(2000);
	}

	@When("user fill existing address form with new information")
	public void user_fill_existing_address_form_with_new_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>>Data = dataTable.asMaps(String.class, String.class);
	selectByVisibleText(factory.accountPage().countryDropDown, Data.get(0).get("country"));
	sendValueUsingJS(factory.accountPage().addressNameInput, "");
	factory.accountPage().addressNameInput.sendKeys(Data.get(0).get("fullName"));
	sendValueUsingJS(factory.accountPage().addressPhoneNumber, "");
	sendValueUsingJS(factory.accountPage().addressPhoneNumber, Data.get(0).get("phoneNumber"));
	sendValueUsingJS(factory.accountPage().streetAddressOption, "");
	sendValueUsingJS(factory.accountPage().streetAddressOption, Data.get(0).get("streetAddress"));
	sendValueUsingJS(factory.accountPage().apartmentAddressInput, "");
	sendValueUsingJS(factory.accountPage().apartmentAddressInput, Data.get(0).get("apt"));
	Thread.sleep(2000);
	sendValueUsingJS(factory.accountPage().addressCityInput, "");
	sendValueUsingJS(factory.accountPage().addressCityInput, Data.get(0).get("city"));
	selectByVisibleText(factory.accountPage().stateAddressInput, Data.get(0).get("state"));
	sendValueUsingJS(factory.accountPage().addressZipCodeInput, "");
	sendValueUsingJS(factory.accountPage().addressZipCodeInput, Data.get(0).get("zipCode"));
	Thread.sleep(2000);
	}

	@When("User click update Your Address button")
	public void user_click_update_your_address_button() throws InterruptedException {
	    factory.accountPage().addressSubmitButton.click();
	    Thread.sleep(2000);
	}

	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void a_message_should_be_displayed_address_updated_successfully() throws InterruptedException {
		waitTillPresence(factory.accountPage().addressMessageSuccessfull);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addressMessageSuccessfull));
		logger.info("Address Added Successfully");
		Thread.sleep(2000);
	}
	@When("User click on remove option of Address section")
	public void user_click_on_remove_option_of_address_section() {
	   factory.accountPage().removeAddressBtn.click();
	}

	@Then("Address details should be removed")
	public void address_details_should_be_removed() {
	   factory.accountPage().addAddressBtn.isDisplayed();
	}


}
