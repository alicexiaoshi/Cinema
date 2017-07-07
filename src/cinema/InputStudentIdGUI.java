package cinema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputStudentIdGUI {
	public InputStudentIdGUI(final int ticketNo){
		final JFrame studentNumberFrame = new JFrame("Input student ID");
		JPanel p = new JPanel();
		JButton okButton = new JButton("OK");
		JLabel l = new JLabel("Please input student ID, use ';' to seperate. Example: <2015213520;2015213521> :");
		final JTextField idField = new JTextField(25);		
		
		l.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p.add(l);
		p.add(idField);
		p.add(okButton);
		studentNumberFrame.add(p);
		
		studentNumberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		studentNumberFrame.setSize(600, 100);
		studentNumberFrame.setResizable(false);
		studentNumberFrame.setVisible(true);
		studentNumberFrame.setLocationRelativeTo(null);
		
		okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] split = idField.getText().split(";");
				if(split.length!=ticketNo){
					//System.out.println(split.length);
					JOptionPane.showMessageDialog(null, "StudentID is wrong", "Error",JOptionPane.ERROR_MESSAGE);
					idField.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "You can select seats now!", "Successful!",JOptionPane.INFORMATION_MESSAGE);
					studentNumberFrame.dispose();
				}
					
			}		
		}
		);
	}	
	
}
