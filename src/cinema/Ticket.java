package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ticket {
	private int ticketNo=0;
	private String film,time,screen,type,id;
	private boolean isStudent=false;
	
	public Ticket(){
		
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	
	/* To record ticket information in a temporary file.
	 * When Payment is finished, information will be used
	 * to generate tickets for user.
	 * */
	public void recordTempTickets(){
		String[] idInfo = new String[this.getTicketNo()];
		String[] ticketInfo = new String[this.getTicketNo()];
		String info = "; Film: "+this.getFilm()+"; Time: "+this.getTime()+"; Screen: "+this.getScreen()+"; Type: "+this.getType()+"; Need StudentID? :"+this.isStudent();
		
		try {	    	 	        	    
			 FileWriter fileWriter = new FileWriter("TempTickets.txt",true);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			 for(int i=0;i<this.getTicketNo();i++){
					idInfo[i]="Ticket ID: "+generateID();
					ticketInfo[i]=idInfo[i]+info;
					bufferedWriter.append(ticketInfo[i]).append("\r\n");
			 }		     	
		     bufferedWriter.close();        		     
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
	/* To generate tickets for user.
	 * Tickets are all stored in a file called tickets.
	 * */
	public void generateTickets(){
		int line=1;
		String temp;
		String path = "./tickets/";
		File file = new File(path);
		
		try{
			/*clear the tickets directory first*/
			String[] tempList = file.list();
		       File tempFile = null;
		       for (int i = 0; i < tempList.length; i++) {
		    	  tempFile = new File(path + tempList[i]);
		          if (tempFile.isFile()) {
		             tempFile.delete();
		          }
		          
		       }
			
			/*generate tickets*/
	    	BufferedReader reader = new BufferedReader(new FileReader("TempTickets.txt"));
		    while ((temp = reader.readLine()) != null) {	    	
		    	FileWriter fileWriter = new FileWriter("./tickets/"+line+".txt",false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(temp);
				bufferedWriter.close();
				line++;        
		    }		  		   
		    reader.close();
		    
		   
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
	/* To clear the content in the temporary file.
	 * Since user clicked the Back button.
	 * */
	public void clearTempTickets(){
		try {		
			FileWriter fileWriter = new FileWriter("TempTickets.txt"); 
			fileWriter.write("");	
			fileWriter.close();		    			
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
	/* To generate ticket ID for each ticket.
	 * */
	public String generateID(){
		int length=8;
		String base = "1234";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();  		        
	}
	
	
}
