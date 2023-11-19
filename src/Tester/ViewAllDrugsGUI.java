package Tester;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ViewAllDrugsGUI extends JFrame {
	private JTable table;
	private JPanel contentPane;

	public ViewAllDrugsGUI() {
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		String[] columns = null;
		String[][] tableData = null;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drug_table", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			columns=new String[cols];
			
			for(int i=1;i<=cols;i++){ //have to compensate with this weird for loop because a SQL table isnt exaclty like a java array
				columns[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			
			tableData = new String[rows][cols];
			int rowcount=0;
			
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					tableData[rowcount][i-1]=rs.getString(i);
				}
				rowcount++;
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		table = new JTable(tableData,columns);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}
}
