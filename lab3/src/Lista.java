


public class Lista {

	private final Node head = new Node(null);
	private int size;
	
	public Lista(){
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

	//metody 
	public void insert(int index, Object value) throws IndexOutOfBoundsException{
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		if(head.next == null){
			head.next = new Node(value);
			size++;
			return;
		}
		Node previous = getNode(index - 1);
		Node next = getNode(index);
        Node inserted = new Node(value);
        previous.next = inserted;
        inserted.next = next;
        size++;
	}
	private Node getNode(int index){
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node find = head.next;
        for(int i = 0; i < index; i++) {
            find = find.next;
        }
        return find;
    }
	
	
	public Object delete(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node previous = getNode(index - 1);
        Node deleted = getNode(index);
        Node next = deleted.next;
        previous.next = next;
        size--;
        return deleted;
    }
	
	public Object get(int index){
	        return getNode(index).value;
	    }
	
	public int size(){
        return size;
    }
	
	public void clear(){
		head.next = null;
		size = 0;
		}
	
	public void wyswietlListe(){
        for(int i = 0; i < size(); i++)
            System.out.println(get(i));
        System.out.println();
    }
	
	public void add(Object value){
        insert(size(), value);
    }

    public boolean delete(Object object){
        Node deleted = head.next;
        int i;
        for(i = 0; !deleted.value.equals(object); i++) 
        	deleted = deleted.next;
        if(i < size){
            delete(i);
            return true;
        }
        return false;
    }

    public Object set(int index, Object value){
    	if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node node = getNode(index);
        Object oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    public int indexOf(Object value){
        Node find = head.next;
        int i = -1;
        for(i = 0; i < size && !find.value.equals(value); i++) 
        	find = find.next;
        return i;
   }

    public boolean contains(Object value){
        Node find = head.next;
        int i;
        
        for(i = 0; !find.value.equals(value) && i < size(); i++) {
        	find = find.next;
        		if (!find.value.equals(value))
        				return false;
        }
        return find.value.equals(value);
    }
	
    
    private final class ValueIterator implements Iterator{
        private Node current = head;
        ValueIterator(){
            first();
        }
        public void first(){
            current = head.next;
        }
        public void next(){
            current = current.next;
        }
        public boolean isDone(){
            return current == null;
        }
        public Object current() throws IndexOutOfBoundsException{
            if(isDone()) throw new IndexOutOfBoundsException();
            return current.value;
        }
       
    }

    public ValueIterator iterator(){
        return new ValueIterator();
    }
}
