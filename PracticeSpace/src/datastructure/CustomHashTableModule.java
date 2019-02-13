package datastructure;
import java.util.*;


public class CustomHashTableModule {
	class Node{ // LinkedList에 들어가느 Map 구조체 내부 클래스 
		String key;
		String value;
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		String value() {
			return value;
		}
		String key() {
			return key;
		}
		void value(String value) {
			this.value = value;
		}
	}
	LinkedList<Node>[] data; // Table 내에 들어있는 키 해시 리스트 
	public CustomHashTableModule(int size){
		this.data = new LinkedList[size];
	}
	private int getHashCode(String key) { //해쉬 함수 

		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode +=c;
		}
		return hashcode;
		
	}
	private int convertToIndex(int hashcode) { //배열의 특정 위치에 배정하는 함수 
		return hashcode % data.length;
	}
	Node searchKey(LinkedList<Node> list, String key) { // 중복 키를 찾는 함수 
		if(list == null) return null;
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	public void put(String key, String value) {
		int hashcode = getHashCode(key); // 해쉬코드와
		int index = convertToIndex(hashcode); // 인덱스르 얻는다
		LinkedList<Node> list = data[index]; // 배열 인덱스에 리스트
		System.out.println(key+", hashcode("+hashcode+"), index("+index+")");
		if(list == null) { // 없으면
			list = new LinkedList<Node>(); // 인스턴스화하고 집어넣음  
			data[index] = list;
		}
		Node node = searchKey(list, key);
		if(node == null) { // 키값이 없으면 
			list.addLast(new Node(key, value)); //링크드리스트의 끝에 추가 
		}
		else {
			node.value(value); // 있으면 갚을 갱신 
		}
	}
	public String get(String key) {
		int hashcode = getHashCode(key); // 해쉬코드와 그를 이용한 인덱스를 계산한다 
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index]; // 해당 인덱스의 링크드리스트를 불러온다
		Node node = searchKey(list, key); // 찾는다 
		return node  == null? "Not found":node.value(); // 없으면 낫파운드
	}
	public void print() {
		for(LinkedList<Node> list : data) {
			if(list == null) {
				continue;
			}
			else {
				for(Node node : list) {
					System.out.print(node.key+" "+node.value+" ");
				}
			}

			System.out.println();
		}
	}
}
