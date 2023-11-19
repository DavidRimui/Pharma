package Tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * This Class provides Helper methods to preform CRUD Operations in the Drug Database
 * @author Chidalu Agbalwa
 *
 */
public class AddClientDBHelper {
	
	
	//Essentially I can Call this method to Create a new Row in my Drug Table
	public static int save(String client_name, String client_email, int client_nod){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into client_table(client_name,client_email,client_num_drugs) values(?,?,?)");
			ps.setString(1,client_name);
			ps.setString(2,client_email);
			ps.setInt(3,client_nod);
			status=ps.executeUpdate(); // returns 1 if the update was successful or 0 if it was not successful
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int saveDrugs(List<String> selectedDrugs, int clientID){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			for(String s: selectedDrugs) {
				PreparedStatement ps2 = con.prepareStatement("SELECT * from drug_table where drug_Name= ? ");
				ps2.setString(1, s);
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int drugID = rs2.getInt(1);
				
				PreparedStatement ps3 = con.prepareStatement("INSERT INTO drug_client_db (client_db_id,drug_id) VALUES (?,?)");
				ps3.setInt(1, clientID);
				ps3.setInt(2, drugID);
				
				status = ps3.executeUpdate(); //status2 should be same size as selected Drugs, returns 1 if the update was successful or 0 if it was not successful
				
			}
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
	
	
	public static String getRow(String client_name) {
		String result = "";
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from client_table WHERE client_Name = ?");
			ps.setString(1, client_name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("client_ID");
				String name =  rs.getString("client_Name");
				String email = rs.getString("client_email");
				int drugNum = rs.getInt("client_num_drugs");
				
				result = "Client with ID: " + id + "\n" + "Name: " + name + "\n" + "Email: " + email + "\n" + "Drug Number: " + drugNum; 
			}
			
			if(result.isEmpty()) {
				result = "No such Client found in database, please check spelling and try again.";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	

}
