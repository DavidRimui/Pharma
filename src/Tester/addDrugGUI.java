package Tester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addDrugGUI extends JFrame {
	
	static addDrugGUI drug_frame;
	private JTextField drugName_tf;
	private JTextField drugPrice_tf;
	private JTextField drugQuantity_tf;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					drug_frame = new addDrugGUI();
					drug_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	
	
	/**
	 * Creates the addDrugGUI frame.
	 */
	
	
	/**
	 * This method Initializes all the contents of the frame
	 */
	public addDrugGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 1241, 728);  
		
		JLabel add_new_drug = new JLabel("Add New Drug");
		add_new_drug.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add_new_drug.setBounds(368, 11, 234, 47);
		getContentPane().add(add_new_drug);
		
		JLabel drugName_lbl = new JLabel("Drug Name:");
		drugName_lbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		drugName_lbl.setBounds(68, 110, 234, 59);
		getContentPane().add(drugName_lbl);
		
		JLabel drugPrice_lbl = new JLabel("Drug Price($):");
		drugPrice_lbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		drugPrice_lbl.setBounds(70, 199, 236, 59);
		getContentPane().add(drugPrice_lbl);
		
		JLabel drugQuantity_lbl = new JLabel("Drug Quantity:");
		drugQuantity_lbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		drugQuantity_lbl.setBounds(70, 285, 234, 67);
		getContentPane().add(drugQuantity_lbl);
		
		drugName_tf = new JTextField();
		drugName_tf.setBounds(341, 118, 261, 47);
		getContentPane().add(drugName_tf);
		drugName_tf.setColumns(10);
		
		drugPrice_tf = new JTextField();
		drugPrice_tf.setColumns(10);
		drugPrice_tf.setBounds(341, 213, 261, 47);
		getContentPane().add(drugPrice_tf);
		
		drugQuantity_tf = new JTextField();
		drugQuantity_tf.setColumns(10);
		drugQuantity_tf.setBounds(341, 303, 261, 47);
		getContentPane().add(drugQuantity_tf);
		
		JButton submitDrug = new JButton("Submit New Drug!");
		submitDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(drugName_tf.getText().isEmpty() || drugPrice_tf.getText().isEmpty() || drugQuantity_tf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(submitDrug, "Please Enter all Information and try again.");
				}
				String dName = drugName_tf.getText();
				//Casting the user entered price to an int for simplicity
				
				int dPrice = (int) Double.parseDouble(drugPrice_tf.getText());
				int dQuantity = (int) Double.parseDouble(drugQuantity_tf.getText());
				
				//Now Create a new Row in the database for this drug
				int i = AddDrugDBHelper.save(dName, dPrice, dQuantity);
				if(i > 0) {
					JOptionPane.showMessageDialog(submitDrug, "Drug Was Successfully Added to The dataBase!");
				}
				else {
					JOptionPane.showMessageDialog(submitDrug, "Sorry, Drug Was not Sucessfully added to database!");
				}
				
			}
		});
		submitDrug.setFont(new Font("Tahoma", Font.PLAIN, 30));
		submitDrug.setBounds(795, 449, 313, 98);
		getContentPane().add(submitDrug);
		
		JButton backBtn = new JButton("Back to Main");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PharmacyGUIMain.main(new String[]{});
				addDrugGUI.drug_frame = new addDrugGUI();
				addDrugGUI.drug_frame.dispose();

			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backBtn.setBounds(101, 449, 313, 98);
		getContentPane().add(backBtn);
	}

}
