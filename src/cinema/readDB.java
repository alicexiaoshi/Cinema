package cinema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class readDB {
	private File film_info_file = new File("film_info.txt");
	private File screen_time_file = new File("screen_time.txt");
	private File seatUsed_file = new File("seatUsed.txt");
	private File TempSeats_file = new File("TempSeats.txt");
		
	
	public boolean checkTicketTime(String chosen){
		boolean isBefore=false;
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
		String now =df.format(new Date());
		try {
			Date nowTime = df.parse(now);
			Date chosenTime = df.parse(chosen);
			if(nowTime.getTime()<=chosenTime.getTime())
				isBefore=true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isBefore;
	}
	
	/* To check whether this seat has been selected or not.
	 * 
	 * */
	public boolean checkSeat(String screen, String seat){
		boolean flag = false;	
		String temp = "";
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(seatUsed_file.getAbsolutePath()));		    	
		    while ((temp = reader.readLine()) != null) {	    	
		    	String[] split=temp.split(":");
		    	if(split.length>1){
		    		if(split[0].equals(screen)){
			    		if(split[1].contains(seat)){		    			
			    			flag=true;
			    			break;
			    		}		    		
			    	}
		    	}		    		            
		     }		  		   
		    reader.close();
		    BufferedReader reader2 = new BufferedReader(new FileReader(TempSeats_file.getAbsolutePath()));		    	
		    while ((temp = reader2.readLine()) != null) {	    	
		    	if(temp.contains(seat)){
	    			//System.out.println(split[1]+"--"+seat);	    			
	    			flag=true;
	    			break;
	    		}            
		     }		  		   
		    reader2.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return flag;
	}
/*	public boolean disable(String screen){
		boolean flag=true;
		String seats=disableSeats(screen);
		
		String[] split=seats.split(" ");		
		for(int i =0;i<split.length;i++){
			//String[] num=split[i].split("-");
			int seat = screen1Map(split[i]);			
			jb[seat].setEnabled(false);			
		}
		return flag;
	}*/
	public int screenMap(String split,String screen){
		
		String[] seat=split.split("-");
		int position=0; 
		switch(screen){
		case "screen1":
			if(split.contains("A"))
				position=position+0;
			else if(split.contains("B"))
				position=position+8;
			else if(split.contains("C"))
				position=position+16;
			else if(split.contains("D"))
				position=position+24;
			else
				position=position-100;
			//System.out.println(num[0]);
			position=position+Integer.parseInt(seat[1]);
			//System.out.println(seat);
			break;
		case "screen2":
			if(split.contains("A"))
				position=position+0;
			else if(split.contains("B"))
				position=position+6;
			else if(split.contains("C"))
				position=position+12;
			else if(split.contains("D"))
				position=position+18;
			else
				position=position-100;
			//System.out.println(num[0]);
			position=position+Integer.parseInt(seat[1]);
			//System.out.println(seat);
			break;
		case "screen3":
			if(split.contains("A"))
				position=position+0;
			else if(split.contains("B"))
				position=position+6;
			else if(split.contains("C"))
				position=position+12;
			else if(split.contains("D"))
				position=position+19;
			else if(split.contains("E"))
				position=position+24;
			else
				position=position-100;
			//System.out.println(num[0]);
			position=position+Integer.parseInt(seat[1]);
			//System.out.println(seat);
			break;
		}
	
		return position;
	}
	
	
	/*Disable the selected button of screen
	 * */
	public String disableSeats(String screen){	
		String seats="error seat";
		String temp = "";
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(seatUsed_file.getAbsolutePath()));		    	
		    while ((temp = reader.readLine()) != null) {	    	
		    	String[] split=temp.split(":");
		    	if(split.length>1){
		    		if(split[0].equals(screen)){
			    		seats=split[1];			    		
			    		break;
			    	}
			    	else
			    		System.out.println(split[0]);
		    	}
		    	else//this means no seat has been selected.
		    		seats="";	    	
		     }		  		   
		    reader.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return seats;
	}
	
	
	/* Find which screen for the specific film and film time
	 * */
	public String whichScreen(String selectedFilm, String filmTime){
		String screen = "screen0--wrong";
		String temp = null;
		//System.out.println("in which screen method:"+selectedFilm+filmTime);
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(screen_time_file.getAbsolutePath()));		    	
		    while ((temp = reader.readLine()) != null) {	    	
		    	String[] split=temp.split(";");
		    	if(split[0].equals(selectedFilm)){
		    		//System.out.println("equal");
		    		for(int i =2; i<split.length;i++){
		    			//System.out.println("split:"+split[i]);
		    			if(split[i].equals(filmTime)){
		    				screen = split[1];
		    				break;
		    			}		    				
		    		}
		    	}	            
		     }		  		   
		    reader.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return screen;
	}
	
	
	public String readFilm_info(){
		 String temp = null;
		 String film_info="";
		    
		    try{
		    	BufferedReader reader = new BufferedReader(new FileReader(film_info_file.getAbsolutePath()));		    	
			    while ((temp = reader.readLine()) != null) {	    	
			    	film_info=film_info+temp+"\r\n\r\n";	            
			     }		  		   
			    reader.close();
		    }catch(Exception ex){
		    	ex.printStackTrace();
		    }				
		return film_info;
	}
	

}
