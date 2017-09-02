package lab6;

public interface ComparatorWiek {
	public static int compare(Osoba os1, Osoba os2) throws ClassCastException {
		// TODO Auto-generated method stub
		return (String.valueOf(os1.getWiek())).compareTo(String.valueOf(os2.getWiek()));
	}
}
