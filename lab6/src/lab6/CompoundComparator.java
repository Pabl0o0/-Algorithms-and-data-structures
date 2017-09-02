package lab6;

public class CompoundComparator implements Comparator, ComparatorNazwisko, ComparatorWiek {

	private static final Comparator[] TablicaComparator = null;
	public void addComparator(Comparator comparator,ComparatorNazwisko comparatorNazwisko, ComparatorWiek comparatorWiek){
		TablicaComparator[0] = comparator;
		TablicaComparator[1] = (Comparator) comparatorNazwisko;
		TablicaComparator[2] = (Comparator) comparatorWiek;
		
	}
	
	public int compare(Osoba os1, Osoba os2) throws ClassCastException {
		int result = 0;
		for(int i = 0; i<TablicaComparator.length;i++){
			if(compare(os1,os2)==0)
			i++;
		}
		return result;
	}
}
