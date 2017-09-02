package lab2;

public class CzworkowiStudenci implements Predicate {

	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		Student student = (Student) o;
	  	if(student.getOcena()>=4.0)
    	return true;
	  	
	  	return false;
    }

}
