package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {
	
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// syntax for finding UI elements and storing them in POM classes 
	/**
	 * @FindBy(locatorType = "value")
	 * public WebElement nameOfElement
	 */
	
	@FindBy(xpath="//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;
	
	@FindBy(id ="search")
	public WebElement allDepartmentDropDown;
	
	@FindBy(css = "#searchInput")
	public WebElement searchBar;
	
	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton; 
	
	@FindBy(linkText = "Sign in")
	public WebElement signInButton;
	
	@FindBy(xpath =("//body[1]/div[1]/div[1]/div[1]/div[1]/div[5]/p[1]"))
	public WebElement cartButton;
	
	@FindBy(xpath ="//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemanProductImage;
	
	@FindBy(xpath ="//a[text()='Account']")
	public WebElement accountOption;
	
	@FindBy(id = "hamburgerBtn")
	public WebElement allIcon;
	
	@FindBy(xpath ="//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarElements;
	
	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement electronicsSideBar;
	
	@FindBy(xpath ="//span[text()='Computers']")
	public WebElement computersSideBar;
	
	@FindBy(xpath="//span[text()='Smart Home']")
	public WebElement smartHomeSideBar;
	
	@FindBy(xpath ="//span[text()='Sports']")
	public WebElement sportsSideBar;
	
	@FindBy(xpath ="//span[text()='Automative']")
	public WebElement automativeSideBar;
	
	@FindBy(xpath ="//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarOptionElements;
	
	@FindBy(xpath = ("//p[contains(text(),'Kasa Outdoor Smart Plug')]"))
	public WebElement smartPlug;
	
	@FindBy(xpath = ("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/select[1]"))
    public WebElement quantityDropDown;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = ("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/input[1]"))
    public WebElement cartQuantity;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedBtn;
	
	@FindBy(id = "addAddressBtn")
	public WebElement shipmentNewAddress;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropDown;
	
	@FindBy(id = "fullNameInput")
	public WebElement fullNameField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phnoneNumberField;
	
	@FindBy(id = "streetInput")
	public WebElement addressBtn;
	
	@FindBy(id = "apartmentInput")
	public WebElement aptField;
	
	@FindBy(id = "cityInput")
	public WebElement cityField;
	
	@FindBy(xpath = ("//body/div[@id='root']/div[3]/div[2]/div[1]/div[1]/form[1]/div[5]/div[2]/div[1]/div[1]/select[1]"))
    public WebElement stateDropDown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeField;
	
	@FindBy(id = "addressBtn")
	public WebElement addAdressBtn;
	
	@FindBy(id = "addPaymentBtn")
	public WebElement addPaymentCard;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement cardNameField;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement monthFeildDropDown;
	
	@FindBy(id = "expirationYearInput")
	public WebElement yearFeildDropDown;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath =("//div[contains(text(),'Order Placed Successfully')]"))
	public WebElement orderPlacedMessage;
	
	@FindBy(xpath = ("//p[contains(text(),'Apex Legends - 1,000 Apex Coins')]"))
	public WebElement ApexCoins;
	
	@FindBy(id = "orderLink")
	public WebElement orderBtn;
	
	@FindBy(xpath = ("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/p[2]"))
	public WebElement orderDetailsBtn;
	
	@FindBy(id = "cancelBtn")
	public WebElement orderCancelBtn;
	
	@FindBy(id = "reasonInput")
	public WebElement cancelationReasonDropDown;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelOrderBtn;
	
	@FindBy(xpath = ("//p[contains(text(),'Your Order Has Been Cancelled')]"))
	public WebElement cancelationMessage;
	
	@FindBy(id = "returnBtn")
	public WebElement returnBtn;
	
	@FindBy(id = "reasonInput")
	public WebElement returnReason;
	
	@FindBy(id = "dropOffInput")
	public WebElement dropOffDropDown;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnConfirmBtn;
	
	@FindBy(xpath = ("//p[contains(text(),'Return was successfull')]"))
	public WebElement returnCacelationMessage;
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(id = "headlineInput")
	public WebElement reviewHeadline;
	
	@FindBy(xpath = ("//textarea[@id='descriptionInput']"))
	public WebElement writtenReview;
	
	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBtn;
	
	@FindBy(xpath = ("//div[contains(text(),'Your review was added successfully')]"))
	public WebElement reviewMessage;
	}
