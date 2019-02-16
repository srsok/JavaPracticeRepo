package algorithm;

public class InsertionSortModule {
	private int[] arr;
	int aux;
	public InsertionSortModule(int[] arr){
		this.arr = arr;
	}
	public void sort() {
		for(int i=0; i<arr.length; i++) {
			int standard = arr[i];
			int aux = i-1;
			
			while(aux >=0 && standard<arr[aux]) {
				arr[aux+1] = arr[aux];
				aux--;
			}
			arr[aux+1] = standard;
		}
	
	}

	public void print() {
		for(int data : arr) {
			System.out.print(data+" ");
		}
		System.out.println("");
	}
}
