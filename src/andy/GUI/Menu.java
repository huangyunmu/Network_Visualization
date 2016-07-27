package andy.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Menu extends JFrame {

	private String linkLocation, nodeLocation, outputLocation;
	private int countVar = 7;
	private String errorFileMessage = "The file name is invalid, please double check!";
	private String[] defaultFileName = { "Link", "Node" };

	/** Creates new form Setting */
	public Menu() {
		setResizable(false);
		initComponents();
		linkLocation = "";
		nodeLocation = "";
		outputLocation = "";
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		titlePanel = new JPanel();
		GridBagConstraints gbc_titlePanel = new GridBagConstraints();
		gbc_titlePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_titlePanel.insets = new Insets(0, 0, 5, 5);
		gbc_titlePanel.gridx = 0;
		gbc_titlePanel.gridy = 0;
		centerPanel.add(titlePanel, gbc_titlePanel);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[] { 250, 400, 150 };
		gbl_titlePanel.rowHeights = new int[] { 40, 0 };
		gbl_titlePanel.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gbl_titlePanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		titlePanel.setLayout(gbl_titlePanel);
		titleLabel = new javax.swing.JLabel();
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.WEST;
		gbc_titleLabel.insets = new Insets(0, 0, 0, 5);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		titlePanel.add(titleLabel, gbc_titleLabel);

		titleLabel.setText("Title");
		titleTextField = new javax.swing.JTextPane();
		titleTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleTextField.setText("My_graph");
		GridBagConstraints gbc_titleTextFile = new GridBagConstraints();
		gbc_titleTextFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleTextFile.insets = new Insets(0, 0, 0, 5);
		gbc_titleTextFile.gridx = 1;
		gbc_titleTextFile.gridy = 0;
		titlePanel.add(titleTextField, gbc_titleTextFile);
		titleTextField.setAlignmentY(Component.TOP_ALIGNMENT);
		titleTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 5;
		centerPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 150, 600, 150, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 27, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);
		helpButton = new javax.swing.JButton();
		GridBagConstraints gbc_helpButton = new GridBagConstraints();
		gbc_helpButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_helpButton.insets = new Insets(0, 0, 0, 5);
		gbc_helpButton.gridx = 0;
		gbc_helpButton.gridy = 0;
		buttonPanel.add(helpButton, gbc_helpButton);

		helpButton.setText("Help");
		helpButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				helpActionPerformed(evt);
			}
		});

		copyrightLabel = new JLabel("Copyright-The HK Polytechnic University");
		copyrightLabel.setForeground(Color.LIGHT_GRAY);
		copyrightLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_copyrightLabel = new GridBagConstraints();
		gbc_copyrightLabel.insets = new Insets(0, 0, 0, 5);
		gbc_copyrightLabel.gridx = 1;
		gbc_copyrightLabel.gridy = 0;
		buttonPanel.add(copyrightLabel, gbc_copyrightLabel);
		drawFigureButton = new javax.swing.JButton();
		GridBagConstraints gbc_drawFigureButton = new GridBagConstraints();
		gbc_drawFigureButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_drawFigureButton.gridx = 2;
		gbc_drawFigureButton.gridy = 0;
		buttonPanel.add(drawFigureButton, gbc_drawFigureButton);

		drawFigureButton.setText("Draw");
		drawFigureButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					drawFigureActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		leftPanel = new JPanel();
		getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

		rightPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) rightPanel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(rightPanel, BorderLayout.EAST);
		this.setVisible(true);
		this.setSize(1024, 600);
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		// this.setSize(1024, 600);
		Toolkit tool = this.getToolkit(); // 得到一个Toolkit对象
		Image myimage = tool.getImage("resource/logo.png"); // 由tool获取图像
		this.setIconImage(myimage);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Network Visualization Tool-Menu");
		centerPanel = new JPanel();
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[] { 800, 0 };
		gbl_centerPanel.rowHeights = new int[] { 50, 150, 50, 50, 0, 50 };
		gbl_centerPanel.columnWeights = new double[] { 1.0 };
		gbl_centerPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		centerPanel.setLayout(gbl_centerPanel);

		filePanel = new JPanel();
		GridBagConstraints gbc_filePanel = new GridBagConstraints();
		gbc_filePanel.insets = new Insets(0, 0, 5, 5);
		gbc_filePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_filePanel.gridx = 0;
		gbc_filePanel.gridy = 1;
		centerPanel.add(filePanel, gbc_filePanel);
		GridBagLayout gbl_filePanel = new GridBagLayout();
		gbl_filePanel.columnWidths = new int[] { 250, 300, 150, 0 };
		gbl_filePanel.rowHeights = new int[] { 50, 50, 50, 0 };
		gbl_filePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_filePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		filePanel.setLayout(gbl_filePanel);
		linkLocationButton = new javax.swing.JButton();
		linkLocationButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_linkLocationButton = new GridBagConstraints();
		gbc_linkLocationButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkLocationButton.insets = new Insets(0, 0, 5, 5);
		gbc_linkLocationButton.gridx = 0;
		gbc_linkLocationButton.gridy = 0;
		filePanel.add(linkLocationButton, gbc_linkLocationButton);

		linkLocationButton.setText("Choose file for links ");
		linkLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkLocationButtonActionPerformed(evt);
			}
		});
		linkLocationLabel = new javax.swing.JLabel();
		linkLocationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_linkLocationLabel = new GridBagConstraints();
		gbc_linkLocationLabel.anchor = GridBagConstraints.WEST;
		gbc_linkLocationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_linkLocationLabel.gridx = 1;
		gbc_linkLocationLabel.gridy = 0;
		filePanel.add(linkLocationLabel, gbc_linkLocationLabel);

		linkLocationLabel.setText("Link file location");
		nodeLocationButton = new javax.swing.JButton();
		nodeLocationButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_nodeLocationButton = new GridBagConstraints();
		gbc_nodeLocationButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeLocationButton.insets = new Insets(0, 0, 5, 5);
		gbc_nodeLocationButton.gridx = 0;
		gbc_nodeLocationButton.gridy = 1;
		filePanel.add(nodeLocationButton, gbc_nodeLocationButton);

		nodeLocationButton.setText("Choose file for nodes");
		nodeLocationLabel = new javax.swing.JLabel();
		nodeLocationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_nodeLocationLabel = new GridBagConstraints();
		gbc_nodeLocationLabel.anchor = GridBagConstraints.WEST;
		gbc_nodeLocationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nodeLocationLabel.gridx = 1;
		gbc_nodeLocationLabel.gridy = 1;
		filePanel.add(nodeLocationLabel, gbc_nodeLocationLabel);

		nodeLocationLabel.setText("Node file location(Optional)");

		nodeLocationCheckBox = new JCheckBox("New check box");
		nodeLocationCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_nodeLocationCheckBox = new GridBagConstraints();
		gbc_nodeLocationCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_nodeLocationCheckBox.gridx = 2;
		gbc_nodeLocationCheckBox.gridy = 1;
		filePanel.add(nodeLocationCheckBox, gbc_nodeLocationCheckBox);
		outputLocationButton = new javax.swing.JButton();
		outputLocationButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_outputLocationButton = new GridBagConstraints();
		gbc_outputLocationButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputLocationButton.insets = new Insets(0, 0, 0, 5);
		gbc_outputLocationButton.gridx = 0;
		gbc_outputLocationButton.gridy = 2;
		filePanel.add(outputLocationButton, gbc_outputLocationButton);

		outputLocationButton.setText("Choose output location");
		outputLocationLabel = new javax.swing.JLabel();
		outputLocationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_outputLocationLabel = new GridBagConstraints();
		gbc_outputLocationLabel.anchor = GridBagConstraints.WEST;
		gbc_outputLocationLabel.insets = new Insets(0, 0, 0, 5);
		gbc_outputLocationLabel.gridx = 1;
		gbc_outputLocationLabel.gridy = 2;
		filePanel.add(outputLocationLabel, gbc_outputLocationLabel);

		outputLocationLabel.setText("Output location");

		outputLocationCheckBox = new JCheckBox("New check box");
		outputLocationCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_outputLocationCheckBox = new GridBagConstraints();
		gbc_outputLocationCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_outputLocationCheckBox.gridx = 2;
		gbc_outputLocationCheckBox.gridy = 2;
		filePanel.add(outputLocationCheckBox, gbc_outputLocationCheckBox);
		outputLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				outputLocationButtonActionPerformed(evt);
			}
		});
		nodeLocationButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeLocationButtonActionPerformed(evt);
			}
		});

		JPanel checkBoxPanel = new JPanel();
		GridBagConstraints gbc_checkBoxPanel = new GridBagConstraints();
		gbc_checkBoxPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxPanel.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxPanel.gridx = 0;
		gbc_checkBoxPanel.gridy = 2;
		centerPanel.add(checkBoxPanel, gbc_checkBoxPanel);
		GridBagLayout gbl_checkBoxPanel = new GridBagLayout();
		gbl_checkBoxPanel.columnWidths = new int[] { 150, 150, 150, 150, 120, 0 };
		gbl_checkBoxPanel.rowHeights = new int[] { 50, 0 };
		gbl_checkBoxPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_checkBoxPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		checkBoxPanel.setLayout(gbl_checkBoxPanel);
		isMultiple = new javax.swing.JCheckBox();
		isMultiple.setToolTipText("If you need to draw more than one figures");
		isMultiple.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		isMultiple.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_isMultiple = new GridBagConstraints();
		gbc_isMultiple.fill = GridBagConstraints.VERTICAL;
		gbc_isMultiple.insets = new Insets(0, 0, 0, 5);
		gbc_isMultiple.gridx = 0;
		gbc_isMultiple.gridy = 0;
		checkBoxPanel.add(isMultiple, gbc_isMultiple);

		isMultiple.setText("Multiple graph");
		isMultiple.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isMultipleActionPerformed(evt);
			}
		});
		isNormalized = new javax.swing.JCheckBox();
		isNormalized.setToolTipText("The value of numberic input is between 0~1 ");
		isNormalized.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_isNormalized = new GridBagConstraints();
		gbc_isNormalized.fill = GridBagConstraints.VERTICAL;
		gbc_isNormalized.insets = new Insets(0, 0, 0, 5);
		gbc_isNormalized.gridx = 1;
		gbc_isNormalized.gridy = 0;
		checkBoxPanel.add(isNormalized, gbc_isNormalized);

		isNormalized.setText("Normalized input");
		isDirected = new javax.swing.JCheckBox();
		isDirected.setToolTipText("If the link has direction\r\n");
		isDirected.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_isDirected = new GridBagConstraints();
		gbc_isDirected.fill = GridBagConstraints.VERTICAL;
		gbc_isDirected.insets = new Insets(0, 0, 0, 5);
		gbc_isDirected.gridx = 2;
		gbc_isDirected.gridy = 0;
		checkBoxPanel.add(isDirected, gbc_isDirected);

		isDirected.setText("Directed link");
		isDirected.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isDirectedActionPerformed(evt);
			}
		});
		charSetaLabel = new javax.swing.JLabel();
		charSetaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_charSetaLabel = new GridBagConstraints();
		gbc_charSetaLabel.fill = GridBagConstraints.VERTICAL;
		gbc_charSetaLabel.insets = new Insets(0, 0, 0, 5);
		gbc_charSetaLabel.gridx = 3;
		gbc_charSetaLabel.gridy = 0;
		checkBoxPanel.add(charSetaLabel, gbc_charSetaLabel);

		charSetaLabel.setText("Char set");
		charSet = new javax.swing.JComboBox();
		charSet.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_charSet = new GridBagConstraints();
		gbc_charSet.insets = new Insets(0, 0, 0, 5);
		gbc_charSet.fill = GridBagConstraints.HORIZONTAL;
		gbc_charSet.gridx = 4;
		gbc_charSet.gridy = 0;
		checkBoxPanel.add(charSet, gbc_charSet);

		charSet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF-8", "Unicode", "ANSI" }));

		varPanel = new JPanel();
		GridBagConstraints gbc_varPanel = new GridBagConstraints();
		gbc_varPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_varPanel.insets = new Insets(0, 0, 5, 5);
		gbc_varPanel.gridx = 0;
		gbc_varPanel.gridy = 3;
		centerPanel.add(varPanel, gbc_varPanel);
		GridBagLayout gbl_varPanel = new GridBagLayout();
		gbl_varPanel.columnWidths = new int[] { 180, 80, 80, 80, 80, 60, 80, 80, 80, 0 };
		gbl_varPanel.rowHeights = new int[] { 24, 0, 0 };
		gbl_varPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_varPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		varPanel.setLayout(gbl_varPanel);
		linkVarLabel = new javax.swing.JLabel();
		linkVarLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_linkVarLabel = new GridBagConstraints();
		gbc_linkVarLabel.anchor = GridBagConstraints.WEST;
		gbc_linkVarLabel.insets = new Insets(0, 0, 5, 5);
		gbc_linkVarLabel.gridx = 0;
		gbc_linkVarLabel.gridy = 0;
		varPanel.add(linkVarLabel, gbc_linkVarLabel);

		linkVarLabel.setText("Link Variable ");
		linkVar0 = new javax.swing.JComboBox();
		linkVar0.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar0 = new GridBagConstraints();
		gbc_linkVar0.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar0.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar0.gridx = 1;
		gbc_linkVar0.gridy = 0;
		varPanel.add(linkVar0, gbc_linkVar0);

		linkVar0.setModel(new DefaultComboBoxModel(
				new String[] { "NodeX", "NodeY", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar0ActionPerformed(evt);
			}
		});
		linkVar1 = new javax.swing.JComboBox();
		linkVar1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar1 = new GridBagConstraints();
		gbc_linkVar1.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar1.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar1.gridx = 2;
		gbc_linkVar1.gridy = 0;
		varPanel.add(linkVar1, gbc_linkVar1);

		linkVar1.setModel(new DefaultComboBoxModel(
				new String[] { "NodeY", "NodeX", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar1ActionPerformed(evt);
			}
		});
		linkVar2 = new javax.swing.JComboBox();
		linkVar2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar2 = new GridBagConstraints();
		gbc_linkVar2.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar2.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar2.gridx = 3;
		gbc_linkVar2.gridy = 0;
		varPanel.add(linkVar2, gbc_linkVar2);

		linkVar2.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar2ActionPerformed(evt);
			}
		});
		linkVar3 = new javax.swing.JComboBox();
		linkVar3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar3 = new GridBagConstraints();
		gbc_linkVar3.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar3.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar3.gridx = 4;
		gbc_linkVar3.gridy = 0;
		varPanel.add(linkVar3, gbc_linkVar3);

		linkVar3.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar3ActionPerformed(evt);
			}
		});
		linkVar4 = new javax.swing.JComboBox();
		linkVar4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar4 = new GridBagConstraints();
		gbc_linkVar4.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar4.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar4.gridx = 5;
		gbc_linkVar4.gridy = 0;
		varPanel.add(linkVar4, gbc_linkVar4);

		linkVar4.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar4ActionPerformed(evt);
			}
		});
		linkVar5 = new javax.swing.JComboBox();
		linkVar5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar5 = new GridBagConstraints();
		gbc_linkVar5.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar5.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar5.gridx = 6;
		gbc_linkVar5.gridy = 0;
		varPanel.add(linkVar5, gbc_linkVar5);

		linkVar5.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		linkVar5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar5ActionPerformed(evt);
			}
		});
		linkVar6 = new javax.swing.JComboBox();
		linkVar6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_linkVar6 = new GridBagConstraints();
		gbc_linkVar6.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar6.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar6.gridx = 7;
		gbc_linkVar6.gridy = 0;
		varPanel.add(linkVar6, gbc_linkVar6);

		linkVar6.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));

		linkVar7 = new JComboBox();
		linkVar7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		linkVar7.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Node X", "Node Y", "Shape", "Color", "Thickness", "Length", "LinkID", "Label" }));
		GridBagConstraints gbc_linkVar7 = new GridBagConstraints();
		gbc_linkVar7.insets = new Insets(0, 0, 5, 5);
		gbc_linkVar7.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkVar7.gridx = 8;
		gbc_linkVar7.gridy = 0;
		varPanel.add(linkVar7, gbc_linkVar7);
		nodeVarLabel = new javax.swing.JLabel();
		GridBagConstraints gbc_nodeVarLabel = new GridBagConstraints();
		gbc_nodeVarLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVarLabel.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVarLabel.gridx = 0;
		gbc_nodeVarLabel.gridy = 1;
		varPanel.add(nodeVarLabel, gbc_nodeVarLabel);
		nodeVarLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		nodeVarLabel.setText("Node Variable");
		nodeVar0 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar0 = new GridBagConstraints();
		gbc_nodeVar0.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar0.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar0.gridx = 1;
		gbc_nodeVar0.gridy = 1;
		varPanel.add(nodeVar0, gbc_nodeVar0);
		nodeVar0.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar0.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar1 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar1 = new GridBagConstraints();
		gbc_nodeVar1.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar1.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar1.gridx = 2;
		gbc_nodeVar1.gridy = 1;
		varPanel.add(nodeVar1, gbc_nodeVar1);
		nodeVar1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar1.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar2 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar2 = new GridBagConstraints();
		gbc_nodeVar2.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar2.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar2.gridx = 3;
		gbc_nodeVar2.gridy = 1;
		varPanel.add(nodeVar2, gbc_nodeVar2);
		nodeVar2.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar2.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar3 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar3 = new GridBagConstraints();
		gbc_nodeVar3.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar3.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar3.gridx = 4;
		gbc_nodeVar3.gridy = 1;
		varPanel.add(nodeVar3, gbc_nodeVar3);
		nodeVar3.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar3.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar4 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar4 = new GridBagConstraints();
		gbc_nodeVar4.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar4.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar4.gridx = 5;
		gbc_nodeVar4.gridy = 1;
		varPanel.add(nodeVar4, gbc_nodeVar4);
		nodeVar4.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar4.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar5 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar5 = new GridBagConstraints();
		gbc_nodeVar5.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar5.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar5.gridx = 6;
		gbc_nodeVar5.gridy = 1;
		varPanel.add(nodeVar5, gbc_nodeVar5);
		nodeVar5.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar5.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));

		nodeVar6 = new JComboBox();
		GridBagConstraints gbc_nodeVar6 = new GridBagConstraints();
		gbc_nodeVar6.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar6.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar6.gridx = 7;
		gbc_nodeVar6.gridy = 1;
		varPanel.add(nodeVar6, gbc_nodeVar6);
		nodeVar6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nodeVar6.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar7 = new javax.swing.JComboBox();
		GridBagConstraints gbc_nodeVar7 = new GridBagConstraints();
		gbc_nodeVar7.fill = GridBagConstraints.HORIZONTAL;
		gbc_nodeVar7.insets = new Insets(0, 0, 0, 5);
		gbc_nodeVar7.gridx = 8;
		gbc_nodeVar7.gridy = 1;
		varPanel.add(nodeVar7, gbc_nodeVar7);
		nodeVar7.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		nodeVar7.setModel(new DefaultComboBoxModel(
				new String[] { " ", "NodeID", "Shape", "Color", "Size", "Label", "X", "Y", "Z" }));
		nodeVar7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar6ActionPerformed(evt);
			}
		});
		nodeVar5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar5ActionPerformed(evt);
			}
		});
		nodeVar4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar4ActionPerformed(evt);
			}
		});
		nodeVar3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar3ActionPerformed(evt);
			}
		});
		nodeVar2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar2ActionPerformed(evt);
			}
		});
		nodeVar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar1ActionPerformed(evt);
			}
		});
		nodeVar0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nodeVar0ActionPerformed(evt);
			}
		});
		linkVar6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkVar6ActionPerformed(evt);
			}
		});
		this.setBounds(100, 100, 1024, 600);
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
		JFileChooser jfc = new JFileChooser();
		FileSystemView view = jfc.getFileSystemView();
		jfc.setCurrentDirectory(view.getHomeDirectory());
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
		FileSystemView view = jfc.getFileSystemView();
		jfc.setCurrentDirectory(view.getHomeDirectory());
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
		FileSystemView view = jfc.getFileSystemView();
		jfc.setCurrentDirectory(view.getHomeDirectory());
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

	public int getRealIndex(String selectedItem, String type) {
		// temp function
		// In the future the graph data part should be rewrite
		// link name is removed
		if (type.equals("link")) {
			switch (selectedItem) {
			case "NodeX":
				return 0;
			case "NodeY":
				return 1;
			case "Shape":
				return 2;
			case "Color":
				return 3;
			case "Thickness":
				return 4;
			case "Length":
				return 5;
			case "LinkID":
				return 6;
			case "Label":
				return 8;
			}
		}
		// node name is removed
		if (type.equals(type)) {
			switch (selectedItem) {
			case "NodeID":
				return 0;
			case "Shape":
				return 1;
			case "Color":
				return 2;
			case "Size":
				return 3;
			case "Label":
				return 5;
			case "X":
				return 6;
			case "Y":
				return 7;
			case "Z":
				return 8;
			}
		}
		return 10;
	}

	private void drawFigureActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Retrieve the data input
		boolean isMultiple, isNormalized, isDirected, isAutoLayout;
		isMultiple = this.isMultiple.isSelected();
		isNormalized = this.isNormalized.isSelected();
		isDirected = this.isDirected.isSelected();
		isAutoLayout = true;
		int[] linkVar = new int[10];
		String title = this.titleTextField.getText();
		linkVar[0] = this.getRealIndex((String) linkVar0.getSelectedItem(), "link");
		linkVar[1] = this.getRealIndex((String) linkVar1.getSelectedItem(), "link");
		linkVar[2] = this.getRealIndex((String) linkVar2.getSelectedItem(), "link");
		linkVar[3] = this.getRealIndex((String) linkVar3.getSelectedItem(), "link");
		linkVar[4] = this.getRealIndex((String) linkVar4.getSelectedItem(), "link");
		linkVar[5] = this.getRealIndex((String) linkVar5.getSelectedItem(), "link");
		linkVar[6] = this.getRealIndex((String) linkVar6.getSelectedItem(), "link");
		linkVar[7] = this.getRealIndex((String) linkVar7.getSelectedItem(), "link");

		int[] nodeVar = new int[10];
		nodeVar[0] = this.getRealIndex((String) nodeVar0.getSelectedItem(), "node");
		nodeVar[1] = this.getRealIndex((String) nodeVar1.getSelectedItem(), "node");
		nodeVar[2] = this.getRealIndex((String) nodeVar2.getSelectedItem(), "node");
		nodeVar[3] = this.getRealIndex((String) nodeVar3.getSelectedItem(), "node");
		nodeVar[4] = this.getRealIndex((String) nodeVar4.getSelectedItem(), "node");
		nodeVar[5] = this.getRealIndex((String) nodeVar5.getSelectedItem(), "node");
		nodeVar[6] = this.getRealIndex((String) nodeVar6.getSelectedItem(), "node");
		nodeVar[7] = this.getRealIndex((String) nodeVar7.getSelectedItem(), "node");
		// for testing
		for (int i = 0; i < 8; i++) {
			System.out.println(linkVar[i] + " " + nodeVar[i]);
		}
		String charSet = (String) this.charSet.getSelectedItem();

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

		// for testing
		linkLocation = "C:\\Users\\EF501b_3\\Desktop\\Link_0.txt";
		nodeLocation = "C:\\Users\\EF501b_3\\Desktop\\Node_0.txt";
		outputLocation = "C:\\Users\\EF501b_3\\Desktop\\";
		JOptionPane.showMessageDialog(this, "Testing mode");

		// validation
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
						// if this is not a null input
						if (linkVar[i] == linkVar[j]) {
						// multiple input of label is allowed
						if (linkVar[i] == 8) {
						continue;
						}
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

	private void helpActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		HowToUse howToUse = new HowToUse();
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
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Menu().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton helpButton;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JComboBox charSet;
	private javax.swing.JLabel charSetaLabel;
	private javax.swing.JButton drawFigureButton;
	private javax.swing.JCheckBox isDirected;
	private javax.swing.JCheckBox isMultiple;
	private javax.swing.JCheckBox isNormalized;
	private javax.swing.JLabel linkVarLabel;
	private javax.swing.JLabel nodeVarLabel;
	private javax.swing.JLabel titleLabel;
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
	private javax.swing.JComboBox nodeVar7;
	private javax.swing.JButton outputLocationButton;
	private javax.swing.JLabel outputLocationLabel;
	private javax.swing.JTextPane titleTextField;
	private JPanel centerPanel;
	private JPanel varPanel;
	private JPanel buttonPanel;
	private JPanel titlePanel;
	private JPanel filePanel;
	private JCheckBox nodeLocationCheckBox;
	private JCheckBox outputLocationCheckBox;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JComboBox linkVar7;
	private JComboBox nodeVar6;
	private JLabel copyrightLabel;
}
