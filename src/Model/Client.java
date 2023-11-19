package Model;

import javax.swing.JTextField;

public class Client {
	private String name;
	private Drug[] drugs;
	static int id = 300;
	private String ID = "2123" + id++;
	private String email;
	int nod; // number of drugs
	
	public Client(String name, String email) {
		this.name = name;
		this.email = email;
		this.drugs = new Drug[10];
	}

	public Client(String name) {
		this.name = name;
		this.drugs = new Drug[10];
	}
	public Client() {
		this.drugs = new Drug[10];
	}
	public void addDrug(Drug nameOfDrug) {
		this.drugs[nod] = nameOfDrug;
		this.nod++;
	}
	public Drug[] getDrugs() {
		Drug[] tempDrugs = new Drug[nod];
		for(int i = 0; i < this.nod; i++) {
			tempDrugs[i] = this.drugs[i];
		}
		return tempDrugs;
	}
	
	public String listDrugs( ) {
		String result = "The Users Drugs are: ";
		for(int i = 0; i < this.nod; i++) {
			result+= this.drugs[i].name + "\n";
		}
		
		return result;
	}
	
	public double getBill() {
		double result = 0.0;
		for(int i = 0; i < this.nod; i++) {
			result+= this.drugs[i].price;
		}
		
		return result;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName () {
		String result = "";
		result = this.name;

		return result;
	}
	
	public String getID() {
		return this.ID;
	}
	
	
	
	public static Client create(String name) {
		return new Client(name);
	}
	
	public static Client create(String name,String email) {
		return new Client(name,email);
	}
	
	

}
