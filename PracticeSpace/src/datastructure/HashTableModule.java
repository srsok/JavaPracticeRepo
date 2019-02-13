package datastructure;
import java.util.*;
public class HashTableModule {
	String[] testKey = {"Kim","Stive","valhalra","Ostin","malrok","Kstin","Omg"};
	
	int[] testValue= {124,4343,5245,545,554,445,442};
	
	Hashtable<String, Integer> testHashTable;
	public HashTableModule(){
		testHashTable = new Hashtable<String, Integer>();
		for(int i=0; i<testKey.length; i++) {
			testHashTable.put(testKey[i], testValue[i]);
		}
	}
	public void test() {
	    testHashTable.put("An",1234);
	    testHashTable.put("yan", 5656);
	    testHashTable.putIfAbsent("Frank",55); // 해당 키가 없을 경우에만 키-값 쌍을 집어넣음
	    System.out.println(testHashTable);
	    
	    System.out.println("\nTable Information methods");
	    System.out.println("This Table is empty?:"+testHashTable.isEmpty());
	    System.out.println("Table Size:"+testHashTable.size());
	    System.out.println("Table Key 'Kim' is exist?:"+testHashTable.containsKey("Kim"));
	    System.out.println("Table Value 999 exsist?:"+testHashTable.containsValue(999));
	    System.out.println("Table Value get:"+testHashTable.get("Kim"));
	    
	    System.out.println("\nTable Removing methods");
	    System.out.println("Removing:"+testHashTable.remove("malrok"));
	    System.out.println(testHashTable);
	    System.out.println("key-value removing:"+testHashTable.remove("Omg",442)); //키와 밸류 모두 매칭될때만 삭제
	    System.out.println(testHashTable);
	    
	    System.out.println("\nMap->Set");
	    Set<Map.Entry<String, Integer>> testEntries = testHashTable.entrySet();
	    System.out.println("Entry:"+testEntries);
	    Set<String> keys = testHashTable.keySet();
	    System.out.println(keys);
	    Collection<Integer> values = testHashTable.values();
	    System.out.println(values);
	    
	    System.out.println("\nIterator");
	    Iterator<Map.Entry<String, Integer>> testIterator = testEntries.iterator();
	    while(testIterator.hasNext()) {
	    	Map.Entry<String, Integer> entry = testIterator.next();
	    	System.out.println(entry.getKey() +" => "+entry.getValue());
	    }
	}
}
