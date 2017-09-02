package lab6;

public class Osoba {

	private String nazwisko;
	private String imie;
	private int wiek;
	
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
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	
	public Osoba(String nazwisko, String imie, int wiek){
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.wiek = wiek;
	}
	@Override
	public String toString() {
		return "Osoba " + imie + " " + nazwisko + " , wiek=" + wiek;
	}
	
	
}
