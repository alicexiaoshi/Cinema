package cinema;


public class Customer {
	private String film,screen,time,ticketType;
	private String allSeats="";
	private int ticketNo=0;
	private double allPrice=0;
	private Ticket ticket;
	private Seat seat;
	private Report report;

	public Customer(){
		seat = new Seat();
		ticket= new Ticket();
		report = new Report();
	}
	
	public Report getReport(){		
		return report;
	}
	
	public Ticket getTicket() {
		return ticket;
	}

	public Seat getSeat() {
		return seat;
	}

	
/*	public int getAllTickeNo() {
		return allTickeNo;
	}

	public void setAllTickeNo(int allTickeNo) {
		this.allTickeNo = this.allTickeNo+allTickeNo;
	}*/
	
	
	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
		ticket.setFilm(film);
		report.setFilm(film);	
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
		ticket.setTime(time);
	}

	
	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
		ticket.setScreen(screen);
	}
	
	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
		ticket.setTicketNo(ticketNo);
		report.setTicketNo(ticketNo);
		System.out.println("set report");
	}


	public String getAllSeats() {
		return allSeats;
	}

	public void setAllSeats(String allSeats) {
		this.allSeats = allSeats+" "+this.allSeats;
	}
	
	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
		double price;
		switch(ticketType){
		case "Child":
			price = 8*this.getTicketNo();				
			break;
		case "Adult":
			price = 16*this.getTicketNo();
			//setAllPrice(16*this.getTicketNo());
			break;
		case "Senior":
			price = 12.8*this.getTicketNo();
			//setAllPrice(12.8*this.getTicketNo());
			break;
		case "Student":
			price = 13.6*this.getTicketNo();
			//setAllPrice(13.6*this.getTicketNo());
			ticket.setStudent(true);		
			break;
		default:
			price=0.0;
			System.out.println("error in set ticket type.");
		}			
		this.setAllPrice(price);	
		report.setAllPrice(price);
		report.setType(ticketType);
		ticket.setType(ticketType);
		ticket.recordTempTickets();
		
	}

	
	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = this.allPrice+allPrice;
	}
	
	
	
	
}
