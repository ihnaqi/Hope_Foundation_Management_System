/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hope
 */
public class ListOfHospitals extends javax.swing.JFrame {

	/**
	 * Creates new form HospitalsServices
	 */
	public ListOfHospitals() {
		initComponents();
		this.setLocationRelativeTo(null);
		listOfHospitals.getTableHeader().setBackground(new java.awt.Color(205,102,206));
		listOfHospitals.getTableHeader().setForeground(new java.awt.Color(255,255,255));
		listOfHospitals.getTableHeader().setOpaque(false);
		
		FeedTheTable();
	}
	
	public void FeedTheTable(){
		/*
				********************************************
				   	Getting Connection with Database
				********************************************
		*/
		String url="jdbc:ucanaccess://CareDatabase.accdb";
		
		Connection con= null;
		PreparedStatement pSt=null;
		ResultSet rSet=null;
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			
			String sql="Select * from Hospitals";
			pSt=con.prepareStatement(sql);
			rSet=pSt.executeQuery();
			
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException.");
		}
		catch(SQLException e){
			System.out.println("SQLException.");
		}
		/*
				**************************************
					Retreiving Data int ArrayList
				**************************************
		*/
		try{
			int serialNumber=0;
			String vehicleNumber="", vehicleColor="";
			DefaultTableModel model=(DefaultTableModel)listOfHospitals.getModel();
			
			while(rSet.next()){
				serialNumber=rSet.getInt(1);
				vehicleNumber=rSet.getString(2);
				vehicleColor=rSet.getString(3);
				model.insertRow(listOfHospitals.getRowCount(), new Object[]{serialNumber, vehicleNumber, vehicleColor});
			}
		}catch(SQLException e){
			System.out.println("SQLException.");
		}
		
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        closeWindow = new javax.swing.JButton();
        signOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        careIcon = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfHospitals = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hospital List");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(5, 11, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 500, 40));

        jPanel3.setBackground(new java.awt.Color(3, 5, 20));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8_home_page_40px.png"))); // NOI18N
        Home.setToolTipText("Display Home Page");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        closeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8_close_window_40px.png"))); // NOI18N
        closeWindow.setToolTipText("Close Window");
        closeWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindowActionPerformed(evt);
            }
        });

        signOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8_sign_out_40px.png"))); // NOI18N
        signOut.setToolTipText("Sign Out");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signOut)
                    .addComponent(closeWindow)
                    .addComponent(Home))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeWindow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signOut)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 260));

        jPanel1.setBackground(new java.awt.Color(15, 15, 27));

        careIcon.setForeground(new java.awt.Color(255, 255, 255));
        careIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8_nature_care_50px.png"))); // NOI18N

        header.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Our Hospital Lists");

        jTextField1.setBackground(new java.awt.Color(22, 29, 60));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managementsystem/Images/icons8_search_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(careIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(careIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(header)))
                        .addGap(10, 10, 10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 70));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jScrollPane1.setBorder(null);

        listOfHospitals.setAutoCreateRowSorter(true);
        listOfHospitals.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        listOfHospitals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S No.", "Hospital Name", "Address", "Phone no"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listOfHospitals.setRowHeight(20);
        listOfHospitals.setShowHorizontalLines(false);
        listOfHospitals.setShowVerticalLines(false);
        jScrollPane1.setViewportView(listOfHospitals);
        if (listOfHospitals.getColumnModel().getColumnCount() > 0) {
            listOfHospitals.getColumnModel().getColumn(0).setPreferredWidth(5);
            listOfHospitals.getColumnModel().getColumn(1).setPreferredWidth(110);
            listOfHospitals.getColumnModel().getColumn(2).setPreferredWidth(110);
            listOfHospitals.getColumnModel().getColumn(3).setPreferredWidth(12);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 500, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        MainPage main=new MainPage();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void closeWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindowActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeWindowActionPerformed

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        // TODO add your handling code here:
        LoginPage log=new LoginPage();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_signOutActionPerformed

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
			java.util.logging.Logger.getLogger(ListOfHospitals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ListOfHospitals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ListOfHospitals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ListOfHospitals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ListOfHospitals().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JLabel careIcon;
    private javax.swing.JButton closeWindow;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listOfHospitals;
    private javax.swing.JButton signOut;
    // End of variables declaration//GEN-END:variables
}
