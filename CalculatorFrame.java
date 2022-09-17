package day3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

	String operand;
	String operator;
	
	public CalculatorFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		var textField = new JTextField();
		
		add(textField, BorderLayout.NORTH);
		
		var panel = new JPanel( new GridLayout(4, 4) );
		
		String[] buttons = { "7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "/", "0", "Clear", "=" };
		
		for(String button : buttons) {
			var btn = new JButton(button);
			
			btn.addActionListener(e -> {
				
				if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
					// 숫자 입력
					textField.setText(textField.getText() + button);
				}
				else if (button.equals("Clear")) {
					// 초기화
					textField.setText("");
					operand = "";
					operator = "";
				}
				else if (button.equals("=")) {
					long op1 = Long.valueOf(operand);
					long op2 = Long.valueOf(textField.getText());
					
					if (operator.equals("+")) {
						textField.setText(String.valueOf(op1 + op2));						
					} else if (operator.equals("-")) {
						textField.setText(String.valueOf(op1 - op2));						
					} else if (operator.equals("*")) {
						textField.setText(String.valueOf(op1 * op2));						
					} else if (operator.equals("/")) {
						textField.setText(String.valueOf(op1 / op2));						
					}
					
				}
				else {
					// 기호 입력
					operand = textField.getText();
					operator = button;
					textField.setText("");
				}
				
			});
			
			panel.add(btn);
		}
		
		add(panel);
	}
	
	public static void main(String[] args) {
		var frame = new CalculatorFrame();
		
		frame.setVisible(true);
		
	}

}
