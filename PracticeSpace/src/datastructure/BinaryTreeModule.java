package datastructure;

public class BinaryTreeModule{ //이진 트리 
	private int data;
	private BinaryTreeModule left;
	private BinaryTreeModule right;
	
	public BinaryTreeModule(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeModule getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeModule left) {
		this.left = left;
	}

	public BinaryTreeModule getRight() {
		return right;
	}

	public void setRight(BinaryTreeModule right) {
		this.right = right;
	}
	
}
