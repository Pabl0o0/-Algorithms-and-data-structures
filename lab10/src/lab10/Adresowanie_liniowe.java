package lab10;

public class Adresowanie_liniowe {

		private Obiekt[] hashArray; 
		private int arraySize;
		
		
		public Adresowanie_liniowe(int size){
			arraySize = size;
			hashArray = new Obiekt[arraySize];
		}
		

		public void dump(){
			System.out.print("Tablica: ");
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					System.out.print(hashArray[j].getKey()+" ");
				else
					System.out.print("$ ");
			}
			System.out.println("");
		}
		


		public int hashFunction(int key){
			return key % arraySize; 
		}
		

		public void put(Obiekt obiekt){
			if((double)size()/(double)arraySize < 0.75){
			int key = obiekt.getKey(); 
			int hashVal = hashFunction(key); 
			
			while(hashArray[hashVal] != null){
				++hashVal; 
				hashVal %= arraySize; 
			}
			hashArray[hashVal] = obiekt; 
			}else{
				resize();
				put(obiekt);
			}
		}
		
	/*	
		public void put(DataItem item, int index){
			if((double)size()/(double)arraySize < 0.75){
			int key = item.getKey(); //pobierz klucz
			int hashVal = index; //oblicz wartoœæ indeksu dla klucza
			//powtarzaj do pustej komórki 
			while(hashArray[hashVal] != null){
				++hashVal; //przejdz do nastêpnej komórki
				hashVal %= arraySize; //jeœli trzeba przejdz na pocz¹tek tablicy
			}
			hashArray[hashVal] = item; //wstaw element
			}else{
				resize();
				put(item,index);
			}
		}
	*/	
		

		public Obiekt get(int key){
			int hashVal = hashFunction(key); 
			
			while(hashArray[hashVal] != null){
				if(hashArray[hashVal].getKey() == key)
					return hashArray[hashVal]; 
				++hashVal; 
				hashVal %= arraySize; 
			}
			return null; 
		}
		

		public boolean containsKey(int key){
			int hashVal = hashFunction(key);
						
			while(hashArray[hashVal] != null){
				if(hashArray[hashVal].getKey() == key)
					return true; 
				++hashVal; 
				hashVal %= arraySize; 
			}
			return false; 
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
				if(hashArray[j] != null){
					isEmpty = false;
					return isEmpty;
				}
			}
			return isEmpty;
		}
		

		public void resize(){
			Adresowanie_liniowe l = new Adresowanie_liniowe(2*arraySize);
			for(int j=0; j<arraySize; j++){
				if(hashArray[j] != null)
					l.put(hashArray[j]);
			}
			hashArray = l.hashArray;
			arraySize = l.hashArray.length;
		}
		
	//---------------------------------------------------------------------------------------------------------------
		public static void main(String[] args){
			Adresowanie_liniowe l = new Adresowanie_liniowe(13);
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

