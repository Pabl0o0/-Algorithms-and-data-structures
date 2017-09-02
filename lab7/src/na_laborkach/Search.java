package na_laborkach;

import java.util.Random;
import java.util.Scanner;

import lab7.Comparator;

public class Search {

	private static Integer[] numbers;
    private static int[] helper;
    private static int number;
    public static void mergeSort(Integer[] tablica) {
            numbers = tablica;
            number = tablica.length;
            helper = new int[number];
            mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {
            if (low < high) {                    
                    int middle = low + (high - low) / 2;                  
                    mergesort(low, middle);                   
                    mergesort(middle + 1, high);                  
                    merge(low, middle, high);
            }
    }

    private static void merge(int low, int middle, int high) {

            
            for (int i = low; i <= high; i++) {
                    helper[i] = numbers[i];
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            while (i <= middle && j <= high) {
                    if (helper[i] <= helper[j]) {
                            numbers[k] = helper[i];
                            i++;
                    } else {
                            numbers[k] = helper[j];
                            j++;
                    }
                    k++;
            }            
            while (i <= middle) {
                    numbers[k] = helper[i];
                    k++;
                    i++;
            }
    }	

	static int liczbaPorownan=0;
	static int liczbaPorownanChybionych=0;
	static int liczbaPorownanTrafionych=0;
	public static void lineSearch(Integer[] tab, int szukanaLiczba){
		liczbaPorownan=0;
		liczbaPorownanChybionych=0;
		liczbaPorownanTrafionych=0;
		for(int i =0; i<tab.length; i++){
			liczbaPorownan++;
			if (szukanaLiczba == tab[i]){
				liczbaPorownanTrafionych++;
//				System.out.println("Odnaleziono element "+szukanaLiczba+" pod indeksem "+i);
				return;
			} else liczbaPorownanChybionych++;						
		}
		
//		liczbaPorownanChybionych++;   //jeœli chcemy mieæ iloœæ chybionych prób a nie porównañ !
//		System.out.println("Nie odnaleziono elementu "+szukanaLiczba);
	}
	
	
	
	
	static int liczbaPorownanB=0;
	static int liczbaPorownanChybionychB=0;
	static int liczbaPorownanTrafionychB=0;
	public static void binarySearch(Integer[] tab, int szukanaLiczba){
	
		liczbaPorownanB=0;	
		liczbaPorownanChybionychB=0;
		liczbaPorownanTrafionychB=0;
	    int lewo = 0, prawo = tab.length - 1, srodek = 0;
	    
	    while(lewo <= prawo)
	    {
	    	liczbaPorownanB++;
	        srodek = (lewo + prawo) / 2;
	        if(tab[srodek] == szukanaLiczba){
	        	liczbaPorownanTrafionychB++;
//	        	System.out.println("Odnaleziono element "+szukanaLiczba+" pod indeksem "+srodek);
	            return;
	        } 
	       else {
	    	   liczbaPorownanChybionychB++;
	    	   if(tab[srodek] < szukanaLiczba)
	       
	            lewo = srodek + 1;
	        	else
	            prawo = srodek - 1;
	    }
	    }
	   
//	    liczbaPorownanChybionychB++; //jeœli chcemy mieæ iloœæ chybionych prób a nie porównañ !
//	    System.out.println("Nie odnaleziono elementu "+szukanaLiczba);
	}
	
	
	
	public static void main(String[] args){
		
		Random generator = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Podaj wielkoœæ tablicy");
		int n = sc.nextInt();
		
		System.out.println("Podaj  górny zakres wielkoœci talibcy");
 		int zakres = sc.nextInt();
 		
 		System.out.println("Podaj liczbê prób");
 		int liczbaProb = sc.nextInt();
 		
 		System.out.println("Podaj liczbê, któr¹ chcesz znalezæ");
 		int szukanaLiczba = sc.nextInt();
 		
 		
 		sc.close();
		Integer[] tablica = new Integer[n]; 
		
		
		
		int suma=0;
		int sumaB=0;
		int sumaChybionych = 0;
		int sumaChybionychB = 0;
		int sumaTrafionych = 0;
		int sumaTrafionychB = 0;
		
		for(int i=0; i<liczbaProb;i++){
			
//			System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n);		
			for(int j=0;j<tablica.length;j++){
				tablica[j]=generator.nextInt(zakres); 
//				System.out.print(tablica[j] +" ");
			}
//			System.out.println("");
//			System.out.println("------------------------");
			

			mergeSort(tablica);
/*			System.out.println("Posortowana MergeSortem");
			for(int j=0;j<tablica.length;j++){
				System.out.print(tablica[j] +" ");
			}
			System.out.println();
			System.out.println();
*/			
			
//		System.out.println("Próba: " +(i+1));
		lineSearch(tablica, szukanaLiczba);
//		System.out.println("Wyszukiwanie liniowe");
//		System.out.println("Liczba porównañ dla wyszukiwania liniowego wynios³a "+liczbaPorownan);
//		System.out.println();
		suma+= liczbaPorownan;
		sumaChybionych+=liczbaPorownanChybionych;
		sumaTrafionych+= liczbaPorownanTrafionych;	
				
		binarySearch(tablica, szukanaLiczba);
//		System.out.println("Wyszukiwanie binarne");
//		System.out.println("Liczba porównañ dla wyszukiwania liniowego wynios³a "+liczbaPorownanB);
//		System.out.println();
		
		sumaB+= liczbaPorownanB;
		sumaChybionychB+= liczbaPorownanChybionychB;
		sumaTrafionychB+= liczbaPorownanTrafionychB;
		}
		
		System.out.println("ogólna iloœæ porównañ chybionych");
		System.out.println("Wyszukiwanie liniowe: " +sumaChybionych);
		System.out.println("Wyszukiwanie binarne: " +sumaChybionychB);
		System.out.println();
		
		System.out.println("ogólna iloœæ porównañ trafionych");
		System.out.println("Wyszukiwanie liniowe: " +sumaTrafionych);
		System.out.println("Wyszukiwanie binarne: " +sumaTrafionychB);
		System.out.println();
		
		System.out.println("ogólna iloœæ porównañ");
		System.out.println("Wyszukiwanie liniowe: " +suma);
		System.out.println("Wyszukiwanie binarne: " +sumaB);
		
		System.out.println();
		System.out.println("ŒREDNIE");
		System.out.println("œrednia iloœæ porównañ chybionych na próbê: ");
		System.out.println("Wyszukiwanie liniowe: " +((double)sumaChybionych/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaChybionychB/(double)liczbaProb));
		
		System.out.println("œrednia iloœæ porównañ trafionych: ");  //porównanie trafione mo¿e byæ tylko jedno na próbê, wiêc max=1 !!!
		System.out.println("Wyszukiwanie liniowe: " +((double)sumaTrafionych/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaTrafionychB/(double)liczbaProb));
		
		System.out.println("œrednia iloœæ porównañ na próbê dla poszczególnych algorytmów:");
		System.out.println("Wyszukiwanie liniowe: " +((double)suma/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaB/(double)liczbaProb));
	}
}
