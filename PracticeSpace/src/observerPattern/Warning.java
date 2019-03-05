package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class Warning implements Observer{
	private Observable observable;
	private Boolean warning = false;
	
	public Warning(Observable source ){
		this.observable = source;
		this.observable.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DataCenter) {
		   DataCenter dataSource = (DataCenter)o;
		   if(warning) {
				System.out.println("Warning! Stop The System.");
			}
			else if(dataSource.getDataSource() >= 100) {
				warning = true;
			}
		}
			
	}
}
