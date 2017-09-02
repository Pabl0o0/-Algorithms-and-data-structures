
public interface Comparator2 {
	public static int compare2(Student st1, Student st2) throws ClassCastException {
		// TODO Auto-generated method stub
		if (!(st1.getImie().equals(st2.getImie())))
			return st1.getImie().compareTo(st2.getImie());
		else if (!(st1.getNazwisko().equals(st2.getNazwisko())))
				return st1.getNazwisko().compareTo(st2.getNazwisko());
		else 
			return (String.valueOf(st1.getOcena())).compareTo(String.valueOf(st2.getOcena()));
	}
}
