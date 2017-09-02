package lab6;

public interface Comparator {
	public static int compare(Osoba os1, Osoba os2) throws ClassCastException {
		// TODO Auto-generated method stub
			return os1.getImie().compareTo(os2.getImie());
	}
}
