package homework;

import java.util.Random;

public class homework extends Comparator {

	static int licznikPrzestawien = 0;

	//metody wolne
	//insertSort
	public static void insertSort(Integer[] tab) {		
	    int i, j;
	    Integer newValue=null;
	    for (i = 1; i < tab.length; i++) {
	        newValue = tab[i];
		        j = i;
	        while ((j > 0) && (Comparator.compare(tab[j-1], newValue) > 0)) {
	            tab[j] = tab[j - 1];
	            j--;
	            licznikPrzestawien++;
	        }
	        tab[j] = newValue;
	    }
	}
	
	//BubbleSort
	public static void BubbleSort(Integer[] tab){
		for (int i = 0;i<tab.length;i++){
			for(int j = 0; j<tab.length-i-1;j++){
				if(Comparator.compare(tab[j], tab[j+1])>0){
					Integer tmp = tab[j];
					tab[j] = tab[j+1];
					tab[j+1] = tmp;
					licznikPrzestawien++;
				}
			}
		}
	}
	
	//SelectSort  
	public static Integer[] SelectSort(Integer[] tab){
		int size = tab.length;
		for(int slot = 0; slot < size - 1; ++slot){
			int smallest = slot;
			for(int check = slot + 1; check<size;++check)
				if(Comparator.compare(tab[check], tab[smallest]) < 0){
					smallest = check;
				}
			swap(tab, smallest, slot);				
			}
		return tab;
		}
	
	
	//metody szybkie
	//Shellsort
	public static void ShellSort(Integer[] tab){
	    int inner , outer , temp;
	    int interval = 1;
	    while(interval <tab.length/3){
	        interval = interval*3+1;
	    }
	    while(interval > 0){
	        for(outer = interval; outer<tab.length; outer++){
	            inner = outer;
	            temp = tab[inner];
	            while(inner > interval-1 && Comparator.compare(tab[inner-interval],temp) >= 0){
	                tab[inner] = tab[inner-interval];
	                inner = inner - interval;
	                licznikPrzestawien++;
	            }
	                tab[inner] = temp;
	        }
	            interval = (interval-1)/3;
	    }       
	}
	
	//QuickSort
	public static void QuickSort(Integer[] tab, int startIndex, int endIndex){
		if(endIndex > startIndex){
			Integer value = tab[endIndex];
			int partition = partition(tab, value, startIndex, endIndex-1);
			if (Comparator.compare(tab[partition],value) < 0){
				++partition;
			}
				swap(tab,partition,endIndex);
				QuickSort(tab, startIndex, partition -1);
				QuickSort(tab, partition +1, endIndex);				
			}
	}
	private static int partition(Integer[] tab, Integer value, int leftIndex, int rightIndex){
		int left = leftIndex;
		int right = rightIndex;
		while(left<right){
			if (Comparator.compare(tab[left],value) < 0){
				++left;
				continue;
			}
			if (Comparator.compare(tab[right],value) >= 0){
				--right;
				continue;
			}
		swap(tab,left,right);
		++left;
		}
		return left;
	}	
	private static void swap(Integer[] tab, int left, int right){
		if(left != right){
			licznikPrzestawien++;
			Integer tmp = tab[left];
			tab[left] = tab[right];
			tab[right] = tmp;
		}
	}

	/*
	//MergeSort
	public static Integer[] MergeSort(Integer[] tab){
		return mergesort(tab, 0, tab.length-1);
	}
	private static Integer[] mergesort(Integer[]tab, int startIndex, int endIndex){
		if(startIndex == endIndex){
			Integer[] result = null;
			addInt(result, tab[startIndex]);			
		}
		int splitIndex = startIndex + (endIndex - startIndex) /2;
		return merge(mergesort(tab, startIndex, splitIndex),
					mergesort(tab, splitIndex+1, endIndex));
	}
	
	private static Integer[] addInt(Integer [] series, Integer newInt){
	    Integer[] newSeries = new Integer[series.length + 1];    
	    for (int i = 0; i < series.length; i++){
	        newSeries[i] = series[i];
	    }
	   newSeries[newSeries.length - 1] = newInt;	   
	    return newSeries;
     }
	
	private static Integer[] merge(Integer[] left, Integer[] right){
		Integer[] result = null;
		for(int i =0; i<left.length;i++){
			for(int j=0; j<right.length; j++){
				if(Comparator.compare(left[i],right[j]) <= 0){
					licznikPrzestawien++;
					addInt(result, left[i+1]);
				}
				else {
					licznikPrzestawien++;
					addInt(result, right[j+1]);
				}
			}
		}
		for(int i =0; i<left.length;i++){
			return addInt(result, left[i+1]);
		}
		for(int j=0; j<right.length; j++){
			return addInt(result, right[j+1]);
		}
		return result;
	}
	
	*/
	/*
	static Integer[] numbers;
    static int[] helper;
    static int porownania=0;
    static int podstawienia=0;
    static int number;
    
    private static void MergeSort(Integer[] tab) {
        numbers = tab;
        number = tab.length;
        helper = new int[number];
        sort(0, number - 1);
    }
    
	public static void sort(int low, int high) {
	    	        // check if low is smaller than high, if not then the array is sorted
	        if (low < high) {
	            // Get the index of the element which is in the middle
	            int middle = low + (high - low) / 2;
	            // Sort the left side of the array
	            sort(low, middle);
	            // Sort the right side of the array
	            sort(middle + 1, high);
	            // Combine them both
	            merge(low, middle, high);
	        }
	}
    
	private static void merge(int low, int middle, int high) {

	        // Copy both parts into the helper array
	        for (int i = low; i <= high; i++) {
	            helper[i] = numbers[i];
	        }

	        int i = low;
	        int j = middle + 1;
	        int k = low;
	        // Copy the smallest values from either the left or the right side back
	        // to the original array
	        while (i <= middle && j <= high) {
	            porownania++;
	            if (helper[i] <= helper[j]) {
	                podstawienia++;
	                numbers[k] = helper[i];
	                i++;
	            } else {
	                podstawienia++;
	                numbers[k] = helper[j];
	                j++;
	            }
	            k++;
	        }
	        // Copy the rest of the left side of the array into the target array
	        while (i <= middle) {
	            podstawienia++;
	            numbers[k] = helper[i];
	            k++;
	            i++;
	        }

	    }
	*/

