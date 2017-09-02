

public class Student {

	private int numer;
	private String nazwisko;
	private String imie;
	private double ocena;
	
	public int getNumer() {
		return numer;
	}
	public void setNumer(int numer) {
		this.numer = numer;
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
	
	public Student(int numer, String nazwisko, String imie, double ocena){
		setNumer(numer);
		setNazwisko(nazwisko);
		setImie(imie);
		setOcena(ocena);
	}
	@Override
	public String toString() {
		return "Student numer: "+ numer +" " + imie + " "+ nazwisko +" numer indeksu: " +" ocena: "
				+ ocena;
	}
	
	
	
}
