import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;


public class mainClass extends JFrame implements ActionListener{

	JTextArea textArea;

	JPanel pnlBtns, pnlText, pnlFile;
	JButton btnUpper, btnLower, btnHashtag, btnLocate, btnConcat;
	JButton btnCreateFile, btnDeleteFile, btnReadFile, btnWriteFile, btnPerms;
	JTextField txtInputFilePath, txtOutputFilePath;

	JLabel lbl, lblFiles, lblInputFile, lblOutputFile;

	public mainClass() {
		// set frame's attributes
		super("Application");
		this.setSize(800, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);


		// set buttons attributes
		this.btnUpper = new JButton("Uppercase");
		this.btnLower = new JButton("Lowercase");
		this.btnHashtag = new JButton("Hashtag");
		this.btnLocate = new JButton("Locate");
		this.btnConcat= new JButton("Concat");
		
		// set pnlBtns attributes
		this.pnlBtns = new JPanel(new FlowLayout());
		// add Buttons to panel
		pnlBtns.add(btnUpper);
		pnlBtns.add(btnLower);
		pnlBtns.add(btnHashtag);
		pnlBtns.add(btnLocate);
		pnlBtns.add(btnConcat);
		

		// set text area attributes
		this.textArea = new JTextArea("This is the way to hash tag in Twitter");
		this.textArea.setAutoscrolls(true);
		// set pnlText attributes
		this.pnlText = new JPanel(new BorderLayout());
		// add text area to panel
		pnlText.add(textArea, BorderLayout.CENTER);


		// set label attributes
		this.lbl = new JLabel(textArea.getText());
		lbl.setMinimumSize(new Dimension(100, 200));

		
		// set file buttons attributes.
		btnCreateFile = new JButton("Create");
		btnDeleteFile = new JButton("Delete");
		btnReadFile = new JButton("Read");
		btnWriteFile = new JButton("Write");
		btnPerms = new JButton("Permissions");
		
		// set text input of files
		txtInputFilePath = new JTextField();
		txtOutputFilePath = new JTextField();
		
		// set labels of file
		lblFiles = new JLabel("Files Operations");
		lblInputFile = new JLabel("Input File");
		lblOutputFile = new JLabel("Output File");
		
		// set files' panel's attributes
		pnlFile = new JPanel(new GridLayout(10, 1, 0, 5));
		
		// add file components to panel
		pnlFile.add(lblFiles);
		pnlFile.add(lblInputFile);
		pnlFile.add(txtInputFilePath);
		pnlFile.add(btnReadFile);
		pnlFile.add(lblOutputFile);
		pnlFile.add(txtOutputFilePath);
		pnlFile.add(btnWriteFile);
		pnlFile.add(btnCreateFile);
		pnlFile.add(btnDeleteFile);
		pnlFile.add(btnPerms);

		// add components to the frame
		this.add(pnlBtns, BorderLayout.NORTH);
		this.add(pnlText, BorderLayout.CENTER);
		this.add(lbl, BorderLayout.SOUTH);
		this.add(pnlFile, BorderLayout.EAST);

		// add actions
		btnUpper.addActionListener(this);
		btnLower.addActionListener(this);
		btnHashtag.addActionListener(this);
		btnLocate.addActionListener(this);
		btnConcat.addActionListener(this);
		btnCreateFile.addActionListener(this);
		btnDeleteFile.addActionListener(this);
		btnReadFile.addActionListener(this);
		btnWriteFile.addActionListener(this);
		btnPerms.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Set Global Settings.
		Object source = e.getSource();
		String text = this.textArea.getText();
		this.lbl.setForeground(Color.green);
		
		// ====================== btnUpper Action ======================
		if(source == btnUpper) {
			this.lbl.setText(myStringOperations.myUppercase(text));
		}
		// ====================== btnLower Action ======================
		else if(source == btnLower) {
			this.lbl.setText(myStringOperations.myLowercase(text));
		}
		// ====================== btnHashTag Action ======================
		else if(source == btnHashtag) {
			try {
				String txt = myStringOperations.myHashTag(text);
				if (txt.contains("Error")) {
					this.lbl.setForeground(Color.red);
				} else {
					this.lbl.setForeground(Color.green);
				}

				this.lbl.setText(txt);
			} catch (Exception e2) {
				this.lbl.setText("<html><h3 style='color: red'>Error Occured..</h3></html>");
			}
		}
		// ====================== btnLocateAction ======================
		else if (source == btnLocate) {
			int twitterIndex = myStringOperations.myLocate(text, "Twitter");
			int wayIndex = myStringOperations.myLocate(text, "way");
			this.lbl.setText("<html>\"Twitter\" is at the index:"+ twitterIndex +"<br>\"way\" is at the index: " + wayIndex + "</html>");
		} 
		// ====================== btnConcat Action ======================
		else if(source == btnConcat) {
			
			this.lbl.setText(this.textArea.getText() + " | This SMS has been entered By User!");
		}
		// ====================== btnCreateFile Action ======================
		else if (source == btnCreateFile) {
			String path = txtOutputFilePath.getText();
			if(myFileHandler.create(path)) {
				lbl.setText("File '" + path + "' Created Successfully");
			} else {
				lbl.setText("File Already Exists.");
			}
		}
		// ====================== btnCreateFile Action ======================
		else if (source == btnDeleteFile) {
			String path = txtOutputFilePath.getText();
			
			if(myFileHandler.delete(path)) {
				lbl.setText("File " + path + " was successfully deleted.");
			} else {
				lbl.setText("<html><span style='color: red'>File " + path + " does not exist.</span></html>.");
			}
		}
		// ====================== btnReadFile Action ======================
		else if(source == btnReadFile) {
			String path = txtInputFilePath.getText(), fileText = myFileHandler.read(path);
			if(fileText != null) {
				textArea.setText(fileText);
				lbl.setText("Read from file");
			} else {
				lbl.setText("<html><span style='color: red'>Either file is empty or does not exist</span></html>");
			}
		}
		// ====================== btnReadFile Action ======================
		else if(source == btnWriteFile) {
			String path = txtOutputFilePath.getText(),
					output = lbl.getText();
			
			if(myFileHandler.write(path, output)) {
				lbl.setText("Data was successfully written into the file " + path);
			} else {
				lbl.setText("<html><span style='color: red'>Could not write data into file.</span></html>");
			}
		}
		// ====================== btnReadFile Action ======================
		else if (source == btnPerms) {
			String path = txtOutputFilePath.getText();
			
			try {
				myFileHandler.setPermission(path);
				lbl.setText("Successfully Changed Permissions.");
			} catch (Exception e2) {
				lbl.setText("<html><span style='color: red'>Could Not Change Permissions. "+ e2.getMessage() +"</span></html>");
			}
		}	
	}
	
	
	public static void main(String[] args) {	
		new mainClass();
	}
}
