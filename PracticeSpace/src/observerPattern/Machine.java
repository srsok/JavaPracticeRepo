package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class Machine implements Observer{

	private Observable observable;
	public Machine(Observable source){
		this.observable = source;
		this.observable.addObserver(this);
	}
	public void working() {
		System.out.println("This system is working now");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DataCenter) {
			DataCenter datasource = (DataCenter)o;
			int source = datasource.getDataSource();
			if(source > 40 && source < 90) working();
		}
		
	}
}
