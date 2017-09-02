package lab2;

public interface Iterator {

	public void first();
	public void last();
	public void next();
	public void previous();
	boolean isDone();
	Student current() ;
}
