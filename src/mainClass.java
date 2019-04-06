import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class mainClass extends JFrame implements ActionListener{

	JTextArea textArea;

	JPanel pnlBtns, pnlText, pnlOutput;
	JButton btnUpper, btnLower, btnHashtag, btnLocate, btnConcat;

	JLabel lbl;

	public mainClass() {
		// set frame's attributes
		super("Application");
		this.setSize(500, 300);
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
		// set pnlText attributes
		this.pnlText = new JPanel(new BorderLayout());
		// text area
		pnlText.add(textArea, BorderLayout.CENTER);


		// set label attributes
		this.lbl = new JLabel(textArea.getText());
		lbl.setMinimumSize(new Dimension(100, 200));


		// add components to the frame	
		this.add(pnlBtns, BorderLayout.NORTH);
		this.add(pnlText, BorderLayout.CENTER);
		this.add(lbl, BorderLayout.SOUTH);

		// add actions
		btnUpper.addActionListener(this);
		btnLower.addActionListener(this);
		btnHashtag.addActionListener(this);
		btnLocate.addActionListener(this);
		btnConcat.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		String text = this.textArea.getText();
		this.lbl.setForeground(Color.green);
		if(source == btnUpper) {
			this.lbl.setText(myStringOperations.myUppercase(text));
		}
		else if(source == btnLower) {
			this.lbl.setText(myStringOperations.myLowercase(text));
		}
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
		} else if (source == btnLocate) {
			int twitterIndex = myStringOperations.myLocate(text, "Twitter");
			int wayIndex = myStringOperations.myLocate(text, "way");
			this.lbl.setText("<html><h4> \"Twitter\" is at the index:"+ twitterIndex +"<br>\"way\" is at the index: " + wayIndex + "</h4></html>");
		} else if(source == btnConcat) {
			
			this.lbl.setText("<html><h3>" + this.lbl.getText() + " | This SMS has been entered By User!</h3></html>");
		}
		
		
	}
	public static void main(String[] args) {	
		new mainClass();
	}
}
