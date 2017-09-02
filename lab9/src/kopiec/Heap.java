package kopiec;

public class Heap {
	
		int left;
		int right;
		int heap[];
		int n;
		int smaller;
				
	public Heap(int size){
		heap = new int[size];
	}

	public void buildingHeap(int[] heap){
		n = heap.length-2;
		for(int i =n/2; i>=0;i--){
			findMinimum(i);		
		}
	}

	public void findMinimum(int i){
		left = 2*i+1;
		right = 2*i+2;
		if (left<= n+1 && heap[left] < heap[i])
			smaller = left;
		else 
			smaller = i;
		if (right <= n+1 && heap[right] < heap[i])
			if(heap[smaller]>heap[right])
				smaller = right;	
		if (smaller != i){
			swap(i,smaller);
			findMinimum(smaller);
		}	
	}

	public void swap(int i, int j){
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;	
	}

	public void heapSort(int [] tab){
		heap=tab;
		buildingHeap(heap);
		for(int i=n+1;i>0;i--){
			swap(0,i);
			n=n-1;
			findMinimum(0);
		}
	}

	public void enqueue(int value){
		int i=0;
		heap=biggerHeap();
		i=heap.length-1;
		heap[i]=value;
		
		while(heap[(i-1)/2]>heap[i]){
			int x=heap[(i-1)/2];
			heap[(i-1)/2]=heap[i];
			heap[i]=x;
			i=(i-1)/2;
		} 			
	}
	
	private int []biggerHeap(){
		int []heap1=new int[heap.length+1];
		System.arraycopy(heap,0,heap1,0,heap.length);
		return heap1;
	}
	
	public void heapDisplay(){
		for(int i=0;i<heap.length;i++)
			System.out.print(heap[i]+", ");
		System.out.println();
	}

	
	int x = 1;
	public int dequeue(){
		int tmp = heap[0];	
		int heapLenght = heap.length-x;
		swap(0,heapLenght);
		if (heapLenght ==2){
			if (heap[1] < heap[0])
				swap(0,1);
			x++;
			return tmp;
		}
		if (heapLenght == 1)
			return tmp;
		int i=0;
		left = 2*i+1;
		right = 2*i+2;
		
	while(heap[left]<heap[i] || heap[right]<heap[i]){		
		if (heap[left] < heap[i])
			smaller = left;
		else 
			smaller = i;
		if (heap[right] < heap[i])
			if(heap[smaller]>heap[right])
				smaller = right;	
		if (smaller != i){
			swap(i,smaller);
			left = 2*smaller+1;
			right = 2*smaller+2;
			i = smaller;
		}
		if (left >= heapLenght || right >= heapLenght){
			break;
		}		
	}
	x++;
	return tmp;
	}
	
	
	public int remove(int index){
		int tmp = heap[index];
		int heapLenght = heap.length-1;
		swap(heapLenght,index);
		heap = smallerHeap();
		buildingHeap(heap);
		return tmp;
	}
	
	private int []smallerHeap(){
		int []heap1=new int[heap.length-1];
		System.arraycopy(heap,0,heap1,0,heap.length-1);
		return heap1;
	}
	
}
	


