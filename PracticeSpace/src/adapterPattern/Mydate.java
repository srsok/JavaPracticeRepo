package adapterPattern;

import java.util.Date;

public class Mydate implements CustomDate {
	private Date oldDate;
	
	public Mydate(){
		oldDate = new Date();
	}
	
	public Mydate(int year, int month, int day){
		oldDate = new Date(year - 1900, month -1, day);
		
	}
	public int getYear() {
		return oldDate.getYear()+1900;
	}
	public int getMonth() {
		return oldDate.getMonth()+1;
	}
	public String toString() {
		return oldDate.toString();
	}
}
