package lab2;

import javafx.scene.control.Tab;

public class Tablica {

	Student[] student;
	private int iloscStudentow;
	
	public Tablica(){
		iloscStudentow = 10;
		student = new Student[iloscStudentow];
		}

	public void add(int index, Student o){
		student[index] = o;
		}
	
	public void wyswietl(){
		IteratorTablicowy i = new IteratorTablicowy(student);
		i.first();
		while(!i.isDone() && i.current() !=null){
			Student st = (Student)i.current();
			System.out.println(st);
			i.next();
		}
		System.out.println();
	}
	
	public void wpisanieOceny(int numerIndeksu, double ocena){
		IteratorTablicowy i = new IteratorTablicowy(student);
		boolean zmieniona = false;
		i.first();
		while(!i.isDone()&& i.current() !=null){
			Student st = (Student)i.current();
			if(st.getNumerIndeksu() == numerIndeksu){
				st.setOcena(ocena);
				System.out.println("Ocena ustawiona");
				System.out.println(st);
				zmieniona = true;
			}
			
			i.next();
			
			}
		if(!zmieniona){
			System.out.println("Nie znaleziono studenta");
			}
		System.out.println();
		}

	
	public void wyswietlSrednia(){
		double srednia;
		double sumaOcen = 0;
		int licznik=0;
		IteratorTablicowy i = new IteratorTablicowy(student,0,4);
		ZdaniStudenci zs = new ZdaniStudenci();
		IteratorFiltrujacy itt = new IteratorFiltrujacy(i, zs);
		itt.first();
		while(!itt.isDone() && itt.current() !=null){
			Student st = (Student)itt.current();
			sumaOcen += st.getOcena();
			itt.next();
			licznik++;
		}
		srednia = sumaOcen / licznik;
		System.out.println("œrednia ocen studentów, którzy zaliczyli: " + srednia);
		System.out.println();
	}
	
	
	public void studenciZOCena4(){
		IteratorTablicowy i = new IteratorTablicowy(student,0,4);
		CzworkowiStudenci cs = new CzworkowiStudenci();
		IteratorFiltrujacy itt = new IteratorFiltrujacy(i, cs);
		itt.first();
		System.out.println("Studenci z ocen¹ przynajmniej 4.0: ");
		while(!itt.isDone() && itt.current() !=null){
			Student st = (Student)itt.current();
			System.out.println(st);
			itt.next();
		}
		System.out.println();
	}
	
	
	
}
    
	


	
	

