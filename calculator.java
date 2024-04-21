                                    package calcuator;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculator extends JFrame implements ActionListener{
	
	JTextField textField;
	JButton[] numberButtons = new JButton [10];
	JButton[] functionButtons = new JButton [8];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,dltButton,clrButton,eqlButton;
	double num1=0,num2=0,result=0;
	
	char operator;
	
	Font myfont = new Font ("serif",Font.BOLD,20);
	
	calculator (){
		setBounds (100,100,430,565);
		setLayout (null);
		
		JLabel name = new JLabel ("calculator");
		name.setBounds(20,5,200,50);
		name.setFont(myfont);
		
		textField = new JTextField ();
		textField.setBounds(40,60,300,50);
		textField.setFont(myfont);
		textField.setEditable(false);
		
		addButton = new JButton ("+");
		subButton = new JButton ("-");
		mulButton = new JButton ("*");
		divButton = new JButton ("/");
		decButton = new JButton (".");
		eqlButton = new JButton ("=");
		dltButton = new JButton ("Delete");
		clrButton = new JButton ("clear");
		
		functionButtons [0] = addButton;
		functionButtons [1] = subButton;
		functionButtons [2] = mulButton;
		functionButtons [3] = divButton;
		functionButtons [4] = decButton;
		functionButtons [5] = eqlButton;
		functionButtons [6] = dltButton;
		functionButtons [7] = clrButton;
		
		for (int i=0;i <8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myfont);
			functionButtons[i].setFocusable(false);
		}
		for (int i=0;i <10; i++) {
			numberButtons[i] = new JButton (String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myfont);
			numberButtons[i].setFocusable(false);
		}
		
		dltButton.setBounds(30,430,100,40);
		clrButton.setBounds(300,430,100,40);
		
		JPanel panel = new JPanel ();
		panel.setBounds(50,120,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.BLACK);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqlButton);
		panel.add(divButton);
		
		
		
		add(dltButton);
		add(clrButton);
		add(textField);
		add(panel);
		add(name);
		setVisible (true);
	}
	
	
	public static void main (String[]args) {
		new calculator();
	}

	public void actionPerformed(ActionEvent e) {
		for (int i =0; i <10;i ++) {
			if (e.getSource()== numberButtons[i]) {
			textField.setText(textField.getText().concat(String.valueOf(i)));
			}
			
			
		}
		//
		
		if (e.getSource()== decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource()== addButton) {
			//textField.setText(textField.getText().concat("+"));
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource()== subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource()== mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator='*';
			textField.setText("");
		}
		if (e.getSource()== divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if (e.getSource()== eqlButton) {
			num2 = Double.parseDouble(textField.getText());
			
		switch (operator) {
		case '+':
			result = num1+num2;
			break;
		case '-':
			result = num1-num2;
			break;
		case '*':
			result = num1*num2;
			break;
		case '/':
			result = num1/num2;
			break;		
		
		}
		textField.setText(String.valueOf(result));
		num1 = result;
		}
		if (e.getSource()== clrButton) {
			textField.setText(" ");
		}
		if (e.getSource()== dltButton) {
			String string = textField.getText();
			textField.setText(" ");
			for (int i =0; i <string.length()-1; i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		
	}
	
}