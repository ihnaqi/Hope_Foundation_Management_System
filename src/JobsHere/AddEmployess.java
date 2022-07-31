/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobsHere;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Hope
 * 
 */
public class AddEmployess extends javax.swing.JFrame {
	private static String currentUser;
	Connection con=null;
	PreparedStatement pSt=null;
	ResultSet rSet=null;

	/**
	 * Creates new form AddEmployess
	 */
	public AddEmployess(String currentUser) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.currentUser=currentUser;
	}
	public boolean searchDatabase(String name){
	
			boolean alreadyExist=false;
			try{
				String url="jdbc:ucanaccess://CareDatabase.accdb";
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				con=DriverManager.getConnection(url);
				
				String sql="Select * from AddEmployee";
				pSt=con.prepareStatement(sql);
				rSet=pSt.executeQuery();
				/**
				 *		*********************************************
				 *			Searching the name into the database,
				 *			whether it exist in our list or not.
				 *		*********************************************
				 */
				while(rSet.next()){
				if(name.equalsIgnoreCase(rSet.getString(3))==true){
					alreadyExist=true;
					break;
				}
			}
		}catch(ClassNotFoundException ex){
						System.out.println("ClassNotFoundException : "+ex.getStackTrace());
			}
		catch(SQLException e){
			System.out.println("SQLException :  Boolean wali"+e.getStackTrace());
		}
		return alreadyExist;
	}


	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        userNameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        designationField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Employees");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(230, 252, 234));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Designation");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 160, 30));

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, 30));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 30, 30));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 10));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("Name");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 160, 30));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel10.setText("Username");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 30));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setText("Password");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 160, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 450));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_sort_down_20px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_cancel_20px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        nameField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 102, 102));
        nameField.setBorder(null);
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 170, 30));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_name_tag_30px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 30, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_username_30px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 30, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 180, 10));

        userNameField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        userNameField.setForeground(new java.awt.Color(0, 102, 102));
        userNameField.setBorder(null);
        jPanel2.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 140, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_keepass_30px.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 30, 30));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 180, 10));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_pen_30px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 30, 30));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 180, 10));

        designationField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        designationField.setForeground(new java.awt.Color(0, 102, 102));
        designationField.setBorder(null);
        jPanel2.add(designationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(18, 69, 63));
        jButton1.setText("Save");
        jButton1.setToolTipText("Click to add Emplyee");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 70, 30));

        passwordField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(0, 102, 102));
        passwordField.setBorder(null);
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 140, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 580, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setState(AddEmployess.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new AddandEditJobs(currentUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		if(nameField.getText().trim().isEmpty() || userNameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || designationField.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "All fields must be filed properly!");	
		}
		 else if(searchDatabase(userNameField.getText().trim())){
			JOptionPane.showMessageDialog(null, "Already Exist!");
		}
		else if(!searchDatabase(userNameField.getText().trim())){
			try {		
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				con=DriverManager.getConnection("jdbc:ucanaccess://CareDatabase.accdb");
				String writeToDatabase="insert into AddEmployee(Name, Username, Password, Designation) values ('"+nameField.getText().trim()+"','"+userNameField.getText().trim()+"'"
						+ ",'"+passwordField.getText().trim()+"','"+designationField.getText().trim()+"')";
				pSt=con.prepareStatement(writeToDatabase);
				pSt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Added to database!");
				/**
				 * Now that data has been entered I should go back to previous page.
				 */
				new AddandEditJobs(currentUser).setVisible(true);
				this.dispose();
				/**
				 * Try Block ends here if the program gracefully completes new window will pop up.
					 */
				} catch (SQLException ex) {
					System.out.println("SQL Exception.");
				} catch (ClassNotFoundException ex) {
					System.out.println("ClassNotFoundException : "+ex.getStackTrace());
				}
		
		}
    }//GEN-LAST:event_jButton1ActionPerformed

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
			java.util.logging.Logger.getLogger(AddEmployess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddEmployess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddEmployess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddEmployess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddEmployess(currentUser).setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField designationField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}