package data;

public class ExperiencePOJO {
public void setCompany(String company) {
		this.company = company;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public void setFilePathImage(String filePathImage) {
		this.filePathImage = filePathImage;
	}
	public void setCardImgFit(String cardImgFit) {
		this.cardImgFit = cardImgFit;
	}
	public void setCardImgFocus(String cardImgFocus) {
		this.cardImgFocus = cardImgFocus;
	}
	public void setSliderZoom1(String sliderZoom1) {
		this.sliderZoom1 = sliderZoom1;
	}
	public void setExpImgFit(String expImgFit) {
		this.expImgFit = expImgFit;
	}
	public void setExpImgFocus(String expImgFocus) {
		this.expImgFocus = expImgFocus;
	}
	public void setSliderZoom2(String sliderZoom2) {
		this.sliderZoom2 = sliderZoom2;
	}
private String company;
private String role;
private String dates;
private String location;
private String headline;
private String story;
private String impact;
private String position;
private String count;
private String filePathImage;
private String cardImgFit;
private String cardImgFocus;
private String sliderZoom1;
private String expImgFit;
private String expImgFocus;
private String sliderZoom2;
public ExperiencePOJO(
		String company, 
		String role, 
		String dates,
		String location, 
		String headline,
		String story,
		String impact, 
		String position, 
		String count, 
		String filePathImage,
		String cardImgFit,
		String cardImgFocus, 
		String sliderZoom1, 
		String expImgFit, 
		String expImgFocus, 
		String sliderZoom2) {
	this.company = company;
	this.role = role;
	this.dates = dates;
	this.location = location;
	this.headline = headline;
	this.story = story;
	this.impact = impact;
	this.position = position;
	this.count = count;
	this.filePathImage = filePathImage;
	this.cardImgFit = cardImgFit;
	this.cardImgFocus = cardImgFocus;
	this.sliderZoom1 = sliderZoom1;
	this.expImgFocus = expImgFocus;
	this.expImgFit = expImgFit;
	this.sliderZoom2 = sliderZoom2;
}
public String getCompany() {
	return company;
}
public String getRole() {
	return role;
}
public String getDates() {
	return dates;
}
public String getLocation() {
	return location;
}
public String getHeadline() {
	return headline;
}
public String getStory() {
	return story;
}
public String getImpact() {
	return impact;
}
public String getPosition() {
	return position;
}
public String getCount() {
	return count;
}
public String getFilePathImage() {
	return filePathImage;
}
public String getCardImgFit() {
	return cardImgFit;
}
public String getCardImgFocus() {
	return cardImgFocus;
}
public String getSliderZoom1() {
	return sliderZoom1;
}
public String getExpImgFit() {
	return expImgFit;
}
public String getExpImgFocus() {
	return expImgFocus;
}
public String getSliderZoom2() {
	return sliderZoom2;
}


}
