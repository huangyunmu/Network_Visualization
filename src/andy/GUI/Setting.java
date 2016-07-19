package andy.GUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import andy.GUI.GraphContainer;

public class Setting extends JFrame {

	private String linkLocation, nodeLocation, outputLocation;
	private int countVar = 7;
	private String errorFileMessage = "The file name is invalid, please double check!";
	private String[] defaultFileName = { "Link", "Node" };

	/** Creates new form Setting */
	public Setting() {
		initComponents();
		linkLocation = "";
		nodeLocation = "";
		outputLocation = "";
		this.title.setText("My_Graph");
		this.setVisible(true);
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		isMultiple = new javax.swing.JCheckBox();
		isNormalized = new javax.swing.JCheckBox();
		isDirected = new javax.swing.JCheckBox();
		jLabel5 = new javax.swing.JLabel();
		back = new javax.swing.JButton();
		drawFigure = new javax.swing.JButton();
		linkLocationButton = new javax.swing.JButton();
		nodeLocationButton = new javax.swing.JButton();
		outputLocationButton = new javax.swing.JButton();
		linkVar1 = new javax.swing.JComboBox();
		linkVar2 = new javax.swing.JComboBox();
		linkVar3 = new javax.swing.JComboBox();
		linkVar4 = new javax.swing.JComboBox();
		linkVar5 = new javax.swing.JComboBox();
		linkVar6 = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		nodeVar1 = new javax.swing.JComboBox();
		nodeVar2 = new javax.swing.JComboBox();
		nodeVar3 = new javax.swing.JComboBox();
		nodeVar4 = new javax.swing.JComboBox();
		nodeVar5 = new javax.swing.JComboBox();
		nodeVar6 = new javax.swing.JComboBox();
		linkVar0 = new javax.swing.JComboBox();
		nodeVar0 = new javax.swing.JComboBox();
		charSetaLabel = new javax.swing.JLabel();
		charSet = new javax.swing.JComboBox();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		title = new javax.swing.JTextPane();
		linkLocationLabel = new javax.swing.JLabel();
		nodeLocationLabel = new javax.swing.JLabel();
		outputLocationLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Setting");

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
		jLabel1.setText("Setting");

		jLabel2.setText("Link information location");

		jLabel3.setText("Node information location(optional)");

		jLabel4.setText("Output Location");

		isMultiple.setText("Multiple graph");
		isMultiple.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isMultipleActionPerformed(evt);
			}
		});

		isNormalized.setText("Normalized input");

		isDirected.setText("Directed link");
		isDirected.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isDirectedActionPerformed(evt);
			}
		});

		jLabel5.setText("Link Variable");

		back.setText("Back");
		back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backActionPerformed(evt);
			}
		});

		drawFigure.setText("Draw Figure");
		drawFigure.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					drawFigureActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		linkLocationButton.setText("Choose file for links ");
		linkLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkLocationButtonActionPerformed(evt);
			}
		});

		nodeLocationButton.setText("Choose file  for nodes");
		nodeLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeLocationButtonActionPerformed(evt);
			}
		});

		outputLocationButton.setText("Choose output location");
		outputLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				outputLocationButtonActionPerformed(evt);
			}
		});

		linkVar1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Node Y", "Node X", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar1ActionPerformed(evt);
			}
		});

		linkVar2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar2ActionPerformed(evt);
			}
		});

		linkVar3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar3ActionPerformed(evt);
			}
		});

		linkVar4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar4ActionPerformed(evt);
			}
		});

		linkVar5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar5ActionPerformed(evt);
			}
		});

		linkVar6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar6ActionPerformed(evt);
			}
		});

		jLabel6.setText("Node Variable");

		nodeVar1.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar1ActionPerformed(evt);
			}
		});

		nodeVar2.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar2ActionPerformed(evt);
			}
		});

		nodeVar3.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar3ActionPerformed(evt);
			}
		});

		nodeVar4.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar4ActionPerformed(evt);
			}
		});

		nodeVar5.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar5ActionPerformed(evt);
			}
		});

		nodeVar6.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar6ActionPerformed(evt);
			}
		});

		linkVar0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Node X", "Node Y", "Shape", "Color",
				"Thickness", "Length", "Link ID", "Link Name", "Comment" }));
		linkVar0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar0ActionPerformed(evt);
			}
		});

		nodeVar0.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", " NodeID", "Shape", "Color", "Size", "Name", "Comment", "X", "Y", "Z" }));
		nodeVar0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar0ActionPerformed(evt);
			}
		});

		charSetaLabel.setText("Char set");

		charSet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF-8", "Unicode", "ANSI" }));

		jLabel7.setText("Title");

		jScrollPane1.setViewportView(title);

		linkLocationLabel.setText("link file location");

		nodeLocationLabel.setText("node file location");

		outputLocationLabel.setText("output location");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(87, 87, 87)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6)
						.addComponent(jLabel5).addComponent(isMultiple).addComponent(jLabel2).addComponent(jLabel3)
						.addComponent(jLabel4).addComponent(jLabel7).addComponent(back,
								javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(linkVar0,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												66, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nodeVar0, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup()
												.addComponent(linkVar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(linkVar2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(linkVar3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(isDirected))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(layout.createSequentialGroup()
																.addComponent(linkVar4,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(linkVar5,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(charSetaLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(charSet,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(linkVar6, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(drawFigure)
												.addGroup(layout.createSequentialGroup()
														.addComponent(nodeVar1, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(nodeVar2, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(nodeVar3, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(nodeVar4, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(nodeVar5, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(nodeVar6, javax.swing.GroupLayout.PREFERRED_SIZE,
																66, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
						.addComponent(isNormalized)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(nodeLocationButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(linkLocationButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(outputLocationButton, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(outputLocationLabel).addComponent(nodeLocationLabel)
										.addComponent(linkLocationLabel))))
				.addGap(50, 50, 50))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(385, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(355, 355, 355)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
										Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel7)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(linkLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkLocationLabel))
						.addGap(10, 10, 10)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel3)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(nodeLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nodeLocationLabel)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(outputLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(outputLocationLabel))
						.addGap(17, 17, 17)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(isMultiple).addComponent(isNormalized).addComponent(isDirected)
								.addComponent(charSetaLabel).addComponent(charSet,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(linkVar1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar0, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(linkVar6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(nodeVar1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar0, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nodeVar6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(drawFigure).addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	// GEN-END:initComponents

	private void nodeVar0ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar0ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nodeVar1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void outputLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.showDialog(new JLabel(), "Choose output location");
		File file = jfc.getSelectedFile();
		outputLocation = file.getAbsolutePath() + "\\";
		this.outputLocationLabel.setText(outputLocation);
		// System.out.println(jfc.getSelectedFile().getName());
	}

	private void nodeLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter filter = new FileNameExtensionFilter("Txt file", "txt");
		jfc.setFileFilter(filter);
		jfc.showDialog(new JLabel(), "Select node data file");
		File file = jfc.getSelectedFile();
		nodeLocation = file.getAbsolutePath();
		if (this.checkFilename(nodeLocation, 1) == true) {
			this.nodeLocationLabel.setText(nodeLocation);
		} else {
			this.nodeLocationLabel.setText(this.errorFileMessage);
		}
		// System.out.println(jfc.getSelectedFile().getName());

	}

	private void linkLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter filter = new FileNameExtensionFilter("Txt file", "txt");
		jfc.setFileFilter(filter);
		jfc.showDialog(new JLabel(), "Select link data file");
		File file = jfc.getSelectedFile();
		linkLocation = file.getAbsolutePath();
		if (this.checkFilename(linkLocation, 0) == true) {
			this.linkLocationLabel.setText(linkLocation);
		} else {
			this.linkLocationLabel.setText(this.errorFileMessage);
		}
		// for testing
		// System.out.println(jfc.getSelectedFile().getName());
	}

	public boolean checkFilename(String testStr, int type) {
		// 0 for link 1 for node
		int l = testStr.length();
		int i = l - 1;
		int j = i;
		while (testStr.charAt(i) != '\\') {
			i--;
		}
		while (testStr.charAt(j) != '.') {
			j--;
		}

		i = i + 1;
		String filename = (String) testStr.subSequence(i, j);
		System.out.println(filename);
		// String[] parts = new String[3];
		String[] splitStr = (filename).split("_");
		if (splitStr.length != 2) {
			return false;
		}
		System.out.printf("%s %s\n", splitStr[0], splitStr[1]);
		System.out.println(this.defaultFileName[type]);
		if (splitStr[0].equals(this.defaultFileName[type]) && splitStr[1].equals("0")) {
			return true;
		}
		return false;
	}

	private void drawFigureActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// TODO add your handling code here:

		boolean isMultiple, isNormalized, isDirected, isAutoLayout;
		isMultiple = this.isMultiple.isSelected();
		isNormalized = this.isNormalized.isSelected();
		isDirected = this.isDirected.isSelected();
		isAutoLayout = true;
		int[] linkVar = new int[10];
		String title = this.title.getText();
		linkVar[0] = linkVar0.getSelectedIndex() + 1;
		linkVar[1] = linkVar1.getSelectedIndex() + 1;
		linkVar[2] = linkVar2.getSelectedIndex();
		linkVar[3] = linkVar3.getSelectedIndex();
		linkVar[4] = linkVar4.getSelectedIndex();
		linkVar[5] = linkVar5.getSelectedIndex();
		linkVar[6] = linkVar6.getSelectedIndex();
		int[] nodeVar = new int[10];
		nodeVar[0] = nodeVar0.getSelectedIndex();
		nodeVar[1] = nodeVar1.getSelectedIndex();
		nodeVar[2] = nodeVar2.getSelectedIndex();
		nodeVar[3] = nodeVar3.getSelectedIndex();
		nodeVar[4] = nodeVar4.getSelectedIndex();
		nodeVar[5] = nodeVar5.getSelectedIndex();
		nodeVar[6] = nodeVar6.getSelectedIndex();
		String charSet = (String) this.charSet.getSelectedItem();

		if (linkVar[1] == 2) {
			linkVar[1] = 1;
		} else if (linkVar[1] == 1) {
			linkVar[1]++;
		}

		for (int i = 0; i < this.countVar; i++) {
			linkVar[i]--;
			if (linkVar[i] == -1) {
				linkVar[i] = 10;
			}
			nodeVar[i]--;
			if (nodeVar[i] == -1) {
				nodeVar[i] = 10;
			}
		}
		for (int i = 0; i < this.countVar; i++) {
			if (nodeVar[i] < 9 && nodeVar[i] > 5) {
				// if the point position need to be set it should be set to
				isAutoLayout = false;
				break;
			}
		}

		boolean[] statusVarList = new boolean[4];
		statusVarList[0] = isNormalized;
		statusVarList[1] = isMultiple;
		statusVarList[2] = isDirected;
		statusVarList[3] = isAutoLayout;

		// validation
		// for testing
		// linkLocation = "C:\\Users\\huangyunmu\\Desktop\\Link_0.txt";
		// nodeLocation = "C:\\Users\\huangyunmu\\Desktop\\Node_0.txt";
		// outputLocation = "C:\\Users\\huangyunmu\\Desktop\\Test\\";

		String errorMessage = "";
		// check whether the link and output location is exist
		if (linkLocation.equals("")) {
			errorMessage = "Please select link location";
			JOptionPane.showMessageDialog(this, errorMessage);
			return;
		}
		if (outputLocation.equals("")) {
			errorMessage = "Please select out location";
			JOptionPane.showMessageDialog(this, errorMessage);
			return;
		}
		// check whether the node x id and node y id is given
		boolean flag1 = false, flag2 = false;
		for (int i = 0; i < countVar; i++) {
			if (linkVar[i] == 0) {
				flag1 = true;
				break;
			}
		}
		for (int i = 0; i < countVar; i++) {
			if (linkVar[i] == 1) {
				flag2 = true;
				break;
			}
		}
		if (flag1 == true && flag2 == true) {
		} else {
			errorMessage = "Please input node x id and node y id";
			JOptionPane.showMessageDialog(this, errorMessage);
			return;
		}
		// check duplicate var
		boolean flag = true;
		for (int i = 0; i < countVar; i++)
			for (int j = 0; j < countVar; j++)
				if (i != j)
					if (linkVar[i] != 10 && linkVar[j] != 10)
						if (linkVar[i] == linkVar[j]) {
							if (linkVar[i] == 8)
								continue;
							flag = false;
							break;
						}
		if (flag == false) {
			errorMessage = "Duplicate variables detected, please double check. Only the comment could be used more than once";
			JOptionPane.showMessageDialog(this, errorMessage);
			return;
		}
		// check node data
		flag = true;
		for (int i = 0; i < countVar; i++)
			for (int j = 0; j < countVar; j++)
				if (i != j)
					if (nodeVar[i] != 10 && nodeVar[j] != 10)
						if (nodeVar[i] == nodeVar[j]) {
							if (nodeVar[i] == 5)
								continue;
							flag = false;
							break;
						}
		if (flag == false) {
			errorMessage = "Duplicate variables detected, please double check. Only the comment could be used more than once";
			JOptionPane.showMessageDialog(this, errorMessage);
			return;
		}
		// for testing
		// System.out.println("link variables");
		// for (int i = 0; i < countVar; i++) {
		// System.out.println(linkVar[i]);
		// }
		// System.out.println("node variables");
		// for (int i = 0; i < countVar; i++) {
		// System.out.println(nodeVar[i]);
		// }

		System.out.printf("%s %b \n", "isMultiple", isMultiple);
		System.out.printf("%s %b \n", "isNormalized", isNormalized);
		System.out.printf("%s %b \n", "isDirected", isDirected);
		System.out.printf("%s %b \n", "isAutolayout", isAutoLayout);
		System.out.printf("%s %s \n", "outputlocation", outputLocation);
		System.out.printf("%s %s \n", "linkLocation", linkLocation);
		System.out.printf("%s %s \n", "nodeLocation", nodeLocation);
		System.out.printf("%s %s \n", "title", title);
		System.out.printf("%s %s \n", "charset", charSet);

		GraphContainer myContainer = new GraphContainer(nodeVar, linkVar, statusVarList, charSet, title, linkLocation,
				nodeLocation, outputLocation);
	}

	private void linkVar6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void linkVar1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void backActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.setVisible(false);
	}

	private void isDirectedActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void isMultipleActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	// public static void main(String args[]) {
	// java.awt.EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// new Setting().setVisible(true);
	// }
	// });
	// }

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton back;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JComboBox charSet;
	private javax.swing.JLabel charSetaLabel;
	private javax.swing.JButton drawFigure;
	private javax.swing.JCheckBox isDirected;
	private javax.swing.JCheckBox isMultiple;
	private javax.swing.JCheckBox isNormalized;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton linkLocationButton;
	private javax.swing.JLabel linkLocationLabel;
	private javax.swing.JComboBox linkVar0;
	private javax.swing.JComboBox linkVar1;
	private javax.swing.JComboBox linkVar2;
	private javax.swing.JComboBox linkVar3;
	private javax.swing.JComboBox linkVar4;
	private javax.swing.JComboBox linkVar5;
	private javax.swing.JComboBox linkVar6;
	private javax.swing.JButton nodeLocationButton;
	private javax.swing.JLabel nodeLocationLabel;
	private javax.swing.JComboBox nodeVar0;
	private javax.swing.JComboBox nodeVar1;
	private javax.swing.JComboBox nodeVar2;
	private javax.swing.JComboBox nodeVar3;
	private javax.swing.JComboBox nodeVar4;
	private javax.swing.JComboBox nodeVar5;
	private javax.swing.JComboBox nodeVar6;
	private javax.swing.JButton outputLocationButton;
	private javax.swing.JLabel outputLocationLabel;
	private javax.swing.JTextPane title;
	// End of variables declaration//GEN-END:variables

}
