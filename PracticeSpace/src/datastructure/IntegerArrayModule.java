package datastructure;

import java.util.Arrays;
import java.util.Collections;
/**
 * Class for Practice Integer Array Control
 * fill, replace value, add, sort, find min max value
 * @param dataArray:main data structure
 *        size: array size
 *        currentIndex: store current index for add, delete function
 *        min: array minimum value 
 *        max: array maximum value
 * @author JungHyun An
 *
 */
public class IntegerArrayModule{
	private int[] dataArray; // main data structre : array
	private int size; //arrray size
	private int currentIndex; //store current index for add, delete function
	private int min=0;
	private int max=0;
	public IntegerArrayModule(int space) {
		 size = space;
	    dataArray = new int[space];	
	    currentIndex=0;
	}
	/**
	 * Method for init array 1 value
	 * @param value: init value
	 * @author JungHyun An
	 *
	 */
	public void init(int value) {
		Arrays.fill(dataArray,value);
		currentIndex = dataArray.length-1;
	}
	public void assign(int index, int value) {
		try {
			dataArray[index] = value;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Can't assign value without index range");
		}
	}
    public void add(int value) {
    	size++;
    	int[] tempArray = dataArray;
    	dataArray = new int[size];
    	for(int i=0; i<tempArray.length; i++) {
    		dataArray[i] = tempArray[i];
    	}
    	dataArray[dataArray.length-1] = value;
    	
    }
	public void sort(boolean trigger) { //true:asc, false:desc
		if(trigger) {
			Arrays.sort(dataArray);
			min = dataArray[0];
			max = dataArray[dataArray.length-1];
		}
		else{
			Integer[] IntegerDataArray = Arrays.stream(dataArray).boxed().toArray(Integer[]::new);
			Arrays.sort(IntegerDataArray, Collections.reverseOrder());
			dataArray = Arrays.stream(IntegerDataArray).mapToInt(Integer::intValue).toArray();
			
			min = dataArray[dataArray.length-1];
			max = dataArray[0];
		}
	}
	public boolean contain(int value) {
		for(int a : dataArray) {
			if(a == value) {
				return true;
			}
		}
			
		return false;
	}
	public void print() { // Print Array Information
		int lastIndex = dataArray.length-1;
		for(int i=0; i<=lastIndex; i++) {
			System.out.print("index"+i+":"+dataArray[i]+" ");
		}
		System.out.println(""); 
		System.out.println("Initial Array Size:"+size);
		
		System.out.println("ArrayList Value Index:"+lastIndex);
		
		System.out.println("Min:"+min);
		System.out.println("Max:"+max);
		
		System.out.println("");
		
	}
}
