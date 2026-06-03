package data;



import org.testng.annotations.DataProvider;

import utils.ConfigReader;

public class DataProviders {

	@DataProvider(name="invalidPassword")
	public static Object[][] invalidPassword() {
		
		return new Object[][] {
			{
				"12345","Wrong Passowrd"
			},	
			{
				"1","Wrong Passowrd"
			},
			{
				"adminadminadminadmin","Wrong Passowrd"
			}
		};
		
	}
	@DataProvider(name="validPasswords")
public static String[] validPasswords() {
		
		return new String[] {ConfigReader.get("admin-password")};
		
	}
	@DataProvider(name = "boundaryFileSize")
	public static Object[][] boundaryFileSize(){
		return new Object[][] {
			{"/Users/rik/Downloads/robots.txt","Experience card image must be JPG, PNG, WebP, or GIF."},
			{"/Users/rik/Downloads/11029.pdf","Experience card image must be JPG, PNG, WebP, or GIF."}
		};
	}
	@DataProvider(name="invalidFieldLength")
	public static Object[][] invalidFieldLength(){
		return new Object[][] {
			{"CompanyName","a","Please lengthen this text to 2 characters or more (you are currently using 1 character)."},
			{"CompanyRole","a","Please lengthen this text to 2 characters or more (you are currently using 1 character)."},
			{"Location","a","Please lengthen this text to 2 characters or more (you are currently using 1 character)."},
			{"Headline","a","Please lengthen this text to 8 characters or more (you are currently using 1 character)."},
			{"Headline","aaaaaaa","Please lengthen this text to 8 characters or more (you are currently using 7 characters)."},
			{"Headline","a","Please lengthen this text to 8 characters or more (you are currently using 1 character)."},
			{"Story","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","Please lengthen this text to 30 characters or more (you are currently using 29 characters)."},
			{"Impact","a","Please lengthen this text to 3 characters or more (you are currently using 1 character)."},
			{"Impact","aa","Please lengthen this text to 3 characters or more (you are currently using 2 characters)."},
			
			
			
		};
	}
	@DataProvider(name="invalidUploadFileFormat")
	public static Object[][] invalidFileFormat(){
		return new Object[][] {
			{"/Users/rik/Desktop/Prerna Doc/Fee.pdf","Experience card image must be JPG, PNG, WebP, or GIF."},
			{"/Users/rik/Desktop/Prerna Doc/Statement of Purpose - PrernaSharma.docx","Experience card image must be JPG, PNG, WebP, or GIF."},
			{"/Users/rik/Desktop/Prerna Doc/Prerna Sharma.pptx","Experience card image must be JPG, PNG, WebP, or GIF."},
		};
	}
	@DataProvider(name="invalidSliderExpData")
	public static Object[][] invalidSliderExperienceData() {
		return new Object[][] {
				{
				new ExperiencePOJO("MSL Testing - Invalid Data"
						, 
						"Executive-Testing"
						,
						"Dec 2023 - Jan 2024"
						, 
						"Toronto, ON"
						, 
						"Campaign ideation and visuals"
						, 
						"social media content, video editing, motion graphics, print assets."
						,
						"Led the creative direction for ."
						
						,
						"Auto fill home card"
						,
						"Show 1 card"
						,
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg"
						,
						"Crop to fill card"
						,
						"Center"
						,
						"99"
						,
						"Crop to fill hero"
						,
						"Center"
						,
						"99"
						)
				},{
					new ExperiencePOJO("MSL Testing - Invalid Data" , 
							"Executive-Testing",
							"Dec 2023 - Jan 2024", 
							"Toronto, ON" , 
							"Campaign ideation and visuals", 
							"social media content, video editing, motion graphics, print assets.",
							"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",
							"Auto fill home card",
							"Show 1 card",
							"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
							"Crop to fill card",
							"Center",
							"99",
							"Crop to fill hero",
							"Center",
							"99")
				}
				
		};
		
	
	}
	@DataProvider(name="missingRequiredFieldData")
	public static Object[][] missingRequiredFieldData(){
		return new Object[][] {
			{"CompanyName" , "Please fill out this field."},
			{"CompanyRole" , "Please fill out this field."},
			{"Location" , "Please fill out this field."},
			{"Headline" , "Please fill out this field."},
			{"Story" , "Please fill out this field."},
			{"Impact" , "Please fill out this field."},
			
		};
	}
	@DataProvider(name="validExpData")
	public static Object[][] validExperienceData() {
		return new Object[][] {
			{
				new ExperiencePOJO(
						"MSL Testing - 1" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",
					
						"Auto fill home card",
						"Show 1 card",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Crop to fill card",
						"Center",
						"120",
						"Crop to fill hero",
						"Center",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 2" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",
					
						"Show as home card 1",
						"Show 2 cards",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Crop to fill card",
						"Center",
						"120",
						"Crop to fill hero",
						"Center",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 3" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",
					
						"Show as home card 2",
						"Show 3 cards",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Show full image",
						"Top",
						"120",
						"Show full image",
						"Top",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 4" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",
						
						"Show as home card 3",
						"Show 1 card",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Show full image",
						"Center",
						"120",
						"Show full image",
						"Center",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 5" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",

						"Show as home card 3",
						"Show 1 card",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Show full image",
						"Bottom",
						"120",
						"Show full image",
						"Bottom",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 6" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",

						"Show as home card 3",
						"Show 1 card",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Show full image",
						"Left",
						"120",
						"Show full image",
						"Left",
						"140"
						)
			},
			{
				new ExperiencePOJO(
						"MSL Testing - 7" , 
						"Executive-Testing","Dec 2023 - Jan 2024", "Toronto, ON" , "Campaign ideation and visuals", 
						"social media content, video editing, motion graphics, print assets.",
						"Led the creative direction for Anil Agarwal Foundation, Nand Ghar, and Animal Care Organization, overseeing the complete design ecosystem from social media and print collateral to integrated campaign concepts and visual storytelling. Partnered with stakeholders to translate social impact goals into engaging creative solutions, ensuring cohesive brand communication across digital, print, and experiential platforms.",

						"Show as home card 3",
						"Show 1 card",
						"/Users/rik/Desktop/Padhaii/workspace/automation/src/test/resources/files/MSL_Logo.jpg",
						"Show full image",
						"Right",
						"120",
						"Show full image",
						"Right",
						"140"
						)
			},
		};
	}
}
