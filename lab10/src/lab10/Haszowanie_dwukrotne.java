package lab10;

public class Haszowanie_dwukrotne {
	
		private Obiekt[] hashArray; 
		private int arraySize;
		
	
		public Haszowanie_dwukrotne(int size){
			arraySize = size;
			hashArray = new Obiekt[arraySize];
		}
		

		public void dump(){
			System.out.print("Tablica: ");
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					System.out.print(hashArray[j].getKey()+" ");
				else
					System.out.print("* ");
			}
			System.out.println("");
		}
		

		public int hashFunction(int key){
			return key % arraySize; 
		}
		

		public int size(){
			int size = 0;
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					size++;
			}
			return size;
		}
		

		public boolean isEmpty(){
			boolean isEmpty = true;
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					isEmpty = false;
			}
			return isEmpty;
		}
		

		public void resize(){
			Haszowanie_dwukrotne d = new Haszowanie_dwukrotne(2*arraySize);
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					d.put(hashArray[j]);
			}
			hashArray = d.hashArray;
			arraySize = d.hashArray.length;
		}
		

		public int hashFunction2(int key){
			return 1 + key % (arraySize-1);
		}
		

		public void put(Obiekt item){
			if((double)size()/(double)arraySize < 0.75){
			int key = item.getKey(); 
			int hashVal = hashFunction(key); 
			int stepSize = hashFunction2(key); 
		
			while(hashArray[hashVal] != null){
				hashVal += stepSize; 
				hashVal %= arraySize; 
			}
			hashArray[hashVal] = item; 
			}else{
				resize();
				put(item);
			}
		}
		

		public Obiekt get(int key){
			int hashVal = hashFunction(key); 
			int stepSize = hashFunction2(key); 
		
			while(hashArray[hashVal] != null){
				if(hashArray[hashVal].getKey() == key)
					return hashArray[hashVal]; 
				hashVal += stepSize; 
				hashVal %= arraySize; 
			}
			return null; 
		}
		
		

			public boolean containsKey(int key){
				int hashVal = hashFunction(key); 
				int stepSize = hashFunction2(key); 
			
				boolean contains = false;
				while(hashArray[hashVal] != null){
					if(hashArray[hashVal].getKey() == key)
						contains = true; 
					hashVal += stepSize; 
					hashVal %= arraySize; 
				}
				return contains; 
			}
		
		

		public static void main(String[] args){
			Haszowanie_dwukrotne l = new Haszowanie_dwukrotne(13);
			l.dump();
			System.out.println("Czy tablica jest pusta? "+l.isEmpty());
			System.out.println("Dodano 3.");
			l.put(new Obiekt(3));
			l.dump();
			System.out.println("Dodano 5, 2, 1, 3, 7, 20.");
			l.put(new Obiekt(5));
			l.put(new Obiekt(2));
			l.put(new Obiekt(1));
			l.put(new Obiekt(3));
			l.put(new Obiekt(7));
			l.put(new Obiekt(20));
			l.dump();
			System.out.println("Dodano 35, 4, 8, 29, 31, 50, 69.");
			l.put(new Obiekt(35));
			l.put(new Obiekt(4));
			l.put(new Obiekt(8));
			l.put(new Obiekt(29));
			l.put(new Obiekt(31));
			l.put(new Obiekt(50));
			l.put(new Obiekt(69));
			l.dump();
			System.out.println("Czy tablica jest pusta? "+l.isEmpty());
			System.out.println("Czy zawiera coœ o kluczu 9? " + l.containsKey(9)); 
			System.out.println("Czy zawiera coœ o kluczu 1? " + l.containsKey(1)); 
			System.out.println("Get 35? " + l.get(35));
		}

	
}
