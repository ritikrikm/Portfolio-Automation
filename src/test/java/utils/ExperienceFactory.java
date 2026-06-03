package utils;

import data.ExperiencePOJO;

public class ExperienceFactory {
	public static ExperiencePOJO validExperience() {
		return new ExperiencePOJO(
				"MSL Testing - Invalid Data",
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
				);

	}
}
