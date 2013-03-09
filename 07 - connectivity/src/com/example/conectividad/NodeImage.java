package com.example.conectividad;


public class NodeImage {

	public NodeImage () {
		super();
	}
	
	private String photoDate;
	private String imageName;
	private String photoUrl;
	private String infoUrl;
	
	public String getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(String photoDate) {
		this.photoDate = photoDate;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getInfoUrl() {
		return infoUrl;
	}
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}
	@Override
	public String toString() {
		return "NodeImage [photoDate=" + photoDate + ", imageName=" + imageName
				+ ", photoUrl=" + photoUrl + ", infoUrl=" + infoUrl + "]";
	}
	

	

	//private URL  
	
}
