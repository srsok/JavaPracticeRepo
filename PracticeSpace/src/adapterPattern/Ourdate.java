package adapterPattern;

import java.util.Date;

public class Ourdate extends Date implements CustomDate{
	public Ourdate(){
		super();
	}
	public Ourdate(int year, int month, int day){
		super(year-1900, month-1, day);
	}
	public int getYear() {
		return super.getYear() + 1900;
	}
	public int getMonth() {
		return super.getMonth() +1;
	}
}
