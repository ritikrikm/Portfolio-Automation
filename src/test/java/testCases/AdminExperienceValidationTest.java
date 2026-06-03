package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import data.DataProviders;
import data.ExperiencePOJO;
import pages.AdminExperiencePage;
import utils.ConfigReader;
import utils.ExperienceFactory;

public class AdminExperienceValidationTest extends BaseTest{
	private static final Logger LOG = LogManager.getLogger(AdminExperienceValidationTest.class);
	 AdminExperiencePage page;
	
	@BeforeMethod(alwaysRun=true)
	public  void pageSetup() {
		page = new AdminExperiencePage(getDriver());
		page.navigateTo(ConfigReader.get("URL"));
		page.adminLogin(ConfigReader.get("admin-password"));
	}
	
	@Test(groups= {"smoke"})
	public void adminPageOpened() {
		String actual = page.adminLoginAfterText();
		Assert.assertEquals(actual.toLowerCase(), "studio uploader");
	}
	
	@Test(dataProvider="validExpData" , dataProviderClass = DataProviders.class)
	public void experienceFormWithValidData(ExperiencePOJO exp) {
		
		createExperience(exp);
		saveExperience();
		Assert.assertEquals("Experience saved as draft.", page.confirmationToast());
		int currCount = page.getCurrentTotalExperience();
		LOG.info("Current count is "+currCount);
		Assert.assertEquals(exp.getCompany(), page.unpublisedCmpInfo()[0]);
		Assert.assertEquals(exp.getRole(), page.unpublisedCmpInfo()[1]);
		
		
		
	}
	@Test(dataProvider="validExpData" , dataProviderClass = DataProviders.class,groups= {"1"})
	public void previewImageCSSValidation(ExperiencePOJO exp) {
		createExperience(exp);
		Assert.assertEquals(expectedObjectFit(exp.getCardImgFit()), page.getCSSAttributeCard("object-fit"));
		Assert.assertEquals(expectedObjectPosition(exp.getCardImgFocus()), page.getCSSAttributeCard("object-position"));
		Assert.assertEquals(expectedObjectFit(exp.getExpImgFit()), page.getCSSAttributeCardOnRight("object-fit"));
		Assert.assertEquals(expectedObjectPosition(exp.getExpImgFocus()), page.getCSSAttributeCard("object-position"));

	}
	@Test(dataProvider="invalidFieldLength" , dataProviderClass=DataProviders.class)
	public void invalidLengthDataValidation(String invalidField, String value , String expectedError) {
		ExperiencePOJO exp = ExperienceFactory.validExperience();
		switch(invalidField) {
		case "CompanyName": exp.setCompany(value); break;
		case "CompanyRole":  exp.setRole(value); break;
		case "Location":  exp.setLocation(value); break;
		case "Headline":  exp.setHeadline(value); break;
		case "Story":  exp.setStory(value); break;
		case "Impact":  exp.setImpact(value); break;
		
		}
		createExperience(exp);
		Assert.assertEquals(expectedError , page.getErrorText(invalidField));
	
		
	}
	@Test(dataProvider = "boundaryFileSize" , dataProviderClass = DataProviders.class)
	public void invalidFileSizeExperience(String file , String expectedError) {
		ExperiencePOJO exp = ExperienceFactory.validExperience();
		exp.setFilePathImage(file);
		createExperienceTillImageUpload(exp);
		Assert.assertEquals(expectedError, page.errorToast("File"));
	}
	@Test(dataProvider="missingRequiredFieldData" , dataProviderClass = DataProviders.class)
	public void verifyRequiredFieldValidation(String missingFieldKey , String expectedError) {
		ExperiencePOJO exp = ExperienceFactory.validExperience();
		switch(missingFieldKey) {
		case "CompanyName": exp.setCompany(""); break;
		case "CompanyRole": exp.setRole(""); break;
		case "Location": exp.setLocation(""); break;
		case "Headline": exp.setHeadline(""); break;
		case "Story": exp.setStory(""); break;
		case "Impact": exp.setImpact(""); break;
		
		}
		createExperience(exp);
		page.saveExperience();
		Assert.assertEquals(expectedError, page.getErrorText(missingFieldKey));
	}
	@Test(dataProvider="invalidUploadFileFormat" , dataProviderClass=DataProviders.class)
	public void invalidFileUploadExperience(String filePath , String expectedError) {
		ExperiencePOJO exp = ExperienceFactory.validExperience();
		exp.setFilePathImage(filePath);
		createExperienceTillImageUpload(exp);
		Assert.assertEquals(expectedError, page.errorToast("File"));
	}
	private String expectedObjectFit(String value) {
	    if (value.equals("Show full image")) return "contain";
	    if (value.contains("Crop to fill")) return "cover";
	    throw new RuntimeException("Invalid fit value: " + value);
	}

	private String expectedObjectPosition(String value) {
	    if (value.equals("Center")) return "50% 50%";
	    if (value.equals("Top")) return "50% 0%";
	    if (value.equals("Bottom")) return "50% 100%";
	    if (value.equals("Left")) return "0% 50%";
	    if (value.equals("Right")) return "100% 50%";
	    throw new RuntimeException("Invalid focus value: " + value);
	}
	private void createExperience(ExperiencePOJO exp) {
		int currPrevCount = page.getCurrentTotalExperience();
		LOG.info("Current Prev Count is " + currPrevCount);
		page.selectExperienceCard();
		LOG.info("**************Experience Card Selected**************");
		page.fillExperienceData(exp.getCompany(), exp.getRole(), exp.getDates(), exp.getLocation(), exp.getHeadline(), exp.getStory(), exp.getImpact());
		LOG.info("**************Experience Data Filling**************");
		page.fillExperienceOnPagePosition(exp.getPosition());
		page.fillExperienceCountPosition(exp.getCount());
		LOG.info("**************Experience Card Filled**************");
		page.uploadExperienceImage(exp.getFilePathImage());
		LOG.info("**************Experience Image Uploaded**************");
		page.ImageFit(exp.getCardImgFit());
		page.ImageFocus(exp.getCardImgFocus());
		page.sliderExperience(Integer.parseInt(exp.getSliderZoom1()));
		page.fillExperienceOnDetailPosition(exp.getExpImgFit());
		page.fillExperienceCountDetailPosition(exp.getExpImgFocus());
		page.sliderExperienceDetail(Integer.parseInt(exp.getSliderZoom2()));

		
	}
	private void createExperienceTillImageUpload(ExperiencePOJO exp) {
		int currPrevCount = page.getCurrentTotalExperience();
		LOG.info("Current Prev Count is " + currPrevCount);
		page.selectExperienceCard();
		LOG.info("**************Experience Card Selected**************");
		page.fillExperienceData(exp.getCompany(), exp.getRole(), exp.getDates(), exp.getLocation(), exp.getHeadline(), exp.getStory(), exp.getImpact());
		LOG.info("**************Experience Data Filling**************");
		page.fillExperienceOnPagePosition(exp.getPosition());
		page.fillExperienceCountPosition(exp.getCount());
		LOG.info("**************Experience Card Filled**************");
		page.uploadExperienceImage(exp.getFilePathImage());
		LOG.info("**************Experience Image Uploaded**************");

		
	}
	private void saveExperience() {
		LOG.info("**************Experience Card Filled Completely**************");
		page.saveExperience();
		LOG.info("**************Experience Save**************");
		page.confirmSave();   
		LOG.info("**************Save Confirmed Clicked**************");
	}

}
