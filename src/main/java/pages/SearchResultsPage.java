package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//a[text()=\"MacBook\"]")
	private WebElement validMacBookProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	// list of product name links shown in search results (caption h4 > a is common in this theme)
	@FindBy(xpath="//div[@class='caption']/h4/a")
	private List<WebElement> productNameLinks;
	
	public boolean displayStatusOfValidProduct() {
		
		return elementUtils.displayStatusOfElement(validHPProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public boolean displayStatusOfValidMacBookProduct() {
		
		return elementUtils.displayStatusOfElement(validMacBookProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getMessageText() {
		
		return elementUtils.getTextFromElement(messageText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	/**
	 * Returns true if any product name in the results contains the provided partialText (case-insensitive).
	 */
	public boolean isAnyProductContaining(String partialText) {
		if (partialText == null || partialText.trim().isEmpty()) {
			return false;
		}
		
		try {
			String needle = partialText.trim().toLowerCase();
			if (productNameLinks == null || productNameLinks.isEmpty()) {
				return false;
			}
			for (WebElement e : productNameLinks) {
				try {
					String name = e.getText();
					if (name != null && name.toLowerCase().contains(needle)) {
						return true;
					}
				} catch (Throwable ignored) {
					// ignore individual element failures and continue
				}
			}
		} catch (Throwable t) {
			// fallback false on any unexpected error
			return false;
		}
		
		return false;
	}

}