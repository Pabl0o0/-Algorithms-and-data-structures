package lab2;

public class IteratorFiltrujacy implements Iterator{
	
	private final Iterator iterf;
	private final Predicate pred;
	
		public IteratorFiltrujacy(Iterator i, Predicate predykat){
		iterf=i; 
		pred=predykat; 
		iterf.first();
	}
	
	
	public void filtrujDoPrzodu() {
		while (!iterf.isDone() && !pred.accept(iterf.current()))
		 iterf.next(); 
		}
	
	public void filtrujDoTylu() {
		while( !iterf.isDone() && !pred.accept(iterf.current()))
			iterf.previous();
		}
	
	public void first() {
		iterf.first(); 
		filtrujDoPrzodu(); 
		}
	
	public void last() {
		iterf.last(); 
		filtrujDoTylu();
	}
		
	public void next() {
		iterf.next(); 
		filtrujDoPrzodu(); 
		}
	
	public void previous() {
	 iterf.previous(); 
	 filtrujDoTylu();
	 }
	
	public boolean isDone() {
		return iterf.isDone(); 
		}
	
	public Student current(){
		return iterf.current();
		}
	
	
	

}