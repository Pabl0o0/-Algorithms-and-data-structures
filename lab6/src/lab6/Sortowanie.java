package lab6;

public class Sortowanie implements Comparator, Comparator2 {

	//poprawna metoda InsertSort ;)
	/*
	  public static void insertionSortZ(Osoba[] arr) {
    int i, j;
    Osoba newValue;
    for (i = 1; i < arr.length; i++) {
        newValue = arr[i];
        j = i;
        while ((j > 0) && (ComparatorZ.compare(arr[j-1], newValue) > 0)) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = newValue;
    }
}
	 */
	
	
	
	public static Osoba[] InsertSort(Osoba[] tablica){
		for (int i = 0;i<tablica.length-1;i++){
			for(int j = i; j>=0;j--){
				if(Comparator.compare(tablica[j], tablica[j+1])>0){
					Osoba tmp = tablica[j];
					tablica[j] = tablica[j+1];
					tablica[j+1] = tmp;
				}
			}
			
		}
		return tablica;
	}
	
	public static Osoba[] InsertSort2(Osoba[] tablica2){
		for (int i = 0;i<tablica2.length-1;i++){
			for(int j = i; j>=0;j--){
				if(Comparator2.compare2(tablica2[j], tablica2[j+1])>0){
					Osoba tmp = tablica2[j];
					tablica2[j] = tablica2[j+1];
					tablica2[j+1] = tmp;
				}
			}			
		}
		return tablica2;
	}
	
	static CompoundComparator cc = new CompoundComparator();
	public static Osoba[] InsertSort3(Osoba[] tablica3){
		for (int i = 0;i<tablica3.length-1;i++){		
				if(cc.compare(tablica3[i], tablica3[i+1])>0){
					Osoba tmp = tablica3[i];
					tablica3[i] = tablica3[i+1];
					tablica3[i+1] = tmp;
				}
		}
		return tablica3;
	}
	
	
	
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Osoba osoba0 = new Osoba("Kowalski", "Jan", 20);
        Osoba osoba1 = new Osoba("Kowal", "Basia", 25);
        Osoba osoba2 = new Osoba("èrÛd≥o", "Maciej", 18);
        Osoba osoba3 = new Osoba("Wysoka", "Marta", 38);
        Osoba osoba4 = new Osoba("Konarek", "Dorota", 55);
        Osoba osoba5 = new Osoba("Nowy", "Bart≥omiej", 62);
        Osoba osoba6 = new Osoba("Nawyk", "Bart≥omiej", 41);
        
        int size = 7;
		Osoba[] tablica = new Osoba[size];
        tablica[0] = osoba0;
        tablica[1] = osoba1;
        tablica[2] = osoba2;
        tablica[3] = osoba3;
        tablica[4] = osoba4;
        tablica[5] = osoba5;
        tablica[6] = osoba6;
        
        Osoba[] tablica2 = new Osoba[size];
        tablica2[0] = osoba0;
        tablica2[1] = osoba1;
        tablica2[2] = osoba2;
        tablica2[3] = osoba3;
        tablica2[4] = osoba4;
        tablica2[5] = osoba5;
        tablica2[6] = osoba6;
        
        Osoba[] tablica3 = new Osoba[size];
        tablica3[0] = osoba0;
        tablica3[1] = osoba1;
        tablica3[2] = osoba2;
        tablica3[3] = osoba3;
        tablica3[4] = osoba4;
        tablica3[5] = osoba5;
        tablica3[6] = osoba6;
        
        System.out.println("Tablica w kolejnoúci wpisania");
        for(int i = 0;i<tablica.length;i++){
        	System.out.println(tablica[i]);
        }
        
        System.out.println();
        System.out.println("Tablica po sortowaniu imionami");
        Osoba[] tab=InsertSort(tablica);
        for(int i=0; i<tab.length;i++){
        System.out.println(tab[i]);
        }
        
        System.out.println();
        System.out.println("Tablica po sortowaniu metodπ z≥oøonπ compare");
        Osoba[] tab2=InsertSort2(tablica2);
        for(int i=0; i<tab2.length;i++){
        System.out.println(tab2[i]);
        }
        
        System.out.println();
        System.out.println("Tablica po sortowaniu tablicπ komparatorÛw");
        Osoba[] tab3=InsertSort2(tablica3);
        for(int i=0; i<tab3.length;i++){
        System.out.println(tab3[i]);
        }
	}

}
