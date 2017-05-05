package SpringIoc0;

public class Book {
	public String name;
	public String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Book() {
		super();
	}

}
