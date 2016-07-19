package andy.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class MainMenu extends JFrame {

	/** Creates new form NewForm */
	public MainMenu() {
		initComponents();
		this.setVisible(true);
	}

	
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Main Menu");

		jButton1.setText("How to use");
		jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Draw Figure");
		jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Exit");
		jButton3.setPreferredSize(new java.awt.Dimension(100, 30));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel1.setText("Network Visualization");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
		jLabel2.setText("Main Menu");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addGap(214, 214, 214)
								.addComponent(jLabel2)
								.addContainerGap(245, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addGap(203,
																		203,
																		203)
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		115,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addGap(25, 25,
																		25)
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(93, 93,
																		93)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addGap(93, 93, 93)
								.addComponent(jButton3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										96,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addComponent(jLabel2)
								.addGap(60, 60, 60)
								.addComponent(jLabel1)
								.addGap(86, 86, 86)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														59,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														59,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														57,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(118, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		HowToUse howToUse = new HowToUse();

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Setting setting = new Setting();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.exit(0);

	}

	/**
	 * @param args the command line arguments
	 */
	//	public static void main(String args[]) {
	//		java.awt.EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				new MainMenu().setVisible(true);
	//			}
	//		});
	//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration//GEN-END:variables

}
