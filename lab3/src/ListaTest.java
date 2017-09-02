

public class ListaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista lista = new Lista();
        Student student0 = new Student(0, "Kowalski", "Jan", 5.5);
        Student student1 = new Student(1, "Kowal", "Basia", 4.5);
        Student student2 = new Student(2, "ród³o", "Maciej", 3.5);
        Student student3 = new Student(3, "Wysoka", "Marta", 4.0);
        Student student4 = new Student(4, "Konarek", "Dorota", 5.0);
        Student student5 = new Student(5, "Nowy", "Marek", 5.0);
        lista.insert(0, student0);
        lista.insert(1, student1);
        lista.add(student4);
        lista.insert(2, student2);
        lista.insert(3, student3);
        System.out.println("LISTA STUDENTÓW");
        lista.wyswietlListe();
        System.out.println("Rozmiar tablicy wynosi: "+ lista.size());
        System.out.println();
        lista.delete(1);
        System.out.println("Po usuniêciu studenta z indeksem 1");
        Iterator iterator = lista.iterator();
        while(!iterator.isDone()){
            System.out.println(iterator.current());
            iterator.next();
        }
        System.out.println();
        
        System.out.println("Student o indeksie 2 to: ");
        System.out.println(lista.get(2));
       
        System.out.println("Po usuniêciu studenta2");
        lista.delete(student2);
        lista.wyswietlListe();
        System.out.println("Po zmianie studenta " + lista.set(1, student5));
        lista.wyswietlListe();
        System.out.println("Indeks studenta5 wynosi: " +lista.indexOf(student5));
        System.out.println();
        System.out.println("Czy jest student5 ? " + lista.contains(student5));
        System.out.println("Czy jest student2 ? " + lista.contains(student2));
        
        System.out.println();
        System.out.print("Czyszczê listê !");
        lista.clear();
        lista.wyswietlListe();
        System.out.println("Rozmiar tablicy wynosi: "+ lista.size());
	}

}
