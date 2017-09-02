public class Test implements Comparator, Comparator2 {

	public static Student[] sortByName(Student[] tablica){
		for (int i = 0;i<tablica.length;i++){
			for(int j = 0; j<tablica.length-i-1;j++){
				if(Comparator.compare(tablica[j], tablica[j+1])>0){
					Student tmp = tablica[j];
					tablica[j] = tablica[j+1];
					tablica[j+1] = tmp;
				}
			}
		}
		return tablica;
	}
	
	public static Student[] complicatedSorted(Student[] tablica){
		for (int i = 0;i<tablica.length;i++){
			for(int j = 0; j<tablica.length-i-1;j++){
				if(Comparator2.compare2(tablica[j], tablica[j+1])>0){
					Student tmp = tablica[j];
					tablica[j] = tablica[j+1];
					tablica[j+1] = tmp;
				}
			}
		}
		return tablica;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student0 = new Student(0, "Kowalski", "Jan", 5.5);
        Student student1 = new Student(1, "Kowal", "Basia", 4.5);
        Student student2 = new Student(2, "ród³o", "Maciej", 3.5);
        Student student3 = new Student(3, "Wysoka", "Marta", 4.0);
        Student student4 = new Student(4, "Konarek", "Dorota", 5.0);
        Student student5 = new Student(5, "Nowy", "Bart³omiej", 2.0);
        Student student6 = new Student(6, "Nawyk", "Bart³omiej", 3.0);
        
        int size = 7;
		Student[] tablica = new Student[size];
        tablica[0] = student0;
        tablica[1] = student1;
        tablica[2] = student2;
        tablica[3] = student3;
        tablica[4] = student4;
        tablica[5] = student5;
        tablica[6] = student6;
        
        System.out.println("Tablica w kolejnoœci wpisania");
        for(int i = 0;i<tablica.length;i++){
        	System.out.println(tablica[i]);
        }
        System.out.println();
        System.out.println("Tablica po sortowaniu imionami");
        Student[] tab=sortByName(tablica);
        for(int i=0; i<tab.length;i++){
        System.out.println(tab[i]);
        }
        
        System.out.println();
        System.out.println("Tablica po sortowaniu imionami compare2");
        Student[] tab2=complicatedSorted(tablica);
        for(int i=0; i<tab2.length;i++){
        System.out.println(tab2[i]);
        }
	}
}

/*
for (int i = 0;i<tablica.length;i++){
	int slot = posortowana.length;
	while(slot>0){
		if(Comparator.compare(tablica[i], tablica[i+1])>0){
	}
}
return posortowana;
}

*//*
Osoba temp;
for (int i = 1; i < input.length; i++) {
    for(int j = i ; j > 0 ; j--){
        if(Comparator.compare(input[j], input[j+1])>0){
            temp = input[j];
            input[j] = input[j-1];
            input[j-1] = temp;
        }
    }
}
return input;
}
*/	

//Osoba[] posortowana = new Osoba[tablica.length];