package designpattern;

import java.util.Date;

import adapterPattern.*;
import observerPattern.*;

public class DesignPatternPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Design Pattern");
		
		
		//adapterTest();
		observerTest();
	}
	private static void observerTest() {
		DataCenter here = new DataCenter();
		Warning task1 = new Warning(here);
		Machine task2 = new Machine(here);

		for(int i=10; i<120; i+=5) {
			System.out.format("%d ", here.getDataSource());
			here.setDataSource(i);
		}
	}
	private static void adapterTest() {
		/*Date today = new Date();
		System.out.println("1>" + today);
		System.out.println("2>" + (today.getYear()+1900));
		System.out.println("3>" + (today.getMonth()+1));
		
		today = new Date(2012-1900, 12-1, 21);
		System.out.println("4>" + today);
		System.out.println("5>" + (today.getYear()+1900));
		System.out.println("6>" + (today.getMonth()+1));
		
		
		CustomDate today = new Mydate();
		System.out.println("1>" + today);
		System.out.println("2>" + today.getYear());
		System.out.println("3>" + today.getMonth());
		
		today = new Mydate(2012,12,21);
		System.out.println("4>" + today);
		System.out.println("5>" + today.getYear());
		System.out.println("6>" + today.getMonth());
		
		System.out.println();
		
		today = new Ourdate();
		System.out.println("1>" + today);
		System.out.println("2>" + today.getYear());
		System.out.println("3>" + today.getMonth());
		
		today = new Ourdate(2012,12,21);
		System.out.println("4>" + today);
		System.out.println("5>" + today.getYear());
		System.out.println("6>" + today.getMonth());
		*/
		
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
