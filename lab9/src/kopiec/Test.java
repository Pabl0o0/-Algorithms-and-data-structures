package kopiec;

import java.util.Random;

public class Test {

	public static void main(String args[]){
		
	Heap h = new Heap(11);
		
	for(int i =0; i<h.heap.length;i++){
		Random r = new Random();
		h.heap[i] = r.nextInt(30);
		for (int j =0; j<i;j++){
			if(h.heap[j]==h.heap[i])
				h.heap[i] = r.nextInt(30);
		}
	}
		
/*	
	h.heap[0]= 27;
	h.heap[1]= 22;
	h.heap[2]= 28;
	h.heap[3]= 13;
	h.heap[4]= 9;	
	h.heap[5]= 16;
	h.heap[6]= 15;
	h.heap[7]= 4;
	h.heap[8]= 11;
	h.heap[9]= 19;
	h.heap[10]= 14;
*/	
	
	h.heapDisplay();
	h.buildingHeap(h.heap);
	System.out.println();
	System.out.println("Bulding heap:");
	h.heapDisplay();	
	h.heapSort(h.heap);	
	System.out.println("After heap sort:");
	h.heapDisplay();	
	System.out.println("-------------------------------------------------------");	
	System.out.println("Enqueue");
	Heap newH = new Heap(0);
	newH.enqueue(1);
	newH.enqueue(24);
	newH.enqueue(9);
	newH.enqueue(15);
	newH.enqueue(7);
	newH.enqueue(20);
	newH.enqueue(0);
	newH.enqueue(2);
	newH.enqueue(10);
	newH.heapDisplay();
	System.out.println("Dequeue");
	for(int i =0; i<newH.heap.length;i++)
		System.out.print(newH.dequeue() +", ");
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("New heap for remove method");
	newH.buildingHeap(newH.heap);
	newH.heapDisplay();
	System.out.println("Removing element with index 0");
	System.out.println(newH.remove(0));
	System.out.println("Checking if it's still a heap after removing element");
	newH.heapDisplay();
	System.out.println();
	System.out.println("Removing element with index 3");
	System.out.println(newH.remove(3));
	System.out.println("Checking if it's still a heap after removing element");
	newH.heapDisplay();
	System.out.println();
	System.out.println("Removing element with index 5");
	System.out.println(newH.remove(5));
	System.out.println("Checking if it's still a heap after removing element");
	newH.heapDisplay();

	}
	
}
