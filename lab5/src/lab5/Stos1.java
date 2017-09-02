package lab5;

import java.util.EmptyStackException;

public class Stos1 { //stos nieograniczony na bazie listy bez g³owy i ogona

	private Element last;
	private int size;
	private Element tmp;
	
	public Stos1(){
		clear();
	}
	
private static final class Element{
	Object value;
	Element next;
	
	Element(Object value){
		this.value = value;
		next = null;
	}
}

	//metody 
	public void push(Object value) {
		if(isEmpty()){
			last = new Element(value);

		} else{
		tmp = new Element(value);
		tmp.next = last;
		last = tmp;
		}
		
		size++;
	}
		
	public boolean isEmpty(){
		if(size == 0){      
			return true;
	} else
		return false;
	}
	
	public int size(){
        return size;
    }
	
	public void clear(){
		size = 0;
		}
	
	public Object pop() throws EmptyStackException {
		if (isEmpty()) { 
			throw new EmptyStackException();
		}
		tmp = last;
		last = last.next;
		size--;
		return tmp.value;
	}
	
	public Object peek() throws EmptyStackException {
		if (isEmpty()) { 
			throw new EmptyStackException();
		}
		return last.value;
	}
}
