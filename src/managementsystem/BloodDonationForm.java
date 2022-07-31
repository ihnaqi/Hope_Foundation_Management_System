/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahzaib
 */
public class BloodDonationForm extends javax.swing.JFrame {
	private String currentUser;
	private ArrayList<DonationForm> bloodDonor=new ArrayList<>();
	private ArrayList<User> myUser=new ArrayList<>();
	private ArrayList<String> bloodStock=new ArrayList<String>();
	private String gender;
	private final String [] ageArray={"Select", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"
			,"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
	private final String []  bloodGroupArray={"Select", "A+", "AB+", "A-", "AB-", "B+", "B-", "O+", "O-"};
	private final String [] diseaseArray={"Select", "Not Any", "Diabetes", "Heart Patient", "Blood Pressure", "Hepatatis", "Malaria","Other"};
	private final String [] hospitalArray={ "Select", "Aga Khan Hospital", "Liaqat Hospital", "Indus Hospital", 
										"Nawaz Sharif Hospital", "Shaukat Khanam Hospital" };
        
    /**
     * Creates new form Bform
     */
    public BloodDonationForm() {
        initComponents();
		
		
		
    }
	public BloodDonationForm(String user){
		initComponents();
		this.currentUser=user;
		populateArrayList();
		String name="";
		String gender="";
		
		for (User myUser1 : myUser) {
			if (myUser1.getUserName().equals(currentUser)) {
				name = (myUser1.getFirstName() + " " + myUser1.getLastName());
				nameField.setText(name);
				if (myUser1.getGender().equalsIgnoreCase("male")) {
					maleButton.setSelected(true);
					gender="Male";
					femaleButton.setSelected(false);
					transgenderButton.setSelected(false);
				} else if (myUser1.getGender().equalsIgnoreCase("female")) {
					femaleButton.setSelected(true);
					gender="Female";
					maleButton.setSelected(false);
					transgenderButton.setSelected(false);
				} else {
					transgenderButton.setSelected(true);
					gender="Transgender";
					maleButton.setSelected(false);
					femaleButton.setSelected(false);
				}
				break;
			}
		}
		ageBox.setModel(new javax.swing.DefaultComboBoxModel(ageArray));
		hospitalBox.setModel(new javax.swing.DefaultComboBoxModel(hospitalArray));
		diseaseBox.setModel(new javax.swing.DefaultComboBoxModel(diseaseArray));
		bloodGroupBox.setModel(new javax.swing.DefaultComboBoxModel(bloodGroupArray));
	}
	public void populateArrayList(){
		
		try{
			FileInputStream file=new FileInputStream("User.txt");
			ObjectInputStream inputFile=new ObjectInputStream(file);
			boolean endOfFile=false;
			
			while(!endOfFile){
				try
				{
					myUser.add((User)inputFile.readObject());
				}
				catch(EOFException e)
				{
					endOfFile=true;
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f.getMessage());
				}	
			}
			inputFile.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void saveUserToFile(){
		try{
			FileOutputStream file=new FileOutputStream("BloodDonors.txt");
			ObjectOutputStream outputfile=new ObjectOutputStream(file);
			
			for(int i=0; i<bloodDonor.size();i++){
				outputfile.writeObject(bloodDonor.get(i));
			}
			outputfile.close();
			JOptionPane.showMessageDialog(null, "Thanks for your generous Support!");
			new BloodBank(currentUser).setVisible(true);
			this.dispose();
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
	}
	public void addBloodToStock(String bloodGroup) throws FileNotFoundException, IOException{
		FileOutputStream file=new FileOutputStream("Donated_Blood.txt");
		ObjectOutputStream outputFile=new ObjectOutputStream(file);
		
		for(int i=0; i<bloodDonor.size();i++){
			outputFile.writeObject(bloodStock.add(bloodGroup));
		}
		
	}
	public boolean isItInStock(String bloodGroupRequired){
		boolean found=false;
		for(int i=0; i<bloodStock.size(); i++){
			System.out.println("Blood Group : "+bloodStock.get(i));
			if(bloodStock.get(i).equalsIgnoreCase(bloodGroupRequired)){
				bloodStock.remove(i);
				found=true;
				break;
			}
	}
		if(found==false)
		return false;
		
		else 
		return true;
		}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        goBackButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        femaleButton = new javax.swing.JRadioButton();
        transgenderButton = new javax.swing.JRadioButton();
        maleButton = new javax.swing.JRadioButton();
        ageBox = new javax.swing.JComboBox<String>();
        bloodGroupBox = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        phoneNbrField = new javax.swing.JTextField();
        hospitalBox = new javax.swing.JComboBox<String>();
        submitButton = new javax.swing.JButton();
        diseaseBox = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Blood Donation Form");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, 490));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Blood Donation Form");

        goBackButton.setBackground(new java.awt.Color(0, 0, 102));
        goBackButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 255, 255));
        goBackButton.setText("Go Back");
        goBackButton.setToolTipText("Press to get back to the home page");
        goBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        goBackButton.setFocusPainted(false);
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(64, 64, 64)
                .addComponent(goBackButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addGap(51, 51, 51))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 480, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8-nature-care-69.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText(" Gender");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText(" Age");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText(" Full Name ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setText(" Blood Group");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText(" Any Disease");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 30));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText(" Phone No.");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, 30));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setText(" Hospital");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 30));

        jPanel3.setBackground(new java.awt.Color(222, 238, 253));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jPanel3.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 230, 30));

        femaleButton.setBackground(new java.awt.Color(222, 238, 253));
        femaleButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        femaleButton.setText("Female");
        femaleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        femaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleButtonActionPerformed(evt);
            }
        });
        jPanel3.add(femaleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        transgenderButton.setBackground(new java.awt.Color(222, 238, 253));
        transgenderButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        transgenderButton.setText("Transgender");
        transgenderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transgenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transgenderButtonActionPerformed(evt);
            }
        });
        jPanel3.add(transgenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        maleButton.setBackground(new java.awt.Color(222, 238, 253));
        maleButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        maleButton.setText("Male");
        maleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleButtonActionPerformed(evt);
            }
        });
        jPanel3.add(maleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        ageBox.setEditable(true);
        ageBox.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        ageBox.setBorder(null);
        ageBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(ageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 80, 30));

        bloodGroupBox.setEditable(true);
        bloodGroupBox.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        bloodGroupBox.setBorder(null);
        bloodGroupBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(bloodGroupBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, 30));

        jLabel10.setBackground(new java.awt.Color(153, 153, 0));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setText("+92");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 40, 30));

        phoneNbrField.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jPanel3.add(phoneNbrField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 150, 30));

        hospitalBox.setEditable(true);
        hospitalBox.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        hospitalBox.setBorder(null);
        hospitalBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(hospitalBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 150, 30));

        submitButton.setBackground(new java.awt.Color(0, 0, 102));
        submitButton.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit Form");
        submitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel3.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 130, 40));

        diseaseBox.setEditable(true);
        diseaseBox.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        diseaseBox.setBorder(null);
        diseaseBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(diseaseBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 100, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("_________________________________________________________________________");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 440, 20));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 340, 490));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 480, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
		String name="", phoneNbr, bloodGroup, disease, hospital;
		int age,index;
        if(phoneNbrField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() || ageBox.getSelectedIndex()==0 
				|| bloodGroupBox.getSelectedIndex()==0 || diseaseBox.getSelectedIndex()==0 || hospitalBox.getSelectedIndex()==0
				|| (femaleButton.isEnabled()==false && maleButton.isEnabled()==false && transgenderButton.isEnabled()==false)){
			JOptionPane.showMessageDialog(null, "Please fill all the details!");
		}
		else
			 name=nameField.getText().trim();
			 index=ageBox.getSelectedIndex();
			 age =Integer.parseInt(ageBox.getItemAt(index));
			 bloodGroup=(String)bloodGroupBox.getSelectedItem();
			 disease=(String)diseaseBox.getSelectedItem();
			 hospital=(String)hospitalBox.getSelectedItem();
			 phoneNbr=jLabel10.getText()+phoneNbrField.getText().trim();
		
			 bloodDonor.add(new BloodDonor(name, gender, disease, age, bloodGroup, phoneNbr, hospital));
			 saveUserToFile();
			 new BloodBank(currentUser).setVisible(true);
			 this.dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleButtonActionPerformed
        // TODO add your handling code here:
		maleButton.setSelected(true);
		gender="Male";
		femaleButton.setSelected(false);
		transgenderButton.setSelected(false);
    }//GEN-LAST:event_maleButtonActionPerformed

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleButtonActionPerformed
        // TODO add your handling code here:
		femaleButton.setSelected(true);
		gender="Female";
		maleButton.setSelected(false);
		transgenderButton.setSelected(false);
    }//GEN-LAST:event_femaleButtonActionPerformed

    private void transgenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transgenderButtonActionPerformed
        // TODO add your handling code here:
		transgenderButton.setSelected(true);
		gender="Transgender";
		femaleButton.setSelected(false);
		maleButton.setSelected(false);
    }//GEN-LAST:event_transgenderButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:
        new BloodBank(currentUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BloodDonationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodDonationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodDonationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodDonationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodDonationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ageBox;
    private javax.swing.JComboBox<String> bloodGroupBox;
    private javax.swing.JComboBox<String> diseaseBox;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JComboBox<String> hospitalBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNbrField;
    private javax.swing.JButton submitButton;
    private javax.swing.JRadioButton transgenderButton;
    // End of variables declaration//GEN-END:variables
}
