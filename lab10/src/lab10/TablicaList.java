package lab10;

public class TablicaList {

	
	private SortedList[] hashArray; 
	private int arraySize;
	

	public TablicaList(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize]; 
		for(int j=0; j<arraySize; j++)
			hashArray[j] = new SortedList(); 
	}
	

	public void dump(){
		for(int j = 0; j<arraySize; j++){
			System.out.print(j+". "); 
			hashArray[j].displayList(); 
		}
	}
	

	public int hashFunction(int key){
		return key % arraySize;
	}
	

	public void put(Link link){
		if(!containsKey(link.getKey())){
		int key = link.getKey();
		int hashVal = hashFunction(key); 
		hashArray[hashVal].insert(link);
		}
	}


	public Link get(int key){
		int hashVal = hashFunction(key);
		Link link = hashArray[hashVal].find(key);
		return link;
	}
	

		public boolean containsKey(int key){
			if(get(key) != null){
				return true;
			}else{
				return false;
			}
		}
		

		public int size(){
			int size = 0;
			for(int j=0; j<arraySize; j++)
				size++;
			return size;
		}
		

		public boolean isEmpty(){
			if(size() == 0)
				return true;
			else
				return false;
		}
		

		public static void main(String[] args){
			TablicaList l = new TablicaList(13);
			l.dump();
			System.out.println("Czy tablica jest pusta? "+l.isEmpty());
			System.out.println("Dodano 3.");
			l.put(new Link(3));
			l.dump();
			System.out.println("Dodano 5, 2, 1, 7, 20.");
			l.put(new Link(5));
			l.put(new Link(2));
			l.put(new Link(1));
			l.put(new Link(7));
			l.put(new Link(20));
			l.dump();
			System.out.println("Dodano 35, 4, 8, 29, 31, 50, 69.");
			l.put(new Link(35));
			l.put(new Link(4));
			l.put(new Link(8));
			l.put(new Link(29));
			l.put(new Link(31));
			l.put(new Link(50));
			l.put(new Link(69));
			l.dump();
			System.out.println("Czy tablica jest pusta? "+l.isEmpty());
		}
}