package lab10;

public class Link {
	
	private int key; 
	public Link next; 
	
	public Link(int item){
		key = item;
	}
	
	public int getKey(){
		return key;
	}
	
	public void displayLink(){
		System.out.print(key+" ");
	}

}


