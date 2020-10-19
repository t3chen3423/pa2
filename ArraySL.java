package cse12pa2student;



public class ArraySL implements StringList {

	String[] elements;
	int size;
	
	public ArraySL(String[] initialElements) {
		this.elements = initialElements;
		this.size = initialElements.length;
	}

  // Fill in all required methods here
	@Override
	public String[] toArray() {
		return elements;
	}
	
	@Override
	public void transformAll(StringTransformer st) {
		String[] newArr = new String[size];
		for(int i = 0; i < size; i++) {
			newArr[i]=st.transformElement(elements[i]);
			System.out.println(newArr[i]);
			
		}
		this.elements = newArr;
	}
	
	@Override
	public void chooseAll(StringChooser sc) {
		int[] count = new int[size];
		int index = 0;
		for(int i = 0; i<size; i++) {
			
			if(sc.chooseElement(this.elements[i])) {
				count[index] = i;
				index++;
			}
			
		}
		
		String[] remove = new String[index];
		for(int i = 0; i<index;i++) {
			remove[i] = elements[count[i]];
			System.out.println(remove[i]);
		}
		this.elements = remove;
	
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
}
