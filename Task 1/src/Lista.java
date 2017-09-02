import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lista {

	private ArrayList<Student> lista = new ArrayList<Student>();

	private int x;
	String[] tab = new String[x];
	
	public void odczyt(){
	String fileName = "fileName.txt";
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(fileName));
        String tmp = null;
        tmp = reader.readLine();
        while ((tmp = reader.readLine()) != null) {
        	String linia = tmp;
        	String[] parts = linia.split("\\s+");
        	String imie = parts[0];
        	String nazwisko = parts[1];
        	String numerIndeksuu = parts[2];
        	String ocenaa = parts[3];
        	int numerIndeksu = Integer.parseInt(numerIndeksuu);
         	double ocena = Double.parseDouble(ocenaa);
        	Student student = new Student(imie, nazwisko, numerIndeksu, ocena);
        	lista.add(student);
       }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	}
	
	
	public void wyswietl(){
		Iterator<Student> iterator = lista.iterator();
	    while(iterator.hasNext()) {
	        Student student = iterator.next();
	        System.out.println(student);
	        
	}
	    System.out.println();
}
	
	public void zmianaOceny(int numerIndeksu){ 
		Iterator<Student> iterator = lista.iterator();
	    while(iterator.hasNext()) {
	        Student student = iterator.next();
	        if(numerIndeksu==student.getNumerIndeksu()){
	        	double nowaOcena;
	        	Scanner sc = new Scanner(System.in);
	        	System.out.println("Wprowadz now¹ ocenê dla studenta o numerze indeksu: " +numerIndeksu+ " " + student.getImie()+ " "+student.getNazwisko());
	        	nowaOcena = sc.nextDouble();
	        	sc.nextLine();
	        	sc.close();
	        	student.setOcena(nowaOcena);
	        	System.out.println("Ocena zosta³a zmieniona !");	
	        	System.out.println(student); // sprawdzam, czy zmieni³o ocenê
	        }
	 }
	    System.out.println();
	}

	public void sredniaOcen(){
		double srednia=0;;
		Iterator<Student> iterator = lista.iterator();
	    while(iterator.hasNext()) {
	        Student student = iterator.next();
	        if(student.getOcena()>=3.0){
	        srednia += student.getOcena();
	        }
	}
	   srednia = srednia/lista.size();
	   System.out.println("Œrednia ocen studentów wynosi: " + srednia);
	   System.out.println();
	}
	
	public void ulani(){
		System.out.println("Kursu nie zaliczyli: ");
		for (Student student: lista){
			if(student.getOcena()<3.0){
				System.out.println(student);
			}
		}
		System.out.println();
	}
	
	public void zapisDoPliku(){
		String fileName = "fileNamePoZapisie.txt";
               
        try{
        		PrintWriter writer = new PrintWriter(fileName);
        		writer.println("LISTA STUDENTÓW:");
        		Iterator<Student> iterator = lista.iterator();
        		 while(iterator.hasNext()) {
        			 Student student = iterator.next();
        			 writer.printf("%-15s%-20s%-12d%-7.1f%n", student.getImie(), student.getNazwisko(), student.getNumerIndeksu(), student.getOcena());
        			 
        		 }
        		 writer.println();
        		 writer.close();
	    } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
         
        System.out.println("Zapisano liste do pliku" + fileName);
    }
}
