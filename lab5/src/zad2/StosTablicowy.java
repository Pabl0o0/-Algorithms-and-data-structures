package zad2;

import java.util.EmptyStackException;

public class StosTablicowy {
	
		private int last;
		private Integer currentSize;
		private Object tablica[];
		
		
		public StosTablicowy(int size){
			tablica = new Object[size];
			last = -1;
			currentSize = size;
		}
		
		public void push (Object object){
			if(isFull()) throw new FullStackException();
			tablica[++last] = object;
		}
		
		public Object pop(){
			if(isEmpty()) throw new EmptyStackException();
			return tablica[last--];
		}
		
		public Object peek() {
	        if(isEmpty()) throw new EmptyStackException();
	        return tablica[last];
	    }
		public boolean isEmpty() {
	        return (last == -1);
	    }
	    public boolean isFull() {
	        return (last == currentSize - 1);
	    }
	    class FullStackException extends RuntimeException{}
}
	