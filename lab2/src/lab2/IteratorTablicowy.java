package lab2;

public class IteratorTablicowy implements Iterator {

	
	Student [] tablica; 
	final int pierwszy; 
	final int ostatni; 
	int biezacy=-1; 
	
	public IteratorTablicowy(Object[] tab, int odElem, int liczbaElem)
	{ tablica=(Student[]) tab;
	pierwszy=odElem;
	ostatni=odElem+liczbaElem-1;
	}
	
	public IteratorTablicowy(Student[] tab) 
	{ tablica=tab; 
		pierwszy=0; 
	ostatni=tablica.length-1;
	}
	@Override
	public void first() {
		// TODO Auto-generated method stub
		biezacy=pierwszy;
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		biezacy=ostatni;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		++biezacy;
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		--biezacy;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return biezacy < pierwszy || biezacy > ostatni;
	}

	@Override
	public Student current() {
		// TODO Auto-generated method stub
		return (Student) tablica [ biezacy ];
	}

}
