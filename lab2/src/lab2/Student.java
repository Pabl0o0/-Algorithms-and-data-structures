package lab2;

public class Student {

	private int numerIndeksu;
	private String nazwisko;
	private String imie;
	private double ocena;
	
	public int getNumerIndeksu() {
		return numerIndeksu;
	}
	public void setNumerIndeksu(int numerIndeksu) {
		this.numerIndeksu = numerIndeksu;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public double getOcena() {
		return ocena;
	}
	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
	public Student(int numerIndeksu, String nazwisko, String imie, double ocena){
		setNumerIndeksu(numerIndeksu);
		setNazwisko(nazwisko);
		setImie(imie);
		setOcena(ocena);
	}
	@Override
	public String toString() {
		return "Student: " + imie + " "+ nazwisko +" numer indeksu: "+ numerIndeksu + " ocena: "
				+ ocena;
	}
	
	
	
}
