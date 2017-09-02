
public class Student {

	private String imie;
	private String nazwisko;
	private int numerIndeksu;
	private double ocena;
	

	
	Student (String imie, String nazwisko, int numerIndeksu, double ocena){
		setImie(imie);
		setNazwisko(nazwisko);
	    setNumerIndeksu(numerIndeksu);
		setOcena(ocena);
		
	}



	public String getImie() {
		return imie;
	}



	public void setImie(String imie) {
		this.imie = imie;
	}



	public String getNazwisko() {
		return nazwisko;
	}



	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}



	public int getNumerIndeksu() {
		return numerIndeksu;
	}



	public void setNumerIndeksu(int numerIndeksu) {
		this.numerIndeksu = numerIndeksu;
	}



	public double getOcena() {
		return ocena;
	}



	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
	@Override
	public String toString() {
		return ("Student: " + imie +" "+  nazwisko + ", numer indeksu: " + numerIndeksu + ", ocena="
				+ ocena);
	}

	
}
