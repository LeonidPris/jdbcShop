package models;

public class Good {
	int id;
	String title;
	int price;
	String photoName;
	
	public Good(int id, String title, int price, String photoName) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.photoName = photoName;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public String getPhotoName() {
		return photoName;
	}
	

}
