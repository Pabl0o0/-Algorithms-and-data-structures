package lab6;

public interface ComparatorNazwisko {

	public static int compare(Osoba os1, Osoba os2) throws ClassCastException {
		// TODO Auto-generated method stub
			return os1.getNazwisko().compareTo(os2.getNazwisko());
	}
}
