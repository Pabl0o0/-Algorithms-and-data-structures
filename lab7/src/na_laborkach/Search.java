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
		
//		liczbaPorownanChybionych++;   //je�li chcemy mie� ilo�� chybionych pr�b a nie por�wna� !
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
	   
//	    liczbaPorownanChybionychB++; //je�li chcemy mie� ilo�� chybionych pr�b a nie por�wna� !
//	    System.out.println("Nie odnaleziono elementu "+szukanaLiczba);
	}
	
	
	
	public static void main(String[] args){
		
		Random generator = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Podaj wielko�� tablicy");
		int n = sc.nextInt();
		
		System.out.println("Podaj  g�rny zakres wielko�ci talibcy");
 		int zakres = sc.nextInt();
 		
 		System.out.println("Podaj liczb� pr�b");
 		int liczbaProb = sc.nextInt();
 		
 		System.out.println("Podaj liczb�, kt�r� chcesz znalez�");
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
			
//			System.out.println("Losuje talic� Integer�w o liczbie element�w = "+ n);		
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
			
//		System.out.println("Pr�ba: " +(i+1));
		lineSearch(tablica, szukanaLiczba);
//		System.out.println("Wyszukiwanie liniowe");
//		System.out.println("Liczba por�wna� dla wyszukiwania liniowego wynios�a "+liczbaPorownan);
//		System.out.println();
		suma+= liczbaPorownan;
		sumaChybionych+=liczbaPorownanChybionych;
		sumaTrafionych+= liczbaPorownanTrafionych;	
				
		binarySearch(tablica, szukanaLiczba);
//		System.out.println("Wyszukiwanie binarne");
//		System.out.println("Liczba por�wna� dla wyszukiwania liniowego wynios�a "+liczbaPorownanB);
//		System.out.println();
		
		sumaB+= liczbaPorownanB;
		sumaChybionychB+= liczbaPorownanChybionychB;
		sumaTrafionychB+= liczbaPorownanTrafionychB;
		}
		
		System.out.println("og�lna ilo�� por�wna� chybionych");
		System.out.println("Wyszukiwanie liniowe: " +sumaChybionych);
		System.out.println("Wyszukiwanie binarne: " +sumaChybionychB);
		System.out.println();
		
		System.out.println("og�lna ilo�� por�wna� trafionych");
		System.out.println("Wyszukiwanie liniowe: " +sumaTrafionych);
		System.out.println("Wyszukiwanie binarne: " +sumaTrafionychB);
		System.out.println();
		
		System.out.println("og�lna ilo�� por�wna�");
		System.out.println("Wyszukiwanie liniowe: " +suma);
		System.out.println("Wyszukiwanie binarne: " +sumaB);
		
		System.out.println();
		System.out.println("�REDNIE");
		System.out.println("�rednia ilo�� por�wna� chybionych na pr�b�: ");
		System.out.println("Wyszukiwanie liniowe: " +((double)sumaChybionych/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaChybionychB/(double)liczbaProb));
		
		System.out.println("�rednia ilo�� por�wna� trafionych: ");  //por�wnanie trafione mo�e by� tylko jedno na pr�b�, wi�c max=1 !!!
		System.out.println("Wyszukiwanie liniowe: " +((double)sumaTrafionych/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaTrafionychB/(double)liczbaProb));
		
		System.out.println("�rednia ilo�� por�wna� na pr�b� dla poszczeg�lnych algorytm�w:");
		System.out.println("Wyszukiwanie liniowe: " +((double)suma/(double)liczbaProb));
		System.out.println("Wyszukiwanie binarne: " +((double)sumaB/(double)liczbaProb));
	}
}
