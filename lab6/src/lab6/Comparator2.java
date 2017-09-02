package lab6;

public interface Comparator2 {
	public static int compare2(Osoba os1, Osoba os2) throws ClassCastException {
		// TODO Auto-generated method stub
		if (!(os1.getImie().equals(os2.getImie())))
			return os1.getImie().compareTo(os2.getImie());
		else if (!(os1.getNazwisko().equals(os2.getNazwisko())))
				return os1.getNazwisko().compareTo(os2.getNazwisko());
		else 
			return (String.valueOf(os1.getWiek())).compareTo(String.valueOf(os2.getWiek()));
	}
}
