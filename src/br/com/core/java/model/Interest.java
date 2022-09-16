package br.com.core.java.model;

public class Interest {

	private int id;
	private String likes;
	private String dislikes;
	private String hobbies;
	private String profileUrl;
	private String about;

	public Interest() {
	}

	public Interest(int id, String likes, String dislikes, String hobbies, String profileUrl, String about) {
		super();
		this.id = id;
		this.likes = likes;
		this.dislikes = dislikes;
		this.hobbies = hobbies;
		this.profileUrl = profileUrl;
		this.about = about;
	}

	@Override
	public String toString() {
		return "Interest [id= " + id + ", likes= " + likes + ", dislikes= " + dislikes + ", hobbies= " + hobbies
				+ ", profileUrl= " + profileUrl + ", about= " + about + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getDislikes() {
		return dislikes;
	}

	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
