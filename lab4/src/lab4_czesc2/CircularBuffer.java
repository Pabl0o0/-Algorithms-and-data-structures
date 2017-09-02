package lab4_czesc2;

public class CircularBuffer {

	private Integer front;
	private Integer end;
	private Integer currentSize;
	private Integer tablica[];
	private Integer maxSize;
	
	public CircularBuffer(int size){
		tablica = new Integer[size];
		front = 0;
		end = 0;
		currentSize = 0;
		maxSize = size;
	}
	
	public void add(Integer itg){
		if(!isFull()){
			tablica[end] = itg;
			currentSize++;
			end = (end+1) % maxSize;			
		}
	}
		
	public boolean isFull(){
		if(currentSize == maxSize){
		System.out.println("Bufor jest pe³ny ");
		return true;
	}else return false;
	}
	
	public void get(){
		 if (!isEmpty()) {
	            Integer temp = tablica[front];
	            tablica[front] = null;
	            front = (front + 1) % maxSize;
	            currentSize--;
	            System.out.println(temp);
		 }
	}
	
	public boolean isEmpty() {
		if(currentSize == 0){
			System.out.print("Bufor jest pusty ");
			return true;
		}else return false;
	}
	
	public int size() {
		System.out.print("Size is: ");
        return currentSize;
    }
	
	public boolean clean() { 
		System.out.println("CLEANING");
        front = 0;          
        end = 0;
        currentSize = 0;
        while (end != 0) {
            tablica[end] = null;
            end = (end + 1) % maxSize;
        }   
        return true;
    }
	
	 public Integer takeFirst() {
	        if (!isEmpty()) {
	            return tablica[front];
	        } else  return null;
	    }

	    public Integer takeLast() {
	        if (!isEmpty()) {
	            return tablica[end - 1];
	        } else return null;
	    }
}
