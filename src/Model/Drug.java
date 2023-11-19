package Model;

public class Drug {
	String name;
	double price;
	int quantity;
	private static int ID = 1;
	
	public Drug(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		Drug.ID++;
	}
	
	public static Drug createDrug(String name, double price, int quantity) {
		Drug result = new Drug(name, price, quantity);
		
		return result;
	}
	public Drug() {
		
	}
	public Drug(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getID() {
		return Drug.ID;
	}
	
	
	
	
}
