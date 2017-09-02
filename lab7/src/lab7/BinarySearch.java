package lab7;

import java.util.Random;

public class BinarySearch {
	
	public static void insertSort(Integer[] tab) {		
	    int i, j;
	    Integer newValue=null;
	    for (i = 1; i < tab.length; i++) {
	        newValue = tab[i];
		        j = i;
	        while ((j > 0) && (Comparator.compare(tab[j-1], newValue) > 0)) {
	            tab[j] = tab[j - 1];
	            j--;
	        }
	        tab[j] = newValue;
	    }
	}

	
	
	
	public static Integer[] addInt(Integer [] series, Integer newInt){
	    Integer[] newSeries = new Integer[series.length + 1];    
	    for (int i = 0; i < series.length; i++){
	        newSeries[i] = series[i];
	    }
	   newSeries[newSeries.length - 1] = newInt;
	   
	    return newSeries;
     }
	
	
	
	public static void szukajBinarnie(int szukanaLiczba, Integer[] tab1, Integer[] tab2, Integer[] superTab) 
    {
		insertSort(tab2);
		System.out.println("Posortowana Tablica Pomocnicza");
		for(int i=0;i<tab2.length;i++){
			System.out.print(tab2[i] +" ");
		}
		
		superTab = new Integer[tab1.length+tab2.length]; //dodanie pierwszej tablicy do superTab
		for(int i=0;i<tab1.length;i++){
			superTab[i] = tab1[i];
		}
		
		int n=0;
		for(int i=tab1.length;i<superTab.length;i++){ //dodanie drugiej tablicy do superTab
			superTab[i] = tab2[n];
			n++;
		}
		
		System.out.println();
		insertSort(superTab);
		System.out.println("Posortowana Tablica przed szukaniem binarnym wygl¹da tak:");
		for(int i=0;i<superTab.length;i++){
			System.out.print(superTab[i] +" ");
		}
		
    		
		
        
		int lewo = 0, prawo = superTab.length - 1, srodek = 0;
        boolean czyZnalezione = false;
        
        while(lewo <= prawo) 
        {
            srodek = (lewo + prawo) / 2;
            if(superTab[srodek] == szukanaLiczba) 
            {
                czyZnalezione = true;
                if (srodek == 0) break; 
                if (superTab[srodek - 1] == szukanaLiczba)
                    prawo = srodek - 1;
                else
                    break; 
            } 
            else if(superTab[srodek] < szukanaLiczba)
                lewo = srodek + 1; 
            else 
                prawo = srodek - 1;
        }
        
        int pierwszaLiczba = 0;
        
        if(czyZnalezione) 
        	pierwszaLiczba = srodek;
        
        
        lewo = 0; prawo = superTab.length - 1; srodek = 0; czyZnalezione = false;
        
        
        while(lewo <= prawo) {
      
            srodek = (lewo + prawo) / 2;
            
            if(superTab[srodek] == szukanaLiczba) 
            {
                czyZnalezione = true;
                if(srodek == superTab.length - 1) break; 
                if(superTab[srodek + 1] == szukanaLiczba) 
                    lewo = srodek + 1;
                else 
                    break; 
            } 
            else 
                if(superTab[srodek] < szukanaLiczba) 
                    lewo = srodek + 1;
                else 
                    prawo = srodek - 1;
        }
        
        int ostatniaLiczba = 0;
        if(czyZnalezione) 
        	ostatniaLiczba = srodek;
        System.out.println();    
        if(czyZnalezione)
            System.out.println("Szukana liczba powtarza siê: " + (ostatniaLiczba - pierwszaLiczba + 1) + " raz(y). A jej indeks to: "+pierwszaLiczba+ " do "+ostatniaLiczba); 
        else
            System.out.println("Szukana liczba nie zosta³a odnaleziona.");
    }
	
	
	
	public static void main(String[] args){
		Random generator = new Random();
		int n = 8; 
		Integer[] tablica = new Integer[n];
/*		tablica[0] = 3; //  test dla sztywnej tablicy
		tablica[1] = 3;
		tablica[2] = 0;
		tablica[3] = 1;
*/		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n);		
		for(int i=0;i<tablica.length;i++){
			tablica[i]=generator.nextInt(n);
			System.out.print(tablica[i] +" ");
		}
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab[i] = tablica[i];
		}
		insertSort(coppiedTab);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab.length;i++){
			System.out.print(coppiedTab[i] +" ");
		}
		System.out.println();
		System.out.println();
		
		
		
		
		System.out.println("Tablica pomocnicza");
		Integer[] series = new Integer[0];
	    series = addInt(series, 555);
	    series = addInt(series, 4233);
	    series = addInt(series, 34);
	    series = addInt(series, 3654745);
	    series = addInt(series, 23);
	    series = addInt(series, 1);
	    for (int i = 0; i < series.length; i++){
	          System.out.println(series[i]);	      
	    }
	    System.out.println();
	    
	    Integer[] superTab = null;
		int szukanaLiczba = 1;
		szukajBinarnie(szukanaLiczba, tablica, series, superTab);
	    
	}
}
