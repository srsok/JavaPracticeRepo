package datastructure;
import java.util.*;
public class ListModule {
	List list;
	int[] testdata = {1,4,5,6,2,3,8,9,11,25,14};
	private boolean mode;
	public ListModule(boolean mode){ // true: ArrayList, false: LinkedList
		this.mode = mode;
		if(mode) {
			list = new ArrayList<Integer>();
		}
		else {
			list = new LinkedList<Integer>();
		}
	}
	public void test() {
		for(int i=0; i<testdata.length; i++) {
			list.add(testdata[i]);
		}
		if(mode) {
			arrayListTest(); 
		}
		else {
			linkedListTest();
		}
	}
	private void linkedListTest() {
		System.out.println("LinkedList Size:"+list.size());
		LinkedList tempList = (LinkedList) list;
		tempList.add(3,33);
		System.out.println("LinkedList:"+tempList);
		tempList.addFirst(11);
		System.out.println("Add first LinkedList:"+tempList);
		tempList.addLast(55);
		System.out.println("Add Last LinkedList:"+tempList);
		
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		tempArrayList.add(533);
		tempArrayList.add(633);
		tempArrayList.add(733);
		tempList.addAll(tempArrayList);
		
		Integer first = (Integer) tempList.getFirst();
		Integer element = (Integer) tempList.get(3);
		Integer last = (Integer) tempList.getLast();
		
		System.out.println("\nGet Methods");
		System.out.println(first);
		System.out.println(element);
		System.out.println(last);
		
		System.out.println("\nRemoving Methods");
		first = (Integer) tempList.removeFirst();
		element = (Integer) tempList.remove(3);
		last = (Integer) tempList.removeLast();
		System.out.println("Remove element:"+first+" =>"+tempList);
		System.out.println("Remove element:"+element+" =>"+tempList);
		System.out.println("Remove element:"+last+" =>"+tempList);
		
		System.out.println("\nFinding Methods");
		System.out.println(tempList.contains(55));
		System.out.println(tempList.indexOf(1));
		
		System.out.println("\nIterator  Methods");
		Iterator<Integer> tempListIter = tempList.iterator();
		while(tempListIter.hasNext()) {
			Integer tempvalue = tempListIter.next();
			System.out.print(tempvalue+" ");
		}
	}
	private void arrayListTest() {
		System.out.println("ArrayList Size:"+list.size());
		Integer removeOjbect = 25;
		Integer containObject = 4;
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		 
		for(int i=0; i<list.size(); i++) {
			System.out.print("index"+i+":"+list.get(i)+" ");
		}
		System.out.println();
		
		list.remove(removeOjbect); // int 자료형이면 index랑 구분이 안됨, Integer 오브젝트로 선언해주고 넣어야됨
		list.remove(list.size()-1);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print("index"+i+":"+list.get(i)+" ");
		}
		System.out.println();
		System.out.println("List contain "+removeOjbect+"?:"+list.contains(removeOjbect));
		System.out.println("List contain "+containObject+"?:"+list.contains(containObject));
		
		System.out.println("then List has "+containObject+" at "+list.indexOf(containObject));
		//lastIndexof : 중복이 존재할 시 마지막 오브젝트의 위치
		
		iterator = list.iterator(); // List의 변동이 잇은 후에는 Iterator를 인스턴스화해야됨
		 while(iterator.hasNext()) {
		    	Integer num = iterator.next();
		    	if(num % 2 ==0) {
		    		iterator.remove(); // 반드시 next 뒤에 remove가 나와야됨, 안그러면 순서가 엉킴
		    	}
		 }
	  
	    for(int i=0; i<list.size(); i++) {
			System.out.print("index"+i+":"+list.get(i)+" ");
		}
	    System.out.println();
	    ArrayList<Integer> templist = new ArrayList<Integer>();
	    templist.add(54);
	    templist.add(14);
	    templist.add(22);
	    templist.add(4);
	    list.addAll(templist);
	    
	    for(int i=0; i<list.size(); i++) {
			System.out.print("index"+i+":"+list.get(i)+" ");
		}
	    System.out.println();
	    Collections.sort(list);
	    for(int i=0; i<list.size(); i++) {
			System.out.print("index"+i+":"+list.get(i)+" ");
		}
	    System.out.println();
	    
	    System.out.println(Collections.max(list));
	    System.out.println(Collections.min(list));
	    Collections.reverse(list);
	    
	    for(int i=0; i<list.size(); i++) {
	 			System.out.print("index"+i+":"+list.get(i)+" ");
	 	 }
	 	 System.out.println();
	 	 Collections.rotate(list,3); // 오른쪽으로 돌림
	 	 for(int i=0; i<list.size(); i++) {
	 			System.out.print("index"+i+":"+list.get(i)+" ");
	 	 }
	 	 System.out.println();
	 	 Collections.rotate(list, -3); //왼쪽으로 돌림
	 	 for(int i=0; i<list.size(); i++) {
 			  System.out.print("index"+i+":"+list.get(i)+" ");
 	     }
 	     System.out.println();
    }

}
