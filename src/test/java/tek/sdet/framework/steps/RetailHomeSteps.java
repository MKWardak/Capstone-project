package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();
	// create object Retailapage
	// creat

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " ExpectedTitle " + expectedTitle);

	}

	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product " + productValue);
	}

	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
		logger.info("the Product is displayed on home page");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("user clicked on All section");

	}

	@Then("below options are present in shop by department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);

		List<WebElement> actualSideBar = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
			logger.info(actualSideBar.get(i).getText() + " is equal to " + expectedSideBar.get(0).get(i));
		}
//		Assert.assertEquals(expectedSideBar.get(0).get(0), factory.homePage().electronicsSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(1), factory.homePage().computersSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(2), factory.homePage().smartHomeSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(3), factory.homePage().sportsSideBar.getText());
//		Assert.assertEquals(expectedSideBar.get(0).get(4), factory.homePage().automativeSideBar.getText());
//		logger.info("actual is equal to expected");

	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
			if (option.getText().equals(department)) {
				click(option);
				try {
					logger.info(option.getText() + " is present ");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarOptionElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(dept));
					logger.info(dept.getText() + " is present ");
				}
			}

		}

	}
	@When("User change the category to {string}")
	public void user_change_the_category_to(String string) throws InterruptedException {
	   selectByVisibleText(factory.homePage().allDepartmentDropDown, string);
	   Thread.sleep(1000);
	}

	@When("User search for an item {string}")
	public void user_search_for_an_item(String string) throws InterruptedException {
	 factory.homePage().searchBar.sendKeys(string);
	 Thread.sleep(1000);
	}

	@When("User click on Search icon")
	public void user_click_on_search_icon() throws InterruptedException {
		factory.homePage().searchButton.click();
		Thread.sleep(1000);
	   
	}

	@When("User click on item")
	public void user_click_on_item() throws InterruptedException {
	  if(factory.homePage().ApexCoins.isDisplayed()) {
		  factory.homePage().ApexCoins.click();
	  }else if(factory.homePage().smartPlug.isDisplayed())
		  factory.homePage().smartPlug.click();
	  Thread.sleep(2000);
	}

	@When("User select quantity ‘{int}’")
	public void user_select_quantity(Integer int1) throws InterruptedException {
	  factory.homePage().quantityDropDown.click();
	  selectByVisibleText(factory.homePage().quantityDropDown, int1.toString());
	  Thread.sleep(1000);
	}

	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() throws InterruptedException {
	  factory.homePage().addToCartBtn.click();
	  factory.homePage().cartButton.click();
	  Thread.sleep(1000);
	}

	@Then("the cart icon quantity should change to ‘{int}’")
	public void the_cart_icon_quantity_should_change_to(Integer int1) throws InterruptedException {
	 String s =   factory.homePage().cartQuantity.getText();
	 if(s.equals(int1.toString())) {
		 System.out.println("quantity is "+int1);
	 }
	 Thread.sleep(2000);
	}
	@Then("User click on Cart option")
	public void user_click_on_cart_option() throws InterruptedException {
	 factory.homePage().cartButton.click();
	 Thread.sleep(2000);
	}

	@Then("User click on Proceed to Checkout button")
	public void user_click_on_proceed_to_checkout_button() {
	   factory.homePage().proceedBtn.click();
	}

	@Then("User click Add a new address link for shipping address")
	public void user_click_add_a_new_address_link_for_shipping_address() {
	  factory.homePage().shipmentNewAddress.click();
	}

	@Then("User fill new address form with below information")
	public void user_fill_new_address_form_with_below_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>>Data = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.homePage().countryDropDown, Data.get(0).get("country"));
		factory.homePage().fullNameField.sendKeys(Data.get(0).get("fullName"));
		factory.homePage().phnoneNumberField.sendKeys(Data.get(0).get("phoneNumber"));
		factory.homePage().addressBtn.sendKeys(Data.get(0).get("streetAddress"));
		factory.homePage().aptField.sendKeys(Data.get(0).get("apt"));
		factory.homePage().cityField.sendKeys(Data.get(0).get("city"));
		selectByVisibleText(factory.homePage().stateDropDown, Data.get(0).get("state"));
		factory.homePage().zipCodeField.sendKeys(Data.get(0).get("zipCode"));
		Thread.sleep(2000);
		
	}
	
	@Then("User click Add a credit card or Debit Card for Payment method")
	public void user_click_add_a_credit_card_or_debit_card_for_payment_method() {
	   factory.homePage().addPaymentCard.click();
	   
	}
	
	@Then("User click on Place Your Order")
	public void user_click_on_place_your_order() {
	   factory.homePage().placeOrderBtn.click();
	}

	@Then("a message should be displayed ‘Order Placed Successfully’")
	public void a_message_should_be_displayed_order_placed_successfully() throws InterruptedException {
		waitTillPresence(factory.homePage().orderPlacedMessage);
		Assert.assertTrue(isElementDisplayed(factory.homePage().orderPlacedMessage));
		logger.info("Order Placed Successfully");
		
	}
	@When("User click on Orders section")
	public void user_click_on_orders_section() throws InterruptedException {
	factory.homePage().orderBtn.click();
	Thread.sleep(2000);
	}

	@When("User click on first order in list")
	public void user_click_on_first_order_in_list() throws InterruptedException {
	   factory.homePage().orderDetailsBtn.click(); 
	   Thread.sleep(2000);
	   factory.homePage().orderDetailsBtn.click();
	 
	}

	@When("User click on Cancel The Order button")
	public void user_click_on_cancel_the_order_button() {
	  factory.homePage().orderCancelBtn.click();
	}

	@When("User select the cancelation Reason ‘Bought wrong item’")
	public void user_select_the_cancelation_reason_bought_wrong_item() {
	selectByVisibleText(factory.homePage().cancelationReasonDropDown,"Bought wrong item");
	}

	@When("User click on Cancel Order button")
	public void user_click_on_cancel_order_button() {
	 factory.homePage().cancelOrderBtn.click();  
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void a_cancelation_message_should_be_displayed_your_order_has_been_cancelled() {
	  factory.homePage().cancelationMessage.isDisplayed();
	}
	@When("User click on Return Items button")
	public void user_click_on_return_items_button() {
	 factory.homePage().returnBtn.click();
	}

	@When("User select the Return Reason ‘Item damaged’")
	public void user_select_the_return_reason_item_damaged() {
	selectByVisibleText(factory.homePage().returnReason, "Item damaged");
	}

	@When("User select the drop off service ‘FedEx’")
	public void user_select_the_drop_off_service_fed_ex() {
	 selectByVisibleText(factory.homePage().dropOffDropDown, "FedEx"); 
	}

	@When("User click on Return Order button")
	public void user_click_on_return_order_button() {
	   factory.homePage().returnConfirmBtn.click(); 
	}

	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void a_cancelation_message_should_be_displayed_return_was_successful() {
	 factory.homePage().returnCacelationMessage.isDisplayed(); 
	}
	@When("User click on Review button")
	public void user_click_on_review_button() {
	   factory.homePage().reviewBtn.click();
	}

	@When("User write Review headline ‘headline value’ and ‘review text’")
	public void user_write_review_headline_headline_value_and_review_text() {
	    factory.homePage().reviewHeadline.sendKeys("headline value");
	    factory.homePage().writtenReview.sendKeys("review text");
	}

	@When("User click Add your Review button")
	public void user_click_add_your_review_button() {
	   factory.homePage().reviewSubmitBtn.click(); 
	}

	@Then("a review message should be displayed ‘Your review was added successfully’")
	public void a_review_message_should_be_displayed_your_review_was_added_successfully() {
		waitTillPresence(factory.homePage().reviewMessage);
		Assert.assertTrue(isElementDisplayed(factory.homePage().reviewMessage));
		logger.info("Your review was added successfully");
	
	}
}