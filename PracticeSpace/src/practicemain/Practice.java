package practicemain;

import datastructure.*;
import java.util.*;

import algorithm.*;
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world\n");
		
		//intArrayTest();
		//arrayListTest();
		//hashTableTest();
		//customHashTableTest();
		//treeTest();
		//binarySearchTreeTest();
		//customStringBufferTest();
		
		//graphTest();
		quicksortTest();
		selectionsortTest();
		insertionsortTest();
	}
	
	private static void intArrayTest() {
		int size=10;
		IntegerArrayModule ia = new IntegerArrayModule(size);
		ia.init(1);
		for(int i=1; i<size; i++) {
			ia.assign(i, i+1);
		}
		ia.sort(false);
		ia.print();
		
		ia.sort(true);
		ia.print();
		
		ia.add(11);
		ia.print();
		
		System.out.println(ia.contain(1));
	}
	private static void arrayListTest() {
		ListModule lm = new ListModule(false);
		lm.test();
	}
	private static void hashTableTest() {
		HashTableModule hm = new HashTableModule();
		hm.test();
	}
	private static void customHashTableTest() {
		CustomHashTableModule chm = new CustomHashTableModule(20);
		chm.put("abc", "gfngfn");
		chm.put("oof", "nfgn");
		chm.put("qwe", "ngnfs");
		chm.put("adfh", "gngf");
		chm.put("cvbf", "gng");
		chm.put("werwf", "bnb");
		chm.put("asdvs", "xcv");
		System.out.println(chm.get("abc"));
		System.out.println(chm.get("oof"));
		System.out.println(chm.get("bbff"));
		System.out.println();
		chm.print();
		
	}
	private static void treeTest() {
		TreeModule<String> tm = new TreeModule<String>("Root");
				
		TreeModule<String> tm1 = tm.addChild("Node1");
		
		
		TreeModule<String> tm11 = tm1.addChild("Node1-1");
		TreeModule<String> tm111 = tm11.addChild("Node1-1-1");
		TreeModule<String> tm112 = tm11.addChild("Node1-1-2");
		
		TreeModule<String> tm12 = tm1.addChild("Node1-2");
		
		TreeModule<String> tm2 = tm.addChild("Node2");
		
		TreeModule<String> tm21 = tm.addChild("Node2-1");
		TreeModule<String> tm22 = tm.addChild("Node2-2");
		String appender="";
		printTree(tm, appender);
		
		System.out.println(tm22.getRoot().getData());
	}
	private static void binarySearchTreeTest() {
		BinarySeachTreeModule bm = new BinarySeachTreeModule();
		bm.insert(20);
		bm.insert(17);
		bm.insert(25);
		bm.insert(15);
		bm.insert(16);
		bm.insert(27);
		System.out.print("InOrder:");
		bm.inorder(bm.getRoot());
		System.out.print("\nPreOrder:");
		bm.preorder(bm.getRoot());
		System.out.print("\nPostOrder:");
		bm.postorder(bm.getRoot());
		
		bm.delete(20);
		System.out.print("\nAfter:");
		bm.preorder(bm.getRoot());
		bm.delete(27);
		System.out.print("\nAfter:");
		bm.preorder(bm.getRoot());
		bm.delete(25);
		System.out.print("\nAfter:");
		bm.preorder(bm.getRoot());
		
	}
	private static void customStringBufferTest() {
		CustomStringBuffer cb = new CustomStringBuffer(2);
		cb.append("abcd");
		System.out.println(cb.toString());
		cb.append(" ddfkfke");
		System.out.println(cb.toString());
	}
	private static void graphTest() {
		GraphModule gr = new GraphModule();
		gr.test();
		
	}
	private static void quicksortTest() {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		QuickSortModule qs = new QuickSortModule(arr);
		qs.print();
		qs.sort();
		qs.print();
	}
	private static void selectionsortTest() {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		SelectionSortModule ss = new SelectionSortModule(arr);
		ss.print();
		ss.sort();
		ss.print();
	}
	private static void insertionsortTest() {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		InsertionSortModule is = new InsertionSortModule(arr);
		is.print();
		is.sort();
		is.print();
	}
	private static <T> void printTree(TreeModule<T> node, String appender) {
		System.out.println(appender + node.getData());
		node.getChildren().forEach(each->printTree(each, appender + appender));
		System.out.println();
	}
}

