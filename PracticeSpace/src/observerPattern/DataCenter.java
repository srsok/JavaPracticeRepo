package observerPattern;

import java.util.Observable;

public class DataCenter extends Observable{
	private int dataSource;

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		sendNotice();
		this.dataSource = dataSource;
	}

	public void sendNotice() {
		this.setChanged();
		this.notifyObservers();
	}

}
