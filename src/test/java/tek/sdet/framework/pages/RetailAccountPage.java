package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//img[@id='profileImage']")
	public WebElement profileImage;
	
	@FindBy(id ="nameInput")
	public WebElement profileNameInputField;
	
	@FindBy(id="personalPhoneInput")
	public WebElement profilePhoneNumberField;
	
	@FindBy(xpath ="//button[text()='Update']")
	public WebElement profileUpdateButton;
	
	@FindBy(xpath="//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMessage;
	
	@FindBy(xpath="//p[contains(text(),'Add Address')]")
	public WebElement addAddressBtn;
	
	@FindBy(xpath="//select[@id='countryDropdown']")
	public WebElement countryDropDown;
	
	@FindBy(css=" #fullNameInput")
	public WebElement addressNameInput;
	
	@FindBy(css="#phoneNumberInput")
	public WebElement addressPhoneNumber;
	
	@FindBy(xpath="//input[@id='streetInput']")
	public WebElement streetAddressOption;
	
	@FindBy(xpath="//input[@id='apartmentInput']")
	public WebElement apartmentAddressInput;
	
	@FindBy(css="#cityInput")
	public WebElement addressCityInput;
	
	@FindBy(xpath="//select[@name='state']")
	public WebElement stateAddressInput;
	
	@FindBy(xpath="//input[@id='zipCodeInput']")
	public WebElement addressZipCodeInput;
	
	@FindBy(xpath="//button[@id='addressBtn']")
	public WebElement addressSubmitButton;
	
	@FindBy(xpath=" //div[contains(text(),'Address Added Successfully')]")
	public WebElement addressMessageSuccessfull;
	
	@FindBy(xpath = ("//button[contains(text(),'Remove')]"))
	public WebElement removeAddressBtn;
	
	@FindBy(id="previousPasswordInput")
	public WebElement previousPassword;
	
	@FindBy(id="newPasswordInput")
	public WebElement newPassword;
	
	@FindBy(id="confirmPasswordInput")
	public WebElement confirmPassword;
	
	@FindBy(id="credentialsSubmitBtn")
	public WebElement submitButton;
	
	@FindBy(xpath="//div[contains(text(),'Password Updated Successfully')]")
	public WebElement UpdateMessage;
	
	@FindBy(xpath = ("//p[contains(text(),'Add a payment method')]"))
	public WebElement addPaymentBtn;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNoField;
	
	@FindBy(id= "nameOnCardInput")
	public WebElement nameField;
	
	@FindBy(id= "expirationMonthInput")
	public WebElement monthField;
	
	@FindBy(id= "expirationYearInput")
	public WebElement YearField;
	
	@FindBy(id= "securityCodeInput")
	public WebElement securityCode;
	
	@FindBy(id= "paymentSubmitBtn")
	public WebElement paymentBtn;
	
	@FindBy(xpath = ("//div[contains(text(),'Payment Method added sucessfully')]"))
	public WebElement paymentMessage;
	
	@FindBy(xpath = ("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]"))
	public WebElement editLink;
	
	@FindBy(xpath = ("//button[contains(text(),'Edit')]"))
	public WebElement editButton;
	
	@FindBy(xpath = ("//div[contains(text(),'Payment Method updated Successfully')]"))
	public WebElement updateMessage;
	
	@FindBy(xpath = ("//button[contains(text(),'remove')]"))
	public WebElement removeCardBtn;
	
	@FindBy(xpath = ("//button[contains(text(),'Edit')]"))
	public WebElement editBtn;
	
	
	
	
	

}
