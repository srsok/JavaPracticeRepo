package algorithm;

public class SelectionSortModule {
	private int[] arr;
	int min;
	public SelectionSortModule(int[] arr){
		this.arr = arr;
	}
	
	public void sort() {
		sort(arr, 0);
	}
	private void sort(int[] arr, int start) {
		if(start < arr.length -1) {
			min = start;
			for(int i = start; i<arr.length; i++) {
				if(arr[i] < arr[min]) min = i;
			}
			swap(arr, start, min);
			sort(arr, start+1);
		}
	}
	private void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	public void print() {
		for(int data : arr) {
			System.out.print(data+" ");
		}
		System.out.println("");
	}
}
