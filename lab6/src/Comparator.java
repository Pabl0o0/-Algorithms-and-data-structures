
public interface Comparator {
	public static int compare(Student st1, Student st2) throws ClassCastException {
		// TODO Auto-generated method stub
			return st1.getImie().compareTo(st2.getImie());
	}
}
