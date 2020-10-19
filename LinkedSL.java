package cse12pa2student;

import java.util.Arrays;

class Node {
	String value;
	Node next;

	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}
}

public class LinkedSL implements StringList {
	Node front;
	int size;

	public LinkedSL(String[] contents) {
    // Fill in this constructor
		this.front = new Node(null, null);
	    Node current = this.front;
	    this.size = 0;
		for(int i = 0; i < contents.length; i++) {
			current.next = new Node(contents[i],null);
			current = current.next;
			this.size ++;
		}
		
	}

	// Fill in all methods
	@Override
	public String[] toArray() {
		String[] arr = new String[this.size];
		for(int i = 0; i < size; i++) {
		    Node current = this.front.next;
		    for(int j = 0; j < i; j += 1) {
		      current = current.next;
		    }
		    arr[i]= current.value;
		}
		return arr;
	}
	
	@Override
	public void transformAll(StringTransformer st) {
		String[] arr = this.toArray();
		String[] newArr = new String[size];
		for(int i = 0; i < size; i++) {
			newArr[i] = st.transformElement(arr[i]);
			
		}
		this.front = new Node(null, null);
	    Node current = this.front;
	    this.size = 0;
		for(int i = 0; i < newArr.length; i++) {
			current.next = new Node(newArr[i],null);
			current = current.next;
			this.size ++;
		}
	}
	
	@Override
	public void chooseAll(StringChooser sc) {
		String[] arr = this.toArray();
		
		
		int[] count = new int[size];
		int index = 0;
		for(int i = 0; i<size; i++) {
			
			if(sc.chooseElement(arr[i])) {
				count[index] = i;
				index++;
			}
			
		}
		System.out.println(Arrays.toString(count));
		String[] remove = new String[index];
		for(int i = 0; i<index;i++) {
			remove[i] = arr[count[i]];
			System.out.println(remove[i]);
		}

		this.front = new Node(null, null);
	    Node current = this.front;
	    this.size = 0;
		for(int i = 0; i < remove.length; i++) {
			current.next = new Node(remove[i],null);
			current = current.next;
			this.size ++;
		}
		
		return;
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	
}
