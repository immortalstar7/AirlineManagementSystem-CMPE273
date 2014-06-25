package model;

public class FlightDetails {
	String flight_name;
	int no_of_seats;
	String flight_date;
	String source;
	String destination;
	String avail_seats;
	int crew_id;
	String flight_no;
	
	
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getAvail_seats() {
		return avail_seats;
	}
	public void setAvail_seats(String avail_seats) {
		this.avail_seats = avail_seats;
	}
	public int getCrew_id() {
		return crew_id;
	}
	public void setCrew_id(int crew_id) {
		this.crew_id = crew_id;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}


}
