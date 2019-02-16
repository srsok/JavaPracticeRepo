package datastructure;

public class CustomStringBuffer {
	private char[] buffer;
	private int capacity;
	private int length;
	
	public CustomStringBuffer(int l) {
		capacity =l;
		buffer = new char [capacity];
		length =0;
	}
	
	public synchronized CustomStringBuffer append(String str) {
		String s = str;
		if(s == null) s = "null";
		
		if(length+s.length()>capacity) { // capacity보다 더한 문자열 크기가 클 경우
			int l = Math.max(length+s.length(), 2*capacity); //더한 길이와 capacity*2 중 큰 값을 선택
			char[] b = new char[l]; // 해당 길이로 임시 버퍼 생성
			for (int i=0; i<length; i++) {
				b[i] = buffer[i]; //버퍼의 내용을 임시 버퍼에 이동
			}
			buffer  = b; // 버퍼 = 임시 버퍼
			capacity =l; // 카파시티 = 확장된 길이
		}
		for(int i=0; i<s.length(); i++) { //버퍼 뒤에 str의 내용 붙임
			buffer[length+i] = s.charAt(i);
		}
		length +=s.length(); // 길이 확장
		return this; // 리턴
	}
	public String toString() {
		return new String(buffer, 0, length);
	}
}
