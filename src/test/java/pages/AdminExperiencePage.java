package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class AdminExperiencePage extends BasePage {

	public AdminExperiencePage(WebDriver driver) {
		super(driver);
	}
	//Locators
	private By pwdField = By.id("admin-password");
	private By openStudioAdminButton = By.cssSelector("button.button.primary");
	
	private By errorToast = By.xpath("//div[@class='toast'][@role='status']");
	private By openStudioText = By.xpath("//p[@class='eyebrow'][text()='Open Studio']");
	
	private By studioUploaderText = By.xpath("//p[@class='eyebrow'][text()='Studio uploader']");
	
	private By adminModeOne = By.xpath("//div[@class='admin-mode-grid']/button[1]"); 
	private By adminModeTwo = By.xpath("//div[@class='admin-mode-grid']/button[2]"); 
	private By adminModeThree = By.xpath("//div[@class='admin-mode-grid']/button[3]"); 
	
	private By ExpCardText = By.xpath("//p[@class='eyebrow'][text()='Experience cards']");
	

	private By companyField = By.id("experienceCompany");
	private By roleField= By.id("experienceTitle");
	private By datesField= By.id("experienceDates");
	private By locationField= By.id("experienceLocation");
	private By headlineField= By.id("experienceHeadline");
	private By storyField= By.id("experienceSummary");
	private By impactField= By.id("experienceImpact");
	
	private By experienceHomeSlotDropdown = By.id("experienceHomeSlot");
	private By experienceHomeLimitDropdown = By.id("experienceHomeLimit");
	private By experienceImage = By.id("experienceImage"); //type file input
	private By removeImage = By.id("clear-experience-image"); 
	
	private By experienceImageFitDropdown = By.id("experienceImageFit"); 
	private By experienceImagePositionDropdown = By.id("experienceImagePosition"); 
	private By experienceImageZoom = By.id("experienceImageZoom"); 
	
	private By experienceDetailImageFitDropdown = By.id("experienceDetailImageFit"); 
	private By experienceDetailImagePositionDropdown = By.id("experienceDetailImagePosition"); 
	private By experienceDetailImageZoom = By.id("experienceDetailImageZoom"); 
	
	private By experienceCoverPreview = By.cssSelector("div[class='experience-preview-cover ']"); //No Image //has space after class name
	private By experienceCoverPreviewName = By.xpath("//p[@class='eyebrow'][text()='Card preview']/parent::div/strong"); 
	private By experienceCoverPreviewRole = By.xpath("//p[@class='eyebrow'][text()='Card preview']/parent::div/small"); 
	private By experienceCoverPreviewHasImageCSS = By.xpath("//div[starts-with(@class,'experience-preview-cover')]/img"); //Has Image
	
	private By experienceRightPreview = By.cssSelector("aside[class='hero-media-card ']"); //No Image //has space after class name
	private By experienceRightPreviewHasImageCSS = By.xpath("//aside[@class='hero-media-card has-image']/img");//has Image
	
	private By loadingSpinner = By.xpath("//div[@class='loading-banner']");
	private By experienceSaveButton = By.xpath("//form[@id='experience-form']//button[@type='submit']");
	private By experienceClear = By.id("clear-experience-form");
	private By confirmSame = By.xpath("//div[@class='confirm-dialog']/div[@class='confirm-panel']/div[@class='confirm-actions']/button[2]");
	private By currentExperienceList = By.xpath("//div[@class='admin-experience-list']/div");
	private By emptyExperience = By.xpath("//div[@class='admin-experience-list']/div[@class='empty-state-']");
	private By draftSaveToast = By.xpath("//div[@class='toast'][text()='Experience saved as draft.']");
	//unpublished draft locators
	private By draftCmpName = By.xpath("//div[@class='admin-experience-list']/div[last()]/div[1]/strong");
	private By draftCmpRole = By.xpath("//div[@class='admin-experience-list']/div[last()]/div[1]/small");//role · 0 projects · Auto home fill
	
	//error locators
	private By errorName = By.xpath("//label[@class='has-field-error']/small[@data-error-for='experienceCompany']");
	private By errorRole = By.xpath("//label[@class='has-field-error']/small[@data-error-for='experienceTitle']");
	private By errorLocation = By.xpath("//label[@class='has-field-error']/small[@data-error-for='experienceLocation']");
	private By errorHeadline = By.xpath("//label[@class='wide has-field-error']/small[@data-error-for='experienceHeadline']");
	private By errorStory = By.xpath("//label[@class='wide has-field-error']/small[@data-error-for='experienceSummary']");
	private By errorImpact = By.xpath("//label[@class='has-field-error']/small[@data-error-for='experienceImpact']");
	private By imagePathError = By.xpath("//div[@role='status'][@class='toast']");
	//action
	public void adminLogin(String pwd) {
		type(pwdField , pwd);
		click(openStudioAdminButton);
	}
	public String adminLoginAfterText() {
		return getText(studioUploaderText);
		
	}
	public String getErrorText(String errorField) {
		switch(errorField) {
		case "CompanyName": return getText(errorName); 
		case "CompanyRole":  return getText(errorRole); 
		case "Location":  return getText(errorLocation); 
		case "Headline":  return getText(errorHeadline); 
		case "Story":  return getText(errorStory); 
		case "Impact":  return getText(errorImpact); 
		default:throw new RuntimeException("error field " + errorField + " is different");
		}
		
		
	}
	public String errorToast(String key) {
		switch(key) {
		case "Admin": return getToastText(errorToast);
		case "File": return getToastText(imagePathError);
		default:throw new RuntimeException("error in the field "+ key+ " not found");
		}
		
	}
	public String confirmationToast() {
		return getToastText(draftSaveToast);
	}
	public void selectExperienceCard() {
		click(adminModeOne);
	}
	public void fillExperienceData(String companyName, String role , String date , String location, String headline, String story, String impact) {
		type(companyField,companyName);
		type(roleField,role);
		type(datesField,date);
		type(locationField,location);
		type(headlineField,headline);
		type(storyField,story);
		type(impactField,impact);
	}

	//shared card info
	public void fillExperienceOnPagePosition(String pos) {
		selectByVisibleText(experienceHomeSlotDropdown,pos);
	}
	public void fillExperienceCountPosition(String pos) {
		selectByVisibleText(experienceHomeLimitDropdown,pos);
	}
	public void uploadExperienceImage(String file) {
		sendFile(experienceImage,file);
	}
	public void removeImage() {
		click(removeImage);
	}
	//first type of card
	public void ImageFit(String value) {
		selectByVisibleText(experienceImageFitDropdown,value);
	}
	public void ImageFocus(String value) {
		selectByVisibleText(experienceImagePositionDropdown,value);
	}
	
	public void sliderExperience(int pos) {
		slider(experienceImageZoom,pos);
	}
	public String getSliderExpImageZoomValue() {
		return getAttribute(experienceImageZoom,"value");
	}
	//second type of card
	public void fillExperienceOnDetailPosition(String pos) {
		selectByVisibleText(experienceDetailImageFitDropdown,pos);
	}
	public void fillExperienceCountDetailPosition(String pos) {
		selectByVisibleText(experienceDetailImagePositionDropdown,pos);
	}
	public void sliderExperienceDetail(int pos) {
		slider(experienceDetailImageZoom,pos);
	}
	public String getSliderExpDetailZoomValue() {
		return getAttribute(experienceDetailImageZoom,"value");
	}
	public String previewCardNameText() {
		return getText(experienceCoverPreviewName);
	}
	public String previewCardRoleText() {
		return getText(experienceCoverPreviewRole);
	}
	
	public int getCurrentTotalExperience() {
		if(countCards(emptyExperience) == 1) return 0;
		return countCards(currentExperienceList);
	}
	public void saveExperience() {
		elementInvisible(loadingSpinner);
		actionClick(experienceSaveButton);
	}
	public void confirmSave() {
		click(confirmSame);
	}
	public String[] unpublisedCmpInfo() {
		String name = getText(draftCmpName);
		String[] word = getText(draftCmpRole).split(" ");
		String role = word[0];
		return new String[] {name,role};
		
	}
	public void clearExperience() {
		click(experienceClear);
	}
	public String getCSSAttributeCard(String key) {
		return getCSSAttribute(experienceCoverPreviewHasImageCSS,key);
	}
	public String getCSSAttributeCardOnRight(String key) {
		return getCSSAttribute(experienceRightPreviewHasImageCSS,key);
	}
}