	// INSERT DO ODWROTNEJ
	public static void insertSort1(Integer[] tab) {		
	    int i, j;
	    Integer newValue=null;
	    for (i = 1; i < tab.length; i++) {
	        newValue = tab[i];
		        j = i;
	        while ((j > 0) && (ReversedComparator.compare(tab[j-1], newValue) > 0)) {
	            tab[j] = tab[j - 1];
	            j--;
	            licznikPrzestawien++;
	        }
	        tab[j] = newValue;
	    }
	}
		
	
	public static void main(String[] args){
		/*
		 * dla losowej tablicy
		 */
		Random generator = new Random();
		int n = 8; // 8 ELEMENTÓW
		Integer[] tablica = new Integer[n];
/*		tablica[0] = 3; //  test dla sztywnej tablicy
		tablica[1] = 3;
		tablica[2] = 0;
		tablica[3] = 1;
*/		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n);		
		for(int i=0;i<tablica.length;i++){
			tablica[i]=generator.nextInt(100);
			System.out.print(tablica[i] +" ");
		}		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab[i] = tablica[i];
		}
		homework.insertSort(coppiedTab);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab.length;i++){
			System.out.print(coppiedTab[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Insert8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Insert8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab2 = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab2[i] = tablica[i];
		}
		homework.BubbleSort(coppiedTab2);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTab2.length;i++){
			System.out.print(coppiedTab2[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Bubble8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Bubble8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab3 = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab3[i] = tablica[i];
		}
		homework.ShellSort(coppiedTab3);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTab3.length;i++){
			System.out.print(coppiedTab3[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Shell8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Shell8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab4 = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab4[i] = tablica[i];
		}
		homework.QuickSort(coppiedTab4, 0, coppiedTab4.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTab4.length;i++){
			System.out.print(coppiedTab4[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Quick8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Quick8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab5 = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTab5[i] = tablica[i];
		}
		homework.SelectSort(coppiedTab5);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTab5.length;i++){
			System.out.print(coppiedTab5[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Select8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Select8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
				
		int n1 = 64; // 64 ELEMENTY
		Integer[] tablica1 = new Integer[n1];
		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n1);		
		for(int i=0;i<tablica1.length;i++){
			tablica1[i]=generator.nextInt(5000);
			System.out.print(tablica1[i] +" ");
		}		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab11 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTab11[i] = tablica1[i];
		}
		homework.insertSort(coppiedTab11);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab11.length;i++){
			System.out.print(coppiedTab11[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Insert64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Insert64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab211 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTab211[i] = tablica1[i];
		}
		homework.BubbleSort(coppiedTab211);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTab211.length;i++){
			System.out.print(coppiedTab211[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Bubble64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Bubble64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab311 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTab311[i] = tablica1[i];
		}
		homework.ShellSort(coppiedTab311);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTab311.length;i++){
			System.out.print(coppiedTab311[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Shell64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Shell64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab411 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTab411[i] = tablica1[i];
		}
		homework.QuickSort(coppiedTab411, 0, coppiedTab411.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTab411.length;i++){
			System.out.print(coppiedTab411[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Quick64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Quick64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab511 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTab511[i] = tablica1[i];
		}
		homework.SelectSort(coppiedTab511);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTab511.length;i++){
			System.out.print(coppiedTab511[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Select64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Select64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		
		
		int n2 = 128; // 128 ELEMENTÓW
		Integer[] tablica2 = new Integer[n2];
		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n2);		
		for(int i=0;i<tablica2.length;i++){
			tablica2[i]=generator.nextInt(n2);
			System.out.print(tablica2[i] +" ");
		}		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab22 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTab22[i] = tablica2[i];
		}
		homework.insertSort(coppiedTab22);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab22.length;i++){
			System.out.print(coppiedTab22[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Insert128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Insert128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab222 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTab222[i] = tablica2[i];
		}
		homework.BubbleSort(coppiedTab222);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTab222.length;i++){
			System.out.print(coppiedTab222[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Bubble128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Bubble128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab322 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTab322[i] = tablica2[i];
		}
		homework.ShellSort(coppiedTab322);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTab322.length;i++){
			System.out.print(coppiedTab322[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Shell128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Shell128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab422 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTab422[i] = tablica2[i];
		}
		homework.QuickSort(coppiedTab422, 0, coppiedTab422.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTab422.length;i++){
			System.out.print(coppiedTab422[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Quick128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Quick128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab522 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTab522[i] = tablica2[i];
		}
		homework.SelectSort(coppiedTab522);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTab522.length;i++){
			System.out.print(coppiedTab522[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Select128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Select128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		
		int n3 = 512; // 512 ELEMENTÓW
		Integer[] tablica3 = new Integer[n3];
		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n3);		
		for(int i=0;i<tablica3.length;i++){
			tablica3[i]=generator.nextInt(n3);
			System.out.print(tablica3[i] +" ");
		}		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab33 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTab33[i] = tablica3[i];
		}
		homework.insertSort(coppiedTab33);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab33.length;i++){
			System.out.print(coppiedTab33[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Insert512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Insert512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab233 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTab233[i] = tablica3[i];
		}
		homework.BubbleSort(coppiedTab233);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTab233.length;i++){
			System.out.print(coppiedTab233[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Bubble512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Bubble512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab333 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTab333[i] = tablica3[i];
		}
		homework.ShellSort(coppiedTab333);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTab333.length;i++){
			System.out.print(coppiedTab333[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Shell512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Shell512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab433 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTab433[i] = tablica3[i];
		}
		homework.QuickSort(coppiedTab433, 0, coppiedTab433.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTab433.length;i++){
			System.out.print(coppiedTab433[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Quick512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Quick512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab533 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTab533[i] = tablica3[i];
		}
		homework.SelectSort(coppiedTab533);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTab533.length;i++){
			System.out.print(coppiedTab533[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Select512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Select512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		
		int n4 = 1024; // 1024 ELEMENTÓW
		Integer[] tablica4 = new Integer[n4];
		System.out.println("Losuje talicê Integerów o liczbie elementów = "+ n4);		
		for(int i=0;i<tablica4.length;i++){
			tablica4[i]=generator.nextInt(n4);
			System.out.print(tablica4[i] +" ");
		}		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTab44 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTab44[i] = tablica4[i];
		}
		homework.insertSort(coppiedTab44);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTab44.length;i++){
			System.out.print(coppiedTab44[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Insert1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Insert1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab244 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTab244[i] = tablica4[i];
		}
		homework.BubbleSort(coppiedTab244);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTab244.length;i++){
			System.out.print(coppiedTab244[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Bubble1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Bubble1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab344 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTab344[i] = tablica4[i];
		}
		homework.ShellSort(coppiedTab344);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTab344.length;i++){
			System.out.print(coppiedTab344[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Shell1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Shell1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab444 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTab444[i] = tablica4[i];
		}
		homework.QuickSort(coppiedTab444, 0, coppiedTab444.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTab444.length;i++){
			System.out.print(coppiedTab444[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Quick1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Quick1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTab544 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTab544[i] = tablica4[i];
		}
		homework.SelectSort(coppiedTab544);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTab544.length;i++){
			System.out.print(coppiedTab544[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer Select1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer Select1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		//ODWROTNIE UPORZ¥DKOWANA
		 // 8 ELEMENTÓW
		Integer[] coppiedTabReversed = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTabReversed[i] = tablica[i];
		}
		homework.insertSort1(coppiedTabReversed);
		System.out.println("ODWRACAM WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabReversed.length;i++){
			System.out.print(coppiedTabReversed[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabR = new Integer[n];
		for(int i=0;i<coppiedTabReversed.length;i++){
			coppiedTabR[i] = coppiedTabReversed[i];
		}
		homework.insertSort(coppiedTabR);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabR.length;i++){
			System.out.print(coppiedTabR[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertR8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertR8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR2 = new Integer[n];
		for(int i=0;i<coppiedTabReversed.length;i++){
			coppiedTabR2[i] = coppiedTabReversed[i];
		}
		homework.BubbleSort(coppiedTabR2);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabR2.length;i++){
			System.out.print(coppiedTabR2[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleR8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleR8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR3 = new Integer[n];
		for(int i=0;i<coppiedTabReversed.length;i++){
			coppiedTabR3[i] = coppiedTabReversed[i];
		}
		homework.ShellSort(coppiedTabR3);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabR3.length;i++){
			System.out.print(coppiedTabR3[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellR8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellR8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR4 = new Integer[n];
		for(int i=0;i<coppiedTabReversed.length;i++){
			coppiedTabR4[i] = coppiedTabReversed[i];
		}
		homework.QuickSort(coppiedTabR4, 0, coppiedTabR4.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabR4.length;i++){
			System.out.print(coppiedTabR4[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickR8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickR8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR5 = new Integer[n];
		for(int i=0;i<coppiedTabReversed.length;i++){
			coppiedTabR5[i] = coppiedTabReversed[i];
		}
		homework.SelectSort(coppiedTabR5);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabR5.length;i++){
			System.out.print(coppiedTabR5[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectR8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectR8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
			
		
		// 64 ELEMENTY
		Integer[] coppiedTabReversed1 = new Integer[n1];
		for(int i=0;i<tablica1.length;i++){
			coppiedTabReversed1[i] = tablica1[i];
		}
		homework.insertSort1(coppiedTabReversed1);
		System.out.println("ODWRACAM WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabReversed1.length;i++){
			System.out.print(coppiedTabReversed1[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabR11 = new Integer[n1];
		for(int i=0;i<coppiedTabReversed1.length;i++){
			coppiedTabR11[i] = coppiedTabReversed1[i];
		}
		homework.insertSort(coppiedTabR11);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabR11.length;i++){
			System.out.print(coppiedTabR11[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertR64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertR64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR211 = new Integer[n1];
		for(int i=0;i<coppiedTabReversed1.length;i++){
			coppiedTabR211[i] = coppiedTabReversed1[i];
		}
		homework.BubbleSort(coppiedTabR211);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabR211.length;i++){
			System.out.print(coppiedTabR211[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleR64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleR64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR311 = new Integer[n1];
		for(int i=0;i<coppiedTabReversed1.length;i++){
			coppiedTabR311[i] = coppiedTabReversed1[i];
		}
		homework.ShellSort(coppiedTabR311);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabR311.length;i++){
			System.out.print(coppiedTabR311[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellR64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellR64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR411 = new Integer[n1];
		for(int i=0;i<coppiedTabReversed1.length;i++){
			coppiedTabR411[i] = coppiedTabReversed1[i];
		}
		homework.QuickSort(coppiedTabR411, 0, coppiedTabR411.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabR411.length;i++){
			System.out.print(coppiedTabR411[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickR64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickR64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR511 = new Integer[n1];
		for(int i=0;i<coppiedTabReversed1.length;i++){
			coppiedTabR511[i] = coppiedTabReversed1[i];
		}
		homework.SelectSort(coppiedTabR511);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabR511.length;i++){
			System.out.print(coppiedTabR511[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectR64prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectR64por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		// 128 ELEMENTÓW		
		Integer[] coppiedTabReversed2 = new Integer[n2];
		for(int i=0;i<tablica2.length;i++){
			coppiedTabReversed2[i] = tablica2[i];
		}
		homework.insertSort1(coppiedTabReversed2);
		System.out.println("ODWRACAM WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabReversed2.length;i++){
			System.out.print(coppiedTabReversed2[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabR22 = new Integer[n2];
		for(int i=0;i<coppiedTabReversed2.length;i++){
			coppiedTabR22[i] = coppiedTabReversed2[i];
		}
		homework.insertSort(coppiedTabR22);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabR22.length;i++){
			System.out.print(coppiedTabR22[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertR128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertR128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR222 = new Integer[n2];
		for(int i=0;i<coppiedTabReversed2.length;i++){
			coppiedTabR222[i] = coppiedTabReversed2[i];
		}
		homework.BubbleSort(coppiedTabR222);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabR222.length;i++){
			System.out.print(coppiedTabR222[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleR128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleR128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR322 = new Integer[n2];
		for(int i=0;i<coppiedTabReversed2.length;i++){
			coppiedTabR322[i] = coppiedTabReversed2[i];
		}
		homework.ShellSort(coppiedTabR322);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabR322.length;i++){
			System.out.print(coppiedTabR322[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellR128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellR128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR422 = new Integer[n2];
		for(int i=0;i<coppiedTabReversed2.length;i++){
			coppiedTabR422[i] = coppiedTabReversed2[i];
		}
		homework.QuickSort(coppiedTabR422, 0, coppiedTabR422.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabR422.length;i++){
			System.out.print(coppiedTabR422[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickR128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickR128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR522 = new Integer[n2];
		for(int i=0;i<coppiedTabReversed2.length;i++){
			coppiedTabR522[i] = coppiedTabReversed2[i];
		}
		homework.SelectSort(coppiedTabR522);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabR522.length;i++){
			System.out.print(coppiedTabR522[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectR128prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectR128por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		// 512 ELEMENTÓW
		Integer[] coppiedTabReversed3 = new Integer[n3];
		for(int i=0;i<tablica3.length;i++){
			coppiedTabReversed3[i] = tablica3[i];
		}
		homework.insertSort1(coppiedTabReversed3);
		System.out.println("ODWRACAM WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabReversed3.length;i++){
			System.out.print(coppiedTabReversed3[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabR33 = new Integer[n3];
		for(int i=0;i<coppiedTabReversed3.length;i++){
			coppiedTabR33[i] = coppiedTabReversed3[i];
		}
		homework.insertSort(coppiedTabR33);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabR33.length;i++){
			System.out.print(coppiedTabR33[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertR512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertR512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR233 = new Integer[n3];
		for(int i=0;i<coppiedTabReversed3.length;i++){
			coppiedTabR233[i] = coppiedTabReversed3[i];
		}
		homework.BubbleSort(coppiedTabR233);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabR233.length;i++){
			System.out.print(coppiedTabR233[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleR512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleR512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR333 = new Integer[n3];
		for(int i=0;i<coppiedTabReversed3.length;i++){
			coppiedTabR333[i] = coppiedTabReversed3[i];
		}
		homework.ShellSort(coppiedTabR333);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabR333.length;i++){
			System.out.print(coppiedTabR333[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellR512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellR512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR433 = new Integer[n3];
		for(int i=0;i<coppiedTabReversed3.length;i++){
			coppiedTabR433[i] = coppiedTabReversed3[i];
		}
		homework.QuickSort(coppiedTabR433, 0, coppiedTabR433.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabR433.length;i++){
			System.out.print(coppiedTabR433[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickR512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickR512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR533 = new Integer[n3];
		for(int i=0;i<coppiedTabReversed3.length;i++){
			coppiedTabR533[i] = coppiedTabReversed3[i];
		}
		homework.SelectSort(coppiedTabR533);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabR533.length;i++){
			System.out.print(coppiedTabR533[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectR512prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectR512por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		
		// 1024 ELEMENTÓW
		Integer[] coppiedTabReversed4 = new Integer[n4];
		for(int i=0;i<tablica4.length;i++){
			coppiedTabReversed4[i] = tablica4[i];
		}
		homework.insertSort1(coppiedTabReversed4);
		System.out.println("ODWRACAM WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabReversed4.length;i++){
			System.out.print(coppiedTabReversed4[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabR44 = new Integer[n4];
		for(int i=0;i<coppiedTabReversed4.length;i++){
			coppiedTabR44[i] = coppiedTabReversed4[i];
		}
		homework.insertSort(coppiedTabR44);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabR44.length;i++){
			System.out.print(coppiedTabR44[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertR1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertR1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR244 = new Integer[n4];
		for(int i=0;i<coppiedTabReversed4.length;i++){
			coppiedTabR244[i] = coppiedTabReversed4[i];
		}
		homework.BubbleSort(coppiedTabR244);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabR244.length;i++){
			System.out.print(coppiedTabR244[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleR1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleR1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR344 = new Integer[n4];
		for(int i=0;i<coppiedTabReversed4.length;i++){
			coppiedTabR344[i] = coppiedTabReversed4[i];
		}
		homework.ShellSort(coppiedTabR344);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabR344.length;i++){
			System.out.print(coppiedTabR344[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellR1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellR1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR444 = new Integer[n4];
		for(int i=0;i<coppiedTabReversed4.length;i++){
			coppiedTabR444[i] = coppiedTabReversed4[i];
		}
		homework.QuickSort(coppiedTabR444, 0, coppiedTabR444.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabR444.length;i++){
			System.out.print(coppiedTabR444[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickR1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickR1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabR544 = new Integer[n4];
		for(int i=0;i<coppiedTabReversed4.length;i++){
			coppiedTabR544[i] = coppiedTabReversed4[i];
		}
		homework.SelectSort(coppiedTabR544);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabR544.length;i++){
			System.out.print(coppiedTabR544[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectR1024prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectR1024por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		
		//POPRAWNIE UPORZ¥DKOWANA
		 // 8 ELEMENTÓW
		Integer[] coppiedTabSorted = new Integer[n];
		for(int i=0;i<tablica.length;i++){
			coppiedTabSorted[i] = tablica[i];
		}
		homework.insertSort(coppiedTabSorted);
		System.out.println("NAJPIERW SORTUJÊ WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
		System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
		for(int i=0;i<coppiedTabSorted.length;i++){
			System.out.print(coppiedTabSorted[i] +" ");
		}
		System.out.println();
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		
		System.out.println("");
		System.out.println("------------------------");
		
		Integer[] coppiedTabS = new Integer[n];
		for(int i=0;i<coppiedTabSorted.length;i++){
			coppiedTabS[i] = coppiedTabSorted[i];
		}
		homework.insertSort(coppiedTabS);
		System.out.println("Posortowana insertSortem");
		for(int i=0;i<coppiedTabS.length;i++){
			System.out.print(coppiedTabS[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer InsertS8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer InsertS8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabS2 = new Integer[n];
		for(int i=0;i<coppiedTabSorted.length;i++){
			coppiedTabS2[i] = coppiedTabSorted[i];
		}
		homework.BubbleSort(coppiedTabS2);
		System.out.println("Posortowana BubbleSortem");
		for(int i=0;i<coppiedTabS2.length;i++){
			System.out.print(coppiedTabS2[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer BubbleS8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer BubbleS8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabS3 = new Integer[n];
		for(int i=0;i<coppiedTabSorted.length;i++){
			coppiedTabS3[i] = coppiedTabSorted[i];
		}
		homework.ShellSort(coppiedTabS3);
		System.out.println("Posortowana ShellSortem");
		for(int i=0;i<coppiedTabS3.length;i++){
			System.out.print(coppiedTabS3[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer ShellS8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer ShellS8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabS4 = new Integer[n];
		for(int i=0;i<coppiedTabSorted.length;i++){
			coppiedTabS4[i] = coppiedTabSorted[i];
		}
		homework.QuickSort(coppiedTabS4, 0, coppiedTabS4.length - 1);
		System.out.println("Posortowana QuickSortem");
		for(int i=0;i<coppiedTabS4.length;i++){
			System.out.print(coppiedTabS4[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer QuickS8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer QuickS8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		
		System.out.println("------------------------");
		Integer[] coppiedTabS5 = new Integer[n];
		for(int i=0;i<coppiedTabSorted.length;i++){
			coppiedTabS5[i] = coppiedTabSorted[i];
		}
		homework.SelectSort(coppiedTabS5);
		System.out.println("Posortowana SelectSortem");
		for(int i=0;i<coppiedTabS5.length;i++){
			System.out.print(coppiedTabS5[i] +" ");
		}
		System.out.println();
		System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
		Integer SelectS8prz = licznikPrzestawien;
		System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
		Integer SelectS8por = licznikPorownan;
		licznikPrzestawien =0;
		licznikPorownan=0;
		System.out.println();
		System.out.println();
		
		
		
		// 64 ELEMENTY
				Integer[] coppiedTabSorted1 = new Integer[n1];
				for(int i=0;i<tablica1.length;i++){
					coppiedTabSorted1[i] = tablica1[i];
				}
				homework.insertSort(coppiedTabSorted1);
				System.out.println("NAJPIERW SORTUJÊ WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
				System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
				for(int i=0;i<coppiedTabSorted1.length;i++){
					System.out.print(coppiedTabSorted1[i] +" ");
				}
				System.out.println();
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("");
				System.out.println("------------------------");
				
				Integer[] coppiedTabS11 = new Integer[n1];
				for(int i=0;i<coppiedTabSorted1.length;i++){
					coppiedTabS11[i] = coppiedTabSorted1[i];
				}
				homework.insertSort(coppiedTabS11);
				System.out.println("Posortowana insertSortem");
				for(int i=0;i<coppiedTabS11.length;i++){
					System.out.print(coppiedTabS11[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer InsertS64prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer InsertS64por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS211 = new Integer[n1];
				for(int i=0;i<coppiedTabSorted1.length;i++){
					coppiedTabS211[i] = coppiedTabSorted1[i];
				}
				homework.BubbleSort(coppiedTabS211);
				System.out.println("Posortowana BubbleSortem");
				for(int i=0;i<coppiedTabS211.length;i++){
					System.out.print(coppiedTabS211[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer BubbleS64prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer BubbleS64por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS311 = new Integer[n1];
				for(int i=0;i<coppiedTabSorted1.length;i++){
					coppiedTabS311[i] = coppiedTabSorted1[i];
				}
				homework.ShellSort(coppiedTabS311);
				System.out.println("Posortowana ShellSortem");
				for(int i=0;i<coppiedTabS311.length;i++){
					System.out.print(coppiedTabS311[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer ShellS64prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer ShellS64por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS411 = new Integer[n1];
				for(int i=0;i<coppiedTabSorted1.length;i++){
					coppiedTabS411[i] = coppiedTabSorted1[i];
				}
				homework.QuickSort(coppiedTabS411, 0, coppiedTabS411.length - 1);
				System.out.println("Posortowana QuickSortem");
				for(int i=0;i<coppiedTabS411.length;i++){
					System.out.print(coppiedTabS411[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer QuickS64prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer QuickS64por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS511 = new Integer[n1];
				for(int i=0;i<coppiedTabSorted1.length;i++){
					coppiedTabS511[i] = coppiedTabSorted1[i];
				}
				homework.SelectSort(coppiedTabS511);
				System.out.println("Posortowana SelectSortem");
				for(int i=0;i<coppiedTabS511.length;i++){
					System.out.print(coppiedTabS511[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer SelectS64prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer SelectS64por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				System.out.println();
				System.out.println();
		
				
		
				// 128 ELEMENTÓW		
				Integer[] coppiedTabSorted2 = new Integer[n2];
				for(int i=0;i<tablica2.length;i++){
					coppiedTabSorted2[i] = tablica2[i];
				}
				homework.insertSort(coppiedTabSorted2);
				System.out.println("NAJPIERW SORTUJÊ WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
				System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
				for(int i=0;i<coppiedTabSorted2.length;i++){
					System.out.print(coppiedTabSorted2[i] +" ");
				}
				System.out.println();
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				
				System.out.println("");
				System.out.println("------------------------");
				
				Integer[] coppiedTabS22 = new Integer[n2];
				for(int i=0;i<coppiedTabSorted2.length;i++){
					coppiedTabS22[i] = coppiedTabSorted2[i];
				}
				homework.insertSort(coppiedTabS22);
				System.out.println("Posortowana insertSortem");
				for(int i=0;i<coppiedTabS22.length;i++){
					System.out.print(coppiedTabS22[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer InsertS128prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer InsertS128por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS222 = new Integer[n2];
				for(int i=0;i<coppiedTabSorted2.length;i++){
					coppiedTabS222[i] = coppiedTabSorted2[i];
				}
				homework.BubbleSort(coppiedTabS222);
				System.out.println("Posortowana BubbleSortem");
				for(int i=0;i<coppiedTabS222.length;i++){
					System.out.print(coppiedTabS222[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer BubbleS128prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer BubbleS128por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS322 = new Integer[n2];
				for(int i=0;i<coppiedTabSorted2.length;i++){
					coppiedTabS322[i] = coppiedTabSorted2[i];
				}
				homework.ShellSort(coppiedTabS322);
				System.out.println("Posortowana ShellSortem");
				for(int i=0;i<coppiedTabS322.length;i++){
					System.out.print(coppiedTabS322[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer ShellS128prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer ShellS128por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS422 = new Integer[n2];
				for(int i=0;i<coppiedTabSorted2.length;i++){
					coppiedTabS422[i] = coppiedTabSorted2[i];
				}
				homework.QuickSort(coppiedTabS422, 0, coppiedTabS422.length - 1);
				System.out.println("Posortowana QuickSortem");
				for(int i=0;i<coppiedTabS422.length;i++){
					System.out.print(coppiedTabS422[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer QuickS128prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer QuickS128por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS522 = new Integer[n2];
				for(int i=0;i<coppiedTabSorted2.length;i++){
					coppiedTabS522[i] = coppiedTabSorted2[i];
				}
				homework.SelectSort(coppiedTabS522);
				System.out.println("Posortowana SelectSortem");
				for(int i=0;i<coppiedTabS522.length;i++){
					System.out.print(coppiedTabS522[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer SelectS128prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer SelectS128por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				System.out.println();
				System.out.println();
				
				
				
				// 512 ELEMENTÓW
				Integer[] coppiedTabSorted3 = new Integer[n3];
				for(int i=0;i<tablica3.length;i++){
					coppiedTabSorted3[i] = tablica3[i];
				}
				homework.insertSort(coppiedTabSorted3);
				System.out.println("NAJPIERW SORTUJÊ WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
				System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
				for(int i=0;i<coppiedTabSorted3.length;i++){
					System.out.print(coppiedTabSorted3[i] +" ");
				}
				System.out.println();
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				
				System.out.println("");
				System.out.println("------------------------");
				
				Integer[] coppiedTabS33 = new Integer[n3];
				for(int i=0;i<coppiedTabSorted3.length;i++){
					coppiedTabS33[i] = coppiedTabSorted3[i];
				}
				homework.insertSort(coppiedTabS33);
				System.out.println("Posortowana insertSortem");
				for(int i=0;i<coppiedTabS33.length;i++){
					System.out.print(coppiedTabS33[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer InsertS512prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer InsertS512por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS233 = new Integer[n3];
				for(int i=0;i<coppiedTabSorted3.length;i++){
					coppiedTabS233[i] = coppiedTabSorted3[i];
				}
				homework.BubbleSort(coppiedTabS233);
				System.out.println("Posortowana BubbleSortem");
				for(int i=0;i<coppiedTabS233.length;i++){
					System.out.print(coppiedTabS233[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer BubbleS512prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer BubbleS512por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS333 = new Integer[n3];
				for(int i=0;i<coppiedTabSorted3.length;i++){
					coppiedTabS333[i] = coppiedTabSorted3[i];
				}
				homework.ShellSort(coppiedTabS333);
				System.out.println("Posortowana ShellSortem");
				for(int i=0;i<coppiedTabS333.length;i++){
					System.out.print(coppiedTabS333[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer ShellS512prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer ShellS512por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS433 = new Integer[n3];
				for(int i=0;i<coppiedTabSorted3.length;i++){
					coppiedTabS433[i] = coppiedTabSorted3[i];
				}
				homework.QuickSort(coppiedTabS433, 0, coppiedTabS433.length - 1);
				System.out.println("Posortowana QuickSortem");
				for(int i=0;i<coppiedTabS433.length;i++){
					System.out.print(coppiedTabS433[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer QuickS512prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer QuickS512por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS533 = new Integer[n3];
				for(int i=0;i<coppiedTabSorted3.length;i++){
					coppiedTabS533[i] = coppiedTabSorted3[i];
				}
				homework.SelectSort(coppiedTabS533);
				System.out.println("Posortowana SelectSortem");
				for(int i=0;i<coppiedTabS533.length;i++){
					System.out.print(coppiedTabS533[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer SelectS512prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer SelectS512por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				System.out.println();
				System.out.println();
				
				
				
				// 1024 ELEMENTÓW
				Integer[] coppiedTabSorted4 = new Integer[n4];
				for(int i=0;i<tablica4.length;i++){
					coppiedTabSorted4[i] = tablica4[i];
				}
				homework.insertSort(coppiedTabSorted4);
				System.out.println("NAJPIERW SORTUJÊ WCZEŒNIEJ WYLOSOWAN¥ TABLICÊ !");
				System.out.println("Przepuszczam poni¿sz¹ tablicê przez wszystkie metody");
				for(int i=0;i<coppiedTabSorted4.length;i++){
					System.out.print(coppiedTabSorted4[i] +" ");
				}
				System.out.println();
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				
				System.out.println("");
				System.out.println("------------------------");
				
				Integer[] coppiedTabS44 = new Integer[n4];
				for(int i=0;i<coppiedTabSorted4.length;i++){
					coppiedTabS44[i] = coppiedTabSorted4[i];
				}
				homework.insertSort(coppiedTabS44);
				System.out.println("Posortowana insertSortem");
				for(int i=0;i<coppiedTabS44.length;i++){
					System.out.print(coppiedTabS44[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer InsertS1024prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer InsertS1024por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS244 = new Integer[n4];
				for(int i=0;i<coppiedTabSorted4.length;i++){
					coppiedTabS244[i] = coppiedTabSorted4[i];
				}
				homework.BubbleSort(coppiedTabS244);
				System.out.println("Posortowana BubbleSortem");
				for(int i=0;i<coppiedTabS244.length;i++){
					System.out.print(coppiedTabS244[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer BubbleS1024prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer BubbleS1024por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS344 = new Integer[n4];
				for(int i=0;i<coppiedTabSorted4.length;i++){
					coppiedTabS344[i] = coppiedTabSorted4[i];
				}
				homework.ShellSort(coppiedTabS344);
				System.out.println("Posortowana ShellSortem");
				for(int i=0;i<coppiedTabS344.length;i++){
					System.out.print(coppiedTabS344[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer ShellS1024prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer ShellS1024por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS444 = new Integer[n4];
				for(int i=0;i<coppiedTabSorted4.length;i++){
					coppiedTabS444[i] = coppiedTabSorted4[i];
				}
				homework.QuickSort(coppiedTabS444, 0, coppiedTabS444.length - 1);
				System.out.println("Posortowana QuickSortem");
				for(int i=0;i<coppiedTabS444.length;i++){
					System.out.print(coppiedTabS444[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer QuickS1024prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer QuickS1024por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				
				System.out.println("------------------------");
				Integer[] coppiedTabS544 = new Integer[n4];
				for(int i=0;i<coppiedTabSorted4.length;i++){
					coppiedTabS544[i] = coppiedTabSorted4[i];
				}
				homework.SelectSort(coppiedTabS544);
				System.out.println("Posortowana SelectSortem");
				for(int i=0;i<coppiedTabS544.length;i++){
					System.out.print(coppiedTabS544[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer SelectS1024prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer SelectS1024por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				System.out.println();
				System.out.println();
				System.out.println();
		
		/*
				System.out.println("");
				System.out.println("------------------------");
				
				Integer[] coppiedTab01 = new Integer[n];
				for(int i=0;i<tablica.length;i++){
					coppiedTab01[i] = tablica[i];
				}
				homework.MergeSort(coppiedTab01);
				System.out.println("Posortowana MergeSortem");
				for(int i=0;i<coppiedTab01.length;i++){
					System.out.print(coppiedTab01[i] +" ");
				}
				System.out.println();
				System.out.println("Licznik przestawieñ wynosi: "+ licznikPrzestawien);
				Integer Merge8prz = licznikPrzestawien;
				System.out.println("Licznik porownan wynosi: "+ licznikPorownan);
				Integer Merge8por = licznikPorownan;
				licznikPrzestawien =0;
				licznikPorownan=0;
				System.out.println();
				System.out.println();
		*/
		


		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("PODSUMOWANIE WYNIKÓW");
		System.out.println("                                             Tablica losowych liczb                                                         Uporz¹dkowane odwrotnie do porz¹dku                                            Uporz¹dkowane zgodnie z porz¹dkiem");
		System.out.println("    Metoda sortowania:|     n=8     |     n=64     |     n= 128     |     n=512     |     n= 1024     ||     n=8     |     n=64     |     n= 128     |     n=512     |     n= 1024     ||     n=8     |     n=64     |     n= 128     |     n=512     |     n= 1024     ");
		System.out.println();
		System.out.printf("QuickSort - l.porównañ:" + "%7d %14d %16d %16d %16d %15d %14d %16d %16d %16d %15d %14d %16d %16d %16d", Quick8por,  Quick64por, Quick128por, Quick512por, Quick1024por, QuickR8por,  QuickR64por, QuickR128por, QuickR512por, QuickR1024por, QuickS8por,  QuickS64por, QuickS128por, QuickS512por, QuickS1024por);
		System.out.println();
		System.out.printf("        l.przestawieñ:"+ "%7d %14d %16d %17d %15d %15d %14d %16d %17d %15d %15d %14d %16d %17d %15d", Quick8prz,  Quick64prz, Quick128prz, Quick512prz, Quick1024prz, QuickR8prz,  QuickR64prz, QuickR128prz, QuickR512prz, QuickR1024prz, QuickS8prz,  QuickS64prz, QuickS128prz, QuickS512prz, QuickS1024prz);
		System.out.println();
		System.out.println();
		System.out.printf("SelectSort - l.porównañ:" + "%6d %14d %16d %16d %16d %14d %14d %16d %16d %16d %14d %14d %16d %16d %16d", Select8por,  Select64por, Select128por, Select512por, Select1024por, SelectR8por,  SelectR64por, SelectR128por, SelectR512por, SelectR1024por, SelectS8por,  SelectS64por, SelectS128por, SelectS512por, SelectS1024por);
		System.out.println();
		System.out.printf("        l.przestawieñ:"+ "%7d %14d %16d %17d %15d %15d %14d %16d %17d %15d %15d %14d %16d %17d %15d", Select8prz,  Select64prz, Select128prz, Select512prz, Select1024prz, SelectR8prz,  SelectR64prz, SelectR128prz, SelectR512prz, SelectR1024prz, SelectS8prz,  SelectS64prz, SelectS128prz, SelectS512prz, SelectS1024prz);
		System.out.println();
		System.out.println();
		System.out.printf("InsertSort - l.porównañ:" + "%6d %14d %16d %16d %16d %14d %14d %16d %16d %16d %14d %14d %16d %16d %16d", Insert8por,  Insert64por, Insert128por, Insert512por, Insert1024por, InsertR8por,  InsertR64por, InsertR128por, InsertR512por, InsertR1024por, InsertS8por,  InsertS64por, InsertS128por, InsertS512por, InsertS1024por);
		System.out.println();
		System.out.printf("        l.przestawieñ:"+ "%7d %14d %16d %17d %15d %15d %14d %16d %17d %15d %15d %14d %16d %17d %15d", Insert8prz,  Insert64prz, Insert128prz, Insert512prz, Insert1024prz, InsertR8prz,  InsertR64prz, InsertR128prz, InsertR512prz, InsertR1024prz, InsertS8prz,  InsertS64prz, InsertS128prz, InsertS512prz, InsertS1024prz);
		System.out.println();
		System.out.println();
		System.out.printf("BubbleSort - l.porównañ:" + "%6d %14d %16d %16d %16d %14d %14d %16d %16d %16d %14d %14d %16d %16d %16d", Bubble8por,  Bubble64por, Bubble128por, Bubble512por, Bubble1024por, BubbleR8por,  BubbleR64por, BubbleR128por, BubbleR512por, BubbleR1024por, BubbleS8por,  BubbleS64por, BubbleS128por, BubbleS512por, BubbleS1024por);
		System.out.println();
		System.out.printf("        l.przestawieñ:"+ "%7d %14d %16d %17d %15d %15d %14d %16d %17d %15d %15d %14d %16d %17d %15d", Bubble8prz,  Bubble64prz, Bubble128prz, Bubble512prz, Bubble1024prz, BubbleR8prz,  BubbleR64prz, BubbleR128prz, BubbleR512prz, BubbleR1024prz, BubbleS8prz,  BubbleS64prz, BubbleS128prz, BubbleS512prz, BubbleS1024prz);
		System.out.println();
		System.out.println();
		System.out.printf("ShellSort - l.porównañ:" + "%6d %14d %16d %16d %16d %14d %14d %16d %16d %16d %14d %14d %16d %16d %16d", Shell8por,  Shell64por, Shell128por, Shell512por, Shell1024por, ShellR8por,  ShellR64por, ShellR128por, ShellR512por, ShellR1024por, ShellS8por,  ShellS64por, ShellS128por, ShellS512por, ShellS1024por);
		System.out.println();
		System.out.printf("        l.przestawieñ:"+ "%7d %14d %16d %17d %15d %15d %14d %16d %17d %15d %15d %14d %16d %17d %15d", Shell8prz,  Shell64prz, Shell128prz, Shell512prz, Shell1024prz, ShellR8prz,  ShellR64prz, ShellR128prz, ShellR512prz, ShellR1024prz, ShellS8prz,  ShellS64prz, ShellS128prz, ShellS512prz, ShellS1024prz);
		System.out.println();
		System.out.println();
	}
}
