/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Shahzaib
 */
public class FindBloodDonorForm extends javax.swing.JFrame {
	private static String currentUser;
	private ArrayList<FindBloodDonor> findDonor=new ArrayList<FindBloodDonor>();
	private ArrayList<User> myUser=new ArrayList<User>();
	private final String [] ageArray={"Select", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"
			,"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
	private final String []  bloodGroupArray={"Select", "A+", "AB+", "A-", "AB-", "B+", "B-", "O+", "O-"};
	private String gender="";
	

    /**
     * Creates new form Dform
     */
    public FindBloodDonorForm() {
        initComponents();
    }
	public FindBloodDonorForm(String name){
		initComponents();
		populateArrayList();
		this.currentUser=name;
		for(int i=0; i<myUser.size();i++){
			if(myUser.get(i).getUserName().equals(currentUser)){
				nameField.setText(myUser.get(i).getFirstName()+" "+myUser.get(i).getLastName());
				if(myUser.get(i).getGender().equalsIgnoreCase("Male")){
					maleButton.setSelected(true);
					femaleButton.setSelected(false);
					transgenderButton.setSelected(false);
					break;
				}
				else if(myUser.get(i).getGender().equalsIgnoreCase("female")){
					femaleButton.setSelected(true);
					maleButton.setSelected(false);
					transgenderButton.setSelected(false);
					break;
				}
				else if(myUser.get(i).getGender().equalsIgnoreCase("transgender")){
					transgenderButton.setSelected(true);
					maleButton.setSelected(false);
					femaleButton.setSelected(false);
					break;
				}
			}
		}
		ageBox.setModel(new javax.swing.DefaultComboBoxModel(ageArray));
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
			FileOutputStream file=new FileOutputStream("RequestDonor.txt");
			ObjectOutputStream outputFile=new ObjectOutputStream(file);
			for(int i=0; i<findDonor.size();i++){
				outputFile.writeObject(findDonor.get(i));
			}
			outputFile.close();
			JOptionPane.showMessageDialog(null, "Your request has been received!\nYou will shortly be notified!");
			new BloodBank(currentUser).setVisible(true);
			this.disable();
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
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
        jLabel7 = new javax.swing.JLabel();
        goBackButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        femaleButton = new javax.swing.JRadioButton();
        transgenderButton = new javax.swing.JRadioButton();
        maleButton = new javax.swing.JRadioButton();
        ageBox = new javax.swing.JComboBox<String>();
        bloodGroupBox = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find Donor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(252, 219, 219));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        jLabel7.setText("Blood Needed Form");

        goBackButton.setBackground(new java.awt.Color(215, 219, 219));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 490, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, 480));

        jPanel3.setBackground(new java.awt.Color(222, 238, 253));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 30));

        femaleButton.setBackground(new java.awt.Color(222, 238, 253));
        femaleButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        femaleButton.setText("Female");
        femaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleButtonActionPerformed(evt);
            }
        });
        jPanel3.add(femaleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        transgenderButton.setBackground(new java.awt.Color(222, 238, 253));
        transgenderButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        transgenderButton.setText("Transgender");
        transgenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transgenderButtonActionPerformed(evt);
            }
        });
        jPanel3.add(transgenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        maleButton.setBackground(new java.awt.Color(222, 238, 253));
        maleButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        maleButton.setText("Male");
        maleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleButtonActionPerformed(evt);
            }
        });
        jPanel3.add(maleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        ageBox.setEditable(true);
        ageBox.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        ageBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        ageBox.setBorder(null);
        ageBox.setRequestFocusEnabled(true);
        ageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageBoxActionPerformed(evt);
            }
        });
        jPanel3.add(ageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, 30));

        bloodGroupBox.setEditable(true);
        bloodGroupBox.setFont(new java.awt.Font("Trebuchet MS", 0, 17)); // NOI18N
        bloodGroupBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "A-", "B+", "A+", "B-", "O+", "AB-", "O+", "AB+" }));
        bloodGroupBox.setBorder(null);
        jPanel3.add(bloodGroupBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        jLabel10.setBackground(new java.awt.Color(153, 153, 0));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setText("+92");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 40, 30));

        phoneNumberField.setFont(new java.awt.Font("Trebuchet MS", 1, 17)); // NOI18N
        jPanel3.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit Form");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 130, 40));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("_____________________________________________________");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 320, 20));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit Form");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 130, 40));

        submitButton.setBackground(new java.awt.Color(0, 0, 102));
        submitButton.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit Form");
        submitButton.setBorder(null);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel3.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 130, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 320, 460));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText(" Age");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 30));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText(" Full Name");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText(" Gender");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText(" Blood Needed");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText(" Phone No.");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 490, 480));

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8-nature-care-69.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
		String name="", phoneNumber="", bloodGroup="";
		int age=0, selectedIndex=0;
		if(nameField.getText().trim().isEmpty() || ageBox.getSelectedIndex()==0 || (maleButton.isEnabled()==false && femaleButton.isEnabled()==false && transgenderButton.isEnabled()==false)
				|| bloodGroupBox.getSelectedIndex()==0 || phoneNumberField.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Please fill all the fields.");
		}
		else if(new BloodDonationForm(currentUser).isItInStock((String)bloodGroupBox.getSelectedItem())==false){
			JOptionPane.showMessageDialog(null, "Sorry currently we are out of Stock!");
		}
		else if(new BloodDonationForm(currentUser).isItInStock((String)bloodGroupBox.getSelectedItem())==true)
			{
			name=nameField.getText().trim();
			selectedIndex=ageBox.getSelectedIndex();
			age=Integer.parseInt(ageBox.getItemAt(selectedIndex));
			bloodGroup=(String)bloodGroupBox.getSelectedItem();
			phoneNumber=jLabel10.getText()+phoneNumberField.getText().trim();
			findDonor.add(new FindBloodDonor(name,gender,age, bloodGroup,phoneNumber ));
			saveUserToFile();
			new BloodBank(currentUser).setVisible(true);
			this.dispose();
		}
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:
        new BloodBank(currentUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void ageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageBoxActionPerformed

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleButtonActionPerformed
        // TODO add your handling code here:
		gender="male";
		maleButton.setSelected(true);
		femaleButton.setSelected(false);
		transgenderButton.setSelected(false);
    }//GEN-LAST:event_maleButtonActionPerformed

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleButtonActionPerformed
        // TODO add your handling code here:
		gender="female";
		femaleButton.setSelected(true);
		maleButton.setSelected(false);
		transgenderButton.setSelected(false);
    }//GEN-LAST:event_femaleButtonActionPerformed

    private void transgenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transgenderButtonActionPerformed
        // TODO add your handling code here:
		gender="transgender";
		transgenderButton.setSelected(true);
		maleButton.setSelected(false);
		femaleButton.setSelected(false);
    }//GEN-LAST:event_transgenderButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FindBloodDonorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindBloodDonorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindBloodDonorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindBloodDonorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindBloodDonorForm(currentUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ageBox;
    private javax.swing.JComboBox<String> bloodGroupBox;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JButton submitButton;
    private javax.swing.JRadioButton transgenderButton;
    // End of variables declaration//GEN-END:variables
}
