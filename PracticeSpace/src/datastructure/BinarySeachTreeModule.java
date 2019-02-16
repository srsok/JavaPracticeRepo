package datastructure;

public class BinarySeachTreeModule {
	BinaryTreeModule root;
	public BinarySeachTreeModule() {
		this.root = null;
	}
	
	public Boolean find(int value) {
		BinaryTreeModule current = root;
		while(current != null) {
			if(current.getData() ==value) {
				return true;
			}
			else if(current.getData()>value) {
				current = current.getLeft();
			}
			else {
				current = current.getRight();
			}
		}
		return false;
	}
	public void insert(int value) {
		BinaryTreeModule newNode = new BinaryTreeModule(value);
		if(root == null) {
			root = newNode;
			return;
		}
		BinaryTreeModule current = root;
		BinaryTreeModule parent = null;
		while(true) {
			parent = current;
			if(value<current.getData()) {
				current = current.getLeft(); 
				if(current == null) {
					parent.setLeft(newNode);
					return;
				}
			}
			else {
				current = current.getRight();
				if(current == null) {
					parent.setRight(newNode);
					return;
				}
			}
		}
	}

	public boolean delete(int value) {
		BinaryTreeModule parent = root;
		BinaryTreeModule current = root;
		boolean isLeftChild = false;
		while(current.getData() != value) {
			parent = current;
			if(current.getData()>value) {
				isLeftChild = true;
				current = current.getLeft();
			}
			else {
				isLeftChild = false;
				current = current.getRight();
			}
			if(current == null) {
				return false;
			}
		}
		
		if(current.getLeft() == null && current.getRight() == null) { // 잎새 노드인 경우 
			if(current == root) {
				root = null;
			}
			if(isLeftChild == true) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
		else if(current.getRight() == null) { // 하나의 자식 노드 -> 오른쪽 자식 노드가 없을 때 
			if(current == root) { //왼쪽을 이어줌 
				root = current.getLeft();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getLeft());
			}
			else {
				parent.setRight(current.getLeft());
			}
		}
		else if(current.getLeft() == null){ //<- 왼쪽  자식 노드가 없을 때
			if(current == root) {
				root = current.getRight();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getRight());
			}
			else {
				parent.setRight(current.getRight());
			}
		}
		else if(current.getLeft() != null && current.getRight() != null) { // 둘 다 있는 경우, 기준->오른쪽 서브트리
			BinaryTreeModule successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			}
			else if(isLeftChild) {
				parent.setLeft(successor);
			}
			else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
		return true;
	}
	
	public void inorder(BinaryTreeModule n) {
		if(n!=null) {
			inorder(n.getLeft());
			System.out.print(" "+n.getData());
			inorder(n.getRight());
		}
	}
	public void preorder(BinaryTreeModule n) {
		if(n!=null) {
			System.out.print(" "+n.getData());
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	public void postorder(BinaryTreeModule n) {
		if(n!=null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(" "+n.getData());
		}
	}
	
	public BinaryTreeModule getRoot() {
		return root;
	}
	private BinaryTreeModule getSuccessor(BinaryTreeModule deleteNode) {
		BinaryTreeModule successor = null;
		BinaryTreeModule successorParent = null;
		BinaryTreeModule current = deleteNode.getRight();
		while(current != null) {
			successorParent  =successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor != deleteNode.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteNode.getRight());
		}
		return successor;
	}
}
