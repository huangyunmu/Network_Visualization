/*
 * HowToUse.java
 *
 * Created on __DATE__, __TIME__
 */

package andy.GUI;

import javax.swing.JFrame;

/**
 * 
 * @author __USER__
 */
public class HowToUse extends javax.swing.JFrame {

	/** Creates new form HowToUse */
	public HowToUse() {
		initComponents();
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
		jLabel1.setText("How to use this tool? ");

		jButton1.setText("OK");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextArea2.setColumns(20);
		jTextArea2.setEditable(false);
		jTextArea2.setRows(5);
		jTextArea2
				.setText("1 Name the input data file with Link_0.txt(Link_1,\nLink_2.txt for multiple graph) for link and \nNode_0.txt for node information. The link \ninforamtion and output location is necessary,\nwhile the node information is optional.\n2 Select the need variables from the combo box \nand select the property in the check box.\n3 For single graph, you can modify the layout and\nsave the file.\nFor multiple graph, you can modify the layout one\nby one and the resutl will be stroed automatically.\n");
		jScrollPane2.setViewportView(jTextArea2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(164,
																		164,
																		164)
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		79,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(46, 46,
																		46)
																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		355,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(142,
																		142,
																		142)
																.addComponent(
																		jLabel1)))
								.addContainerGap(65, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										296, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1).addGap(36, 36, 36)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// return;
		this.setVisible(false);

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	// public static void main(String args[]) {
	// java.awt.EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// new HowToUse().setVisible(true);
	// }
	// });
	// }

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea2;
	// End of variables declaration//GEN-END:variables

}