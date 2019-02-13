package practicemain;

import datastructure.*;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world\n");
		
		//intArrayTest();
		//arrayListTest();
		//hashTableTest();
		customHashTableTest();
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
}
