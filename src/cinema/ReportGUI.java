package cinema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReportGUI{
	
	public ReportGUI(Customer user){
		final JFrame reportFrame = new JFrame("Report of today!");
		JPanel northPanel,centerPanel,southPanel;
		JLabel promptLabel,filmSaleLabel,typeNoLabel,totalNoLabel;
		JButton cancelButton;
		JTextArea filmSaleArea;
		JScrollPane scrollPane;
		
		northPanel = new JPanel();
		centerPanel  = new JPanel();
		southPanel = new JPanel();
		
		promptLabel = new JLabel("Report of today! ");
		promptLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		filmSaleLabel = new JLabel();
//		filmSaleLabel.setText(user.getReport().filmSale());
		
		filmSaleArea= new JTextArea(user.getReport().presentReport(),15,30);
		scrollPane = new JScrollPane(filmSaleArea);
		scrollPane.setPreferredSize(new Dimension(350, 100));
		filmSaleArea.setLineWrap(true);
		filmSaleArea.setEditable(false);
		filmSaleArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		filmSaleArea.setBackground(new Color(238, 238, 238));
		filmSaleArea.setWrapStyleWord(true);
		
		cancelButton = new JButton("OK");
		
		
		northPanel.add(promptLabel);
		centerPanel.add(scrollPane);						
		southPanel.add(cancelButton);
		reportFrame.add(northPanel,BorderLayout.NORTH);
		reportFrame.add(centerPanel,BorderLayout.CENTER);
		reportFrame.add(southPanel,BorderLayout.SOUTH);
		
		cancelButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						reportFrame.dispose();
					}
				}
		);
								
		reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		reportFrame.setSize(600, 200);
		reportFrame.setResizable(false);
		reportFrame.setVisible(true);
		reportFrame.setLocationRelativeTo(null);
	}
	
}
