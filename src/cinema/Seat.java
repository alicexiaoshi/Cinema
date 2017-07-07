package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Seat {
	private File TempSeats_file = new File("TempSeats.txt");
	private File seatUsed_file = new File("seatUsed.txt");
	
	public Seat(){
		
	}
	
	/* To save the selected seats in a temporary file.
	 * */
	public void saveTempSeats(String seat){
		try {	    	 	        	    
			 FileWriter fileWriter = new FileWriter("TempSeats.txt",true);
			 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		     //System.out.println();
		     bufferedWriter.append(seat).append(" ");	
		     bufferedWriter.close();		    			
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
	/* To record the seats into a file,
	 * before accomplishing serving this user. 
	 * */
	public void recordTempSeats(String screen,String allSeats){
		String temp = "";
		String info = "";
		System.out.println("in recordtempseats"+allSeats);
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(seatUsed_file.getAbsolutePath()));
	    	StringBuffer bf = new StringBuffer();
		    while ((temp = reader.readLine()) != null) {	    	
		    	//temp=temp.trim();
		    	if(temp.indexOf(screen) == -1){ //string temp does not contain that specific screen           	
					bf.append(temp).append("\r\n");	
				}
		    	else{
		    		info=temp;
		    		System.out.print(info+"seat info=temp recordtempseat");
		    	}
		     }		  		   
		    reader.close();
		    
		    FileWriter fileWriter = new FileWriter("seatUsed.txt",false);//overwrite not append
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(bf.toString());
			bufferedWriter.append(info).append(allSeats);	
		    bufferedWriter.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
	/* To clear the content in the temporary file.
	 * Since user clicked the Back button.
	 * */
	public void clearTempSeats(){
		try {		
			FileWriter fileWriter = new FileWriter(TempSeats_file); 
			fileWriter.write("");	
			fileWriter.close();		    			
		}catch (IOException ioe) {
	        // TODO Auto-generated catch block
	        ioe.printStackTrace();
	    }
	}
}
