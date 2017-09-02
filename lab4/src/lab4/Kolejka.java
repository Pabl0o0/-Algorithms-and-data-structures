package lab4;

public  class Kolejka implements Queue {

	private Node head = new Node(null);
	private int size;
	
	public Kolejka(){
		clear();
	}
	
	//wewnêtrzna klasa wartownika
private static final class Node{
	Object value;
	Node next;
	
	Node(Object value){
		this.value = value;
		next = null;
	}

}
	
	@Override
	public void enqueue(Object value) {
		// TODO Auto-generated method stub
		if(head.next == null){
			head.next = new Node(value);
			size++;
		} else{
			Node tmp = head;
			while (tmp.next!=null){
				tmp = tmp.next;
			}
			tmp.next = new Node(value);
			size++;
			}		
		System.out.println(value);    //pokazuje element wstawiany 
	}
	
	@Override
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) { 
			throw new EmptyQueueException("Kolejka pusta!");
		}
		Node tmp = head;
		head = head.next;
		size--;
		return tmp.next.value;
		
		}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head.next == null){
			return true;
		}
		return false;
	}

	
	public void displayQueue()throws EmptyQueueException {
		
		if (isEmpty()) { 
			throw new EmptyQueueException("Kolejka pusta!");
		}
		
		else {
			Node tmp = head.next;
			while ( tmp != null ) {
				System.out.println(tmp.value);
				tmp = tmp.next;
			}
		}
	}

}
