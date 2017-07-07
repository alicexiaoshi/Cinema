package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
	private int ticketNo;
	private String film,type;
	private double allPrice=0.0;
	
	public Report(){
		
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	 
	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

	/* To record the report information into a temporary file,
	 * which is convenient for the program to calculate the final report.
	 * */
	public void recordTempReports(){
		String reportInfo =this.getFilm()+";"+this.getType()+";"+this.getTicketNo()+";"+this.getAllPrice();	
		try {	    	 	        	    
			 FileWriter fileWriter = new FileWriter("TempReports.txt",true);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			 bufferedWriter.append(reportInfo).append("\r\n");
			 	     	
		     bufferedWriter.close();        		     
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
	
	/* To clear the content in the temporary file.
	 * Since user clicked the Back button.
	 * */
	public void clearTempReports(){
		try {		
			FileWriter fileWriter = new FileWriter("TempReports.txt"); 
			fileWriter.write("");	
			fileWriter.close();		    			
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
	public String presentReport(){
		double beautySale=0,kongSale=0,loganSale=0,moonSale=0,lalaSale=0;
		int totalNoticketSold=0,childNo=0,seniorNo=0,studentNo=0,adultNo=0;
		String reportInfo="";
		String temp;
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader("TempReports.txt"));
		    while ((temp = reader.readLine()) != null) {	    	
		    	String[] split = temp.split(";");
		    	String film = split[0];
		    	String type = split[1];
		    	int ticketNo = Integer.parseInt(split[2]);
		    	double allPrice = Double.parseDouble(split[3]);
		    	
		    	switch(film){
		    	case "KONG:SKULL ISLAND":
		    		kongSale = kongSale+allPrice;
		    		break;
		    	case "BEAUTY AND THE BEAST":
		    		beautySale =beautySale+allPrice;
		    		break;
		    	case "MOONLIGHT":
		    		moonSale = moonSale+allPrice;
		    		break;
		    	case "LALA LAND":
		    		lalaSale = lalaSale+allPrice;
		    		break;
		    	case "LOGAN":
		    		loganSale = loganSale+allPrice;
		    	}
		    	
		    	switch(type){
		    	case "Adult":
		    		adultNo=adultNo+ticketNo;
		    		break;
		    	case "Senior":
		    		seniorNo=seniorNo+ticketNo;
		    		break;
		    	case "Child":
		    		childNo=childNo+ticketNo;
		    		break;
		    	case "Student":
		    		studentNo=studentNo+ticketNo;
		    		break;
		    	}
		    	totalNoticketSold=totalNoticketSold+ticketNo;
		    	
		    	reportInfo="1.Sale of each film:\nKONG:SKULL ISLAND:"+kongSale+"\nBEAUTY AND THE BEAST:"+beautySale
		    		+"\nMOONLIGHT:"+moonSale+"\nLALA LAND:"+lalaSale+"\nLOGAN:"+loganSale
		    		+"\n\n2.Total number of tickets sold: "+totalNoticketSold
		    		+"\n\n3.Each type of tickets sole:\nChild:  "+childNo+"\nAdult:  "+adultNo+"\nSenior: "+seniorNo+"\nStudent:"+studentNo;
		    			    	      
		    }		  		   
		    reader.close();
		    
		   
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return reportInfo;
	}
}
