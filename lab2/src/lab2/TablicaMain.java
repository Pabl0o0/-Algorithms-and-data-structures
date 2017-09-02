package lab2;

public class TablicaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		Tablica tab = new Tablica();
		tab.add(0, new Student(111111,"Kowalski","Jan",5.0));
		tab.add(1, new Student(222222,"Zimny","Marian",0.0));
		tab.add(2, new Student(333333,"Rogal","Dorota",4.0));
		tab.add(3, new Student(444444,"Ca³ek","Justyna",2.0));
		tab.wyswietl();
		tab.wpisanieOceny(222222, 5.5);
			
		tab.wyswietlSrednia();
		tab.studenciZOCena4();
	}

}
