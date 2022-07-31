/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem.ServicesPage;

import java.sql.*;
import java.beans.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hope
 */
public class Availability extends javax.swing.JFrame {

	/**
	 * Creates new form Availability
	 */
	public Availability() {
		initComponents();
		this.setLocationRelativeTo(null);
		availabilityInfo.setBackground(new java.awt.Color(255,255,255));
		availabilityInfo.getTableHeader().setBackground(new java.awt.Color(155,206,102));
		availabilityInfo.getTableHeader().setForeground(new java.awt.Color(255,255,255));
		availabilityInfo.getTableHeader().setOpaque(false);
		
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
			
			String sql="Select * from Ambulances";
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
			boolean isAvailable=false;
			DefaultTableModel model=(DefaultTableModel)availabilityInfo.getModel();
			
			while(rSet.next()){
				serialNumber=rSet.getInt(1);
				vehicleNumber=rSet.getString(2);
				vehicleColor=rSet.getString(3);
				isAvailable=Math.random()>0.5 ? true:false;
				model.insertRow(availabilityInfo.getRowCount(), new Object[]{serialNumber, vehicleNumber, vehicleColor, isAvailable});
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

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JLabel();
        disposeButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availabilityInfo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ambulance Availability");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_nature_care_20px.png"))); // NOI18N
        jLabel9.setToolTipText("Hope Care");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 460));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        minimizeButton.setForeground(new java.awt.Color(255, 255, 255));
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_sort_down_20px.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        disposeButton.setForeground(new java.awt.Color(255, 255, 255));
        disposeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JobsHere/AdminImages/icons8_cancel_20px.png"))); // NOI18N
        disposeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disposeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disposeButtonMouseClicked(evt);
            }
        });

        availabilityInfo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        availabilityInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial Number", "Vechicle Number", "Vehicle Color", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        availabilityInfo.setFocusable(false);
        availabilityInfo.setIntercellSpacing(new java.awt.Dimension(0, 0));
        availabilityInfo.setSelectionBackground(new java.awt.Color(0, 51, 204));
        availabilityInfo.setShowHorizontalLines(false);
        availabilityInfo.setShowVerticalLines(false);
        availabilityInfo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(availabilityInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disposeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disposeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 840, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        // TODO add your handling code here:
        this.setState(Availability.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void disposeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disposeButtonMouseClicked
        // TODO add your handling code here:
        new managementsystem.Ambulance().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_disposeButtonMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

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
			java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Availability().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availabilityInfo;
    private javax.swing.JLabel disposeButton;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizeButton;
    // End of variables declaration//GEN-END:variables
}
