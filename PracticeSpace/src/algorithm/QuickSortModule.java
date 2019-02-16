package algorithm;

public class QuickSortModule {
	private int[] arr;
	public QuickSortModule(int[] arr){
		this.arr = arr;
	}
	
	public void sort() {
		sort(arr, 0, arr.length-1);
	}
	private void sort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if(start <part2-1) {
			sort(arr, start, part2-1);
		}
		if(part2<end) {
			sort(arr, part2, end);
		}
	}
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) /2];
		while(start<=end) {
			while(arr[start]<pivot) start++;
			while(arr[end]>pivot) end--;
			if(start <=end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
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
