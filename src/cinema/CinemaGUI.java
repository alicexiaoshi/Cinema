package cinema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

import java.util.Arrays;
import java.util.Calendar;

/**
*Title  : CinemaGUI.java
*This is Software Engineering project.
*@author  Group
*@version  jdk1.8.0_121 
*/
public class CinemaGUI extends readDB implements Runnable {
	JFrame mainFrame;
	JLabel welcomeLabel;
	JPanel northPanel,centerPanel,southPanel,westPanel,eastPanel;
	
	public CinemaGUI(){	

		mainFrame  = new JFrame("CINEMA SYSTEM");
		/*set time for northPanel*/
		northPanel = new JPanel();
		welcomeLabel = new JLabel();
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		northPanel.add(welcomeLabel);
				
		homePane();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		mainFrame.setSize(750, 700);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		
	}
	public void homePane(){		
		JButton buyTicket,admin,reportButton;
		JTextArea scheduleArea;
		final Customer user = new Customer();
		
		centerPanel = new JPanel();
		southPanel  = new JPanel();
		
//		welcomeLabel = new JLabel();
//		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scheduleArea= new JTextArea(readFilm_info(),15,30);
		scheduleArea.setLineWrap(true);
		scheduleArea.setEditable(false);
		scheduleArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scheduleArea.setBackground(new Color(238, 238, 238));
		scheduleArea.setWrapStyleWord(true);
		buyTicket = new JButton(" Buy Tickets Now !  ");
		reportButton = new JButton("Whole Day Report");
		admin = new JButton("Admin");
		
		//northPanel.add(welcomeLabel);
		centerPanel.add(scheduleArea);
		southPanel.add(buyTicket);
		southPanel.add(reportButton);
		
		//southPanel.add(admin);
		mainFrame.add(northPanel,BorderLayout.NORTH);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		mainFrame.add(southPanel,BorderLayout.SOUTH);
		
		buyTicket.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//northPanel.setVisible(false);
						centerPanel.setVisible(false);
						southPanel.setVisible(false);
						//mainFrame.remove(northPanel);
						mainFrame.remove(centerPanel);
						mainFrame.remove(southPanel);
						showFilmPane(user);
					}
				}
		);
		reportButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						ReportGUI rg = new ReportGUI(user);											
					}
				}
		);
	}
	
	public void showFilmPane(final Customer user){
		ImageIcon kongImage,loganImage,beautyImage,moonlightImage,lalaImage;
		JPanel kongPanel,loganPanel,beautyPanel,moonlightPanel,lalaPanel,schedulePanel;
		JLabel kongLabel,loganLabel,beautyLabel,moonlightLabel,lalaLabel;
		JButton orderButton,backButton;
		int width = 180,height = 250; //the width and height of 5 images.
		final JRadioButton rb1,rb2,rb3,rb4,rb5;
		 	
			
		centerPanel = new JPanel(new GridLayout(2,3,20,1));//2 line and 3 columns
		southPanel  = new JPanel();
		

		kongPanel = new JPanel(new BorderLayout());	
		loganPanel = new JPanel(new BorderLayout());
		beautyPanel = new JPanel(new BorderLayout());
		moonlightPanel = new JPanel(new BorderLayout());
		lalaPanel = new JPanel(new BorderLayout());
		schedulePanel = new JPanel(new BorderLayout());
		
		kongImage = new ImageIcon("image/kong.jpg");
		loganImage = new ImageIcon("image/logan.jpg");
		beautyImage = new ImageIcon("image/beauty.jpg");
		moonlightImage = new ImageIcon("image/moonlight.jpg");
		lalaImage = new ImageIcon("image/lala.jpg");	
		/*set width and height of images*/
		Image img1 = kongImage.getImage();  
        kongImage.setImage(img1.getScaledInstance(width, height, Image.SCALE_DEFAULT));      
        Image img2 = loganImage.getImage();  
        loganImage.setImage(img2.getScaledInstance(width, height, Image.SCALE_DEFAULT));
        Image img3 = beautyImage.getImage();  
        beautyImage.setImage(img3.getScaledInstance(width, height, Image.SCALE_DEFAULT));
        Image img4 = moonlightImage.getImage();  
        moonlightImage.setImage(img4.getScaledInstance(width, height, Image.SCALE_DEFAULT));
        Image img5 = lalaImage.getImage();  
        lalaImage.setImage(img5.getScaledInstance(width, height, Image.SCALE_DEFAULT));
		/*add image into JLabel*/
		kongLabel = new JLabel(kongImage);
		loganLabel = new JLabel(loganImage);
		beautyLabel = new JLabel(beautyImage);
		moonlightLabel = new JLabel(moonlightImage);
		lalaLabel = new JLabel(lalaImage);
		/*add image_label to the north of panel*/
		kongPanel.add(kongLabel,BorderLayout.NORTH);
		loganPanel.add(loganLabel,BorderLayout.NORTH);
		beautyPanel.add(beautyLabel,BorderLayout.NORTH);
		moonlightPanel.add(moonlightLabel,BorderLayout.NORTH);
		lalaPanel.add(lalaLabel,BorderLayout.NORTH);


		/* Create panel for JLabel and JRadioButton, all 10 panels.
		 * To make label present in the middle.
		 */
		JPanel[] p = new JPanel[11];
		for(int i=1;i<11;i++){
			p[i] = new JPanel();
		}
	
		p[1].add(new JLabel(" ---- 118 min ---- "));
		p[2].add(new JLabel(" ---- 135 min ---- "));
		p[3].add(new JLabel(" ---- 130 min ---- "));
		p[4].add(new JLabel(" ---- 111 min ---- "));
		p[5].add(new JLabel(" ---- 128 min ---- "));
		/*add label_panel into center of panel*/
		kongPanel.add(p[1],BorderLayout.CENTER);
		loganPanel.add(p[2],BorderLayout.CENTER);
		beautyPanel.add(p[3],BorderLayout.CENTER);
		moonlightPanel.add(p[4],BorderLayout.CENTER);
		lalaPanel.add(p[5],BorderLayout.CENTER);
		
		/*create JRadioButton for each film*/
		rb1 = new JRadioButton("KONG:SKULL ISLAND",true);
    	rb2 = new JRadioButton("LOGAN",true);
    	rb3 = new JRadioButton("BEAUTY AND THE BEST",true);
    	rb4 = new JRadioButton("MOONLIGH",true);
    	rb5 = new JRadioButton("LALA LAND",true);
    	/*ButtonGroup makes user can only chose one button at one time.*/
    	ButtonGroup filmGroup = new ButtonGroup();
    	filmGroup.add(rb1);
    	filmGroup.add(rb2);
    	filmGroup.add(rb3);
    	filmGroup.add(rb4);
    	filmGroup.add(rb5);
		
		p[6].add(rb1);
		p[7].add(rb2);
		p[8].add(rb3);
		p[9].add(rb4);
		p[10].add(rb5);
    	/*add RadioButton_panel into south of panel*/
		kongPanel.add(p[6],BorderLayout.SOUTH);
		loganPanel.add(p[7],BorderLayout.SOUTH);
		beautyPanel.add(p[8],BorderLayout.SOUTH);
		moonlightPanel.add(p[9],BorderLayout.SOUTH);
		lalaPanel.add(p[10],BorderLayout.SOUTH);
		
		/*add film information for schedulePanel*/
		JPanel info_panel = new JPanel();
		JLabel info_label = new JLabel("Film Schedule");	
		info_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		info_panel.add(info_label);
		schedulePanel.add((info_panel),BorderLayout.NORTH);
		orderButton = new JButton("Order");
		backButton = new JButton("Back");
		//homeButton = new JButton("Home");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(orderButton);
		buttonPanel.add(backButton);
		//buttonPanel.add(homeButton);
		schedulePanel.add(buttonPanel,BorderLayout.SOUTH);
		

		centerPanel.add(kongPanel);
		centerPanel.add(loganPanel);
		centerPanel.add(beautyPanel);
		centerPanel.add(moonlightPanel);
		centerPanel.add(lalaPanel);
		centerPanel.add(schedulePanel);
		
		mainFrame.setTitle("BUY TICKET");
		//mainFrame.add(northPanel,BorderLayout.NORTH);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		mainFrame.add(southPanel,BorderLayout.SOUTH);
		
		backButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//northPanel.setVisible(false);
						centerPanel.setVisible(false);
						//southPanel.setVisible(false);
						mainFrame.remove(northPanel);
						mainFrame.remove(centerPanel);
						mainFrame.remove(southPanel);
						homePane();
					}
				}
		);
		orderButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						user.getSeat().clearTempSeats();
						user.getTicket().clearTempTickets();
						
						//northPanel.setVisible(false);
						centerPanel.setVisible(false);
						southPanel.setVisible(false);
						//mainFrame.remove(northPanel);
						mainFrame.remove(centerPanel);
						mainFrame.remove(southPanel);
						String selectedFilm="KONG:SKULL ISLAND";
						if(rb2.isSelected()){
							selectedFilm = "LOGAN";
						}
						else if(rb3.isSelected()){
							selectedFilm = "BEAUTY AND THE BEAST";
						}
						else if(rb4.isSelected()){
							selectedFilm = "MOONLIGHT";
						}
						else if(rb5.isSelected()){
							selectedFilm = "LALA LAND";
						}
						user.setFilm(selectedFilm);
						selectFilmPane(user);
					}
				}
		);
	}
	public void selectFilmPane(final Customer user){
		
		JPanel filmPanel,selectPanel,filmName,filmImage,showTime,ticketType,ticketNo;
		JButton confirmButton,backButton;
		JLabel filmNameLabel,showTimeLabel;
		final JComboBox<String> ticketTypeCombo,filmTimeCombo;
		final JTextField ticketNoField;
		int width=220,height=320;
		String[] ticket_type = {"","Child","Adult","Senior","Student"};
		
		//centerPanel = new JPanel();
		centerPanel = new JPanel(new BorderLayout());
		southPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		
		filmPanel = new JPanel(new BorderLayout());
		selectPanel = new JPanel(new GridLayout(0,1));
		filmImage = new JPanel();
		showTime = new JPanel();
		ticketType = new JPanel();
		ticketNo = new JPanel();
		
		filmNameLabel = new JLabel();
		filmNameLabel.setText(user.getFilm());
		filmNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		filmName = new JPanel();
		filmName.add(filmNameLabel);
		filmPanel.add(filmName,BorderLayout.NORTH);//add film name first
		
		
		
		showTimeLabel = new JLabel("Please select a show time:");
		//showTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		showTime.setLayout(null);
		showTime.add(showTimeLabel);
		showTimeLabel.setBounds(250,10,300,25);
		switch(user.getFilm()){
			case "KONG:SKULL ISLAND":{	
				ImageIcon image = new ImageIcon("image/kong.jpg");
				Image img = image.getImage();  
				image.setImage(img.getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
				filmImage.add(new JLabel(image),BorderLayout.NORTH);
				String[] kongTime = {"","15:30", "18:30", "21:00", "20:00", "20:30"};
				filmTimeCombo = new JComboBox<String>(kongTime);
				filmTimeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));				
				showTime.add(filmTimeCombo);
				filmTimeCombo.setBounds(420,10,70,25);
				break;
			}
			case "LOGAN":{
				ImageIcon image = new ImageIcon("image/logan.jpg");
				Image img = image.getImage();  
				image.setImage(img.getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
				filmImage.add(new JLabel(image),BorderLayout.NORTH);
				String[] loganTime = {"","15:30", "18:00"};
				filmTimeCombo = new JComboBox<String>(loganTime);
				filmTimeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));
				showTime.add(filmTimeCombo);
				filmTimeCombo.setBounds(420,10,70,25);
				break;
			}
			case "BEAUTY AND THE BEAST":{
				ImageIcon image = new ImageIcon("image/beauty.jpg");
				Image img = image.getImage();  
				image.setImage(img.getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
				filmImage.add(new JLabel(image),BorderLayout.NORTH);
				String[] beautyTime = {"","10:00", "10:30","12:30","13:00"};
				filmTimeCombo = new JComboBox<String>(beautyTime);	
				filmTimeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));
				showTime.add(filmTimeCombo);
				filmTimeCombo.setBounds(420,10,70,25);
				break;
			}
			case "MOONLIGHT":{
				ImageIcon image = new ImageIcon("image/moonlight.jpg");
				Image img = image.getImage();  
				image.setImage(img.getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
				filmImage.add(new JLabel(image),BorderLayout.NORTH);
				String[] moonlightTime = {"","16:00","18:00"};
				filmTimeCombo = new JComboBox<String>(moonlightTime);	
				filmTimeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));
				showTime.add(filmTimeCombo);
				filmTimeCombo.setBounds(420,10,70,25);
				break;
			}
			case "LALA LAND":{
				ImageIcon image = new ImageIcon("image/lala.jpg");
				Image img = image.getImage();  
				image.setImage(img.getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
				filmImage.add(new JLabel(image),BorderLayout.NORTH);
				String[] lalaTime = {"","10:30","13:00"};
				filmTimeCombo = new JComboBox<String>(lalaTime);	
				filmTimeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));
				showTime.add(filmTimeCombo);
				filmTimeCombo.setBounds(420,10,70,25);
				break;
			}
			default:{
				String[] defaultTime = {""};
				filmTimeCombo = new JComboBox<String>(defaultTime);				
				JOptionPane.showMessageDialog(null, "Error", "Failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		ticketTypeCombo = new JComboBox<String>(ticket_type);
		ticketTypeCombo.setFont(new Font("Times New Roman", Font.BOLD,16));
		ticketTypeCombo.setBounds(420,10,70,25);
		ticketType.setLayout(null);
		JLabel ticketTypeLabel = new JLabel("Please select ticket type:");
		ticketTypeLabel.setBounds(250,10,300,25);
		ticketType.add(ticketTypeLabel);
		ticketType.add(ticketTypeCombo);//need to check student id
		
		ticketNoField = new JTextField(8);
		ticketNoField.setBounds(420,10,70,25);
		JLabel ticketNoLabel = new JLabel("Please select ticket number:");
		ticketNoLabel.setBounds(250,10,300,25);
		ticketNo.setLayout(null);
		ticketNo.add(ticketNoLabel);
		ticketNo.add(ticketNoField);
		
		filmPanel.add(filmImage,BorderLayout.CENTER);
		selectPanel.add(showTime);
		selectPanel.add(ticketType);
		selectPanel.add(ticketNo);
		
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		
		centerPanel.add(filmPanel,BorderLayout.NORTH);
		centerPanel.add(selectPanel,BorderLayout.CENTER);
		southPanel.add(confirmButton);
		southPanel.add(backButton);
		
		mainFrame.setTitle("Make a choice");
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		mainFrame.add(southPanel,BorderLayout.SOUTH);
		
		backButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//northPanel.setVisible(false);
						centerPanel.setVisible(false);
						southPanel.setVisible(false);
						//mainFrame.remove(northPanel);
						mainFrame.remove(centerPanel);
						mainFrame.remove(southPanel);
						showFilmPane(user);
					}
				}
		);
		confirmButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {	
						
						if((String)filmTimeCombo.getSelectedItem()==""||(String)ticketTypeCombo.getSelectedItem()==""||ticketNoField.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Show time or Ticket type or Ticket number is not selected!", "Error",JOptionPane.ERROR_MESSAGE);						
						else if(checkTicketTime((String)filmTimeCombo.getSelectedItem())==false){
							JOptionPane.showMessageDialog(null, "Show time is passed, please select another time.", "Error",JOptionPane.ERROR_MESSAGE);
						}
						else{
							int ticketNo = Integer.parseInt(ticketNoField.getText());
							if((String)ticketTypeCombo.getSelectedItem()=="Student"){
								InputStudentIdGUI inputID = new InputStudentIdGUI(ticketNo);
							}
							
							//northPanel.setVisible(false);
							centerPanel.setVisible(false);
							southPanel.setVisible(false);
							//mainFrame.remove(northPanel);
							mainFrame.remove(centerPanel);
							mainFrame.remove(southPanel);
							//selectScreenPane(selectedFilm,ticketNo);
							String screen = whichScreen(user.getFilm(),(String)filmTimeCombo.getSelectedItem());
							//System.out.println("which screen return:"+screen);
							user.setTime((String)filmTimeCombo.getSelectedItem());
							user.setScreen(screen);
							user.setTicketNo(ticketNo);
							user.setTicketType((String)ticketTypeCombo.getSelectedItem());
							
							/*show the seat layout for each screen*/
							screenPane(user);						
							
						}
	
					}
				}
		);
	}
	//public void screen1Pane(final String screen,final int ticketNo,final String selectedFilm,final String time){
	public void screenPane(final Customer user){
		final String seats;
		final JButton selectSeatsButton;
		final JButton confirmButton;
		JButton backButton, homeButton;
		JButton[] jb = new JButton[33];	
		
		centerPanel = new JPanel(new GridLayout(4,9,10,80));
		southPanel = new JPanel();
		westPanel = new JPanel(new GridLayout(4,1,10,10));
		eastPanel = new JPanel(new GridLayout(4,1,10,10));
		
		if(user.getScreen().equals("screen1")){
			/*create seats button of screen 1*/
			//JButton[] jb = new JButton[33];	
			int k=32;
			for(int i=1;i<=36;i++){	
				int[] base = new int[]{5,14,23,32}; 			        
				if (Arrays.binarySearch(base,i) >= 0) {     
					centerPanel.add(new JLabel());
				} 
				else{
					jb[k]= new JButton();
					centerPanel.add(jb[k]);
					k--;
				}									
			}
			/*set number to seats*/
			for(int i=1;i<=8;i++){
				jb[i].setText(""+i);
			}
			for(int i=9;i<=16;i++){
				jb[i].setText(""+(i-8));
			}
			for(int i=17;i<=24;i++){
				jb[i].setText(""+(i-16));
			}
			for(int i=25;i<=32;i++){
				jb[i].setText(""+(i-24));
			}
			
			
			
		}
		else if(user.getScreen().equals("screen2")){
			/*create seats button of screen 2*/
			//JButton[] jb = new JButton[33];	
			int k=26;
			for(int i=1;i<=36;i++){
				int[] base = new int[]{5,10,14,18,19,23,27,28,32,36}; 			        
				if (Arrays.binarySearch(base,i) >= 0) {     
					centerPanel.add(new JLabel());
				}  
				else{
					jb[k]= new JButton();
					centerPanel.add(jb[k]);
					k--;
				}									
			}
			/*set number to seats*/
			for(int i=1;i<=6;i++){
				jb[i].setText(""+i);
			}
			for(int i=7;i<=12;i++){
				jb[i].setText(""+(i-6));
			}
			for(int i=13;i<=18;i++){
				jb[i].setText(""+(i-12));
			}
			for(int i=19;i<=26;i++){
				jb[i].setText(""+(i-18));
			}

		}
		else{
			/*create seats button of screen 3*/
			centerPanel = new JPanel(new GridLayout(5,8,20,30));
			westPanel = new JPanel(new GridLayout(5,1,20,10));
			eastPanel = new JPanel(new GridLayout(5,1,20,10));
			//JButton[] jb = new JButton[33];	
			int k=32;
			for(int i=1;i<=40;i++){
				int[] base = new int[]{11,14,19,22,27,30,35,38}; 			        
				if (Arrays.binarySearch(base,i) >= 0) {     
					centerPanel.add(new JLabel());
				}  
				else{
					jb[k]= new JButton();
					centerPanel.add(jb[k]);
					k--;
				}									
			}
			/*set number to seats*/
			for(int i=1;i<=6;i++){
				jb[i].setText(""+i);
			}
			for(int i=7;i<=12;i++){
				jb[i].setText(""+(i-6));
			}
			for(int i=13;i<=18;i++){
				jb[i].setText(""+(i-12));
			}
			for(int i=19;i<=24;i++){
				jb[i].setText(""+(i-18));
			}
			for(int i=25;i<=32;i++){
				jb[i].setText(""+(i-24));
			}
			eastPanel.add(new JLabel("E"));
			westPanel.add(new JLabel("E"));
		}
		seats=disableSeats(user.getScreen());
		if(!seats.equals("")){//if there are seats have been selected
			String[] split=seats.split(" ");
			int usedSeat;
			for(int i =0;i<split.length;i++){
				usedSeat = screenMap(split[i],user.getScreen());			
				jb[usedSeat].setEnabled(false);			
			}
		}
		
		eastPanel.add(new JLabel("D"));
		eastPanel.add(new JLabel("C"));
		eastPanel.add(new JLabel("B"));
		eastPanel.add(new JLabel("A"));
		westPanel.add(new JLabel("D"));
		westPanel.add(new JLabel("C"));
		westPanel.add(new JLabel("B"));
		westPanel.add(new JLabel("A"));
		
		selectSeatsButton = new JButton("Select Seats");
		confirmButton = new JButton("Go To Confirm");
		confirmButton.setEnabled(false);
		backButton = new JButton("Back");
		homeButton = new JButton("Home");
		
		southPanel.add(selectSeatsButton);
		southPanel.add(confirmButton);
		southPanel.add(backButton);
		//southPanel.add(homeButton);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		mainFrame.add(southPanel,BorderLayout.SOUTH);
		mainFrame.add(westPanel,BorderLayout.WEST);
		mainFrame.add(eastPanel,BorderLayout.EAST);
		
		selectSeatsButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						for(int i=0;i<user.getTicketNo();i++){
							selectSeatsPane(user);
						}
						selectSeatsButton.setEnabled(false);
						confirmButton.setEnabled(true);
						//selectSeatsPane(screen, ticketNo);
					}
				}
		);
		confirmButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//northPanel.setVisible(false);
						centerPanel.setVisible(false);
						southPanel.setVisible(false);
						westPanel.setVisible(false);
						eastPanel.setVisible(false);
						//mainFrame.remove(northPanel);
						mainFrame.remove(centerPanel);
						mainFrame.remove(southPanel);
						mainFrame.remove(westPanel);
						mainFrame.remove(eastPanel);
						//finalConfirmPane(selectedFilm,time,seats);
						finalConfirmPane(user);
					}
				}
		);
		
		backButton.addActionListener(
		new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//northPanel.setVisible(false);
				centerPanel.setVisible(false);
				southPanel.setVisible(false);
				//mainFrame.remove(northPanel);
				mainFrame.remove(centerPanel);
				mainFrame.remove(southPanel);
				westPanel.setVisible(false);
				eastPanel.setVisible(false);
				mainFrame.remove(westPanel);
				mainFrame.remove(eastPanel);
				showFilmPane(user);
				user.getSeat().clearTempSeats();
			}
		}
		);
		
		
	}
	//public void finalConfirmPane(final String film, String time, String seats){
	public void finalConfirmPane(final Customer user){
		JButton payButton,homeButton;
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		southPanel = new JPanel();
		
		JPanel infoPanel = new JPanel();
		JPanel filmPanel = new JPanel();
		JPanel timePanel = new JPanel();
		JPanel seatPanel = new JPanel();
		JPanel pricePanel = new JPanel();
		//JLabel infoLable = new JLabel("Please confirm your ticket information");
		//info.setFont(new Font("Times New Roman", Font.BOLD,12));
		infoPanel.add(new JLabel("--- Please confirm your ticket information ---"));
		infoPanel.setBounds(250,150,250,30);
		filmPanel.add(new JLabel("Film:  "+user.getFilm()));
		filmPanel.setBounds(250,200,250,30);
		timePanel.add(new JLabel("Time:  "+user.getTime()));
		timePanel.setBounds(250,250,250,30);
		seatPanel.add(new JLabel("Seat:  "+user.getAllSeats()));
		seatPanel.setBounds(250,300,250,30);
		pricePanel.add(new JLabel("Price:  "+user.getAllPrice()));
		pricePanel.setBounds(250,350,250,30);
		
		centerPanel.add(infoPanel);
		centerPanel.add(filmPanel);
		centerPanel.add(timePanel);
		centerPanel.add(seatPanel);
		centerPanel.add(pricePanel);
		
		payButton = new JButton("Pay and Buy other film");
		//buyAnotherButton = new JButton("Buy more this film");
		homeButton = new JButton("Home");
		southPanel.add(payButton);
		//southPanel.add(buyAnotherButton);
		southPanel.add(homeButton);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		mainFrame.add(southPanel,BorderLayout.SOUTH);
		
		payButton.addActionListener(
		new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//northPanel.setVisible(false);
				centerPanel.setVisible(false);
				southPanel.setVisible(false);
				//mainFrame.remove(northPanel);
				mainFrame.remove(centerPanel);
				mainFrame.remove(southPanel);
				JOptionPane.showMessageDialog(null, " Payment successful !!", "Success",JOptionPane.INFORMATION_MESSAGE);
				homePane();//accomplish serving one customer.
				user.getSeat().recordTempSeats(user.getScreen(),user.getAllSeats());
				user.getSeat().clearTempSeats();
				user.getTicket().generateTickets();
				user.getTicket().clearTempTickets();
				user.getReport().recordTempReports();
			}
		}
		);
		
		/*buyAnotherButton.addActionListener(
		new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//northPanel.setVisible(false);
				centerPanel.setVisible(false);
				southPanel.setVisible(false);
				//mainFrame.remove(northPanel);
				mainFrame.remove(centerPanel);
				mainFrame.remove(southPanel);
				selectFilmPane(user);//user must pay for this film and then he can select another film
			}
		}
		);*/
		homeButton.addActionListener(
		new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//northPanel.setVisible(false);
				centerPanel.setVisible(false);
				southPanel.setVisible(false);
				//mainFrame.remove(northPanel);
				mainFrame.remove(centerPanel);
				mainFrame.remove(southPanel);
				homePane();
			}
		}
		);
	}
	public void selectSeatsPane(final Customer user){
		final JFrame selectSeatsFrame;
		JPanel selectPanel;
		final JComboBox lineCombo,columnCombo;
		JButton okButton;
		String[] line = {"A","B","C","D","E"};
		String[] column = {"1","2","3","4","5","6","7","8"};		
		
		
		selectSeatsFrame = new JFrame("Please select a seat");
		selectPanel = new JPanel();
		lineCombo =  new JComboBox<String>(line);
		columnCombo = new JComboBox<String>(column);
		okButton = new JButton("OK");
		selectPanel.add(lineCombo);
		selectPanel.add(columnCombo);
		selectPanel.add(okButton);
		selectSeatsFrame.add(selectPanel);
		selectSeatsFrame.setSize(300,100);
		selectSeatsFrame.setLocationRelativeTo(null);
		selectSeatsFrame.setResizable(false);
		selectSeatsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectSeatsFrame.setVisible(true);
		
		okButton.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String seat = lineCombo.getSelectedItem()+"-"+columnCombo.getSelectedItem();
						System.out.println("seat in okbutton"+seat);
						boolean flag = checkSeat(user.getScreen(), seat);
						
						if(!flag){
							JOptionPane.showMessageDialog(null, "OK! Seat has been selected.", "Success",JOptionPane.INFORMATION_MESSAGE);
							selectSeatsFrame.dispose();								
							user.setAllSeats(seat);	
							user.getSeat().saveTempSeats(seat);
						}
						else{
							JOptionPane.showMessageDialog(null, "Sorry! This seat has been selected.", "Failed",JOptionPane.ERROR_MESSAGE);
						}
					}		
				}
		);
	}



	public void run(){
		showTime();
	}
	public void showTime(){
		String info = "Welcome to the cinema!   Time: ";
		String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
		while(true){
			SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
			  welcomeLabel.setText(info+dateFormatter.format(Calendar.getInstance().getTime()));
			  try
			  {
				  Thread.sleep(1000); 
			  }
			  catch(Exception e)
			  {
				  welcomeLabel.setText("error in time");
			  } 
		}
	}
	public static void main(String[] args){
		CinemaGUI start = new CinemaGUI();
		Report report = new Report();
		report.clearTempReports();
		Thread time = new Thread(start);
		time.start();
	}
}
