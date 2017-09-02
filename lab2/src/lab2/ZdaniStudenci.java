package lab2;

public class ZdaniStudenci implements Predicate {

	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		Student student = (Student) o;
		  	if(student.getOcena()>=3.0)
	    	return true;
		  	
		  	return false;
	    }
	
	   
	
}
